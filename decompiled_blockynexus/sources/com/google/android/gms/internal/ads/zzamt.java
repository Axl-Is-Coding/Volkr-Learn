package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamt {
    private static zzamt zzdjg;
    private AtomicBoolean zzdjh = new AtomicBoolean(false);

    zzamt() {
    }

    private static void zza(Context context, AppMeasurementSdk appMeasurementSdk) {
        try {
            ((zzbis) zzbbt.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzamy.zzbxx)).zza(ObjectWrapper.wrap(context), new zzamu(appMeasurementSdk));
        } catch (RemoteException | zzbbv | NullPointerException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    static /* synthetic */ void zze(Context context, String str) {
        zzabb.initialize(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzwm.zzpx().zzd(zzabb.zzcns)).booleanValue());
        zza(context, AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle));
    }

    private static boolean zzn(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    static /* synthetic */ void zzo(Context context) {
        zzabb.initialize(context);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcnx)).booleanValue() && zzn(context)) {
            zza(context, AppMeasurementSdk.getInstance(context));
        }
    }

    public static zzamt zztr() {
        if (zzdjg == null) {
            zzdjg = new zzamt();
        }
        return zzdjg;
    }

    public final Thread zzd(final Context context, final String str) {
        if (!this.zzdjh.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable(this, context, str) { // from class: com.google.android.gms.internal.ads.zzamw
            private final Context zzckh;
            private final zzamt zzdjj;
            private final String zzdjk;

            {
                this.zzdjj = this;
                this.zzckh = context;
                this.zzdjk = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzamt.zze(this.zzckh, this.zzdjk);
            }
        });
        thread.start();
        return thread;
    }

    public final Thread zzm(final Context context) {
        if (!this.zzdjh.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.zzamv
            private final Context zzckh;
            private final zzamt zzdjj;

            {
                this.zzdjj = this;
                this.zzckh = context;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzamt.zzo(this.zzckh);
            }
        });
        thread.start();
        return thread;
    }
}
