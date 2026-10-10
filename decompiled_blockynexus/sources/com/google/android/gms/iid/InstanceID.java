package com.google.android.gms.iid;

import a.a.b;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class InstanceID {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    private static Map<String, InstanceID> zzbq = new b();
    private static long zzbr = TimeUnit.DAYS.toSeconds(7);
    private static zzak zzbs;
    private static zzaf zzbt;
    private static String zzbu;
    private String zzbv;
    private Context zzk;

    private InstanceID(Context context, String str) {
        this.zzbv = "";
        this.zzk = context.getApplicationContext();
        this.zzbv = str;
    }

    @Deprecated
    public static InstanceID getInstance(Context context) {
        return getInstance(context, null);
    }

    @KeepForSdk
    public static synchronized InstanceID getInstance(Context context, Bundle bundle) {
        InstanceID instanceID;
        String string = bundle == null ? "" : bundle.getString("subtype");
        if (string == null) {
            string = "";
        }
        Context applicationContext = context.getApplicationContext();
        if (zzbs == null) {
            String packageName = applicationContext.getPackageName();
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 73);
            sb.append("Instance ID SDK is deprecated, ");
            sb.append(packageName);
            sb.append(" should update to use Firebase Instance ID");
            Log.w("InstanceID", sb.toString());
            zzbs = new zzak(applicationContext);
            zzbt = new zzaf(applicationContext);
        }
        zzbu = Integer.toString(zzg(applicationContext));
        instanceID = zzbq.get(string);
        if (instanceID == null) {
            instanceID = new InstanceID(applicationContext, string);
            zzbq.put(string, instanceID);
        }
        return instanceID;
    }

    private final KeyPair getKeyPair() {
        return zzbs.zzj(this.zzbv).getKeyPair();
    }

    static String zzd(KeyPair keyPair) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            bArrDigest[0] = (byte) ((bArrDigest[0] & ci.m) + 112);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("InstanceID", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    static int zzg(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
            return 0;
        }
    }

    static String zzh(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(strValueOf);
            Log.w("InstanceID", sb.toString());
            return null;
        }
    }

    public static zzak zzn() {
        return zzbs;
    }

    @Deprecated
    public void deleteInstanceID() throws IOException {
        zzd("*", "*", null);
        zzm();
    }

    @Deprecated
    public void deleteToken(String str, String str2) throws IOException {
        zzd(str, str2, null);
    }

    @Deprecated
    public long getCreationTime() {
        return zzbs.zzj(this.zzbv).getCreationTime();
    }

    @Deprecated
    public String getId() {
        return zzd(getKeyPair());
    }

    @KeepForSdk
    public String getSubtype() {
        return this.zzbv;
    }

    @Deprecated
    public String getToken(String str, String str2) throws IOException {
        return getToken(str, str2, null);
    }

    @Deprecated
    public String getToken(String str, String str2, Bundle bundle) throws IOException {
        String str3;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String str4 = zzbs.get("appVersion");
        boolean z = true;
        if (str4 != null && str4.equals(zzbu) && (str3 = zzbs.get("lastToken")) != null) {
            if ((System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str3)).longValue() <= zzbr) {
                z = false;
            }
        }
        String strZze = z ? null : zzbs.zze(this.zzbv, str, str2);
        if (strZze != null) {
            return strZze;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        String strZze2 = zze(str, str2, bundle);
        if (strZze2 == null) {
            return strZze2;
        }
        zzbs.zzd(this.zzbv, str, str2, strZze2, zzbu);
        return strZze2;
    }

    public final void zzd(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzbs.zzf(this.zzbv, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.zzbv) ? str : this.zzbv);
        if (!"".equals(this.zzbv)) {
            str = this.zzbv;
        }
        bundle.putString("X-subtype", str);
        zzaf.zzi(zzbt.zzd(bundle, getKeyPair()));
    }

    public final String zze(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzbv) ? str : this.zzbv;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        String strZzi = zzaf.zzi(zzbt.zzd(bundle, getKeyPair()));
        if (!"RST".equals(strZzi) && !strZzi.startsWith("RST|")) {
            return strZzi;
        }
        InstanceIDListenerService.zzd(this.zzk, zzbs);
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    final void zzm() {
        zzbs.zzk(this.zzbv);
    }
}
