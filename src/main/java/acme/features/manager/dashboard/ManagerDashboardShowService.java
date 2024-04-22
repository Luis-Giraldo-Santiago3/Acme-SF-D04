
package acme.features.manager.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.forms.ManagerDashboard;
import acme.roles.Manager;

@Service
public class ManagerDashboardShowService extends AbstractService<Manager, ManagerDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ManagerDashboardRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		ManagerDashboard dashboard;
		int totalNumberMustUserStories;
		int totalNumberShouldUserStories;
		int totalNumberCouldUserStories;
		int totalNumberWontUserStories;
		Double averageEstimatedCostUserStories;
		Double deviationEstimatedCostUserStories;
		Integer minimunEstimatedCostUserStories;
		Integer maximumEstimatedCostUserStories;
		Double averageCostProjects;
		Double deviationCostProjects;
		Integer minimunCostProjects;
		Integer maximumCostProjects;

		totalNumberMustUserStories = this.repository.totalNumberOfMustUserStories();
		totalNumberShouldUserStories = this.repository.totalNumberOfShouldUserStories();
		totalNumberCouldUserStories = this.repository.totalNumberOfCouldUserStories();
		totalNumberWontUserStories = this.repository.totalNumberOfWontUserStories();
		averageEstimatedCostUserStories = this.repository.averageEstimatedCostUserStories();
		deviationEstimatedCostUserStories = this.repository.deviationEstimatedCostUserStories();
		minimunEstimatedCostUserStories = this.repository.minimunEstimatedCostUserStories();
		maximumEstimatedCostUserStories = this.repository.maximumEstimatedCostUserStories();
		averageCostProjects = this.repository.averageCostProjects();
		deviationCostProjects = this.repository.deviationCostProjects();
		minimunCostProjects = this.repository.minimunCostProjects();
		maximumCostProjects = this.repository.maximumCostProjects();

		dashboard = new ManagerDashboard();
		dashboard.setTotalNumberMustUserStories(totalNumberMustUserStories);
		dashboard.setTotalNumberShouldUserStories(totalNumberShouldUserStories);
		dashboard.setTotalNumberCouldUserStories(totalNumberCouldUserStories);
		dashboard.setTotalNumberWontUserStories(totalNumberWontUserStories);
		dashboard.setAverageEstimatedCostUserStories(averageEstimatedCostUserStories);
		dashboard.setDeviationEstimatedCostUserStories(deviationEstimatedCostUserStories);
		dashboard.setMinimunEstimatedCostUserStories(minimunEstimatedCostUserStories);
		dashboard.setMaximumEstimatedCostUserStories(maximumEstimatedCostUserStories);
		dashboard.setAverageCostProjects(averageCostProjects);
		dashboard.setDeviationCostProjects(deviationCostProjects);
		dashboard.setMinimunCostProjects(minimunCostProjects);
		dashboard.setMaximumCostProjects(maximumCostProjects);

		super.getBuffer().addData(dashboard);
	}

	@Override
	public void unbind(final ManagerDashboard object) {
		Dataset dataset;

		dataset = super.unbind(object, //
			"totalNumberMustUserStories", "totalNumberShouldUserStories", // 
			"totalNumberCouldUserStories", "totalNumberWontUserStories", //
			"averageEstimatedCostUserStories", "deviationEstimatedCostUserStories", //
			"minimunEstimatedCostUserStories", "maximumEstimatedCostUserStories", "averageCostProjects", "deviationCostProjects", "minimunCostProjects", "maximumCostProjects");

		super.getResponse().addData(dataset);
	}

}
