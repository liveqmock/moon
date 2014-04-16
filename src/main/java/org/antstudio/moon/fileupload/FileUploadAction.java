package org.antstudio.moon.fileupload;

import java.io.File;
import java.io.IOException;

import org.antstudio.moon.rest.annotation.Post;
import org.antstudio.support.session.SessionContext;
import org.antstudio.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadAction {

	/**
	 * 文件上传,主要用于配合前端web uploader.使用此控制器时需要将web uploader
	 * @param file
	 * @return
	 * @throws IOException
	 */
    @Post("/file/upload")
    public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile[]  files) throws IOException{
    	for(MultipartFile file:files){
    		File f = new File(SessionContext.getWebAppPath()+"upload/"+file.getOriginalFilename());
    		if(f.exists()){
    			f = new File(SessionContext.getWebAppPath()+"upload/"+file.getOriginalFilename());
    		}
    		FileUtils.save(file.getInputStream(),FileUtils.getFileNotExists(f));
    	}
        return "";
    }
    
}
