
package acme.entities.sponsorships;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sponsorships extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}", message = "{validation.sponsorships.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Past
	private LocalDate			moment;

	private Integer				duration;

	@Min(0)
	private Double				amount;

	private Sponsorship			type;

	private Optional<String>	email;

	private Optional<String>	link;

}
