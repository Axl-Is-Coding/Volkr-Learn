package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public class zzazd {
    private zzazd() {
    }

    public static boolean zzb(zzbgj zzbgjVar) {
        if (zzbgjVar == null) {
            return false;
        }
        zzbgjVar.onResume();
        return true;
    }

    public static zzazd zzdh(int i) {
        return i >= 28 ? new zzazk() : i >= 26 ? new zzazl() : i >= 24 ? new zzazi() : i >= 21 ? new zzazj() : i >= 19 ? new zzazg() : i >= 18 ? new zzazh() : i >= 17 ? new zzaze() : new zzazd();
    }

    public static boolean zzxy() {
        int iMyUid = Process.myUid();
        return iMyUid == 0 || iMyUid == 1000;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean zza(Activity activity, Configuration configuration) {
        return false;
    }

    public boolean zza(final Context context, final WebSettings webSettings) {
        zzbay.zza(context, new Callable(context, webSettings) { // from class: com.google.android.gms.internal.ads.zzazc
            private final Context zzcyt;
            private final WebSettings zzebk;

            {
                this.zzcyt = context;
                this.zzebk = webSettings;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = this.zzcyt;
                WebSettings webSettings2 = this.zzebk;
                if (context2.getCacheDir() != null) {
                    webSettings2.setAppCachePath(context2.getCacheDir().getAbsolutePath());
                    webSettings2.setAppCacheMaxSize(0L);
                    webSettings2.setAppCacheEnabled(true);
                }
                webSettings2.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                webSettings2.setAllowContentAccess(false);
                return true;
            }
        });
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public void zzbg(Context context) {
    }

    public CookieManager zzbh(Context context) {
        if (zzxy()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzbbq.zzc("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public void zzg(Activity activity) {
    }

    public int zzxw() {
        return 5;
    }

    public ViewGroup.LayoutParams zzxx() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int zzxz() {
        return 1;
    }

    public long zzya() {
        return -1L;
    }

    public int zzb(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public static boolean zza(zzbgj zzbgjVar) {
        if (zzbgjVar == null) {
            return false;
        }
        zzbgjVar.onPause();
        return true;
    }

    public zzbgi zza(zzbgj zzbgjVar, zzts zztsVar, boolean z) {
        return new zzbhk(zzbgjVar, zztsVar, z);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f2) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public zzuk zza(Context context, TelephonyManager telephonyManager) {
        return zzuk.ENUM_UNKNOWN;
    }

    public int zza(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }
}
