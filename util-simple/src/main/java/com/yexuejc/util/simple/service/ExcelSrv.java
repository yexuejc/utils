package com.yexuejc.util.simple.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * Excel 逻辑处理
 *
 * @ClassName: ExcelSrv
 * @Description:
 * @author: maxf
 * @date: 2017/12/28 15:34
 */
public interface ExcelSrv {
    /**
     * 保存excel文件
     *
     * @param fileName 文件名称
     * @param file
     * @return
     */
    Map<String, Object> saveExcel(String fileName, MultipartFile file);

    /**
     * 转换user
     * @param workbook
     * @param file
     * @return
     */
    Map<String, Object> excel2User(Workbook workbook, File file);
}
