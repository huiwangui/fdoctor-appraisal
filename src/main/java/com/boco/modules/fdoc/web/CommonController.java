package com.boco.modules.fdoc.web;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.boco.common.constants.BusinessConstants;
import com.boco.common.json.BaseJsonVo;
import com.boco.common.utils.FTPUtils;
import com.boco.common.utils.JsonUtils;
import com.boco.common.utils.PropertiesUtils;
import com.boco.common.utils.StringUtils;

@Controller
@RequestMapping(value = "/common", produces = "application/json;charset=UTF-8")
public class CommonController {

	/**
	 * 
	 * imgUpload:(图片上传处理). <br/>
	 * 
	 * @author q
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
	@ResponseBody
	public String imgUpload(@RequestParam("file") CommonsMultipartFile img,
			HttpServletRequest request) {
		/**
		 * 图片上传部分
		 */
		try {
			InputStream is = img.getInputStream();

			// 生成jpeg图片
			String headSuffix = StringUtils.getSuffix(img.getOriginalFilename()); // 获取后缀名
			String signImgHeadName = UUID.randomUUID().toString().substring(0, 8)
					+ "." + headSuffix; // 重命名为8位随机数

			// 复制文件到指定路径
			File saveFile = new File(
					(request.getContextPath() + "/upload/img/" + signImgHeadName)
							.substring(9));
			FileUtils.copyInputStreamToFile(is, saveFile);
			// 上传文件到服务器
			FTPUtils.upload(saveFile, "/upload/img/");

			return JsonUtils.getJson(BaseJsonVo.success("/upload/img/"
					+ signImgHeadName));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtils.getJson(BaseJsonVo.error());
		}
	}
	
	/**
	 * 
	 * editorImgUpload:(文本编辑器插入图片上传). <br/>
	 * 
	 * @author q
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/editorImgUpload", method = RequestMethod.POST)
	@ResponseBody
	public String editorImgUpload(@RequestParam("file") CommonsMultipartFile img,
			HttpServletRequest request) {
		/**
		 * 图片上传部分
		 */
		try {
			InputStream is = img.getInputStream();

			// 生成jpeg图片
			String headSuffix = StringUtils.getSuffix(img.getOriginalFilename()); // 获取后缀名
			String signImgHeadName = UUID.randomUUID().toString().substring(0, 8)
					+ "." + headSuffix; // 重命名为8位随机数

			// 复制文件到指定路径
			File saveFile = new File(
					(request.getContextPath() + "/upload/article/" + signImgHeadName)
							.substring(9));
			FileUtils.copyInputStreamToFile(is, saveFile);
			// 上传文件到服务器
			FTPUtils.upload(saveFile, "/upload/article/");

			String webServerIp = PropertiesUtils.getValue("ftp_web_server_ip");
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("code", 0);
			returnMap.put("msg", "图片上传成功");
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("src", webServerIp + "/upload/article/"+ signImgHeadName);
			returnMap.put("data", dataMap);
			return JsonUtils.getJson(returnMap);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("code", 1);
			returnMap.put("msg", "图片上传失败");
			return JsonUtils.getJson(returnMap);
		}
	}
}
