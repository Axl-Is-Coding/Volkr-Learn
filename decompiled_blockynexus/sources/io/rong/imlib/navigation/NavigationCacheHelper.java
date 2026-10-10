package io.rong.imlib.navigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.p;
import com.google.gson.s;
import com.umeng.analytics.pro.au;
import io.rong.common.RLog;
import io.rong.common.fwlog.FwLog;
import io.rong.imlib.CMPStrategy;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.common.SharedPreferencesUtils;
import io.rong.imlib.filetransfer.FtConst;
import io.rong.imlib.filetransfer.upload.FilePlatformInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class NavigationCacheHelper {
    private static final String APP_KEY = "appKey";
    private static final String BACKUP_SERVER = "bs";
    private static final String BAI_DU_MEDIA_SERVER = "bosAddr";
    private static final String CACHED_TIME = "cached_time";
    private static final String CLIENT_IP = "clientIp";
    private static final String CMP_SERVER = "server";
    private static final String CODE = "code";
    private static final String COMPLEX_CONNECTION = "complexConnection";
    private static final String CONN_POLICY = "connPolicy";
    private static final int DEFAULT_GIF_SIZE = 2048;
    private static final String DEFAULT_MEDIA_SERVER_HOST_BAIDU = "gz.bcebos.com";
    private static final String DEFAULT_VIDEO_TIME = "300";
    private static final String EXT_KIT_SWITCH = "extkitSwitch";
    private static final String GET_CHATROOM_HISTORY_SERVICE = "chatroomMsg";
    private static final String GET_GROUP_MESSAGE_LIMIT = "grpMsgLimit";
    private static final String GET_REMOTE_SERVICE = "historyMsg";
    private static final String GIF_SIZE = "gifSize";
    private static final String JOIN_MULTI_CHATROOM = "joinMChrm";
    private static final String KV_STORAGE = "kvStorage";
    private static final String LAST_SUCCESS_NAVI = "lastSuccessNavi";
    private static final String LOCATION_CONFIG = "location";
    private static final String LOG_MONITOR = "monitor";
    private static final String MEDIA_SERVER = "uploadServer";
    private static final String MEDIA_SERVER_CONFIG = "ossConfig";
    private static final String NAVIGATION_IP_PREFERENCE = "RongNavigationIp";
    private static final String NAVIGATION_PREFERENCE = "RongNavigation";
    private static final String OFFLINE_LOG_SERVER = "offlinelogserver";
    private static final String ONLINE_LOG_SERVER = "onlinelogserver";
    private static final String OPEN_DNS = "openHttpDNS";
    private static final String OPEN_MP = "openMp";
    private static final String OPEN_US = "openUS";
    private static final String TAG = "NavigationCacheHelper";
    private static final long TIME_OUT = 7200000;
    private static final String TIMING_UPLOAD_LOG_CONFIG = "logPolicy";
    private static final String TIMING_UPLOAD_LOG_SWITCH = "logSwitch";
    private static final String TOKEN = "token";
    private static final String TYPE = "type";
    private static final int USERID_MAX_LENGTH = 64;
    private static final String USER_ID = "userId";
    private static final String VIDEO_TIMES = "videoTimes";
    private static final String VOIP_CALL_INFO = "voipCallInfo";
    private static Object lock = new Object();
    private static long sCacheTime;
    private static boolean userPolicy;

    static void cacheLastSuccessNaviDomainList(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, NAVIGATION_IP_PREFERENCE, 0).edit();
        editorEdit.putString(LAST_SUCCESS_NAVI, str);
        editorEdit.commit();
    }

    static void cacheRequest(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit();
        editorEdit.putLong(CACHED_TIME, System.currentTimeMillis() - ((long) TimeZone.getDefault().getRawOffset()));
        editorEdit.putString("appKey", str);
        editorEdit.putString("token", str2);
        editorEdit.commit();
    }

    public static void clearCache(Context context) {
        SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit().clear().commit();
    }

    static void clearComplexConnectionEntries(Context context) {
        SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit().remove(COMPLEX_CONNECTION).commit();
    }

    public static void clearNaviCache(Context context) {
        SharedPreferencesUtils.get(context, NAVIGATION_IP_PREFERENCE, 0).edit().clear().commit();
    }

    public static void clearUserId(Context context) {
        SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit().remove("userId").commit();
    }

    private static String decode(String str, String str2, String str3) {
        int iIndexOf;
        int iIndexOf2;
        if (str == null || (iIndexOf = str.indexOf(str2) + str2.length()) >= (iIndexOf2 = str.indexOf(str3)) || iIndexOf2 == 0) {
            return null;
        }
        return str.substring(iIndexOf, iIndexOf2);
    }

    static int decode2File(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            RLog.e(TAG, "[connect] decode2File: navi data is empty.");
            return RongIMClient.ErrorCode.RC_NODE_NOT_FOUND.getValue();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(CODE)) {
                return RongIMClient.ErrorCode.RC_NODE_NOT_FOUND.getValue();
            }
            int iOptInt = jSONObject.optInt(CODE);
            if (iOptInt != 200) {
                RLog.e(TAG, "[connect] decode2File: code & httpCode " + iOptInt + "-" + i);
                return ((iOptInt == 401 && i == 403) || (iOptInt == 403 && i == 401)) ? RongIMClient.ErrorCode.RC_CONN_USER_OR_PASSWD_ERROR.getValue() : RongIMClient.ErrorCode.RC_NAVI_RESOURCE_ERROR.getValue();
            }
            SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit();
            String strOptString = jSONObject.optString("userId");
            if (TextUtils.isEmpty(strOptString) || strOptString.getBytes().length > 64) {
                RLog.e(TAG, "[connect] decode2File: no user_id." + str);
                return RongIMClient.ErrorCode.RC_NODE_NOT_FOUND.getValue();
            }
            editorEdit.putString("userId", strOptString);
            String strOptString2 = jSONObject.optString(CMP_SERVER);
            String strOptString3 = jSONObject.optString(BACKUP_SERVER);
            if (TextUtils.isEmpty(strOptString2) && TextUtils.isEmpty(strOptString3)) {
                RLog.e(TAG, "[connect] decode2File: cmp is invalid, " + str);
                return RongIMClient.ErrorCode.RC_NODE_NOT_FOUND.getValue();
            }
            editorEdit.putString(CMP_SERVER, strOptString2);
            editorEdit.putString(BACKUP_SERVER, strOptString3);
            editorEdit.putString(MEDIA_SERVER, jSONObject.optString(MEDIA_SERVER));
            editorEdit.putString(MEDIA_SERVER_CONFIG, jSONObject.optString(MEDIA_SERVER_CONFIG));
            editorEdit.putString("location", jSONObject.optString("location"));
            editorEdit.putString(VOIP_CALL_INFO, jSONObject.optString(VOIP_CALL_INFO));
            editorEdit.putBoolean(GET_REMOTE_SERVICE, jSONObject.optBoolean(GET_REMOTE_SERVICE));
            editorEdit.putBoolean(GET_CHATROOM_HISTORY_SERVICE, jSONObject.optBoolean(GET_CHATROOM_HISTORY_SERVICE));
            if (jSONObject.has(GET_GROUP_MESSAGE_LIMIT)) {
                editorEdit.putInt(GET_GROUP_MESSAGE_LIMIT, jSONObject.optInt(GET_GROUP_MESSAGE_LIMIT));
            }
            editorEdit.putBoolean(JOIN_MULTI_CHATROOM, jSONObject.optBoolean(JOIN_MULTI_CHATROOM));
            editorEdit.putBoolean(OPEN_MP, jSONObject.optInt(OPEN_MP) == 1);
            editorEdit.putBoolean(OPEN_US, jSONObject.optInt(OPEN_US) == 1);
            if (jSONObject.has(LOG_MONITOR)) {
                editorEdit.putInt(LOG_MONITOR, jSONObject.optInt(LOG_MONITOR));
            }
            editorEdit.putBoolean("type", jSONObject.optInt("type") == 1);
            if (jSONObject.has(CONN_POLICY)) {
                editorEdit.putInt(CONN_POLICY, jSONObject.optInt(CONN_POLICY));
            }
            if (jSONObject.has(VIDEO_TIMES)) {
                editorEdit.putInt(VIDEO_TIMES, jSONObject.optInt(VIDEO_TIMES));
            }
            editorEdit.putString(OFFLINE_LOG_SERVER, jSONObject.optString(OFFLINE_LOG_SERVER));
            editorEdit.putString(ONLINE_LOG_SERVER, jSONObject.optString(ONLINE_LOG_SERVER));
            editorEdit.putBoolean(EXT_KIT_SWITCH, jSONObject.optInt(EXT_KIT_SWITCH) == 1);
            editorEdit.putBoolean(KV_STORAGE, jSONObject.optInt(KV_STORAGE) == 1);
            if (jSONObject.has(GIF_SIZE)) {
                editorEdit.putInt(GIF_SIZE, jSONObject.optInt(GIF_SIZE));
            }
            editorEdit.putBoolean(OPEN_DNS, jSONObject.optInt(OPEN_DNS) == 1);
            if (jSONObject.has(BAI_DU_MEDIA_SERVER)) {
                editorEdit.putString(BAI_DU_MEDIA_SERVER, jSONObject.optString(BAI_DU_MEDIA_SERVER));
            }
            if (jSONObject.optInt(TIMING_UPLOAD_LOG_SWITCH) == 1) {
                String strOptString4 = jSONObject.optString(TIMING_UPLOAD_LOG_CONFIG);
                if (TextUtils.isEmpty(strOptString4)) {
                    editorEdit.putString(TIMING_UPLOAD_LOG_CONFIG, "");
                } else {
                    editorEdit.putString(TIMING_UPLOAD_LOG_CONFIG, strOptString4.replaceAll("&quot;", "\""));
                }
            } else {
                editorEdit.putString(TIMING_UPLOAD_LOG_CONFIG, "");
            }
            editorEdit.commit();
            return 0;
        } catch (JSONException unused) {
            return RongIMClient.ErrorCode.RC_NODE_NOT_FOUND.getValue();
        }
    }

    static String getBaiDuMediaServer(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString(BAI_DU_MEDIA_SERVER, DEFAULT_MEDIA_SERVER_HOST_BAIDU);
    }

    public static long getCachedTime() {
        return sCacheTime;
    }

    public static String getClientIp(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString(CLIENT_IP, "");
    }

    public static List<String> getConnectionCmpList(Context context) {
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0);
        String string = sharedPreferences.getString(CMP_SERVER, null);
        String string2 = sharedPreferences.getString(BACKUP_SERVER, null);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(string)) {
            arrayList.add(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            for (String str : string2.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public static int getGifSizeLimit(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getInt(GIF_SIZE, 2048);
    }

    public static int getGroupMessageLimit(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getInt(GET_GROUP_MESSAGE_LIMIT, 1000);
    }

    private static String getLastSuccessNaviDomainList(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_IP_PREFERENCE, 0).getString(LAST_SUCCESS_NAVI, null);
    }

    public static LocationConfig getLocationConfig(Context context) {
        String string = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString("location", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                LocationConfig locationConfig = new LocationConfig();
                JSONObject jSONObject = new JSONObject(string);
                locationConfig.setConfigure(jSONObject.optBoolean("configure"));
                if (jSONObject.has("conversationTypes")) {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("conversationTypes");
                    int[] iArr = new int[jSONArrayOptJSONArray.length()];
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        iArr[i] = jSONArrayOptJSONArray.optInt(i);
                    }
                    locationConfig.setConversationTypes(iArr);
                }
                locationConfig.setMaxParticipant(jSONObject.optInt("maxParticipant"));
                locationConfig.setDistanceFilter(jSONObject.optInt("distanceFilter"));
                locationConfig.setRefreshInterval(jSONObject.optInt("refreshInterval"));
                return locationConfig;
            } catch (JSONException e2) {
                RLog.e(TAG, "getLocationConfig ", e2);
            }
        }
        return null;
    }

    public static int getLogMonitor(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getInt(LOG_MONITOR, 0);
    }

    static String getMediaServer(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString(MEDIA_SERVER, null);
    }

    public static List<FilePlatformInfo> getMediaServerCache(Context context) {
        try {
            SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0);
            List<FilePlatformInfo> mediaServerConfig = sharedPreferences.contains(MEDIA_SERVER_CONFIG) ? getMediaServerConfig(sharedPreferences) : null;
            if (mediaServerConfig != null && mediaServerConfig.size() != 0) {
                return mediaServerConfig;
            }
            return getOldMediaServerConfig(sharedPreferences);
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, " getMediaServerCache ", e2);
            return null;
        }
    }

    private static List<FilePlatformInfo> getMediaServerConfig(SharedPreferences sharedPreferences) {
        ArrayList arrayList = new ArrayList();
        try {
            for (p pVar : new s().a(sharedPreferences.getString(MEDIA_SERVER_CONFIG, null)).c()) {
                String strH = null;
                String strH2 = "";
                FtConst.ServiceType serviceTypeReverse = null;
                for (String str : pVar.e().m()) {
                    if (TextUtils.equals(str, FtConst.ServiceType.QI_NIU.getName())) {
                        serviceTypeReverse = FtConst.ServiceType.reverse(str);
                        strH = pVar.e().a(str).h();
                    } else if (TextUtils.equals(str, FtConst.ServiceType.BAI_DU.getName())) {
                        serviceTypeReverse = FtConst.ServiceType.reverse(str);
                        strH = pVar.e().a(str).h();
                        if (TextUtils.isEmpty(strH)) {
                            strH = DEFAULT_MEDIA_SERVER_HOST_BAIDU;
                        }
                    } else if (TextUtils.equals(str, FtConst.ServiceType.ALI_OSS.getName())) {
                        serviceTypeReverse = FtConst.ServiceType.reverse(str);
                        strH = pVar.e().a(str).h();
                    } else if (TextUtils.equals(str, au.aw)) {
                        strH2 = pVar.e().a(str).h();
                    }
                }
                if (serviceTypeReverse != null) {
                    arrayList.add(new FilePlatformInfo(strH, strH2, serviceTypeReverse));
                }
            }
            Collections.sort(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, " getMediaServerConfig ", e2);
            arrayList.clear();
        }
        return arrayList;
    }

    @Deprecated
    public static String getOfflineLogServer(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString(OFFLINE_LOG_SERVER, "https://feedback.cn.ronghub.com");
    }

    private static List<FilePlatformInfo> getOldMediaServerConfig(SharedPreferences sharedPreferences) {
        ArrayList arrayList = new ArrayList();
        try {
            String string = sharedPreferences.getString(MEDIA_SERVER, null);
            String string2 = sharedPreferences.getString(BAI_DU_MEDIA_SERVER, DEFAULT_MEDIA_SERVER_HOST_BAIDU);
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(new FilePlatformInfo(string, FtConst.ServiceType.QI_NIU.getPriority(), FtConst.ServiceType.QI_NIU));
            }
            if (!TextUtils.isEmpty(string2)) {
                arrayList.add(new FilePlatformInfo(string, FtConst.ServiceType.BAI_DU.getPriority(), FtConst.ServiceType.BAI_DU));
            }
            Collections.sort(arrayList);
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.e(TAG, " getOldMediaServerConfig ", e2);
            arrayList.clear();
        }
        return arrayList;
    }

    @Deprecated
    public static String getOnlineLogServer(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString(ONLINE_LOG_SERVER, null);
    }

    public static boolean getPrivateCloudConfig(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean("type", false);
    }

    public static String getRealTimeLogConfig(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString(TIMING_UPLOAD_LOG_CONFIG, null);
    }

    public static String getToken(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString("token", "");
    }

    public static String getUserId(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString("userId", null);
    }

    public static int getVideoLimitTime(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getInt(VIDEO_TIMES, Integer.valueOf(DEFAULT_VIDEO_TIME).intValue());
    }

    static String getVoIPCallInfo(Context context) {
        String string;
        synchronized (lock) {
            string = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getString(VOIP_CALL_INFO, null);
        }
        return string;
    }

    public static boolean isCMPValid(String str) {
        return CMPStrategy.getInstance().isCMPValid(str);
    }

    static boolean isCacheTimeout(Context context) {
        long j = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getLong(CACHED_TIME, 0L);
        return j != 0 && (System.currentTimeMillis() - ((long) TimeZone.getDefault().getRawOffset())) - j > TIME_OUT;
    }

    public static boolean isCacheValid(Context context, String str, String str2, String str3) {
        if (getConnectionCmpList(context).size() == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0);
        String string = sharedPreferences.getString("appKey", null);
        String string2 = sharedPreferences.getString("token", null);
        String string3 = sharedPreferences.getString("userId", null);
        String lastSuccessNaviDomainList = getLastSuccessNaviDomainList(context);
        sCacheTime = sharedPreferences.getLong(CACHED_TIME, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) TimeZone.getDefault().getRawOffset());
        boolean z = string != null && string.equals(str) && string2 != null && string2.equals(str2) && jCurrentTimeMillis - sCacheTime <= TIME_OUT && !TextUtils.isEmpty(string3) && isNaviUrlsValid(lastSuccessNaviDomainList, str3);
        FwLog.write(3, 1, FwLog.LogTag.L_GET_NAVI_S.getTag(), "cache_valid|delta_time", Boolean.valueOf(z), Long.valueOf(jCurrentTimeMillis - sCacheTime));
        return z;
    }

    static boolean isChatroomHistoryEnabled(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(GET_CHATROOM_HISTORY_SERVICE, false);
    }

    public static boolean isConnPolicyEnable(Context context) {
        boolean z = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getInt(CONN_POLICY, 0) == 1;
        RLog.i(TAG, "isConnPolicyEnable, userPolicy = " + userPolicy + ", naviPolicy = " + z);
        if (z) {
            return true;
        }
        return userPolicy;
    }

    public static boolean isDnsEnabled(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(OPEN_DNS, false);
    }

    static boolean isGetRemoteEnabled(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(GET_REMOTE_SERVICE, false);
    }

    public static boolean isJoinMChatroomEnabled(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(JOIN_MULTI_CHATROOM, false);
    }

    public static boolean isKvStorageEnabled(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(KV_STORAGE, false);
    }

    static boolean isMPOpened(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(OPEN_MP, true);
    }

    private static boolean isNaviUrlsValid(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        return str2.equals(str);
    }

    public static boolean isPhraseEnabled(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(EXT_KIT_SWITCH, false);
    }

    static boolean isUSOpened(Context context) {
        return SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).getBoolean(OPEN_US, false);
    }

    static String queryRequestIP(String str) {
        DNSResolve dNSResolve = new DNSResolve(str);
        dNSResolve.resolveHost();
        return dNSResolve.getIP();
    }

    public static void saveUserId(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit();
        editorEdit.putString("userId", str);
        editorEdit.apply();
    }

    public static void setUserPolicy(boolean z) {
        RLog.i(TAG, "setUserPolicy, userPolicy = " + z);
        userPolicy = z;
    }

    static void updateClientIp(Context context, String str) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit();
        editorEdit.putString(CLIENT_IP, str);
        editorEdit.commit();
    }

    public static void updateTime(Context context, long j) {
        SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit();
        editorEdit.putLong(CACHED_TIME, j);
        editorEdit.commit();
    }

    public static void updateVoIPCallInfo(Context context, String str) {
        synchronized (lock) {
            SharedPreferences.Editor editorEdit = SharedPreferencesUtils.get(context, NAVIGATION_PREFERENCE, 0).edit();
            editorEdit.putString(VOIP_CALL_INFO, str);
            editorEdit.commit();
        }
    }
}
