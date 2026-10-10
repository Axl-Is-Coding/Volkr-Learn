package b.e.a.a.a;

import android.content.Context;
import b.e.a.a.a.b.c;
import b.e.a.a.a.b.d;
import b.e.a.a.a.b.g;
import b.e.a.a.a.d.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2549a;

    private void b(Context context) {
        e.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.2.22-Ironsrc";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        g.a().a(context);
        c.a().a(context);
        b.e.a.a.a.d.b.a(context);
        d.a().a(context);
    }

    void a(boolean z) {
        this.f2549a = z;
    }

    boolean b() {
        return this.f2549a;
    }
}
