package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public interface zzbgj extends com.google.android.gms.ads.internal.zzk, zzajr, zzaks, zzbdu, zzbfy, zzbhi, zzbhl, zzbhp, zzbhq, zzbhs, zzbht, zzqu {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzbhi
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    @Override // com.google.android.gms.internal.ads.zzbhs
    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbdu
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(ViewGroup viewGroup, Activity activity, String str, String str2);

    void zza(com.google.android.gms.ads.internal.overlay.zze zzeVar);

    void zza(zzadn zzadnVar);

    void zza(zzads zzadsVar);

    @Override // com.google.android.gms.internal.ads.zzbdu
    void zza(zzbhd zzbhdVar);

    void zza(zzbhy zzbhyVar);

    void zza(zzdnv zzdnvVar, zzdnw zzdnwVar);

    void zza(zzsc zzscVar);

    void zza(String str, Predicate<zzahq<? super zzbgj>> predicate);

    void zza(String str, zzahq<? super zzbgj> zzahqVar);

    @Override // com.google.android.gms.internal.ads.zzbdu
    void zza(String str, zzbfl zzbflVar);

    void zzabp();

    void zzabq();

    Context zzabr();

    com.google.android.gms.ads.internal.overlay.zze zzabs();

    com.google.android.gms.ads.internal.overlay.zze zzabt();

    @Override // com.google.android.gms.internal.ads.zzbhr
    zzbhy zzabu();

    String zzabv();

    zzbhv zzabw();

    WebViewClient zzabx();

    boolean zzaby();

    @Override // com.google.android.gms.internal.ads.zzbhq
    zzeg zzabz();

    IObjectWrapper zzaca();

    @Override // com.google.android.gms.internal.ads.zzbhl
    boolean zzacb();

    void zzacc();

    boolean zzacd();

    boolean zzace();

    void zzacf();

    void zzacg();

    zzads zzach();

    void zzaci();

    void zzacj();

    zzsc zzack();

    boolean zzacl();

    zzsu zzacm();

    boolean zzacn();

    void zzal(boolean z);

    void zzap(IObjectWrapper iObjectWrapper);

    void zzax(boolean z);

    void zzb(com.google.android.gms.ads.internal.overlay.zze zzeVar);

    void zzb(String str, zzahq<? super zzbgj> zzahqVar);

    void zzb(String str, String str2, String str3);

    void zzba(boolean z);

    void zzbb(boolean z);

    void zzbc(boolean z);

    void zzbw(Context context);

    boolean zzc(boolean z, int i);

    void zzdu(int i);

    void zzuy();

    @Override // com.google.android.gms.internal.ads.zzbdu
    zzbhd zzzs();

    @Override // com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzbhi
    Activity zzzu();

    @Override // com.google.android.gms.internal.ads.zzbdu
    com.google.android.gms.ads.internal.zzb zzzv();

    @Override // com.google.android.gms.internal.ads.zzbdu
    zzabp zzzw();

    @Override // com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzbht
    zzbbx zzzx();
}
