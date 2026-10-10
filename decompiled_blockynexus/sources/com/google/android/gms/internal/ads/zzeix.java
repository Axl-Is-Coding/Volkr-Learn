package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeix {
    private final byte[] buffer;
    private final zzejj zziew;

    private zzeix(int i) {
        this.buffer = new byte[i];
        this.zziew = zzejj.zzw(this.buffer);
    }

    public final zzeip zzben() {
        this.zziew.zzbfq();
        return new zzeiz(this.buffer);
    }

    public final zzejj zzbeo() {
        return this.zziew;
    }

    /* synthetic */ zzeix(int i, zzeio zzeioVar) {
        this(i);
    }
}
