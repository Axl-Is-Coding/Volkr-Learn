package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
@Deprecated
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    public interface PooledExecutorFactory {
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        if (zza == null) {
            zza = new zza();
        }
        return zza;
    }
}
