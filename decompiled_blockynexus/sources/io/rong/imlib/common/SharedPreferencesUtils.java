package io.rong.imlib.common;

import android.content.Context;
import android.content.SharedPreferences;
import io.rong.common.rlog.RLog;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class SharedPreferencesUtils {
    private static final String IS_INIT = "isInit";
    private static final String SECURE_PRE = "secure_";
    private static final String TAG = "SharedPreferencesUtils";
    private static Boolean result;

    public static SharedPreferences get(final Context context, final String str, int i) {
        if (context == null) {
            return null;
        }
        if (result == null) {
            try {
                result = Boolean.valueOf(context.getResources().getBoolean(context.getResources().getIdentifier("rc_secure_shared_preferences", "bool", context.getPackageName())));
            } catch (Exception unused) {
                RLog.e(TAG, "not found rc_secure_shared_preferences");
                result = false;
            }
        }
        if (!result.booleanValue()) {
            return context.getSharedPreferences(str, i);
        }
        final SecureSharedPreferences secureSharedPreferences = SecureSharedPreferences.get(context, SECURE_PRE + str, i);
        if (!secureSharedPreferences.getBoolean(IS_INIT, false)) {
            new Thread(new Runnable() { // from class: io.rong.imlib.common.SharedPreferencesUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (SharedPreferencesUtils.class) {
                        File file = new File(context.getCacheDir().getParent() + "/shared_prefs", str + ".xml");
                        if (file.exists() && !file.delete()) {
                            RLog.w(SharedPreferencesUtils.TAG, "delete failed");
                        }
                    }
                    secureSharedPreferences.edit().putBoolean(SharedPreferencesUtils.IS_INIT, true).apply();
                }
            }).start();
        }
        return secureSharedPreferences;
    }
}
