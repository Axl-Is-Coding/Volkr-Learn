package com.google.android.gms.gcm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
final class zzd {
    static zzd zzj;
    private final Context zzk;
    private String zzl;
    private final AtomicInteger zzm = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zzd(Context context) {
        this.zzk = context.getApplicationContext();
    }

    static synchronized zzd zzd(Context context) {
        if (zzj == null) {
            zzj = new zzd(context);
        }
        return zzj;
    }

    static String zzd(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private final Bundle zze() {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = this.zzk.getPackageManager().getApplicationInfo(this.zzk.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (applicationInfo == null || applicationInfo.metaData == null) ? Bundle.EMPTY : applicationInfo.metaData;
    }

    private final String zze(Bundle bundle, String str) {
        String strZzd = zzd(bundle, str);
        if (!TextUtils.isEmpty(strZzd)) {
            return strZzd;
        }
        String strValueOf = String.valueOf(str);
        String strZzd2 = zzd(bundle, "_loc_key".length() != 0 ? strValueOf.concat("_loc_key") : new String(strValueOf));
        if (TextUtils.isEmpty(strZzd2)) {
            return null;
        }
        Resources resources = this.zzk.getResources();
        int identifier = resources.getIdentifier(strZzd2, "string", this.zzk.getPackageName());
        if (identifier == 0) {
            String strValueOf2 = String.valueOf(str);
            String strSubstring = ("_loc_key".length() != 0 ? strValueOf2.concat("_loc_key") : new String(strValueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 49 + String.valueOf(strZzd2).length());
            sb.append(strSubstring);
            sb.append(" resource not found: ");
            sb.append(strZzd2);
            sb.append(" Default value will be used.");
            Log.w("GcmNotification", sb.toString());
            return null;
        }
        String strValueOf3 = String.valueOf(str);
        String strZzd3 = zzd(bundle, "_loc_args".length() != 0 ? strValueOf3.concat("_loc_args") : new String(strValueOf3));
        if (TextUtils.isEmpty(strZzd3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(strZzd3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return resources.getString(identifier, objArr);
        } catch (MissingFormatArgumentException e2) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(strZzd2).length() + 58 + String.valueOf(strZzd3).length());
            sb2.append("Missing format argument for ");
            sb2.append(strZzd2);
            sb2.append(": ");
            sb2.append(strZzd3);
            sb2.append(" Default value will be used.");
            Log.w("GcmNotification", sb2.toString(), e2);
            return null;
        } catch (JSONException unused) {
            String strValueOf4 = String.valueOf(str);
            String strSubstring2 = ("_loc_args".length() != 0 ? strValueOf4.concat("_loc_args") : new String(strValueOf4)).substring(6);
            StringBuilder sb3 = new StringBuilder(String.valueOf(strSubstring2).length() + 41 + String.valueOf(strZzd3).length());
            sb3.append("Malformed ");
            sb3.append(strSubstring2);
            sb3.append(": ");
            sb3.append(strZzd3);
            sb3.append("  Default value will be used.");
            Log.w("GcmNotification", sb3.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0295  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean zze(android.os.Bundle r15) {
        /*
            Method dump skipped, instruction units count: 729
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.zzd.zze(android.os.Bundle):boolean");
    }
}
