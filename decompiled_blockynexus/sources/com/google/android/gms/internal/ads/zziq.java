package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zziq {
    private int zzahn;
    protected AudioTrack zzajy;
    private boolean zzalq;
    private long zzalr;
    private long zzals;
    private long zzalt;
    private long zzalu;
    private long zzalv;
    private long zzalw;

    private zziq() {
    }

    public final void pause() {
        if (this.zzalu != -9223372036854775807L) {
            return;
        }
        this.zzajy.pause();
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzajy = audioTrack;
        this.zzalq = z;
        this.zzalu = -9223372036854775807L;
        this.zzalr = 0L;
        this.zzals = 0L;
        this.zzalt = 0L;
        if (audioTrack != null) {
            this.zzahn = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzalv = zzfy();
        this.zzalu = SystemClock.elapsedRealtime() * 1000;
        this.zzalw = j;
        this.zzajy.stop();
    }

    public final long zzfy() {
        if (this.zzalu != -9223372036854775807L) {
            return Math.min(this.zzalw, this.zzalv + ((((SystemClock.elapsedRealtime() * 1000) - this.zzalu) * ((long) this.zzahn)) / 1000000));
        }
        int playState = this.zzajy.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.zzajy.getPlaybackHeadPosition());
        if (this.zzalq) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzalt = this.zzalr;
            }
            playbackHeadPosition += this.zzalt;
        }
        if (this.zzalr > playbackHeadPosition) {
            this.zzals++;
        }
        this.zzalr = playbackHeadPosition;
        return playbackHeadPosition + (this.zzals << 32);
    }

    public final long zzfz() {
        return (zzfy() * 1000000) / ((long) this.zzahn);
    }

    public boolean zzga() {
        return false;
    }

    public long zzgb() {
        throw new UnsupportedOperationException();
    }

    public long zzgc() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zziq(zzir zzirVar) {
        this();
    }
}
