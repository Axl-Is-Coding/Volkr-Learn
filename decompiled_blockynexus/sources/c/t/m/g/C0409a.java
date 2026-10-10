package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.C0446ma;
import c.t.m.g.qc;

/* JADX INFO: renamed from: c.t.m.g.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0409a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3080a;

    public static Ia a(C c2) {
        if (!f3080a) {
            b(c2);
        }
        return Zb.a();
    }

    private static synchronized void b(C c2) {
        if (f3080a) {
            return;
        }
        System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        if (c2 == null) {
            throw new C0415c("initParam null");
        }
        String packageName = c2.f2883a.getPackageName();
        String strA = C0446ma.a(c2.f2883a);
        int iA = c2.f2885c ? c2.f2884b : C0446ma.a(c2.f2883a, packageName);
        if (iA <= 0) {
            throw new C0415c("appid illegal:".concat(String.valueOf(iA)));
        }
        if (!c2.f2885c) {
            C0446ma.a aVarA = C0446ma.a(iA, c2.f2883a, packageName, "com.tencent.halley.common.platform.service.PlatformService");
            if (aVarA == null) {
                throw new C0415c("need set PlatformService in manifest for halley");
            }
            if (aVarA.f3309e != null && aVarA.f3306b != null) {
                fc.o = !aVarA.f3309e.equals(aVarA.f3306b);
            }
            if (aVarA.f3308d) {
                throw new C0415c("need set PlatformService exported to false");
            }
            if (!aVarA.f3307c) {
                throw new C0415c("need set PlatformService enabled to true");
            }
            C0446ma.a aVarA2 = C0446ma.a(iA, c2.f2883a, packageName, "com.tencent.halley.common.platform.service.ActivateService");
            if (aVarA2 != null) {
                if (!aVarA2.f3308d) {
                    throw new C0415c("need set ActivateService exported to true");
                }
                if (aVarA2.f3310f == null) {
                    throw new C0415c("need set security_version for ActivateService");
                }
                if (aVarA2.f3310f.getInt("security_version") <= 0) {
                    throw new C0415c("need set valid security_version for ActivateService");
                }
            }
        }
        fc.a(iA, c2, strA);
        ic.a();
        qc.a.f3362a = c2.f2888f;
        C0434ia c0434iaD = C0434ia.d();
        if (fc.g()) {
            c0434iaD.f3236c = C0431ha.e();
        }
        c0434iaD.f3236c.a(c0434iaD);
        c0434iaD.f3236c.d();
        f3080a = true;
        SystemClock.elapsedRealtime();
    }
}
