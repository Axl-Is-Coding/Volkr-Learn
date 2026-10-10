package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.AdError;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.umeng.analytics.pro.au;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdvb {
    private static final HashMap<String, Class<?>> zzhol = new HashMap<>();
    private final zzdve zzhnv;
    private final zzdta zzhom;
    private zzdup zzhon;
    private final Object zzhoo = new Object();
    private final Context zzvr;
    private final zzdtc zzvw;

    public zzdvb(Context context, zzdve zzdveVar, zzdtc zzdtcVar, zzdta zzdtaVar) {
        this.zzvr = context;
        this.zzhnv = zzdveVar;
        this.zzvw = zzdtcVar;
        this.zzhom = zzdtaVar;
    }

    private final synchronized Class<?> zza(zzdus zzdusVar) throws zzdvc {
        if (zzdusVar.zzawv() == null) {
            throw new zzdvc(4010, au.z);
        }
        String strZzdg = zzdusVar.zzawv().zzdg();
        Class<?> cls = zzhol.get(strZzdg);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.zzhom.zzb(zzdusVar.zzaww())) {
                throw new zzdvc(2026, "VM did not pass signature verification");
            }
            try {
                File fileZzawx = zzdusVar.zzawx();
                if (!fileZzawx.exists()) {
                    fileZzawx.mkdirs();
                }
                Class<?> clsLoadClass = new DexClassLoader(zzdusVar.zzaww().getAbsolutePath(), fileZzawx.getAbsolutePath(), null, this.zzvr.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                zzhol.put(strZzdg, clsLoadClass);
                return clsLoadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
                throw new zzdvc(AdError.REMOTE_ADS_SERVICE_ERROR, e2);
            }
        } catch (GeneralSecurityException e3) {
            throw new zzdvc(2026, e3);
        }
    }

    public final zzdtf zzawz() {
        zzdup zzdupVar;
        synchronized (this.zzhoo) {
            zzdupVar = this.zzhon;
        }
        return zzdupVar;
    }

    public final zzdus zzaxa() {
        synchronized (this.zzhoo) {
            if (this.zzhon == null) {
                return null;
            }
            return this.zzhon.zzawp();
        }
    }

    public final void zzb(zzdus zzdusVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            zzdup zzdupVar = new zzdup(zza(zza(zzdusVar), zzdusVar), zzdusVar, this.zzhnv, this.zzvw);
            if (!zzdupVar.zzawq()) {
                throw new zzdvc(4000, "init failed");
            }
            int iZzawr = zzdupVar.zzawr();
            if (iZzawr != 0) {
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(iZzawr);
                throw new zzdvc(4001, sb.toString());
            }
            synchronized (this.zzhoo) {
                if (this.zzhon != null) {
                    try {
                        this.zzhon.close();
                    } catch (zzdvc e2) {
                        this.zzvw.zza(e2.zzaxb(), -1L, e2);
                    }
                    this.zzhon = zzdupVar;
                } else {
                    this.zzhon = zzdupVar;
                }
            }
            this.zzvw.zzg(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (zzdvc e3) {
            this.zzvw.zza(e3.zzaxb(), System.currentTimeMillis() - jCurrentTimeMillis, e3);
        } catch (Exception e4) {
            this.zzvw.zza(4010, System.currentTimeMillis() - jCurrentTimeMillis, e4);
        }
    }

    private final Object zza(Class<?> cls, zzdus zzdusVar) throws zzdvc {
        try {
            return cls.getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzvr, "msa-r", zzdusVar.zzawy(), null, new Bundle(), 2);
        } catch (Exception e2) {
            throw new zzdvc(AdError.INTERNAL_ERROR_2004, e2);
        }
    }
}
