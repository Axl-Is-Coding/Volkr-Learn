package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdwh {
    private static final Object zzhqg;
    private static final Method zzhqh;
    private static final Method zzhqi;

    static {
        Object objZzaxf = zzaxf();
        zzhqg = objZzaxf;
        zzhqh = objZzaxf == null ? null : zza("getStackTraceElement", Throwable.class, Integer.TYPE);
        zzhqi = zzhqg != null ? zzaxg() : null;
    }

    public static String zza(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzehy.zza(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static Object zzaxf() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzaxg() {
        try {
            Method methodZza = zza("getStackTraceDepth", Throwable.class);
            if (methodZza == null) {
                return null;
            }
            methodZza.invoke(zzaxf(), new Throwable());
            return methodZza;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static void zzi(Throwable th) {
        zzdwd.checkNotNull(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    @Deprecated
    public static RuntimeException zzj(Throwable th) {
        zzi(th);
        throw new RuntimeException(th);
    }

    private static Method zza(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }
}
