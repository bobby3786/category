package com.bobby.category.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	
	@Column(name = "create_at")
	@CreatedDate
	private LocalDateTime created_at;
	
	@Column(name = "created_by")
	@CreatedBy
	private String created_by;
	
	@Column(name = "updated_at")
	@LastModifiedDate
	private LocalDateTime updated_at;
	
	@Column(name = "updated_by")
	@LastModifiedBy
	private String updated_by;

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdate_by(String updated_by) {
		this.updated_by = updated_by;
	}

	@Override
	public String toString() {
		return "BaseEntity [created_at=" + created_at + ", created_by=" + created_by + ", updated_at=" + updated_at
				+ ", updated_by=" + updated_by + "]";
	}
	
	
	

}
