
package acme.entities.trainingModule;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrainingModule extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "[A-Z]{1,3}-[0-9]{3}", message = "{validation.trainingModule.code}")
	@NotBlank
	@Column(unique = true)
	private String				code;

	@Past
	private LocalDate			creationMoment;

	@NotBlank
	@Length(max = 100)
	private String				details;

	private Difficulty			difficultyLevel;

	// Revisar restricciones de este
	@Past
	private LocalDate			updateMoment;

	private String				link;

	private Double				totalTime;

	private boolean				draftMode;

}
