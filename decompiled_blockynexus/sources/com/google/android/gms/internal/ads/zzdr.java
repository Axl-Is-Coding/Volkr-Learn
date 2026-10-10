package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdr implements Runnable {
    private final /* synthetic */ zzdp zzwd;

    zzdr(zzdp zzdpVar) {
        this.zzwd = zzdpVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        synchronized (this.zzwd.zzwb) {
            if (this.zzwd.zzwc) {
                return;
            }
            this.zzwd.zzwc = true;
            try {
                this.zzwd.zzbs();
            } catch (Exception e2) {
                this.zzwd.zzvw.zza(2023, -1L, e2);
            }
            synchronized (this.zzwd.zzwb) {
                this.zzwd.zzwc = false;
            }
        }
    }
}
