
package acme.features.manager.dashboard;

import org.springframework.data.jpa.repository.Query;

import acme.client.repositories.AbstractRepository;

public interface ManagerDashboardRepository extends AbstractRepository {

	// Proporciona el número total de "Must" historias de usuario
	@Query("select u from UserStory u where u.priority = 'Must'")
	Double totalNumberOfMustUserStories();

	// Proporciona el número total de "Should" historias de usuario
	@Query("select u from UserStory u where u.priority = 'Should'")
	Double totalNumberOfShouldUserStories();

	// Proporciona el número total de "Could" historias de usuario
	@Query("select u from UserStory u where u.priority = 'Could'")
	Double totalNumberOfCouldUserStories();

	// Proporciona el número total de "Wont" historias de usuario
	@Query("select u from UserStory u where u.priority = 'Wont'")
	Double totalNumberOfWontUserStories();

	// Proporciona el coste medio estimado de todas las historias de usuario
	@Query("select avg(u.estimatedCost) from UserStory u ")
	Double averageEstimatedCostOfUserStories();

	// Proporciona la desviación del coste estimado de todas las historias de usuario
	@Query("select stddev(u.estimatedCost) from UserStory u")
	Double deviationEstimatedCostOfUserStories();

	// Proporciona el minimo coste estimado de todas las historias de usuario
	@Query("select min(u.estimatedCost) from UserStory u")
	Double minimumEstimatedCostOfUserStories();

	// Proporciona el maximo coste estimado de todas las historias de usuario
	@Query("select max(u.estimatedCost) from UserStory u")
	Double maximumEstimatedCostNumberOfUserStories();

	// Proporciona la media de coste de todos los proyectos
	@Query("select avg(p.cost) from Project p")
	Double averageCostOfProjects();

	// Proporciona la desviación del coste de todos los proyectos
	@Query("select stddev(p.cost) from Project p")
	Double deviationCostOfProjects();

	// Proporciona el minimo coste de todos los proyectos
	@Query("select min(p.cost) from Project p")
	Double minimumCostOfProjects();

	// Proporciona el maximo coste de todos los proyectos
	@Query("select max(p.cost) from Project p")
	Double maximumCostNumberOfProjects();

}
