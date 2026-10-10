package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-base@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeib extends zzehx {
    private final zzeia zziea = new zzeia();

    zzeib() {
    }

    @Override // com.google.android.gms.internal.ads.zzehx
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.zziea.zza(th, true).add(th2);
    }

    @Override // com.google.android.gms.internal.ads.zzehx
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> listZza = this.zziea.zza(th, false);
        if (listZza == null) {
            return;
        }
        synchronized (listZza) {
            for (Throwable th2 : listZza) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }
}
