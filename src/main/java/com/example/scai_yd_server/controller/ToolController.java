package com.example.scai_yd_server.controller;

import com.example.scai_yd_server.base.Result;
import com.example.scai_yd_server.base.ResultGenerator;
import com.example.scai_yd_server.model.PicTypeModel;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi
        .xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/tool")
public class ToolController {

    @RequestMapping(value = "/getDownloadDoc", method = {RequestMethod.POST})
    @ResponseBody
    public Result<Object> queryPicTypeList(String docName) throws IOException {
        String filepath = System.getProperty("user.dir")+"\\upload\\";
        String fileName = docName+".docx";
        final String file = filepath + fileName;
        File f = new File(file);
        if (!f.exists()) {
            System.out.println("Sorry File does not Exists!");
            return ResultGenerator.success("Sorry File does not Exists!");
        } else {
            if (f.getName().endsWith(".docx") || f.getName().endsWith(".DOCX")) {

                // 1) 加载word文档生成 XWPFDocument对象
                InputStream in = new FileInputStream(f);
                XWPFDocument document = new XWPFDocument(in);

                // 2) 解析 XHTML配置 (这里设置IURIResolver来设置图片存放的目录)
                File imageFolderFile = new File(filepath);
                XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(imageFolderFile));
                options.setExtractor(new FileImageExtractor(imageFolderFile));
                options.setIgnoreStylesIfUnused(false);
                options.setFragment(true);

                // 3) 将 XWPFDocument转换成XHTML
//                OutputStream out = new FileOutputStream(new File(filepath + htmlName));
//                XHTMLConverter.getInstance().convert(document, out, options);

                //也可以使用字符数组流获取解析的内容
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                XHTMLConverter.getInstance().convert(document, baos, options);
                String content = baos.toString();
                Map<String,String> map = new HashMap<>();
                map.put("path",System.getProperty("user.dir"));
                map.put("content",content);
                return ResultGenerator.success(map);
//                System.out.println(content);
//                 baos.close();
            } else {
                System.out.println("Enter only MS Office 2007+ files");
                return ResultGenerator.success("Enter only MS Office 2007+ files");
            }
        }

    }
}
