//--------------------------------------------------------------------------
//	Copyright (c) 2010-2020, En.dennisit or Cn.苏若年
//  All rights reserved.
//
//	Redistribution and use in source and binary forms, with or without
//  modification, are permitted provided that the following conditions are
//  met:
//
//	Redistributions of source code must retain the above copyright notice,
//  this list of conditions and the following disclaimer.
//	Redistributions in binary form must reproduce the above copyright
//  notice, this list of conditions and the following disclaimer in the
//  documentation and/or other materials provided with the distribution.
//	Neither the name of the dennisit nor the names of its contributors
//  may be used to endorse or promote products derived from this software
//  without specific prior written permission.
//  Author: dennisit@163.com | dobby | 苏若年
//--------------------------------------------------------------------------
package com.plugin.qrcode.iostream;

import com.google.zxing.common.BitMatrix;
import com.plugin.qrcode.constant.DefaultConstant;
import com.plugin.qrcode.type.QrColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Description:
 * @author dennisit@163.com
 * @version 1.0
 */
public class ImageIOUtil {

    /**
     * core api support fro qrCode to file
     * @param format
     * @param file
     * @throws java.io.IOException
     */
    public static void writeToFile(BufferedImage bufferedImage, String format, File file) throws IOException {
        if (!ImageIO.write(bufferedImage, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }


    /**
     * core api support for qrCode to stream
     * @param format
     * @param stream
     * @throws java.io.IOException
     */
    public static void writeToStream(BufferedImage bufferedImage, String format, OutputStream stream) throws IOException {
        if (!ImageIO.write(bufferedImage, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }


    /**
     * api support for basic qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,QrColor frontColor, QrColor backColor) {
        return toBufferedImage(matrix, frontColor.getColor(), backColor.getColor());
    }

    /**
     * core api support for basic qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,int frontColor, int backColor) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? frontColor : backColor);
            }
        }
        return image;
    }

    /**
     * api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,QrColor frontColor, QrColor backColor,
                                                String logoImagePath) throws IOException{
        return toBufferedImage(matrix,frontColor.getColor(),backColor.getColor(),logoImagePath, DefaultConstant.LOGO_WIDTH, DefaultConstant.LOGO_HEIGHT);
    }

    /**
     * api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,QrColor frontColor, QrColor backColor,
                                                String logoImagePath, Integer targetLogoWidth,Integer targetLogoHeight) throws IOException{
        return toBufferedImage(matrix,frontColor.getColor(),backColor.getColor(),logoImagePath,targetLogoWidth,targetLogoHeight, DefaultConstant.LOGO_BORDER_WITH);
    }

    /**
     * api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,QrColor frontColor, QrColor backColor,
                                                String logoImagePath, Integer targetLogoWidth,Integer targetLogoHeight,Integer logoBorderWidth) throws IOException{
        return toBufferedImage(matrix,frontColor.getColor(),backColor.getColor(),logoImagePath,targetLogoWidth,targetLogoHeight,logoBorderWidth,true);
    }

    /**
     * api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,QrColor frontColor, QrColor backColor,
                                                String logoImagePath, Integer targetLogoWidth,Integer targetLogoHeight,Integer logoBorderWidth,Boolean isWhiteFulling) throws IOException{
        return toBufferedImage(matrix,frontColor.getColor(),backColor.getColor(),logoImagePath,targetLogoWidth,targetLogoHeight,logoBorderWidth,isWhiteFulling);
    }

    /**
     * api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,int frontColor, int backColor,
                                                String logoImagePath) throws IOException{
        return toBufferedImage(matrix,frontColor,backColor,logoImagePath, DefaultConstant.LOGO_WIDTH, DefaultConstant.LOGO_HEIGHT);
    }

    /**
     * api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,int frontColor, int backColor,
                                                String logoImagePath, Integer targetLogoWidth,Integer targetLogoHeight) throws IOException{
        return toBufferedImage(matrix,frontColor,backColor,logoImagePath,targetLogoWidth,targetLogoHeight, DefaultConstant.LOGO_BORDER_WITH);
    }

    /**
     * api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,int frontColor, int backColor,
                                                String logoImagePath, Integer targetLogoWidth,Integer targetLogoHeight,Integer logoBorderWidth) throws IOException{
        return toBufferedImage(matrix,frontColor,backColor,logoImagePath,targetLogoWidth,targetLogoHeight, logoBorderWidth, true);
    }

    /**
     * core api support for inner logo qrCode
     * @param matrix
     * @param frontColor
     * @param backColor
     * @param logoImagePath
     * @return
     * @throws java.io.IOException
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix,int frontColor, int backColor,
                                                String logoImagePath, Integer targetLogoWidth,Integer targetLogoHeight,Integer logoBorderWidth,Boolean isWhiteFulling) throws IOException{
        int matrixWidth = matrix.getWidth();
        int matrixHeight = matrix.getHeight();
        Integer logoHalfWidth = targetLogoWidth/2;
        // 读取源图像
        BufferedImage scaleImage = ImageIOUtil.scale(logoImagePath, targetLogoWidth, targetLogoHeight, isWhiteFulling);
        int[][] srcPixels = new int[targetLogoWidth][targetLogoHeight];
        for (int i = 0; i < scaleImage.getWidth(); i++) {
            for (int j = 0; j < scaleImage.getHeight(); j++) {
                srcPixels[i][j] = scaleImage.getRGB(i, j);
            }
        }
        // 二维矩阵转为一维像素数组
        int halfW = matrix.getWidth() / 2;
        int halfH = matrix.getHeight() / 2;
        int[] pixels = new int[matrixWidth * matrixHeight];

        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                // 读取图片
                if ( x > halfW - logoHalfWidth && x < halfW + logoHalfWidth && y > halfH - logoHalfWidth && y < halfH + logoHalfWidth ) {
                    pixels[y * matrixWidth + x] = srcPixels[x - halfW
                            + logoHalfWidth][y - halfH + logoHalfWidth];
                }else if ( (x > halfW - logoHalfWidth - logoBorderWidth
                        && x < halfW - logoHalfWidth + logoBorderWidth
                        && y > halfH - logoHalfWidth - logoBorderWidth && y < halfH
                        + logoHalfWidth + logoBorderWidth)
                        || (x > halfW + logoHalfWidth - logoBorderWidth
                        && x < halfW + logoHalfWidth + logoBorderWidth
                        && y > halfH - logoHalfWidth - logoBorderWidth && y < halfH
                        + logoHalfWidth + logoBorderWidth)
                        || (x > halfW - logoHalfWidth - logoBorderWidth
                        && x < halfW + logoHalfWidth + logoBorderWidth
                        && y > halfH - logoHalfWidth - logoBorderWidth && y < halfH
                        - logoHalfWidth + logoBorderWidth)
                        || (x > halfW - logoHalfWidth - logoBorderWidth
                        && x < halfW + logoHalfWidth + logoBorderWidth
                        && y > halfH + logoHalfWidth - logoBorderWidth && y < halfH
                        + logoHalfWidth + logoBorderWidth) ) {
                    // 在图片四周形成边框
                    pixels[y * matrixWidth + x] = backColor;
                } else {
                    // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；
                    pixels[y * matrixWidth + x] = matrix.get(x, y) ? frontColor : backColor;
                }
            }
        }
        BufferedImage image = new BufferedImage(matrixWidth, matrixHeight, BufferedImage.TYPE_INT_RGB);
        image.getRaster().setDataElements(0, 0, matrixWidth, matrixHeight, pixels);
        return image;
    }




    /**
     * scale image
     * @param srcImageFile original image file path
     * @param height target height
     * @param width target width
     * @param hasFiller 比例不对时是否需要补白：true为补白; false为不补白; 补白性能弱
     * @return target BufferedImage
     * @throws java.io.IOException
     */
    public static BufferedImage scale(String srcImageFile, int height, int width, boolean hasFiller) throws IOException {
        double ratio = 0.0; // 缩放比例
        File file = new File(srcImageFile);
        BufferedImage srcImage = ImageIO.read(file);
        Image destImage = srcImage.getScaledInstance(width, height,BufferedImage.SCALE_SMOOTH);
        // 计算比例
        if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
            if (srcImage.getHeight() > srcImage.getWidth()) {
                ratio = (new Integer(height)).doubleValue()
                        / srcImage.getHeight();
            } else {
                ratio = (new Integer(width)).doubleValue()
                        / srcImage.getWidth();
            }
            AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
            destImage = op.filter(srcImage, null);
        }
        if (hasFiller) {// 补白
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphic = image.createGraphics();
            graphic.setColor(Color.white);
            graphic.fillRect(0, 0, width, height);
            if (width == destImage.getWidth(null))
                graphic.drawImage(destImage, 0, (height - destImage.getHeight(null)) / 2, destImage.getWidth(null),
                        destImage.getHeight(null), Color.white, null);
            else
                graphic.drawImage(destImage,
                        (width - destImage.getWidth(null)) / 2, 0, destImage.getWidth(null), destImage.getHeight(null),
                        Color.white, null);
            graphic.dispose();
            destImage = image;
        }
        return (BufferedImage) destImage;
    }

}
