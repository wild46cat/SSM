package com.xueyou.ssm.controller;

import com.xueyou.ssm.utils.SysContent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by wuxueyou on 16/10/7.
 */
@RestController
@RequestMapping(value = "/file", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8;")
public class FileDownloadController {
    @RequestMapping(value = "download")
    public void download(String path) throws IOException{
        final String fileName = "download";
        HttpServletResponse response = SysContent.getResponse();
        HttpServletRequest request = SysContent.getRequest();
        String realPath = request.getSession().getServletContext().getRealPath(path);
        response.reset();
        String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
        String suffix = realPath.substring(realPath.lastIndexOf("."));
        response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName + time + suffix, "UTF-8"));
        response.setContentType("application/octet-stream; charset=utf-8");
        File file = new File(realPath);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[bis.available()];
        OutputStream os = response.getOutputStream();
        bis.read(bytes);
        os.write(bytes);
    }
}
