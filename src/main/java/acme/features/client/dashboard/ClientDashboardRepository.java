/*
 * AdministratorDashboardRepository.java
 *
 * Copyright (C) 2012-2024 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.client.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.client.repositories.AbstractRepository;

@Repository
public interface ClientDashboardRepository extends AbstractRepository {

	// Consulta para obtener el porcentaje del número total de registros de progreso con completitud por debajo del 25%
	@Query("SELECT COUNT(pl) FROM ProgressLog pl WHERE pl.completenessPercentage < 25")
	Integer percentageOfTotalNumberCompleteness25();

	// Consulta para obtener el porcentaje del número total de registros de progreso con completitud entre 25% y 50%
	@Query("SELECT COUNT(pl) FROM ProgressLog pl WHERE pl.completenessPercentage >= 25 AND pl.completenessPercentage < 50")
	Integer percentageOfTotalNumberCompleteness25At50();

	// Consulta para obtener el porcentaje del número total de registros de progreso con completitud entre 50% y 75%
	@Query("SELECT COUNT(pl) FROM ProgressLog pl WHERE pl.completenessPercentage >= 50 AND pl.completenessPercentage < 75")
	Integer percentageOfTotalNumberCompleteness50at75();

	// Consulta para obtener el porcentaje del número total de registros de progreso con completitud por encima del 75%
	@Query("SELECT COUNT(pl) FROM ProgressLog pl WHERE pl.completenessPercentage >= 75")
	Integer percentageOfTotalNumberCompletenessMore75();

	// Consulta para obtener el promedio del presupuesto de los contratos
	@Query("SELECT AVG(c.budget) FROM Contract c")
	Double averageBudgetOfContract();

	// Consulta para obtener la desviación del presupuesto de los contratos
	@Query("SELECT STDDEV(c.budget) FROM Contract c")
	Double deviationBudgetOfContract();

	// Consulta para obtener el presupuesto mínimo de los contratos
	@Query("SELECT MIN(c.budget) FROM Contract c")
	Double minimumBudgetOfContract();

	// Consulta para obtener el presupuesto máximo de los contratos
	@Query("SELECT MAX(c.budget) FROM Contract c")
	Double maximumBudgetOfContract();

}
