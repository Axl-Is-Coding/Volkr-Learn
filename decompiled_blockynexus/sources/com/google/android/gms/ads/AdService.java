package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzaqp;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzwm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class AdService extends IntentService {
    private final zzaqp zzacw;

    public AdService() {
        super("AdService");
        this.zzacw = zzwm.zzpu().zzb(this, new zzanc());
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            this.zzacw.zzc(intent);
        } catch (RemoteException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 50);
            sb.append("RemoteException calling handleNotificationIntent: ");
            sb.append(strValueOf);
            zzbbq.zzfc(sb.toString());
        }
    }
}
