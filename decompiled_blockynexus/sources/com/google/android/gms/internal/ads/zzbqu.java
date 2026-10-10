package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqu {
    public final List<? extends zzdzc<? extends zzbqo>> zzfrx;

    public zzbqu(List<? extends zzdzc<? extends zzbqo>> list) {
        this.zzfrx = list;
    }

    public static zzcta<zzbqu> zza(zzcvl<? extends zzbqo> zzcvlVar) {
        return new zzcsz(zzcvlVar, zzbqt.zzdwz);
    }

    public static zzcta<zzbqu> zza(zzcta<? extends zzbqo> zzctaVar) {
        return new zzcsz(zzctaVar, zzbqw.zzdwz);
    }

    public zzbqu(zzbqo zzbqoVar) {
        this.zzfrx = Collections.singletonList(zzdyq.zzaf(zzbqoVar));
    }
}
