package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzn extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzj zzbpm;

    private zzn(zzj zzjVar) {
        this.zzbpm = zzjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String doInBackground(Void... voidArr) {
        try {
            this.zzbpm.zzbpk = (zzeg) this.zzbpm.zzbpg.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzbbq.zzd("", e2);
        }
        return this.zzbpm.zzkl();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        if (this.zzbpm.zzbpi == null || str2 == null) {
            return;
        }
        this.zzbpm.zzbpi.loadUrl(str2);
    }

    /* synthetic */ zzn(zzj zzjVar, zzm zzmVar) {
        this(zzjVar);
    }
}
