package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemz extends zzemx<zzena, zzena> {
    zzemz() {
    }

    private static void zza(Object obj, zzena zzenaVar) {
        ((zzejz) obj).zzijc = zzenaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final boolean zza(zzelz zzelzVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final void zzaj(Object obj) {
        ((zzejz) obj).zzijc.zzbec();
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ zzena zzar(zzena zzenaVar) {
        zzena zzenaVar2 = zzenaVar;
        zzenaVar2.zzbec();
        return zzenaVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ int zzat(zzena zzenaVar) {
        return zzenaVar.zzbgh();
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ zzena zzax(Object obj) {
        return ((zzejz) obj).zzijc;
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ zzena zzay(Object obj) {
        zzena zzenaVar = ((zzejz) obj).zzijc;
        if (zzenaVar != zzena.zzbiv()) {
            return zzenaVar;
        }
        zzena zzenaVarZzbiw = zzena.zzbiw();
        zza(obj, zzenaVarZzbiw);
        return zzenaVarZzbiw;
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ int zzaz(zzena zzenaVar) {
        return zzenaVar.zzbix();
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zzb(zzena zzenaVar, int i, long j) {
        zzenaVar.zzd((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ zzena zzbiu() {
        return zzena.zzbiw();
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zzc(zzena zzenaVar, zzenu zzenuVar) throws IOException {
        zzenaVar.zza(zzenuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zzi(Object obj, zzena zzenaVar) {
        zza(obj, zzenaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zzj(Object obj, zzena zzenaVar) {
        zza(obj, zzenaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ zzena zzk(zzena zzenaVar, zzena zzenaVar2) {
        zzena zzenaVar3 = zzenaVar;
        zzena zzenaVar4 = zzenaVar2;
        return zzenaVar4.equals(zzena.zzbiv()) ? zzenaVar3 : zzena.zza(zzenaVar3, zzenaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zza(zzena zzenaVar, zzenu zzenuVar) throws IOException {
        zzenaVar.zzb(zzenuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zzc(zzena zzenaVar, int i, int i2) {
        zzenaVar.zzd((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zza(zzena zzenaVar, int i, zzena zzenaVar2) {
        zzenaVar.zzd((i << 3) | 3, zzenaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zza(zzena zzenaVar, int i, zzeip zzeipVar) {
        zzenaVar.zzd((i << 3) | 2, zzeipVar);
    }

    @Override // com.google.android.gms.internal.ads.zzemx
    final /* synthetic */ void zza(zzena zzenaVar, int i, long j) {
        zzenaVar.zzd(i << 3, Long.valueOf(j));
    }
}
