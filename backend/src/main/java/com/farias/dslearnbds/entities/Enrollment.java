package com.farias.dslearnbds.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.farias.dslearnbds.entities.pk.EnrollmentId;


@Entity
@Table(name="tb_enrollment")
public class Enrollment implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnrollmentId id = new EnrollmentId();
	private String enrollment;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	private boolean avaliable;
	private boolean onlyUpdate;
	
	
	public Enrollment() {
		super();
	}


	public Enrollment(User user, Offer offer, String enrollment, Instant refundMoment, boolean avaliable, boolean onlyUpdate) {
		super();
		this.id.setUser(user);
		this.id.setOffer(offer);
		this.enrollment = enrollment;
		this.refundMoment = refundMoment;
		this.avaliable = avaliable;
		this.onlyUpdate = onlyUpdate;
	}


	public EnrollmentId getId() {
		return id;
	}

	public void setId(EnrollmentId id) {
		this.id = id;
	}
	
	public User getStudent() {
		return this.id.getUser();
	}
	
	public void setStudent(User user) {
		this.id.setUser(user);
	}

	public Offer getOffer() {
		return this.id.getOffer();
	}
	
	public void setOffer(Offer offer) {
		this.id.setOffer(offer);
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}


	public Instant getRefundMoment() {
		return refundMoment;
	}


	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}


	public boolean isAvaliable() {
		return avaliable;
	}


	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}


	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}


	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (avaliable ? 1231 : 1237);
		result = prime * result + ((enrollment == null) ? 0 : enrollment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (onlyUpdate ? 1231 : 1237);
		result = prime * result + ((refundMoment == null) ? 0 : refundMoment.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollment other = (Enrollment) obj;
		if (avaliable != other.avaliable)
			return false;
		if (enrollment == null) {
			if (other.enrollment != null)
				return false;
		} else if (!enrollment.equals(other.enrollment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (onlyUpdate != other.onlyUpdate)
			return false;
		if (refundMoment == null) {
			if (other.refundMoment != null)
				return false;
		} else if (!refundMoment.equals(other.refundMoment))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", enrollment=" + enrollment + ", refundMoment=" + refundMoment + ", avaliable="
				+ avaliable + ", onlyUpdate=" + onlyUpdate + "]";
	}
	
	
}
