package cn.sjzc.manageSystem.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileTools {

	public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {

		String extName = "";
		String picRelativePath = "/Pic"; // 返回url前缀
		String filePath = "/grain/Pic";
		String originalFilename = file.getOriginalFilename();// 得到上传的文件名
		extName = originalFilename.substring(originalFilename.lastIndexOf("."));// 得到图片的后缀

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String nowTime = sdf.format(new Date());
		int randomCode = (int) (Math.random() * (999 - 100) + 100);
		String fileName = nowTime + randomCode + extName;// 生成新文件名
		// 创建了一个File对象，名字是newFile，路径是filePath，名字是filename。
		File newFile = new File(filePath, fileName);
		if (!newFile.exists()) {
			if (!newFile.getParentFile().exists()) {
				newFile.getParentFile().mkdirs();
			}
			newFile.createNewFile();
		}

		FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
		String picDataPath = picRelativePath + "/" + fileName;
		return picDataPath;
	}
}
