package io.rong.imlib.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import io.rong.common.rlog.RLog;
import io.rong.imlib.common.SharedPreferencesUtils;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes5.dex */
public class ReferrerReceiver extends BroadcastReceiver {
    private static String key = "referrer";

    public static void deleteReferrer(Context context) {
        SharedPreferencesUtils.get(context, key, 0).edit().remove(key).commit();
    }

    public static String getReferrer(Context context) {
        return SharedPreferencesUtils.get(context, key, 0).getString(key, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent != null) {
            try {
                if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER") || (stringExtra = intent.getStringExtra(key)) == null) {
                    return;
                }
                String strDecode = URLDecoder.decode(stringExtra, "UTF-8");
                Log.d("Statistics", "Referrer: " + strDecode);
                String[] strArrSplit = strDecode.split("&");
                String strTrim = null;
                String strTrim2 = null;
                for (int i = 0; i < strArrSplit.length; i++) {
                    if (strArrSplit[i].startsWith("countly_cid")) {
                        strTrim = strArrSplit[i].replace("countly_cid=", "").trim();
                    }
                    if (strArrSplit[i].startsWith("countly_cuid")) {
                        strTrim2 = strArrSplit[i].replace("countly_cuid=", "").trim();
                    }
                }
                String str = strTrim != null ? "&campaign_id=" + strTrim : "";
                if (strTrim2 != null) {
                    str = str + "&campaign_user=" + strTrim2;
                }
                Log.d("Statistics", "Processed: " + str);
                if (str.equals("")) {
                    return;
                }
                SharedPreferencesUtils.get(context, key, 0).edit().putString(key, str).commit();
            } catch (Exception e2) {
                RLog.d("Statistics", e2.toString());
            }
        }
    }
}
