
package acme.forms;

public class ManagerDashboard {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int							totalNumberMustUserStories;
	int							totalNumberShouldUserStories;
	int							totalNumberCouldUserStories;
	int							totalNumberWontUserStories;
	Double						averageEstimatedCostOfUserStories;
	Double						deviationEstimatedCostOfUserStories;
	int							minimunEstimatedCostUserStories;
	int							maximumEstimatedCostUserStories;
	Double						averageCostProjects;
	Double						deviationCostProjects;
	int							minimunCostProjects;
	int							maximumCostNumberProjects;

}
