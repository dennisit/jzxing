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
package com.plugin.qrcode.arithmetic;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.plugin.qrcode.constant.DefaultConstant;
import com.plugin.qrcode.iostream.ImageIOUtil;
import com.plugin.qrcode.support.MultiFormatFactory;
import com.plugin.qrcode.type.QrColor;
import com.plugin.qrcode.type.QrImage;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * @author dennisit@163.com
 * @version 1.0
 */
public class JQRArithmetic {


    /**
     * width of qrcode
     */
    private int qrWidth = DefaultConstant.WIDTH;

    /**
     * height of qrcode
     */
    private int qrHeight = DefaultConstant.HEIGHT;

    /**
     * font color of qrcode
     */
    private QrColor frontColor = DefaultConstant.FRONT_COLOR;

    /**
     * back color of qrcode
     */
    private QrColor backColor = DefaultConstant.BACK_COLOR;

    /**
     * content charset of qrcode
     */
    private String contentCharset = DefaultConstant.CONTENT_CHARSET;


    public JQRArithmetic() {
        this(DefaultConstant.WIDTH, DefaultConstant.HEIGHT);
    }


    public JQRArithmetic(int qrWidth, int qrHeight) {
        this(qrWidth, qrHeight, DefaultConstant.FRONT_COLOR, DefaultConstant.BACK_COLOR);
        this.qrWidth = qrWidth;
        this.qrHeight = qrHeight;
    }

    public JQRArithmetic(int qrWidth, int qrHeight, QrColor frontColor, QrColor backColor) {
        this(qrWidth, qrHeight, frontColor,backColor, DefaultConstant.CONTENT_CHARSET);
        this.qrWidth = qrWidth;
        this.qrHeight = qrHeight;
        this.frontColor = frontColor;
        this.backColor = backColor;
    }

    public JQRArithmetic(int qrWidth, int qrHeight, QrColor frontColor, QrColor backColor, String contentCharset) {
        this.qrWidth = qrWidth;
        this.qrHeight = qrHeight;
        this.frontColor = frontColor;
        this.backColor = backColor;
        this.contentCharset = contentCharset;
    }

    /**
     * for qrCode to local file with default iamge type "png";
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public void qrCodeToFile(String content,String filePath,String fileName) throws Exception{
        qrCodeToFile(content, filePath, fileName, DefaultConstant.IMAGE_TYPE);
    }

    /**
     * for qrCode to local file with specially appointed imageType
     * @param filePath
     * @param fileName
     * @param imageType
     * @throws Exception
     */
    public void qrCodeToFile(String content,String filePath,String fileName,QrImage imageType) throws Exception{
        BufferedImage bufferedImage = qrCodeToStream(content);
        File qrImageFile = new File(filePath,fileName + "." + imageType.getType());
        ImageIOUtil.writeToFile(bufferedImage,imageType.getType(),qrImageFile);
    }

    /**
     * api support logo to HttpServletResponse
     * @throws Exception
     */
    public void qrCodeToResponse(String content,HttpServletResponse response) throws Exception{
        qrCodeToResponse(content, DefaultConstant.IMAGE_TYPE ,response);
    }

    /**
     * api support logo to HttpServletResponse
     * @param imageType
     * @throws Exception
     */
    public void qrCodeToResponse(String content,QrImage imageType,HttpServletResponse response) throws Exception{
        BufferedImage bufferedImage = qrCodeToStream(content);
        ImageIOUtil.writeToStream(bufferedImage,imageType.getType(),response.getOutputStream());
    }

    /**
     * core api for BufferedImage with simple content make
     * @param content
     * @return
     * @throws Exception
     */
    public BufferedImage qrCodeToStream(String content) throws Exception{
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, this.contentCharset);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        BitMatrix bitMatrix = MultiFormatFactory.getInstance().encode(content, BarcodeFormat.QR_CODE, qrWidth, qrHeight, hints);
        return ImageIOUtil.toBufferedImage(bitMatrix, frontColor, backColor);
    }

    /**
     * api support logo qrCode to file
     * @param content
     * @param filePath
     * @param fileName
     * @param jqrLogo
     * @throws Exception
     */
    public void qrLogoCodeToFile(String content,String filePath, String fileName,QrImage imageType, JQRLogo jqrLogo) throws Exception{
        BufferedImage image = qrLogoCodeToStream(content,jqrLogo);
        File targetQrFile = new File(filePath,fileName + "." + imageType.getType());
        ImageIOUtil.writeToFile(image,imageType.getType(),targetQrFile);
    }

    /**
     * api support logo qrCode to HttpServletResponse
     * @param content
     * @param jqrLogo
     * @param response
     * @throws Exception
     */

    public void qrLogoCodeToResponse(String content,QrImage imageType,JQRLogo jqrLogo ,HttpServletResponse response) throws Exception{
        BufferedImage bufferedImage = qrLogoCodeToStream(content,jqrLogo);
        ImageIOUtil.writeToStream(bufferedImage,imageType.getType(),response.getOutputStream());
    }

    /**
     * core api for BufferedImage with jqrLogo make
     * @param content
     * @param jqrLogo
     * @return
     * @throws Exception
     */
    public BufferedImage qrLogoCodeToStream(String content,JQRLogo jqrLogo) throws Exception{
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, this.contentCharset);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 生成二维码
        BitMatrix matrix = MultiFormatFactory.getInstance().encode(content, BarcodeFormat.QR_CODE, this.qrWidth, this.qrHeight, hints);
        return ImageIOUtil.toBufferedImage(matrix,this.frontColor,this.backColor,jqrLogo.getImagePath(),jqrLogo.getTargetWidth(),jqrLogo.getTargetHeight(),jqrLogo.getBorderWidth());
    }

    public int getQrWidth() {
        return qrWidth;
    }

    public void setQrWidth(int qrWidth) {
        this.qrWidth = qrWidth;
    }

    public int getQrHeight() {
        return qrHeight;
    }

    public void setQrHeight(int qrHeight) {
        this.qrHeight = qrHeight;
    }

    public QrColor getFrontColor() {
        return frontColor;
    }

    public void setFrontColor(QrColor frontColor) {
        this.frontColor = frontColor;
    }

    public QrColor getBackColor() {
        return backColor;
    }

    public void setBackColor(QrColor backColor) {
        this.backColor = backColor;
    }

    public String getContentCharset() {
        return contentCharset;
    }

    public void setContentCharset(String contentCharset) {
        this.contentCharset = contentCharset;
    }


}
