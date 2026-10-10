package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdge implements zzdgx<zzdgf> {
    private final zzawo zzbqq;
    private final zzdzb zzgcz;
    private final Context zzvr;

    public zzdge(zzawo zzawoVar, zzdzb zzdzbVar, Context context) {
        this.zzbqq = zzawoVar;
        this.zzgcz = zzdzbVar;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgf> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgh
            private final zzdge zzgxr;

            {
                this.zzgxr = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgxr.zzarx();
            }
        });
    }

    final /* synthetic */ zzdgf zzarx() throws Exception {
        if (!this.zzbqq.zzac(this.zzvr)) {
            return new zzdgf(null, null, null, null, null);
        }
        String strZzaf = this.zzbqq.zzaf(this.zzvr);
        String str = strZzaf == null ? "" : strZzaf;
        String strZzag = this.zzbqq.zzag(this.zzvr);
        String str2 = strZzag == null ? "" : strZzag;
        String strZzah = this.zzbqq.zzah(this.zzvr);
        String str3 = strZzah == null ? "" : strZzah;
        String strZzai = this.zzbqq.zzai(this.zzvr);
        return new zzdgf(str, str2, str3, strZzai == null ? "" : strZzai, "TIME_OUT".equals(str2) ? (Long) zzwm.zzpx().zzd(zzabb.zzcnq) : null);
    }
}
