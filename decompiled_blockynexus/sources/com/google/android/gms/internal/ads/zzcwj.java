package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwj {
    private final Clock zzbqa;
    private final zzctd zzfst;
    private final zzcwl zzgpx;
    private final List<String> zzgpy = Collections.synchronizedList(new ArrayList());
    private final boolean zzgpz = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcxn)).booleanValue();

    public zzcwj(Clock clock, zzcwl zzcwlVar, zzctd zzctdVar) {
        this.zzbqa = clock;
        this.zzgpx = zzcwlVar;
        this.zzfst = zzctdVar;
    }

    final <T> zzdzc<T> zza(zzdnw zzdnwVar, zzdnv zzdnvVar, zzdzc<T> zzdzcVar) {
        long jElapsedRealtime = this.zzbqa.elapsedRealtime();
        String str = zzdnvVar.zzdjo;
        if (str != null) {
            zzdyq.zza(zzdzcVar, new zzcwm(this, jElapsedRealtime, str, zzdnvVar, zzdnwVar), zzbbz.zzeeu);
        }
        return zzdzcVar;
    }

    public final String zzaqm() {
        return TextUtils.join("_", this.zzgpy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(Consts.DOT);
        sb.append(i);
        sb.append(Consts.DOT);
        sb.append(j);
        String string = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str2).length());
            sb2.append(string);
            sb2.append(Consts.DOT);
            sb2.append(str2);
            string = sb2.toString();
        }
        this.zzgpy.add(string);
    }
}
