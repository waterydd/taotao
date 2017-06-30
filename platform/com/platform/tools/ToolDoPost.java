package com.platform.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.platform.util.HttpClientUtil;
import com.platform.util.PropertyUtil;

/**
 * 处理用户请求，调用APP接口
 *@author:YDD
 *@date:2017年6月29日
 */
public class ToolDoPost {

	public static String doPost(String url, List<NameValuePair> params) throws Exception {
		
		HttpClient httpClient = HttpClientUtil.getHttpClient();
		
		String urlTotal = PropertyUtil.getReqHttpsUrl() + url; // url 地址
		
		HttpPost httpPost = new HttpPost(urlTotal);
		
		HttpResponse response = null;
		InputStream instream = null;          
		try{
			if (params != null) {
				httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			}
			response = httpClient.execute(httpPost);
			
			HttpEntity entity = response.getEntity();
			if (entity != null) {

				instream = entity.getContent();
				BufferedReader dr = new BufferedReader(new InputStreamReader(instream));
				StringBuilder str = new StringBuilder();
				String temp = "";
				while ((temp = dr.readLine()) != null) {
					str.append(temp);
				}
				/*System.out.println("x" + str);*/
				
				return str.toString();
			} else
				System.out.println("Error");
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			httpPost.releaseConnection();
			instream.close();
			if (response != null)
				EntityUtils.consume(response.getEntity());
			if (httpPost != null)
				httpPost.abort();
	    }
		return urlTotal;
	}
}
