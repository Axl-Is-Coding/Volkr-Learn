package com.ut.mini.core.sign;

import android.content.Context;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.d.i;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class UTSecuritySDKRequestAuthentication implements IUTRequestAuthentication {
    private String ad;
    private String g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f21361b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f21362c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f21360a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Field f124a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Field f126b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private Field f127c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f125a = null;
    private int z = 1;
    private boolean F = false;

    public UTSecuritySDKRequestAuthentication(String str, String str2) {
        this.g = null;
        this.g = str;
        this.ad = str2;
    }

    private synchronized void D() {
        Class<?> cls;
        Method method;
        boolean zBooleanValue;
        if (this.F) {
            return;
        }
        Class<?> cls2 = null;
        try {
            cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
            try {
                this.f21361b = cls.getMethod("getInstance", Context.class).invoke(null, b.a().getContext());
                this.f21362c = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.f21361b, new Object[0]);
            } catch (Throwable th) {
                th = th;
                i.a("initSecurityCheck", th.getMessage());
            }
        } catch (Throwable th2) {
            th = th2;
            cls = null;
        }
        if (cls == null) {
            this.F = true;
            return;
        }
        try {
            this.f21360a = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
            this.f124a = this.f21360a.getDeclaredField("appKey");
            this.f126b = this.f21360a.getDeclaredField("paramMap");
            this.f127c = this.f21360a.getDeclaredField("requestType");
            try {
                method = cls.getMethod("isOpen", new Class[0]);
            } catch (Throwable th3) {
                i.a("initSecurityCheck", th3.getMessage());
                method = null;
            }
            if (method != null) {
                zBooleanValue = ((Boolean) method.invoke(this.f21361b, new Object[0])).booleanValue();
            } else {
                try {
                    cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                } catch (Throwable th4) {
                    i.a("initSecurityCheck", th4.getMessage());
                }
                zBooleanValue = cls2 == null;
            }
            this.z = zBooleanValue ? 1 : 12;
            this.f125a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", this.f21360a, String.class);
        } catch (Throwable th5) {
            i.a("initSecurityCheck", th5.getMessage());
        }
        this.F = true;
        return;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getAppkey() {
        return this.g;
    }

    public String getAuthCode() {
        return this.ad;
    }

    @Override // com.ut.mini.core.sign.IUTRequestAuthentication
    public String getSign(String str) {
        Class cls;
        if (!this.F) {
            D();
        }
        if (this.g == null) {
            i.a("UTSecuritySDKRequestAuthentication:getSign", "There is no appkey,please check it!");
            return null;
        }
        if (str == null) {
            return null;
        }
        if (this.f21361b != null && (cls = this.f21360a) != null && this.f124a != null && this.f126b != null && this.f127c != null && this.f125a != null && this.f21362c != null) {
            try {
                Object objNewInstance = cls.newInstance();
                this.f124a.set(objNewInstance, this.g);
                ((Map) this.f126b.get(objNewInstance)).put("INPUT", str);
                this.f127c.set(objNewInstance, Integer.valueOf(this.z));
                return (String) this.f125a.invoke(this.f21362c, objNewInstance, this.ad);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }
}
