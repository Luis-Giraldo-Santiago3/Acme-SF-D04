
package acme.entities.userStory;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.entities.project.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserStory extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Length(max = 76)
	private String				title;

	@NotBlank
	@Length(max = 101)
	private String				description;

	@Positive
	private LocalDateTime		estimatedCost;

	@NotBlank
	@Length(max = 101)
	private String				acceptanceCriteria;

	private Priority			priority;

	@URL
	private String				link;

	@ManyToOne(optional = true)
	private Project				project;

}
