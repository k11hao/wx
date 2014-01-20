package cn.oyjg.base.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Image {
    public static void main(String[] args) {
        // 测试从Base64编码转换为图片文件
        String strImg ="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";
        GenerateImage(strImg, "D:\\oyjg.jpg");
        
        // 测试从图片文件转换为Base64编码
        //System.out.print(GetImageStr("d:\\oyjg.jpg"));
    }
    public static String GetImageStr(byte[] filebyte) {// 将将字节文件直接转换为base64编码，并对其进行Base64编码处理     
    	
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(filebyte);// 返回Base64编码过的字节数组字符串
    }
    
    public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }

    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        }
    }
    public static byte[] GenerateImagebyte(String imgStr) {// 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            return bytes;
//            // 生成jpeg图片
//            OutputStream out = new FileOutputStream(imgFilePath);
//            out.write(bytes);
//            out.flush();
//            out.close();
//            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
}