package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.sandboxol.center.config.StringConstant;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.pro.r;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.w;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InternalAgent.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements l, r {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f20587a = null;
    private static final String h = "sp_uapp";
    private static final String i = "prepp_uapp";
    private static final int o = 128;
    private static final int p = 256;
    private static String q = "";
    private static String r = "";
    private static final String s = "ekv_bl";
    private static final String t = "ekv_bl_ver";
    private static final String v = "ekv_wl";
    private static final String w = "ekv_wl_ver";
    private static final String z = "umsp_1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ISysListener f20588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n f20589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private t f20590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f20591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private s f20592f;
    private j g;
    private boolean j;
    private volatile JSONObject k;
    private volatile JSONObject l;
    private volatile JSONObject m;
    private boolean n;
    private com.umeng.analytics.filter.a u;
    private com.umeng.analytics.filter.b x;
    private k y;

    /* JADX INFO: compiled from: InternalAgent.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f20593a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f20587a = appContext.getApplicationContext();
        }
    }

    public static b a() {
        return a.f20593a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.k == null) {
                this.k = new JSONObject();
            }
            if (this.l == null) {
                this.l = new JSONObject();
            }
            String string = sharedPreferences.getString(i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.m == null) {
                this.m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.k;
    }

    public JSONObject c() {
        return this.m;
    }

    public JSONObject d() {
        return this.l;
    }

    public void e() {
        this.l = null;
    }

    public String f() throws Throwable {
        if (UMUtils.isMainProgress(f20587a)) {
            return q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() throws Throwable {
        if (UMUtils.isMainProgress(f20587a)) {
            return r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            if (f20587a != null) {
                if (!UMUtils.isMainProgress(f20587a)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                if (UMConfigure.isDebugLog() && !UMConfigure.getInitStatus()) {
                    UMLog.mutlInfo(h.H, 3, "", null, null);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                UMWorkDispatch.sendEvent(f20587a, 4352, CoreProtocol.getInstance(f20587a), Long.valueOf(jCurrentTimeMillis));
                UMWorkDispatch.sendEvent(f20587a, m.a.g, CoreProtocol.getInstance(f20587a), Long.valueOf(jCurrentTimeMillis));
            }
            if (this.f20588b != null) {
                this.f20588b.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    void j() throws Throwable {
        try {
            if (f20587a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f20587a)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", jCurrentTimeMillis);
            UMWorkDispatch.sendEvent(f20587a, m.a.f20904f, CoreProtocol.getInstance(f20587a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (f20587a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.k != null) {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f20587a).edit();
            editorEdit.putString(h, this.k.toString());
            editorEdit.commit();
        } else {
            this.k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        if (f20587a == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.k == null) {
            this.k = new JSONObject();
        }
        return this.k;
    }

    public synchronized void m() {
        try {
            if (f20587a != null) {
                if (!UMUtils.isMainProgress(f20587a)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f20587a).edit();
                    editorEdit.remove(h);
                    editorEdit.commit();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.umeng.analytics.pro.l
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManagerEx.b()) {
            if (!FieldManagerEx.allow(d.a.header_ekv_send_on_exit.name())) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(m.a.y)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f20587a;
                UMWorkDispatch.sendEvent(context, m.a.y, CoreProtocol.getInstance(context), null);
            }
        }
    }

    private b() {
        this.f20589c = new n();
        this.f20590d = new t();
        this.f20591e = new i();
        this.f20592f = s.a();
        this.g = null;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.u = null;
        this.x = null;
        this.y = null;
        this.f20589c.a(this);
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            if (this.u == null) {
                this.u = new com.umeng.analytics.filter.a("ekv_bl", "ekv_bl_ver");
                this.u.register(f20587a);
            }
            if (this.x == null) {
                this.x = new com.umeng.analytics.filter.b("ekv_wl", "ekv_wl_ver");
                this.x.register(f20587a);
            }
            if (UMUtils.isMainProgress(f20587a)) {
                if (!this.j) {
                    this.j = true;
                    i(f20587a);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.n) {
                            this.g = j.a(context);
                            if (this.g.a()) {
                                this.n = true;
                            }
                            this.y = k.a();
                            try {
                                k.a(context);
                                this.y.a(this);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else {
                    this.n = true;
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(h.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f20587a));
            }
        } catch (Throwable unused2) {
        }
    }

    void b(String str) throws Throwable {
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (j.f20879b != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f20590d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    void c(Context context) throws Throwable {
        if (context == null) {
            UMLog.aq(h.p, 0, "\\|");
            return;
        }
        if (j.f20879b == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(h.q, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (j.f20879b != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f20591e.b(context.getClass().getName());
            }
            i();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            r = context.getClass().getName();
        }
    }

    void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f20587a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            if (this.g != null) {
                this.g.c();
            }
            j.a(context, "onKillProcess");
            if (this.f20591e != null) {
                this.f20591e.b();
            }
            if (this.f20590d != null) {
                this.f20590d.b();
            }
            if (f20587a != null) {
                if (this.f20592f != null) {
                    this.f20592f.c(f20587a, Long.valueOf(System.currentTimeMillis()));
                }
                m.a(f20587a).d();
                t.a(f20587a);
                if (j.f20879b == MobclickAgent.PageMode.AUTO) {
                    j.b(f20587a);
                }
                PreferenceWrapper.getDefault(f20587a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(h.ai, 0, "\\|");
            return null;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(h.ag, 0, "\\|");
            return null;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.k == null) {
            this.k = new JSONObject();
        } else if (this.k.has(str)) {
            return this.k.opt(str);
        }
        return null;
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(h.ah, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        this.k = new JSONObject();
        UMWorkDispatch.sendEvent(f20587a, m.a.r, CoreProtocol.getInstance(f20587a), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(h.ap, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        if (this.m.length() > 0) {
            UMWorkDispatch.sendEvent(f20587a, m.a.v, CoreProtocol.getInstance(f20587a), null);
        }
        this.m = new JSONObject();
    }

    void b(Context context) throws Throwable {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (j.f20879b == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(h.o, 2, "\\|");
        }
        try {
            if (!this.j || !this.n) {
                a(context);
            }
            if (j.f20879b != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f20591e.a(context.getClass().getName());
            }
            h();
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                q = context.getClass().getName();
            }
        } catch (Throwable th) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public void i() {
        try {
            if (f20587a != null) {
                if (!UMUtils.isMainProgress(f20587a)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                UMWorkDispatch.sendEvent(f20587a, m.a.h, CoreProtocol.getInstance(f20587a), Long.valueOf(System.currentTimeMillis()));
                UMWorkDispatch.sendEvent(f20587a, m.a.f20902d, CoreProtocol.getInstance(f20587a), null);
                UMWorkDispatch.sendEvent(f20587a, m.a.f20901c, CoreProtocol.getInstance(f20587a), null);
                UMWorkDispatch.sendEvent(f20587a, m.a.i, CoreProtocol.getInstance(f20587a), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f20588b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(h.aq, 0, "\\|");
            return null;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(h.an, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.m.has(str)) {
                this.m.remove(str);
                UMWorkDispatch.sendEvent(f20587a, m.a.u, CoreProtocol.getInstance(f20587a), this.m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(h.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean c(String str) {
        if (this.u.enabled() && this.u.matchHit(str)) {
            return true;
        }
        if (!this.x.enabled()) {
            return false;
        }
        if (!this.x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(h.ah, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(h.ag, 0, "\\|");
            return;
        }
        if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.k == null) {
            this.k = new JSONObject();
        }
        if (this.k.has(str)) {
            this.k.remove(str);
            UMWorkDispatch.sendEvent(f20587a, m.a.s, CoreProtocol.getInstance(f20587a), str);
        }
    }

    public void b(Context context, String str) throws Throwable {
        try {
            if (context == null) {
                UMLog.aq(h.N, 0, "\\|");
                return;
            }
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f20587a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f20587a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap map = new HashMap();
                map.put(com.umeng.analytics.pro.b.aB, str);
                a(f20587a, com.umeng.analytics.pro.b.aA, (Map<String, Object>) map, -1L, false);
                return;
            }
            UMLog.aq(h.O, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized String e(Context context) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (context == null) {
            UMLog.aq(h.ai, 0, "\\|");
            return null;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.k != null) {
            return this.k.toString();
        }
        this.k = new JSONObject();
        return null;
    }

    void c(Context context, String str) throws Throwable {
        if (context == null) {
            UMLog.aq(h.z, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        AnalyticsConfig.a(f20587a, str);
    }

    void a(String str) throws Throwable {
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (j.f20879b != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f20590d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(ISysListener iSysListener) throws Throwable {
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f20588b = iSysListener;
        }
    }

    public void a(Context context, int i2) throws Throwable {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        AnalyticsConfig.a(f20587a, i2);
    }

    public synchronized void b(Object obj) {
        if (f20587a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f20587a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(i, str).commit();
            }
        } else if (editorEdit != null) {
            editorEdit.remove(i).commit();
        }
    }

    public void a(Context context, String str, HashMap<String, Object> map) throws Throwable {
        if (context == null) {
            return;
        }
        try {
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f20587a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.j || !this.n) {
                a(f20587a);
            }
            String string = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                string = this.k.toString();
            }
            q.a(f20587a).a(str, map, string);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    private boolean b(String str, Object obj) {
        int length;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            length = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            length = 0;
        }
        if (length > 128) {
            MLog.e("key length is " + length + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    void a(Context context, String str) throws Throwable {
        if (context == null) {
            UMLog.aq(h.w, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(h.x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.j || !this.n) {
                a(f20587a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(com.umeng.analytics.pro.b.P, 2);
            jSONObject.put(com.umeng.analytics.pro.b.Q, str);
            jSONObject.put("__ii", this.f20592f.c());
            UMWorkDispatch.sendEvent(f20587a, m.a.j, CoreProtocol.getInstance(f20587a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, Throwable th) throws Throwable {
        if (context != null && th != null) {
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f20587a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.j || !this.n) {
                    a(f20587a);
                }
                a(f20587a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e2) {
                if (MLog.DEBUG) {
                    MLog.e(e2);
                    return;
                }
                return;
            }
        }
        UMLog.aq(h.y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j, int i2) throws Throwable {
        if (context == null) {
            return;
        }
        try {
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(f20587a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                string = this.k.toString();
            }
            q.a(f20587a).a(str, str2, j, i2, string);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, String str, Map<String, Object> map, long j) throws Throwable {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(com.umeng.analytics.pro.b.aC).contains(str)) {
                UMLog.aq(h.f20873b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(h.f20875d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(com.umeng.analytics.pro.b.aC).contains(it.next().getKey())) {
                    UMLog.aq(h.f20876e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j, false);
            return;
        }
        UMLog.aq(h.f20874c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) throws Throwable {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j, boolean z2) throws Throwable {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f20587a == null) {
                f20587a = context.getApplicationContext();
            }
            if (!this.j || !this.n) {
                a(f20587a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.k == null) {
                this.k = new JSONObject();
            } else {
                string = this.k.toString();
            }
            q.a(f20587a).a(str, map, j, string, z2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.r
    public void a(Throwable th) throws Throwable {
        try {
            if (f20587a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f20587a)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                if (this.f20590d != null) {
                    this.f20590d.b();
                }
                j.a(f20587a, "onAppCrash");
                if (this.f20591e != null) {
                    this.f20591e.b();
                }
                if (this.g != null) {
                    this.g.c();
                }
                if (this.f20592f != null) {
                    this.f20592f.c(f20587a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(com.umeng.analytics.pro.b.P, 1);
                    jSONObject.put(com.umeng.analytics.pro.b.Q, DataHelper.convertExceptionToString(th));
                    g.a(f20587a).a(this.f20592f.c(), jSONObject.toString(), 1);
                }
                m.a(f20587a).d();
                t.a(f20587a);
                if (j.f20879b == MobclickAgent.PageMode.AUTO) {
                    j.b(f20587a);
                }
                PreferenceWrapper.getDefault(f20587a).edit().commit();
            }
        } catch (Exception e2) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e2);
            }
        }
    }

    void a(String str, String str2) throws Throwable {
        try {
            if (f20587a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(f20587a)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.analytics.pro.b.L, str);
            jSONObject.put(StringConstant.UID, str2);
            jSONObject.put("ts", jCurrentTimeMillis);
            UMWorkDispatch.sendEvent(f20587a, m.a.f20903e, CoreProtocol.getInstance(f20587a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    void a(boolean z2) throws Throwable {
        Context context = f20587a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z2;
        }
    }

    void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    void a(MobclickAgent.PageMode pageMode) throws Throwable {
        Context context = f20587a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setPageCollectionMode can not be called in child process");
        } else {
            j.f20879b = pageMode;
        }
    }

    void a(double d2, double d3) throws Throwable {
        Context context = f20587a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f20569a == null) {
            AnalyticsConfig.f20569a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f20569a;
        dArr[0] = d2;
        dArr[1] = d3;
    }

    void a(Context context, MobclickAgent.EScenarioType eScenarioType) throws Throwable {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f20587a, eScenarioType.toValue());
        }
        if (this.j && this.n) {
            return;
        }
        a(f20587a);
    }

    void a(long j) throws Throwable {
        Context context = f20587a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j;
            w.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i2 = 0;
        if (context == null) {
            UMLog.aq(h.af, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.k == null) {
                    this.k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i2 < strArr.length) {
                            if (strArr[i2] != null && HelperUtils.checkStrLen(strArr[i2], 256)) {
                                jSONArray.put(strArr[i2]);
                                i2++;
                            }
                            MLog.e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                            return;
                        }
                        this.k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i2 < jArr.length) {
                            jSONArray2.put(jArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i2 < iArr.length) {
                            jSONArray3.put(iArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i2 < fArr.length) {
                            jSONArray4.put(fArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i2 < dArr.length) {
                            jSONArray5.put(dArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i2 < sArr.length) {
                            jSONArray6.put((int) sArr[i2]);
                            i2++;
                        }
                        this.k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(f20587a, m.a.q, CoreProtocol.getInstance(f20587a), this.k.toString());
            return;
        }
        UMLog.aq(h.ag, 0, "\\|");
    }

    private void a(String str, Object obj) {
        try {
            if (this.k == null) {
                this.k = new JSONObject();
            }
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i2 < strArr.length) {
                        if (strArr[i2] != null && !HelperUtils.checkStrLen(strArr[i2], 256)) {
                            jSONArray.put(strArr[i2]);
                        }
                        i2++;
                    }
                    this.k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put(fArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put((int) sArr[i2]);
                        i2++;
                    }
                    this.k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i2 < list.size()) {
                    Object obj2 = list.get(i2);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i2));
                    }
                    i2++;
                }
                this.k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Object obj) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (f20587a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(f20587a).edit();
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(h, this.k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.e(th);
        }
        if (context == null) {
            UMLog.aq(h.aj, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        q.a(f20587a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            UMLog.aq(h.al, 0, "\\|");
            return;
        }
        if (f20587a == null) {
            f20587a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f20587a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.j || !this.n) {
            a(f20587a);
        }
        if (this.m == null) {
            this.m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    try {
                        String string = itKeys.next().toString();
                        Object obj = jSONObject.get(string);
                        if (b(string, obj)) {
                            jSONObject2.put(string, obj);
                            if (jSONObject2.length() > 10) {
                                MLog.e("please check propertics, size overlength!");
                                return;
                            }
                            continue;
                        } else {
                            return;
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            this.m = jSONObject2;
            if (this.m.length() > 0) {
                UMWorkDispatch.sendEvent(f20587a, m.a.t, CoreProtocol.getInstance(f20587a), this.m.toString());
            }
            return;
        }
        UMLog.aq(h.am, 0, "\\|");
    }
}
