package com.bytedance.sdk.openadsdk.h.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: StorageList.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile c f6945e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f6947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Method f6948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f6949d;

    private c() {
        this.f6946a = null;
        this.f6947b = null;
        this.f6948c = null;
        this.f6949d = null;
        this.f6946a = o.a();
        Context context = this.f6946a;
        if (context != null) {
            this.f6947b = context.getSystemService("storage");
            try {
                this.f6948c = this.f6947b.getClass().getMethod("getVolumeList", new Class[0]);
                this.f6949d = this.f6947b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        if (f6945e == null) {
            synchronized (c.class) {
                if (f6945e == null) {
                    f6945e = new c();
                }
            }
        }
        return f6945e;
    }

    public boolean b() {
        Method method;
        Object obj = this.f6947b;
        if (obj != null && (method = this.f6948c) != null && this.f6949d != null) {
            try {
                Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                if (objArr != null && objArr.length != 0) {
                    Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                    Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                    if (method2 != null && method3 != null) {
                        for (Object obj2 : objArr) {
                            if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue()) {
                                if (this.f6949d.invoke(this.f6947b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
