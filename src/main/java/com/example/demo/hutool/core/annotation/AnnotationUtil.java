package com.example.demo.hutool.core.annotation;


import com.example.demo.hutool.core.util.ArrayUtil;
import com.example.demo.hutool.core.util.ReflectUtil;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.sql.Ref;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 17:17
 */
public class AnnotationUtil {

    public static CombinationAnnotationElement toCombination(AnnotatedElement annotatedElement) {
        if (annotatedElement instanceof CombinationAnnotationElement) {
            return (CombinationAnnotationElement) annotatedElement;
        }

        return new CombinationAnnotationElement(annotatedElement);
    }


    public static Annotation[] getAnnotations(AnnotatedElement annotatedElement, boolean isToCombination) {
        return (null == annotatedElement) ? null : ((isToCombination ? toCombination(annotatedElement) : annotatedElement)).getAnnotations();
    }


    public static <A extends Annotation> A getAnnotation(AnnotatedElement annotatedElement, Class<A> annotationType) {
        return (null == annotatedElement) ? null : toCombination(annotatedElement).getAnnotation(annotationType);
    }


    public static <T> T getAnnotationValue(AnnotatedElement annotatedElement, Class<? extends Annotation> annotationType) {

        return getAnnotationValue(annotatedElement, annotationType, "value");

    }

    //todo
    public static <T> T getAnnotationValue(AnnotatedElement annotatedElement, Class<? extends Annotation> annotationType, String propertyName) {
        final Annotation annotation = getAnnotation(annotatedElement, annotationType);
        if (null == annotation) {
            return null;
        }

        final Method method = ReflectUtil.getMethodOfObj(annotation, propertyName);

        if (method == null) {
            return null;
        }
        return ReflectUtil.invoke(annotation, method);

    }


    public static Map<String, Object> getAnnotationValueMap(AnnotatedElement annotatedElement,Class<? extends Annotation> annotationType){
        final Annotation annotation = getAnnotation(annotatedElement,annotationType);
        if (annotation == null) {
            return null;
        }
        final Method[] methods = ReflectUtil.getMethods(annotationType, t -> {
            if (ArrayUtil.isEmpty(t.getParameterTypes())) {
                final String name = t.getName();
                return (false == "hashCode".equals(name) && false == "toString".equals(name) && false == "annotationType".equals(name));
            }
            return false;
        });

        final Map<String, Object> result = new HashMap<>(methods.length, 1);
        for (Method method : methods) {
            result.put(method.getName(),ReflectUtil.invoke(annotation,method));
        }
        return result;


    }

    public static RetentionPolicy getRetentionPolicy(Class<? extends Annotation> annotationType) {
        final Retention retention = annotationType.getAnnotation(Retention.class);
        if (null == retention) {
            return RetentionPolicy.CLASS;
        }
        return retention.value();
    }


    public static ElementType[] getTargetType(Class<? extends Annotation> annotationType) {
        final Target target = annotationType.getAnnotation(Target.class);
        if (null == target) {
            return new ElementType[]{ElementType.TYPE, //
                    ElementType.FIELD, //
                    ElementType.METHOD, //
                    ElementType.PARAMETER, //
                    ElementType.CONSTRUCTOR, //
                    ElementType.LOCAL_VARIABLE, //
                    ElementType.ANNOTATION_TYPE, //
                    ElementType.PACKAGE//
            };
        }
        return target.value();
    }


    public static boolean isDocumented(Class<? extends Annotation> annotationType) {
        return annotationType.isAnnotationPresent(Documented.class);
    }

    /**
     * 是否可以被继承，默认为 false
     *
     * @param annotationType 注解类
     * @return 是否会保存到 Javadoc 文档中
     */
    public static boolean isInherited(Class<? extends Annotation> annotationType) {
        return annotationType.isAnnotationPresent(Inherited.class);
    }


}
