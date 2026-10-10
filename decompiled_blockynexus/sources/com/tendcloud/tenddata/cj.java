package com.tendcloud.tenddata;

import android.content.Context;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class cj {
    public static boolean a() {
        try {
            if (af.b(29) || !by.a()) {
                return false;
            }
            Class.forName("com.android.id.impl.IdProviderImpl");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectMiUi(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            Object objNewInstance = cls.newInstance();
            try {
                de.b().setUDID((String) cls.getMethod("getUDID", Context.class).invoke(objNewInstance, context));
            } catch (Throwable unused) {
            }
            try {
                de.b().setOAID((String) cls.getMethod("getOAID", Context.class).invoke(objNewInstance, context));
            } catch (Throwable unused2) {
            }
            try {
                de.b().setVAID((String) cls.getMethod("getVAID", Context.class).invoke(objNewInstance, context));
            } catch (Throwable unused3) {
            }
            de.b().setAAID((String) cls.getMethod("getAAID", Context.class).invoke(objNewInstance, context));
        } catch (Throwable unused4) {
        }
    }
}
