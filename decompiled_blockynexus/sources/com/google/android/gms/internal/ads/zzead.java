package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelj;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzead<KeyFormatProtoT extends zzelj, KeyProtoT extends zzelj> {
    private final zzeaf<KeyFormatProtoT, KeyProtoT> zzhuc;

    zzead(zzeaf<KeyFormatProtoT, KeyProtoT> zzeafVar) {
        this.zzhuc = zzeafVar;
    }

    final KeyProtoT zzp(zzeip zzeipVar) throws GeneralSecurityException, zzekj {
        zzelj zzeljVarZzq = this.zzhuc.zzq(zzeipVar);
        this.zzhuc.zzc(zzeljVarZzq);
        return this.zzhuc.zzd(zzeljVarZzq);
    }
}
