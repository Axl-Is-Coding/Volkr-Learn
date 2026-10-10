package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
final class zzit extends zziq {
    private final AudioTimestamp zzalz;
    private long zzama;
    private long zzamb;
    private long zzamc;

    public zzit() {
        super(null);
        this.zzalz = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzama = 0L;
        this.zzamb = 0L;
        this.zzamc = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final boolean zzga() {
        boolean timestamp = this.zzajy.getTimestamp(this.zzalz);
        if (timestamp) {
            long j = this.zzalz.framePosition;
            if (this.zzamb > j) {
                this.zzama++;
            }
            this.zzamb = j;
            this.zzamc = j + (this.zzama << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final long zzgb() {
        return this.zzalz.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    public final long zzgc() {
        return this.zzamc;
    }
}
