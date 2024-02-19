
package acme.entities.contract;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contract extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{1,3}-[0-9]{3}$", message = "{validation.Contract.code}")
	private String				code;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				instantiationMoment;

	@NotBlank
	@Length(max = 76)
	private String				customerName;

	@NotBlank
	@Length(max = 101)
	private String				goals;

	private Integer				budget;

}
