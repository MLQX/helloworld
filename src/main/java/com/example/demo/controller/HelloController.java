package com.example.demo.controller;

import cn.hutool.core.util.*;
import com.example.demo.pojo.Friend;
import com.example.demo.pojo.Friend2;
import com.example.demo.pojo.SimpleObj;
import com.example.demo.pojo.Student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String sayHello(){
        return "hell32225o";
    }


    @RequestMapping("/lb")
    @ResponseBody
    public Map<String,Object> lombokTest(){
        Map<String, Object> map = new HashMap<>();

        Friend friend = new Friend();
        friend.setId(33);
        friend.setName("eog");
        map.put("friend", friend);
        return map;


    }


    /**
     * hutool-StrUtil
     * @return
     */
    @RequestMapping("/hutool")
    @ResponseBody
    public Map<String,Object> hutoolTest(){
        Map<String, Object> map = new HashMap<>();



        //CharSequeue方法判断字符串组是null or ""
        String a = "hello";
        String b = "workd";
        String c = null ;
        boolean hasEmpty = StrUtil.hasEmpty(a,b,c);
        log.debug("hasEmpty的值为："+hasEmpty);


        String filename = "abcdef.txt";
        //removeSuffix方法
        String filename2=StrUtil.removeSuffixIgnoreCase(filename,".txt");
        log.debug("filename2 "+filename2);




        //sub方法
        String su = "abcjejgoe";
        String aa = StrUtil.sub(su,0,2);
        log.debug("aa "+aa);
        String bb = "EOJGEO";
        byte[] bytes=bb.getBytes(Charset.defaultCharset());
        log.debug("bytes "+bytes.toString());



        //format方法
        String template = "{}爱{},就像老鼠爱大米";
        String template2=StrUtil.format(template, "你", "我");
        log.debug("template2 "+template2);




        return map;


    }



    /**
     * hutool-HexUtil
     * @return
     */
    @RequestMapping("/hutool2")
    @ResponseBody
    public void hutoolTest2(){

        String af = "geojoe";
        String encodedHexStr = HexUtil.encodeHexStr(af,CharsetUtil.CHARSET_UTF_8);
        log.debug("encodedHexStr "+encodedHexStr);

        String decodedStr = HexUtil.decodeHexStr(encodedHexStr);
        log.debug("decodedStr "+decodedStr);

    }
    /**
     * hutool-ObjectUtil
     * @return
     */
    @RequestMapping("/hutool3")
    @ResponseBody
    public void hutoolTest3(){

        //Student student1 = new Student();
        //Student student2 = new Student();
        //
        //
        //// equal方法
        //boolean isEqual = ObjectUtil.equal(student1, student2);
        //log.debug("isEqual "+isEqual);
        //
        //log.debug("isEqual2 "+student1.equals(student2));  // true
        //
        //
        ////Collection<String> collection =
        //
        //
        //
        //// length方法
        //Map<String, Object> map = new HashMap<>();
        //
        //map.put("a", "a");
        //map.put("b", "b");
        //map.put("c", "c");
        //
        //int size = ObjectUtil.length(map);
        //log.debug("size of the map "+size);
        //
        //
        //// contains方法
        //boolean con = ObjectUtil.contains(map, "a");
        //log.debug("is contains a? "+con);
        //
        //
        //// isNull 和 isNotNull方法
        //boolean isNotNull = ObjectUtil.isNotNull(null);
        //boolean isNotNull2 = ObjectUtil.isNull(null);
        //log.debug("check the value of  isNotNull == true "+isNotNull);
        //log.debug("check the value of  isNull == true "+isNotNull2);
        //
        //
        //
        //// isBaseType方法
        //Integer ioc = 3;
        //boolean isBaseType = ObjectUtil.isBasicType(ioc);
        //log.debug("check the value of  isBaseType == true "+isBaseType);
        //
        ////clone方法 克隆对象，如果对象实现Cloneable接口，调用其clone方法，如果实现Serializable接口，执行深度克隆，否则返回null。  ？？？
        //SimpleObj s = new SimpleObj("我是SimpleObj的name");
        //Friend friend = new Friend(1,"张三",s);
        ////Friend friend1 = ObjectUtil.clone(friend);
        //Friend friend1 = ObjectUtil.cloneByStream(friend);
        //log.debug("check the value name of  friend1 "+friend1.getName());
        //log.debug("check the value name of  friend1.simpleObj "+friend1.getSimpleObj().getName());
        //log.debug("check the address of  friend1.simpleObj "+friend1.getSimpleObj().hashCode());
        //friend.getSimpleObj().setName("更改后simpleObje的name值");
        //log.debug("again check the value name of  friend1.simpleObj "+friend1.getSimpleObj().getName());
        //
        //log.debug("again check the address of  friend1.simpleObj "+friend1.getSimpleObj().hashCode());


        Friend2 ff = new Friend2();
        Friend2 fff = (Friend2) ObjectUtil.cloneByStream(ff);



    }





    /**
     * hutool-ReflectUtil
     * @return
     */
    @RequestMapping("/hutool4")
    @ResponseBody
    public void hutoolTest4(){

        class Obj{
            void run(){
                System.out.println("run ");
            }
        }
        Method[] methods = ReflectUtil.getMethods(Obj.class);



        //Obj o= (Obj)ReflectUtil.newInstance(Obj.class);
        SimpleObj simpleObj= ReflectUtil.newInstance(SimpleObj.class);

        //ReflectUtil.invoke(o, "run");





    }


    /**
     * hutool-TypeUtil
     * @return
     */
    @RequestMapping("/hutool5")
    @ResponseBody
    public void hutoolTest5(){

        class Obj{
            void run(){
                System.out.println("run ");
            }
        }
        Method[] methods = ReflectUtil.getMethods(Obj.class);



        //Obj o= (Obj)ReflectUtil.newInstance(Obj.class);
        SimpleObj simpleObj= ReflectUtil.newInstance(SimpleObj.class);

        //ReflectUtil.invoke(o, "run");





    }
}
