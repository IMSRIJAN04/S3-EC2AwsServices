package com.aws.nimesaassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec2Instance")
public class EC2Instance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String jobId;
	private String instance;

	public EC2Instance(String jobId, String instance) {
		this.jobId = jobId;
		this.instance = instance;
	}
}
