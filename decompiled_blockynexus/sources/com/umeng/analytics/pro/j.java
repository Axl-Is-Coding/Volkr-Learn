package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.c;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoViewPageTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20878a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f20882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f20883d;
    com.umeng.analytics.vshelper.a g;
    Application.ActivityLifecycleCallbacks h;
    private final Map<String, Long> i;
    private boolean m;
    private int n;
    private int o;
    private static JSONArray j = new JSONArray();
    private static Object k = new Object();
    private static Application l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MobclickAgent.PageMode f20879b = MobclickAgent.PageMode.AUTO;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static String f20880e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static int f20881f = -1;

    /* JADX INFO: compiled from: AutoViewPageTracker.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final j f20885a = new j();

        private a() {
        }
    }

    static /* synthetic */ int a(j jVar) {
        int i = jVar.o;
        jVar.o = i - 1;
        return i;
    }

    static /* synthetic */ int b(j jVar) {
        int i = jVar.n;
        jVar.n = i - 1;
        return i;
    }

    static /* synthetic */ int e(j jVar) {
        int i = jVar.o;
        jVar.o = i + 1;
        return i;
    }

    static /* synthetic */ int f(j jVar) {
        int i = jVar.n;
        jVar.n = i + 1;
        return i;
    }

    private j() {
        this.i = new HashMap();
        this.m = false;
        this.f20882c = false;
        this.f20883d = false;
        this.n = 0;
        this.o = 0;
        this.g = PageNameMonitor.getInstance();
        this.h = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.j.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (j.f20879b != MobclickAgent.PageMode.AUTO) {
                    return;
                }
                j.this.b(activity);
                com.umeng.analytics.b.a().i();
                j.this.f20882c = false;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) throws Throwable {
                if (j.f20879b == MobclickAgent.PageMode.AUTO && activity != null) {
                    String str = activity.getPackageName() + Consts.DOT + activity.getLocalClassName();
                    j.this.g.activityResume(str);
                    j jVar = j.this;
                    if (jVar.f20882c) {
                        jVar.f20882c = false;
                        if (TextUtils.isEmpty(j.f20878a)) {
                            j.f20878a = str;
                        } else if (!j.f20878a.equals(str)) {
                            j.this.a(activity);
                            com.umeng.analytics.b.a().h();
                        }
                    } else {
                        jVar.a(activity);
                        com.umeng.analytics.b.a().h();
                    }
                }
                if (UMConfigure.isDebugLog()) {
                    String str2 = !AnalyticsConfig.CATCH_EXCEPTION ? "否" : "是";
                    long j2 = AnalyticsConfig.kContinueSessionMillis / 1000;
                    if (j.this.f20883d) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("[当前页面采集模式]: " + j.f20879b.toString());
                    sb.append("; ");
                    sb.append(" [是否使能异常捕获功能]: " + str2);
                    sb.append("; ");
                    sb.append(" [当前会话间隔时长]: " + j2 + "秒");
                    MLog.d(sb.toString());
                    j.this.f20883d = true;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) throws Throwable {
                if (activity != null) {
                    if (j.this.n <= 0) {
                        if (j.f20880e == null) {
                            j.f20880e = UUID.randomUUID().toString();
                        }
                        if (j.f20881f == -1) {
                            j.f20881f = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (j.f20881f == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap map = new HashMap();
                            map.put("activityName", activity.toString());
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) map);
                            j.f20881f = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, h.ar);
                            }
                        } else if (j.f20881f == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap map2 = new HashMap();
                            map2.put("pairUUID", j.f20880e);
                            map2.put("pid", Integer.valueOf(Process.myPid()));
                            map2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map2.put("activityName", activity.toString());
                            com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) map2);
                        }
                    }
                    if (j.this.o < 0) {
                        j.e(j.this);
                    } else {
                        j.f(j.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) throws Throwable {
                MobclickAgent.PageMode pageMode = j.f20879b;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        j.a(j.this);
                        return;
                    }
                    j.b(j.this);
                    if (j.this.n <= 0) {
                        if (j.f20881f == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i = j.f20881f;
                        if ((i == 1 || (i == 0 && !UMUtils.isMainProgress(activity))) && activity != null) {
                            HashMap map = new HashMap();
                            map.put("pairUUID", j.f20880e);
                            map.put("reason", "Normal");
                            map.put("pid", Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map.put("activityName", activity.toString());
                            com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) map);
                            if (j.f20880e != null) {
                                j.f20880e = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (l != null) {
                d();
            }
        }
    }

    private void d() {
        if (this.m) {
            return;
        }
        this.m = true;
        if (l == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        l.registerActivityLifecycleCallbacks(this.h);
    }

    public void c() {
        b((Activity) null);
        b();
    }

    public boolean a() {
        return this.m;
    }

    public void b() {
        this.m = false;
        if (l != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                l.unregisterActivityLifecycleCallbacks(this.h);
            }
            l = null;
        }
    }

    public static synchronized j a(Context context) {
        if (l == null && context != null) {
            if (context instanceof Activity) {
                l = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                l = (Application) context;
            }
        }
        return a.f20885a;
    }

    public static void b(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (k) {
                    string = j.toString();
                    j = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put(c.d.a.f20810c, new JSONArray(string));
                    g.a(context).a(s.a().c(), jSONObject, g.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str) {
        if (f20881f == 1 && UMUtils.isMainProgress(context)) {
            HashMap map = new HashMap();
            map.put("pairUUID", f20880e);
            map.put("reason", str);
            if (f20880e != null) {
                f20880e = null;
            }
            if (context != null) {
                map.put("pid", Integer.valueOf(Process.myPid()));
                map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                map.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        f20878a = activity.getPackageName() + Consts.DOT + activity.getLocalClassName();
        synchronized (this.i) {
            this.i.put(f20878a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.i) {
                if (f20878a == null && activity != null) {
                    f20878a = activity.getPackageName() + Consts.DOT + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(f20878a) || !this.i.containsKey(f20878a)) {
                    j3 = 0;
                } else {
                    long jLongValue = this.i.get(f20878a).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                    this.i.remove(f20878a);
                    j2 = jCurrentTimeMillis;
                    j3 = jLongValue;
                }
            }
            synchronized (k) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(b.u, f20878a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(b.w, j3);
                    jSONObject.put("type", 0);
                    j.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
