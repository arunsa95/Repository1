/**
 * 
 */
package com.cg.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author aruravic
 *
 */
@Entity
@Table(name = "Trainee")
public class Trainee {
	@Id
	@NotNull
	private Integer traineeId;

	@Size(min = 3, max = 21)
	@NotEmpty(message = "Please Enter Trainee Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Trainee Name must contain only alphabets")
	//@Pattern(regexp = "[\\p{P}\\p{S}]", message = "Trainee Name must contain only alphabets")
	private String traineeName;

	@NotEmpty(message = "Please Enter Domain Name")
	private String traineeDomain;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	// @Temporal(TemporalType.DATE)
	@NotNull
	@Past
	private Date traineeDob;

	public enum Gender {
		MALE, FEMALE
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeDomain() {
		return traineeDomain;
	}

	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}

	public Date getTraineeDob() {
		return traineeDob;
	}

	public void setTraineeDob(Date traineeDob) {
		this.traineeDob = traineeDob;
	}

	@Override
	public String toString() {
		return "Trainee_Bean [traineeId=" + traineeId + ", traineeName="
				+ traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeDob=" + traineeDob + "]";
	}

}
