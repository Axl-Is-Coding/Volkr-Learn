package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewPageTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20938c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static JSONArray f20939d = new JSONArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f20940e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f20943f = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Stack<String> f20941a = new Stack<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f20942b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f20940e) {
                    string = f20939d.toString();
                    f20939d = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put("__a", new JSONArray(string));
                    if (jSONObject.length() > 0) {
                        g.a(context).a(s.a().c(), jSONObject, g.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f20943f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.f20941a.size() == 0) {
                UMLog.aq(h.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f20943f) {
            l = this.f20943f.get(str);
        }
        if (l == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f20941a.size() > 0 && str.equals(this.f20941a.peek())) {
            this.f20941a.pop();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - l.longValue();
        synchronized (f20940e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(b.u, str);
                jSONObject.put("duration", jCurrentTimeMillis);
                jSONObject.put(b.w, l);
                jSONObject.put("type", a());
                f20939d.put(jSONObject);
                if (f20939d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, m.a.f20901c, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.f20941a.size() == 0) {
            return;
        }
        UMLog.aq(h.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f20941a.size() != 0) {
            UMLog.aq(h.F, 0, "\\|", new String[]{"@"}, new String[]{this.f20941a.peek()}, null, null);
        }
        this.f20942b.customPageBegin(str);
        synchronized (this.f20943f) {
            this.f20943f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f20941a.push(str);
            }
        }
    }

    public void b() {
        String key;
        synchronized (this.f20943f) {
            key = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f20943f.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long jLongValue = entry.getValue().longValue();
                    key = entry.getKey();
                    j = jLongValue;
                }
            }
        }
        if (key != null) {
            b(key);
        }
    }
}
