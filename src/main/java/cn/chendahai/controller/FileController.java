package cn.chendahai.controller;

import cn.chendahai.config.FileConst;
import cn.chendahai.vo.JsonResult;
import cn.chendahai.vo.JsonResultFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/30 0030
 */
@RestController
@Api(tags = "文件上传下载")
public class FileController {

    @Autowired
    private FileConst fileConst;

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    @ResponseBody
    @ApiOperation("文件上传")
    public JsonResult uploadList(MultipartFile file) {
        try {
            String dataForm = new SimpleDateFormat("yyyy-MM").format(new Date());
            File uploadFile = new File(fileConst.getUploadPath() + "/" + dataForm + "/" + file.getOriginalFilename());
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            file.transferTo(uploadFile);
            return JsonResultFactory.success(uploadFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JsonResultFactory.success("ok");
    }

    /**
     * 文件下载
     */
    @RequestMapping(value = "/download", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @ApiOperation("文件下载")
    public void downloadList(String filePath, HttpServletResponse response) {
        File file = new File(filePath);
        if (file.exists()) {
            //首先设置响应的内容格式是force-download，那么你一旦点击下载按钮就会自动下载文件了
            response.setContentType("application/force-download");
            //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
            response.addHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
            //进行读写操作
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                //从源文件中读
                int i = bis.read(buffer);
                while (i != -1) {
                    //写到response的输出流中
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //善后工作，关闭各种流
                try {
                    if (bis != null) {
                        bis.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
