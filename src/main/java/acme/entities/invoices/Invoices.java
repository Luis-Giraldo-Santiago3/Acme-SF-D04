
package acme.entities.invoices;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invoices extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "IN-[0-9]{4}-[0-9]{4}", message = "{validation.invoices.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Past
	private LocalDate			registrationTime;

	private Integer				dueDate;

	@NotNull
	@Min(0)
	private Double				quantity;

	@Min(0)
	private Double				tax;


	private Double totalAmount() {
		return this.quantity + this.tax;
	}


	private String link;

}
