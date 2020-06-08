package com.gmail.rwawrzkowicz.classloaders;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassExample {

    public static void main(String[] args) {
        Class<? extends Class> stringClass = String.class.getClass();
        List<Member> declaredMembers = getDeclaredMembers(stringClass);
        List<Member> members = getMembers(stringClass);
        List<Annotation> declaredAnnotations = Arrays.asList(stringClass.getDeclaredAnnotations());
        System.out.println(declaredMembers);
        System.out.println(members);
        System.out.println(declaredAnnotations);
    }

    private static List<Member> getMembers(Class<?> aClass) {
        List<Member> declaredFields = Arrays.asList(aClass.getFields());
        List<Member> declaredMethods = Arrays.asList(aClass.getMethods());
        List<Member> declaredConstructors = Arrays.asList(aClass.getConstructors());

        return Stream.of(
                declaredFields, declaredMethods, declaredConstructors)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Member> getDeclaredMembers(Class<?> aClass) {
        List<Member> declaredFields = Arrays.asList(aClass.getDeclaredFields());
        List<Member> declaredMethods = Arrays.asList(aClass.getDeclaredMethods());
        List<Member> declaredConstructors = Arrays.asList(aClass.getDeclaredConstructors());

        return Stream.of(
                declaredFields, declaredMethods, declaredConstructors)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
