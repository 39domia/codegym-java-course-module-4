package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.form.MyUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
public class MyFileUploadController {

    // Phương thức này được gọi mỗi lần có Submit.

    // GET: Hiển thị trang form upload
    @GetMapping("/uploadOneFile")
    public String uploadOneFileHandler(Model model) {
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);

        return "uploadOneFile";
    }

    // POST: Sử lý Upload
    @PostMapping("/uploadOneFile")
    public String uploadOneFileHandlerPOST(HttpServletRequest request, Model model, @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {

        return this.doUpload(request, model, myUploadForm);

    }

    // GET: Hiển thị trang form upload
    @GetMapping("/uploadMultiFile")
    public String uploadMultiFileHandler(Model model) {

        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);

        return "uploadMultiFile";
    }

    // POST: Sử lý Upload
    @PostMapping("/uploadMultiFile")
    public String uploadMultiFileHandlerPOST(HttpServletRequest request, Model model,
                                             @ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {
        return this.doUpload(request, model, myUploadForm);
    }

    private String doUpload(HttpServletRequest request, Model model, MyUploadForm myUploadForm) {
        String description = myUploadForm.getDescription();
        System.out.println("Description: " + description);
        // Thư mục gốc upload file.
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath);
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] fileDatas = myUploadForm.getFileDatas();
        Map<File, String> uploadedFiles = new HashMap();
        for (CommonsMultipartFile fileData : fileDatas) {
            // Tên file gốc tại Client.
            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = " + name);
            if (name != null && name.length() > 0) {
                try {
                    // Tạo file tại Server.
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
                    // Luồng ghi dữ liệu vào file trên Server.
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    uploadedFiles.put(serverFile, name);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                }
            }
        }
        model.addAttribute("description", description);
        model.addAttribute("uploadedFiles", uploadedFiles);
        return "uploadResult";
    }

}