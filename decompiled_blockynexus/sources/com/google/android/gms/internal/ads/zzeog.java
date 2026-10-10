package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeog extends zzeoi implements zzbp {
    private String type;
    private long zzawn;
    private zzbs zzitn;
    private boolean zzitv;

    public zzeog(String str) {
        this.type = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final String getType() {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzbs zzbsVar) {
        this.zzitn = zzbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbp
    public final void zza(zzeok zzeokVar, ByteBuffer byteBuffer, long j, zzbo zzboVar) throws IOException {
        this.zzawn = zzeokVar.position() - ((long) byteBuffer.remaining());
        this.zzitv = byteBuffer.remaining() == 16;
        zza(zzeokVar, j, zzboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeoi
    public final void zza(zzeok zzeokVar, long j, zzbo zzboVar) throws IOException {
        this.zzitt = zzeokVar;
        this.zzitz = zzeokVar.position();
        this.zzbgl = this.zzitz - ((long) ((this.zzitv || 8 + j >= 4294967296L) ? 16 : 8));
        zzeokVar.zzfc(zzeokVar.position() + j);
        this.zzawj = zzeokVar.position();
        this.zzitx = zzboVar;
    }
}
