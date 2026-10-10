package com.alibaba.sdk.android.feedback.xblink.f;

import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private XBHybridWebView f3864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f3865c = new HashMap();

    public j(Context context, XBHybridWebView xBHybridWebView) {
        this.f3863a = null;
        this.f3864b = null;
        this.f3863a = context;
        this.f3864b = xBHybridWebView;
    }

    public synchronized Object a(String str) {
        a aVarA;
        Object obj = this.f3865c.get(str);
        if (obj != null || (aVarA = k.a(str, this.f3863a, this.f3864b)) == null) {
            return obj;
        }
        this.f3865c.put(str, aVarA);
        return aVarA;
    }

    public synchronized void a() {
        for (Object obj : this.f3865c.values()) {
            if (obj instanceof a) {
                ((a) obj).a();
            }
        }
    }

    public synchronized void a(int i, int i2, Intent intent) {
        for (Object obj : this.f3865c.values()) {
            if (obj instanceof a) {
                ((a) obj).a(i, i2, intent);
            }
        }
    }

    public synchronized void a(String str, Object obj) {
        this.f3865c.put(str, obj);
    }

    public synchronized void b() {
        for (Object obj : this.f3865c.values()) {
            if (obj instanceof a) {
                ((a) obj).b();
            }
        }
    }

    public synchronized void c() {
        for (Object obj : this.f3865c.values()) {
            if (obj instanceof a) {
                ((a) obj).c();
            }
        }
    }
}
