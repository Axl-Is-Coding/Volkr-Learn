package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzabc implements zzadk {
    private final /* synthetic */ zzaax zzcys;

    zzabc(zzaax zzaaxVar) {
        this.zzcys = zzaaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final String get(String str, String str2) {
        return this.zzcys.zzcln.getString(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final Long getLong(String str, long j) {
        try {
            return Long.valueOf(this.zzcys.zzcln.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf(this.zzcys.zzcln.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final Double zza(String str, double d2) {
        return Double.valueOf(this.zzcys.zzcln.getFloat(str, (float) d2));
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final Boolean zzf(String str, boolean z) {
        return Boolean.valueOf(this.zzcys.zzcln.getBoolean(str, z));
    }
}
