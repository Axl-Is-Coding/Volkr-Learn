package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddj implements zzdgx<zzddg> {
    private final zzdzb zzgcz;
    private final Context zzvr;

    public zzddj(zzdzb zzdzbVar, Context context) {
        this.zzgcz = zzdzbVar;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzddg> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzddi
            private final zzddj zzgwd;

            {
                this.zzgwd = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwd.zzaro();
            }
        });
    }

    final /* synthetic */ zzddg zzaro() throws Exception {
        double d2;
        Intent intentRegisterReceiver = this.zzvr.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (intentRegisterReceiver != null) {
            int intExtra = intentRegisterReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
            double intExtra2 = intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            double intExtra3 = intentRegisterReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d2 = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d2 = -1.0d;
        }
        return new zzddg(d2, z);
    }
}
