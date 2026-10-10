package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzelc implements zzelk {
    private zzelk[] zzilg;

    zzelc(zzelk... zzelkVarArr) {
        this.zzilg = zzelkVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzelk
    public final boolean zze(Class<?> cls) {
        for (zzelk zzelkVar : this.zzilg) {
            if (zzelkVar.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzelk
    public final zzelh zzf(Class<?> cls) {
        for (zzelk zzelkVar : this.zzilg) {
            if (zzelkVar.zze(cls)) {
                return zzelkVar.zzf(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
