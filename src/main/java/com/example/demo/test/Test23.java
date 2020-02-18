package com.example.demo.test;


import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 *  图片工具类 ImgUtil
 */
@Slf4j
public class Test23{


    public static void main(String[] args) throws IOException {

        //图片缩放
        //ImgUtil.scale(FileUtil.file("~/Pictures/dd.png"), FileUtil.file("~/Pictures/dd2.png"), 0.1f);


        //图片裁剪
        //ImgUtil.cut(
        //        FileUtil.file("~/Pictures/dd.png"),
        //        FileUtil.file("~/Pictures/dd3.png"),
        //        new Rectangle(200, 200, 100, 100)//裁剪的矩形区域
        //);


        //文件转化格式
        //ImgUtil.convert(FileUtil.file("~/Pictures/dd.png"), FileUtil.file("~/Pictures/dd.jpg"));

        //变黑白
        //ImgUtil.gray(FileUtil.file("~/Pictures/dd.png"), FileUtil.file("~/Pictures/ddGray.png"));


        //水印
        //ImgUtil.pressText(
        //        FileUtil.file("~/Pictures/dd.png"), //
        //        FileUtil.file("~/Pictures/dd.pngShuiyin.png"), //
        //        "你红太狼的初吻是我喜羊羊哒~", Color.WHITE, //文字
        //        new Font("黑体", Font.PLAIN, 44), //字体
        //        0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
        //        0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
        //        0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
        //);

        //添加图片水印 (测试失败_)
        //ImgUtil.pressImage(
        //        FileUtil.file("~/Pictures/dd.jpg"),
        //        FileUtil.file("~/Pictures/ddShuiyin.jpg"),
        //        ImgUtil.read(FileUtil.file("/home/ruoan/Pictures/ds.ico")), //水印图片
        //        0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
        //        0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
        //        0.1f
        //);



        //旋转
        // 旋转180度
        //BufferedImage image = ImgUtil.rotate(ImageIO.read(FileUtil.file("e:/pic/366466.jpg")), 180);
        //ImgUtil.write(image, FileUtil.file("e:/pic/result.png"));

        //水平翻转
        //ImgUtil.flip(FileUtil.file("d:/logo.png"), FileUtil.file("d:/result.png"));





    }


}



