package com.yexuejc.util.simple.web;

import com.yexuejc.util.base.constant.RespsConstant;
import com.yexuejc.util.base.excel.ExcelImportUtils;
import com.yexuejc.util.base.http.Resps;
import com.yexuejc.util.simple.constant.IMapConstant;
import com.yexuejc.util.simple.pojo.User;
import com.yexuejc.util.simple.service.ExcelSrv;
import com.yexuejc.util.simple.service.UserSrv;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * excel 上传、下载、处理
 *
 * @PackageName: com.yexuejc.util.simple.web
 * @Description:
 * @author: maxf
 * @date: 2017/12/28 15:31
 */
@RestController
public class ExcelCtrl {

    @Autowired
    ExcelSrv excelSrv;
    @Autowired
    UserSrv userSrv;

    /**
     * 下载xecel模板
     *
     * @return
     */
    @RequestMapping(value = "/excel/download", method = RequestMethod.GET)
    public Object excelDownload(HttpServletRequest request, HttpServletResponse response) {
        String filePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "file/";
        String fileName = "user.xlsx";
        try {
            File file = new File(filePath + fileName);
            // 如果文件不存在
            if (!file.exists()) {
                return Resps.fail("获取失败");
            }
            // 设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            // 读取要下载的文件，保存到文件输入流
            FileInputStream in = new FileInputStream(filePath + fileName);
            // 创建输出流
            OutputStream out = response.getOutputStream();
            // 创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区当中
            while ((len = in.read(buffer)) > 0) {
                // 输出缓冲区的内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            // 关闭文件输入流
            in.close();
            // 关闭输出流
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Resps.success("下载成功");
    }


    @RequestMapping(value = "/excel/upload", method = RequestMethod.PUT)
    public Object excelUpload(@RequestParam(value = "filename") MultipartFile file, HttpServletRequest request,
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

        Map<String, Object> map = excelSrv.saveExcel(fileName, file);
        if (map == null) {
            return Resps.error("文件处理失败！");
        }
        File tmpFile = (File) map.get(IMapConstant.TEMP_FILE);

        //批量导入
        map = excelSrv.excel2User((Workbook) map.get(IMapConstant.WORK_BOOK), tmpFile);
        if (map.get(IMapConstant.LIST) == null) {
            return Resps.error(map.get(IMapConstant.MSG) == null ? "没有获取到数据" : map.get(IMapConstant.MSG).toString());
        }
        List<User> userList = (List<User>) map.get(IMapConstant.LIST);
        for (User user : userList) {
            System.out.println(user.toString());
        }

        boolean b = userSrv.addUsers(userList);

        //删除上传的临时文件
        if (tmpFile.exists()) {
            tmpFile.delete();
        }
        return Resps.success(RespsConstant.MSG_SUCCESS_HTTP);
    }


}
