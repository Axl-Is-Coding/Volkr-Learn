package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzje implements zzie {
    private boolean zzamn;
    private zzjf zzamw;
    private long zzamy;
    private long zzamz;
    private float zzaia = 1.0f;
    private float zzaib = 1.0f;
    private int zzahm = -1;
    private int zzami = -1;
    private ByteBuffer zzamm = zzie.zzaiy;
    private ShortBuffer zzamx = this.zzamm.asShortBuffer();
    private ByteBuffer zzalf = zzie.zzaiy;

    @Override // com.google.android.gms.internal.ads.zzie
    public final void flush() {
        this.zzamw = new zzjf(this.zzami, this.zzahm);
        this.zzamw.setSpeed(this.zzaia);
        this.zzamw.zzc(this.zzaib);
        this.zzalf = zzie.zzaiy;
        this.zzamy = 0L;
        this.zzamz = 0L;
        this.zzamn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean isActive() {
        return Math.abs(this.zzaia - 1.0f) >= 0.01f || Math.abs(this.zzaib - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void reset() {
        this.zzamw = null;
        this.zzamm = zzie.zzaiy;
        this.zzamx = this.zzamm.asShortBuffer();
        this.zzalf = zzie.zzaiy;
        this.zzahm = -1;
        this.zzami = -1;
        this.zzamy = 0L;
        this.zzamz = 0L;
        this.zzamn = false;
    }

    public final float zza(float f2) {
        this.zzaia = zzpq.zza(f2, 0.1f, 8.0f);
        return this.zzaia;
    }

    public final float zzb(float f2) {
        this.zzaib = zzpq.zza(f2, 0.1f, 8.0f);
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzfe() {
        if (!this.zzamn) {
            return false;
        }
        zzjf zzjfVar = this.zzamw;
        return zzjfVar == null || zzjfVar.zzgh() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final int zzfj() {
        return this.zzahm;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final int zzfk() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zzfl() {
        this.zzamw.zzfl();
        this.zzamn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.zzalf;
        this.zzalf = zzie.zzaiy;
        return byteBuffer;
    }

    public final long zzgf() {
        return this.zzamy;
    }

    public final long zzgg() {
        return this.zzamz;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zzn(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.zzamy += (long) iRemaining;
            this.zzamw.zza(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iZzgh = (this.zzamw.zzgh() * this.zzahm) << 1;
        if (iZzgh > 0) {
            if (this.zzamm.capacity() < iZzgh) {
                this.zzamm = ByteBuffer.allocateDirect(iZzgh).order(ByteOrder.nativeOrder());
                this.zzamx = this.zzamm.asShortBuffer();
            } else {
                this.zzamm.clear();
                this.zzamx.clear();
            }
            this.zzamw.zzb(this.zzamx);
            this.zzamz += (long) iZzgh;
            this.zzamm.limit(iZzgh);
            this.zzalf = this.zzamm;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzb(int i, int i2, int i3) throws zzih {
        if (i3 != 2) {
            throw new zzih(i, i2, i3);
        }
        if (this.zzami == i && this.zzahm == i2) {
            return false;
        }
        this.zzami = i;
        this.zzahm = i2;
        return true;
    }
}
