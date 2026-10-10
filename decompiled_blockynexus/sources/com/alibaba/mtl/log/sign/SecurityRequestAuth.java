package com.alibaba.mtl.log.sign;

import android.content.Context;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.d.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SecurityRequestAuth implements IRequestAuth {
    private String ad;
    private String g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f3653b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f3654c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f3652a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Field f68a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Field f70b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private Field f71c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f69a = null;
    private int z = 1;
    private boolean F = false;

    public SecurityRequestAuth(String str, String str2) {
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
                this.f3653b = cls.getMethod("getInstance", Context.class).invoke(null, a.getContext());
                this.f3654c = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.f3653b, new Object[0]);
            } catch (Throwable th) {
                th = th;
                i.a("SecurityRequestAuth", "initSecurityCheck", th);
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
            this.f3652a = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
            this.f68a = this.f3652a.getDeclaredField("appKey");
            this.f70b = this.f3652a.getDeclaredField("paramMap");
            this.f71c = this.f3652a.getDeclaredField("requestType");
            try {
                method = cls.getMethod("isOpen", new Class[0]);
            } catch (Throwable th3) {
                i.a("SecurityRequestAuth", "initSecurityCheck", th3);
                method = null;
            }
            if (method != null) {
                zBooleanValue = ((Boolean) method.invoke(this.f3653b, new Object[0])).booleanValue();
            } else {
                try {
                    cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                } catch (Throwable th4) {
                    i.a("SecurityRequestAuth", "initSecurityCheck", th4);
                }
                zBooleanValue = cls2 == null;
            }
            this.z = zBooleanValue ? 1 : 12;
            this.f69a = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", this.f3652a, String.class);
        } catch (Throwable th5) {
            i.a("SecurityRequestAuth", "initSecurityCheck", th5);
        }
        this.F = true;
        return;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getAppkey() {
        return this.g;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getSign(String str) {
        Class cls;
        if (!this.F) {
            D();
        }
        if (this.g == null) {
            i.a("SecurityRequestAuth", "There is no appkey,please check it!");
            return null;
        }
        if (str == null) {
            return null;
        }
        if (this.f3653b != null && (cls = this.f3652a) != null && this.f68a != null && this.f70b != null && this.f71c != null && this.f69a != null && this.f3654c != null) {
            try {
                Object objNewInstance = cls.newInstance();
                this.f68a.set(objNewInstance, this.g);
                ((Map) this.f70b.get(objNewInstance)).put("INPUT", str);
                this.f71c.set(objNewInstance, Integer.valueOf(this.z));
                return (String) this.f69a.invoke(this.f3654c, objNewInstance, this.ad);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
