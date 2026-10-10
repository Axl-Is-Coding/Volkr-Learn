package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzali extends zzbcn<zzalp> {
    private final Object lock = new Object();
    private final zzalm zzdhy;
    private boolean zzdhz;

    public zzali(zzalm zzalmVar) {
        this.zzdhy = zzalmVar;
    }

    public final void release() {
        synchronized (this.lock) {
            if (this.zzdhz) {
                return;
            }
            this.zzdhz = true;
            zza(new zzalh(this), new zzbcl());
            zza(new zzalk(this), new zzalj(this));
        }
    }
}
