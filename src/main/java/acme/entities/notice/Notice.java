
package acme.entities.notice;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notice extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Past
	private Date				instantiationMoment;

	private String				author;

	@NotBlank
	@Max(101)
	private String				message;

	@Email
	private String				email;

	@URL
	private String				link;

}
