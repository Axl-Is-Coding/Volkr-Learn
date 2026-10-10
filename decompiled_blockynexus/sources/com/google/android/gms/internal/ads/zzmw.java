package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmw implements zznm {
    private final int track;
    private final /* synthetic */ zzmn zzbek;

    public zzmw(zzmn zzmnVar, int i) {
        this.zzbek = zzmnVar;
        this.track = i;
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final boolean isReady() {
        return this.zzbek.zzbb(this.track);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final int zzb(zzhq zzhqVar, zzjk zzjkVar, boolean z) {
        return this.zzbek.zza(this.track, zzhqVar, zzjkVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzeh(long j) {
        this.zzbek.zzd(this.track, j);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzhs() throws IOException {
        this.zzbek.zzhs();
    }
}
