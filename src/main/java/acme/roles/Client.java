
package acme.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client extends AbstractRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^CLI-[0-9]{4}$", message = "{validation.Client.identification}")
	private String				identification;

	@NotBlank
	@Length(max = 75, min = 0)
	private String				companyName;

	@NotBlank
	@Pattern(regexp = "company|individual", message = "{validation.Client.type}")
	private String				type;

	@NotBlank
	@Email
	@Length(max = 255, min = 0)
	private String				email;

	@URL
	@Length(max = 255, min = 0)
	private String				link;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
