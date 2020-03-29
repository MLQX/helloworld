//package com.example.demo.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.example.demo.pojo.Person;
//import com.example.demo.service.PersonService;
//import com.example.demo.utils.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/es")
//public class EsController {
//
//
//    @Autowired
//    PersonService personService;
//
//
//    /**
//     * 向es添加数据
//     */
//    @RequestMapping("/insert")
//    public Object insert(@RequestBody Person person){
//        JSONObject object=null;
//        try {
//            Person savePerson=  personService.save(person);
//            object= (JSONObject) JSON.toJSON(savePerson);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return object;
//    }
//
//
//    /**
//     * 从es删除数据
//     * @param person
//     * @return
//     */
//    @RequestMapping("/delete")
//    public Object delete(@RequestBody Person person){
//
//        try {
//            personService.delete(person);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.failed404();
//        }
//        return Response.successMsg();
//
//    }
//
//
//    /**
//     * 查询操作
//     * @param pageNo
//     * @param pageSize
//     * @param key
//     * @return
//     */
//    @RequestMapping("/query")
//    public Object query(@RequestParam(value = "pageNo",required = false)Integer pageNo, @RequestParam(value = "pageSize",required = false)Integer pageSize,
//                        @RequestParam(value = "key",required = false)String key){
//
//        Response response=new Response();
//        try {
//            Page<Person> personPage= personService.pageQuery(pageNo,pageSize,key);
//            response.setData(personPage);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.failed404();
//        }
//        return response;
//
//    }
//}
//
