package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.alibaba.android.arouter.utils.Consts;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.umeng.analytics.pro.au;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbg {
    public static final Handler zzaah = new zzdvo(Looper.getMainLooper());
    private static final String zzedt = AdView.class.getName();
    private static final String zzedu = InterstitialAd.class.getName();
    private static final String zzedv = PublisherAdView.class.getName();
    private static final String zzedw = PublisherInterstitialAd.class.getName();
    private static final String zzedx = SearchAdView.class.getName();
    private static final String zzedy = AdLoader.class.getName();
    private float zzedz = -1.0f;

    public static void zza(boolean z, HttpURLConnection httpURLConnection, String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public static String zzbn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || zzym()) {
            string = "emulator";
        }
        return zzex(string);
    }

    public static String zzbo(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        return Settings.Secure.getString(contentResolver, "android_id");
    }

    public static boolean zzbp(Context context) {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000);
        return iIsGooglePlayServicesAvailable == 0 || iIsGooglePlayServicesAvailable == 2;
    }

    public static boolean zzbq(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @TargetApi(17)
    public static boolean zzbr(Context context) {
        int iIntValue;
        int iIntValue2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            iIntValue = displayMetrics.heightPixels;
            iIntValue2 = displayMetrics.widthPixels;
        } else {
            try {
                iIntValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                iIntValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == iIntValue && displayMetrics.widthPixels == iIntValue2;
    }

    public static int zzbs(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int zzc(Context context, int i) {
        return zza(context.getResources().getDisplayMetrics(), i);
    }

    public static boolean zzd(Context context, int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i) == 0;
    }

    public static int zze(Context context, int i) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context == null) {
            return -1;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null || (configuration = resources.getConfiguration()) == null) {
            return -1;
        }
        int i2 = configuration.orientation;
        if (i == 0) {
            i = i2;
        }
        return i == i2 ? Math.round(displayMetrics.heightPixels / displayMetrics.density) : Math.round(displayMetrics.widthPixels / displayMetrics.density);
    }

    public static String zzex(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    @VisibleForTesting
    public static boolean zzey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(zzadb.zzdce.get());
    }

    public static boolean zzym() {
        return Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
    }

    public static boolean zzyn() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String zzyo() {
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return string;
    }

    public final int zzb(Context context, int i) {
        if (this.zzedz < WheelView.DividerConfig.FILL) {
            synchronized (this) {
                if (this.zzedz < WheelView.DividerConfig.FILL) {
                    Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    this.zzedz = displayMetrics.density;
                }
            }
        }
        return Math.round(i / this.zzedz);
    }

    public static Throwable zzd(Throwable th) {
        if (zzadb.zzdcg.get().booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th3.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzey(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else {
                    String className = stackTraceElement.getClassName();
                    if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                        arrayList.add(stackTraceElement);
                    } else {
                        arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                    }
                }
            }
            if (z) {
                if (th2 == null) {
                    th2 = new Throwable(th3.getMessage());
                } else {
                    th2 = new Throwable(th3.getMessage(), th2);
                }
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th2;
    }

    public static int zza(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, i, displayMetrics);
    }

    public final void zza(ViewGroup viewGroup, zzvn zzvnVar, String str, String str2) {
        zzbbq.zzfe(str2);
        zza(viewGroup, zzvnVar, str, -65536, -16777216);
    }

    public final void zza(ViewGroup viewGroup, zzvn zzvnVar, String str) {
        zza(viewGroup, zzvnVar, str, -16777216, -1);
    }

    private final void zza(ViewGroup viewGroup, zzvn zzvnVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setBackgroundColor(i2);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i);
        int iZzc = zzc(context, 3);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(zzvnVar.widthPixels - iZzc, zzvnVar.heightPixels - iZzc, 17));
        viewGroup.addView(frameLayout, zzvnVar.widthPixels, zzvnVar.heightPixels);
    }

    public static int zzb(DisplayMetrics displayMetrics, int i) {
        return Math.round(i / displayMetrics.density);
    }

    @VisibleForTesting
    public static String zza(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        String className;
        int i2 = 0;
        while (true) {
            i = i2 + 1;
            if (i >= stackTraceElementArr.length) {
                className = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzedt.equalsIgnoreCase(className2) || zzedu.equalsIgnoreCase(className2) || zzedv.equalsIgnoreCase(className2) || zzedw.equalsIgnoreCase(className2) || zzedx.equalsIgnoreCase(className2) || zzedy.equalsIgnoreCase(className2))) {
                break;
            }
            i2 = i;
        }
        className = stackTraceElementArr[i].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, Consts.DOT);
            StringBuilder sb = new StringBuilder();
            int i3 = 2;
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0 || !stringTokenizer.hasMoreElements()) {
                        break;
                    }
                    sb.append(Consts.DOT);
                    sb.append(stringTokenizer.nextToken());
                    i3 = i4;
                }
                str = sb.toString();
            }
            if (className != null && !className.contains(str)) {
                return className;
            }
        }
        return null;
    }

    public final void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        zza(context, str, str2, bundle, true, new zzbbj(this));
    }

    public static void zza(Context context, String str, String str2, Bundle bundle, boolean z, zzbbl zzbblVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString(au.w, Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            int apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(context);
            StringBuilder sb = new StringBuilder(23);
            sb.append(apkVersion);
            sb.append(".202510000");
            str = sb.toString();
        }
        bundle.putString("js", str);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", str2);
        for (String str3 : bundle.keySet()) {
            builderAppendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzbblVar.zzes(builderAppendQueryParameter.toString());
    }

    public static AdSize zza(Context context, int i, int i2, int i3) {
        int iRound;
        int iZze = zze(context, i3);
        if (iZze == -1) {
            return AdSize.INVALID;
        }
        int iMin = Math.min(90, Math.round(iZze * 0.15f));
        if (i > 655) {
            iRound = Math.round((i / 728.0f) * 90.0f);
        } else if (i > 632) {
            iRound = 81;
        } else if (i > 526) {
            iRound = Math.round((i / 468.0f) * 60.0f);
        } else {
            iRound = i > 432 ? 68 : Math.round((i / 320.0f) * 50.0f);
        }
        return new AdSize(i, Math.max(Math.min(iRound, iMin), 50));
    }
}
