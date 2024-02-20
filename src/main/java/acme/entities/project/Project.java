
package acme.entities.project;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;
import acme.entities.userStory.UserStory;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Project extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Length(min = 5, max = 15)
	@Pattern(regexp = "[A-Z]{3}-[0-9]{4}", message = "{validation.project.code}")
	private String				code;

	@NotBlank
	@Length(max = 76)
	private String				title;

	@NotBlank
	@Length(max = 101)
	private String				summary; // esto es el abstract que piden pero abstract esta reservada

	private Boolean				cost;

	private Optional			link;

	private List<UserStory>		userStories;

}
