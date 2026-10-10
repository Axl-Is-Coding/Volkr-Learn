package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdt implements Runnable {
    private final /* synthetic */ zzdu zzwf;

    zzdt(zzdu zzduVar) {
        this.zzwf = zzduVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        if (this.zzwf.zzwj != null) {
            return;
        }
        synchronized (zzdu.zzwh) {
            if (this.zzwf.zzwj != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = zzabb.zzcqs.get().booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzdu.zzwi = new zztx(this.zzwf.zzwg.zzvr, "ADSHIELD", null);
                    z = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z = zBooleanValue;
            }
            this.zzwf.zzwj = Boolean.valueOf(z);
            zzdu.zzwh.open();
        }
    }
}
