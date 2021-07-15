package com.example.scai_yd_server.dao;

import com.example.scai_yd_server.model.PicInfoModel;
import com.example.scai_yd_server.model.PicTypeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PicListDao {

    List<PicInfoModel> queryPicListByType(String typeId);

    void deleteTypeById(Integer id);

    List<PicTypeModel> queryPicTypeList();

    PicInfoModel queryPicDetailById(String id);

    List<PicInfoModel> queryPicListByTypeName(@Param(value="typeName")String typeName);

    List<PicInfoModel> queryPics();

    void deletePicById(Integer id);

    List<PicInfoModel> searchPicListByKey(String key);

    void saveInfo(PicInfoModel picInfo);

    void saveType(PicTypeModel picTypeModel);

    void updataPicType(PicTypeModel picTypeModel);

    void updatePicInfoById(PicInfoModel picInfo);
}
