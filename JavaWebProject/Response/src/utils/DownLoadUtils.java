package utils;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import sun.misc.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            Encoder encoder = Base64.getEncoder();
            String result = encoder.encodeToString(filename.getBytes("utf-8"))+ "?=";

//            BASE64Encoder base64Encoder = new BASE64Encoder();
//            filename = "=?utf-8?B?" +base64Encoder(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
