package io.rong.push.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.RongLibConst;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.push.PushType;
import io.rong.push.core.PushUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PushCacheHelper {
    public final String APP_PUSH_INFORMATION = "RongPushAppConfig";
    private final String TIME = "navigation_time";
    private final String ADDRESS_LIST = "addressList";
    private final String DEVICE_ID = "deviceId";
    private final String IS_CONFIG_DONE = "isConfig";
    private final String PUSH_TYPE_CONFIGED = PushConst.PUSH_TYPE;
    private final String ENABLED_PUSH_TYPES = "enabledPushTypes";
    private final String PUSH_DOMAIN = PushConst.PushDomain;
    private final String TOKEN = RongLibConst.KEY_TOKEN;
    private final long EXPIRED_TIME = 7200000;

    private static class Singleton {
        static PushCacheHelper sInstance = new PushCacheHelper();

        private Singleton() {
        }
    }

    public static PushCacheHelper getInstance() {
        return Singleton.sInstance;
    }

    public void cacheRongDeviceId(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.putString("deviceId", str);
        editorEdit.apply();
    }

    public void clearAll(Context context) {
        SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit().clear().apply();
    }

    public void clearPushConfigInfo(Context context) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.remove("isConfig");
        editorEdit.remove(PushConst.PUSH_TYPE);
        editorEdit.commit();
    }

    public ArrayList<String> getCachedAddressList(Context context) {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0);
        ArrayList<String> arrayList = new ArrayList<>();
        String string = sharedPreferences.getString("addressList", "");
        return TextUtils.isEmpty(string) ? arrayList : (ArrayList) new j().a(string, new TypeToken<List<String>>() { // from class: io.rong.push.common.PushCacheHelper.1
        }.getType());
    }

    public String getCachedDeviceId(Context context) {
        return SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getString("deviceId", "");
    }

    public String getCachedEnablePushTypes(Context context) {
        return SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getString("enabledPushTypes", "");
    }

    public String getCachedPushDomain(Context context) {
        return SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getString(PushConst.PushDomain, PushUtils.getDefaultNavi());
    }

    public String getCachedTokenInfo(Context context) {
        return SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getString(RongLibConst.KEY_TOKEN, "");
    }

    public PushType getConfigPushType(Context context) {
        return PushType.getType(SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getString(PushConst.PUSH_TYPE, PushType.RONG.getName()));
    }

    public boolean getPushContentShowStatus(Context context) {
        return SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getBoolean(PushConst.IS_SHOW_DEAIL, true);
    }

    public String getPushServerInfoInIMToken(Context context) {
        return SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getString(PushConst.PUSH_DOMAIN_IN_IM_TOKEN, "");
    }

    public boolean isCacheValid(Context context, String str) {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0);
        return System.currentTimeMillis() - sharedPreferences.getLong("navigation_time", -1L) < 7200000 && !TextUtils.isEmpty(sharedPreferences.getString("addressList", "")) && getCachedDeviceId(context).equals(DeviceUtils.getDeviceId(context, str));
    }

    public boolean isConfigDone(Context context) {
        return SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).getBoolean("isConfig", false);
    }

    public void saveAllAddress(Context context, ArrayList<String> arrayList, long j) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.putString("addressList", new j().a(arrayList));
        editorEdit.putLong("navigation_time", j);
        editorEdit.commit();
    }

    public void saveEnablePushTypes(Context context, String str) {
        SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit().putString("enabledPushTypes", str).commit();
    }

    public void savePushConfigInfo(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.putBoolean("isConfig", true);
        editorEdit.putString(PushConst.PUSH_TYPE, str);
        editorEdit.commit();
    }

    public void savePushDomain(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.putString(PushConst.PushDomain, str);
        editorEdit.apply();
    }

    public void saveTokenInfo(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.putString(RongLibConst.KEY_TOKEN, str);
        editorEdit.apply();
    }

    public void setPushContentShowStatus(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.putBoolean(PushConst.IS_SHOW_DEAIL, z);
        editorEdit.apply();
    }

    public void setPushServerInIMToken(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPushAppConfig", 0).edit();
        editorEdit.putString(PushConst.PUSH_DOMAIN_IN_IM_TOKEN, str);
        editorEdit.apply();
    }
}
