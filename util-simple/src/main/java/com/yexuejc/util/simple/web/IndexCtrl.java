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


}
