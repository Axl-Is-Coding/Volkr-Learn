package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzcbf {
    private final zzbgj zzdgy;
    private final zzccm zzfww;

    public zzcbf(zzccm zzccmVar) {
        this(zzccmVar, null);
    }

    public final zzbgj zzahl() {
        return this.zzdgy;
    }

    public final zzccm zzakz() {
        return this.zzfww;
    }

    public final View zzala() {
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar != null) {
            return zzbgjVar.getWebView();
        }
        return null;
    }

    public final View zzalb() {
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar == null) {
            return null;
        }
        return zzbgjVar.getWebView();
    }

    public Set<zzcab<zzbuh>> zzb(zzbtd zzbtdVar) {
        return Collections.singleton(zzcab.zzb(zzbtdVar, zzbbz.zzeeu));
    }

    public Set<zzcab<zzbzu>> zzc(zzbtd zzbtdVar) {
        return Collections.singleton(zzcab.zzb(zzbtdVar, zzbbz.zzeeu));
    }

    public zzcbf(zzccm zzccmVar, zzbgj zzbgjVar) {
        this.zzfww = zzccmVar;
        this.zzdgy = zzbgjVar;
    }

    public final zzcab<zzbxz> zzb(Executor executor) {
        final zzbgj zzbgjVar = this.zzdgy;
        return new zzcab<>(new zzbxz(zzbgjVar) { // from class: com.google.android.gms.internal.ads.zzcbh
            private final zzbgj zzeqk;

            {
                this.zzeqk = zzbgjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxz
            public final void zzail() {
                zzbgj zzbgjVar2 = this.zzeqk;
                if (zzbgjVar2.zzabs() != null) {
                    zzbgjVar2.zzabs().close();
                }
            }
        }, executor);
    }
}
