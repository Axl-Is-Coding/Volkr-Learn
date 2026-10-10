package com.google.gson.internal.a;

import com.google.gson.internal.r;
import java.lang.reflect.AccessibleObject;

/* JADX INFO: compiled from: ReflectionAccessor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f14120a;

    static {
        f14120a = r.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f14120a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
