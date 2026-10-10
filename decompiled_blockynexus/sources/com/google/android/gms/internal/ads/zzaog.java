package com.google.android.gms.internal.ads;

import android.location.Location;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.sandboxol.center.config.VipSubscribeStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaog implements NativeMediationAdRequest {
    private final String zzado;
    private final int zzchc;
    private final boolean zzchn;
    private final int zzdlk;
    private final int zzdll;
    private final zzadu zzdly;
    private final List<String> zzdlz = new ArrayList();
    private final Map<String, Boolean> zzdma = new HashMap();
    private final Date zzmx;
    private final Set<String> zzmz;
    private final boolean zzna;
    private final Location zznb;

    public zzaog(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzadu zzaduVar, List<String> list, boolean z2, int i3, String str) {
        this.zzmx = date;
        this.zzchc = i;
        this.zzmz = set;
        this.zznb = location;
        this.zzna = z;
        this.zzdlk = i2;
        this.zzdly = zzaduVar;
        this.zzchn = z2;
        this.zzdll = i3;
        this.zzado = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] strArrSplit = str2.split(":", 3);
                    if (strArrSplit.length == 3) {
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(strArrSplit[2])) {
                            this.zzdma.put(strArrSplit[1], true);
                        } else if ("false".equals(strArrSplit[2])) {
                            this.zzdma.put(strArrSplit[1], false);
                        }
                    }
                } else {
                    this.zzdlz.add(str2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzzd.zzqw().zzqg();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.zzmx;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.zzchc;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzmz;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zznb;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        zzaak zzaakVar;
        if (this.zzdly == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzdly.zzddm).setImageOrientation(this.zzdly.zzbnn).setRequestMultipleImages(this.zzdly.zzbnp);
        zzadu zzaduVar = this.zzdly;
        if (zzaduVar.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(zzaduVar.zzbnq);
        }
        zzadu zzaduVar2 = this.zzdly;
        if (zzaduVar2.versionCode >= 3 && (zzaakVar = zzaduVar2.zzddn) != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(zzaakVar));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzzd.zzqw().zzqh();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdlz;
        if (list != null) {
            return list.contains("2") || this.zzdlz.contains(VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD);
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.zzdlz;
        if (list != null) {
            return list.contains("1") || this.zzdlz.contains(VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD);
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchn;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzna;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdlz;
        return list != null && list.contains(VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzdlk;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzuj() {
        List<String> list = this.zzdlz;
        return list != null && list.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzuk() {
        return this.zzdma;
    }
}
