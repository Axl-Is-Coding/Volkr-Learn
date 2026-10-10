package com.alibaba.sdk.android.feedback.xblink.f;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.f.a.p;
import com.alibaba.sdk.android.feedback.xblink.f.a.t;
import com.alibaba.sdk.android.feedback.xblink.f.a.u;
import com.alibaba.sdk.android.feedback.xblink.f.a.y;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f3866a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f3867b = new HashMap();

    public static a a(String str, Context context, XBHybridWebView xBHybridWebView) {
        l lVar = (l) f3866a.get(str);
        if (lVar != null) {
            String strA = lVar.a();
            if (!TextUtils.isEmpty(strA)) {
                try {
                    ClassLoader classLoaderB = lVar.b();
                    Class<?> cls = classLoaderB == null ? Class.forName(strA) : classLoaderB.loadClass(strA);
                    if (cls != null && a.class.isAssignableFrom(cls)) {
                        a aVar = (a) cls.newInstance();
                        aVar.a(context, xBHybridWebView);
                        return aVar;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.alibaba.sdk.android.feedback.xblink.i.g.b("WVPluginManager", "create plugin error: " + str + ". " + e2.getMessage());
                }
                if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.e("WVPluginManager", "create plugin failed: " + str);
                }
                return null;
            }
        }
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVPluginManager", "create plugin failed, plugin not register or empty, " + str);
        }
        return null;
    }

    public static Map a(String str, String str2) {
        int iIndexOf;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVPluginManager", "getOriginalPlugin failed, alias is empty.");
            return null;
        }
        String str3 = (String) f3867b.get(str + "::" + str2);
        if (TextUtils.isEmpty(str3) || (iIndexOf = str3.indexOf("::")) <= 0) {
            return null;
        }
        String strSubstring = str3.substring(0, iIndexOf);
        String strSubstring2 = str3.substring(iIndexOf + 2);
        HashMap map = new HashMap();
        map.put("name", strSubstring);
        map.put(FirebaseAnalytics.Param.METHOD, strSubstring2);
        return map;
    }

    public static void a() {
        a("Base", com.alibaba.sdk.android.feedback.xblink.f.a.a.class);
        a("WXBase", com.alibaba.sdk.android.feedback.xblink.f.b.c.class);
        a("WXApp", com.alibaba.sdk.android.feedback.xblink.f.b.a.class);
        a("WXCommunication", com.alibaba.sdk.android.feedback.xblink.f.b.d.class);
        a("WXPageAction", "createNewPage", "WXApp", "createNewPage");
        a("WXCamera", "takePhoto", "WVCamera", "takePhoto");
        a("WXCamera", "photoReduce", "WVCamera", "photoReduce");
        a("WXCamera", "confirmUploadPhoto", "WVCamera", "confirmUploadPhoto");
        a("WXPhoto", u.class);
        a("WXMediaRecorder", p.class);
        a("WXMediaPlayer", com.alibaba.sdk.android.feedback.xblink.f.a.k.class);
        a("WXDevice", com.alibaba.sdk.android.feedback.xblink.f.a.d.class);
        a("WXFeedBack", com.alibaba.sdk.android.feedback.xblink.f.a.g.class);
        a("WXLogin", com.alibaba.sdk.android.feedback.xblink.f.a.j.class);
        a("WXMsg", t.class);
        a("WXLog", com.alibaba.sdk.android.feedback.xblink.f.a.i.class);
        a("WXTrack", y.class);
        a("WVToolBarManager", com.alibaba.sdk.android.feedback.xblink.f.a.b.class);
        a("WXErrorPage", com.alibaba.sdk.android.feedback.xblink.f.a.f.class);
        a("WXEncriptionTool", com.alibaba.sdk.android.feedback.xblink.f.a.e.class);
        a("WXKeyboard", com.alibaba.sdk.android.feedback.xblink.f.a.h.class);
    }

    public static void a(String str, Class cls) {
        a(str, cls, false);
    }

    public static void a(String str, Class cls, boolean z) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        f3866a.put(str, new l(cls.getName(), z ? cls.getClassLoader() : null));
    }

    public static void a(String str, String str2, String str3, String str4) {
        if (!f3866a.containsKey(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVPluginManager", "registerAlias quit, this is no original plugin or alias is invalid.");
            return;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return;
        }
        f3867b.put(str + "::" + str2, str3 + "::" + str4);
    }
}
