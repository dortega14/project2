package com.revature.connection;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
/**
 * 
 * @author TeamLeo
 * This class configures the environment variables
 * for the Amazon Simple Storage Service to
 * enable uploading an image into an S3 bucket.
 */
@Configuration
public class AwsConfig {
	
	/**
	 * Instance variables.
	 */
	private AWSCredentials cred;
    private String accessKey = ""; 
    private String secretKey = "";
    private AmazonS3 s3;
    private String bucketName = "socialmediap2";
	
    /**
     * Access key and secret key configuration.
     */
    public AwsConfig() {
        cred = new BasicAWSCredentials(accessKey, secretKey);
        s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred))
            .withRegion(Regions.US_EAST_1).build();
    }

    /**
     * getter for s3.
     * @return s3
     */
    public AmazonS3 gets3(){
        return this.s3;
    }

    /**
     * getter for bucketName.
     * @return bucketName
     */
    public String getBucketName(){
        return this.bucketName;
    }
}
