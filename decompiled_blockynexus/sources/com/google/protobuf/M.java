package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: UnsafeUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f14320a = e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f14321b = g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f14322c = f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f14323d = d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f14324e = a(a((Class<?>) Buffer.class, "address"));

    static long a() {
        return f14323d;
    }

    static boolean b() {
        return f14322c;
    }

    static boolean c() {
        return f14321b;
    }

    private static int d() {
        if (f14322c) {
            return f14320a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static Unsafe e() {
        try {
            return (Unsafe) AccessController.doPrivileged(new L());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean f() {
        Unsafe unsafe = f14320a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("getByte", Object.class, Long.TYPE);
                cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean g() {
        Unsafe unsafe = f14320a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getByte", Long.TYPE);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
                cls.getMethod("getLong", Long.TYPE);
                cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    static byte a(byte[] bArr, long j) {
        return f14320a.getByte(bArr, j);
    }

    static long b(byte[] bArr, long j) {
        return f14320a.getLong(bArr, j);
    }

    static void a(byte[] bArr, long j, byte b2) {
        f14320a.putByte(bArr, j, b2);
    }

    private static long a(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = f14320a) == null) {
            return -1L;
        }
        return unsafe.objectFieldOffset(field);
    }

    private static Field a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
