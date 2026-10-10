package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmy implements zzdso {
    private final Clock zzbqa;
    private final zzcms zzghn;
    private final Map<zzdsf, Long> zzghm = new HashMap();
    private final Map<zzdsf, zzcmx> zzgho = new HashMap();

    public zzcmy(zzcms zzcmsVar, Set<zzcmx> set, Clock clock) {
        this.zzghn = zzcmsVar;
        for (zzcmx zzcmxVar : set) {
            this.zzgho.put(zzcmxVar.zzghl, zzcmxVar);
        }
        this.zzbqa = clock;
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str, Throwable th) {
        if (this.zzghm.containsKey(zzdsfVar)) {
            long jElapsedRealtime = this.zzbqa.elapsedRealtime() - this.zzghm.get(zzdsfVar).longValue();
            Map<String, String> mapZzru = this.zzghn.zzru();
            String strValueOf = String.valueOf(str);
            String strConcat = strValueOf.length() != 0 ? "task.".concat(strValueOf) : new String("task.");
            String strValueOf2 = String.valueOf(Long.toString(jElapsedRealtime));
            mapZzru.put(strConcat, strValueOf2.length() != 0 ? "f.".concat(strValueOf2) : new String("f."));
        }
        if (this.zzgho.containsKey(zzdsfVar)) {
            zza(zzdsfVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzb(zzdsf zzdsfVar, String str) {
        this.zzghm.put(zzdsfVar, Long.valueOf(this.zzbqa.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzc(zzdsf zzdsfVar, String str) {
        if (this.zzghm.containsKey(zzdsfVar)) {
            long jElapsedRealtime = this.zzbqa.elapsedRealtime() - this.zzghm.get(zzdsfVar).longValue();
            Map<String, String> mapZzru = this.zzghn.zzru();
            String strValueOf = String.valueOf(str);
            String strConcat = strValueOf.length() != 0 ? "task.".concat(strValueOf) : new String("task.");
            String strValueOf2 = String.valueOf(Long.toString(jElapsedRealtime));
            mapZzru.put(strConcat, strValueOf2.length() != 0 ? "s.".concat(strValueOf2) : new String("s."));
        }
        if (this.zzgho.containsKey(zzdsfVar)) {
            zza(zzdsfVar, true);
        }
    }

    private final void zza(zzdsf zzdsfVar, boolean z) {
        zzdsf zzdsfVar2 = this.zzgho.get(zzdsfVar).zzghk;
        String str = z ? "s." : "f.";
        if (this.zzghm.containsKey(zzdsfVar2)) {
            long jElapsedRealtime = this.zzbqa.elapsedRealtime() - this.zzghm.get(zzdsfVar2).longValue();
            Map<String, String> mapZzru = this.zzghn.zzru();
            String strValueOf = String.valueOf(this.zzgho.get(zzdsfVar).label);
            String strConcat = strValueOf.length() != 0 ? "label.".concat(strValueOf) : new String("label.");
            String strValueOf2 = String.valueOf(Long.toString(jElapsedRealtime));
            mapZzru.put(strConcat, strValueOf2.length() != 0 ? str.concat(strValueOf2) : new String(str));
        }
    }
}
