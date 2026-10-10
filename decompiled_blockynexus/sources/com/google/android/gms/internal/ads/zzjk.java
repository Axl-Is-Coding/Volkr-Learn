package com.google.android.gms.internal.ads;

import io.rong.imkit.utils.FileTypeUtils;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjk extends zzjh {
    public long zzaob;
    public ByteBuffer zzdd;
    public final zzjg zzaoa = new zzjg();
    private final int zzaoc = 0;

    public zzjk(int i) {
    }

    private final ByteBuffer zzaf(int i) {
        ByteBuffer byteBuffer = this.zzdd;
        int iCapacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(iCapacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzjh
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzdd;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean isEncrypted() {
        return zzad(FileTypeUtils.GIGABYTE);
    }

    public final void zzae(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzdd;
        if (byteBuffer == null) {
            zzaf(i);
            throw null;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = this.zzdd.position() + i;
        if (iCapacity >= iPosition) {
            return;
        }
        zzaf(iPosition);
        throw null;
    }
}
