package com.alibaba.sdk.android.feedback.xblink.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f3843a = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");
    private static d g;
    private boolean k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3844b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3845c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3846d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3847e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3848f = 4;
    private boolean i = true;
    private final List j = new ArrayList();
    private ReentrantReadWriteLock l = new ReentrantReadWriteLock();
    private boolean m = false;
    private Handler h = new Handler(Looper.getMainLooper(), this);

    private d() {
    }

    public static synchronized d a() {
        if (g == null) {
            g = new d();
        }
        return g;
    }

    private f a(String str) {
        e eVar = null;
        if (str == null) {
            return null;
        }
        Matcher matcher = f3843a.matcher(str);
        if (matcher.matches()) {
            f fVar = new f(this, eVar);
            int iGroupCount = matcher.groupCount();
            if (iGroupCount >= 5) {
                fVar.f3857f = matcher.group(5);
            }
            if (iGroupCount >= 3) {
                fVar.f3855d = matcher.group(1);
                fVar.g = matcher.group(2);
                fVar.f3856e = matcher.group(3);
                return fVar;
            }
        }
        return null;
    }

    private void a(int i, f fVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.obj = fVar;
        this.h.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, String str) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVJsBridge", String.format("callMethod-obj:%s method:%s param:%s sid:%s", fVar.f3855d, fVar.f3856e, fVar.f3857f, fVar.g));
        }
        if (!this.i || fVar.f3852a == null) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "jsbridge is closed.");
            a(4, fVar);
            return;
        }
        if (!this.k) {
            try {
                this.l.readLock().lock();
                if (!this.j.isEmpty()) {
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        if (!((g) it.next()).a(str, fVar.f3855d, fVar.f3856e, fVar.f3857f)) {
                            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "preprocessor call fail, callMethod cancel.");
                            a(3, fVar);
                            return;
                        }
                    }
                }
            } finally {
                this.l.readLock().unlock();
            }
        }
        Map mapA = k.a(fVar.f3855d, fVar.f3856e);
        if (mapA != null) {
            if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                com.alibaba.sdk.android.feedback.xblink.i.g.c("WVJsBridge", "call method through alias name. newObject: " + ((String) mapA.get("name")) + " newMethod: " + ((String) mapA.get(FirebaseAnalytics.Param.METHOD)));
            }
            fVar.f3855d = (String) mapA.get("name");
            fVar.f3856e = (String) mapA.get(FirebaseAnalytics.Param.METHOD);
        }
        Object jsObject = fVar.f3852a.getJsObject(fVar.f3855d);
        if (jsObject == null) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "callMethod: Plugin " + fVar.f3855d + " didn't found, you should call WVPluginManager.registerPlugin first.");
        } else {
            if (jsObject instanceof a) {
                com.alibaba.sdk.android.feedback.xblink.i.g.c("WVJsBridge", "call new method execute.");
                fVar.f3853b = jsObject;
                a(0, fVar);
                return;
            }
            try {
                if (fVar.f3856e != null) {
                    Method method = jsObject.getClass().getMethod(fVar.f3856e, Object.class, String.class);
                    if (method.isAnnotationPresent(n.class)) {
                        fVar.f3853b = jsObject;
                        fVar.f3854c = method;
                        a(1, fVar);
                        return;
                    } else {
                        com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "callMethod: Method " + fVar.f3856e + " didn't has @WindVaneInterface annotation, obj=" + fVar.f3855d);
                    }
                }
            } catch (NoSuchMethodException unused) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WVJsBridge", "callMethod: Method " + fVar.f3856e + " didn't found. It must has two parameter, Object.class and String.class, obj=" + fVar.f3855d);
            }
        }
        a(2, fVar);
    }

    public void a(XBHybridWebView xBHybridWebView, String str) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVJsBridge", "callMethod: url=" + str);
        }
        if (!this.m) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "jsbridge is not init.");
            return;
        }
        f fVarA = a(str);
        if (fVarA != null) {
            fVarA.f3852a = xBHybridWebView;
            com.alibaba.sdk.android.feedback.xblink.h.a.a().a(new e(this, fVarA, xBHybridWebView.getUrl()));
        } else {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "url format error and call canceled. url=" + str);
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public synchronized void b() {
        if (!this.m) {
            k.a();
            this.m = true;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        m mVar;
        String str2;
        f fVar = (f) message.obj;
        if (fVar == null) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("WVJsBridge", "CallMethodContext is null, and do nothing.");
            return false;
        }
        b bVar = new b(fVar.f3852a, fVar.g);
        int i = message.what;
        str = "{}";
        if (i == 0) {
            Object obj = fVar.f3853b;
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "WVApiPlugin execute . method: " + fVar.f3856e + ";" + fVar.f3855d);
            if (!((a) obj).a(fVar.f3856e, TextUtils.isEmpty(fVar.f3857f) ? "{}" : fVar.f3857f, bVar)) {
                if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.e("WVJsBridge", "WVApiPlugin execute failed. method: " + fVar.f3856e);
                }
                a(2, fVar);
            }
            return true;
        }
        if (i != 1) {
            if (i == 2) {
                mVar = new m();
                str2 = "HY_NO_HANDLER";
            } else if (i == 3) {
                mVar = new m();
                str2 = "HY_NO_PERMISSION";
            } else {
                if (i != 4) {
                    return false;
                }
                mVar = new m();
                str2 = "HY_CLOSED";
            }
            mVar.a(str2);
            bVar.b(mVar);
            return true;
        }
        Object obj2 = fVar.f3853b;
        try {
            Method method = fVar.f3854c;
            Object[] objArr = new Object[2];
            objArr[0] = bVar;
            if (!TextUtils.isEmpty(fVar.f3857f)) {
                str = fVar.f3857f;
            }
            objArr[1] = str;
            method.invoke(obj2, objArr);
        } catch (Exception e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("WVJsBridge", "call method " + fVar.f3854c + " exception. " + e2.getMessage());
        }
        return true;
    }
}
