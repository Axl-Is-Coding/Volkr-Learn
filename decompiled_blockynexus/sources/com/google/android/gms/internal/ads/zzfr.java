package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzcf;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfr extends zzgm {
    public zzfr(zzex zzexVar, String str, String str2, zzcf.zza.C0108zza c0108zza, int i, int i2) {
        super(zzexVar, str, str2, c0108zza, i, 24);
    }

    private final void zzcz() {
        AdvertisingIdClient advertisingIdClientZzcs = this.zzwg.zzcs();
        if (advertisingIdClientZzcs == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info info = advertisingIdClientZzcs.getInfo();
            String strZzar = zzfg.zzar(info.getId());
            if (strZzar != null) {
                synchronized (this.zzabc) {
                    this.zzabc.zzac(strZzar);
                    this.zzabc.zza(info.isLimitAdTrackingEnabled());
                    this.zzabc.zza(zzcf.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgm
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzwg.zzck()) {
            zzcz();
            return;
        }
        synchronized (this.zzabc) {
            this.zzabc.zzac((String) this.zzabm.invoke(null, this.zzwg.getContext()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgm, java.util.concurrent.Callable
    /* JADX INFO: renamed from: zzcy */
    public final Void call() throws Exception {
        if (this.zzwg.isInitialized()) {
            return super.call();
        }
        if (!this.zzwg.zzck()) {
            return null;
        }
        zzcz();
        return null;
    }
}
