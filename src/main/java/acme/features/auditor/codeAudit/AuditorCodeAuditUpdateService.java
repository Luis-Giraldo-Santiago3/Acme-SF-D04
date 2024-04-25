
package acme.features.auditor.codeAudit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.client.views.SelectChoices;
import acme.entities.student5.CodeAudit;
import acme.entities.student5.Mark;
import acme.entities.student5.Type;
import acme.roles.Auditor;

@Service
public class AuditorCodeAuditUpdateService extends AbstractService<Auditor, CodeAudit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuditorCodeAuditRepository repository;

	// AbstractService<Employer, Job> -------------------------------------


	@Override
	public void authorise() {
		boolean status;
		int masterId;
		CodeAudit codeAudit;
		Auditor auditor;

		masterId = super.getRequest().getData("id", int.class);
		codeAudit = this.repository.findOneCodeAuditById(masterId);
		auditor = codeAudit == null ? null : codeAudit.getAuditor();
		status = codeAudit != null && !codeAudit.isPublished() && super.getRequest().getPrincipal().hasRole(auditor);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		CodeAudit object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneCodeAuditById(id);

		super.getBuffer().addData(object);
	}

	@Override
	public void bind(final CodeAudit object) {
		assert object != null;

		super.bind(object, "code", "executionDate", "type", "correctiveActions", "mark", "link");

	}

	@Override
	public void validate(final CodeAudit object) {
		assert object != null;

		if (!super.getBuffer().getErrors().hasErrors("code")) {
			CodeAudit existing;

			existing = this.repository.findOneCodeAuditByCode(object.getCode());
			if (!(object.getId() == existing.getId()))
				super.state(existing == null, "code", "auditor.codeAudit.form.error.duplicated");
		}

		if (!(object.getMark() == Mark.F || object.getMark() == Mark.F_MINUS))
			super.state(object.isPublished(), "mark", "auditor.codeAudit.form.error.publishedTrue");
		else {
			super.state(!object.isPublished(), "mark", "auditor.codeAudit.form.error.publishedFalse");
			object.setPublished(false);
		}
	}

	@Override
	public void perform(final CodeAudit object) {
		assert object != null;

		this.repository.save(object);
	}

	@Override
	public void unbind(final CodeAudit object) {
		assert object != null;

		SelectChoices choices;
		Dataset dataset;
		choices = SelectChoices.from(Mark.class, object.getMark());
		dataset = super.unbind(object, "code", "executionDate", "type", "mark", "correctiveActions", "link", "published");
		dataset.put("mark", choices.getSelected().getKey());
		dataset.put("marks", choices);
		dataset.put("types", SelectChoices.from(Type.class, object.getType()));
		super.getResponse().addData(dataset);
	}

}
