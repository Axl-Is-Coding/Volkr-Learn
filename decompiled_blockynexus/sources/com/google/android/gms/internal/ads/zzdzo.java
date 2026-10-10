package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzo<V> implements Runnable {
    private zzdzm<V> zzhtw;

    zzdzo(zzdzm<V> zzdzmVar) {
        this.zzhtw = zzdzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdzc<? extends V> zzdzcVar;
        zzdzm<V> zzdzmVar = this.zzhtw;
        if (zzdzmVar == null || (zzdzcVar = ((zzdzm) zzdzmVar).zzhtu) == null) {
            return;
        }
        this.zzhtw = null;
        if (zzdzcVar.isDone()) {
            zzdzmVar.setFuture(zzdzcVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = ((zzdzm) zzdzmVar).zzhtv;
            zzdzm.zza((zzdzm) zzdzmVar, (ScheduledFuture) null);
            String string = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        StringBuilder sb = new StringBuilder("Timed out".length() + 66);
                        sb.append("Timed out");
                        sb.append(" (timeout delayed by ");
                        sb.append(jAbs);
                        sb.append(" ms after scheduled time)");
                        string = sb.toString();
                    }
                } catch (Throwable th) {
                    zzdzmVar.setException(new zzdzn(string));
                    throw th;
                }
            }
            String strValueOf = String.valueOf(string);
            String strValueOf2 = String.valueOf(zzdzcVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 2 + String.valueOf(strValueOf2).length());
            sb2.append(strValueOf);
            sb2.append(": ");
            sb2.append(strValueOf2);
            zzdzmVar.setException(new zzdzn(sb2.toString()));
        } finally {
            zzdzcVar.cancel(true);
        }
    }
}
