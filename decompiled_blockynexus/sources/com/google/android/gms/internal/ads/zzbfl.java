package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbfl implements Releasable {
    protected Context mContext;
    protected String zzedk;
    protected WeakReference<zzbdu> zzels;

    public zzbfl(zzbdu zzbduVar) {
        this.mContext = zzbduVar.getContext();
        this.zzedk = com.google.android.gms.ads.internal.zzp.zzkr().zzs(this.mContext, zzbduVar.zzzx().zzbre);
        this.zzels = new WeakReference<>(zzbduVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String zzfp(java.lang.String r1) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfl.zzfp(java.lang.String):java.lang.String");
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        zzbbg.zzaah.post(new zzbfn(this, str, str2, j, j2, z, i, i2));
    }

    @VisibleForTesting
    public final void zzc(String str, String str2, long j) {
        zzbbg.zzaah.post(new zzbfo(this, str, str2, j));
    }

    protected void zzdl(int i) {
    }

    protected void zzdm(int i) {
    }

    protected void zzdn(int i) {
    }

    protected void zzdo(int i) {
    }

    public boolean zze(String str, String[] strArr) {
        return zzfn(str);
    }

    public abstract boolean zzfn(String str);

    protected String zzfo(String str) {
        zzwm.zzpt();
        return zzbbg.zzex(str);
    }

    @VisibleForTesting
    public final void zza(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzbbg.zzaah.post(new zzbfm(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    protected final void zza(String str, String str2, int i) {
        zzbbg.zzaah.post(new zzbfp(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, String str4) {
        zzbbg.zzaah.post(new zzbfr(this, str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzbdu zzbduVar = this.zzels.get();
        if (zzbduVar != null) {
            zzbduVar.zza(str, map);
        }
    }
}
