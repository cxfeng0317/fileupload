package com.company.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author CJF
 * @category 文件上传工具类
 */
@Component
public class FileUpload {

	@Value("${fileuploadpath}")
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 保存图片并返回地址
	 * 
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String upload(HttpServletRequest request) throws IllegalStateException, IOException {
//		图片地址
		String fileName = null;
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
			while (iterator.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multipartHttpServletRequest.getFile(iterator.next().toString());
				if (file != null) {
					fileName = file.getOriginalFilename();
					String path = getPath() + fileName;
					System.out.println("地址：" + path);
					// 上传
					file.transferTo(new File(path));
				}

			}
		}
		return fileName;
	}
}
