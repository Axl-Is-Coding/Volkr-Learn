package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaye {

    @VisibleForTesting
    private final String zzdzq;
    private final zzayr zzdzr;

    @VisibleForTesting
    private long zzdzl = -1;

    @VisibleForTesting
    private long zzdzm = -1;

    @VisibleForTesting
    private int zzdzn = -1;

    @VisibleForTesting
    int zzdzo = -1;

    @VisibleForTesting
    private long zzdzp = 0;
    private final Object lock = new Object();

    @VisibleForTesting
    private int zzdzs = 0;

    @VisibleForTesting
    private int zzdzt = 0;

    public zzaye(String str, zzayr zzayrVar) {
        this.zzdzq = str;
        this.zzdzr = zzayrVar;
    }

    private static boolean zzan(Context context) {
        Context contextZzab = zzatx.zzab(context);
        int identifier = contextZzab.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
        if (identifier == 0) {
            zzbbq.zzfd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == contextZzab.getPackageManager().getActivityInfo(new ComponentName(contextZzab.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzbbq.zzfd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzbbq.zzfe("Fail to fetch AdActivity theme");
            zzbbq.zzfd("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final void zza(zzvg zzvgVar, long j) {
        synchronized (this.lock) {
            long jZzxl = this.zzdzr.zzxl();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
            if (this.zzdzm == -1) {
                if (jCurrentTimeMillis - jZzxl > ((Long) zzwm.zzpx().zzd(zzabb.zzcop)).longValue()) {
                    this.zzdzo = -1;
                } else {
                    this.zzdzo = this.zzdzr.zzxm();
                }
                this.zzdzm = j;
                this.zzdzl = this.zzdzm;
            } else {
                this.zzdzl = j;
            }
            if (zzvgVar == null || zzvgVar.extras == null || zzvgVar.extras.getInt("gw", 2) != 1) {
                this.zzdzn++;
                this.zzdzo++;
                if (this.zzdzo == 0) {
                    this.zzdzp = 0L;
                    this.zzdzr.zzfa(jCurrentTimeMillis);
                } else {
                    this.zzdzp = jCurrentTimeMillis - this.zzdzr.zzxn();
                }
            }
        }
    }

    public final Bundle zzp(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzdzq);
            bundle.putLong("basets", this.zzdzm);
            bundle.putLong("currts", this.zzdzl);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzdzn);
            bundle.putInt("preqs_in_session", this.zzdzo);
            bundle.putLong("time_in_session", this.zzdzp);
            bundle.putInt("pclick", this.zzdzs);
            bundle.putInt("pimp", this.zzdzt);
            bundle.putBoolean("support_transparent_background", zzan(context));
        }
        return bundle;
    }

    public final void zzwa() {
        synchronized (this.lock) {
            this.zzdzt++;
        }
    }

    public final void zzwb() {
        synchronized (this.lock) {
            this.zzdzs++;
        }
    }
}
