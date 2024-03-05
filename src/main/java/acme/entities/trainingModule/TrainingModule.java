
package acme.entities.trainingModule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.entities.project.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "draftMode"), //
	@Index(columnList = "code")

})
public class TrainingModule extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}", message = "{validation.trainingModule.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Past
	private Date				creationMoment;

	@NotBlank
	@Length(max = 100)
	private String				details;

	private Difficulty			difficultyLevel;

	// Revisar restricciones de este
	@Past
	private Date				updateMoment;

	@URL
	private String				link;

	private Double				totalTime;

	private boolean				draftMode;

	// Relationships

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private Project				project;

}
