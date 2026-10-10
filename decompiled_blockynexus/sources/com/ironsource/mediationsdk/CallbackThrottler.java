package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2360o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CallbackThrottler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CallbackThrottler f14635a = new CallbackThrottler();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14639e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC2360o f14638d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Long> f14636b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Boolean> f14637c = new HashMap();

    private CallbackThrottler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeCallback(String str, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14636b.put(str, Long.valueOf(System.currentTimeMillis()));
        InterfaceC2360o interfaceC2360o = this.f14638d;
        if (interfaceC2360o != null) {
            interfaceC2360o.a(bVar);
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdLoadFailed(" + bVar.toString() + ")", 1);
        }
    }

    public boolean b() {
        boolean zA;
        synchronized (this) {
            zA = a("mediation");
        }
        return zA;
    }

    public static synchronized CallbackThrottler a() {
        return f14635a;
    }

    public void a(InterfaceC2360o interfaceC2360o) {
        this.f14638d = interfaceC2360o;
    }

    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        synchronized (this) {
            a("mediation", bVar);
        }
    }

    private boolean a(String str) {
        if (!TextUtils.isEmpty(str) && this.f14637c.containsKey(str)) {
            return this.f14637c.get(str).booleanValue();
        }
        return false;
    }

    private void a(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (a(str)) {
            return;
        }
        if (!this.f14636b.containsKey(str)) {
            invokeCallback(str, bVar);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f14636b.get(str).longValue();
        if (jCurrentTimeMillis > this.f14639e * 1000) {
            invokeCallback(str, bVar);
            return;
        }
        this.f14637c.put(str, true);
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC2339p(this, str, bVar), ((long) (this.f14639e * 1000)) - jCurrentTimeMillis);
    }

    public void a(int i) {
        this.f14639e = i;
    }
}
