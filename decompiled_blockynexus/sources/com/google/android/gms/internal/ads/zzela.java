package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzela implements zzemi {
    private static final zzelk zzilf = new zzekz();
    private final zzelk zzile;

    public zzela() {
        this(new zzelc(zzeka.zzbgo(), zzbho()));
    }

    private static boolean zza(zzelh zzelhVar) {
        return zzelhVar.zzbhs() == zzejz.zze.zzijs;
    }

    private static zzelk zzbho() {
        try {
            return (zzelk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzilf;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemi
    public final <T> zzemf<T> zzg(Class<T> cls) {
        zzemh.zzi(cls);
        zzelh zzelhVarZzf = this.zzile.zzf(cls);
        return zzelhVarZzf.zzbht() ? zzejz.class.isAssignableFrom(cls) ? zzelp.zza(zzemh.zzbij(), zzejp.zzbfw(), zzelhVarZzf.zzbhu()) : zzelp.zza(zzemh.zzbih(), zzejp.zzbfx(), zzelhVarZzf.zzbhu()) : zzejz.class.isAssignableFrom(cls) ? zza(zzelhVarZzf) ? zzeln.zza(cls, zzelhVarZzf, zzelt.zzbhz(), zzekt.zzbhm(), zzemh.zzbij(), zzejp.zzbfw(), zzeli.zzbhw()) : zzeln.zza(cls, zzelhVarZzf, zzelt.zzbhz(), zzekt.zzbhm(), zzemh.zzbij(), (zzejo<?>) null, zzeli.zzbhw()) : zza(zzelhVarZzf) ? zzeln.zza(cls, zzelhVarZzf, zzelt.zzbhy(), zzekt.zzbhl(), zzemh.zzbih(), zzejp.zzbfx(), zzeli.zzbhv()) : zzeln.zza(cls, zzelhVarZzf, zzelt.zzbhy(), zzekt.zzbhl(), zzemh.zzbii(), (zzejo<?>) null, zzeli.zzbhv());
    }

    private zzela(zzelk zzelkVar) {
        zzekb.zza(zzelkVar, "messageInfoFactory");
        this.zzile = zzelkVar;
    }
}
