package c.t.m.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class I extends F implements InterfaceC0428ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    C0427g f2924a = new C0427g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Object> f2925b = new ArrayList();

    public I() {
        fc.j().post(new J(this));
    }

    @Override // c.t.m.g.InterfaceC0428ga
    public final String a(String str, int i, String str2, String str3, String str4, String str5) {
        return this.f2924a.a(str, i, str2, str3, str4, str5);
    }

    final synchronized void a() {
        Iterator<Object> it = this.f2925b.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // c.t.m.g.F, c.t.m.g.L
    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !N.a().b().equals(str2)) {
            N.a().a(str2, true);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f2924a) {
            this.f2924a.b();
            this.f2924a.a(str);
        }
        C0446ma.a("settings_in_client", this.f2924a.a());
        a();
    }

    public final String b() {
        return "settings";
    }

    @Override // c.t.m.g.F, c.t.m.g.L
    public final void c() {
        C0434ia.d().b();
    }
}
