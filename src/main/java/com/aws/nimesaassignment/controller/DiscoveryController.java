package com.aws.nimesaassignment.controller;

import com.aws.nimesaassignment.customexception.CustomException;
import com.aws.nimesaassignment.service.NimesaServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/nimesa/aws")
public class DiscoveryController {
	Logger log = LoggerFactory.getLogger(DiscoveryController.class);

	@Autowired
	private NimesaServices nimesaServices;

	@PostMapping("/discover/services")
	public ResponseEntity<String> discoverServices(
			@RequestBody List<String> services) {
		try {
			CompletableFuture<String> jobResult = nimesaServices
					.discoverServices(services);
			// to return the JobId
			return ResponseEntity.ok("JobId: " + jobResult.get());
		} catch (Exception e) {
			log.info("Error occurred while fetching discover services.");
			return ResponseEntity.status(500).body("Error: " + e.getMessage());
		}
	}

	@GetMapping("/job/result/{jobId}")
	public ResponseEntity<String> getJobResult(
			@PathVariable("jobId") String jobId) throws CustomException {
		try {
			// to return the status by jobId
			return ResponseEntity.ok("JobId " + jobId + " status is : "
					+ nimesaServices.getJobResultByJobId(jobId));
		} catch (Exception e) {
			log.info("Error occurred while fetching status of jobId :" + jobId);
			return ResponseEntity.status(500).body("Error: " + e.getMessage());
		}
	}

	@GetMapping("/discovery/result/{service}")
	public ResponseEntity<List<String>> getDiscoveryResult(
			@PathVariable("service") String service) {
		// to return the discovery services list
		return new ResponseEntity<>(
				nimesaServices.getDiscoveryServiceDetails(service),
				HttpStatus.OK);
	}

	@GetMapping("/s3/bucket/object-count/{bucketName}")
	public ResponseEntity<Integer> getS3BucketObjectCount(
			@PathVariable("bucketName") String bucketName) {
		// to return the S3BucketObjectCount
		return new ResponseEntity<>(
				nimesaServices.getS3BucketObjectCount(bucketName),
				HttpStatus.OK);
	}

	@GetMapping("/s3/bucket/object")
	public ResponseEntity<String> getS3BucketObjects(
			@RequestParam("bucketName") String bucketName) {
		try {
			// to return the S3BucketObjects
			return new ResponseEntity<>(
					nimesaServices.getS3BucketObjects(bucketName).join(),
					HttpStatus.OK);
		} catch (Exception e) {
			log.info(
					"Error occurred while fetching S3BucketObjects for bucket name :"
							+ bucketName);
			return ResponseEntity.status(500).body("Error: " + e.getMessage());
		}
	}

	@GetMapping("/s3/bucket/object-like")
	public ResponseEntity<List<String>> getS3BucketObjectlike(
			@RequestParam("bucketName") String bucketName,
			@RequestParam("pattern") String pattern) {
		// to return the S3BucketObjects like
		return new ResponseEntity<>(
				nimesaServices.getS3BucketObjectlike(bucketName, pattern),
				HttpStatus.OK);
	}

}