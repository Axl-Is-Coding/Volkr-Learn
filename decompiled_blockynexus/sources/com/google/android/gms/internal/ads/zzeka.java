package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeka implements zzelk {
    private static final zzeka zzijf = new zzeka();

    private zzeka() {
    }

    public static zzeka zzbgo() {
        return zzijf;
    }

    @Override // com.google.android.gms.internal.ads.zzelk
    public final boolean zze(Class<?> cls) {
        return zzejz.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzelk
    public final zzelh zzf(Class<?> cls) {
        if (!zzejz.class.isAssignableFrom(cls)) {
            String strValueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported message type: ".concat(strValueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzelh) zzejz.zzd(cls.asSubclass(zzejz.class)).zza(zzejz.zze.zzijm, (Object) null, (Object) null);
        } catch (Exception e2) {
            String strValueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(strValueOf2.length() != 0 ? "Unable to get message info for ".concat(strValueOf2) : new String("Unable to get message info for "), e2);
        }
    }
}
