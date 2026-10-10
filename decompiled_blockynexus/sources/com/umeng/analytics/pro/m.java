package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sandboxol.center.config.StringConstant;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfigEx;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CoreProtocolImpl.java */
/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f20893a = null;
    private static final String l = "first_activate_time";
    private static final String m = "ana_is_f";
    private static final String n = "thtstart";
    private static final String o = "dstk_last_time";
    private static final String p = "dstk_cnt";
    private static final String q = "gkvc";
    private static final String r = "ekvc";
    private static final String t = "-1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f20894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f20895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f20897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20898f;
    private JSONArray g;
    private final int h;
    private int i;
    private int j;
    private long k;
    private final long s;
    private boolean u;
    private boolean v;
    private Object w;

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class a {
        public static final int A = 8212;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f20899a = 4097;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f20900b = 4098;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f20901c = 4099;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f20902d = 4100;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f20903e = 4101;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f20904f = 4102;
        public static final int g = 4103;
        public static final int h = 4104;
        public static final int i = 4105;
        public static final int j = 4106;
        public static final int k = 4352;
        public static final int l = 4353;
        public static final int m = 4354;
        public static final int n = 4355;
        public static final int o = 8193;
        public static final int p = 8194;
        public static final int q = 8195;
        public static final int r = 8196;
        public static final int s = 8197;
        public static final int t = 8199;
        public static final int u = 8200;
        public static final int v = 8201;
        public static final int w = 8208;
        public static final int x = 8209;
        public static final int y = 8210;
        public static final int z = 8211;
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final m f20905a = new m();

        private b() {
        }
    }

    public static m a(Context context) {
        if (f20893a == null && context != null) {
            f20893a = context.getApplicationContext();
        }
        return b.f20905a;
    }

    private void b(JSONObject jSONObject) {
        JSONObject jSONObjectF;
        if (g.a(UMGlobalContext.getAppContext(f20893a)).c() || (jSONObjectF = g.a(UMGlobalContext.getAppContext(f20893a)).f()) == null) {
            return;
        }
        String strOptString = jSONObjectF.optString("__av");
        String strOptString2 = jSONObjectF.optString("__vc");
        try {
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject.put("app_version", UMUtils.getAppVersionName(f20893a));
            } else {
                jSONObject.put("app_version", strOptString);
            }
            if (TextUtils.isEmpty(strOptString2)) {
                jSONObject.put("version_code", UMUtils.getAppVersionCode(f20893a));
            } else {
                jSONObject.put("version_code", strOptString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Object obj) throws Throwable {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.i)) {
                    return;
                } else {
                    this.i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.k, this.j)) {
                    return;
                } else {
                    this.j++;
                }
            }
            if (this.g.length() >= this.f20898f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                g.a(f20893a).a(this.g);
                this.g = new JSONArray();
            }
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        try {
            if (!jSONObject.getJSONObject("header").has(com.umeng.analytics.pro.b.ay)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.length() > 0 && jSONObjectOptJSONObject.has(com.umeng.analytics.pro.b.n)) {
                    g.a(f20893a).a(true, false);
                }
                g.a(f20893a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("analytics");
                if (jSONObject2.has(com.umeng.analytics.pro.b.n) && (jSONObjectOptJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.b.n).optJSONObject(0)) != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(strOptString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        g.a(f20893a).b(strOptString);
                    }
                }
            }
            g.a(f20893a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            UMWorkDispatch.sendEvent(f20893a, a.l, CoreProtocol.getInstance(f20893a), null);
        } catch (Exception unused) {
        }
    }

    private void h() throws Throwable {
        JSONObject jSONObjectB = b(UMEnvelopeBuild.maxDataSpace(f20893a));
        if (jSONObjectB == null || jSONObjectB.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectB.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectB.opt("content");
        if (f20893a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f20893a, jSONObject, jSONObject2);
        if (jSONObjectBuildEnvelopeWithExtHeader != null) {
            try {
                if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(jSONObjectBuildEnvelopeWithExtHeader);
            }
            b((Object) jSONObjectBuildEnvelopeWithExtHeader);
        }
    }

    private void i() throws Throwable {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        JSONObject jSONObjectA = a(UMEnvelopeBuild.maxDataSpace(f20893a));
        if (jSONObjectA == null || jSONObjectA.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectA.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectA.opt("content");
        Context context = f20893a;
        if (context == null || jSONObject == null || jSONObject2 == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(jSONObjectBuildEnvelopeWithExtHeader);
        }
        a((Object) jSONObjectBuildEnvelopeWithExtHeader);
    }

    private JSONObject j() {
        JSONObject jSONObjectK = k();
        if (jSONObjectK != null) {
            try {
                jSONObjectK.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return jSONObjectK;
    }

    private JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put("wrapper_version", AnalyticsConfig.mWrapperVersion);
                jSONObject.put("wrapper_type", AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f20893a);
            jSONObject.put(com.umeng.analytics.pro.b.i, verticalType);
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f20893a);
                if (TextUtils.isEmpty(gameSdkVersion)) {
                    gameSdkVersion = "9.1.6+000";
                }
                jSONObject.put("sdk_version", gameSdkVersion);
            } else {
                jSONObject.put("sdk_version", "9.1.6+000");
            }
            String strMD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f20893a));
            if (!TextUtils.isEmpty(strMD5)) {
                jSONObject.put("secret", strMD5);
            }
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(f20893a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f20893a);
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(f20893a, com.umeng.analytics.pro.b.ak, "");
            if (!TextUtils.isEmpty(strImprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.analytics.pro.b.am, "");
                } else {
                    jSONObject.put(com.umeng.analytics.pro.b.am, strImprintProperty2);
                }
            }
            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(f20893a, com.umeng.analytics.pro.b.al, "");
            if (!TextUtils.isEmpty(strImprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.analytics.pro.b.an, "");
                } else {
                    jSONObject.put(com.umeng.analytics.pro.b.an, strImprintProperty3);
                }
            }
            jSONObject.put(com.umeng.analytics.pro.b.ae, "1.0.0");
            if (r()) {
                jSONObject.put(com.umeng.analytics.pro.b.ag, "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.analytics.pro.b.l, l());
            jSONObject.put(com.umeng.analytics.pro.b.m, m());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(strImprintProperty)) {
                        jSONObject.put(com.umeng.analytics.pro.b.l, sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.analytics.pro.b.m, sharedPreferences.getString("vers_date", str));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfigEx.getAppVersionName(f20893a)).putString("pre_date", str).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String l() {
        String string;
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(f20893a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strImprintProperty)) {
            string = strImprintProperty;
        } else {
            if (!TextUtils.isEmpty(this.f20896d)) {
                return this.f20896d;
            }
            if (this.f20895c == null) {
                this.f20895c = PreferenceWrapper.getDefault(f20893a);
            }
            String string2 = this.f20895c.getString("pre_version", "");
            String appVersionName = DeviceConfigEx.getAppVersionName(f20893a);
            if (TextUtils.isEmpty(string2)) {
                this.f20895c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                string = "0";
            } else {
                string = this.f20895c.getString("cur_version", "");
                if (appVersionName.equals(string)) {
                    string = string2;
                } else {
                    this.f20895c.edit().putString("pre_version", string).putString("cur_version", appVersionName).commit();
                }
            }
        }
        this.f20896d = string;
        return string;
    }

    private String m() {
        String string;
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(f20893a, "ud_da", null);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strImprintProperty)) {
            string = strImprintProperty;
        } else {
            if (!TextUtils.isEmpty(this.f20897e)) {
                return this.f20897e;
            }
            if (this.f20895c == null) {
                this.f20895c = PreferenceWrapper.getDefault(f20893a);
            }
            string = this.f20895c.getString("pre_date", "");
            if (TextUtils.isEmpty(string)) {
                string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                this.f20895c.edit().putString("pre_date", string).commit();
            } else {
                String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                if (!string.equals(str)) {
                    this.f20895c.edit().putString("pre_date", str).commit();
                    string = str;
                }
            }
        }
        this.f20897e = string;
        return string;
    }

    private void n() {
        try {
            this.i = 0;
            this.j = 0;
            this.k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f20893a).edit().putLong(o, System.currentTimeMillis()).putInt(p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean o() {
        try {
            if (!TextUtils.isEmpty(s.a().b())) {
                b(f20893a);
            }
            if (this.g.length() <= 0) {
                return false;
            }
            for (int i = 0; i < this.g.length(); i++) {
                JSONObject jSONObjectOptJSONObject = this.g.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("__i");
                    if (TextUtils.isEmpty(strOptString) || t.equals(strOptString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void p() {
        if (this.g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.g.length(); i++) {
                try {
                    JSONObject jSONObject = this.g.getJSONObject(i);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String strOptString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(strOptString) || t.equals(strOptString)) {
                            String strB = s.a().b();
                            if (TextUtils.isEmpty(strB)) {
                                strB = t;
                            }
                            jSONObject.put("__i", strB);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.g = jSONArray;
        }
    }

    private void q() {
        SharedPreferences sharedPreferences;
        try {
            if (!r() || f20893a == null || (sharedPreferences = PreferenceWrapper.getDefault(f20893a)) == null || sharedPreferences.getLong(l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean r() {
        SharedPreferences sharedPreferences;
        try {
            if (f20893a == null || (sharedPreferences = PreferenceWrapper.getDefault(f20893a)) == null) {
                return false;
            }
            return sharedPreferences.getLong(m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() throws Throwable {
        b(f20893a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                g.a(f20893a).a(this.g);
                this.g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f20893a).edit().putLong(n, this.k).putInt(q, this.i).putInt(r, this.j).commit();
        } catch (Throwable unused) {
        }
    }

    private m() {
        this.f20894b = null;
        this.f20895c = null;
        this.f20896d = null;
        this.f20897e = null;
        this.f20898f = 10;
        this.g = new JSONArray();
        this.h = 5000;
        this.i = 0;
        this.j = 0;
        this.k = 0L;
        this.s = 28800000L;
        this.u = false;
        this.v = false;
        this.w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f20893a);
            this.k = sharedPreferences.getLong(n, 0L);
            this.i = sharedPreferences.getInt(q, 0);
            this.j = sharedPreferences.getInt(r, 0);
            this.f20894b = new c();
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (jSONObject.getJSONObject("header").has(com.umeng.analytics.pro.b.ay)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has("analytics")) {
                    if (!jSONObject.getJSONObject("analytics").has(com.umeng.analytics.pro.b.n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    g.a(f20893a).i();
                    g.a(f20893a).h();
                    g.a(f20893a).b(true, false);
                    g.a(f20893a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has("analytics") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.length() > 0) {
                if (jSONObjectOptJSONObject.has(com.umeng.analytics.pro.b.n)) {
                    g.a(f20893a).b(true, false);
                }
                if (jSONObjectOptJSONObject.has("ekv") || jSONObjectOptJSONObject.has(com.umeng.analytics.pro.b.S)) {
                    g.a(f20893a).h();
                }
                if (jSONObjectOptJSONObject.has("error")) {
                    g.a(f20893a).i();
                }
            }
            g.a(f20893a).a();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ReportPolicy.ReportStrategy f20906a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20907b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20908c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20909d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20910e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ABTest f20911f;

        public c() {
            this.f20911f = null;
            this.f20911f = ABTest.getService(m.f20893a);
        }

        public void a() {
            try {
                int[] iArrA = a(-1, -1);
                this.f20907b = iArrA[0];
                this.f20908c = iArrA[1];
            } catch (Throwable unused) {
            }
        }

        protected void b() {
            int iA;
            Defcon service = Defcon.getService(m.f20893a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f20906a;
                this.f20906a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f20906a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(m.f20893a), service);
            } else {
                boolean z = Integer.valueOf(UMEnvelopeBuild.imprintProperty(m.f20893a, "integrated_test", m.t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z && !MLog.DEBUG) {
                    UMLog.mutlInfo(h.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z) {
                    this.f20906a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(m.f20893a));
                } else if (this.f20911f.isInTest() && "RPT".equals(this.f20911f.getTestName())) {
                    if (this.f20911f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(m.f20893a, "test_report_interval", m.t)).intValue() != -1) {
                            iA = a(90000);
                        } else {
                            iA = this.f20908c;
                            if (iA <= 0) {
                                iA = this.f20910e;
                            }
                        }
                    } else {
                        iA = 0;
                    }
                    this.f20906a = b(this.f20911f.getTestPolicy(), iA);
                } else {
                    int i = this.f20909d;
                    int i2 = this.f20910e;
                    int i3 = this.f20907b;
                    if (i3 != -1) {
                        i2 = this.f20908c;
                        i = i3;
                    }
                    this.f20906a = b(i, i2);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.f20906a instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(h.I, 3, "", null, null);
                    } else if (this.f20906a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(h.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.f20906a).getReportInterval() / 1000)});
                    } else if (this.f20906a instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(h.L, 3, "", null, null);
                    } else if (this.f20906a instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) this.f20906a).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(h.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z2 = this.f20906a instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f20906a;
        }

        public int[] a(int i, int i2) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(m.f20893a, "report_policy", m.t)).intValue();
            int iIntValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(m.f20893a, "report_interval", m.t)).intValue();
            if (iIntValue == -1 || !ReportPolicy.isValid(iIntValue)) {
                return new int[]{i, i2};
            }
            if (6 == iIntValue) {
                int i3 = 90;
                if (iIntValue2 != -1 && iIntValue2 >= 90 && iIntValue2 <= 86400) {
                    i3 = iIntValue2;
                }
                return new int[]{iIntValue, i3 * 1000};
            }
            if (11 == iIntValue) {
                int i4 = 15;
                if (iIntValue2 != -1 && iIntValue2 >= 15 && iIntValue2 <= 3600) {
                    i4 = iIntValue2;
                }
                return new int[]{iIntValue, i4 * 1000};
            }
            return new int[]{i, i2};
        }

        public int a(int i) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(m.f20893a, "test_report_interval", m.t)).intValue();
            return (iIntValue == -1 || iIntValue < 90 || iIntValue > 86400) ? i : iIntValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i, int i2) {
            if (i == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f20906a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f20906a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f20906a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(m.f20893a));
            }
            if (i == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f20906a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(m.f20893a);
            }
            if (i == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f20906a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i2);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(m.f20893a), i2);
            }
            if (i == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f20906a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(m.f20893a));
            }
            if (i != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f20906a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f20906a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i2);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i2);
            return reportQuasiRealtime;
        }
    }

    private void c(JSONObject jSONObject) throws Throwable {
        try {
            if (!g.a(f20893a).e()) {
                JSONObject jSONObjectG = g.a(f20893a).g();
                if (jSONObjectG != null) {
                    String strOptString = jSONObjectG.optString("__av");
                    String strOptString2 = jSONObjectG.optString("__vc");
                    if (TextUtils.isEmpty(strOptString)) {
                        jSONObject.put("app_version", UMUtils.getAppVersionName(f20893a));
                    } else {
                        jSONObject.put("app_version", strOptString);
                    }
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONObject.put("version_code", UMUtils.getAppVersionCode(f20893a));
                        return;
                    } else {
                        jSONObject.put("version_code", strOptString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put("app_version", UMUtils.getAppVersionName(f20893a));
            jSONObject.put("version_code", UMUtils.getAppVersionCode(f20893a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f20893a != null) {
            synchronized (this.w) {
                if (this.u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(f20893a, a.l, CoreProtocol.getInstance(f20893a), null);
                }
            }
            synchronized (this.w) {
                if (this.v) {
                    UMWorkDispatch.sendEvent(f20893a, a.m, CoreProtocol.getInstance(f20893a), null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, Object> f20912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f20913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f20914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f20915d;

        private d() {
            this.f20912a = null;
            this.f20913b = null;
            this.f20914c = null;
            this.f20915d = 0L;
        }

        public Map<String, Object> a() {
            return this.f20912a;
        }

        public String b() {
            return this.f20914c;
        }

        public String c() {
            return this.f20913b;
        }

        public long d() {
            return this.f20915d;
        }

        public d(String str, Map<String, Object> map, String str2, long j) {
            this.f20912a = null;
            this.f20913b = null;
            this.f20914c = null;
            this.f20915d = 0L;
            this.f20912a = map;
            this.f20913b = str;
            this.f20915d = j;
            this.f20914c = str2;
        }
    }

    private void d(JSONObject jSONObject) throws Throwable {
        String str;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                if (jSONObject4.has("ekv")) {
                    str = "appkey";
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        MLog.d("事件:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                } else {
                    str = "appkey";
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.S)) {
                    jSONObject3.put(com.umeng.analytics.pro.b.S, jSONObject4.getJSONArray(com.umeng.analytics.pro.b.S));
                    if (jSONObject3.length() > 0) {
                        MLog.d("游戏事件:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        MLog.d("错误:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.n)) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray(com.umeng.analytics.pro.b.n);
                    JSONArray jSONArray3 = new JSONArray();
                    int i = 0;
                    while (i < jSONArray2.length()) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            jSONArray = jSONArray2;
                        } else {
                            jSONArray = jSONArray2;
                            if (jSONObject5.has(com.umeng.analytics.pro.b.t)) {
                                jSONObject5.remove(com.umeng.analytics.pro.b.t);
                            }
                            jSONArray3.put(jSONObject5);
                        }
                        i++;
                        jSONArray2 = jSONArray;
                    }
                    jSONObject3.put(com.umeng.analytics.pro.b.n, jSONArray3);
                    if (jSONObject3.length() > 0) {
                        MLog.d("会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.H)) {
                    jSONObject3.put(com.umeng.analytics.pro.b.H, jSONObject4.getJSONObject(com.umeng.analytics.pro.b.H));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.K)) {
                    jSONObject3.put(com.umeng.analytics.pro.b.K, jSONObject4.getJSONObject(com.umeng.analytics.pro.b.K));
                    if (jSONObject3.length() > 0) {
                        MLog.d("账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            } else {
                str = "appkey";
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has("sdk_version")) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                }
                if (jSONObject2.has("device_id")) {
                    jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                }
                if (jSONObject2.has("device_model")) {
                    jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                }
                if (jSONObject2.has("version_code")) {
                    jSONObject3.put("version", jSONObject2.getInt("version_code"));
                }
                String str2 = str;
                if (jSONObject2.has(str2)) {
                    jSONObject3.put(str2, jSONObject2.getString(str2));
                }
                if (jSONObject2.has("channel")) {
                    jSONObject3.put("channel", jSONObject2.getString("channel"));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public JSONObject b(long j) throws Throwable {
        if (TextUtils.isEmpty(w.a().d(UMGlobalContext.getAppContext(f20893a)))) {
            return null;
        }
        JSONObject jSONObjectB = g.a(UMGlobalContext.getAppContext(f20893a)).b(false);
        String[] strArrA = com.umeng.analytics.c.a(f20893a);
        if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.b.L, strArrA[0]);
                jSONObject.put(com.umeng.analytics.pro.b.M, strArrA[1]);
                if (jSONObject.length() > 0) {
                    jSONObjectB.put(com.umeng.analytics.pro.b.K, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int iA = p.a().a(f20893a);
        if (jSONObjectB.length() == 1 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.b.K) != null && iA != 3) {
            return null;
        }
        p.a().b(jSONObjectB, f20893a);
        if (jSONObjectB.length() <= 0 && iA != 3) {
            return null;
        }
        JSONObject jSONObjectJ = j();
        if (jSONObjectJ != null) {
            b(jSONObjectJ);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (iA == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject3.put("analytics", jSONObjectB);
            }
            if (jSONObjectJ != null && jSONObjectJ.length() > 0) {
                jSONObject2.put("header", jSONObjectJ);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String strOptString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            g.a(f20893a).a(strOptString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private boolean c(boolean z) throws Throwable {
        if (r()) {
            return true;
        }
        if (this.f20894b == null) {
            this.f20894b = new c();
        }
        this.f20894b.a();
        ReportPolicy.ReportStrategy reportStrategyC = this.f20894b.c();
        boolean zShouldSendMessage = reportStrategyC.shouldSendMessage(z);
        if (zShouldSendMessage) {
            if (((reportStrategyC instanceof ReportPolicy.ReportByInterval) || (reportStrategyC instanceof ReportPolicy.DebugPolicy) || (reportStrategyC instanceof ReportPolicy.ReportQuasiRealtime)) && o()) {
                d();
            }
            if ((reportStrategyC instanceof ReportPolicy.DefconPolicy) && o()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + reportStrategyC.getClass().getSimpleName());
            }
        }
        return zShouldSendMessage;
    }

    private void e(JSONObject jSONObject) throws Throwable {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("analytics")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("analytics");
                if (jSONObject4.has(com.umeng.analytics.pro.b.n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.b.n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.b.n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.b.K)) {
                    jSONObject3.put(com.umeng.analytics.pro.b.K, jSONObject4.getJSONObject(com.umeng.analytics.pro.b.K));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("header") && jSONObject.has("header") && (jSONObject2 = jSONObject.getJSONObject("header")) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has("sdk_version")) {
                    jSONObject3.put("sdk_version", jSONObject2.getString("sdk_version"));
                }
                if (jSONObject2.has("device_id")) {
                    jSONObject3.put("device_id", jSONObject2.getString("device_id"));
                }
                if (jSONObject2.has("device_model")) {
                    jSONObject3.put("device_model", jSONObject2.getString("device_model"));
                }
                if (jSONObject2.has("version_code")) {
                    jSONObject3.put("version", jSONObject2.getInt("version_code"));
                }
                if (jSONObject2.has("appkey")) {
                    jSONObject3.put("appkey", jSONObject2.getString("appkey"));
                }
                if (jSONObject2.has("channel")) {
                    jSONObject3.put("channel", jSONObject2.getString("channel"));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj, int i) {
        if (AnalyticsConfig.enable) {
            try {
                switch (i) {
                    case a.f20899a /* 4097 */:
                        if (UMUtils.isMainProgress(f20893a)) {
                            if (obj != null) {
                                e(obj);
                            }
                            if (t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        }
                        UMProcessDBHelper.getInstance(f20893a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f20893a), new JSONArray().put(obj));
                        return;
                    case a.f20900b /* 4098 */:
                        if (obj != null) {
                            e(obj);
                        }
                        if (t.equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case a.f20901c /* 4099 */:
                        t.a(f20893a);
                        return;
                    case a.f20902d /* 4100 */:
                        j.b(f20893a);
                        return;
                    case a.f20903e /* 4101 */:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        a((Object) null, true);
                        g(obj);
                        return;
                    case a.f20904f /* 4102 */:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        a((Object) null, true);
                        f(obj);
                        return;
                    case a.g /* 4103 */:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        s.a().a(f20893a, obj);
                        synchronized (this.w) {
                            this.v = true;
                            break;
                        }
                        return;
                    case a.h /* 4104 */:
                        s.a().c(f20893a, obj);
                        return;
                    case a.i /* 4105 */:
                        d();
                        return;
                    case a.j /* 4106 */:
                        h(obj);
                        return;
                    default:
                        switch (i) {
                            case 4352:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                s.a().b(f20893a, obj);
                                synchronized (this.w) {
                                    this.u = true;
                                    break;
                                }
                                return;
                            case a.l /* 4353 */:
                                a(obj, true);
                                return;
                            case a.m /* 4354 */:
                                c();
                                return;
                            case a.n /* 4355 */:
                                if (!UMUtils.isMainProgress(f20893a)) {
                                    UMProcessDBHelper.getInstance(f20893a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f20893a), new JSONArray().put(obj));
                                    return;
                                } else {
                                    if (obj != null) {
                                        e(obj);
                                        d();
                                        return;
                                    }
                                    return;
                                }
                            default:
                                switch (i) {
                                    case a.q /* 8195 */:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case a.r /* 8196 */:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case a.s /* 8197 */:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i) {
                                            case a.t /* 8199 */:
                                            case a.u /* 8200 */:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case a.v /* 8201 */:
                                                com.umeng.analytics.b.a().b((Object) null);
                                                return;
                                            default:
                                                switch (i) {
                                                    case a.w /* 8208 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = f20893a;
                                                        UMWorkDispatch.sendEvent(context, a.x, CoreProtocol.getInstance(context), null);
                                                        Context context2 = f20893a;
                                                        UMWorkDispatch.sendEvent(context2, a.m, CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case a.x /* 8209 */:
                                                        a(obj, false);
                                                        return;
                                                    case a.y /* 8210 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (!UMUtils.isMainProgress(f20893a) || (this.f20894b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                            return;
                                                        }
                                                        a(true);
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                        }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f20893a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(com.umeng.analytics.pro.b.L);
                String string2 = jSONObject.getString(StringConstant.UID);
                long j = jSONObject.getLong("ts");
                String[] strArrA = com.umeng.analytics.c.a(f20893a);
                if (strArrA != null && string.equals(strArrA[0]) && string2.equals(strArrA[1])) {
                    return;
                }
                s.a().a(f20893a, j);
                String strC = w.a().c(f20893a);
                boolean zB = s.a().b(f20893a, j, false);
                com.umeng.analytics.c.a(f20893a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + strC);
                s.a().a(f20893a, j, true);
                if (zB) {
                    s.a().b(f20893a, j);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long jCurrentTimeMillis = 0;
        try {
            if (f20893a == null || (sharedPreferences = PreferenceWrapper.getDefault(f20893a)) == null) {
                return 0L;
            }
            long j = sharedPreferences.getLong(l, 0L);
            if (j == 0) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(l, jCurrentTimeMillis).commit();
                    return jCurrentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j;
        } catch (Throwable unused2) {
            return jCurrentTimeMillis;
        }
    }

    public void c(Object obj) throws Throwable {
        b(f20893a);
        d();
        if (d(false)) {
            i();
        }
    }

    private void f(Object obj) throws Throwable {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j = jSONObject.getLong("ts");
                b(f20893a);
                d();
                String[] strArrA = com.umeng.analytics.c.a(f20893a);
                if (strArrA == null || TextUtils.isEmpty(strArrA[0]) || TextUtils.isEmpty(strArrA[1])) {
                    return;
                }
                s.a().a(f20893a, j);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + w.a().c(f20893a));
                boolean zB = s.a().b(f20893a, j, false);
                com.umeng.analytics.c.b(f20893a);
                s.a().a(f20893a, j, true);
                if (zB) {
                    s.a().b(f20893a, j);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j) {
        try {
            if (o.a(jSONObject) <= j) {
                return jSONObject;
            }
            jSONObject = null;
            g.a(f20893a).a(true, false);
            g.a(f20893a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObjectA = null;
        try {
            jSONObjectA = g.a(f20893a).a(z);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            } else {
                try {
                    boolean zHas = jSONObjectA.has(com.umeng.analytics.pro.b.n);
                    jSONObjectA = jSONObjectA;
                    if (zHas) {
                        JSONArray jSONArray3 = jSONObjectA.getJSONArray(com.umeng.analytics.pro.b.n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i = 0;
                        while (i < jSONArray3.length()) {
                            JSONObject jSONObject = (JSONObject) jSONArray3.get(i);
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.umeng.analytics.pro.b.s);
                            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(com.umeng.analytics.pro.b.t);
                            if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 != null) {
                                jSONObject.put(com.umeng.analytics.pro.b.s, jSONArrayOptJSONArray2);
                                jSONObject.remove(com.umeng.analytics.pro.b.t);
                            }
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray.get(i2));
                                }
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray2.get(i3));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.b.w);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject.put(com.umeng.analytics.pro.b.s, jSONArray5);
                                jSONObject.remove(com.umeng.analytics.pro.b.t);
                            }
                            if (jSONObject.has(com.umeng.analytics.pro.b.s)) {
                                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(com.umeng.analytics.pro.b.s);
                                int i4 = 0;
                                while (i4 < jSONArrayOptJSONArray3.length()) {
                                    JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i4);
                                    if (jSONObject2.has(com.umeng.analytics.pro.b.w)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject2.put("ts", jSONObject2.getLong(com.umeng.analytics.pro.b.w));
                                        jSONObject2.remove(com.umeng.analytics.pro.b.w);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i4++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject.put(com.umeng.analytics.pro.b.s, jSONArrayOptJSONArray3);
                                jSONObject.put(com.umeng.analytics.pro.b.y, jSONArrayOptJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject.put(com.umeng.analytics.pro.b.y, 0);
                            }
                            jSONArray4.put(jSONObject);
                            i++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObjectA.put(com.umeng.analytics.pro.b.n, jSONArray4);
                        jSONObjectA = jSONObjectA;
                    }
                } catch (Exception e2) {
                    MLog.e("merge pages error");
                    e2.printStackTrace();
                    jSONObjectA = jSONObjectA;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f20893a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObjectA.put("userlevel", string);
                }
            }
            String[] strArrA = com.umeng.analytics.c.a(f20893a);
            if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(com.umeng.analytics.pro.b.L, strArrA[0]);
                jSONObject3.put(com.umeng.analytics.pro.b.M, strArrA[1]);
                if (jSONObject3.length() > 0) {
                    jSONObjectA.put(com.umeng.analytics.pro.b.K, jSONObject3);
                }
            }
            if (ABTest.getService(f20893a).isInTest()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(ABTest.getService(f20893a).getTestName(), ABTest.getService(f20893a).getGroupInfo());
                jSONObjectA.put(com.umeng.analytics.pro.b.J, jSONObject4);
            }
            p.a().a(jSONObjectA, f20893a);
        } catch (Throwable unused) {
        }
        return jSONObjectA;
    }

    public void e() throws Throwable {
        if (d(false)) {
            i();
        }
    }

    public void d(Object obj) throws Throwable {
        q();
        l();
        m();
        a(true);
    }

    private boolean d(boolean z) {
        if (this.f20894b == null) {
            this.f20894b = new c();
        }
        ReportPolicy.ReportStrategy reportStrategyC = this.f20894b.c();
        if (!(reportStrategyC instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z) {
            return ((ReportPolicy.DefconPolicy) reportStrategyC).shouldSendMessageByInstant();
        }
        return reportStrategyC.shouldSendMessage(false);
    }

    public void a(boolean z) throws Throwable {
        if (c(z)) {
            if (!(this.f20894b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f20893a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    i();
                    return;
                }
                return;
            }
            if (z) {
                if (UMEnvelopeBuild.isOnline(f20893a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    i();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(f20893a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                i();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List listAsList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && listAsList.contains(jSONObjectOptJSONObject.optString("id"))) {
                    i++;
                }
            } catch (Throwable unused) {
            }
        }
        return i >= length;
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ekv");
        int length = jSONArrayOptJSONArray.length();
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                        if (jSONArrayOptJSONArray2 != null && a(jSONArrayOptJSONArray2)) {
                            i++;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (i >= length) {
                return true;
            }
        }
        return false;
    }

    public void b(Context context) {
        try {
            g.a(context).d();
            p();
        } catch (Throwable unused) {
        }
    }

    public JSONObject a(long j) throws Throwable {
        if (TextUtils.isEmpty(w.a().d(f20893a))) {
            return null;
        }
        JSONObject jSONObjectB = b(false);
        int iA = p.a().a(f20893a);
        if (jSONObjectB.length() > 0) {
            if (jSONObjectB.length() == 1) {
                if (jSONObjectB.optJSONObject(com.umeng.analytics.pro.b.K) != null && iA != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                    return null;
                }
            } else if (jSONObjectB.length() == 2 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.b.K) != null && !TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                return null;
            }
            String strOptString = jSONObjectB.optString(com.umeng.analytics.pro.b.n);
            String strOptString2 = jSONObjectB.optString(com.umeng.analytics.pro.b.S);
            String strOptString3 = jSONObjectB.optString("ekv");
            if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && a(jSONObjectB)) {
                return null;
            }
        } else if (iA != 3) {
            return null;
        }
        JSONObject jSONObjectK = k();
        if (jSONObjectK != null) {
            c(jSONObjectK);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (iA == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject2.put("analytics", jSONObjectB);
            }
            if (jSONObjectK != null && jSONObjectK.length() > 0) {
                jSONObject.put("header", jSONObjectK);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j) {
        try {
            if (o.a(jSONObject) <= j) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.b.ay, o.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return o.a(f20893a, j, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j, int i) {
        if (j == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j <= 28800000) {
            return i < 5000;
        }
        n();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z) throws Throwable {
        if (z) {
            if (d(true)) {
                h();
            }
        } else if (UMEnvelopeBuild.isOnline(f20893a) && d(true)) {
            h();
        }
    }
}
