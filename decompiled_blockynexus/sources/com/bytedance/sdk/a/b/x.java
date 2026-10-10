package com.bytedance.sdk.a.b;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: RealCall.java */
/* JADX INFO: loaded from: classes.dex */
final class x implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final v f5331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.bytedance.sdk.a.b.a.c.j f5332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final y f5333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f5334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p f5335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5336f;

    /* JADX INFO: compiled from: RealCall.java */
    final class a extends com.bytedance.sdk.a.b.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f5337a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f f5338c;

        String a() {
            return this.f5337a.f5333c.a().f();
        }

        @Override // com.bytedance.sdk.a.b.a.b
        protected void b() {
            IOException e2;
            aa aaVarF;
            boolean z = true;
            try {
                try {
                    aaVarF = this.f5337a.f();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f5337a.f5332b.a()) {
                        this.f5338c.a(this.f5337a, new IOException("Canceled"));
                    } else {
                        this.f5338c.a(this.f5337a, aaVarF);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (z) {
                        com.bytedance.sdk.a.b.a.g.e.b().a(4, "Callback failure for " + this.f5337a.d(), e2);
                    } else {
                        this.f5337a.f5335e.a(this.f5337a, e2);
                        this.f5338c.a(this.f5337a, e2);
                    }
                }
            } finally {
                this.f5337a.f5331a.s().a(this);
            }
        }
    }

    private x(v vVar, y yVar, boolean z) {
        this.f5331a = vVar;
        this.f5333c = yVar;
        this.f5334d = z;
        this.f5332b = new com.bytedance.sdk.a.b.a.c.j(vVar, z);
    }

    private void g() {
        this.f5332b.a(com.bytedance.sdk.a.b.a.g.e.b().a("response.body().close()"));
    }

    public boolean b() {
        return this.f5332b.a();
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public x clone() {
        return a(this.f5331a, this.f5333c, this.f5334d);
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : "");
        sb.append(this.f5334d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(e());
        return sb.toString();
    }

    String e() {
        return this.f5333c.a().m();
    }

    aa f() throws IOException {
        ArrayList arrayList = new ArrayList(this.f5331a.v());
        arrayList.add(this.f5332b);
        arrayList.add(new com.bytedance.sdk.a.b.a.c.a(this.f5331a.f()));
        arrayList.add(new com.bytedance.sdk.a.b.a.a.a(this.f5331a.g()));
        arrayList.add(new com.bytedance.sdk.a.b.a.b.a(this.f5331a));
        if (!this.f5334d) {
            arrayList.addAll(this.f5331a.w());
        }
        arrayList.add(new com.bytedance.sdk.a.b.a.c.b(this.f5334d));
        return new com.bytedance.sdk.a.b.a.c.g(arrayList, null, null, null, 0, this.f5333c, this, this.f5335e, this.f5331a.a(), this.f5331a.b(), this.f5331a.c()).a(this.f5333c);
    }

    static x a(v vVar, y yVar, boolean z) {
        x xVar = new x(vVar, yVar, z);
        xVar.f5335e = vVar.x().a(xVar);
        return xVar;
    }

    @Override // com.bytedance.sdk.a.b.e
    public aa a() throws IOException {
        synchronized (this) {
            if (!this.f5336f) {
                this.f5336f = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        g();
        this.f5335e.a(this);
        try {
            try {
                this.f5331a.s().a(this);
                aa aaVarF = f();
                if (aaVarF != null) {
                    return aaVarF;
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                this.f5335e.a(this, e2);
                throw e2;
            }
        } finally {
            this.f5331a.s().b(this);
        }
    }
}
