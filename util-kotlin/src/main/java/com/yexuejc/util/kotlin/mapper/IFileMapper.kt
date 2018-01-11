package com.yexuejc.util.kotlin.mapper

import com.yexuejc.util.kotlin.web.vo.UploadFileModel
import org.apache.ibatis.annotations.*

/**
 * 文件持久化层
 * @PackageName: com.yexuejc.util.kotlin
 * @Description:
 * @author: maxf
 * @date: 2018/1/11 16:44
 */
@Mapper
interface IFileMapper {
    /**
     * 保存
     */
    @Insert("INSERT INTO tb_update (update_id, update_type, update_version, update_min_version, update_code, update_note, update_ismust, update_url,update_crt_time,update_filesize)"
            + " VALUES (#{id}, #{type}, #{version}, #{minVersion}, #{code}, #{note}, #{ismust}, #{fileUrl},now(),#{fileSize})")
    fun save(model: UploadFileModel): Int

    /**
     * 获取update列表
     * @return
     */
    @Results(
            Result(column = "update_id", property = "id")
            , Result(column = "update_version", property = "version")
            , Result(column = "update_code", property = "code")
            , Result(column = "update_min_version", property = "minVersion")
            , Result(column = "update_note", property = "note")
            , Result(column = "update_ismust", property = "ismust")
            , Result(column = "update_url", property = "fileUrl")
            , Result(column = "update_crt_time", property = "crtTime")
            , Result(column = "update_type", property = "type")
            , Result(column = "update_filesize", property = "fileSize")
    )
    @Select("SELECT * from tb_update ORDER BY update_crt_time desc")
    fun list(): List<UploadFileModel>

    /**
     * 根据id获取数据
     */
    @Results(
            Result(column = "update_id", property = "id")
            , Result(column = "update_version", property = "version")
            , Result(column = "update_code", property = "code")
            , Result(column = "update_min_version", property = "minVersion")
            , Result(column = "update_note", property = "note")
            , Result(column = "update_ismust", property = "ismust")
            , Result(column = "update_url", property = "fileUrl")
            , Result(column = "update_crt_time", property = "crtTime")
            , Result(column = "update_type", property = "type")
            , Result(column = "update_filesize", property = "fileSize")
    )
    @Select("SELECT * from tb_update where update_id=#{id}")
    fun getUploadById(id: String): UploadFileModel
}