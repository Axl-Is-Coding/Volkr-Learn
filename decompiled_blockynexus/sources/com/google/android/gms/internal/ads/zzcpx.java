package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpx extends zzcpv {
    public zzcpx(Context context) {
        this.zzgkh = new zzask(context, com.google.android.gms.ads.internal.zzp.zzlf().zzyj(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgkf) {
                this.zzgkf = true;
                try {
                    this.zzgkh.zzve().zzb(this.zzgkg, new zzcpy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
                }
            }
        }
    }

    public final zzdzc<InputStream> zzj(zzatc zzatcVar) {
        synchronized (this.mLock) {
            if (this.zzgke) {
                return this.zzdja;
            }
            this.zzgke = true;
            this.zzgkg = zzatcVar;
            this.zzgkh.checkAvailabilityAndConnect();
            this.zzdja.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcqa
                private final zzcpx zzgkk;

                {
                    this.zzgkk = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgkk.zzapz();
                }
            }, zzbbz.zzeeu);
            return this.zzdja;
        }
    }
}
