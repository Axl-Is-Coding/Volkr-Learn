package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzog {
    private zzof zzbhv;

    protected final void invalidate() {
        zzof zzofVar = this.zzbhv;
        if (zzofVar != null) {
            zzofVar.zzes();
        }
    }

    public abstract zzoi zza(zzhw[] zzhwVarArr, zznp zznpVar) throws zzhd;

    public final void zza(zzof zzofVar) {
        this.zzbhv = zzofVar;
    }

    public abstract void zzd(Object obj);
}
