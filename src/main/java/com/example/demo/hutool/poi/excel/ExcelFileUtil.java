package com.example.demo.hutool.poi.excel;


import com.example.demo.hutool.core.io.IORuntimeException;
import com.example.demo.hutool.core.io.IoUtil;
import org.apache.poi.poifs.filesystem.FileMagic;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 16:14
 */
public class ExcelFileUtil {

    /**
     * excel97-2003(xls)
     * @param inputStream
     * @return
     */
    public static boolean isXls(InputStream inputStream){

        //TODO  IoUtil
        final PushbackInputStream pushbackInputStream = IoUtil.toPushbackStream(inputStream, 8);
        try {
            //根据回退流判断文件类型，如果不是想要的类型则抛出异常
            return FileMagic.valueOf(pushbackInputStream) == FileMagic.OLE2;
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }





    }


    /**
     *  2007+ 版本 （xlsx）
     * @param inputStream
     * @return
     */
    public static boolean isXlsx(InputStream inputStream){

        //TODO  IoUtil
        final PushbackInputStream pushbackInputStream = IoUtil.toPushbackStream(inputStream, 8);
        try {
            //根据回退流判断文件类型，如果不是想要的类型则抛出异常
            return FileMagic.valueOf(pushbackInputStream) == FileMagic.OOXML;
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }





    }



}
