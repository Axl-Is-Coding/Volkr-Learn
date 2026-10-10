package c.t.m.g;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class dc extends cc {
    public dc(ac acVar) {
        super(acVar);
    }

    @Override // c.t.m.g.cc
    public final C0457q a() {
        C0434ia.d().a(1);
        return super.a();
    }

    @Override // c.t.m.g.cc
    protected final C0457q a(int i) {
        String str = this.f3105c;
        ac acVar = this.f3103a;
        Map<String, String> map = acVar.f3088c;
        byte[] bArr = acVar.f3087b;
        String str2 = acVar.g;
        boolean z = acVar.n;
        C0434ia.d().f();
        C0448n c0448n = new C0448n(str, map, bArr, i, str2, z, null);
        c0448n.f3283a = this.f3104b;
        c0448n.o = this.h;
        c0448n.A = "app";
        this.i = c0448n;
        AbstractC0442l abstractC0442l = this.i;
        abstractC0442l.l = this.f3103a.q;
        return abstractC0442l.a();
    }
}
