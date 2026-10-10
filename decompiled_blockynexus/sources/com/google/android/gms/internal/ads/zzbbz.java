package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbz {
    public static final zzdzb zzeep;
    public static final zzdzb zzeeq;
    public static final zzdzb zzeer;
    public static final ScheduledExecutorService zzees;
    public static final zzdzb zzeet;
    public static final zzdzb zzeeu;

    static {
        ExecutorService executorServiceZza;
        ExecutorService executorServiceZzb;
        zzeep = zza(ClientLibraryUtils.isPackageSide() ? zzdvg.zzaxc().zza(zzfh("Default"), zzdvl.zzhov) : new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), zzfh("Default")));
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZza = zzdvg.zzaxc().zza(5, zzfh("Loader"), zzdvl.zzhou);
        } else {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfh("Loader"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            executorServiceZza = threadPoolExecutor;
        }
        zzeeq = zza(executorServiceZza);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZzb = zzdvg.zzaxc().zzb(zzfh("Activeview"), zzdvl.zzhou);
        } else {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfh("Activeview"));
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            executorServiceZzb = threadPoolExecutor2;
        }
        zzeer = zza(executorServiceZzb);
        zzees = new zzbby(3, zzfh(AppEventsConstants.EVENT_NAME_SCHEDULE));
        zzeet = zza(new zzbca());
        zzeeu = zza(zzdze.zzayh());
    }

    private static zzdzb zza(Executor executor) {
        return new zzbcd(executor, null);
    }

    private static ThreadFactory zzfh(String str) {
        return new zzbcb(str);
    }
}
