
package acme.features.administrator.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.accounts.Administrator;
import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.entities.group.Banner;
import acme.entities.student1.Project;
import acme.roles.Manager;

@Service
public class AdministratosBannerDeleteService extends AbstractService<Administrator, Banner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorBannerRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		boolean status;
		Manager manager;
		int managerRequestId;
		int projectId;
		Project project;

		projectId = super.getRequest().getData("id", int.class);
		project = this.repository.findOneProjectById(projectId);
		manager = project == null ? null : project.getManager();
		managerRequestId = super.getRequest().getPrincipal().getActiveRoleId();
		if (manager != null)
			status = super.getRequest().getPrincipal().hasRole(manager) && manager.getId() == managerRequestId;
		else
			status = false;

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Project object;
		int projectId;

		projectId = super.getRequest().getData("id", int.class);
		object = this.repository.findOneProjectById(projectId);

		super.getBuffer().addData(object);
	}

	@Override
	public void bind(final Banner object) {
		assert object != null;

		super.bind(object, "instantiationUpdateMoment", "displayStart", "displayFinish", "linkPicture", "slogan", "linkTarget");
	}

	@Override
	public void validate(final Banner object) {
		assert object != null;
	}

	@Override
	public void perform(final Banner object) {
		assert object != null;
		this.repository.delete(object);
	}

	@Override
	public void unbind(final Banner object) {
		assert object != null;

		Dataset dataset;

		dataset = super.unbind(object, "instantiationUpdateMoment", "displayStart", "displayFinish", "linkPicture", "slogan", "linkTarget");

		super.getResponse().addData(dataset);

	}
}
