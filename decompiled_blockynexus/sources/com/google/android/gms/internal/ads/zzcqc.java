package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcqc extends zzcpv {
    private String zzgkm;
    private int zzgkn = zzcqd.zzgko;

    public zzcqc(Context context) {
        this.zzgkh = new zzask(context, com.google.android.gms.ads.internal.zzp.zzlf().zzyj(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgkf) {
                this.zzgkf = true;
                try {
                    if (this.zzgkn == zzcqd.zzgkp) {
                        this.zzgkh.zzve().zzc(this.zzgkg, new zzcpy(this));
                    } else if (this.zzgkn == zzcqd.zzgkq) {
                        this.zzgkh.zzve().zza(this.zzgkm, new zzcpy(this));
                    } else {
                        this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdja.setException(new zzcqm(zzdpg.INTERNAL_ERROR));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
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

    public final zzdzc<InputStream> zzgm(String str) {
        synchronized (this.mLock) {
            if (this.zzgkn != zzcqd.zzgko && this.zzgkn != zzcqd.zzgkq) {
                return zzdyq.immediateFailedFuture(new zzcqm(zzdpg.INVALID_REQUEST));
            }
            if (this.zzgke) {
                return this.zzdja;
            }
            this.zzgkn = zzcqd.zzgkq;
            this.zzgke = true;
            this.zzgkm = str;
            this.zzgkh.checkAvailabilityAndConnect();
            this.zzdja.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcqe
                private final zzcqc zzgkl;

                {
                    this.zzgkl = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgkl.zzapz();
                }
            }, zzbbz.zzeeu);
            return this.zzdja;
        }
    }

    public final zzdzc<InputStream> zzk(zzatc zzatcVar) {
        synchronized (this.mLock) {
            if (this.zzgkn != zzcqd.zzgko && this.zzgkn != zzcqd.zzgkp) {
                return zzdyq.immediateFailedFuture(new zzcqm(zzdpg.INVALID_REQUEST));
            }
            if (this.zzgke) {
                return this.zzdja;
            }
            this.zzgkn = zzcqd.zzgkp;
            this.zzgke = true;
            this.zzgkg = zzatcVar;
            this.zzgkh.checkAvailabilityAndConnect();
            this.zzdja.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcqb
                private final zzcqc zzgkl;

                {
                    this.zzgkl = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgkl.zzapz();
                }
            }, zzbbz.zzeeu);
            return this.zzdja;
        }
    }
}
