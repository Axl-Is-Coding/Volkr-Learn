package c.t.m.g;

import c.t.m.g.AbstractC0462s;
import c.t.m.g.AbstractC0462s.c;
import c.t.m.g.AbstractC0483z;

/* JADX INFO: renamed from: c.t.m.g.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class C0471v implements AbstractC0483z.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ AbstractC0462s f3426a;

    C0471v(AbstractC0462s abstractC0462s) {
        this.f3426a = abstractC0462s;
    }

    @Override // c.t.m.g.AbstractC0483z.a
    public final void a(boolean z, Object obj) {
        AbstractC0462s.d dVar = (AbstractC0462s.d) obj;
        dVar.f3387e = z;
        this.f3426a.new c(dVar).a(true);
    }
}
