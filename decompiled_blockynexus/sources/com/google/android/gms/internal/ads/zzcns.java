package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcns implements AppEventListener, zzbuh, zzbui, zzbuy, zzbuz, zzbvs, zzbws, zzdso, zzux {
    private long startTime;
    private final List<Object> zzeeg;
    private final zzcng zzgib;

    public zzcns(zzcng zzcngVar, zzbix zzbixVar) {
        this.zzgib = zzcngVar;
        this.zzeeg = Collections.singletonList(zzbixVar);
    }

    @Override // com.google.android.gms.internal.ads.zzux
    public final void onAdClicked() {
        zza(zzux.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdClosed() {
        zza(zzbuh.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final void onAdImpression() {
        zza(zzbuz.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdLeftApplication() {
        zza(zzbuh.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(jElapsedRealtime);
        zzayp.zzei(sb.toString());
        zza(zzbvs.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdOpened() {
        zza(zzbuh.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zza(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
        zza(zzbuh.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
        zza(zzbuh.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str) {
        zza(zzdsg.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(zzatw zzatwVar, String str, String str2) {
        zza(zzbuh.class, "onRewarded", zzatwVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzb(zzdog zzdogVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzc(zzdsf zzdsfVar, String str) {
        zza(zzdsg.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzca(Context context) {
        zza(zzbuy.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcb(Context context) {
        zza(zzbuy.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzcc(Context context) {
        zza(zzbuy.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(zzatc zzatcVar) {
        this.startTime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
        zza(zzbws.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(zzva zzvaVar) {
        zza(zzbui.class, "onAdFailedToLoad", Integer.valueOf(zzvaVar.errorCode), zzvaVar.zzcgw, zzvaVar.zzcgx);
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str, Throwable th) {
        zza(zzdsg.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzb(zzdsf zzdsfVar, String str) {
        zza(zzdsg.class, "onTaskStarted", str);
    }

    private final void zza(Class<?> cls, String str, Object... objArr) {
        zzcng zzcngVar = this.zzgib;
        List<Object> list = this.zzeeg;
        String strValueOf = String.valueOf(cls.getSimpleName());
        zzcngVar.zza(list, strValueOf.length() != 0 ? "Event-".concat(strValueOf) : new String("Event-"), str, objArr);
    }
}
