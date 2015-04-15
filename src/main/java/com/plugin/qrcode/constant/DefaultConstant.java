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
package com.plugin.qrcode.constant;

import com.plugin.qrcode.type.QrColor;
import com.plugin.qrcode.type.QrImage;

/**
 * Description:
 * @author dennisit@163.com
 * @version 1.0
 */
public interface DefaultConstant {

    public String CONTENT_CHARSET = "UTF-8";

    public Integer WIDTH = 200;

    public Integer HEIGHT = 200;

    public QrColor FRONT_COLOR = QrColor.BLACK;

    public QrColor BACK_COLOR = QrColor.WHITE;

    public QrImage IMAGE_TYPE = QrImage.PNG;

    public Integer LOGO_WIDTH = 30;

    public Integer LOGO_HEIGHT = 30;

    public Integer LOGO_BORDER_WITH = 5;

}
