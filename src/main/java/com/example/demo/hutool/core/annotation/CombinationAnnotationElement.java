package com.example.demo.hutool.core.annotation;

import com.example.demo.hutool.core.collection.CollUtil;
import org.junit.Test;

import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.util.*;

/**
 * @author ruoan
 * @version 1.0
 * @date 2020/4/8 17:21
 */
public class CombinationAnnotationElement implements AnnotatedElement, Serializable {


    private static final long serialVersionUID = 9068821319091875943L;

    private static final Set<Class<? extends Annotation>> META_ANNOTATIONS = CollUtil.newHashSet(Target.class, Retention.class,
            Documented.class,SuppressWarnings.class,Override.class,Deprecated.class, Inherited.class);


    private Map<Class<? extends Annotation>,Annotation> annotationMap;
    private Map<Class<? extends Annotation>,Annotation> declaredAnnotationMap;


    public CombinationAnnotationElement(AnnotatedElement element) {
        init(element);
    }

    private void init(AnnotatedElement element) {

        final Annotation[] declaredAnnotations = element.getDeclaredAnnotations();
        this.declaredAnnotationMap = new HashMap<>();
        parseDeclared(declaredAnnotations);


        final Annotation[] annotations = element.getAnnotations();
        if (Arrays.equals(declaredAnnotations, annotations)) {
            this.annotationMap = this.declaredAnnotationMap;
        } else {
            this.annotationMap = new HashMap<>();
            parse(annotations);
        }

    }

    private void parseDeclared(Annotation[] declaredAnnotations) {
        Class<? extends Annotation> annotationType;
        for (Annotation annotation : declaredAnnotations) {
            annotationType=annotation.annotationType();
            if (false == META_ANNOTATIONS.contains(annotationType)) {
                declaredAnnotationMap.put(annotationType, annotation);
                parseDeclared(annotationType.getDeclaredAnnotations());
            }
        }
    }

    private void parse(Annotation[] annotations) {
        Class<? extends Annotation> annotationType;
        for (Annotation annotation : annotations) {
            annotationType=annotation.annotationType();
            if (false == META_ANNOTATIONS.contains(annotationType)) {
                annotationMap.put(annotationType, annotation);
                parseDeclared(annotationType.getAnnotations());
            }
        }
    }


    @Override
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        Annotation annotation = annotationMap.get(annotationClass);
        return (annotation == null) ? null:(T) annotation;
    }

    @Override
    public Annotation[] getAnnotations() {
        final Collection<Annotation> annotations = this.annotationMap.values();
        return annotations.toArray(new Annotation[0]);
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        final Collection<Annotation> annotations = this.declaredAnnotationMap.values();
        return annotations.toArray(new Annotation[0]);
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return annotationMap.containsKey(annotationClass);
    }




}
