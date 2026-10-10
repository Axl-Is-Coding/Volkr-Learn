package b.e.a.a.a.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2550a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.ironsrc.adsession.g> f2551b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<com.iab.omid.library.ironsrc.adsession.g> f2552c = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return f2550a;
    }

    public void a(com.iab.omid.library.ironsrc.adsession.g gVar) {
        this.f2551b.add(gVar);
    }

    public Collection<com.iab.omid.library.ironsrc.adsession.g> b() {
        return Collections.unmodifiableCollection(this.f2551b);
    }

    public void b(com.iab.omid.library.ironsrc.adsession.g gVar) {
        boolean zD = d();
        this.f2552c.add(gVar);
        if (zD) {
            return;
        }
        g.a().b();
    }

    public Collection<com.iab.omid.library.ironsrc.adsession.g> c() {
        return Collections.unmodifiableCollection(this.f2552c);
    }

    public void c(com.iab.omid.library.ironsrc.adsession.g gVar) {
        boolean zD = d();
        this.f2551b.remove(gVar);
        this.f2552c.remove(gVar);
        if (!zD || d()) {
            return;
        }
        g.a().c();
    }

    public boolean d() {
        return this.f2552c.size() > 0;
    }
}
