package com.example.scai_yd_server.controller;

import com.example.scai_yd_server.base.ODDGenerator;
import com.example.scai_yd_server.base.Result;
import com.example.scai_yd_server.base.ResultGenerator;
import com.example.scai_yd_server.dao.PicListDao;
import com.example.scai_yd_server.model.PicInfoModel;
import com.example.scai_yd_server.model.PicTypeModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/picture")
public class PicInfoController {

    @Autowired
    private PicListDao picListDao;

    @RequestMapping(value = "/queryPicTypeList", method = {RequestMethod.GET})
    @ResponseBody
    public Result<List<PicTypeModel>> queryPicTypeList(HttpServletRequest request){

        List<PicTypeModel> picTypes = picListDao.queryPicTypeList();
        return ResultGenerator.success(picTypes);
    }
    @RequestMapping(value = "/deleteTypeById", method = {RequestMethod.POST})
    @ResponseBody
    public Result<List<PicTypeModel>> deleteTypeById(Integer id){

        picListDao.deleteTypeById(id);
        return ResultGenerator.success();
    }
    @RequestMapping(value = "/queryPicListByTypeId", method = {RequestMethod.GET})
    public Result<List<PicInfoModel>> queryPicListByTypeId(@RequestParam(name = "typeId") String typeId){

        List<PicInfoModel> picList = picListDao.queryPicListByType(typeId);

        return ResultGenerator.success(picList);
    }
    @RequestMapping(value = "/queryPicListByTypeName", method = {RequestMethod.GET})
    public Result<PageInfo<PicInfoModel>> queryPicListByTypeName(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                             @RequestParam(value = "pageSize",defaultValue = "6")Integer pageSize,
                                                             @RequestParam(name = "typeName") String typeName){

        PageHelper.startPage(pageNum,pageSize);
        List<PicInfoModel> picList = picListDao.queryPicListByTypeName(typeName);
        PageInfo<PicInfoModel> pageInfo = new PageInfo<PicInfoModel>(picList);
        return ResultGenerator.success(pageInfo);
    }
    @RequestMapping(value = "/queryPicDetailById", method = {RequestMethod.GET})
    public Result<PicInfoModel> queryPicDetailById(@RequestParam(name = "id") String id){

        PicInfoModel picList = picListDao.queryPicDetailById(id);

        return ResultGenerator.success(picList);
    }
    @RequestMapping(value = "/queryPics", method = {RequestMethod.GET})
    public Result<PageInfo<PicInfoModel>> queryPics(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                @RequestParam(value = "pageSize",defaultValue = "6")Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<PicInfoModel> picList = picListDao.queryPics();
        PageInfo<PicInfoModel> pageInfo = new PageInfo<PicInfoModel>(picList);

        return ResultGenerator.success(pageInfo);
    }


    @RequestMapping(value = "/deletePicById", method = {RequestMethod.POST})
    @ResponseBody
    public Result<List<PicTypeModel>> deletePicById(Integer id){

        picListDao.deletePicById(id);
        return ResultGenerator.success();
    }
    @RequestMapping(value = "/search", method = {RequestMethod.GET})
    public Result<PageInfo<PicInfoModel>> search(String key,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                             @RequestParam(value = "pageSize",defaultValue = "6")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PicInfoModel> picList = picListDao.searchPicListByKey(key);
        PageInfo<PicInfoModel> pageInfo = new PageInfo<PicInfoModel>(picList);
        return ResultGenerator.success(pageInfo);
    }

    @RequestMapping(value = "/fileUpload", method = {RequestMethod.POST})
    public Result<String> fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = System.getProperty("user.dir")+"\\upload\\img\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/upload/img/" + fileName;
        return ResultGenerator.success(filename);
    }
    @RequestMapping(value = "/fileUploads", method = {RequestMethod.POST})
    public Object fileUploads(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = System.getProperty("user.dir")+"\\upload\\img\\"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/upload/img/" + fileName;
        Map<String,Object> map = new HashMap<>();
        map.put("data", new String[]{filename});
        map.put("errno", 0);
        return map;
    }
    @RequestMapping(value = "/saveInfo", method = {RequestMethod.POST})
    @ResponseBody
    public Result<String> saveInfo(PicInfoModel picInfo){
        if(picInfo.getId()!=null){
            picListDao.updatePicInfoById(picInfo);
        }else{
            picInfo.setNumber(ODDGenerator.getC(null));
            picListDao.saveInfo(picInfo);
        }

        return ResultGenerator.success("保存成功",null);
    }
    @RequestMapping(value = "/savePicType", method = {RequestMethod.POST})
    @ResponseBody
    public Result<String> saveType(PicTypeModel picTypeModel){

        if(picTypeModel.getId()!=null){
            picListDao.updataPicType(picTypeModel);
        }else{
            picListDao.saveType(picTypeModel);
        }

        return ResultGenerator.success("保存成功",null);
    }

}
