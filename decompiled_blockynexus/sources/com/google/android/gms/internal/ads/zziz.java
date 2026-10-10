package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zziz implements zzie {
    private int zzahm;
    private ByteBuffer zzalf;
    private int zzami;
    private int[] zzamj;
    private boolean zzamk;
    private int[] zzaml;
    private ByteBuffer zzamm;
    private boolean zzamn;

    public zziz() {
        ByteBuffer byteBuffer = zzie.zzaiy;
        this.zzamm = byteBuffer;
        this.zzalf = byteBuffer;
        this.zzahm = -1;
        this.zzami = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void flush() {
        this.zzalf = zzie.zzaiy;
        this.zzamn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean isActive() {
        return this.zzamk;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void reset() {
        flush();
        this.zzamm = zzie.zzaiy;
        this.zzahm = -1;
        this.zzami = -1;
        this.zzaml = null;
        this.zzamk = false;
    }

    public final void zzb(int[] iArr) {
        this.zzamj = iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzfe() {
        return this.zzamn && this.zzalf == zzie.zzaiy;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final int zzfj() {
        int[] iArr = this.zzaml;
        return iArr == null ? this.zzahm : iArr.length;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final int zzfk() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zzfl() {
        this.zzamn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.zzalf;
        this.zzalf = zzie.zzaiy;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zzn(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = (((iLimit - iPosition) / (this.zzahm * 2)) * this.zzaml.length) << 1;
        if (this.zzamm.capacity() < length) {
            this.zzamm = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzamm.clear();
        }
        while (iPosition < iLimit) {
            for (int i : this.zzaml) {
                this.zzamm.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.zzahm << 1;
        }
        byteBuffer.position(iLimit);
        this.zzamm.flip();
        this.zzalf = this.zzamm;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzb(int i, int i2, int i3) throws zzih {
        boolean z = !Arrays.equals(this.zzamj, this.zzaml);
        this.zzaml = this.zzamj;
        if (this.zzaml == null) {
            this.zzamk = false;
            return z;
        }
        if (i3 != 2) {
            throw new zzih(i, i2, i3);
        }
        if (!z && this.zzami == i && this.zzahm == i2) {
            return false;
        }
        this.zzami = i;
        this.zzahm = i2;
        this.zzamk = i2 != this.zzaml.length;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzaml;
            if (i4 >= iArr.length) {
                return true;
            }
            int i5 = iArr[i4];
            if (i5 >= i2) {
                throw new zzih(i, i2, i3);
            }
            this.zzamk = (i5 != i4) | this.zzamk;
            i4++;
        }
    }
}
