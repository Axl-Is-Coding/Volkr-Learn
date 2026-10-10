package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqc implements zzeoy<zzafy> {
    private final zzbqa zzfrc;

    public zzbqc(zzbqa zzbqaVar) {
        this.zzfrc = zzbqaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzafy zzafyVarZzair = this.zzfrc.zzair();
        zzepe.zza(zzafyVarZzair, "Cannot return null from a non-@Nullable @Provides method");
        return zzafyVarZzair;
    }
}
