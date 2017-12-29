package com.yexuejc.util.simple.service;

import com.yexuejc.util.base.excel.ExcelImportUtils;
import com.yexuejc.util.base.util.StrUtil;
import com.yexuejc.util.base.util.SysUtils;
import com.yexuejc.util.simple.constant.IMapConstant;
import com.yexuejc.util.simple.pojo.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel 逻辑处理
 *
 * @ClassName: ExcelSrvImpl
 * @Description:
 * @author: maxf
 * @date: 2017/12/28 15:35
 */
@Service
public class ExcelSrvImpl implements ExcelSrv {
    private static final DecimalFormat df = new DecimalFormat("#");

    /**
     * 获取excel单元格内容，当单元格内容为number时，转换成string
     *
     * @param cell
     * @return
     */
    private String getCell(Cell cell) {
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                // 数字
                return df.format(cell.getNumericCellValue());
            default:
                return cell.getStringCellValue();
        }
    }

    /**
     * 保存excel文件
     *
     * @param fileName
     * @param mfile
     * @return
     */
    @Override
    public Map<String, Object> saveExcel(String fileName, MultipartFile mfile) {
        Map<String, Object> map = new HashMap<>(2);
        String filePath = SysUtils.getCachePath();
        File uploadDir = new File(filePath);
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        //新建一个文件
        File tempFile = new File(filePath + "/" + System.currentTimeMillis() + "-" + fileName);
        //初始化输入流
        InputStream is = null;
        try {
            //将上传的文件写入新建的文件中
            mfile.transferTo(tempFile);

            //根据新建的文件实例化输入流
            is = new FileInputStream(tempFile);

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if (ExcelImportUtils.isExcel2007(fileName)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = new HSSFWorkbook(is);
            }
            //根据excel里面的内容读取知识库信息
            map.put(IMapConstant.WORK_BOOK, wb);
            map.put(IMapConstant.TEMP_FILE, tempFile);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 转换user
     *
     * @param wb
     * @param file
     * @return
     */
    @Override
    public Map<String, Object> excel2User(Workbook wb, File file) {
        Map<String, Object> map = new HashMap<>(2);
        map.put(IMapConstant.MSG, "");
        List<User> userList = new ArrayList<>();

        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        //得到Excel的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        //总列数
        int totalCells = 0;
        //得到Excel的列数(前提是有行数)，从第2行算起,第一行时标题
        if (totalRows >= 2 && sheet.getRow(1) != null) {
            totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
        }

        //循环Excel行数,从第二行开始。标题不入库
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                map.put(IMapConstant.MSG, map.get(IMapConstant.MSG) + "\n" +
                        "第" + (r + 1) + "行数据有问题，请仔细检查！");
                continue;
            }
            User user = new User();
            user.setId(StrUtil.genUUID());
            //循环Excel的列
            boolean cellBool = true;
            for (int c = 0; c < totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    switch (c) {
                        case 0:
                            //mobile
                            user.setMobile(getCell(cell));
                            break;
                        case 1:
                            //昵称
                            user.setAlias(getCell(cell));
                            break;
                        case 2:
                            //pwd
                            user.setPwd(StrUtil.toMD5(getCell(cell)));
                            break;
                        case 3:
                            //简介
                            user.setIntro(getCell(cell));
                            break;
                    }
                } else {
                    cellBool = false;
                    map.put(IMapConstant.MSG, map.get(IMapConstant.MSG) + "\n" +
                            "第" + (r + 1) + "行第" + (c + 1) + "列数据有问题，请仔细检查！");
                }
            }
            if (cellBool) {
                userList.add(user);
            }
        }
        map.put(IMapConstant.LIST, userList);
        return map;
    }
}
