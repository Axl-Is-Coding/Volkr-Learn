package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdup implements zzdtf {
    private final Object zzhnt;
    private final zzdus zzhnu;
    private final zzdve zzhnv;
    private final zzdtc zzvw;

    zzdup(Object obj, zzdus zzdusVar, zzdve zzdveVar, zzdtc zzdtcVar) {
        this.zzhnt = obj;
        this.zzhnu = zzdusVar;
        this.zzhnv = zzdveVar;
        this.zzvw = zzdtcVar;
    }

    private static String zzk(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzcf.zzf) zzcf.zzf.zzbl().zzb(zzcm.DG).zzj(zzeip.zzu(bArr)).zzbgt()).toByteArray(), 11);
    }

    public final synchronized void close() throws zzdvc {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.zzhnt.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zzhnt, new Object[0]);
            this.zzvw.zzg(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e2) {
            throw new zzdvc(AdError.INTERNAL_ERROR_2003, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> mapZzcf;
        mapZzcf = this.zzhnv.zzcf();
        mapZzcf.put("f", "c");
        mapZzcf.put("ctx", context);
        mapZzcf.put("cs", str2);
        mapZzcf.put("aid", null);
        mapZzcf.put(ViewHierarchyConstants.VIEW_KEY, view);
        mapZzcf.put("act", activity);
        return zzk(zzb(null, mapZzcf));
    }

    final zzdus zzawp() {
        return this.zzhnu;
    }

    final synchronized boolean zzawq() throws zzdvc {
        try {
        } catch (Exception e2) {
            throw new zzdvc(2001, e2);
        }
        return ((Boolean) this.zzhnt.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zzhnt, new Object[0])).booleanValue();
    }

    public final synchronized int zzawr() throws zzdvc {
        try {
        } catch (Exception e2) {
            throw new zzdvc(AdError.INTERNAL_ERROR_2006, e2);
        }
        return ((Integer) this.zzhnt.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zzhnt, new Object[0])).intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> mapZzce;
        mapZzce = this.zzhnv.zzce();
        mapZzce.put("f", "v");
        mapZzce.put("ctx", context);
        mapZzce.put("aid", null);
        mapZzce.put(ViewHierarchyConstants.VIEW_KEY, view);
        mapZzce.put("act", activity);
        return zzk(zzb(null, mapZzce));
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final synchronized String zzv(Context context, String str) {
        Map<String, Object> mapZzcd;
        mapZzcd = this.zzhnv.zzcd();
        mapZzcd.put("f", "q");
        mapZzcd.put("ctx", context);
        mapZzcd.put("aid", null);
        return zzk(zzb(null, mapZzcd));
    }

    private final synchronized byte[] zzb(Map<String, String> map, Map<String, Object> map2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e2) {
            this.zzvw.zza(2007, System.currentTimeMillis() - jCurrentTimeMillis, e2);
            return null;
        }
        return (byte[]) this.zzhnt.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zzhnt, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtf
    public final synchronized void zza(String str, MotionEvent motionEvent) throws zzdvc {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put("aid", null);
            map.put("evt", motionEvent);
            this.zzhnt.getClass().getDeclaredMethod("he", Map.class).invoke(this.zzhnt, map);
            this.zzvw.zzg(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e2) {
            throw new zzdvc(2005, e2);
        }
    }
}
