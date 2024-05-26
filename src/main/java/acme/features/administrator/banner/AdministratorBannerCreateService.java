
package acme.features.administrator.banner;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.accounts.Administrator;
import acme.client.data.models.Dataset;
import acme.client.helpers.MomentHelper;
import acme.client.services.AbstractService;
import acme.entities.group.Banner;

@Service
public class AdministratorBannerCreateService extends AbstractService<Administrator, Banner> {

	@Autowired
	protected AdministratorBannerRepository repository;


	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		Banner object;
		object = new Banner();
		final Date actualDate = MomentHelper.getCurrentMoment();
		object.setInstantiationUpdateMoment(actualDate);
		super.getBuffer().addData(object);
	}

	@Override
	public void bind(final Banner object) {
		assert object != null;
		super.bind(object, "displayStart", "displayFinish", "linkPicture", "slogan", "linkTarget");

	}

	@Override
	public void validate(final Banner object) {
		assert object != null;
		if (!super.getBuffer().getErrors().hasErrors("displayStart"))
			super.state(MomentHelper.isAfter(object.getDisplayStart(), object.getInstantiationUpdateMoment()), "displayStart", "administrator.banner.form.error.displayStart");

		if (!super.getBuffer().getErrors().hasErrors("displayFinish") && !super.getBuffer().getErrors().hasErrors("displayStart")) {
			Date maximumPeriod;
			maximumPeriod = MomentHelper.deltaFromMoment(object.getDisplayStart(), 7, ChronoUnit.DAYS);
			super.state(MomentHelper.isAfterOrEqual(object.getDisplayFinish(), maximumPeriod) && object.getDisplayFinish().after(object.getDisplayStart()), "displayFinish", "administrator.banner.form.error.displayFinish");
		}
	}
	@Override
	public void perform(final Banner object) {
		assert object != null;
		this.repository.save(object);
	}

	@Override
	public void unbind(final Banner object) {
		assert object != null;
		Dataset dataset;
		dataset = super.unbind(object, "instantiationUpdateMoment", "displayStart", "displayFinish", "linkPicture", "slogan", "linkTarget");
		super.getResponse().addData(dataset);

	}
}
