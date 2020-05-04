package com.example.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo.interceptor.OneInterceptor;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/5/4 21:18
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/*/**"); //全部被OneIntercetor拦截
    }

    /**
     * 自定义静态资源目录
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/st/**").addResourceLocations("classpath:/static/pages/"); // for .html  放在这个目录下可以不通过模板引擎访问
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");  // for .js

    }

    /**
     *  自定义视图控制器  页面跳转  路由->视图名绑定
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/toLogin").setViewName("login");

    }

    //TODO 看看咋用
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(new HandlerMethodReturnValueHandler() {
            @Override
            public boolean supportsReturnType(MethodParameter methodParameter) {

                return false;
            }

            @Override
            public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {

            }
        });
    }

    /**
     * 自定义静态资源处理器
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {


        configurer.enable("defaultServletName");
    }



    //@Bean
    //public InternalResourceViewResolver resourceViewResolver(){
    //    //InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
    //    //internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
    //    //internalResourceViewResolver.setPrefix(".jsp");
    //    //return internalResourceViewResolver;
    //    return null;
    //}
    /**
     * 自定义视图解析器
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry.viewResolver(resourceViewResolver());
    }

    /**
     * 自定义跨域参数
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("POST", "GET")
                .allowedOrigins("*");
    }


    /**
     * 自定义消息转换器 fastJson  确实有用  但是有中文乱码和content-type=text/html问题
     *
     *
     * 中文乱码通过配置 CrosFilter 指定返回的编码 utf-8解决
     * 但是同样指定的返回类型却没有生效， 于是在返回json的controller的@RequestMapping加上一个produces="application/json;charset=UTF-8"解决
     *
     *
     * 本来默认是jackson， 现在扩展了消息转换器,可能出现问题，使用下面 的方式：重写
     */
    //@Override
    //public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    //    FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
    //    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    //    fastJsonConfig.setCharset(Charset.defaultCharset());
    //
    //    //升级最新版本需加=============================================================
    //    List<MediaType> supportedMediaTypes = new ArrayList<>();
    //    supportedMediaTypes.add(MediaType.APPLICATION_JSON);
    //    supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    //    supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
    //    supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
    //    supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
    //    supportedMediaTypes.add(MediaType.APPLICATION_PDF);
    //    supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
    //    supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
    //    supportedMediaTypes.add(MediaType.APPLICATION_XML);
    //    supportedMediaTypes.add(MediaType.IMAGE_GIF);
    //    supportedMediaTypes.add(MediaType.IMAGE_JPEG);
    //    supportedMediaTypes.add(MediaType.IMAGE_PNG);
    //    supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
    //    supportedMediaTypes.add(MediaType.TEXT_HTML);
    //    supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
    //    supportedMediaTypes.add(MediaType.TEXT_PLAIN);
    //    supportedMediaTypes.add(MediaType.TEXT_XML);
    //    fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
    //
    //
    //    fastJsonConfig.setSerializerFeatures(
    //            SerializerFeature.PrettyFormat, //解决中文乱码
    //            SerializerFeature.DisableCircularReferenceDetect,  //消除对同一对象循环引用的问题,默认为false
    //            SerializerFeature.WriteMapNullValue, // 是否输出值为null的字段,默认为false
    //            SerializerFeature.WriteNullStringAsEmpty); //字符类型字段如果为null,输出为"",而非null
    //    fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
    //    converters.add(fastJsonHttpMessageConverter);
    //}

    /**
     * 注入消息转换器替换原来的
     * @return
     */
    @Bean
    public HttpMessageConverters httpMessageConverters(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();    //添加fastJson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);    //处理中文乱码问题
        fastJsonConfig.setSerializerFeatures(
                            SerializerFeature.PrettyFormat, //解决中文乱码
                            SerializerFeature.DisableCircularReferenceDetect,  //消除对同一对象循环引用的问题,默认为false
                            SerializerFeature.WriteMapNullValue, // 是否输出值为null的字段,默认为false
                            SerializerFeature.WriteNullStringAsEmpty); //字符类型字段如果为null,输出为"",而非null
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);    //在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }

}
