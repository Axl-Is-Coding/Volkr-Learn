package com.google.gson.internal.a;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: UnsafeReflectionAccessor.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f14121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f14122c = c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Field f14123d = b();

    c() {
    }

    private static Object c() {
        try {
            f14121b = Class.forName("sun.misc.Unsafe");
            Field declaredField = f14121b.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.gson.internal.a.b
    public void a(AccessibleObject accessibleObject) {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    boolean b(AccessibleObject accessibleObject) {
        if (this.f14122c != null && this.f14123d != null) {
            try {
                f14121b.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f14122c, accessibleObject, Long.valueOf(((Long) f14121b.getMethod("objectFieldOffset", Field.class).invoke(this.f14122c, this.f14123d)).longValue()), true);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Field b() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
