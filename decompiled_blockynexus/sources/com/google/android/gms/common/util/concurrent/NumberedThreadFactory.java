package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class NumberedThreadFactory implements ThreadFactory {
    private final String zza;
    private final int zzb;
    private final AtomicInteger zzc;
    private final ThreadFactory zzd;

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.zzd.newThread(new zza(runnable, 0));
        String str = this.zza;
        int andIncrement = this.zzc.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        threadNewThread.setName(sb.toString());
        return threadNewThread;
    }

    private NumberedThreadFactory(String str, int i) {
        this.zzc = new AtomicInteger();
        this.zzd = Executors.defaultThreadFactory();
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
        this.zzb = 0;
    }
}
