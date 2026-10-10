package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzash implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzasf zzdqo;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdqp;

    zzash(zzasf zzasfVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdqo = zzasfVar;
        this.zzdqp = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.zzdqo.zza(thread, th);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdqp;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } catch (Throwable unused) {
                zzbbq.zzfc("AdMob exception reporter failed reporting the exception.");
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdqp;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.zzdqp;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
