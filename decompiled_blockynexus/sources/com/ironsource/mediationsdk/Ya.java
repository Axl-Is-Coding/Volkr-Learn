package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: WaterfallLifeCycleHolder.java */
/* JADX INFO: loaded from: classes2.dex */
public class Ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f14747a = "WaterfallLifeCycleHolder";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LWSProgRvSmash f14751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f14752f;
    private int g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ConcurrentHashMap<String, CopyOnWriteArrayList<LWSProgRvSmash>> f14748b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14749c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14750d = "";
    private Timer h = new Timer();

    public Ya(List<String> list, int i) {
        this.f14752f = list;
        this.g = i;
    }

    public boolean b(LWSProgRvSmash lWSProgRvSmash) {
        boolean z = false;
        if (lWSProgRvSmash == null || (this.f14751e != null && ((lWSProgRvSmash.B() == LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK && this.f14751e.r().equals(lWSProgRvSmash.r())) || ((lWSProgRvSmash.B() == LoadWhileShowSupportState.NONE || this.f14752f.contains(lWSProgRvSmash.v())) && this.f14751e.v().equals(lWSProgRvSmash.v()))))) {
            z = true;
        }
        if (z && lWSProgRvSmash != null) {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, f14747a + " " + lWSProgRvSmash.r() + " does not support load while show and will not be added to the auction request", 1);
        }
        return !z;
    }

    public CopyOnWriteArrayList<LWSProgRvSmash> c() {
        CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList = this.f14748b.get(this.f14749c);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public String d() {
        return this.f14749c;
    }

    public int e() {
        return this.f14748b.size();
    }

    public LWSProgRvSmash f() {
        return this.f14751e;
    }

    public void a(LWSProgRvSmash lWSProgRvSmash) {
        this.f14751e = lWSProgRvSmash;
    }

    public void a(CopyOnWriteArrayList<LWSProgRvSmash> copyOnWriteArrayList, String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, f14747a + " updating new  waterfall with id " + str, 1);
        this.f14748b.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.f14750d)) {
            this.h.schedule(new Xa(this, this.f14750d), this.g);
        }
        this.f14750d = this.f14749c;
        this.f14749c = str;
    }

    public boolean b() {
        return this.f14748b.size() > 5;
    }
}
