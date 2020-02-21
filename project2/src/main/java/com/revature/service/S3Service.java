package com.revature.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.revature.connection.AwsConfig;

/**
 * @author TeamLeo
 * Service layer for the AWS
 * Simple Storage Service.
 */
@Service
public class S3Service {
	
	/**
	 * Automatically creates an association 
	 * to the AwsConfig
	 */
	@Autowired
    AwsConfig config;

	/**
	 * Upload a MultipartFile to the bucket
	 * @param file
	 * @return bucket URL
	 */
    public String upload(MultipartFile file) {
        File f;
        try{
            f = convertIntoFile(file);
            config.gets3().putObject(
                new PutObjectRequest(config.getBucketName(), f.getName(), f)
                .withCannedAcl(CannedAccessControlList.PublicRead));
                return "http://"+config.getBucketName()+"s3.us-east-1amazonaws.com/"+f.getName();
         } catch(IOException e){
                return null;
            }
        }


    /**
     * Converts a file into a MultipartFile
     * @param file
     * @return converted
     * @throws IOException
     */
    private File convertIntoFile(MultipartFile file) throws IOException {
        File converted = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(converted);
        fos.write(file.getBytes());
        fos.close();
        return converted;
    }

}
