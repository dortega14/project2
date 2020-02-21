package com.revature.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
import com.revature.connection.AwsConfig;

@Controller
public class S3Controller {
	
	private AwsConfig awsC;

	@Autowired
	public void AwsConfig(AwsConfig awsC) {
		this.awsC = awsC;
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/upload.app")
//	public String imageUpload(@RequestParam("name") String name, 
//							  @RequestParam("file") MultipartFile file,
//							  RedirectAttributes ra) {
//		@SuppressWarnings("deprecation")
//		AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
//		awsC.getBucketName();
//		try {
//			InputStream is = file.getInputStream();
//			
//			s3client.putObject(new PutObjectRequest(awsC.getBucketName(), name, is, new ObjectMetadata())
//					.withCannedAcl(CannedAccessControlList.PublicRead));
//			
//			S3Object s3object = s3client.getObject(new GetObjectRequest(awsC.getBucketName(), name));
//			
//			ra.addAttribute("picUrl", s3object.getObjectContent().getHttpRequest().getURI().toString());
//			
//			System.out.println(s3object.getObjectContent().getHttpRequest().getURI().toString());
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return "redirect:/user";
//	}

}
