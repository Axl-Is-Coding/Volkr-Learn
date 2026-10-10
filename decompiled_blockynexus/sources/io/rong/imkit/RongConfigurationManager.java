package io.rong.imkit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import io.rong.imkit.utilities.LangUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.SharedPreferencesUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class RongConfigurationManager {
    private static String FILE_MAX_SIZE = "FileMaxSize";
    private static String RONG_CONFIG = "RongKitConfiguration";
    private static boolean isInit;

    private static class SingletonHolder {
        static RongConfigurationManager sInstance = new RongConfigurationManager();

        private SingletonHolder() {
        }
    }

    private static class SystemConfigurationChangedReceiver extends BroadcastReceiver {
        private SystemConfigurationChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                LangUtils.setSystemLocale(Locale.getDefault());
                LangUtils.RCLocale appLocale = LangUtils.getAppLocale(context);
                if (appLocale.toLocale().equals(LangUtils.getSystemLocale())) {
                    return;
                }
                RongConfigurationManager.getInstance().switchLocale(appLocale, context);
            }
        }
    }

    public static RongConfigurationManager getInstance() {
        return SingletonHolder.sInstance;
    }

    public static void init(Context context) {
        if (isInit) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        context.registerReceiver(new SystemConfigurationChangedReceiver(), intentFilter);
        getInstance().switchLocale(getInstance().getAppLocale(context), context);
        isInit = true;
    }

    public LangUtils.RCLocale getAppLocale(Context context) {
        return LangUtils.getAppLocale(context);
    }

    public Context getConfigurationContext(Context context) {
        return LangUtils.getConfigurationContext(context);
    }

    public int getFileMaxSize(Context context) {
        if (context == null) {
            return 100;
        }
        return SharedPreferencesUtils.get(context, RONG_CONFIG, 0).getInt(FILE_MAX_SIZE, 100);
    }

    public RongIMClient.PushLanguage getPushLanguage(Context context) {
        return LangUtils.getPushLanguage(context);
    }

    public Locale getSystemLocale() {
        return LangUtils.getSystemLocale();
    }

    public void setFileMaxSize(Context context, int i) {
        SharedPreferencesUtils.get(context, RONG_CONFIG, 0).edit().putInt(FILE_MAX_SIZE, i).apply();
    }

    public void setPushLanguage(Context context, RongIMClient.PushLanguage pushLanguage) {
        LangUtils.setPushLanguage(context, pushLanguage);
    }

    public void switchLocale(LangUtils.RCLocale rCLocale, Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = rCLocale.toLocale();
        if (Build.VERSION.SDK_INT < 24) {
            context.getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        LangUtils.saveLocale(context, rCLocale);
    }

    private RongConfigurationManager() {
    }
}
