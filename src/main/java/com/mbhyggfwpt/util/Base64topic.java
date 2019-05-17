package com.mbhyggfwpt.util;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Base64topic {

	public Map<String, Object> encodeBase64(String base64, String imgdirPath, String imgType) {
		
		Map<String, Object> map = new HashMap<>();
		String fileDir = dateFile();
		String fileName = UUID.randomUUID().toString().replace("-", "");

		BASE64Decoder decoder = new BASE64Decoder();
		Path sjPath = Paths.get(imgdirPath +"/"+fileDir+ "/" + fileName + imgType);
		map.put("sjPath",sjPath);
		map.put("filePath", fileDir + "/" + fileName  + imgType);

		map.put("fileName", fileName);
		// 解密
		byte[] b;
		try {
			File filedir = new File(imgdirPath + "/" + fileDir);
			if (!filedir.exists() && !filedir.isDirectory()) {
				filedir.mkdir();
			}

			File file = new File(sjPath.toString());
			if (!file.exists()) {
                file.createNewFile();
            }
			b = decoder.decodeBuffer(base64);
			// 处理数据
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}

			OutputStream out = new FileOutputStream(sjPath.toString());

			out.write(b);
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public String dateFile() {
		Calendar now = Calendar.getInstance();

		return Integer.toString(now.get(Calendar.YEAR)) + "-" +
                Integer.toString(now.get(Calendar.MONTH) + 1) + "-" + Integer.toString(now.get(Calendar.DAY_OF_MONTH ));
	}
}
