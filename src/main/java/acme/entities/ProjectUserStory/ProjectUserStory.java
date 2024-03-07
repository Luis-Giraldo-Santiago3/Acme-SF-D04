
package acme.entities.ProjectUserStory;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.client.data.AbstractEntity;
import acme.entities.project.Project;
import acme.entities.userStory.UserStory;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProjectUserStory extends AbstractEntity {

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Project		project;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private UserStory	userStory;

}
