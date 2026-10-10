package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2350e;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractAdUnitManager.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC2309a implements InterfaceC2350e {
    int h;
    private AbstractSmash j;
    private AbstractSmash k;
    String l;
    String m;
    Boolean p;
    boolean q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f14754a = "reason";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f14755b = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f14756c = "placement";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f14757d = "rewardName";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f14758e = "rewardAmount";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f14759f = "providerPriority";
    boolean o = false;
    boolean r = true;
    final CopyOnWriteArrayList<AbstractSmash> i = new CopyOnWriteArrayList<>();
    com.ironsource.mediationsdk.logger.c n = com.ironsource.mediationsdk.logger.c.c();
    com.ironsource.mediationsdk.utils.f g = null;

    AbstractC2309a() {
    }

    void a(int i) {
        this.h = i;
    }

    void b(AbstractSmash abstractSmash) {
        this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, abstractSmash.r() + " is set as backfill", 0);
        this.j = abstractSmash;
    }

    void c(AbstractSmash abstractSmash) {
        try {
            String strH = U.e().h();
            if (!TextUtils.isEmpty(strH)) {
                abstractSmash.a(strH);
            }
            String strC = com.ironsource.mediationsdk.a.a.a().c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            abstractSmash.b(strC, com.ironsource.mediationsdk.a.a.a().b());
        } catch (Exception e2) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, ":setCustomParams():" + e2.toString(), 3);
        }
    }

    void d(AbstractSmash abstractSmash) {
        this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, abstractSmash.r() + " is set as premium", 0);
        this.k = abstractSmash;
    }

    AbstractSmash e() {
        return this.j;
    }

    AbstractSmash f() {
        return this.k;
    }

    void a(AbstractSmash abstractSmash) {
        this.i.add(abstractSmash);
        com.ironsource.mediationsdk.utils.f fVar = this.g;
        if (fVar != null) {
            fVar.a(abstractSmash);
        }
    }

    synchronized void d() {
        this.r = false;
    }

    synchronized boolean c() {
        return this.r;
    }
}
