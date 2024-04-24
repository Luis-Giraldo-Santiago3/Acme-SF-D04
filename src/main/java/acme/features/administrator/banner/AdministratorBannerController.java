
package acme.features.administrator.banner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.client.controllers.AbstractController;
import acme.client.data.accounts.Administrator;
import acme.entities.group.Banner;

@Controller
public class AdministratorBannerController extends AbstractController<Administrator, Banner> {
	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorBannerShowService		showService;

	@Autowired
	private AdministratorBannerListService		listService;

	@Autowired
	private AdministratosBannerDeleteService	deleteService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
<<<<<<< HEAD
		super.addBasicCommand("show", this.showService);
=======
		//super.addBasicCommand("show", this.showService);
>>>>>>> refs/remotes/origin/rafmolgar2
		super.addBasicCommand("delete", this.deleteService);
		super.addCustomCommand("list-service", "list", this.listService);
	}
}
