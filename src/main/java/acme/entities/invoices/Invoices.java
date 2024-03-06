
package acme.entities.invoices;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.entities.sponsorships.Sponsorships;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Invoices extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------
	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@Pattern(regexp = "IN-[0-9]{4}-[0-9]{4}", message = "{validation.invoices.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	private Date				registrationTime;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				dueDate;

	@NotNull
	@Min(0)
	private int					quantity;

	@NotNull
	@Positive
	private double				tax;

	@URL
	private String				link;


	// Derived attributes -----------------------------------------------------
	@Transient
	private Double totalAmount() {
		return this.getQuantity() + this.getTax();
	}


	// Relationships ----------------------------------------------------------
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Sponsorships sponsorship;
}
