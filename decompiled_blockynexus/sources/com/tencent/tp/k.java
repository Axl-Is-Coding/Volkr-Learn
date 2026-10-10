package com.tencent.tp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class k {
    public static Object a(Class cls, String str, Object obj, Class[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static Object a(String str, Object obj, String str2) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object a(String str, String str2) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.get(null);
    }

    public static Object a(String str, String str2, Object obj, Class[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        return Class.forName(str).getMethod(str2, clsArr).invoke(obj, objArr);
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        return Class.forName(str).getMethod(str2, clsArr).invoke(null, objArr);
    }

    public static void a(String str, String str2, Object obj) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        declaredField.set(null, obj);
    }

    public static void a(String str, String str2, Object obj, Object obj2) throws IllegalAccessException, NoSuchFieldException, SecurityException, ClassNotFoundException, IllegalArgumentException {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }
}
