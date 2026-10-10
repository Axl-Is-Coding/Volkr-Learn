package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrz implements Comparator<zzrn> {
    public zzrz(zzsa zzsaVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzrn zzrnVar, zzrn zzrnVar2) {
        zzrn zzrnVar3 = zzrnVar;
        zzrn zzrnVar4 = zzrnVar2;
        if (zzrnVar3.zzmo() < zzrnVar4.zzmo()) {
            return -1;
        }
        if (zzrnVar3.zzmo() > zzrnVar4.zzmo()) {
            return 1;
        }
        if (zzrnVar3.zzmn() < zzrnVar4.zzmn()) {
            return -1;
        }
        if (zzrnVar3.zzmn() > zzrnVar4.zzmn()) {
            return 1;
        }
        float fZzmq = (zzrnVar3.zzmq() - zzrnVar3.zzmo()) * (zzrnVar3.zzmp() - zzrnVar3.zzmn());
        float fZzmq2 = (zzrnVar4.zzmq() - zzrnVar4.zzmo()) * (zzrnVar4.zzmp() - zzrnVar4.zzmn());
        if (fZzmq > fZzmq2) {
            return -1;
        }
        return fZzmq < fZzmq2 ? 1 : 0;
    }
}
