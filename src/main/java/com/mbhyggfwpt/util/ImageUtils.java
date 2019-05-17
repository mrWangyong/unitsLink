package com.mbhyggfwpt.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Project: Frame
 * @Package Name: com.uwonders.alarmcenter.tools
 * @Description:
 * @Author: Yogurt.W
 * @Creation Date: 2018年04月24日17:19
 * @ModifycationHistory: WHO      WHEN    WHY
 * --------------------------------------------------
 **/
public final class ImageUtils {
    private static Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    /**
     * 图片缩放
     * @param org    原图路径
     * @param dest   缩放图路径
     * @param height 高度
     * @param width  宽度
     */
    public static boolean resize(String org, String dest, int height, int width) {
        //是否进行了压缩
        boolean bol = false;
        String pictype="";
        if (!"".equals(org) && org != null) {
            pictype = org.substring(org.lastIndexOf(".")+1,org.length());
        }
        //缩放比例
        double ratio;
        File o = new File(org);
        File d = new File(dest);
        BufferedImage bi;
        try {
            bi = ImageIO.read(o);
            Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
            int itempWidth = bi.getWidth();
            int itempHeight = bi.getHeight();

            //计算比例
            if ((itempHeight > height) || (itempWidth > width)) {
                ratio = Math.min((new Integer(height)).doubleValue() / itempHeight, (new Integer(width)).doubleValue() / itempWidth);
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
                ImageIO.write((BufferedImage) itemp,pictype, d);
                bol = true;
            }
        } catch (IOException e1) {
            logger.error("ImageUtils.resize出错:" + e1.getMessage());
        }
        return bol;
    }

    public static void resizeWidth(String org, String dest, int height, int width) {
        String pictype="";
        if(!"".equals(org)&&org!=null){
            pictype = org.substring(org.lastIndexOf(".")+1,org.length());
        }
        double ratio; //缩放比例
        File o = new File(org);
        File d = new File(dest);
        BufferedImage bi;
        try {
            bi = ImageIO.read(o);
            Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
            int itempWidth = bi.getWidth();

            //计算比例
            if (itempWidth != width) {
                //LogRecord.recode(ImageUtils.class, "【开始图片缩放 width】-----pictype:", pictype);
                ratio = ((new Integer(width)).doubleValue() / itempWidth);
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
                ImageIO.write((BufferedImage) itemp,pictype, d);
            }

        } catch (IOException e1) {
            logger.error("ImageUtils.resizeWidth出错:" + e1.getMessage());
        }
    }

    public static void copyFile(String sourcePath, String targetPath){
        BufferedInputStream inBuff=null;
        BufferedOutputStream outBuff=null;
        try {
            File sourceFile = new File(sourcePath);
            File targetFile = new File(targetPath);
            if (!targetFile.exists()) {
                if (!targetFile.getParentFile().mkdirs()) {
                    logger.error("ImageUtils.copyFile：targetFile创建出错");
                }
            }
            // 新建文件输入流并对它进行缓冲
            inBuff=new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff=new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b=new byte[1024 * 5];
            int len;
            while((len=inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } catch(IOException e){
            logger.error("ImageUtils.copyFile图片复制异常:" + e.getMessage());
        } finally {
            // 关闭流
            try {
                if (inBuff != null) {
                    inBuff.close();
                }
                if (outBuff != null) {
                    outBuff.close();
                }

            } catch (IOException e) {
                logger.error("ImageUtils.copyFile文件流关闭异常:" + e.getMessage());
            }

        }
    }

    /*public static void main(String[] args) throws IOException{

        //resize("D:\\myycxg\\xiazi.jpg","D:\\myycxg\\xiazi2.jpg", 400, 400);;
        String str1 = "D:\\myycxg\\uploadfiles\\realimg\\2018-4-25\\xiazi.jpg";
        //String str2 = str1.substring(str1.lastIndexOf("realimg"),str1.lastIndexOf("."));
        //String str2 = str1.substring(str1.indexOf("uploadfiles")).substring(str1.substring(str1.indexOf("uploadfiles")).indexOf("\\"));
        //System.out.println(str2);
    }*/
}