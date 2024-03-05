
package acme.entities.risk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.client.data.accounts.Administrator;
import acme.entities.project.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "draftMode"), //
	@Index(columnList = "reference")
})
public class Risk extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^“R-[0-9]{3}$", message = "{validation.Risk.reference}")
	private String				reference;

	@Past
	private Date				identificationDate;

	@Positive
	private double				impact;

	private double				probability;

	@NotBlank
	@Length(max = 100)
	private String				description;

	@URL
	private String				link;

	private boolean				draftMode;

	// Derived attributes -----------------------------------------------------


	public Double value() {

		return this.impact * this.probability;

	}

	// Relationships ----------------------------------------------------------


	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Project			project;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Administrator	administrator;

}
