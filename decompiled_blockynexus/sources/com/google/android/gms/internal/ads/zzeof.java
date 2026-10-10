package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeof extends zzeoe implements zzbp {
    private int flags;
    private int version;

    protected zzeof(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzito) {
            zzbkf();
        }
        return this.version;
    }

    protected final long zzr(ByteBuffer byteBuffer) {
        this.version = zzbq.zza(byteBuffer.get());
        this.flags = (zzbq.zzg(byteBuffer) << 8) + 0 + zzbq.zza(byteBuffer.get());
        return 4L;
    }
}
