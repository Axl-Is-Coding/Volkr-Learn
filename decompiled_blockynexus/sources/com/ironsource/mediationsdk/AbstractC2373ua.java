package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ua, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgSmash.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2373ua {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractC2311b f15008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.ironsource.mediationsdk.model.a f15009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected JSONObject f15011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f15012e;

    AbstractC2373ua(com.ironsource.mediationsdk.model.a aVar, AbstractC2311b abstractC2311b) {
        this.f15009b = aVar;
        this.f15008a = abstractC2311b;
        this.f15011d = aVar.b();
    }

    public void a(String str) {
        this.f15012e = AuctionDataUtils.b().d(str);
    }

    public void b(boolean z) {
        this.f15010c = z;
    }

    public String r() {
        return this.f15009b.e();
    }

    public int s() {
        return this.f15009b.c();
    }

    public boolean t() {
        return this.f15010c;
    }

    public int u() {
        return this.f15009b.d();
    }

    public String v() {
        return this.f15009b.f();
    }

    public int w() {
        return 1;
    }

    public Map<String, Object> x() {
        HashMap map = new HashMap();
        try {
            map.put("providerAdapterVersion", this.f15008a != null ? this.f15008a.getVersion() : "");
            map.put("providerSDKVersion", this.f15008a != null ? this.f15008a.getCoreSDKVersion() : "");
            map.put("spId", this.f15009b.h());
            map.put(com.umeng.analytics.pro.b.L, this.f15009b.a());
            map.put("instanceType", Integer.valueOf(y() ? 2 : 1));
            map.put("programmatic", Integer.valueOf(w()));
            if (!TextUtils.isEmpty(this.f15012e)) {
                map.put("dynamicDemandSource", this.f15012e);
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getProviderEventData " + r() + ")", e2);
        }
        return map;
    }

    public boolean y() {
        return this.f15009b.i();
    }
}
