
package acme.features.administrator.banner;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.accounts.Administrator;
import acme.client.data.models.Dataset;
import acme.client.helpers.MomentHelper;
import acme.client.services.AbstractService;
import acme.entities.group.Banner;

@Service
public class AdministratorBannerUpdateService extends AbstractService<Administrator, Banner> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorBannerRepository	repository;

	private Date							lowestMoment	= Date.from(Instant.parse("1999-12-31T23:00:00Z"));
	private Date							topestMoment	= Date.from(Instant.parse("2200-12-31T23:59:59Z"));

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		Banner object;
		int bannerId;
		Date instantiationMoment;

		instantiationMoment = MomentHelper.getCurrentMoment();
		bannerId = super.getRequest().getData("id", int.class);
		object = this.repository.findOneBannerById(bannerId);
		object.setInstantiationUpdateMoment(instantiationMoment);

		super.getBuffer().addData(object);
	}

	@Override
	public void bind(final Banner object) {
		assert object != null;

		super.bind(object, "displayStart", "displayFinish", "slogan", "linkPicture", "link");

	}

	@Override
	public void validate(final Banner object) {
		assert object != null;

		if (!this.getBuffer().getErrors().hasErrors("displayStart")) {
			Date displayStartDate = object.getDisplayStart();
			Date instantiationMoment = object.getInstantiationUpdateMoment();

			super.state(MomentHelper.isAfter(displayStartDate, instantiationMoment), "displayStart", "administrator.banner.form.error.displayStartDate");
			super.state(MomentHelper.isAfterOrEqual(displayStartDate, this.lowestMoment) && MomentHelper.isBeforeOrEqual(displayStartDate, this.topestMoment), "displayStartDate", "administrator.banner.form.error.badDiplayStartDate");
		}
		if (!this.getBuffer().getErrors().hasErrors("displayFinish")) {
			Date displayEndDate = object.getDisplayFinish();
			Date instantiationMoment = object.getInstantiationUpdateMoment();

			super.state(MomentHelper.isAfter(displayEndDate, instantiationMoment), "displayStart", "administrator.banner.form.error.displayEndDate");
			super.state(MomentHelper.isAfterOrEqual(displayEndDate, this.lowestMoment) && MomentHelper.isBeforeOrEqual(displayEndDate, this.topestMoment), "displayStartDate", "administrator.banner.form.error.badDiplayEndDate");
		}

		if (!this.getBuffer().getErrors().hasErrors("displayStart") && !this.getBuffer().getErrors().hasErrors("displayFinish")) {
			Date displayStartDate = object.getDisplayStart();
			Date displayEndDate = object.getDisplayFinish();

			super.state(this.isPassedOneWeekAtLeast(displayEndDate, displayStartDate), "displayFinish", "administrator.banner.form.error.notTimeEnough");
		}
	}

	private boolean isPassedOneWeekAtLeast(final Date date1, final Date date2) {
		boolean res = false;
		long diffInMillies = date1.getTime() - date2.getTime();
		long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		if (diffInDays >= 7L)
			res = true;
		return res;
	}

	@Override
	public void perform(final Banner object) {
		assert object != null;

		Date instantiationMoment;

		instantiationMoment = MomentHelper.getCurrentMoment();
		object.setInstantiationUpdateMoment(instantiationMoment);
		this.repository.save(object);
	}

	@Override
	public void unbind(final Banner object) {
		assert object != null;

		Dataset dataset;

		dataset = super.unbind(object, "instantiationUpdateMoment", "displayStart", "displayFinish", "slogan", "linkPicture", "linkTarget");

		super.getResponse().addData(dataset);

	}

}
