package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoj implements zzom {
    private final byte[] data;
    private Uri uri;
    private int zzbia;
    private int zzbib;

    public zzoj(byte[] bArr) {
        zzoz.checkNotNull(bArr);
        zzoz.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final void close() throws IOException {
        this.uri = null;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbib;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbia, bArr, i, iMin);
        this.zzbia += iMin;
        this.zzbib -= iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzom
    public final long zza(zzon zzonVar) throws IOException {
        this.uri = zzonVar.uri;
        long j = zzonVar.position;
        this.zzbia = (int) j;
        long length = zzonVar.zzcp;
        if (length == -1) {
            length = ((long) this.data.length) - j;
        }
        this.zzbib = (int) length;
        int i = this.zzbib;
        if (i > 0 && this.zzbia + i <= this.data.length) {
            return i;
        }
        int i2 = this.zzbia;
        long j2 = zzonVar.zzcp;
        int length2 = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j2);
        sb.append("], length: ");
        sb.append(length2);
        throw new IOException(sb.toString());
    }
}
