package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbdx {
    private final zzbbx zzdqm;
    private final String zzdrb;
    private final zzabs zzegj;
    private boolean zzegn;
    private final zzabq zzeja;
    private final long[] zzejc;
    private final String[] zzejd;
    private zzbdf zzeji;
    private boolean zzejj;
    private boolean zzejk;
    private final Context zzvr;
    private final zzbac zzejb = new zzbah().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzyi();
    private boolean zzeje = false;
    private boolean zzejf = false;
    private boolean zzejg = false;
    private boolean zzejh = false;
    private long zzejl = -1;

    public zzbdx(Context context, zzbbx zzbbxVar, String str, zzabs zzabsVar, zzabq zzabqVar) {
        this.zzvr = context;
        this.zzdqm = zzbbxVar;
        this.zzdrb = str;
        this.zzegj = zzabsVar;
        this.zzeja = zzabqVar;
        String str2 = (String) zzwm.zzpx().zzd(zzabb.zzcmm);
        if (str2 == null) {
            this.zzejd = new String[0];
            this.zzejc = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        this.zzejd = new String[strArrSplit.length];
        this.zzejc = new long[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.zzejc[i] = Long.parseLong(strArrSplit[i]);
            } catch (NumberFormatException e2) {
                zzbbq.zzd("Unable to parse frame hash target time number.", e2);
                this.zzejc[i] = -1;
            }
        }
    }

    public final void onStop() {
        if (!zzadi.zzdcv.get().booleanValue() || this.zzejj) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.zzdrb);
        bundle.putString("player", this.zzeji.zzyx());
        for (zzbae zzbaeVar : this.zzejb.zzyh()) {
            String strValueOf = String.valueOf(zzbaeVar.name);
            bundle.putString(strValueOf.length() != 0 ? "fps_c_".concat(strValueOf) : new String("fps_c_"), Integer.toString(zzbaeVar.count));
            String strValueOf2 = String.valueOf(zzbaeVar.name);
            bundle.putString(strValueOf2.length() != 0 ? "fps_p_".concat(strValueOf2) : new String("fps_p_"), Double.toString(zzbaeVar.zzecl));
        }
        int i = 0;
        while (true) {
            long[] jArr = this.zzejc;
            if (i >= jArr.length) {
                com.google.android.gms.ads.internal.zzp.zzkr().zza(this.zzvr, this.zzdqm.zzbre, "gmob-apps", bundle, true);
                this.zzejj = true;
                return;
            }
            String str = this.zzejd[i];
            if (str != null) {
                String strValueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf3).length() + 3);
                sb.append("fh_");
                sb.append(strValueOf3);
                bundle.putString(sb.toString(), str);
            }
            i++;
        }
    }

    public final void zzaac() {
        this.zzegn = true;
        if (!this.zzejf || this.zzejg) {
            return;
        }
        zzabj.zza(this.zzegj, this.zzeja, "vfp2");
        this.zzejg = true;
    }

    public final void zzaad() {
        this.zzegn = false;
    }

    public final void zzb(zzbdf zzbdfVar) {
        zzabj.zza(this.zzegj, this.zzeja, "vpc2");
        this.zzeje = true;
        zzabs zzabsVar = this.zzegj;
        if (zzabsVar != null) {
            zzabsVar.zzh("vpn", zzbdfVar.zzyx());
        }
        this.zzeji = zzbdfVar;
    }

    public final void zzc(zzbdf zzbdfVar) {
        if (this.zzejg && !this.zzejh) {
            if (zzayp.zzxa() && !this.zzejh) {
                zzayp.zzei("VideoMetricsMixin first frame");
            }
            zzabj.zza(this.zzegj, this.zzeja, "vff2");
            this.zzejh = true;
        }
        long jNanoTime = com.google.android.gms.ads.internal.zzp.zzky().nanoTime();
        if (this.zzegn && this.zzejk && this.zzejl != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d2 = jNanoTime - this.zzejl;
            Double.isNaN(nanos);
            Double.isNaN(d2);
            this.zzejb.zza(nanos / d2);
        }
        this.zzejk = this.zzegn;
        this.zzejl = jNanoTime;
        long jLongValue = ((Long) zzwm.zzpx().zzd(zzabb.zzcmn)).longValue();
        long currentPosition = zzbdfVar.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzejd;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && jLongValue > Math.abs(currentPosition - this.zzejc[i])) {
                String[] strArr2 = this.zzejd;
                int i2 = 8;
                Bitmap bitmap = zzbdfVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j = j3;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
            i++;
        }
    }

    public final void zzfb() {
        if (!this.zzeje || this.zzejf) {
            return;
        }
        zzabj.zza(this.zzegj, this.zzeja, "vfr2");
        this.zzejf = true;
    }
}
