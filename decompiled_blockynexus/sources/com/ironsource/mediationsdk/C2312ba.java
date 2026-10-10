package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.C2353h;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ba, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MediationInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
class C2312ba extends MediationInitializer.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediationInitializer f14792e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2312ba(MediationInitializer mediationInitializer) {
        super();
        this.f14792e = mediationInitializer;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ironsource.mediationsdk.model.s sVarC;
        try {
            U uE = U.e();
            Wa.b().a();
            if (this.f14792e.a(this.f14792e.s).b()) {
                this.f14792e.w = "userGenerated";
            } else {
                this.f14792e.s = uE.a((Context) this.f14792e.r);
                if (TextUtils.isEmpty(this.f14792e.s)) {
                    this.f14792e.s = com.ironsource.environment.b.l(this.f14792e.r);
                    if (TextUtils.isEmpty(this.f14792e.s)) {
                        this.f14792e.s = "";
                    } else {
                        this.f14792e.w = "UUID";
                    }
                } else {
                    this.f14792e.w = "GAID";
                }
                uE.a(this.f14792e.s, false);
            }
            C2353h.a().a("userIdType", this.f14792e.w);
            if (!TextUtils.isEmpty(this.f14792e.s)) {
                C2353h.a().a("userId", this.f14792e.s);
            }
            if (!TextUtils.isEmpty(this.f14792e.t)) {
                C2353h.a().a("appKey", this.f14792e.t);
            }
            this.f14792e.z = new Date().getTime();
            this.f14792e.u = uE.a(this.f14792e.r, this.f14792e.s, this.f14697c);
            if (this.f14792e.u != null) {
                this.f14792e.l.removeCallbacks(this);
                if (!this.f14792e.u.g()) {
                    if (this.f14792e.j) {
                        return;
                    }
                    this.f14792e.a(MediationInitializer.EInitStatus.INIT_FAILED);
                    this.f14792e.j = true;
                    Iterator it = this.f14792e.q.iterator();
                    while (it.hasNext()) {
                        ((MediationInitializer.b) it.next()).a("serverResponseIsNotValid");
                    }
                    return;
                }
                this.f14792e.a(MediationInitializer.EInitStatus.INITIATED);
                uE.a(new Date().getTime() - this.f14792e.z);
                if (this.f14792e.u.a().a().a()) {
                    com.ironsource.mediationsdk.d.b.a(this.f14792e.r);
                }
                List<IronSource.AD_UNIT> listB = this.f14792e.u.b();
                Iterator it2 = this.f14792e.q.iterator();
                while (it2.hasNext()) {
                    ((MediationInitializer.b) it2.next()).a(listB, this.f14792e.e());
                }
                if (this.f14792e.x == null || (sVarC = this.f14792e.u.a().a().c()) == null || TextUtils.isEmpty(sVarC.c())) {
                    return;
                }
                this.f14792e.x.a(sVarC.c());
                return;
            }
            if (this.f14792e.f14693e == 3) {
                this.f14792e.y = true;
                Iterator it3 = this.f14792e.q.iterator();
                while (it3.hasNext()) {
                    ((MediationInitializer.b) it3.next()).a();
                }
            }
            if (this.f14695a && this.f14792e.f14693e < this.f14792e.f14694f) {
                this.f14792e.i = true;
                this.f14792e.l.postDelayed(this, this.f14792e.f14692d * 1000);
                if (this.f14792e.f14693e < this.f14792e.g) {
                    this.f14792e.f14692d *= 2;
                }
            }
            if ((!this.f14695a || this.f14792e.f14693e == this.f14792e.h) && !this.f14792e.j) {
                this.f14792e.j = true;
                if (TextUtils.isEmpty(this.f14696b)) {
                    this.f14696b = "noServerResponse";
                }
                Iterator it4 = this.f14792e.q.iterator();
                while (it4.hasNext()) {
                    ((MediationInitializer.b) it4.next()).a(this.f14696b);
                }
                this.f14792e.a(MediationInitializer.EInitStatus.INIT_FAILED);
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
            }
            MediationInitializer.f(this.f14792e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
