package com.yexuejc.util.kotlin.web

import com.yexuejc.util.base.util.StrUtil
import com.yexuejc.util.kotlin.service.IFileSrv
import com.yexuejc.util.kotlin.web.vo.UploadFileModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.io.File
import java.io.FileInputStream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/file")
class FileCtrl {
    @Autowired
    val fileSrv: IFileSrv? = null

    @RequestMapping("/list")
    fun list(): ModelAndView {
        val mv = ModelAndView("list")
        val list = fileSrv!!.list()
        if (list != null) {
            mv.addObject("list", list)
            mv.addObject("ext", list!!.size)
        } else {
            mv.addObject("list", "")
            mv.addObject("ext", 0)
        }
        return mv
    }

    /**
     * 下载指定id文件
     *
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/download", produces = arrayOf("application/json;charset=utf-8"))
    fun download(id: String, request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val mv = ModelAndView("succ")
        if (StrUtil.isEmpty(id)) {
            mv.addObject("ret", "E")
            mv.addObject("msg", "文件不存在")
            return mv
        }
        val model = fileSrv!!.getUploadById(id)
        if (model == null) {
            mv.addObject("ret", "E")
            mv.addObject("msg", "文件不存在")
            return mv
        }
        val file = File(model!!.fileUrl)
        // 如果文件不存在
        if (!file.exists()) {
            mv.addObject("msg", "您要下载的资源不存在")
            mv.addObject("ret", "E")
            return mv
        }
        downloadFile(model, request, response)
        return mv
    }

    /**
     * 下载文件
     */
    fun downloadFile(model: UploadFileModel, request: HttpServletRequest, response: HttpServletResponse) {
        try {
            // 设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition",
                    "attachment;filename=" + model.fileUrl!!.substring(model.fileUrl!!.lastIndexOf("/") + 1))
            // 读取要下载的文件，保存到文件输入流
            val inputStream = FileInputStream(model.fileUrl!!)
            // 创建输出流
            val out = response.outputStream
            // 创建缓冲区
            val buffer = ByteArray(1024)
            var len: Int = inputStream.read(buffer)
            // 循环将输入流中的内容读取到缓冲区当中
            // 输出缓冲区的内容到浏览器，实现文件下载
            while (len > 0) {
                len = inputStream.read(buffer)
                out.write(buffer, 0, len)
            }
            // 关闭文件输入流
            inputStream.close()
            // 关闭输出流
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


}