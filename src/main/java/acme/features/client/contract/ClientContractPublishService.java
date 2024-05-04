
package acme.features.client.contract;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.client.views.SelectChoices;
import acme.entities.student1.Project;
import acme.entities.student2.Contract;
import acme.roles.Client;

@Service
public class ClientContractPublishService extends AbstractService<Client, Contract> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ClientContractRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		boolean status;
		int masterId;
		Contract contract;
		Client client;

		masterId = super.getRequest().getData("id", int.class);
		contract = this.repository.findOneContractById(masterId);
		client = contract == null ? null : contract.getClient();
		status = contract != null && !contract.isPublished() && super.getRequest().getPrincipal().hasRole(client);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Contract object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneContractById(id);
		object.setPublished(false);

		super.getBuffer().addData(object);
	}

	@Override
	public void bind(final Contract object) {
		assert object != null;

		int projectId;
		Project project;

		projectId = super.getRequest().getData("project", int.class);
		project = this.repository.findOneProjectById(projectId);

		super.bind(object, "code", "instantiationMoment", "providerName", "customerName", "goals", "budget");
		object.setProject(project);
	}

	@Override
	public void validate(final Contract object) {
		assert object != null;
		Date past = new Date(946681199000L);
		Collection<Contract> listAllContracts = this.repository.findAllContract();
		Collection<Contract> contractsFiltered = listAllContracts.stream().filter(x -> x.getProject().getId() == object.getProject().getId()).toList();
		double totalAmount = contractsFiltered.stream().map(x -> x.getBudget().getAmount()).collect(Collectors.summingDouble(x -> x));
		double converterHourToEUR = 24;

		if (!super.getBuffer().getErrors().hasErrors("code")) {
			Contract existing;
			existing = this.repository.findOneContractByCode(object.getCode());
			final Contract contract2 = object.getCode().equals("") || object.getCode() == null ? null : this.repository.findOneContractById(object.getId());
			super.state(existing == null || contract2.equals(existing), "code", "client.contract.form.error.code");
		}

		if (!super.getBuffer().getErrors().hasErrors("instantiationMoment"))
			super.state(object.getInstantiationMoment().after(past), "instantiationMoment", "client.contract.form.error.moment");

		if (!super.getBuffer().getErrors().hasErrors("budget")) {
			double totalCost = object.getProject().getCost() * converterHourToEUR;
			super.state(totalAmount <= totalCost, "budget", "client.contract.form.error.higher-cost");
			super.state(object.getBudget().getAmount() <= 1000000.00, "budget", "client.contract.form.error.higher-amount");
			super.state(object.getBudget().getAmount() >= -1000000.00, "budget", "client.contract.form.error.lower-amount");
			super.state(object.getBudget().getCurrency().equals("EUR"), "budget", "client.contract.form.error.currency");
		}
	}

	@Override
	public void perform(final Contract object) {
		assert object != null;

		object.setPublished(true);
		this.repository.save(object);
	}

	@Override
	public void unbind(final Contract object) {
		assert object != null;
		Collection<Project> projects;
		SelectChoices choices;
		Dataset dataset;

		projects = this.repository.findAllProjectsPublished();

		choices = SelectChoices.from(projects, "title", object.getProject());

		dataset = super.unbind(object, "code", "instantiationMoment", "providerName", "customerName", "goals", "budget", "project", "client", "published");
		dataset.put("project", choices.getSelected().getKey());
		dataset.put("projects", choices);

		super.getResponse().addData(dataset);
	}
}
