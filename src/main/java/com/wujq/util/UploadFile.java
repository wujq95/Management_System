package com.wujq.util;

import com.wujq.domain.User;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadFile {

    /**
     * upload portrait method
     * @param user
     * @param photo
     * @param request
     * @throws IOException
     */
    public static void upload(User user,MultipartFile photo, HttpServletRequest request) throws IOException {
        if(photo!=null&&photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){
            //define the photo upload path
            String path = request.getSession().getServletContext().getRealPath("upload");
            //get the name of the photo
            String realName = photo.getOriginalFilename();
            //get suffix
            String ext = FilenameUtils.getExtension(realName);
            //create a new photo name
            String newName = UUID.randomUUID().toString().replaceAll("-", "")+"."+ext;
            //create a new empty file
            File targetFile = new File(path, newName);
            //write photo into the empty file
            photo.transferTo(targetFile);
            user.setUser_img(newName);
        }
    }
}
