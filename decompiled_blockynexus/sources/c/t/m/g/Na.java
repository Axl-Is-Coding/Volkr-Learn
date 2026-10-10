package c.t.m.g;

import android.os.Bundle;
import c.t.m.g.Ya;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class Na implements Ya.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ Bundle f2965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ La f2966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Oa f2967c;

    Na(Oa oa, Bundle bundle, La la) {
        this.f2967c = oa;
        this.f2965a = bundle;
        this.f2966b = la;
    }

    @Override // c.t.m.g.Ya.b
    public final void a(String str) {
        this.f2965a.putString("msg_suc", str);
        La la = this.f2966b;
        if (la != null) {
            la.a(str);
        }
    }

    @Override // c.t.m.g.Ya.b
    public final void b(String str) {
        this.f2965a.putString("msg_fail", str);
        La la = this.f2966b;
        if (la != null) {
            la.b(str);
        }
    }
}
