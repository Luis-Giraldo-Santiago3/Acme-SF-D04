
package acme.forms;

public class ManagerDashboard {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int							totalNumberMustUserStories;
	int							totalNumberShouldUserStories;
	int							totalNumberCouldUserStories;
	int							totalNumberWontUserStories;
	Double						averageEstimatedCostUserStories;
	Double						deviationEstimatedCostUserStories;
	Integer						minimunEstimatedCostUserStories;
	Integer						maximumEstimatedCostUserStories;
	Double						averageCostProjects;
	Double						deviationCostProjects;
	Integer						minimunCostProjects;
	Integer						maximumCostNumberProjects;

}
