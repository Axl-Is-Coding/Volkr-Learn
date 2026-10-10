package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzdto implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final long startTime;

    @VisibleForTesting
    private zzduk zzhmj;
    private final LinkedBlockingQueue<zzduv> zzhml;
    private final String zzhmn;
    private final String zzhmo;
    private final zzdtc zzvw;
    private final zzgo zzvy;
    private final int zzhmp = 1;
    private final HandlerThread zzedb = new HandlerThread("GassDGClient");

    public zzdto(Context context, int i, zzgo zzgoVar, String str, String str2, String str3, zzdtc zzdtcVar) {
        this.zzhmn = str;
        this.zzvy = zzgoVar;
        this.zzhmo = str2;
        this.zzvw = zzdtcVar;
        this.zzedb.start();
        this.startTime = System.currentTimeMillis();
        this.zzhmj = new zzduk(context, this.zzedb.getLooper(), this, this, 19621000);
        this.zzhml = new LinkedBlockingQueue<>();
        this.zzhmj.checkAvailabilityAndConnect();
    }

    private final void zzapz() {
        zzduk zzdukVar = this.zzhmj;
        if (zzdukVar != null) {
            if (zzdukVar.isConnected() || this.zzhmj.isConnecting()) {
                this.zzhmj.disconnect();
            }
        }
    }

    private final zzdun zzavx() {
        try {
            return this.zzhmj.zzawm();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static zzduv zzavz() {
        return new zzduv(null, 1);
    }

    private final void zzb(int i, long j, Exception exc) {
        zzdtc zzdtcVar = this.zzvw;
        if (zzdtcVar != null) {
            zzdtcVar.zza(i, System.currentTimeMillis() - j, exc);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdun zzdunVarZzavx = zzavx();
        if (zzdunVarZzavx != null) {
            try {
                zzduv zzduvVarZza = zzdunVarZzavx.zza(new zzdut(this.zzhmp, this.zzvy, this.zzhmn, this.zzhmo));
                zzb(5011, this.startTime, null);
                this.zzhml.put(zzduvVarZza);
            } catch (Throwable th) {
                zzb(2010, this.startTime, new Exception(th));
            } finally {
                zzapz();
                this.zzedb.quit();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzb(4012, this.startTime, null);
            this.zzhml.put(zzavz());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            zzb(4011, this.startTime, null);
            this.zzhml.put(zzavz());
        } catch (InterruptedException unused) {
        }
    }

    public final zzduv zzef(int i) {
        zzduv zzduvVarPoll;
        try {
            zzduvVarPoll = this.zzhml.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            zzb(AdError.INTERSTITIAL_AD_TIMEOUT, this.startTime, e2);
            zzduvVarPoll = null;
        }
        zzb(AuthApiStatusCodes.AUTH_TOKEN_ERROR, this.startTime, null);
        if (zzduvVarPoll != null) {
            if (zzduvVarPoll.status == 7) {
                zzdtc.zzb(zzbw.zza.zzc.DISABLED);
            } else {
                zzdtc.zzb(zzbw.zza.zzc.ENABLED);
            }
        }
        return zzduvVarPoll == null ? zzavz() : zzduvVarPoll;
    }
}
