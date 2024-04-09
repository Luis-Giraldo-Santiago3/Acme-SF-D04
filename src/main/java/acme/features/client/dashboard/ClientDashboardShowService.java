
package acme.features.client.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.forms.ClientDashboard;
import acme.roles.Client;

@Service
public class ClientDashboardShowService extends AbstractService<Client, ClientDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ClientDashboardRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		ClientDashboard dashboard;
		Integer percentageOfTotalNumberCompleteness25;
		Integer percentageOfTotalNumberCompleteness25At50;
		Integer percentageOfTotalNumberCompleteness50at75;
		Integer percentageOfTotalNumberCompletenessMore75;
		Double averageBudgetOfContract;
		Double deviationBudgetOfContract;
		Double minimumBudgetOfContract;
		Double maximumBudgetOfContract;

		percentageOfTotalNumberCompleteness25 = this.repository.percentageOfTotalNumberCompleteness25();
		percentageOfTotalNumberCompleteness25At50 = this.repository.percentageOfTotalNumberCompleteness25At50();
		percentageOfTotalNumberCompleteness50at75 = this.repository.percentageOfTotalNumberCompleteness50at75();
		percentageOfTotalNumberCompletenessMore75 = this.repository.percentageOfTotalNumberCompletenessMore75();
		averageBudgetOfContract = this.repository.averageBudgetOfContract();
		deviationBudgetOfContract = this.repository.deviationBudgetOfContract();
		minimumBudgetOfContract = this.repository.minimumBudgetOfContract();
		maximumBudgetOfContract = this.repository.maximumBudgetOfContract();

		dashboard = new ClientDashboard();
		dashboard.setPercentageOfTotalNumberCompleteness25(percentageOfTotalNumberCompleteness25);
		dashboard.setPercentageOfTotalNumberCompleteness25At50(percentageOfTotalNumberCompleteness25At50);
		dashboard.setPercentageOfTotalNumberCompleteness50at75(percentageOfTotalNumberCompleteness50at75);
		dashboard.setPercentageOfTotalNumberCompletenessMore75(percentageOfTotalNumberCompletenessMore75);
		dashboard.setAverageBudgetOfContract(averageBudgetOfContract);
		dashboard.setDeviationBudgetOfContract(deviationBudgetOfContract);
		dashboard.setMinimumBudgetOfContract(minimumBudgetOfContract);
		dashboard.setMaximumBudgetOfContract(maximumBudgetOfContract);

		super.getBuffer().addData(dashboard);
	}

	@Override
	public void unbind(final ClientDashboard object) {
		Dataset dataset;

		dataset = super.unbind(object, //
			"percentageOfTotalNumberCompleteness25", "percentageOfTotalNumberCompleteness25At50", // 
			"percentageOfTotalNumberCompleteness50at75", "percentageOfTotalNumberCompletenessMore75", //
			"averageBudgetOfContract", "deviationBudgetOfContract", //
			"minimumBudgetOfContract", "maximumBudgetOfContract");

		super.getResponse().addData(dataset);
	}

}
