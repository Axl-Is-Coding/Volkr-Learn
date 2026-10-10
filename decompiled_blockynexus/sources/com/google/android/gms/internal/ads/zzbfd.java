package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbfd {
    private long zzdh;

    public final long zzq(ByteBuffer byteBuffer) {
        zzbu zzbuVar;
        zzbr zzbrVar;
        long j = this.zzdh;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator<zzbp> it = new zzbn(new zzbfa(byteBufferDuplicate), zzbff.zzelj).zzbkg().iterator();
            while (true) {
                zzbuVar = null;
                if (!it.hasNext()) {
                    zzbrVar = null;
                    break;
                }
                zzbp next = it.next();
                if (next instanceof zzbr) {
                    zzbrVar = (zzbr) next;
                    break;
                }
            }
            Iterator<zzbp> it2 = zzbrVar.zzbkg().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbp next2 = it2.next();
                if (next2 instanceof zzbu) {
                    zzbuVar = (zzbu) next2;
                    break;
                }
            }
            this.zzdh = (zzbuVar.getDuration() * 1000) / zzbuVar.zzr();
            return this.zzdh;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
