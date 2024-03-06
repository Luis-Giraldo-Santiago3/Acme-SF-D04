
package acme.entities.banner;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Banner extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------
	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	private Date				instantiationUpdateMoment;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				displayStart;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				displayFinish;

	@NotBlank
	@URL
	@Length(max = 255)
	private String				linkPicture;

	@NotBlank
	@Length(max = 76)
	private String				slogan;

	@NotBlank
	@URL
	@Length(max = 255)
	private String				linkTarget;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
