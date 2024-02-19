
package acme.entities.progressLogs;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProgressLogs extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "^PG-[A-Z]{1,2}-[0-9]{4}$")
	private String				recordId;

	@Positive
	private Double				completeness;

	@NotBlank
	@Length(max = 101)
	private String				comment;

	@NotNull
	@Past
	private Date				registrationMoment;

	@NotBlank
	@Length(max = 76)
	private String				responsiblePerson;
}
