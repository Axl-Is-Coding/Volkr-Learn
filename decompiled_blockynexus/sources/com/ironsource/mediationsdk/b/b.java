package com.ironsource.mediationsdk.b;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: BaseEventsManager.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.b.b f14773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f14774b;

    b(f fVar, b.f.b.b bVar) {
        this.f14774b = fVar;
        this.f14773a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f14773a == null || !this.f14774b.p) {
            return;
        }
        this.f14773a.a("eventSessionId", this.f14774b.r);
        String strB = com.ironsource.mediationsdk.utils.j.b(this.f14774b.s);
        if (this.f14774b.i(this.f14773a)) {
            this.f14773a.a("connectionType", strB);
        }
        if (this.f14774b.a(strB, this.f14773a)) {
            b.f.b.b bVar = this.f14773a;
            bVar.a(this.f14774b.g(bVar));
        }
        this.f14774b.a(this.f14773a, "reason");
        this.f14774b.a(this.f14773a, "ext1");
        if (!this.f14774b.c().isEmpty()) {
            for (Map.Entry<String, String> entry : this.f14774b.c().entrySet()) {
                if (!this.f14773a.b().has(entry.getKey()) && entry.getKey() != "eventId" && entry.getKey() != "timestamp") {
                    this.f14773a.a(entry.getKey(), entry.getValue());
                }
            }
        }
        if (this.f14774b.k(this.f14773a)) {
            if (this.f14774b.j(this.f14773a) && !this.f14774b.h(this.f14773a)) {
                this.f14773a.a("sessionDepth", Integer.valueOf(this.f14774b.a(this.f14773a)));
            }
            if (this.f14774b.e(this.f14773a)) {
                this.f14774b.d(this.f14773a);
            } else if (!TextUtils.isEmpty(this.f14774b.a(this.f14773a.c())) && this.f14774b.f(this.f14773a)) {
                b.f.b.b bVar2 = this.f14773a;
                bVar2.a("placement", this.f14774b.a(bVar2.c()));
            }
            try {
                this.f14774b.K.b(IronSourceLogger.IronSourceTag.EVENT, ("{\"eventId\":" + this.f14773a.c() + ",\"timestamp\":" + this.f14773a.d() + "," + this.f14773a.a().substring(1)).replace(",", UMCustomLogInfoBuilder.LINE_SEP), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f14774b.o.add(this.f14773a);
            f.e(this.f14774b);
        }
        f fVar = this.f14774b;
        boolean zA = fVar.a(fVar.y) ? this.f14774b.a(this.f14773a.c(), this.f14774b.y) : this.f14774b.b(this.f14773a);
        if (!this.f14774b.l && zA) {
            this.f14774b.l = true;
        }
        if (this.f14774b.m != null) {
            if (this.f14774b.i()) {
                this.f14774b.h();
                return;
            }
            f fVar2 = this.f14774b;
            if (fVar2.a((ArrayList<b.f.b.b>) fVar2.o) || zA) {
                this.f14774b.g();
            }
        }
    }
}
