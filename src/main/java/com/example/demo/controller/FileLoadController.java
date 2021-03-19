package com.example.demo.controller;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/4/2 10:03
 */
@RestController
@RequestMapping("/upload")
public class FileLoadController {


    private String FilePath = "E:/img/";

    @RequestMapping(value = "/uploadimgAPP", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("file") MultipartFile[] file, @RequestParam String pathName,
                                      HttpServletRequest request) {

        Map<String, Object> map = new HashMap<String, Object>();

        if (file != null && file.length > 0) {

            String fileName = null;

            try {

                for (int i = 0; i < file.length; i++) {

                    if (!file[i].isEmpty()) {

                        map.put("fileName", uploadImage(FilePath + pathName, pathName, file[i], true));
                        System.out.println(fileName);
                        Map<String, String> mapqMap = new HashMap<String, String>();
                        mapqMap = (Map<String, String>) map.get("fileName");
                        fileName = mapqMap.get("YT");
                        System.out.println(fileName);
                    }
                }
                //上传成功
                if (fileName != null) {
                    System.out.println("上传成功！");
                    map.put("status", fileName);
                } else {
                    map.put("status", "上传失败！文件格式错误！");
                    //throw new RuntimeException("上传失败！文件格式错误！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                map.put("status", "上传异常！");
            }
        } else {
            map.put("status", "没有检测到有效文件！");
        }
        return map;
    }

    /**
     * 上传图片
     * 原名称
     *
     * @param file         文件
     * @param isRandomName 是否随机名称
     * @return 完整文件路径
     */
    public Map<String, String> uploadImage(String path, String pathName, MultipartFile file, boolean isRandomName) {
        //上传
        try {
            String[] typeImg = {"gif", "png", "jpg", "jpeg"};

            if (file != null) {

                String origName = file.getOriginalFilename();// 文件原名称
                System.out.println("上传的文件原名称:" + origName);
                // 判断文件类型
                String type = origName.indexOf(".") != -1 ? origName.substring(origName.lastIndexOf(".") + 1, origName.length()) : null;

                if (type != null) {
                    boolean booIsType = false;
                    for (int i = 0; i < typeImg.length; i++) {
                        if (typeImg[i].equals(type.toLowerCase())) {
                            booIsType = true;
                        }
                    }
                    //类型正确
                    if (booIsType) {
                        //组合名称
                        String fileSrc = "";
                        //是否随机名称
                        if (isRandomName) {
                            origName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + UUID.randomUUID().toString() + origName.substring(origName.lastIndexOf("."));
                        }


                        //判断是否存在目录
                        File Fpath = new File(path);
                        if (!Fpath.exists()) {
                            Fpath.mkdirs();//创建目录
                        }
                        //上传
                        File targetFile = new File(path, origName);
                        file.transferTo(targetFile);
                        //完整路径
                        fileSrc = path + "/" + origName;

                        //压缩图片
                        long size = file.getSize();
                        double scale = 1.0d;
                        if (size >= 200 * 1024) {
                            if (size > 0) {
                                scale = (200 * 1024f) / size;
                            }
                        }
                        try {
                            if (size < 200 * 1024) {
                                Thumbnails.of(fileSrc).scale(1f).toFile(fileSrc);
                            } else {
                                Thumbnails.of("C:/" + fileSrc).scale(1f).outputQuality(0.25f).toFile("C:/" + fileSrc);
                            }
                        } catch (Exception e1) {
                        }
                        //缩略图

                        String fileSrc1 = path + "/" + origName;
                        try {
                            Thumbnails.of(fileSrc).scale(0.4f).outputQuality(0.4f).toFile(fileSrc1);
                        } catch (Exception e1) {
                        }
                        System.out.println("图片上传成功:" + fileSrc);
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("SL", fileSrc1);
                        map.put("YT", fileSrc);
                        return map;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
