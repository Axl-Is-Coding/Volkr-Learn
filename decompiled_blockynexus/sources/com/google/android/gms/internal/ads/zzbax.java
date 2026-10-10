package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbax extends zzayl {
    private final String url;
    private final zzbbu zzedh;

    public zzbax(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.zzp.zzkr().zzs(context, str));
    }

    @Override // com.google.android.gms.internal.ads.zzayl
    public final void zzvb() {
        this.zzedh.zzes(this.url);
    }

    private zzbax(String str, String str2) {
        this.zzedh = new zzbbu(str2);
        this.url = str;
    }
}
