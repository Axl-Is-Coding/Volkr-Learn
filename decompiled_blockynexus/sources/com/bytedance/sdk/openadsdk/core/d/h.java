package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.o;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.imchat.server.network.async.AsyncTaskManager;
import com.umeng.analytics.pro.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: MaterialMeta.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private Map<String, Object> A;
    private a B;
    private boolean C;
    private int D;
    private String E;
    private AdSlot J;
    private int K;
    private String M;
    private JSONObject Q;
    private int S;
    private String T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f6104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f6105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6106d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6108f;
    private String j;
    private String k;
    private String l;
    private b n;
    private e o;
    private int p;
    private String q;
    private String r;
    private long u;
    private int v;
    private n w;
    private boolean x;
    private boolean y;
    private int z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<g> f6107e = new ArrayList();
    private List<String> g = new ArrayList();
    private List<String> h = new ArrayList();
    private List<String> i = new ArrayList();
    private String m = "0";
    private List<FilterWord> s = new ArrayList();
    private int t = 0;
    private String F = "";
    private c G = new c();
    private int H = AsyncTaskManager.HTTP_ERROR_CODE;
    private int I = 0;
    private int L = 1;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private int R = 1;

    /* JADX INFO: compiled from: MaterialMeta.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f6110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f6111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f6112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f6113e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f6114f;
        private String g;

        public String a() {
            return this.f6114f;
        }

        public String b() {
            return this.f6109a;
        }

        public String c() {
            return this.f6110b;
        }

        public String d() {
            return this.f6111c;
        }

        public String e() {
            return this.f6112d;
        }

        public String f() {
            return this.f6113e;
        }

        public String g() {
            return this.g;
        }

        public void a(String str) {
            this.f6114f = str;
        }

        public void b(String str) {
            this.f6109a = str;
        }

        public void c(String str) {
            this.f6110b = str;
        }

        public void d(String str) {
            this.f6111c = str;
        }

        public void e(String str) {
            this.f6112d = str;
        }

        public void f(String str) {
            this.f6113e = str;
        }

        public void g(String str) {
            this.g = str;
        }
    }

    public String A() {
        return this.f6106d;
    }

    public List<g> B() {
        return this.f6107e;
    }

    public String C() {
        return this.f6108f;
    }

    public List<String> D() {
        return this.g;
    }

    public List<String> E() {
        return this.h;
    }

    public List<String> F() {
        return this.i;
    }

    public String G() {
        return this.j;
    }

    public String H() {
        return this.k;
    }

    public String I() {
        return this.l;
    }

    public String J() {
        return this.m;
    }

    public b K() {
        return this.n;
    }

    public e L() {
        return this.o;
    }

    public String M() {
        return this.r;
    }

    public int N() {
        return this.p;
    }

    public List<FilterWord> O() {
        return this.s;
    }

    public long P() {
        return this.u;
    }

    public int Q() {
        return this.v;
    }

    public boolean R() {
        return this.x;
    }

    public boolean S() {
        return this.y;
    }

    public Map<String, Object> T() {
        return this.A;
    }

    public JSONObject U() {
        return this.Q;
    }

    public String V() {
        return this.M;
    }

    public boolean W() {
        if (this.f6107e.isEmpty()) {
            return false;
        }
        if (this.p == 4 && this.f6107e.size() < 3) {
            return false;
        }
        Iterator<g> it = this.f6107e.iterator();
        while (it.hasNext()) {
            if (!it.next().d()) {
                return false;
            }
        }
        return true;
    }

    public boolean X() {
        return Y() == 1;
    }

    public int Y() {
        return this.t;
    }

    public JSONObject Z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", x());
            jSONObject.put("target_url", A());
            jSONObject.put("ad_id", J());
            jSONObject.put("source", w());
            jSONObject.put("screenshot", R());
            jSONObject.put("dislike_control", Y());
            jSONObject.put("play_bar_show_time", m());
            jSONObject.put("is_playable", r());
            jSONObject.put("playable_type", c());
            jSONObject.put("playable_style", d());
            jSONObject.put("play_bar_style", i());
            jSONObject.put("if_block_lp", a());
            jSONObject.put("cache_sort", n());
            jSONObject.put("if_sp_cache", o());
            g gVarY = y();
            if (gVarY != null && !TextUtils.isEmpty(gVarY.a())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", gVarY.a());
                jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, gVarY.c());
                jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, gVarY.b());
                jSONObject.put("icon", jSONObject2);
            }
            g gVarZ = z();
            if (gVarZ != null && !TextUtils.isEmpty(gVarZ.a())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", gVarZ.a());
                jSONObject3.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, gVarZ.c());
                jSONObject3.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, gVarZ.b());
                jSONObject.put("cover_image", jSONObject3);
            }
            Object objU = U();
            if (objU != null) {
                jSONObject.put("session_params", objU);
            }
            c cVarJ = j();
            if (cVarJ != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("click_upper_content_area", cVarJ.f6067a);
                jSONObject4.put("click_upper_non_content_area", cVarJ.f6068b);
                jSONObject4.put("click_lower_content_area", cVarJ.f6069c);
                jSONObject4.put("click_lower_non_content_area", cVarJ.f6070d);
                jSONObject4.put("click_button_area", cVarJ.f6071e);
                jSONObject4.put("click_video_area", cVarJ.f6072f);
                jSONObject.put("click_area", jSONObject4);
            }
            AdSlot adSlotK = k();
            if (adSlotK != null) {
                jSONObject.put("adslot", adSlotK.toJsonObj());
            }
            List<g> listB = B();
            if (listB != null) {
                JSONArray jSONArray = new JSONArray();
                for (g gVar : listB) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", gVar.a());
                    jSONObject5.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, gVar.c());
                    jSONObject5.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, gVar.b());
                    jSONArray.put(jSONObject5);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listD = D();
            if (listD != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listD.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listE = E();
            if (listE != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listE.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            List<String> listF = F();
            if (listF != null) {
                JSONArray jSONArray4 = new JSONArray();
                Iterator<String> it3 = listF.iterator();
                while (it3.hasNext()) {
                    jSONArray4.put(it3.next());
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", C());
            jSONObject.put("title", G());
            jSONObject.put("description", H());
            jSONObject.put("ext", M());
            jSONObject.put("image_mode", N());
            jSONObject.put("is_playable", r());
            jSONObject.put("intercept_flag", l());
            jSONObject.put("button_text", I());
            jSONObject.put("ad_logo", h());
            jSONObject.put("video_adaptation", g());
            jSONObject.put("feed_video_opentype", e());
            b bVarK = K();
            if (bVarK != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, bVarK.b());
                jSONObject6.put(au.n, bVarK.c());
                jSONObject6.put("download_url", bVarK.a());
                jSONObject6.put(FirebaseAnalytics.Param.SCORE, bVarK.d());
                jSONObject6.put("comment_num", bVarK.e());
                jSONObject6.put("app_size", bVarK.f());
                jSONObject.put("app", jSONObject6);
            }
            e eVarL = L();
            if (eVarL != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("deeplink_url", eVarL.a());
                jSONObject7.put(MessengerShareContentUtility.FALLBACK_URL, eVarL.b());
                jSONObject7.put("fallback_type", eVarL.c());
                jSONObject.put("deep_link", jSONObject7);
            }
            List<FilterWord> listO = O();
            if (listO != null) {
                JSONArray jSONArray5 = new JSONArray();
                Iterator<FilterWord> it4 = listO.iterator();
                while (it4.hasNext()) {
                    JSONObject jSONObjectB = b(it4.next());
                    if (jSONObjectB != null) {
                        jSONArray5.put(jSONObjectB);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            jSONObject.put("count_down", Q());
            jSONObject.put("expiration_time", P());
            n nVarV = v();
            if (nVarV != null) {
                jSONObject.put("video", nVarV.l());
            }
            if (T() != null) {
                JSONObject jSONObject8 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = T().entrySet();
                if (setEntrySet != null && !setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject8.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject8);
            }
            a aVarU = u();
            if (aVarU != null) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("id", aVarU.b());
                jSONObject9.put("md5", aVarU.c());
                jSONObject9.put("url", aVarU.d());
                jSONObject9.put("data", aVarU.e());
                jSONObject9.put("diff_data", aVarU.f());
                jSONObject9.put("version", aVarU.a());
                jSONObject9.put("dynamic_creative", aVarU.g());
                jSONObject.put("tpl_info", jSONObject9);
            }
            jSONObject.put("market_url", V());
            jSONObject.put("auction_price", f());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int a() {
        return this.N;
    }

    public boolean b() {
        return this.N == 1;
    }

    public int c() {
        return this.D;
    }

    public String d() {
        return this.E;
    }

    public int e() {
        return this.P;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.m.equals(hVar.m) && this.r.equals(hVar.r);
    }

    public String f() {
        return this.T;
    }

    public int g() {
        return this.O;
    }

    public int h() {
        return this.L;
    }

    public int hashCode() {
        return (this.m.hashCode() * 31) + this.r.hashCode();
    }

    public int i() {
        return this.I;
    }

    public c j() {
        return this.G;
    }

    public AdSlot k() {
        return this.J;
    }

    public int l() {
        return this.K;
    }

    public int m() {
        return this.H;
    }

    public int n() {
        return this.R;
    }

    public int o() {
        return this.S;
    }

    public boolean p() {
        n nVar = this.w;
        return nVar == null || nVar.m() != 1;
    }

    public boolean q() {
        n nVar = this.w;
        return nVar != null && nVar.n() == 1;
    }

    public boolean r() {
        return this.C;
    }

    public boolean s() {
        return r() && c() == 1;
    }

    public int t() {
        return this.z;
    }

    public a u() {
        return this.B;
    }

    public n v() {
        return this.w;
    }

    public String w() {
        return this.q;
    }

    public int x() {
        return this.f6103a;
    }

    public g y() {
        return this.f6104b;
    }

    public g z() {
        return this.f6105c;
    }

    public void a(int i) {
        this.N = i;
    }

    public void b(int i) {
        this.D = i;
    }

    public void c(int i) {
        this.P = i;
    }

    public void d(int i) {
        this.O = i;
    }

    public void e(int i) {
        this.L = i;
    }

    public void f(int i) {
        this.I = i;
    }

    public void g(int i) {
        this.K = i;
    }

    public void h(int i) {
        this.H = i;
    }

    public void i(int i) {
        this.R = i;
    }

    public void j(int i) {
        this.S = i;
    }

    public void k(int i) {
        this.z = i;
    }

    public void l(int i) {
        this.f6103a = i;
    }

    public void m(int i) {
        this.p = i;
    }

    public void n(int i) {
        this.v = i;
    }

    public void o(int i) {
        this.t = i;
    }

    public void a(String str) {
        this.E = str;
    }

    public void b(String str) {
        this.T = str;
    }

    public void c(String str) {
        this.q = str;
    }

    public void d(String str) {
        this.f6106d = str;
    }

    public void e(String str) {
        this.f6108f = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.k = str;
    }

    public void h(String str) {
        this.l = str;
    }

    public void i(String str) {
        this.m = str;
    }

    public void j(String str) {
        this.r = str;
    }

    public void k(String str) {
        this.M = str;
    }

    public void a(c cVar) {
        this.G = cVar;
    }

    public void b(g gVar) {
        this.f6105c = gVar;
    }

    public void c(g gVar) {
        this.f6107e.add(gVar);
    }

    public static boolean c(h hVar) {
        return hVar != null && hVar.r() && hVar.c() == 0;
    }

    public void a(AdSlot adSlot) {
        this.J = adSlot;
    }

    public void b(boolean z) {
        this.x = z;
    }

    public static boolean a(h hVar) {
        return hVar != null && hVar.r();
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f6103a = 4;
        this.m = jSONObject.optString("id");
        this.q = jSONObject.optString("source");
        this.n = new b();
        this.n.c(jSONObject.optString("pkg_name"));
        this.n.b(jSONObject.optString("name"));
        this.n.a(jSONObject.optString("download_url"));
    }

    public void a(boolean z) {
        this.C = z;
    }

    public void a(a aVar) {
        this.B = aVar;
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().b();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
    }

    public void a(n nVar) {
        this.w = nVar;
    }

    public void a(g gVar) {
        this.f6104b = gVar;
    }

    private JSONObject b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<FilterWord> it = filterWord.getOptions().iterator();
                    while (it.hasNext()) {
                        jSONArray.put(b(it.next()));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public void a(b bVar) {
        this.n = bVar;
    }

    public void a(e eVar) {
        this.o = eVar;
    }

    public void a(FilterWord filterWord) {
        this.s.add(filterWord);
    }

    public void a(long j) {
        this.u = j;
    }

    public void a(Map<String, Object> map) {
        this.A = map;
    }

    public void a(JSONObject jSONObject) {
        this.Q = jSONObject;
    }

    public static boolean a(h hVar, boolean z, boolean z2) {
        n nVar;
        if (hVar != null && (nVar = hVar.w) != null && nVar.a() == 1) {
            o.b("MaterialMeta", "can show end card follow js");
            return z2;
        }
        o.b("MaterialMeta", "can show end card follow js WebViewClient");
        return z;
    }

    public static boolean b(h hVar) {
        return hVar != null && hVar.r() && hVar.c() == 1;
    }
}
