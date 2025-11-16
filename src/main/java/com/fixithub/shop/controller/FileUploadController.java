package com.fixithub.shop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "http://localhost:5173")
public class FileUploadController {

    // private static final String UPLOAD_DIR = "uploads/";
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/"; // ✅ Đường dẫn tuyệt đối

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        // ✅ Tạo thư mục nếu chưa tồn tại
        Files.createDirectories(Paths.get(UPLOAD_DIR));

        // ✅ Lưu file
        String filePath = UPLOAD_DIR + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        // ✅ Trả lại đường dẫn (relative để frontend dùng)
        return ResponseEntity.ok("/" + filePath);
    }
}
