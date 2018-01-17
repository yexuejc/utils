package com.yexuejc.util.kotlin.web

import com.yexuejc.util.base.constant.RespsConstant
import com.yexuejc.util.base.http.Resps
import com.yexuejc.util.base.util.JsonUtil
import com.yexuejc.util.base.util.StrUtil
import com.yexuejc.util.kotlin.service.IFileSrv
import com.yexuejc.util.kotlin.web.vo.UploadFileModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.io.File
import java.io.FileInputStream
import java.text.DecimalFormat
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/file")
class FileCtrl {
    @Autowired
    var fileSrv: IFileSrv? = null
    val df = DecimalFormat("0.00")
    private val TYPE_A = "A"
    private val TYPE_I = "I"

    /**
     * 异步获取上传历史
     *
     * @return
     */
    @RequestMapping(value = "/list/json", produces = arrayOf("application/json;charset=utf-8"))
    @ResponseBody
    fun listJson(): Resps<List<UploadFileModel>>? {
        val list: List<UploadFileModel>? = fileSrv?.list()
        return Resps<List<UploadFileModel>>().setSucc(list)
    }

    /**
     * 文件列表
     */
    @RequestMapping("/list")
    fun list(): ModelAndView {
        val mv = ModelAndView("list")
        val list: List<UploadFileModel>? = fileSrv?.list()

        /// 遍历list1 转化model 为map， 然后处理数据，再添加到集合list2中
        val list2 = ArrayList<Map<String, Any>>()
        list?.forEach {
            val map: MutableMap<String, Any> = JsonUtil.json2Obj(JsonUtil.obj2Json(it), MutableMap::class.java) as
                    MutableMap<String, Any>
            val fileSize = map.get("fileSize") as Int
            if (fileSize / 1024 / 1024 > 0) {
                map.put("fileSize", df.format(fileSize.toDouble() / 1024 / 1024) + "MB")
            } else {
                map.put("fileSize", df.format(fileSize.toDouble() / 1024) + "KB")
            }
            list2.add(map)
        }
        if (list != null) {
            mv.addObject("list", list)
            mv.addObject("list2", list2)
            mv.addObject("ext", list?.size)
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
            mv.addObject("ret", RespsConstant.CODE_ERROR)
            mv.addObject("msg", "文件不存在")
            return mv
        }
        val model = fileSrv?.getUploadById(id)
        if (model == null) {
            mv.addObject("ret", RespsConstant.CODE_ERROR)
            mv.addObject("msg", "文件不存在")
            return mv
        }
        val file = File(model?.fileUrl)
        // 如果文件不存在
        if (!file.exists()) {
            mv.addObject("msg", "您要下载的资源不存在")
            mv.addObject("ret", RespsConstant.CODE_ERROR)
            return mv
        }
        downloadFile(model, request, response)
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
    @RequestMapping(value = "/download/json", produces = arrayOf("application/json;charset=utf-8"))
    @ResponseBody
    fun downloadJson(id: String, request: HttpServletRequest, response: HttpServletResponse): Any {
        if (StrUtil.isEmpty(id)) {
            return Resps.error("文件不存在")
        }
        val model = fileSrv?.getUploadById(id)
        if (model == null) {
            return Resps.error("文件不存在")
        }
        val file = File(model.fileUrl)
        // 如果文件不存在
        if (!file.exists()) {
            return Resps.error("您要下载的资源不存在")
        }
        downloadFile(model, request, response)
        return Resps.success(RespsConstant.MSG_SUCCESS_HTTP)
    }

    /**
     * 根据类型和版本code 获取更新文件
     *
     * @param type 类型 A I
     * @param code 版本code
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateNew", produces = arrayOf("application/json;charset=utf-8"))
    fun updateNew(type: String, code: Int, request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val mv = ModelAndView("succ")
        val checkParams = (StrUtil.isEmpty(type) || StrUtil.isEmpty(code) ||
                !(TYPE_A.equals(type) || TYPE_I.equals(type)))
        if (checkParams) {
            mv.addObject("ret", RespsConstant.CODE_ERROR)
            mv.addObject("msg", "参数错误")
            return mv
        }
        val model = fileSrv?.getUploadByType(type, code)
        if (model == null) {
            mv.addObject("ret", RespsConstant.CODE_ERROR)
            mv.addObject("msg", "文件不存在")
            return mv
        }
        val file = File(model?.fileUrl)
        // 如果文件不存在
        if (!file.exists()) {
            mv.addObject("msg", "您要下载的资源不存在")
            mv.addObject("ret", RespsConstant.CODE_ERROR)
            return mv
        }
        downloadFile(model, request, response)
        return mv
    }

    /**
     * 根据类型和版本code 获取更新文件
     *
     * @param type 类型 A I
     * @param code 版本code
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateNew/json", produces = arrayOf("application/json;charset=utf-8"))
    @ResponseBody
    fun updateNewJson(type: String, code: Int, request: HttpServletRequest,
                      response: HttpServletResponse): Any {
        val checkParam = (StrUtil.isEmpty(type) || StrUtil.isEmpty(code)
                || !(TYPE_A.equals(type) || TYPE_I.equals(type)))
        if (checkParam) {
            return Resps.error("参数错误")
        }
        val model = fileSrv?.getUploadByType(type, code)
        if (model == null) {
            return Resps.error("文件不存在")
        }
        val file = File(model.fileUrl)
        // 如果文件不存在
        if (!file.exists()) {
            return Resps.error("您要下载的资源不存在")
        }
        downloadFile(model, request, response)
        return Resps.success(RespsConstant.MSG_SUCCESS_HTTP)
    }

    /**
     * 更新android
     *
     * @param type
     * @param code
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/downloadAndroid", produces = arrayOf("application/json;charset=utf-8"))
    @ResponseBody
    fun downloadAndroid(request: HttpServletRequest, response: HttpServletResponse): Any {
        return downloadByType("A", request, response)
    }

    /**
     * 更新ios
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/downloadIOS", produces = arrayOf("application/json;charset=utf-8"))
    @ResponseBody
    fun downloadIOS(request: HttpServletRequest, response: HttpServletResponse): Any {
        return downloadByType("I", request, response)
    }

    /**
     * 更新json
     *
     * @param type
     * @param code
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/check/json", produces = arrayOf("application/json;charset=utf-8"))
    @ResponseBody
    fun check(type: String, code: Int, request: HttpServletRequest, response: HttpServletResponse): Any {
        val eheckParam = (StrUtil.isEmpty(type) || StrUtil.isEmpty(code)
                || !(TYPE_A.equals(type) || TYPE_I.equals(type)))
        if (eheckParam) {
            return Resps.error("参数错误")
        }
        val model = fileSrv?.getUploadByType(type, code)
        if (model == null) {
            return Resps.success("已经是最新版了")
        } else {
            return Resps<UploadFileModel>().setSucc(model)
        }
    }

    /**
     * 下载文件
     */
    private fun downloadFile(model: UploadFileModel, request: HttpServletRequest, response: HttpServletResponse) {
        try {
            // 设置响应头，控制浏览器下载该文件
            response.setHeader("content-disposition",
                    "attachment;filename=" + model.fileUrl?.substring(model.fileUrl?.lastIndexOf("/")?:0 + 1))
            // 读取要下载的文件，保存到文件输入流
            val inputStream = FileInputStream(model.fileUrl)
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

    private fun downloadByType(type: String, request: HttpServletRequest, response: HttpServletResponse): Any {
        val model: UploadFileModel? = fileSrv?.getUploadNowByType(type)
        if (model == null) {
            return Resps.error("文件不存在")
        }
        val file = File(model?.fileUrl)
        // 如果文件不存在
        if (!file.exists()) {
            return Resps.error("您要下载的资源不存在")
        }
        downloadFile(model, request, response)
        return Resps.success(RespsConstant.MSG_SUCCESS_HTTP)
    }

}