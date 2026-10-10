package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzdtm implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzedb = new HandlerThread("GassClient");

    @VisibleForTesting
    private zzduk zzhmj;
    private final String zzhmk;
    private final LinkedBlockingQueue<zzcf.zza> zzhml;

    public zzdtm(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhmk = str2;
        this.zzedb.start();
        this.zzhmj = new zzduk(context, this.zzedb.getLooper(), this, this, 9200000);
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
    private static zzcf.zza zzavy() {
        return (zzcf.zza) zzcf.zza.zzaq().zzn(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbgt();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzdun zzdunVarZzavx = zzavx();
        try {
            if (zzdunVarZzavx != null) {
                try {
                    try {
                        this.zzhml.put(zzdunVarZzavx.zza(new zzduj(this.packageName, this.zzhmk)).zzawn());
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable unused2) {
                    this.zzhml.put(zzavy());
                }
            }
        } finally {
            zzapz();
            this.zzedb.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhml.put(zzavy());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            this.zzhml.put(zzavy());
        } catch (InterruptedException unused) {
        }
    }

    public final zzcf.zza zzee(int i) {
        zzcf.zza zzaVarPoll;
        try {
            zzaVarPoll = this.zzhml.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzaVarPoll = null;
        }
        return zzaVarPoll == null ? zzavy() : zzaVarPoll;
    }
}
