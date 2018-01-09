package com.yexuejc.util.kotlin.web

import com.yexuejc.util.base.constant.RespsConstant
import com.yexuejc.util.kotlin.web.vo.UploadFileModel
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import com.yexuejc.util.base.util.StrUtil
import com.yexuejc.util.base.http.Resps
import com.yexuejc.util.base.util.FileUtil
import org.springframework.beans.factory.annotation.Value


/**
 * @PackageName: com.yexuejc.util.kotlin.web
 * @Description:
 * @author: maxf
 * @date: 2018/1/8 18:44
 */
@RestController
@RequestMapping("/file")
class UpdateCtrl {
    private val DATA_N = "N"
    private val DATA_Y = "Y"
    private val TYPE_A = "A"
    private val TYPE_I = "I"

    @Value(value = "\${upload.root.path}")
    val rootPath: String? = null


    @RequestMapping("/upload/goto")
    fun goto(): ModelAndView {
        var mv = ModelAndView("/upload");
        return mv;
    }

    @RequestMapping(value = "upload", produces = arrayOf("multipart/form-data;charset=UTF-8"))
    fun upload(@RequestParam("file") file: MultipartFile, model: UploadFileModel,
               request: HttpServletRequest): ModelAndView {
        var mv = ModelAndView("succ");
        var resps = checkUploadFileModel(model);
        if (resps.code != RespsConstant.CODE_SUCCESS) {
            mv.addObject("code", resps.code)
            mv.addObject("msg", resps.msg)
            return mv;
        }
        var filePath: String? = ""
        if (file != null && !file.isEmpty) {
            filePath = rootPath + "/v_" + model.version + "_" + System.currentTimeMillis() + "." + FileUtil
                    .getFileType(file.getOriginalFilename());
        }

        return mv;
    }

    /**
     * checkFileModel
     */
    private fun checkUploadFileModel(model: UploadFileModel): Resps<Any> {
        model.id = StrUtil.genUUID()
        if (StrUtil.isEmpty(model.version)) {
            return Resps.fail("版本号为空")

        }
        if (StrUtil.isEmpty(model.code)) {
            return Resps.fail("支持最低版本号为空")
        }
        if (DATA_N.equals(model.ismust) && StrUtil.isEmpty(model.minVersion)) {
            return Resps.fail("支持最低版本号为空")
        }
        return Resps.success("保存成功")
    }


}
