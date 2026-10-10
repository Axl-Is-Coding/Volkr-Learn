package b.e.a.a.a.b;

import android.content.Context;
import android.os.Handler;
import b.e.a.a.a.b.c;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class g implements b.e.a.a.a.a.c, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f2566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2567b = WheelView.DividerConfig.FILL;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b.e.a.a.a.a.e f2568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b.e.a.a.a.a.b f2569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b.e.a.a.a.a.d f2570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f2571f;

    public g(b.e.a.a.a.a.e eVar, b.e.a.a.a.a.b bVar) {
        this.f2568c = eVar;
        this.f2569d = bVar;
    }

    public static g a() {
        if (f2566a == null) {
            f2566a = new g(new b.e.a.a.a.a.e(), new b.e.a.a.a.a.b());
        }
        return f2566a;
    }

    private a e() {
        if (this.f2571f == null) {
            this.f2571f = a.a();
        }
        return this.f2571f;
    }

    @Override // b.e.a.a.a.a.c
    public void a(float f2) {
        this.f2567b = f2;
        Iterator<com.iab.omid.library.ironsrc.adsession.g> it = e().c().iterator();
        while (it.hasNext()) {
            it.next().j().a(f2);
        }
    }

    public void a(Context context) {
        this.f2570e = this.f2568c.a(new Handler(), context, this.f2569d.a(), this);
    }

    @Override // b.e.a.a.a.b.c.a
    public void a(boolean z) {
        if (z) {
            com.iab.omid.library.ironsrc.walking.e.h().a();
        } else {
            com.iab.omid.library.ironsrc.walking.e.h().c();
        }
    }

    public void b() {
        c.a().a(this);
        c.a().b();
        if (c.a().d()) {
            com.iab.omid.library.ironsrc.walking.e.h().a();
        }
        this.f2570e.a();
    }

    public void c() {
        com.iab.omid.library.ironsrc.walking.e.h().b();
        c.a().c();
        this.f2570e.b();
    }

    public float d() {
        return this.f2567b;
    }
}
