package com.wechat.util;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Shuang on 2018/5/15.
 */
@Component
@PropertySource(value = {"classpath:wechat.properties"})
public class QiniuUtil {
	@Value("${qiniu.AK}")
	private String accessKey;
	@Value("${qiniu.SK}")
	private String secretKey;
	@Value("${qiniu.Bucket}")
	private String bucket;
	@Value("${qiniu.url}")
	private String url;

	public String uploadImg(String key,MultipartFile file){
		String result = null;
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(Zone.zone2());
		//配置上传管理器
		UploadManager uploadManager = new UploadManager(cfg);
		//创建上传凭证
		Auth auth = Auth.create(accessKey, secretKey);
		//开始上传
		String upToken = auth.uploadToken(bucket,key);
		Response qresponse = null;
		try {
			qresponse = uploadManager.put(file.getInputStream(),key,upToken,null, null);
			//解析上传成功的结果
			DefaultPutRet putRet = JSONUtils.readValue(qresponse.bodyString(),DefaultPutRet.class);
//			System.out.println(putRet.key);
//			System.out.println(putRet.hash);

			result = url+putRet.key;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
	}

//	public void uploadFile(String filePath){
//		//构造一个带指定Zone对象的配置类
//		Configuration cfg = new Configuration(Zone.zone2());
//		//配置上传管理器
//		UploadManager uploadManager = new UploadManager(cfg);
//		//创建上传凭证
//		Auth auth = Auth.create(accessKey, secretKey);
//		//开始上传
//		String upToken = auth.uploadToken(bucket,"hhh");
//		Response qresponse = null;
//		try {
//			//Response response = uploadManager.put(filePath, "hhh", upToken);
//			qresponse = uploadManager.put(filePath,"hhh",upToken);
//			//解析上传成功的结果
//			DefaultPutRet putRet = Utils.readValue(qresponse.bodyString(),DefaultPutRet.class);
//			System.out.println(putRet.key);
////			System.out.println(putRet.hash);
//
//			//result = url+putRet.key;
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//	}
	public String upToken(){
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);

		System.out.println(upToken);
		return  upToken;
	}
}
