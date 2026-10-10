package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tendcloud.tenddata.ab;
import com.umeng.analytics.pro.h;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class MobclickAgent {

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f20579a;

        EScenarioType(int i) {
            this.f20579a = i;
        }

        public int toValue() {
            return this.f20579a;
        }
    }

    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() throws Throwable {
        b.a().a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    public static void enableEncrypt(boolean z) {
    }

    public static b getAgent() {
        return b.a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().h(context);
    }

    private static void init(Context context) {
        b.a().a(context);
    }

    public static void onDeepLinkReceived(Context context, String str) throws Throwable {
        b.a().b(context, str);
    }

    public static void onEvent(Context context, String str) throws Throwable {
        b.a().a(context, str, (String) null, -1L, 1);
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) throws Throwable {
        if (map == null) {
            UMLog.aq(h.f20872a, 0, "\\|");
        } else {
            b.a().a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) throws Throwable {
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("__ct__", Integer.valueOf(i));
        b.a().a(context, str, map2, -1L);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> map) throws Throwable {
        b.a().a(context, str, map);
    }

    public static void onKillProcess(Context context) {
        b.a().d(context);
    }

    public static void onPageEnd(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(h.D, 0, "\\|");
        } else {
            b.a().b(str);
        }
    }

    public static void onPageStart(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(h.C, 0, "\\|");
        } else {
            b.a().a(str);
        }
    }

    public static void onPause(Context context) throws Throwable {
        b.a().c(context);
    }

    public static void onProfileSignIn(String str) throws Throwable {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() throws Throwable {
        b.a().j();
    }

    public static void onResume(Context context) throws Throwable {
        if (context == null) {
            UMLog.aq(h.n, 0, "\\|");
        } else {
            b.a().b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().a(context, jSONObject);
    }

    public static void reportError(Context context, String str) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("generateCustomLog", String.class, String.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls, str, MessengerShareContentUtility.PREVIEW_DEFAULT);
        } catch (Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) throws Throwable {
        b.a().a(z);
    }

    public static void setCheckDevice(boolean z) {
    }

    public static void setDebugMode(boolean z) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().a(context, list);
    }

    private static void setGameScenarioType(Context context) throws Throwable {
        b.a().a(context, EScenarioType.E_UM_GAME);
    }

    public static void setLatencyWindow(long j) {
    }

    public static void setLocation(double d2, double d3) throws Throwable {
        b.a().a(d2, d3);
    }

    public static void setOpenGLContext(GL10 gl10) {
        b.a().a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) throws Throwable {
        b.a().a(pageMode);
    }

    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) throws Throwable {
        b.a().c(context, str);
    }

    public static void setSessionContinueMillis(long j) throws Throwable {
        if (j <= ab.R) {
            j = 30000;
        }
        b.a().a(j);
    }

    private static void setSysListener(ISysListener iSysListener) throws Throwable {
        b.a().a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().f(context, str);
    }

    public static void onEvent(Context context, String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(h.k, 0, "\\|");
        } else {
            b.a().a(context, str, str2, -1L, 1);
        }
    }

    public static void onProfileSignIn(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(h.t, 0, "\\|");
            return;
        }
        if (str2.length() > 64) {
            UMLog.aq(h.u, 0, "\\|");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.a().a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.aq(h.v, 0, "\\|");
        } else {
            b.a().a(str, str2);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) throws Throwable {
        if (map == null) {
            UMLog.aq(h.f20872a, 0, "\\|");
        } else {
            b.a().a(context, str, new HashMap(map), -1L);
        }
    }

    public static void reportError(Context context, Throwable th) {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("generateCustomLog", Throwable.class, String.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(cls, th, MessengerShareContentUtility.PREVIEW_DEFAULT);
        } catch (Throwable unused) {
        }
    }
}
