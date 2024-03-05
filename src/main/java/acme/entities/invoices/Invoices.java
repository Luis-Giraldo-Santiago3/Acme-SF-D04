
package acme.entities.invoices;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.client.data.datatypes.Money;
import acme.entities.sponsorships.Sponsorships;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "draftMode"), //
	@Index(columnList = "code")
})
public class Invoices extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------
	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	@Pattern(regexp = "IN-[0-9]{4}-[0-9]{4}", message = "{validation.invoices.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Past
	private LocalDate			registrationTime;

	private Integer				dueDate;

	@Valid
	@NotNull
	@Min(0)
	private Money				quantity;

	@Valid
	@Min(0)
	private Money				tax;

	@URL
	private String				link;

	private boolean				draftMode;


	// Derived attributes -----------------------------------------------------
	@Transient
	private Double totalAmount() {
		return this.quantity.getAmount() + this.tax.getAmount();
	}


	// Relationships ----------------------------------------------------------
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Sponsorships sponsorship;
}
