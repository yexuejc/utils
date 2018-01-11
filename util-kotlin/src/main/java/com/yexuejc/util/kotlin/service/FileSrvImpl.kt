package com.yexuejc.util.kotlin.service

import com.yexuejc.util.kotlin.mapper.IFileMapper
import com.yexuejc.util.kotlin.web.vo.UploadFileModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * 文件处理
 * @PackageName: com.yexuejc.util.kotlin.service
 * @Description:
 * @author: maxf
 * @date: 2018/1/11 16:35
 */
@Service
class FileSrvImpl : IFileSrv {


    @Autowired
    val fileMapper: IFileMapper? = null

    /**
     * 保存
     */
    override fun save(model: UploadFileModel): Int {
        return fileMapper!!.save(model)
    }
    override fun list(): List<UploadFileModel> {
        return fileMapper!!.list()
    }
    override fun getUploadById(id: String): UploadFileModel {
        return fileMapper!!.getUploadById(id)
    }

}