package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DemandOnlySmash {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractC2311b f14647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.ironsource.mediationsdk.model.a f14648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected JSONObject f14649c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f14652f;
    protected String i;
    private final Object j = new Object();
    private final Object k = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SMASH_STATE f14650d = SMASH_STATE.NOT_LOADED;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Timer f14651e = null;
    protected String g = "";
    protected List<String> h = new ArrayList();

    protected enum SMASH_STATE {
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public DemandOnlySmash(com.ironsource.mediationsdk.model.a aVar, AbstractC2311b abstractC2311b) {
        this.f14648b = aVar;
        this.f14647a = abstractC2311b;
        this.f14649c = aVar.b();
    }

    boolean a(SMASH_STATE smash_state, SMASH_STATE smash_state2) {
        synchronized (this.j) {
            if (this.f14650d != smash_state) {
                return false;
            }
            a(smash_state2);
            return true;
        }
    }

    public String j() {
        return this.f14648b.e();
    }

    public int o() {
        return this.f14648b.c();
    }

    public Map<String, Object> p() {
        HashMap map = new HashMap();
        try {
            map.put("providerAdapterVersion", this.f14647a != null ? this.f14647a.getVersion() : "");
            map.put("providerSDKVersion", this.f14647a != null ? this.f14647a.getCoreSDKVersion() : "");
            map.put("spId", this.f14648b.h());
            map.put(com.umeng.analytics.pro.b.L, this.f14648b.a());
            map.put("isDemandOnly", 1);
            if (s()) {
                map.put("programmatic", 1);
                map.put("instanceType", 2);
                if (!TextUtils.isEmpty(this.g)) {
                    map.put("auctionId", this.g);
                }
            } else {
                map.put("programmatic", 0);
                map.put("instanceType", 1);
            }
            if (!TextUtils.isEmpty(this.i)) {
                map.put("dynamicDemandSource", this.i);
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getProviderEventData " + j() + ")", e2);
        }
        return map;
    }

    String q() {
        SMASH_STATE smash_state = this.f14650d;
        return smash_state == null ? "null" : smash_state.toString();
    }

    public String r() {
        return this.f14648b.h();
    }

    public boolean s() {
        return this.f14648b.i();
    }

    void t() {
        synchronized (this.k) {
            if (this.f14651e != null) {
                this.f14651e.cancel();
                this.f14651e = null;
            }
        }
    }

    SMASH_STATE a(SMASH_STATE[] smash_stateArr, SMASH_STATE smash_state) {
        SMASH_STATE smash_state2;
        synchronized (this.j) {
            smash_state2 = this.f14650d;
            if (Arrays.asList(smash_stateArr).contains(this.f14650d)) {
                a(smash_state);
            }
        }
        return smash_state2;
    }

    void a(SMASH_STATE smash_state) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlySmash " + this.f14648b.e() + ": current state=" + this.f14650d + ", new state=" + smash_state, 0);
        synchronized (this.j) {
            this.f14650d = smash_state;
        }
    }

    void a(TimerTask timerTask) {
        synchronized (this.k) {
            t();
            this.f14651e = new Timer();
            this.f14651e.schedule(timerTask, this.f14652f * 1000);
        }
    }

    public void a(String str) {
        this.i = AuctionDataUtils.b().d(str);
    }
}
