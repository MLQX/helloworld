package com.example.demo.hutool.poi;

import com.example.demo.hutool.core.exceptions.DependencyException;
import com.example.demo.hutool.core.util.ClassLoaderUtil;

/**
 * poi引入检查
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 16:42
 */
public class PoiChecker {

    public static final String NO_POI_ERROR_MSG = "You need to add dependency of 'poi-ooxml' to your project, and version >= 4.1.2";


    public static void checkPoiImport(){

        try {
            Class.forName("org.apache.poi.ss.usermodel.Workbook", false, ClassLoaderUtil.getClassLoader());
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            throw new DependencyException(e, NO_POI_ERROR_MSG);
        }

    }





}
