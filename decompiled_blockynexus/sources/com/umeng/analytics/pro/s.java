package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.c;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.w;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: compiled from: SessionTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class s implements w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20931a = "session_start_time";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20932b = "session_end_time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20933c = "session_id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20934d = "pre_session_id";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f20935e = "a_start_time";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f20936f = "a_end_time";
    private static String g;
    private static Context h;
    private static boolean i;
    private static long j;

    /* JADX INFO: compiled from: SessionTracker.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final s f20937a = new s();

        private a() {
        }
    }

    public static s a() {
        return a.f20937a;
    }

    public void b(Context context, Object obj) {
        try {
            if (h == null) {
                h = UMGlobalContext.getAppContext(context);
            }
            long jCurrentTimeMillis = obj == null ? System.currentTimeMillis() : ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(h);
            if (sharedPreferences == null) {
                return;
            }
            j = sharedPreferences.getLong(f20936f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + j);
            String string = sharedPreferences.getString(b.aw, "");
            String appVersionName = UMUtils.getAppVersionName(h);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit == null) {
                return;
            }
            if (TextUtils.isEmpty(string) || string.equals(appVersionName)) {
                if (!w.a().e(h)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
                    i = false;
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                i = true;
                editorEdit.putLong(f20931a, jCurrentTimeMillis);
                editorEdit.commit();
                a(h, jCurrentTimeMillis, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
            editorEdit.putLong(f20931a, jCurrentTimeMillis);
            editorEdit.commit();
            m.a(h).a((Object) null, true);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + w.a().c(h));
            i = true;
            a(h, jCurrentTimeMillis, true);
        } catch (Throwable unused) {
        }
    }

    public void c(Context context, Object obj) {
        try {
            if (h == null && context != null) {
                h = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f20935e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + jLongValue);
            editorEdit.putLong(f20936f, jLongValue);
            editorEdit.putLong(f20932b, jLongValue);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    private s() {
        w.a().a(this);
    }

    public void a(Context context, long j2) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(h);
        if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putLong(f20931a, j2);
        editorEdit.commit();
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor editorEdit;
        try {
            if (h == null && context != null) {
                h = context.getApplicationContext();
            }
            long jLongValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(h);
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(b.aw, "");
            String appVersionName = UMUtils.getAppVersionName(h);
            if (TextUtils.isEmpty(string)) {
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(b.aw, appVersionName);
                editorEdit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(b.aw, "");
                editorEdit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                editorEdit.putString(b.aw, appVersionName);
                editorEdit.putString("vers_date", string2);
                editorEdit.putString("vers_pre_version", string3);
                editorEdit.putString("cur_version", string4);
                editorEdit.putInt("vers_code", i2);
                editorEdit.putString("vers_name", string);
                editorEdit.commit();
                if (i) {
                    i = false;
                    b(h, jLongValue, true);
                    b(h, jLongValue);
                    return;
                }
                return;
            }
            if (i) {
                i = false;
                g = b(context);
                MLog.d("创建新会话: " + g);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + g);
                return;
            }
            g = sharedPreferences.getString("session_id", null);
            editorEdit.putLong(f20935e, jLongValue);
            editorEdit.putLong(f20936f, 0L);
            editorEdit.commit();
            MLog.d("延续上一个会话: " + g);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + g);
            c(context);
            m.a(h).a(false);
        } catch (Throwable unused) {
        }
    }

    private void c(Context context) {
        m.a(context).b(context);
        m.a(context).d();
    }

    public String c() {
        return a(h);
    }

    private String b(Context context) {
        if (h == null && context != null) {
            h = context.getApplicationContext();
        }
        String strD = w.a().d(h);
        try {
            c(context);
            m.a(h).d((Object) null);
        } catch (Throwable unused) {
        }
        return strD;
    }

    public boolean b(Context context, long j2, boolean z) {
        String strA;
        long j3;
        boolean z2 = false;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (strA = w.a().a(h)) == null) {
                return false;
            }
            long j4 = sharedPreferences.getLong(f20935e, 0L);
            long j5 = sharedPreferences.getLong(f20936f, 0L);
            if (j4 > 0 && j5 == 0) {
                z2 = true;
                if (z) {
                    if (j == 0) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                        j3 = j2;
                    } else {
                        j3 = j;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + j);
                    }
                    c(h, Long.valueOf(j3));
                } else {
                    c(h, Long.valueOf(j2));
                    j3 = j2;
                }
                JSONObject jSONObject = new JSONObject();
                if (z) {
                    jSONObject.put(c.d.a.g, j3);
                } else {
                    jSONObject.put(c.d.a.g, j2);
                }
                JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
                if (jSONObjectB != null && jSONObjectB.length() > 0) {
                    jSONObject.put("__sp", jSONObjectB);
                }
                JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
                if (jSONObjectC != null && jSONObjectC.length() > 0) {
                    jSONObject.put("__pp", jSONObjectC);
                }
                g.a(context).a(strA, jSONObject, g.a.END);
                m.a(h).e();
            }
        } catch (Throwable unused) {
        }
        return z2;
    }

    public String a(Context context, long j2, boolean z) {
        String strB = w.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + strB);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            g.a(context).a(strB, jSONObject, g.a.INSTANTSESSIONBEGIN);
            m.a(context).a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return strB;
    }

    public void b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            m.a(h).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String b() {
        return g;
    }

    public String a(Context context) {
        try {
            if (g == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return g;
    }

    @Override // com.umeng.analytics.pro.w.a
    public void a(String str, String str2, long j2, long j3) throws Throwable {
        a(h, str2, j2, j3);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = h;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.w.a
    public void a(String str, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    private void a(Context context, String str, long j2, long j3) throws Throwable {
        if (TextUtils.isEmpty(g)) {
            g = w.a().a(h);
        }
        if (TextUtils.isEmpty(str) || str.equals(g)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(c.d.a.g, j3);
            JSONObject jSONObjectB = com.umeng.analytics.b.a().b();
            if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject.put("__sp", jSONObjectB);
            }
            JSONObject jSONObjectC = com.umeng.analytics.b.a().c();
            if (jSONObjectC != null && jSONObjectC.length() > 0) {
                jSONObject.put("__pp", jSONObjectC);
            }
            g.a(context).a(g, jSONObject, g.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            g.a(context).a(str, jSONObject2, g.a.BEGIN);
        } catch (Exception unused2) {
        }
        g = str;
    }

    private void a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(h);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(f20932b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(c.d.a.g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(b.B, location[0]);
                jSONObject2.put(b.C, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(c.d.a.f20812e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i2 = h.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long jLongValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long jLongValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (jLongValue > 0 && jLongValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(b.G, jLongValue);
                jSONObject3.put(b.F, jLongValue2);
                jSONObject.put("__c", jSONObject3);
            }
            g.a(h).a(str, jSONObject, g.a.NEWSESSION);
            t.a(h);
            j.b(h);
        } catch (Throwable unused) {
        }
    }
}
