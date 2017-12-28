package com.yexuejc.util.simple.web;

import com.yexuejc.util.base.constant.RespsConstant;
import com.yexuejc.util.base.excel.ExcelImportUtils;
import com.yexuejc.util.base.http.Resps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @PackageName: com.yexuejc.util.simple
 * @Description:
 * @author: maxf
 * @date: 2017/12/27 14:05
 */
@RestController
public class IndexCtrl {
    @Value("${application.version}")
    private String version;


    @RequestMapping("/")
    private Object index() {
        return "yexuejc-util Simple Project by Spring Boot.\t\n version:" + version;
    }

    @RequestMapping(value = "/consumerBat", method = RequestMethod.POST)
    public Object consumerBat(@RequestParam(value = "filename") MultipartFile file, HttpServletRequest request,
                              HttpServletResponse response)
            throws IOException {

        //判断文件是否为空
        if (file == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Resps.error("文件不能为空！");
        }

        //获取文件名
        String fileName = file.getOriginalFilename();

        //验证文件名是否合格
        if (!ExcelImportUtils.validateExcel(fileName)) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Resps.error("文件必须是excel格式！");
        }

        //进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
        long size = file.getSize();
        if (StringUtils.isEmpty(fileName) || size == 0) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return Resps.error("文件不能为空！");
        }

        //批量导入
//        Map<String, Object> map = consumerSrv.consumerBat(fileName, file);
//        if (!map.get("rc").equals("S")) {
//            return new Resps<>("E", new String[]{map.get("msg").toString()});
//        }
        return Resps.success(RespsConstant.MSG_SUCCESS_HTTP);
    }
}
