package com.travelgo.user.service.s3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.io.InputStream;

@Service
public class S3Service {
    private final S3Client s3;
    @Value("${aws.s3.bucket}")
    private  String bucketName;

    @Autowired
    public S3Service(S3Client s3) {
        this.s3 = s3;
    }

    public String putObject(String key, MultipartFile file) throws IOException {

        System.out.println(file.getOriginalFilename());
        String directory = "travelGo/users/images/" + key + "-" + file.getOriginalFilename();
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(directory)
                .acl(ObjectCannedACL.PUBLIC_READ)
                .contentType("image/jpeg") // Set the appropriate content type
                .build();

        // Use the InputStream from the MultipartFile as the RequestBody
        try (InputStream is = file.getInputStream()) {
            PutObjectResponse response = s3.putObject(objectRequest, RequestBody.fromInputStream(is, file.getSize()));
        }
        //https://travelgohotelstorage.s3.us-east-2.amazonaws.com/hotelImages/H004travelgohotelstorage.s3.us-east-2.amazonaws.com/hotelImages/H004
        return "https://" + bucketName + ".s3.us-east-1.amazonaws.com/" + directory;
    }
}
