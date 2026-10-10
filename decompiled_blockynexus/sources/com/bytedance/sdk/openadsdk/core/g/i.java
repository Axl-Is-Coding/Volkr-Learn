package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.v;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTSdkSettings.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements d {
    private static final String g = ab.j();
    private static final String h = null;
    private static final String i = null;
    private static final String j = null;
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private int F;
    private String R;
    private String S;
    private int T;
    private String U;
    private int V;
    private String W;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6218c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6220e;
    private String k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, a> f6216a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, j> f6217b = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f6219d = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f6221f = Collections.synchronizedSet(new HashSet());
    private int l = 1;
    private int m = 0;
    private int n = 1;
    private String o = "com.oppo.market";
    private int p = 0;
    private String q = "com.huawei.appmarket";
    private int r = 1;
    private int s = 30;
    private int t = 1;
    private int u = 30;
    private int v = 10;
    private int w = 1;
    private int x = 0;
    private int y = 5;
    private int z = 2;
    private int G = 0;
    private long H = 0;
    private Set<String> I = Collections.synchronizedSet(new HashSet());
    private Set<String> J = Collections.synchronizedSet(new HashSet());
    private int K = 0;
    private int L = 1;
    private long M = 10000;
    private int N = 50;
    private int O = 30;
    private int P = 5;
    private int Q = 3600;
    private String X = null;
    private String Y = null;
    private boolean Z = false;
    private int aa = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
    private int ab = 100;

    private int a(boolean z) {
        return z ? 20 : 5;
    }

    private static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("code_id");
        int iOptInt = jSONObject.optInt("auto_play", 1);
        int iOptInt2 = jSONObject.optInt("voice_control", 1);
        int iOptInt3 = jSONObject.optInt("rv_preload", 2);
        int iOptInt4 = jSONObject.optInt("nv_preload", 1);
        int iOptInt5 = jSONObject.optInt("read_video_from_cache", 1);
        int iOptInt6 = jSONObject.optInt("proportion_watching", 100);
        int iOptInt7 = jSONObject.optInt("skip_time_displayed", 0);
        int iOptInt8 = jSONObject.optInt("video_skip_result", 2);
        int iOptInt9 = jSONObject.optInt("reg_creative_control", 1);
        int iOptInt10 = jSONObject.optInt("play_bar_show_time", 3);
        int iOptInt11 = jSONObject.optInt("rv_skip_time", -1);
        int iOptInt12 = jSONObject.optInt("endcard_close_time", -1);
        int iOptInt13 = jSONObject.optInt("playable_endcard_close_time", -1);
        int iOptInt14 = jSONObject.optInt("voice_control", 2);
        int iOptInt15 = jSONObject.optInt("if_show_win", 1);
        int iOptInt16 = jSONObject.optInt("sp_preload", 0);
        int iOptInt17 = jSONObject.optInt("stop_time", ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        int iOptInt18 = jSONObject.optInt("native_playable_delay", 2);
        int iOptInt19 = jSONObject.optInt("time_out_control", -1);
        int iOptInt20 = jSONObject.optInt("playable_duration_time", 20);
        int iOptInt21 = jSONObject.optInt("playable_close_time", -1);
        int iOptInt22 = jSONObject.optInt("playable_reward_type", 0);
        int iOptInt23 = jSONObject.optInt("reward_is_callback", 0);
        int iOptInt24 = jSONObject.optInt("iv_skip_time", 5);
        return a.a().a(strOptString).n(iOptInt).o(iOptInt2).p(iOptInt3).q(iOptInt4).r(iOptInt5).s(iOptInt6).t(iOptInt7).u(iOptInt8).v(iOptInt9).m(iOptInt10).l(iOptInt11).j(iOptInt12).i(iOptInt14).k(iOptInt13).w(iOptInt15).f(iOptInt16).g(iOptInt17).h(iOptInt18).e(iOptInt19).a(iOptInt21).d(iOptInt20).b(iOptInt22).c(iOptInt23).x(jSONObject.optInt("slot_type", 2)).y(iOptInt24).a(jSONObject.optJSONArray("parent_tpl_ids"));
    }

    private static j c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("tpl_id", "");
        String strOptString2 = jSONObject.optString("md5", "");
        return j.a().a(strOptString).b(strOptString2).c(jSONObject.optString("url", ""));
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strB = com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", g) : z().b("dyn_draw_engine_url", g);
        this.X = jSONObject.optString("dyn_draw_engine_url", g);
        o.e("TemplateManager", "settinng---TTDynamic.init().....oldDynDrawEngineUrl=" + strB);
        o.e("TemplateManager", "settinng---TTDynamic.init().....newmDynDrawEngineUrl=" + this.X);
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(this.X) || this.X.equals(strB)) {
            return;
        }
        o.b("TemplateManager", "重新初始化模板TTDynamic.init().....");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.a.d.a().e();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.d.a().a(false);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.b.a().g();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.b.a().b(false);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.b.a().b();
    }

    private void e(JSONObject jSONObject) {
        this.V = jSONObject.optInt("is_gdpr_user", -1);
        int i2 = this.V;
        if (i2 == -1 || i2 == 1 || i2 == 0) {
            return;
        }
        this.V = -1;
    }

    private int f(JSONObject jSONObject) {
        this.E = jSONObject.optInt("splash_load_type", 1);
        int i2 = this.E;
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) {
            return this.E;
        }
        return 1;
    }

    private int g(JSONObject jSONObject) {
        this.F = jSONObject.optInt("splash_check_type", 1);
        int i2 = this.F;
        if (i2 == 0 || i2 == 1) {
            return this.F;
        }
        return 1;
    }

    private void w() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e();
        } catch (Throwable unused) {
        }
    }

    private void x() {
        if (TextUtils.isEmpty(this.f6220e)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f6220e);
            int length = jSONArray.length();
            if (length > 0) {
                this.f6221f.clear();
                for (int i2 = 0; i2 < length; i2++) {
                    this.f6221f.add((String) jSONArray.opt(i2));
                }
            }
        } catch (Exception unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this.f6221f);
        } catch (Throwable unused2) {
        }
    }

    private void y() {
        if (TextUtils.isEmpty(this.f6218c)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f6218c);
            int length = jSONArray.length();
            if (length > 0) {
                this.f6217b.clear();
                for (int i2 = 0; i2 < length; i2++) {
                    j jVarC = c(jSONArray.optJSONObject(i2));
                    if (jVarC != null) {
                        this.f6217b.put(jVarC.f6222a, jVarC);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private v z() {
        return v.a("tt_sdk_settings", com.bytedance.sdk.openadsdk.core.o.a());
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a() {
        int i2 = 0;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            this.k = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "xpath", "");
            this.M = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", 10000L);
            this.N = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", 50);
            this.l = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_back_dialog", 1);
            this.m = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_progressbar", 0);
            this.n = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook", 1);
            this.o = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_config_hook_oppo_arg1", "com.oppo.market");
            this.p = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_oppo_arg4", 0);
            this.q = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "download_config_hook_huawei_arg1", "com.huawei.appmarket");
            this.r = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", 1);
            this.s = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", 30);
            this.t = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_enable_install_again", 1);
            this.u = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time", 30);
            this.v = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time_next", 10);
            this.w = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", 1);
            this.x = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_switch", 0);
            this.y = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_time", 5);
            this.z = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_count", 2);
            this.O = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pos_cache_time", 30);
            this.P = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", 5);
            this.Q = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", 3600);
            this.f6220e = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "template_ids", (String) null);
            this.A = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_version", (String) null);
            this.B = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ab_test_param", (String) null);
            this.C = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "pyload_h5", (String) null);
            this.D = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "playableLoadH5Url", (String) null);
            this.E = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", 1);
            this.F = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", 1);
            this.K = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", 0);
            this.L = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", 1);
            this.aa = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            this.ab = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", 100);
            w();
            this.f6218c = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "tpl_infos", (String) null);
            this.G = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", 0);
            this.H = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", 0L);
            this.R = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ads_url", i);
            this.S = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "app_log_url", h);
            this.T = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "coppa", -99);
            com.bytedance.sdk.openadsdk.core.h.b().c(this.T);
            this.U = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "policy_url", j);
            this.W = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_dev_607_en.html");
            this.V = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "isGdprUser", -1);
            this.X = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dyn_draw_engine_url", g);
            this.Y = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "dc", (String) null);
            this.I.clear();
            Set<String> setB = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "hit_app_list_data", (Set<String>) null);
            if (setB != null && !setB.isEmpty()) {
                Iterator<String> it = setB.iterator();
                while (it.hasNext()) {
                    this.I.add(it.next());
                }
            }
            this.J.clear();
            Set<String> setB2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "scheme_list_data", (Set<String>) null);
            if (setB2 != null && !setB2.isEmpty()) {
                Iterator<String> it2 = setB2.iterator();
                while (it2.hasNext()) {
                    this.J.add(it2.next());
                }
            }
            x();
            y();
            String strB = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_settings", "ad_slot_conf", (String) null);
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(strB);
                int length = jSONArray.length();
                if (length > 0) {
                    this.f6216a.clear();
                    while (i2 < length) {
                        a aVarB = b(jSONArray.optJSONObject(i2));
                        if (aVarB != null) {
                            this.f6216a.put(aVarB.f6184a, aVarB);
                        }
                        i2++;
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        v vVarZ = z();
        this.k = vVarZ.b("xpath", "");
        this.M = vVarZ.b("duration", 10000L);
        this.N = vVarZ.b("max", 50);
        this.l = vVarZ.b("download_config_back_dialog", 1);
        this.m = vVarZ.b("download_config_progressbar", 0);
        this.n = vVarZ.b("download_config_hook", 1);
        this.o = vVarZ.b("download_config_hook_oppo_arg1", "com.oppo.market");
        this.p = vVarZ.b("download_config_hook_oppo_arg4", 0);
        this.q = vVarZ.b("download_config_hook_huawei_arg1", "com.huawei.appmarket");
        this.r = vVarZ.b("download_config_dl_network", 1);
        this.s = vVarZ.b("download_config_dl_size", 30);
        this.t = vVarZ.b("download_config_enable_install_again", 1);
        this.u = vVarZ.b("download_config_install_again_time", 30);
        this.v = vVarZ.b("download_config_install_again_time_next", 10);
        this.w = vVarZ.b("download_config_storage_internal", 1);
        this.x = vVarZ.b("download_config_resume_notify_switch", 0);
        this.z = vVarZ.b("download_config_resume_notify_count", 2);
        this.y = vVarZ.b("download_config_resume_notify_time", 5);
        this.O = vVarZ.b("pos_cache_time", 30);
        this.Q = vVarZ.b("fetch_template", 3600);
        this.A = vVarZ.a("ab_test_version");
        this.B = vVarZ.a("ab_test_param");
        this.P = vVarZ.b("vbtt", 5);
        this.f6220e = vVarZ.b("template_ids", (String) null);
        this.C = vVarZ.b("pyload_h5", (String) null);
        this.D = vVarZ.b("playableLoadH5Url", (String) null);
        this.E = vVarZ.b("splash_load_type", 1);
        this.F = vVarZ.b("splash_check_type", 1);
        this.K = vVarZ.b("if_both_open", 0);
        this.L = vVarZ.b("support_tnc", 1);
        this.f6218c = vVarZ.b("tpl_infos", (String) null);
        this.G = vVarZ.b("app_list_control", 0);
        this.aa = vVarZ.b("fetch_tpl_timeout_ctrl", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        this.ab = vVarZ.b("max_tpl_cnts", 100);
        w();
        this.H = vVarZ.b("hit_app_list_time", 0L);
        this.R = vVarZ.a("ads_url");
        this.S = vVarZ.a("app_log_url");
        this.T = vVarZ.b("coppa", -99);
        com.bytedance.sdk.openadsdk.core.h.b().c(this.T);
        this.U = vVarZ.b("policy_url", j);
        this.W = vVarZ.b("consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_dev_607_en.html");
        this.X = vVarZ.b("dyn_draw_engine_url", g);
        this.Y = vVarZ.a("dc");
        this.V = vVarZ.b("isGdprUser", -1);
        this.I.clear();
        Set<String> setB3 = vVarZ.b("hit_app_list_data", (Set<String>) null);
        if (setB3 != null && !setB3.isEmpty()) {
            Iterator<String> it3 = setB3.iterator();
            while (it3.hasNext()) {
                this.I.add(it3.next());
            }
        }
        this.J.clear();
        Set<String> setB4 = vVarZ.b("scheme_list_data", (Set<String>) null);
        if (setB4 != null && !setB4.isEmpty()) {
            Iterator<String> it4 = setB4.iterator();
            while (it4.hasNext()) {
                this.J.add(it4.next());
            }
        }
        x();
        y();
        String strB2 = vVarZ.b("ad_slot_conf", (String) null);
        if (TextUtils.isEmpty(strB2)) {
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONArray(strB2);
            int length2 = jSONArray2.length();
            if (length2 > 0) {
                this.f6216a.clear();
                while (i2 < length2) {
                    a aVarB2 = b(jSONArray2.optJSONObject(i2));
                    if (aVarB2 != null) {
                        this.f6216a.put(aVarB2.f6184a, aVarB2);
                    }
                    i2++;
                }
            }
        } catch (Exception unused2) {
        }
    }

    public long h() {
        return this.M;
    }

    public int i() {
        return this.N;
    }

    public int j() {
        return this.Q;
    }

    public String k() {
        return this.C;
    }

    public String l() {
        return this.D;
    }

    public int m() {
        if (this.aa <= 0) {
            this.aa = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        }
        return this.aa;
    }

    public boolean n() {
        return this.Z;
    }

    public int o(String str) {
        if (str == null) {
            return 20;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).u;
    }

    public int p(String str) {
        if (str == null) {
            return -1;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).n;
    }

    public boolean q(String str) {
        return str == null || com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).f6189f == 1;
    }

    public String r() {
        return this.W;
    }

    public String s() {
        return this.X;
    }

    public String t() {
        return this.Y;
    }

    public int u() {
        return this.V;
    }

    public int v() {
        return this.P;
    }

    private a t(String str) {
        return a.a().a(str).n(1).o(!this.f6219d.contains(str) ? 1 : 0).p(2).q(1).r(1).s(100).t(0).v(1).m(3).l(-1).j(-1).i(2).k(-1).w(1).e(-1).a(-1).d(20).x(2).y(5).a((JSONArray) null);
    }

    public JSONArray h(String str) {
        try {
            a aVarR = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str));
            if (aVarR != null && aVarR.z != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = aVarR.z.iterator();
                while (it.hasNext()) {
                    l lVarA = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(it.next());
                    if (lVarA != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", lVarA.b());
                        jSONObject.put("md5", lVarA.c());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean i(String str) {
        try {
            a aVarR = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str));
            if (aVarR != null) {
                return aVarR.z != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean j(String str) {
        try {
            a aVarR = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str));
            if (aVarR != null) {
                return aVarR.A == 8;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int k(String str) {
        return r(String.valueOf(str)).i;
    }

    public int l(String str) {
        return r(str).k;
    }

    public boolean n(String str) {
        return r(String.valueOf(str)).y == 0;
    }

    public a r(String str) {
        a aVar = this.f6216a.get(str);
        return aVar == null ? t(str) : aVar;
    }

    public void s(String str) {
        this.f6219d.add(str);
    }

    public String o() {
        return this.R;
    }

    public String p() {
        return this.S;
    }

    public String q() {
        return this.U;
    }

    public String e() {
        return this.A;
    }

    public String f() {
        return this.B;
    }

    public String g() {
        return this.k;
    }

    public int m(String str) {
        if (str == null) {
            return -1;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).m;
    }

    public boolean e(String str) {
        return str == null || com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).p == 1;
    }

    public int f(String str) {
        return str == null ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).r;
    }

    public int g(String str) {
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).l;
    }

    public int e(int i2) {
        return r(String.valueOf(i2)).x;
    }

    public boolean c() {
        return this.K == 1;
    }

    public boolean c(String str) {
        return r(String.valueOf(str)).h == 1;
    }

    public int c(int i2) {
        return r(String.valueOf(i2)).f6185b;
    }

    public boolean d() {
        return this.L == 1;
    }

    public int d(String str) {
        return r(String.valueOf(str)).t;
    }

    public int d(int i2) {
        return r(String.valueOf(i2)).j;
    }

    public int b() {
        return this.ab;
    }

    public boolean b(String str) {
        int i2 = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).f6188e;
        if (i2 == 1) {
            return q.d(com.bytedance.sdk.openadsdk.core.o.a());
        }
        if (i2 == 2) {
            return q.c(com.bytedance.sdk.openadsdk.core.o.a()) != 0;
        }
        if (i2 != 3) {
        }
        return false;
    }

    public boolean b(int i2) {
        return i2 != 0 && com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(i2)).o == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.d
    public void a(JSONObject jSONObject) {
        String string;
        this.k = jSONObject.optString("xpath");
        this.O = jSONObject.optInt("pos_cache_time", 30);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("feq_policy");
        if (jSONObjectOptJSONObject != null) {
            this.M = jSONObjectOptJSONObject.optLong("duration") * 1000;
            this.N = jSONObjectOptJSONObject.optInt("max");
        }
        this.P = jSONObject.optInt("vbtt", 5);
        this.Q = jSONObject.optInt("fetch_tpl_interval", 3600);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c();
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("abtest");
        if (jSONObjectOptJSONObject2 != null) {
            this.A = jSONObjectOptJSONObject2.optString("version");
            this.B = jSONObjectOptJSONObject2.optString("param");
        } else {
            this.B = null;
            this.A = null;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_version");
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_param");
            } else {
                v vVarZ = z();
                vVarZ.b("ab_test_version");
                vVarZ.b("ab_test_param");
            }
        }
        this.C = jSONObject.optString("pyload_h5");
        this.D = jSONObject.optString("pure_pyload_h5");
        this.R = jSONObject.optString("ads_url");
        this.S = jSONObject.optString("app_log_url");
        this.T = jSONObject.optInt("coppa", -99);
        com.bytedance.sdk.openadsdk.core.h.b().c(this.T);
        this.U = jSONObject.optString("privacy_url", j);
        this.W = jSONObject.optString("consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_dev_607_en.html");
        this.Y = jSONObject.optString("dc");
        d(jSONObject);
        e(jSONObject);
        this.E = f(jSONObject);
        o.e("splashLoad", "setting-》mSplashLoadType=" + this.E);
        this.F = g(jSONObject);
        o.e("splashLoad", "setting-》mSplashCheckType=" + this.F);
        this.K = jSONObject.optInt("if_both_open", 0);
        this.L = jSONObject.optInt("support_tnc", 1);
        this.G = jSONObject.optInt("al", 0);
        this.ab = jSONObject.optInt("max_tpl_cnts", 100);
        w();
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject3 != null) {
            this.aa = jSONObjectOptJSONObject3.optInt("fetch_tpl_timeout_ctrl", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        }
        this.H = System.currentTimeMillis();
        this.I.clear();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("spam_app_list");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String strOptString = jSONArrayOptJSONArray.optString(i2);
                if (!TextUtils.isEmpty(strOptString)) {
                    this.I.add(strOptString);
                }
            }
        }
        this.J.clear();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("scheme_check_list");
        if (jSONArrayOptJSONArray2 != null) {
            int length2 = jSONArrayOptJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                String strOptString2 = jSONArrayOptJSONArray2.optString(i3);
                if (!TextUtils.isEmpty(strOptString2)) {
                    this.J.add(strOptString2);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("download_config");
        if (jSONObjectOptJSONObject4 != null) {
            this.l = jSONObjectOptJSONObject4.optInt("is_enable_back_dialog", 1);
            this.m = jSONObjectOptJSONObject4.optInt("landing_page_progressbar_visible", 0);
            this.n = jSONObjectOptJSONObject4.optInt("hook", 1);
            this.o = jSONObjectOptJSONObject4.optString("hook_oppo_arg1", "com.oppo.market");
            this.p = jSONObjectOptJSONObject4.optInt("hook_oppo_arg4", 0);
            this.q = jSONObjectOptJSONObject4.optString("hook_huawei_arg1", "com.huawei.appmarket");
            this.r = jSONObjectOptJSONObject4.optInt("dl_network", 1);
            this.s = jSONObjectOptJSONObject4.optInt("dl_size", 30);
            this.t = jSONObjectOptJSONObject4.optInt("is_enable_start_install_again", 1);
            this.u = jSONObjectOptJSONObject4.optInt("start_install_time", 30);
            this.v = jSONObjectOptJSONObject4.optInt("next_install_min_time", 10);
            this.w = jSONObjectOptJSONObject4.optInt("if_storage_internal", 1);
            this.x = jSONObjectOptJSONObject4.optInt("if_tips", 0);
            this.y = jSONObjectOptJSONObject4.optInt("min_failed_time", 5);
            this.z = jSONObjectOptJSONObject4.optInt("max_failes_count", 2);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("tpl_ids");
        if (jSONArrayOptJSONArray3 != null) {
            this.f6220e = jSONArrayOptJSONArray3.toString();
            x();
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("ad_slot_conf_list");
        if (jSONArrayOptJSONArray4 != null) {
            string = jSONArrayOptJSONArray4.toString();
            int length3 = jSONArrayOptJSONArray4.length();
            if (length3 > 0) {
                this.f6216a.clear();
                for (int i4 = 0; i4 < length3; i4++) {
                    a aVarB = b(jSONArrayOptJSONArray4.optJSONObject(i4));
                    if (aVarB != null) {
                        this.f6216a.put(aVarB.f6184a, aVarB);
                    }
                }
            }
        } else {
            string = null;
        }
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("tpl_infos");
        if (jSONArrayOptJSONArray5 != null) {
            this.f6218c = jSONArrayOptJSONArray5.toString();
            int length4 = jSONArrayOptJSONArray5.length();
            if (length4 > 0) {
                this.f6217b.clear();
                for (int i5 = 0; i5 < length4; i5++) {
                    j jVarC = c(jSONArrayOptJSONArray5.optJSONObject(i5));
                    if (jVarC != null) {
                        this.f6217b.put(jVarC.f6222a, jVarC);
                        a(jVarC);
                    }
                }
            }
        }
        a(string, (String) null);
        this.Z = true;
    }

    public int a(String str) {
        if (str == null) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).w;
    }

    private void a(j jVar) {
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(jVar);
    }

    private void a(String str, String str2) {
        v vVar;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "xpath", this.k);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "duration", Long.valueOf(this.M));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max", Integer.valueOf(this.N));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_back_dialog", Integer.valueOf(this.l));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_progressbar", Integer.valueOf(this.m));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook", Integer.valueOf(this.n));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_oppo_arg1", this.o);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_oppo_arg4", Integer.valueOf(this.p));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_hook_huawei_arg1", this.q);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_network", Integer.valueOf(this.r));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_dl_size", Integer.valueOf(this.s));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_enable_install_again", Integer.valueOf(this.t));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time", Integer.valueOf(this.u));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_install_again_time_next", Integer.valueOf(this.v));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_storage_internal", Integer.valueOf(this.w));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_switch", Integer.valueOf(this.x));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_time", Integer.valueOf(this.y));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "download_config_resume_notify_count", Integer.valueOf(this.z));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pos_cache_time", Integer.valueOf(this.O));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.P));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_template", Integer.valueOf(this.Q));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_load_type", Integer.valueOf(this.E));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "splash_check_type", Integer.valueOf(this.F));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "if_both_open", Integer.valueOf(this.K));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "support_tnc", Integer.valueOf(this.L));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "pyload_h5", this.C);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "playableLoadH5Url", this.D);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_list_control", Integer.valueOf(this.G));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "max_tpl_cnts", Integer.valueOf(this.ab));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "fetch_tpl_timeout_ctrl", Integer.valueOf(this.aa));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_time", Long.valueOf(this.H));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "hit_app_list_data", this.I);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "scheme_list_data", this.J);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ads_url", this.R);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "app_log_url", this.S);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "coppa", Integer.valueOf(this.T));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "policy_url", this.U);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "consent_url", this.W);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "dyn_draw_engine_url", this.X);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "dc", this.Y);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "isGdprUser", Integer.valueOf(this.V));
            if (!TextUtils.isEmpty(this.A)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_version", this.A);
            }
            if (!TextUtils.isEmpty(this.B)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ab_test_param", this.B);
            }
            if (!TextUtils.isEmpty(str)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "ad_slot_conf", str);
            }
            if (!TextUtils.isEmpty(this.f6220e)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "template_ids", this.f6220e);
            }
            if (TextUtils.isEmpty(this.f6218c)) {
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_settings", "tpl_infos", this.f6218c);
            return;
        }
        v vVarZ = z();
        vVarZ.a("xpath", this.k);
        vVarZ.a("duration", this.M);
        vVarZ.a("max", this.N);
        vVarZ.a("download_config_back_dialog", this.l);
        vVarZ.a("download_config_progressbar", this.m);
        vVarZ.a("download_config_hook", this.n);
        vVarZ.a("download_config_hook_oppo_arg1", this.o);
        vVarZ.a("download_config_hook_oppo_arg4", this.p);
        vVarZ.a("download_config_hook_huawei_arg1", this.q);
        vVarZ.a("download_config_dl_network", this.r);
        vVarZ.a("download_config_dl_size", this.s);
        vVarZ.a("download_config_enable_install_again", this.t);
        vVarZ.a("download_config_install_again_time", this.u);
        vVarZ.a("download_config_install_again_time_next", this.v);
        vVarZ.a("download_config_storage_internal", this.w);
        vVarZ.a("download_config_resume_notify_switch", this.x);
        vVarZ.a("download_config_resume_notify_time", this.y);
        vVarZ.a("download_config_resume_notify_count", this.z);
        vVarZ.a("pos_cache_time", this.O);
        vVarZ.a("fetch_template", this.Q);
        vVarZ.a("pyload_h5", this.C);
        vVarZ.a("playableLoadH5Url", this.D);
        vVarZ.a("splash_load_type", this.E);
        vVarZ.a("splash_check_type", this.F);
        vVarZ.a("if_both_open", this.K);
        vVarZ.a("support_tnc", this.L);
        vVarZ.a("app_list_control", this.G);
        vVarZ.a("max_tpl_cnts", this.ab);
        vVarZ.a("fetch_tpl_timeout_ctrl", this.aa);
        vVarZ.a("hit_app_list_time", this.H);
        vVarZ.a("hit_app_list_data", this.I);
        vVarZ.a("scheme_list_data", this.J);
        vVarZ.a("ads_url", this.R);
        vVarZ.a("app_log_url", this.S);
        vVarZ.a("coppa", this.T);
        vVarZ.a("policy_url", this.U);
        vVarZ.a("consent_url", this.W);
        vVarZ.a("dyn_draw_engine_url", this.X);
        vVarZ.a("dc", this.Y);
        vVarZ.a("isGdprUser", this.V);
        if (!TextUtils.isEmpty(this.A)) {
            vVarZ.a("ab_test_version", this.A);
        }
        if (!TextUtils.isEmpty(this.B)) {
            vVarZ.a("ab_test_param", this.B);
        }
        vVarZ.a("vbtt", this.P);
        if (TextUtils.isEmpty(str)) {
            vVar = vVarZ;
        } else {
            vVar = vVarZ;
            vVar.a("ad_slot_conf", str);
        }
        if (!TextUtils.isEmpty(this.f6220e)) {
            vVar.a("template_ids", this.f6220e);
        }
        if (TextUtils.isEmpty(this.f6218c)) {
            return;
        }
        vVar.a("tpl_infos", this.f6218c);
    }

    public boolean a(int i2) {
        return r(String.valueOf(i2)).f6186c == 1;
    }

    public int a(String str, boolean z) {
        if (str == null) {
            return a(z);
        }
        int i2 = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(str)).v;
        return i2 != -1 ? i2 : a(z);
    }
}
