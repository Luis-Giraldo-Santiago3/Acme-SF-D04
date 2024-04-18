
package acme.features.manager.dashboard;

import org.springframework.data.jpa.repository.Query;

import acme.client.repositories.AbstractRepository;

public interface ManagerDashboardRepository extends AbstractRepository {

	// Proporciona el número total de "Must" historias de usuario
	@Query("SELECT COUNT(u) FROM UserStory u WHERE u.priority = 0")
	int totalNumberOfMustUserStories();

	// Proporciona el número total de "Should" historias de usuario
	@Query("SELECT COUNT(u) FROM UserStory u WHERE u.priority = 1")
	int totalNumberOfShouldUserStories();

	// Proporciona el número total de "Could" historias de usuario
	@Query("SELECT COUNT(u) FROM UserStory u WHERE u.priority = 2")
	int totalNumberOfCouldUserStories();

	// Proporciona el número total de "Wont" historias de usuario
	@Query("SELECT COUNT(u) FROM UserStory u WHERE u.priority = 3")
	int totalNumberOfWontUserStories();

	// Proporciona el coste medio estimado de todas las historias de usuario
	@Query("SELECT AVG(u.estimatedCost) FROM UserStory u")
	Double averageEstimatedCostUserStories();

	// Proporciona la desviación del coste estimado de todas las historias de usuario
	@Query("SELECT STDDEV(u.estimatedCost) FROM UserStory u")
	Double deviationEstimatedCostUserStories();

	// Proporciona el mínimo coste estimado de todas las historias de usuario
	@Query("SELECT MIN(u.estimatedCost) FROM UserStory u")
	Integer minimunEstimatedCostUserStories();

	// Proporciona el máximo coste estimado de todas las historias de usuario
	@Query("SELECT MAX(u.estimatedCost) FROM UserStory u")
	Integer maximumEstimatedCostUserStories();

	// Proporciona la media de coste de todos los proyectos
	@Query("SELECT AVG(p.cost) FROM Project p")
	Double averageCostProjects();

	// Proporciona la desviación del coste de todos los proyectos
	@Query("SELECT STDDEV(p.cost) FROM Project p")
	Double deviationCostProjects();

	// Proporciona el mínimo coste de todos los proyectos
	@Query("SELECT MIN(p.cost) FROM Project p")
	Integer minimunCostProjects();

	// Proporciona el máximo coste de todos los proyectos
	@Query("SELECT MAX(p.cost) FROM Project p")
	Integer maximumCostProjects();

}
