package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjc implements zzie {
    private ByteBuffer zzalf;
    private ByteBuffer zzamm;
    private boolean zzamn;
    private int zzami = -1;
    private int zzahm = -1;
    private int zzaka = 0;

    public zzjc() {
        ByteBuffer byteBuffer = zzie.zzaiy;
        this.zzamm = byteBuffer;
        this.zzalf = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void flush() {
        this.zzalf = zzie.zzaiy;
        this.zzamn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean isActive() {
        int i = this.zzaka;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void reset() {
        flush();
        this.zzamm = zzie.zzaiy;
        this.zzami = -1;
        this.zzahm = -1;
        this.zzaka = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzb(int i, int i2, int i3) throws zzih {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzih(i, i2, i3);
        }
        if (this.zzami == i && this.zzahm == i2 && this.zzaka == i3) {
            return false;
        }
        this.zzami = i;
        this.zzahm = i2;
        this.zzaka = i3;
        if (i3 != 2) {
            return true;
        }
        this.zzamm = zzie.zzaiy;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzfe() {
        return this.zzamn && this.zzalf == zzie.zzaiy;
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
        this.zzamn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.zzalf;
        this.zzalf = zzie.zzaiy;
        return byteBuffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081 A[ADDED_TO_REGION, LOOP:2: B:25:0x0081->B:26:0x0083, LOOP_START, PHI: r0
      0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:16:0x0041, B:26:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzie
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzn(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.zzaka
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L20
            if (r3 == r6) goto L21
            if (r3 != r4) goto L1a
            int r2 = r2 / 2
            goto L23
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L20:
            int r2 = r2 / r6
        L21:
            int r2 = r2 << 1
        L23:
            java.nio.ByteBuffer r3 = r7.zzamm
            int r3 = r3.capacity()
            if (r3 >= r2) goto L3a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.zzamm = r2
            goto L3f
        L3a:
            java.nio.ByteBuffer r2 = r7.zzamm
            r2.clear()
        L3f:
            int r2 = r7.zzaka
            if (r2 == r5) goto L81
            if (r2 == r6) goto L68
            if (r2 != r4) goto L62
        L47:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzamm
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamm
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L47
        L62:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L68:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzamm
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamm
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + (-128)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L68
        L81:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzamm
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzamm
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L81
        L9c:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.zzamm
            r8.flip()
            java.nio.ByteBuffer r8 = r7.zzamm
            r7.zzalf = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjc.zzn(java.nio.ByteBuffer):void");
    }
}
