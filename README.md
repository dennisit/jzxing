# jzxing
依赖POM
<!--二维码-->
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>core</artifactId>
    <version>3.2.0</version>
</dependency>

说明: 最新3.x版本依赖jdk1.7及以上, jdk1.6版本 使用2.x版本
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>core</artifactId>
    <version>2.2</version>
</dependency>


[ 接入springBean的用法 ]
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	   http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util-3.2.xsd">

    <description>二维码</description>

    <util:constant id="red" static-field="com.plugin.qrcode.type.QrColor.RED" />
    <util:constant id="black" static-field="com.plugin.qrcode.type.QrColor.BLACK" />
    <util:constant id="white" static-field="com.plugin.qrcode.type.QrColor.WHITE" />

    <bean id="jqrArithmetic" class="com.plugin.qrcode.JQRcodeFactoryBean">
        <property name="qrWidth" value="200" />
        <property name="qrHeight" value="200" />
        <property name="contentCharset" value="UTF-8" />
        <property name="frontColor" ref="black" />
        <property name="backColor" ref="white" />
    </bean>

</beans>

