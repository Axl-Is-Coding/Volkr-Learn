package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.plus.PlusShare;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.ci;
import io.rong.common.LibStorageUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTAndroidObject.java */
/* JADX INFO: loaded from: classes.dex */
public class v implements com.bytedance.sdk.openadsdk.d.b, ad.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, Boolean> f6377f = new ConcurrentHashMap();
    private com.bytedance.sdk.openadsdk.e.h A;
    private List<com.bytedance.sdk.openadsdk.core.d.h> C;
    private HashMap<String, i> D;
    private com.bytedance.sdk.openadsdk.c.p G;
    private String H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<String, Object> f6378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6379b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<WebView> f6381d;
    private WeakReference<Context> g;
    private com.bytedance.sdk.openadsdk.d.c h;
    private String i;
    private WeakReference<View> j;
    private String k;
    private int l;
    private String m;
    private int n;
    private com.bytedance.sdk.openadsdk.core.d.h p;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.j q;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.g r;
    private JSONObject s;
    private com.bytedance.sdk.openadsdk.d.d t;
    private com.bytedance.sdk.openadsdk.e.a u;
    private com.bytedance.sdk.openadsdk.e.e v;
    private com.bytedance.sdk.openadsdk.e.d w;
    private JSONObject x;
    private com.bytedance.sdk.openadsdk.core.a.d y;
    private com.bytedance.sdk.openadsdk.e.b z;
    private boolean o = true;
    private boolean B = true;
    private boolean E = false;
    private boolean F = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6380c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ad f6382e = new ad(Looper.getMainLooper(), this);

    /* JADX INFO: compiled from: TTAndroidObject.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f6398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6399e;
    }

    static {
        f6377f.put("log_event", Boolean.TRUE);
        f6377f.put("private", Boolean.TRUE);
        f6377f.put("dispatch_message", Boolean.TRUE);
        f6377f.put("custom_event", Boolean.TRUE);
        f6377f.put("log_event_v3", Boolean.TRUE);
    }

    public v(Context context) {
        this.g = new WeakReference<>(context);
    }

    private void d(JSONObject jSONObject) throws Exception {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.p;
        if (hVar == null || TextUtils.isEmpty(hVar.d())) {
            return;
        }
        jSONObject.put("playable_style", this.p.d());
    }

    private void e(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.c.p pVar;
        if (jSONObject == null || (pVar = this.G) == null) {
            return;
        }
        pVar.a(jSONObject);
    }

    private void f(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.e.b bVar = this.z;
        if (bVar == null || jSONObject == null) {
            return;
        }
        bVar.a(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject) {
        if (this.r == null || jSONObject == null) {
            return;
        }
        try {
            this.r.e(jSONObject.optBoolean("mute", false));
        } catch (Exception unused) {
        }
    }

    private WebView h() {
        WeakReference<WebView> weakReference = this.f6381d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private JSONObject i() {
        try {
            View view = this.j.get();
            WebView webView = this.f6381d.get();
            if (view != null && webView != null) {
                int[] iArrB = ac.b(view);
                int[] iArrB2 = ac.b(webView);
                if (iArrB != null && iArrB2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", ac.b(o.a(), iArrB[0] - iArrB2[0]));
                    jSONObject.put("y", ac.b(o.a(), iArrB[1] - iArrB2[1]));
                    jSONObject.put("w", ac.b(o.a(), view.getWidth()));
                    jSONObject.put("h", ac.b(o.a(), view.getHeight()));
                    jSONObject.put("isExist", ac.e(view));
                    return jSONObject;
                }
                com.bytedance.sdk.openadsdk.utils.o.e("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
                return null;
            }
            com.bytedance.sdk.openadsdk.utils.o.e("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("TTAndroidObject", "setCloseButtonInfo error", th);
            return null;
        }
    }

    private List<String> j() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    private void k() {
        com.bytedance.sdk.openadsdk.e.h hVar = this.A;
        if (hVar == null) {
            return;
        }
        hVar.a();
    }

    private void l() {
        com.bytedance.sdk.openadsdk.e.h hVar = this.A;
        if (hVar == null) {
            return;
        }
        hVar.b();
    }

    private void m() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = this.r;
        if (gVar != null) {
            gVar.K();
        }
    }

    private void n() {
        WeakReference<Context> weakReference = this.g;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.p != null) {
            com.bytedance.sdk.openadsdk.c.d.a(this.g.get(), this.p, this.H, "open_policy");
        }
        if (TextUtils.isEmpty(o.h().q())) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.b.a(this.f6381d.get().getContext(), new Intent(this.f6381d.get().getContext(), (Class<?>) TTWebsiteActivity.class), null);
    }

    private JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        if (o.h() != null) {
            try {
                int iD = ab.d(this.k);
                int iG = o.h().g(String.valueOf(iD));
                int iE = o.h().e(iD);
                boolean zC = o.h().c(String.valueOf(iD));
                jSONObject.put("voice_control", o.h().b(iD));
                jSONObject.put("rv_skip_time", iG);
                jSONObject.put("fv_skip_show", zC);
                jSONObject.put("iv_skip_time", iE);
                jSONObject.put("show_dislike", this.p != null && this.p.X());
                jSONObject.put("video_adaptation", this.p != null ? this.p.g() : 0);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Context context;
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.C;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.D = new HashMap<>();
        WeakReference<WebView> weakReference = this.f6381d;
        WebView webView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.g;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.d.h hVar : this.C) {
            this.D.put(hVar.J(), new i(context, hVar, webView));
        }
    }

    private boolean q() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.p;
        if (hVar == null || hVar.U() == null || this.p.r() || this.E || this.p.U().optInt("parent_type") != 2) {
            return false;
        }
        int iC = ab.c(this.k);
        if (iC != 8 && iC != 7) {
            return false;
        }
        this.E = true;
        return true;
    }

    private void r() {
        if (this.h == null) {
            this.h = com.bytedance.sdk.openadsdk.d.a.a(this, this.p);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                h(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.2
                    @Override // java.lang.Runnable
                    public void run() {
                        v.this.h(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                j(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.3
                    @Override // java.lang.Runnable
                    public void run() {
                        v.this.j(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            l(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        i(jSONObject);
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        a("getTemplateInfo", true);
        try {
            if (this.s != null) {
                this.s.put("setting", o());
            }
            a("getTemplateInfo", false);
            return this.s.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                g(jSONObject);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.1
                    @Override // java.lang.Runnable
                    public void run() {
                        v.this.g(jSONObject);
                    }
                });
            }
        } catch (Exception unused) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTAndroidObject", "");
        }
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            k(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(JSONObject jSONObject) {
        if (this.r == null || jSONObject == null) {
            return;
        }
        try {
            this.r.c(jSONObject.optInt("stateType", -1));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject) {
        String str;
        int i;
        double d2;
        double d3;
        double dOptDouble;
        double dOptDouble2;
        double dOptDouble3;
        double dOptDouble4;
        double d4;
        double d5;
        double dOptDouble5;
        int i2;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            double d6 = 0.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_x", 0.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("down_y", 0.0d);
                dOptDouble2 = jSONObjectOptJSONObject.optDouble("up_x", 0.0d);
                dOptDouble3 = jSONObjectOptJSONObject.optDouble("up_y", 0.0d);
                dOptDouble4 = jSONObjectOptJSONObject.optDouble("down_time", 0.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", 0.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", 0.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", 0.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", 0.0d);
                dOptDouble5 = jSONObjectOptJSONObject.optDouble("button_height", 0.0d);
                d6 = dOptDouble6;
                d3 = dOptDouble7;
                d4 = dOptDouble9;
                d5 = dOptDouble10;
                str = strOptString;
                i = iOptInt;
                d2 = dOptDouble8;
            } else {
                str = strOptString;
                i = iOptInt;
                d2 = 0.0d;
                d3 = 0.0d;
                dOptDouble = 0.0d;
                dOptDouble2 = 0.0d;
                dOptDouble3 = 0.0d;
                dOptDouble4 = 0.0d;
                d4 = 0.0d;
                d5 = 0.0d;
                dOptDouble5 = 0.0d;
            }
            com.bytedance.sdk.openadsdk.core.d.f fVarA = new f.a().d((int) d6).c((int) dOptDouble).b((int) dOptDouble2).a((int) dOptDouble3).b((long) dOptDouble4).a((long) d3).e((int) d2).f((int) d4).g((int) d5).h((int) dOptDouble5).a();
            if (this.q != null) {
                i2 = i;
                this.q.a(i2, fVarA);
            } else {
                i2 = i;
            }
            a(str, i2, fVarA);
        } catch (Exception unused) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar = this.q;
            if (jVar != null) {
                jVar.a(-1, null);
            }
        }
    }

    public v c(String str) {
        this.m = str;
        return this;
    }

    private String e(String str) {
        return this.q == null ? ab.a(this.l) : str;
    }

    private void f(String str) {
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView webViewH = h();
                    if (webViewH != null) {
                        com.bytedance.sdk.openadsdk.utils.n.a(webViewH, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/")) {
                    int iIndexOf = str.indexOf(38, 30);
                    if (iIndexOf <= 0) {
                        return;
                    }
                    String strSubstring = str.substring(30, iIndexOf);
                    String strSubstring2 = str.substring(iIndexOf + 1);
                    if (strSubstring.equals("SCENE_FETCHQUEUE") && strSubstring2.length() > 0) {
                        d(strSubstring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void k(JSONObject jSONObject) {
        double dOptDouble;
        boolean z;
        if (this.q == null || jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.j jVar = new com.bytedance.sdk.openadsdk.core.d.j();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
            double dOptDouble2 = 0.0d;
            if (jSONObjectOptJSONObject != null) {
                dOptDouble2 = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                dOptDouble = jSONObjectOptJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            } else {
                dOptDouble = 0.0d;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
            if (jSONObjectOptJSONObject2 != null) {
                double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                z = zOptBoolean;
                double dOptDouble5 = jSONObjectOptJSONObject2.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                double dOptDouble6 = jSONObjectOptJSONObject2.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                jVar.c(dOptDouble3);
                jVar.d(dOptDouble4);
                jVar.e(dOptDouble5);
                jVar.f(dOptDouble6);
            } else {
                z = zOptBoolean;
            }
            String strOptString = jSONObject.optString("message", g.a(101));
            int iOptInt = jSONObject.optInt("code", 101);
            jVar.a(z);
            jVar.a(dOptDouble2);
            jVar.b(dOptDouble);
            jVar.a(strOptString);
            jVar.a(iOptInt);
            this.q.a(jVar);
        } catch (Exception unused) {
            jVar.a(101);
            jVar.a(g.a(101));
            this.q.a(jVar);
        }
    }

    private void l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.utils.l.a(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void m(JSONObject jSONObject) {
        if (jSONObject == null || this.t == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                this.t.a(true, jSONArrayOptJSONArray);
            } else {
                this.t.a(false, null);
            }
        } catch (Exception unused) {
            this.t.a(false, null);
        }
    }

    public v b(boolean z) {
        this.F = z;
        return this;
    }

    public v c(boolean z) {
        this.B = z;
        return this;
    }

    public void d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", a(this.C));
            a("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.i)) {
            jSONObject.put("cid", this.i);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("log_extra", this.k);
        }
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("download_url", this.m);
        }
        jSONObject.put("dc", TextUtils.isEmpty(o.h().t()) ? o.h().t() : "SG");
        jSONObject.put(au.M, ab.c(o.a()));
    }

    public v b(String str) {
        this.k = str;
        return this;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.d.c cVar = this.h;
        if (cVar != null) {
            cVar.c();
        }
    }

    public v a(WebView webView) {
        this.f6381d = new WeakReference<>(webView);
        return this;
    }

    public v b(int i) {
        this.l = i;
        return this;
    }

    public void e() {
        com.bytedance.sdk.openadsdk.d.c cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
        if (q()) {
            c();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.c.p pVar) {
        this.G = pVar;
    }

    public v b(JSONObject jSONObject) {
        this.x = jSONObject;
        return this;
    }

    private void d(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                a aVar = new a();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        aVar.f6395a = jSONObjectOptJSONObject.optString("__msg_type", null);
                        aVar.f6396b = jSONObjectOptJSONObject.optString("__callback_id", null);
                        aVar.f6397c = jSONObjectOptJSONObject.optString("func");
                        aVar.f6398d = jSONObjectOptJSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                        aVar.f6399e = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(aVar.f6395a) && !TextUtils.isEmpty(aVar.f6397c)) {
                    Message messageObtainMessage = this.f6382e.obtainMessage(11);
                    messageObtainMessage.obj = aVar;
                    this.f6382e.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.openadsdk.utils.o.a()) {
                com.bytedance.sdk.openadsdk.utils.o.d("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            com.bytedance.sdk.openadsdk.utils.o.d("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    private boolean n(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", a(this.C));
        } catch (Exception unused) {
        }
        return true;
    }

    public v a(boolean z) {
        this.f6379b = z;
        return this;
    }

    public boolean b() {
        return this.f6380c;
    }

    private void b(final a aVar, final JSONObject jSONObject) {
        if (aVar == null) {
            return;
        }
        try {
            a(aVar.f6398d, new com.bytedance.sdk.openadsdk.e.c() { // from class: com.bytedance.sdk.openadsdk.core.v.4
                @Override // com.bytedance.sdk.openadsdk.e.c
                public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.h> list) {
                    if (!z) {
                        v.this.b(aVar.f6396b, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", v.this.a(list));
                        v.this.b(aVar.f6396b, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public v a(String str) {
        this.i = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            o(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public v a(View view) {
        this.j = new WeakReference<>(view);
        return this;
    }

    private JSONObject p(JSONObject jSONObject) {
        if (this.f6378a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                for (Map.Entry<String, Object> entry : this.f6378a.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.utils.o.b(e2.toString());
            }
        }
        return jSONObject;
    }

    public v a(int i) {
        this.n = i;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.p = hVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.b bVar) {
        this.z = bVar;
        return this;
    }

    public void c() {
        a((JSONObject) null, new com.bytedance.sdk.openadsdk.e.c() { // from class: com.bytedance.sdk.openadsdk.core.v.5
            @Override // com.bytedance.sdk.openadsdk.e.c
            public void a(boolean z, List<com.bytedance.sdk.openadsdk.core.d.h> list) {
                v.this.C = list;
                v.this.p();
                v.this.d();
            }
        });
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "event");
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            o(jSONObject2);
        } catch (Exception unused) {
        }
    }

    public v a(com.bytedance.sdk.openadsdk.e.h hVar) {
        this.A = hVar;
        return this;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.d.c cVar = this.h;
        if (cVar != null) {
            cVar.b();
        }
    }

    private boolean i(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar = this.r;
        if (gVar != null && jSONObject != null) {
            double dL = gVar.L();
            int iM = this.r.M();
            Double.isNaN(dL);
            try {
                jSONObject.put("currentTime", dL / 1000.0d);
                jSONObject.put(ServerProtocol.DIALOG_PARAM_STATE, iM);
                com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "currentTime,state:" + iM);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void o(JSONObject jSONObject) {
        WebView webViewH;
        if (jSONObject == null || (webViewH = h()) == null) {
            return;
        }
        String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")";
        com.bytedance.sdk.openadsdk.utils.n.a(webViewH, str);
        if (com.bytedance.sdk.openadsdk.utils.o.a()) {
            com.bytedance.sdk.openadsdk.utils.o.a("TTAndroidObject", "js_msg " + str);
        }
    }

    public boolean a() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.p;
        return hVar != null && hVar.b();
    }

    public void b(Uri uri) {
        long j;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.openadsdk.utils.o.d("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                f(uri.toString());
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            this.H = queryParameter2;
            String queryParameter3 = uri.getQueryParameter(PlusShare.KEY_CALL_TO_ACTION_LABEL);
            long j2 = 0;
            try {
                j = Long.parseLong(uri.getQueryParameter("value"));
            } catch (Exception unused) {
                j = 0;
            }
            try {
                j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
            } catch (Exception unused2) {
            }
            long j3 = j2;
            JSONObject jSONObject = null;
            String queryParameter4 = uri.getQueryParameter("extra");
            if (!TextUtils.isEmpty(queryParameter4)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(queryParameter4);
                    try {
                        jSONObject2.putOpt("ua_policy", Integer.valueOf(this.n));
                    } catch (Exception unused3) {
                    }
                    jSONObject = jSONObject2;
                } catch (Exception unused4) {
                }
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.p, queryParameter, e(queryParameter2), queryParameter3, j, j3, "click".equals(queryParameter3) ? p(jSONObject) : jSONObject);
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "handleUri exception: ", e2);
        }
    }

    public v a(Map<String, Object> map) {
        this.f6378a = map;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar) {
        this.q = jVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.nativeexpress.g gVar) {
        this.r = gVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.d.d dVar) {
        this.t = dVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.core.a.d dVar) {
        this.y = dVar;
        return this;
    }

    public v a(JSONObject jSONObject) {
        this.s = jSONObject;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.a aVar) {
        this.u = aVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.e eVar) {
        this.v = eVar;
        return this;
    }

    public v a(com.bytedance.sdk.openadsdk.e.d dVar) {
        this.w = dVar;
        return this;
    }

    private void a(JSONObject jSONObject, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = j().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.a.a.a());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.a.a.e());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.a.a.b());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.a.a.d());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.a.a.f());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.a.a.a(o.a()));
    }

    private void a(a aVar) throws Exception {
        JSONObject jSONObjectI;
        com.bytedance.sdk.openadsdk.e.a aVar2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if ("call".equals(aVar.f6395a)) {
            JSONObject jSONObject3 = new JSONObject();
            if ("appInfo".equals(aVar.f6397c)) {
                if (TextUtils.isEmpty(aVar.f6396b)) {
                    return;
                }
                a(jSONObject3, aVar.f6399e);
                b(aVar.f6396b, jSONObject3);
                return;
            }
            if ("adInfo".equals(aVar.f6397c)) {
                if (TextUtils.isEmpty(aVar.f6396b)) {
                    return;
                }
                c(jSONObject3);
                b(aVar.f6396b, jSONObject3);
                return;
            }
            if ("sendLog".equals(aVar.f6397c)) {
                JSONObject jSONObject4 = aVar.f6398d;
                if (jSONObject4 != null && (jSONObject2 = jSONObject4.getJSONObject("extJson")) != null && jSONObject2.has("category") && jSONObject2.has("tag") && jSONObject2.has(PlusShare.KEY_CALL_TO_ACTION_LABEL)) {
                    String string = jSONObject2.getString("category");
                    jSONObject2.getString("tag");
                    String string2 = jSONObject2.getString(PlusShare.KEY_CALL_TO_ACTION_LABEL);
                    long j = jSONObject4.getLong("value");
                    long j2 = jSONObject4.getLong("extValue");
                    try {
                        jSONObject2.putOpt("ua_policy", Integer.valueOf(this.n));
                    } catch (Exception unused) {
                    }
                    if ("click".equals(string2)) {
                        jSONObject2 = p(jSONObject2);
                    }
                    com.bytedance.sdk.openadsdk.c.d.a(this.p, string, ab.a(this.l), string2, j, j2, jSONObject2);
                    return;
                }
                return;
            }
            if ("playable_style".equals(aVar.f6397c)) {
                if (TextUtils.isEmpty(aVar.f6396b)) {
                    return;
                }
                d(jSONObject3);
                b(aVar.f6396b, jSONObject3);
                return;
            }
            if ("getTemplateInfo".equals(aVar.f6397c)) {
                if (TextUtils.isEmpty(aVar.f6396b)) {
                    return;
                }
                JSONObject jSONObject5 = this.s;
                if (jSONObject5 != null) {
                    jSONObject5.put("setting", o());
                }
                b(aVar.f6396b, this.s);
                return;
            }
            if ("getTeMaiAds".equals(aVar.f6397c) && !TextUtils.isEmpty(aVar.f6396b) && (jSONObject = this.x) != null) {
                b(aVar.f6396b, jSONObject);
            }
            if ("isViewable".equals(aVar.f6397c)) {
                if (TextUtils.isEmpty(aVar.f6396b)) {
                    return;
                }
                jSONObject3.put("viewStatus", this.F ? 1 : 0);
                b(aVar.f6396b, jSONObject3);
                return;
            }
            if ("getScreenSize".equals(aVar.f6397c)) {
                if (TextUtils.isEmpty(aVar.f6396b) || (aVar2 = this.u) == null) {
                    return;
                }
                int iB = aVar2.b();
                int iA = this.u.a();
                jSONObject3.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, iB);
                jSONObject3.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, iA);
                b(aVar.f6396b, jSONObject3);
                return;
            }
            if ("getCloseButtonInfo".equals(aVar.f6397c)) {
                if (TextUtils.isEmpty(aVar.f6396b) || (jSONObjectI = i()) == null) {
                    return;
                }
                b(aVar.f6396b, jSONObjectI);
                return;
            }
            if ("getVolume".equals(aVar.f6397c)) {
                AudioManager audioManager = (AudioManager) o.a().getSystemService(LibStorageUtils.AUDIO);
                int streamVolume = -1;
                if (audioManager != null) {
                    streamVolume = audioManager.getStreamVolume(3);
                    com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "音乐音量 >>>> AudioManager-->currentVolume=" + streamVolume);
                }
                if (TextUtils.isEmpty(aVar.f6396b)) {
                    return;
                }
                jSONObject3.put("endcard_mute", streamVolume <= 0);
                b(aVar.f6396b, jSONObject3);
                return;
            }
            if ("removeLoading".equals(aVar.f6397c)) {
                com.bytedance.sdk.openadsdk.e.d dVar = this.w;
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            if ("sendReward".equals(aVar.f6397c)) {
                this.f6380c = true;
                com.bytedance.sdk.openadsdk.e.e eVar = this.v;
                if (eVar != null) {
                    eVar.a();
                }
            }
            boolean zA = a(aVar, jSONObject3);
            if (!TextUtils.isEmpty(aVar.f6396b) && zA) {
                b(aVar.f6396b, jSONObject3);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean a(a aVar, JSONObject jSONObject) {
        Context context;
        WeakReference<Context> weakReference;
        Context context2;
        Object obj;
        if (this.f6379b) {
            try {
                JSONObject jSONObjectOptJSONObject = aVar.f6398d.optJSONObject("data");
                if (jSONObjectOptJSONObject != null) {
                    com.bytedance.sdk.openadsdk.utils.o.b("download_app_ad", "替换 download_url 前 appAdJson:" + jSONObjectOptJSONObject.toString());
                    jSONObjectOptJSONObject.put("download_url", this.p.K().a());
                    com.bytedance.sdk.openadsdk.utils.o.c("download_app_ad", "替换 download_url 后 appAdJson::" + jSONObjectOptJSONObject.toString());
                }
            } catch (Throwable unused) {
            }
        }
        String str = aVar.f6397c;
        byte b2 = -1;
        switch (str.hashCode()) {
            case -2036781162:
                if (str.equals("subscribe_app_ad")) {
                    b2 = 0;
                }
                break;
            case -1330994877:
                if (str.equals("pauseWebView")) {
                    b2 = ci.n;
                }
                break;
            case -1169135450:
                if (str.equals("changeVideoState")) {
                    b2 = 9;
                }
                break;
            case -844321441:
                if (str.equals("webview_time_track")) {
                    b2 = 18;
                }
                break;
            case -800853518:
                if (str.equals("clickEvent")) {
                    b2 = 4;
                }
                break;
            case -511324706:
                if (str.equals("openPrivacy")) {
                    b2 = 12;
                }
                break;
            case -489318846:
                if (str.equals("getMaterialMeta")) {
                    b2 = ci.k;
                }
                break;
            case -278382602:
                if (str.equals("send_temai_product_ids")) {
                    b2 = 11;
                }
                break;
            case 27837080:
                if (str.equals("download_app_ad")) {
                    b2 = 1;
                }
                break;
            case 105049135:
                if (str.equals("unsubscribe_app_ad")) {
                    b2 = 2;
                }
                break;
            case 571273292:
                if (str.equals("dynamicTrack")) {
                    b2 = 6;
                }
                break;
            case 711635577:
                if (str.equals("getCurrentVideoState")) {
                    b2 = 10;
                }
                break;
            case 1107374321:
                if (str.equals("pauseWebViewTimers")) {
                    b2 = 17;
                }
                break;
            case 1151744482:
                if (str.equals("muteVideo")) {
                    b2 = 8;
                }
                break;
            case 1237100796:
                if (str.equals("renderDidFinish")) {
                    b2 = 5;
                }
                break;
            case 1634511418:
                if (str.equals("endcard_load")) {
                    b2 = ci.m;
                }
                break;
            case 1713585602:
                if (str.equals("getNetworkData")) {
                    b2 = ci.l;
                }
                break;
            case 2086000188:
                if (str.equals("skipVideo")) {
                    b2 = 7;
                }
                break;
            case 2105008900:
                if (str.equals("landscape_click")) {
                    b2 = 3;
                }
                break;
        }
        switch (b2) {
            case 0:
                r();
                WeakReference<Context> weakReference2 = this.g;
                if (weakReference2 != null && (context = weakReference2.get()) != null) {
                    this.h.a(context, aVar.f6398d, this.k, this.l, this.o);
                }
                return false;
            case 1:
                com.bytedance.sdk.openadsdk.core.a.d dVar = this.y;
                if (dVar != null) {
                    dVar.a(this.B);
                    return false;
                }
                if (this.h != null && (weakReference = this.g) != null && (context2 = weakReference.get()) != null) {
                    this.h.a(context2, aVar.f6398d);
                }
                return false;
            case 2:
                com.bytedance.sdk.openadsdk.d.c cVar = this.h;
                if (cVar == null) {
                    return false;
                }
                cVar.a(aVar.f6398d);
                return false;
            case 3:
                WeakReference<Context> weakReference3 = this.g;
                if (weakReference3 != null && (obj = (Context) weakReference3.get()) != null && (obj instanceof com.bytedance.sdk.openadsdk.core.video.d.b)) {
                    ((com.bytedance.sdk.openadsdk.core.video.d.b) obj).Q();
                }
                return false;
            case 4:
                j(aVar.f6398d);
                return false;
            case 5:
                k(aVar.f6398d);
                return false;
            case 6:
                l(aVar.f6398d);
                return false;
            case 7:
                m();
                return false;
            case 8:
                g(aVar.f6398d);
                return false;
            case 9:
                h(aVar.f6398d);
                return false;
            case 10:
                return i(jSONObject);
            case 11:
                m(aVar.f6398d);
                return false;
            case 12:
                com.bytedance.sdk.openadsdk.utils.o.b("TTAndroidObject", "openPrivacy");
                n();
                return false;
            case 13:
                return n(jSONObject);
            case 14:
                b(aVar, jSONObject);
                return false;
            case 15:
                f(aVar.f6398d);
                return false;
            case 16:
                k();
                return false;
            case 17:
                l();
                e(aVar.f6398d);
                return false;
            case 18:
                e(aVar.f6398d);
                return false;
            default:
                return false;
        }
    }

    private void a(String str, boolean z) {
        if (this.G == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.G.a(str);
        } else {
            this.G.b(str);
        }
    }

    private void a(String str, int i, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        HashMap<String, i> map;
        i iVar;
        if (TextUtils.isEmpty(str) || (map = this.D) == null || (iVar = map.get(str)) == null) {
            return;
        }
        iVar.a(i, fVar);
    }

    private void a(JSONObject jSONObject, final com.bytedance.sdk.openadsdk.e.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            if (this.p != null && !TextUtils.isEmpty(this.k)) {
                int iC = ab.c(this.k);
                AdSlot adSlotK = this.p.k();
                com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
                if (this.p.u() != null) {
                    iVar.f6119e = 2;
                }
                JSONObject jSONObjectU = this.p.U();
                if (jSONObjectU == null) {
                    jSONObjectU = new JSONObject();
                }
                if (jSONObject != null) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectU.put(next, jSONObject.opt(next));
                    }
                }
                iVar.g = jSONObjectU;
                o.f().a(adSlotK, iVar, iC, new p.a() { // from class: com.bytedance.sdk.openadsdk.core.v.6
                    @Override // com.bytedance.sdk.openadsdk.core.p.a
                    public void a(int i, String str) {
                        cVar.a(false, null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.a
                    public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                        if (aVar.c() == null || aVar.c().isEmpty()) {
                            cVar.a(false, null);
                        } else {
                            cVar.a(true, aVar.c());
                        }
                    }
                });
                return;
            }
            cVar.a(false, null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray a(List<com.bytedance.sdk.openadsdk.core.d.h> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).Z());
        }
        return jSONArray;
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (f6377f.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message != null && message.what == 11) {
            Object obj = message.obj;
            if (obj instanceof a) {
                try {
                    a((a) obj);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.b
    public void a(String str, JSONObject jSONObject) {
        c(str, jSONObject);
    }
}
