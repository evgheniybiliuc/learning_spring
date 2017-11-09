package home.learning.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        return saveUploadedFile(name, file);
    }


    @RequestMapping(value = "/uploadMultipleFiles", method = RequestMethod.POST)
    @ResponseBody
    public String uploadMultipleFileHandler(@RequestParam("name") String[] names, @RequestParam("file") MultipartFile[] files) {
        if (files.length != names.length)
            return "Mandatory inforamtion missing";
        StringBuilder messageBuilder = new StringBuilder();

        for (int i = 0; i < files.length; i++) {
            messageBuilder.append(saveUploadedFile(names[i], files[i]));
            messageBuilder.append("<br/>");
        }
        return messageBuilder.toString();
    }


    private String saveUploadedFile(String name, MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(serverFile));

                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
                logger.info("Server file loaction" + serverFile.getAbsolutePath());
                return "you successfully uploaded file:" + name;
            } catch (IOException e) {
                return "Failed to upload file:" + name;
            }
        } else {
            return "Failed to upload file:" + name;
        }
    }
}
