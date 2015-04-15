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
package com.plugin.qrcode;

import com.plugin.qrcode.arithmetic.JQRArithmetic;
import com.plugin.qrcode.constant.DefaultConstant;
import com.plugin.qrcode.type.QrColor;
import org.springframework.beans.factory.FactoryBean;

import java.io.Serializable;

/**
 * Description:
 * @author dennisit@163.com
 * @version 1.0
 */
public class JQRcodeFactoryBean implements FactoryBean, Serializable {

    /**
     * width of qrcode
     */
    private int qrWidth;

    /**
     * height of qrcode
     */
    private int qrHeight;

    /**
     * font color of qrcode
     */
    private QrColor frontColor;

    /**
     * back color of qrcode
     */
    private QrColor backColor;

    /**
     * content charset of qrcode
     */
    private String contentCharset;

    @Override
    public Object getObject() throws Exception {
        if( 0 == qrWidth ){
            qrWidth = DefaultConstant.WIDTH ;
        }
        if( 0 == qrHeight ){
            qrHeight = DefaultConstant.HEIGHT ;
        }
        if( null == frontColor ){
            frontColor = DefaultConstant.FRONT_COLOR ;
        }
        if( null == backColor ){
            backColor = DefaultConstant.BACK_COLOR ;
        }
        if( null == contentCharset ){
            contentCharset = DefaultConstant.CONTENT_CHARSET;
        }
        return new JQRArithmetic(qrWidth,qrHeight,frontColor,backColor,contentCharset);
    }

    @Override
    public Class<?> getObjectType() {
        return JQRArithmetic.class;
    }

    @Override
    public boolean isSingleton() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
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
