package com.aws.nimesaassignment.repository;

import com.aws.nimesaassignment.entity.EC2Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EC2InstanceRepository
		extends
			JpaRepository<EC2Instance, Long> {
}
