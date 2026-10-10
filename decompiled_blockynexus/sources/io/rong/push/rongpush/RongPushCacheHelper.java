package io.rong.push.rongpush;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import io.rong.imlib.common.DeviceUtils;
import io.rong.imlib.common.SharedPreferencesUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RongPushCacheHelper {
    public static final String DeviceId = "deviceId";
    private static final String PUSH_SHARE_PREFERENCE = "RongPush";
    private final String TIME = "navigation_time";
    private final String ADDRESS_LIST = "addressList";
    private final long EXPIRED_TIME = 7200000;

    private static class Singleton {
        static RongPushCacheHelper sInstance = new RongPushCacheHelper();

        private Singleton() {
        }
    }

    private String getCachedDeviceId(Context context) {
        return SharedPreferencesUtils.get(context, "RongPush", 0).getString("deviceId", "");
    }

    public static RongPushCacheHelper getInstance() {
        return Singleton.sInstance;
    }

    public void cacheRongPushIPs(Context context, ArrayList<String> arrayList, long j) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, "RongPush", 0).edit();
        editorEdit.putString("addressList", new j().a(arrayList));
        editorEdit.putLong("navigation_time", j);
        editorEdit.commit();
    }

    public ArrayList<String> getCachedAddressList(Context context) {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "RongPush", 0);
        ArrayList<String> arrayList = new ArrayList<>();
        String string = sharedPreferences.getString("addressList", "");
        return TextUtils.isEmpty(string) ? arrayList : (ArrayList) new j().a(string, new TypeToken<List<String>>() { // from class: io.rong.push.rongpush.RongPushCacheHelper.1
        }.getType());
    }

    public boolean isCacheValid(Context context, String str) {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, "RongPush", 0);
        return System.currentTimeMillis() - sharedPreferences.getLong("navigation_time", -1L) < 7200000 && !TextUtils.isEmpty(sharedPreferences.getString("addressList", "")) && getCachedDeviceId(context).equals(DeviceUtils.getDeviceId(context, str));
    }
}
