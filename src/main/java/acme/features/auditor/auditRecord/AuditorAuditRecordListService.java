
package acme.features.auditor.auditRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.entities.student5.AuditRecord;
import acme.entities.student5.CodeAudit;
import acme.roles.Auditor;

@Service
public class AuditorAuditRecordListService extends AbstractService<Auditor, AuditRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuditorAuditRecordRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		boolean status;
		Auditor auditor;
		int auditorRequestId;
		int codeAuditId;
		CodeAudit codeAudit;

		codeAuditId = super.getRequest().getData("masterId", int.class); //por arreglar
		codeAudit = this.repository.findOneCodeAuditById(codeAuditId);
		auditor = codeAudit == null ? null : codeAudit.getAuditor();
		auditorRequestId = super.getRequest().getPrincipal().getActiveRoleId();
		if (auditor != null)
			status = super.getRequest().getPrincipal().hasRole(auditor) && auditor.getId() == auditorRequestId;
		else
			status = false;

		super.getResponse().setAuthorised(status);
	}
	@Override
	public void load() {
		Collection<AuditRecord> objects;
		int codeAuditId;

		codeAuditId = super.getRequest().getData("masterId", int.class);
		objects = this.repository.findManyAuditRecordsByCodeAuditId(codeAuditId);

		super.getBuffer().addData(objects);
	}

	@Override
	public void unbind(final AuditRecord object) {
		assert object != null;
		Dataset dataset;
		int masterId;
		masterId = super.getRequest().getData("masterId", int.class);
		dataset = super.unbind(object, "code", "auditPeriodStart", "auditPeriodEnd", "mark", "link", "published");

		super.getResponse().addGlobal("masterId", masterId);

		super.getResponse().addData(dataset);
	}

}
