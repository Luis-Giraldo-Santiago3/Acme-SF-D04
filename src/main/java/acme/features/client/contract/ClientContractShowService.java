
package acme.features.client.contract;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.models.Dataset;
import acme.client.helpers.MomentHelper;
import acme.client.services.AbstractService;
import acme.client.views.SelectChoices;
import acme.entities.student2.Contract;
import acme.entities.student2.ProgressLog;
import acme.roles.Client;

@Service
public class ClientContractShowService extends AbstractService<Client, Contract> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ClientContractRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		boolean status;
		int masterId;
		Contract contract;
		Client client;
		Date currentMoment;

		masterId = super.getRequest().getData("id", int.class);
		contract = this.repository.findOneContractById(masterId);
		client = contract == null ? null : contract.getClient();
		currentMoment = MomentHelper.getCurrentMoment();
		status = super.getRequest().getPrincipal().hasRole(client) || contract != null && contract.isPublished() && MomentHelper.isAfter(contract.getInstantiationMoment(), currentMoment);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Contract object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneContractById(id);

		super.getBuffer().addData(object);
	}

	@Override
	public void unbind(final Contract object) {
		assert object != null;

		int clientId;
		Collection<ProgressLog> progressLogs;
		SelectChoices choices;
		Dataset dataset;

		if (object.isPublished())
			progressLogs = this.repository.findAllProgressLog();
		else {
			clientId = super.getRequest().getPrincipal().getActiveRoleId();
			progressLogs = this.repository.findManyProgressLogByClientId(clientId);
		}
		choices = SelectChoices.from(progressLogs, "recordId", progressLogs.stream().toList().get(0));

		dataset = super.unbind(object, "code", "instantiationMoment", "providerName", "customerName", "goals", "budget", "published");
		dataset.put("contractor", choices.getSelected().getKey());
		dataset.put("contractors", choices);

		super.getResponse().addData(dataset);
	}

}
