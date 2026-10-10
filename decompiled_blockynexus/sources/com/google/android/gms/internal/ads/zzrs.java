package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzrs implements Comparator<zzry> {
    zzrs(zzrp zzrpVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzry zzryVar, zzry zzryVar2) {
        zzry zzryVar3 = zzryVar;
        zzry zzryVar4 = zzryVar2;
        int i = zzryVar3.zzbtz - zzryVar4.zzbtz;
        return i != 0 ? i : (int) (zzryVar3.value - zzryVar4.value);
    }
}
