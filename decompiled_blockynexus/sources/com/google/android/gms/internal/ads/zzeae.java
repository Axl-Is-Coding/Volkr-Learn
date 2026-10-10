package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelj;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeae<PrimitiveT, KeyProtoT extends zzelj> implements zzeab<PrimitiveT> {
    private final zzeag<KeyProtoT> zzhud;
    private final Class<PrimitiveT> zzhue;

    public zzeae(zzeag<KeyProtoT> zzeagVar, Class<PrimitiveT> cls) {
        if (!zzeagVar.zzayp().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzeagVar.toString(), cls.getName()));
        }
        this.zzhud = zzeagVar;
        this.zzhue = cls;
    }

    private final zzead<?, KeyProtoT> zzayl() {
        return new zzead<>(this.zzhud.zzayr());
    }

    private final PrimitiveT zzb(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.zzhue)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.zzhud.zze(keyprotot);
        return (PrimitiveT) this.zzhud.zza(keyprotot, this.zzhue);
    }

    @Override // com.google.android.gms.internal.ads.zzeab
    public final String getKeyType() {
        return this.zzhud.getKeyType();
    }

    @Override // com.google.android.gms.internal.ads.zzeab
    public final PrimitiveT zza(zzelj zzeljVar) throws GeneralSecurityException {
        String strValueOf = String.valueOf(this.zzhud.zzayn().getName());
        String strConcat = strValueOf.length() != 0 ? "Expected proto of type ".concat(strValueOf) : new String("Expected proto of type ");
        if (this.zzhud.zzayn().isInstance(zzeljVar)) {
            return zzb(zzeljVar);
        }
        throw new GeneralSecurityException(strConcat);
    }

    @Override // com.google.android.gms.internal.ads.zzeab
    public final Class<PrimitiveT> zzayk() {
        return this.zzhue;
    }

    @Override // com.google.android.gms.internal.ads.zzeab
    public final PrimitiveT zzm(zzeip zzeipVar) throws GeneralSecurityException {
        try {
            return zzb(this.zzhud.zzr(zzeipVar));
        } catch (zzekj e2) {
            String strValueOf = String.valueOf(this.zzhud.zzayn().getName());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "Failures parsing proto of type ".concat(strValueOf) : new String("Failures parsing proto of type "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeab
    public final zzelj zzn(zzeip zzeipVar) throws GeneralSecurityException {
        try {
            return zzayl().zzp(zzeipVar);
        } catch (zzekj e2) {
            String strValueOf = String.valueOf(this.zzhud.zzayr().zzaym().getName());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "Failures parsing proto of type ".concat(strValueOf) : new String("Failures parsing proto of type "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeab
    public final zzefb zzo(zzeip zzeipVar) throws GeneralSecurityException {
        try {
            return (zzefb) ((zzejz) zzefb.zzbbw().zzhq(this.zzhud.getKeyType()).zzaf(zzayl().zzp(zzeipVar).zzbdw()).zzb(this.zzhud.zzayo()).zzbgt());
        } catch (zzekj e2) {
            throw new GeneralSecurityException("Unexpected proto", e2);
        }
    }
}
