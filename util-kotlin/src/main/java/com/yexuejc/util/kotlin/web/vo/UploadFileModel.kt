package com.yexuejc.util.kotlin.web.vo

import java.io.Serializable

/**
 * @author maxf:yexue
 * @className UploadFileModel
 * @description
 * @time 2017年11月3日 下午3:11:57
 */
class UploadFileModel : Serializable {
    /**
     * 文件路径
     */
    var fileUrl: String? = null
    /**
     * 更新版本号
     */
    var version: String? = null
    /**
     * 版本code
     */
    var code: Int = 0
    /**
     * 更新说明
     */
    var note: String? = null
    /**
     * 支持最小版本号
     */
    var minVersion: String? = null
    /**
     * 是否强制更新
     */
    var ismust: String? = null
    /**
     * 更新客户端（A：android,I:ios）
     */
    var type: String? = null

    var id: String? = null
    var crtTime: String? = null
    /**
     * 文件大小
     */
    var fileSize: Long? = null

    override fun toString(): String {
        return ("UploadFileModel [fileUrl=" + fileUrl + ", version=" + version + ", code=" + code + ", note=" + note
                + ", minVersion=" + minVersion + ", ismust=" + ismust + ", type=" + type + ", id=" + id + "]")
    }

    companion object {
        private const val serialVersionUID = -2509266299451520613L
    }
}
