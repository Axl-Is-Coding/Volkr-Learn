package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbgu extends FrameLayout implements zzbgj {
    private final zzbgj zzeof;
    private final zzbdn zzeog;
    private final AtomicBoolean zzeoh;

    public zzbgu(zzbgj zzbgjVar) {
        super(zzbgjVar.getContext());
        this.zzeoh = new AtomicBoolean();
        this.zzeof = zzbgjVar;
        this.zzeog = new zzbdn(zzbgjVar.zzabr(), this, this);
        if (zzacn()) {
            return;
        }
        addView(this.zzeof.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void destroy() {
        final IObjectWrapper iObjectWrapperZzaca = zzaca();
        if (iObjectWrapperZzaca == null) {
            this.zzeof.destroy();
            return;
        }
        zzayu.zzeba.post(new Runnable(iObjectWrapperZzaca) { // from class: com.google.android.gms.internal.ads.zzbgx
            private final IObjectWrapper zzeoj;

            {
                this.zzeoj = iObjectWrapperZzaca;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.zzp.zzlg().zzac(this.zzeoj);
            }
        });
        zzayu.zzeba.postDelayed(new zzbgw(this), ((Integer) zzwm.zzpx().zzd(zzabb.zzcud)).intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final String getRequestId() {
        return this.zzeof.getRequestId();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhs
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final WebView getWebView() {
        return this.zzeof.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean isDestroyed() {
        return this.zzeof.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void loadData(String str, String str2, String str3) {
        this.zzeof.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzeof.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void loadUrl(String str) {
        this.zzeof.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void onPause() {
        this.zzeog.onPause();
        this.zzeof.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void onResume() {
        this.zzeof.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgj
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeof.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgj
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzeof.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void setRequestedOrientation(int i) {
        this.zzeof.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzeof.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzeof.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, Map<String, ?> map) {
        this.zzeof.zza(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zzaaa() {
        this.zzeof.zzaaa();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzabp() {
        this.zzeof.zzabp();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzabq() {
        this.zzeof.zzabq();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final Context zzabr() {
        return this.zzeof.zzabr();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final com.google.android.gms.ads.internal.overlay.zze zzabs() {
        return this.zzeof.zzabs();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final com.google.android.gms.ads.internal.overlay.zze zzabt() {
        return this.zzeof.zzabt();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhr
    public final zzbhy zzabu() {
        return this.zzeof.zzabu();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final String zzabv() {
        return this.zzeof.zzabv();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final zzbhv zzabw() {
        return this.zzeof.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final WebViewClient zzabx() {
        return this.zzeof.zzabx();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzaby() {
        return this.zzeof.zzaby();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhq
    public final zzeg zzabz() {
        return this.zzeof.zzabz();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final IObjectWrapper zzaca() {
        return this.zzeof.zzaca();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhl
    public final boolean zzacb() {
        return this.zzeof.zzacb();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzacc() {
        this.zzeog.onDestroy();
        this.zzeof.zzacc();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzacd() {
        return this.zzeof.zzacd();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzace() {
        return this.zzeof.zzace();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzacf() {
        this.zzeof.zzacf();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzacg() {
        this.zzeof.zzacg();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final zzads zzach() {
        return this.zzeof.zzach();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzaci() {
        setBackgroundColor(0);
        this.zzeof.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzacj() {
        TextView textView = new TextView(getContext());
        Resources resources = com.google.android.gms.ads.internal.zzp.zzkv().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final zzsc zzack() {
        return this.zzeof.zzack();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzacl() {
        return this.zzeoh.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final zzsu zzacm() {
        return this.zzeof.zzacm();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzacn() {
        return this.zzeof.zzacn();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzal(boolean z) {
        this.zzeof.zzal(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzap(IObjectWrapper iObjectWrapper) {
        this.zzeof.zzap(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zzav(boolean z) {
        this.zzeof.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzax(boolean z) {
        this.zzeof.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzb(String str, zzahq<? super zzbgj> zzahqVar) {
        this.zzeof.zzb(str, zzahqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzba(boolean z) {
        this.zzeof.zzba(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzbb(boolean z) {
        this.zzeof.zzbb(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzbc(boolean z) {
        this.zzeof.zzbc(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzbw(Context context) {
        this.zzeof.zzbw(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzc(boolean z, int i) {
        if (!this.zzeoh.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcoe)).booleanValue()) {
            return false;
        }
        if (this.zzeof.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zzeof.getParent()).removeView(this.zzeof.getView());
        }
        return this.zzeof.zzc(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzdc(String str) {
        this.zzeof.zzdc(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzdu(int i) {
        this.zzeof.zzdu(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final zzbfl zzfj(String str) {
        return this.zzeof.zzfj(str);
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void zzkn() {
        this.zzeof.zzkn();
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final void zzko() {
        this.zzeof.zzko();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzuy() {
        this.zzeof.zzuy();
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zzuz() {
        this.zzeof.zzuz();
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final zzbdn zzzr() {
        return this.zzeog;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final zzbhd zzzs() {
        return this.zzeof.zzzs();
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final zzabq zzzt() {
        return this.zzeof.zzzt();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzbhi
    public final Activity zzzu() {
        return this.zzeof.zzzu();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final com.google.android.gms.ads.internal.zzb zzzv() {
        return this.zzeof.zzzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final zzabp zzzw() {
        return this.zzeof.zzzw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzbht
    public final zzbbx zzzx() {
        return this.zzeof.zzzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final int zzzy() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final int zzzz() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, JSONObject jSONObject) {
        this.zzeof.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzeof.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(String str, zzahq<? super zzbgj> zzahqVar) {
        this.zzeof.zza(str, zzahqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzb(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzeof.zzb(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(String str, Predicate<zzahq<? super zzbgj>> predicate) {
        this.zzeof.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzb(String str, String str2, String str3) {
        this.zzeof.zzb(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zza(boolean z, long j) {
        this.zzeof.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zzb(boolean z, int i) {
        this.zzeof.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzeof.zza(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(zzbhy zzbhyVar) {
        this.zzeof.zza(zzbhyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final void zza(String str, zzbfl zzbflVar) {
        this.zzeof.zza(str, zzbflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(zzadn zzadnVar) {
        this.zzeof.zza(zzadnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(zzsc zzscVar) {
        this.zzeof.zza(zzscVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqrVar) {
        this.zzeof.zza(zzqrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(zzads zzadsVar) {
        this.zzeof.zza(zzadsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final void zza(zzbhd zzbhdVar) {
        this.zzeof.zza(zzbhdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        this.zzeof.zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(boolean z, int i, String str) {
        this.zzeof.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzeof.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.zzeof.zza(this, activity, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(zzdnv zzdnvVar, zzdnw zzdnwVar) {
        this.zzeof.zza(zzdnvVar, zzdnwVar);
    }
}
