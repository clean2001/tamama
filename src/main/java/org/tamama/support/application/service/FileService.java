//package org.tamama.support.application.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//
//@RequiredArgsConstructor
//@Service
//public class FileService {
////    private final AmazonS3 amazonS3;
//
//    public String uploadFile(MultipartFile file) {
//        // 파일을 서버에 임시저장
//        String originalFileName = file.getName();
//        File tempFile = new File("/temp/files/" + originalFileName);
//        multipartFile.transferTo(tempFile);
//
//        try {
//            // 2. S3에 업로드
//            String s3Key = "uploads/" + tempFileName;
//            amazonS3.putObject(bucket, s3Key, tempFile);
//
//            // 3. 업로드된 S3 URL 반환
//            return amazonS3.getUrl(bucket, s3Key).toString();
//
//        } finally {
//            // 4. 임시파일 삭제
//            if (tempFile.exists()) {
//                tempFile.delete();
//            }
//        }
//    }
//}
