package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzazu {
    private final Object lock = new Object();
    private String zzebw = "";
    private String zzebx = "";
    private boolean zzeby = false;

    @VisibleForTesting
    private String zzebz = "";

    private final String zzbj(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzebw)) {
                com.google.android.gms.ads.internal.zzp.zzkr();
                this.zzebw = zzayu.zzt(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.zzebw)) {
                    com.google.android.gms.ads.internal.zzp.zzkr();
                    this.zzebw = zzayu.zzxs();
                    com.google.android.gms.ads.internal.zzp.zzkr();
                    zzayu.zzc(context, "debug_signals_id.txt", this.zzebw);
                }
            }
            str = this.zzebw;
        }
        return str;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = zzd(context, (String) zzwm.zzpx().zzd(zzabb.zzctp), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zzb(context, str, builderBuildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("linkedDeviceId", zzbj(context));
        builderBuildUpon.appendQueryParameter("adSlotPath", str2);
        builderBuildUpon.appendQueryParameter("afmaVersion", str3);
        return builderBuildUpon.build();
    }

    @VisibleForTesting
    private final boolean zzf(Context context, String str, String str2) {
        String strZzh = zzh(context, zzd(context, (String) zzwm.zzpx().zzd(zzabb.zzctn), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strZzh)) {
            zzbbq.zzef("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strZzh.trim());
            String strOptString = jSONObject.optString("gct");
            this.zzebz = jSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            synchronized (this.lock) {
                this.zzebx = strOptString;
            }
            return true;
        } catch (JSONException e2) {
            zzbbq.zzd("Fail to get in app preview response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String strZzh = zzh(context, zzd(context, (String) zzwm.zzpx().zzd(zzabb.zzcto), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strZzh)) {
            zzbbq.zzef("Not linked for debug signals.");
            return false;
        }
        try {
            boolean zEquals = "1".equals(new JSONObject(strZzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzeby = zEquals;
            }
            return zEquals;
        } catch (JSONException e2) {
            zzbbq.zzd("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzh(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put(AbstractSpiCall.HEADER_USER_AGENT, com.google.android.gms.ads.internal.zzp.zzkr().zzs(context, str2));
        zzdzc<String> zzdzcVarZzc = new zzbag(context).zzc(str, map);
        try {
            return zzdzcVarZzc.get(((Integer) zzwm.zzpx().zzd(zzabb.zzctq)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            String strValueOf = String.valueOf(str);
            zzbbq.zzc(strValueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(strValueOf) : new String("Interrupted while retriving a response from: "), e2);
            zzdzcVarZzc.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            String strValueOf2 = String.valueOf(str);
            zzbbq.zzc(strValueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(strValueOf2) : new String("Timeout while retriving a response from: "), e3);
            zzdzcVarZzc.cancel(true);
            return null;
        } catch (Exception e4) {
            String strValueOf3 = String.valueOf(str);
            zzbbq.zzc(strValueOf3.length() != 0 ? "Error retriving a response from: ".concat(strValueOf3) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zza(context, zzd(context, (String) zzwm.zzpx().zzd(zzabb.zzctm), str, str2));
    }

    public final void zza(Context context, String str, String str2, String str3) {
        boolean zZzyg = zzyg();
        if (!zzg(context, str, str2)) {
            zzi(context, str, str2);
            return;
        }
        if (!zZzyg && !TextUtils.isEmpty(str3)) {
            zzc(context, str2, str3, str);
        }
        zzbbq.zzef("Device is linked for debug signals.");
        zza(context, "The device is successfully linked for troubleshooting.", false, true);
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !com.google.android.gms.ads.internal.zzp.zzlb().zzyg()) {
            return false;
        }
        zzbbq.zzef("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
            return;
        }
        if ("2".equals(this.zzebz)) {
            zzbbq.zzef("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzebz)) {
            zzbbq.zzef("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if ("0".equals(this.zzebz)) {
            zzbbq.zzef("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String zzyf() {
        String str;
        synchronized (this.lock) {
            str = this.zzebx;
        }
        return str;
    }

    public final boolean zzyg() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeby;
        }
        return z;
    }

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzbbq.zzfd("Can not create dialog without Activity Context");
        } else {
            zzayu.zzeba.post(new zzazx(this, context, str, z, z2));
        }
    }
}
