
package acme.features.auditor.auditRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.client.controllers.AbstractController;
import acme.entities.student5.AuditRecord;
import acme.roles.Auditor;

@Controller
public class AuditorAuditRecordController extends AbstractController<Auditor, AuditRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuditorAuditRecordListService listService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
	}
}
