package fengge.controller;

import fengge.DTO.ExcelEntity;
import fengge.config.ExcelListener;
import fengge.config.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Feng, Ge 2021/5/30 0030 10:55
 */
@RestController
@RequestMapping("/excel")
public class ExcelDownloadController {

    private static final Logger log = LoggerFactory.getLogger(ExcelDownloadController.class);

    /**
     * 单个文件上传
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(MultipartFile file) {
        String msg = "";
        try {
            if (file.isEmpty()) {
                msg = "文件为空";
                return msg;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            //创建一个临时文件，用于暂时存放
            File tmpFile = File.createTempFile("tmp", null);
            //将MultipartFile 转换为 File 临时文件
            file.transferTo(tmpFile);
            //将临时文件转为输入流
            InputStream inputStream = new FileInputStream(tmpFile);
            ExcelUtils.readExcel(inputStream, ExcelEntity.class);
            msg = "上传成功";
            //上传完成 删除临时文件
            tmpFile.delete();
            return msg;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg = "上传失败";
        return msg;
    }

}
