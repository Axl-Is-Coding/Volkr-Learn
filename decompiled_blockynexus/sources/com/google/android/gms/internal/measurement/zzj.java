package com.google.android.gms.internal.measurement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzj {
    ExecutorService zza(int i);

    ExecutorService zza(ThreadFactory threadFactory, int i);
}
