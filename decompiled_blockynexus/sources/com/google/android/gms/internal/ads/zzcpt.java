package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpt extends zzcpv {
    public zzcpt(Context context) {
        this.zzgkh = new zzask(context, com.google.android.gms.ads.internal.zzp.zzlf().zzyj(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgkf) {
                this.zzgkf = true;
                try {
                    this.zzgkh.zzve().zza(this.zzgkg, new zzcpy(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcpv, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbbq.zzef("Cannot connect to remote service, fallback to local instance.");
        this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
    }

    public final zzdzc<InputStream> zzi(zzatc zzatcVar) {
        synchronized (this.mLock) {
            if (this.zzgke) {
                return this.zzdja;
            }
            this.zzgke = true;
            this.zzgkg = zzatcVar;
            this.zzgkh.checkAvailabilityAndConnect();
            this.zzdja.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcpw
                private final zzcpt zzgki;

                {
                    this.zzgki = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgki.zzapz();
                }
            }, zzbbz.zzeeu);
            return this.zzdja;
        }
    }
}
