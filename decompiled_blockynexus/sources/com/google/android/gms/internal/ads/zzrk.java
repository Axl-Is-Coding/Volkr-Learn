package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public final class zzrk extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbsf;
    private final int zzbsh;
    private final boolean zzbsi;
    private boolean zzbtf;
    private boolean zzbtg;
    private final zzrd zzbth;
    private final int zzbti;
    private final int zzbtj;
    private final int zzbtk;
    private final int zzbtl;
    private final int zzbtm;
    private final int zzbtn;
    private final String zzbto;
    private final boolean zzbtp;
    private final boolean zzbtq;

    public zzrk() {
        this(new zzrd());
    }

    @VisibleForTesting
    private final zzro zza(View view, zzre zzreVar) {
        boolean z;
        if (view == null) {
            return new zzro(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzro(this, 0, 0);
            }
            zzreVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzro(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzbgj)) {
            WebView webView = (WebView) view;
            if (PlatformVersion.isAtLeastKitKat()) {
                zzreVar.zzme();
                webView.post(new zzrm(this, zzreVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            return z ? new zzro(this, 0, 1) : new zzro(this, 0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzro(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zzro zzroVarZza = zza(viewGroup.getChildAt(i3), zzreVar);
            i += zzroVarZza.zzbtx;
            i2 += zzroVarZza.zzbty;
        }
        return new zzro(this, i, i2);
    }

    @VisibleForTesting
    private static boolean zzmj() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context context = com.google.android.gms.ads.internal.zzp.zzku().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzml() {
        synchronized (this.lock) {
            this.zzbtf = true;
            boolean z = this.zzbtf;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzbbq.zzef(sb.toString());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (zzmj()) {
                    Activity activity = com.google.android.gms.ads.internal.zzp.zzku().getActivity();
                    if (activity == null) {
                        zzbbq.zzef("ContentFetchThread: no activity. Sleeping.");
                        zzml();
                    } else if (activity != null) {
                        View viewFindViewById = null;
                        try {
                            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                                viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
                            }
                        } catch (Exception e2) {
                            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "ContentFetchTask.extractContent");
                            zzbbq.zzef("Failed getting root view of activity. Content not extracted.");
                        }
                        if (viewFindViewById != null && viewFindViewById != null) {
                            viewFindViewById.post(new zzrj(this, viewFindViewById));
                        }
                    }
                } else {
                    zzbbq.zzef("ContentFetchTask: sleeping");
                    zzml();
                }
                Thread.sleep(this.zzbti * 1000);
            } catch (InterruptedException e3) {
                zzbbq.zzc("Error in ContentFetchTask", e3);
            } catch (Exception e4) {
                zzbbq.zzc("Error in ContentFetchTask", e4);
                com.google.android.gms.ads.internal.zzp.zzkv().zza(e4, "ContentFetchTask.run");
            }
            synchronized (this.lock) {
                while (this.zzbtf) {
                    try {
                        zzbbq.zzef("ContentFetchTask: waiting");
                        this.lock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbtf = false;
            this.lock.notifyAll();
            zzbbq.zzef("ContentFetchThread: wakeup");
        }
    }

    @VisibleForTesting
    final void zzj(View view) {
        try {
            zzre zzreVar = new zzre(this.zzbsf, this.zzbtj, this.zzbsh, this.zzbtk, this.zzbtl, this.zzbtm, this.zzbtn, this.zzbsi);
            Context context = com.google.android.gms.ads.internal.zzp.zzku().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbto)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwm.zzpx().zzd(zzabb.zzcng), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbto)) {
                    return;
                }
            }
            zzro zzroVarZza = zza(view, zzreVar);
            zzreVar.zzmg();
            if (zzroVarZza.zzbtx == 0 && zzroVarZza.zzbty == 0) {
                return;
            }
            if (zzroVarZza.zzbty == 0 && zzreVar.zzmh() == 0) {
                return;
            }
            if (zzroVarZza.zzbty == 0 && this.zzbth.zza(zzreVar)) {
                return;
            }
            this.zzbth.zzc(zzreVar);
        } catch (Exception e2) {
            zzbbq.zzc("Exception in fetchContentOnUIThread", e2);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzmi() {
        synchronized (this.lock) {
            if (this.started) {
                zzbbq.zzef("Content hash thread already started, quiting...");
            } else {
                this.started = true;
                start();
            }
        }
    }

    public final zzre zzmk() {
        return this.zzbth.zzo(this.zzbtq);
    }

    public final boolean zzmm() {
        return this.zzbtf;
    }

    @VisibleForTesting
    private zzrk(zzrd zzrdVar) {
        this.started = false;
        this.zzbtf = false;
        this.zzbtg = false;
        this.zzbth = zzrdVar;
        this.lock = new Object();
        this.zzbsf = zzacq.zzdat.get().intValue();
        this.zzbtj = zzacq.zzdaq.get().intValue();
        this.zzbsh = zzacq.zzdau.get().intValue();
        this.zzbtk = zzacq.zzdas.get().intValue();
        this.zzbtl = ((Integer) zzwm.zzpx().zzd(zzabb.zzcnd)).intValue();
        this.zzbtm = ((Integer) zzwm.zzpx().zzd(zzabb.zzcne)).intValue();
        this.zzbtn = ((Integer) zzwm.zzpx().zzd(zzabb.zzcnf)).intValue();
        this.zzbti = zzacq.zzdav.get().intValue();
        this.zzbto = (String) zzwm.zzpx().zzd(zzabb.zzcnh);
        this.zzbtp = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcni)).booleanValue();
        this.zzbsi = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcnj)).booleanValue();
        this.zzbtq = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcnk)).booleanValue();
        setName("ContentFetchTask");
    }

    @VisibleForTesting
    final void zza(zzre zzreVar, WebView webView, String str, boolean z) {
        zzreVar.zzmd();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString(ViewHierarchyConstants.TEXT_KEY);
                if (!this.zzbtp && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(strOptString).length());
                    sb.append(title);
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                    sb.append(strOptString);
                    zzreVar.zza(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzreVar.zza(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzreVar.zzly()) {
                this.zzbth.zzb(zzreVar);
            }
        } catch (JSONException unused) {
            zzbbq.zzef("Json string may be malformed.");
        } catch (Throwable th) {
            zzbbq.zzb("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }
}
