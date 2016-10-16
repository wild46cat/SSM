package com.xueyou.ssm.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xueyou.ssm.utils.Base;
import com.xueyou.ssm.utils.SysContent;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/3.
 */
@RestController
@RequestMapping(value = "/file", method = RequestMethod.POST, produces = "application/json;charset=UTF-8;")
public class FileUploadController {

    @RequestMapping(value = "/upload",produces = "text/html;charset=UTF-8;")
    private String fileUpload(MultipartFile file, Model model) {
        Map<String, Object> resMap = new HashMap<>();
        if (!file.isEmpty()) {
            HttpServletRequest request = SysContent.getRequest();
            String relativePathDir = "/ssmUpload/files";
            String realPathDir = request.getSession().getServletContext().getRealPath(relativePathDir);
            String fileSign = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(Calendar.getInstance().getTime());
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = realPathDir + "/" + file.getName() + fileSign + suffix;
            System.out.println(fileName);
            File myDir = new File(realPathDir);
            if (!myDir.exists()) {
                myDir.mkdirs();
            }
            File uploadFile = new File(fileName);
            try {
                byte[] filebytes = file.getBytes();
                file.transferTo(uploadFile);
                resMap.put("resMsg", Base.MSG_SUCCESS);
                resMap.put("resCode", Base.MSG_CODE_SUCCESS);
                resMap.put("resFile", new BASE64Encoder().encode(filebytes));
                resMap.put("resFilePath",relativePathDir + "/" + file.getName() + fileSign + suffix);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            resMap.put("resCode", Base.MSG_CODE_ERROR);
            resMap.put("resMsg", Base.MSG_ERROR);
        }
        String resJson = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            resJson = mapper.writeValueAsString(resMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resJson;
    }
}
