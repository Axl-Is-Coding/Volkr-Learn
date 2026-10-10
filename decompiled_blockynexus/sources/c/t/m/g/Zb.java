package c.t.m.g;

import android.text.TextUtils;
import c.t.m.g.C0412b;
import c.t.m.g.qc;

/* JADX INFO: loaded from: classes.dex */
public final class Zb implements Ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Zb f3071a = new Zb();

    private Zb() {
    }

    public static Zb a() {
        return f3071a;
    }

    @Override // c.t.m.g.Ia
    public final Sb a(InterfaceC0447mb interfaceC0447mb) {
        if (interfaceC0447mb == null) {
            throw new RuntimeException("execute...IHttpRequest is null");
        }
        if (!(interfaceC0447mb instanceof ac)) {
            throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
        }
        ac acVar = (ac) interfaceC0447mb;
        acVar.h = null;
        acVar.q = System.currentTimeMillis();
        boolean z = false;
        qc.a.a("app_http_use_proxy", 0, 1, 1);
        dc dcVar = new dc(acVar);
        acVar.i = dcVar;
        if (acVar.m <= 0) {
            acVar.a(dcVar.a());
        } else {
            C0412b.a.f3093a.f3092a.execute(new _b(dcVar, acVar));
            z = !acVar.c();
        }
        C0457q c0457qD = acVar.d();
        if (z) {
            acVar.p = true;
        }
        if (c0457qD == null) {
            c0457qD = new C0457q(-14, "force return timeout:" + acVar.m);
        }
        return new bc(c0457qD);
    }

    @Override // c.t.m.g.Ia
    public final InterfaceC0447mb a(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("url is empty");
        }
        return new ac(str, bArr);
    }
}
