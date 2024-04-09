
package acme.features.manager.project;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.services.AbstractService;
import acme.entities.student1.Project;
import acme.roles.Manager;

public class ManagerProjectShowService extends AbstractService<Manager, Project> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ManagerProjectRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		boolean status;
		int projectId;
		Project project;
		projectId = super.getRequest().getData("id", int.class);
		project = this.repository.findOneProjectById(projectId);

		status = super.getRequest().getPrincipal().hasRole(project.getManager()) || project != null && project.isPublished();

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Project object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneProjectById(id);

		super.getBuffer().addData(object);
	}
	/*
	 * 
	 * @Override
	 * public void unbind(final Project object) {
	 * assert object != null;
	 * 
	 * int managerId;
	 * SelectChoices choices;
	 * Dataset dataset;
	 * 
	 * if (object.isPublished())
	 * contractors = this.repository.findAllContractors();
	 * else {
	 * employerId = super.getRequest().getPrincipal().getActiveRoleId();
	 * contractors = this.repository.findManyContractorsByEmployerId(employerId);
	 * }
	 * choices = SelectChoices.from(contractors, "name", object.getContractor());
	 * 
	 * dataset = super.unbind(object, "reference", "title", "deadline", "salary", "score", "moreInfo", "description", "draftMode");
	 * dataset.put("contractor", choices.getSelected().getKey());
	 * dataset.put("contractors", choices);
	 * 
	 * super.getResponse().addData(dataset);
	 * }
	 */

}
