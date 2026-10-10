package com.bytedance.sdk.a.b.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: RouteException.java */
/* JADX INFO: loaded from: classes.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f4947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f4948b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        f4947a = declaredMethod;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f4948b = iOException;
    }

    public IOException a() {
        return this.f4948b;
    }

    public void a(IOException iOException) {
        a(iOException, this.f4948b);
        this.f4948b = iOException;
    }

    private void a(IOException iOException, IOException iOException2) {
        Method method = f4947a;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
