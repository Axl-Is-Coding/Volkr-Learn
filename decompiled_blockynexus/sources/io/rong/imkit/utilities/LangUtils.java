package io.rong.imkit.utilities;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import io.rong.imlib.RongIMClient;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class LangUtils {
    private static final String APP_LOCALE = "app_locale";
    private static final String APP_PUSH_LANGUAGE = "app_push_language";
    private static final String LOCALE_CONF_FILE_NAME = "locale.config";
    private static Locale systemLocale = Locale.getDefault();

    public static class RCLocale {
        private String rcLocale;
        public static final RCLocale LOCALE_CHINA = new RCLocale("zh");
        public static final RCLocale LOCALE_US = new RCLocale("en");
        public static final RCLocale LOCALE_ARAB = new RCLocale("ar");
        public static final RCLocale LOCALE_AUTO = new RCLocale("auto");

        private RCLocale(String str) {
            this.rcLocale = str;
        }

        public static RCLocale valueOf(String str) {
            return LOCALE_CHINA.value().equals(str) ? LOCALE_CHINA : LOCALE_US.value().equals(str) ? LOCALE_US : LOCALE_ARAB.value().equals(str) ? LOCALE_ARAB : LOCALE_AUTO;
        }

        public Locale toLocale() {
            return this.rcLocale.equals(LOCALE_CHINA.value()) ? Locale.CHINESE : this.rcLocale.equals(LOCALE_US.value()) ? Locale.ENGLISH : this.rcLocale.equals(LOCALE_ARAB.value()) ? new Locale("ar") : LangUtils.getSystemLocale();
        }

        public String value() {
            return this.rcLocale;
        }
    }

    public static RCLocale getAppLocale(Context context) {
        return RCLocale.valueOf(context.getSharedPreferences(LOCALE_CONF_FILE_NAME, 0).getString(APP_LOCALE, "auto"));
    }

    public static Context getConfigurationContext(Context context) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        LocaleList localeList = new LocaleList(getAppLocale(context).toLocale());
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        return context.createConfigurationContext(configuration);
    }

    public static RCLocale getCurrentLanguage(Context context) {
        String string = context.getSharedPreferences(LOCALE_CONF_FILE_NAME, 0).getString(APP_LOCALE, "auto");
        return "auto".equals(string) ? getSystemLocale().toString().equals("zh_CN") ? RCLocale.LOCALE_CHINA : RCLocale.LOCALE_US : RCLocale.valueOf(string);
    }

    public static RongIMClient.PushLanguage getPushLanguage(Context context) {
        String string = context.getSharedPreferences(LOCALE_CONF_FILE_NAME, 0).getString(APP_PUSH_LANGUAGE, "");
        if (RongIMClient.PushLanguage.ZH_CN.getMsg().equals(string)) {
            return RongIMClient.PushLanguage.ZH_CN;
        }
        if (RongIMClient.PushLanguage.EN_US.getMsg().equals(string)) {
            return RongIMClient.PushLanguage.EN_US;
        }
        if (RongIMClient.PushLanguage.AR_SA.getMsg().equals(string)) {
            return RongIMClient.PushLanguage.AR_SA;
        }
        return null;
    }

    public static Locale getSystemLocale() {
        return systemLocale;
    }

    public static void saveLocale(Context context, RCLocale rCLocale) {
        context.getSharedPreferences(LOCALE_CONF_FILE_NAME, 0).edit().putString(APP_LOCALE, rCLocale.value()).commit();
    }

    public static void setPushLanguage(Context context, RongIMClient.PushLanguage pushLanguage) {
        context.getSharedPreferences(LOCALE_CONF_FILE_NAME, 0).edit().putString(APP_PUSH_LANGUAGE, pushLanguage.getMsg()).commit();
    }

    public static void setSystemLocale(Locale locale) {
        systemLocale = locale;
    }
}
