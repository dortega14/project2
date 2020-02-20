package com.revature.connection;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfig {
	
	private AWSCredentials cred;
    private String accessKey = "AKIAUPQUDQ7AYSR2OAIV"; 
    private String secretKey = "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";
    private AmazonS3 s3;
    private String bucketName = "socialmediap2";
	
    public AwsConfig() {
        cred = new BasicAWSCredentials(accessKey, secretKey);
        s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred))
            .withRegion(Regions.US_EAST_1).build();
    }

    public AmazonS3 gets3(){
        return this.s3;
    }

    public String getBucketName(){
        return this.bucketName;
    }
}
