package com.iab.omid.library.ironsrc.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import b.e.a.a.a.c.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements a.InterfaceC0040a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f14573a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f14574b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f14575c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Runnable f14576d = new com.iab.omid.library.ironsrc.walking.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Runnable f14577e = new d();
    private int g;
    private long k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<b> f14578f = new ArrayList();
    private f i = new f();
    private b.e.a.a.a.c.b h = new b.e.a.a.a.c.b();
    private g j = new g(new com.iab.omid.library.ironsrc.walking.a.c());

    public interface a extends b {
        void a(int i, long j);
    }

    public interface b {
        void b(int i, long j);
    }

    e() {
    }

    private void a(long j) {
        if (this.f14578f.size() > 0) {
            for (b bVar : this.f14578f) {
                bVar.b(this.g, TimeUnit.NANOSECONDS.toMillis(j));
                if (bVar instanceof a) {
                    ((a) bVar).a(this.g, j);
                }
            }
        }
    }

    private void a(View view, b.e.a.a.a.c.a aVar, JSONObject jSONObject, c cVar) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        b.e.a.a.a.c.a aVarB = this.h.b();
        String strA = this.i.a(str);
        if (strA != null) {
            JSONObject jSONObjectA = aVarB.a(view);
            b.e.a.a.a.d.b.a(jSONObjectA, str);
            b.e.a.a.a.d.b.b(jSONObjectA, strA);
            b.e.a.a.a.d.b.a(jSONObject, jSONObjectA);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        String strA = this.i.a(view);
        if (strA == null) {
            return false;
        }
        b.e.a.a.a.d.b.a(jSONObject, strA);
        this.i.e();
        return true;
    }

    private void b(View view, JSONObject jSONObject) {
        ArrayList<String> arrayListB = this.i.b(view);
        if (arrayListB != null) {
            b.e.a.a.a.d.b.a(jSONObject, arrayListB);
        }
    }

    public static e h() {
        return f14573a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        j();
        d();
        k();
    }

    private void j() {
        this.g = 0;
        this.k = b.e.a.a.a.d.d.a();
    }

    private void k() {
        a(b.e.a.a.a.d.d.a() - this.k);
    }

    private void l() {
        if (f14575c == null) {
            f14575c = new Handler(Looper.getMainLooper());
            f14575c.post(f14576d);
            f14575c.postDelayed(f14577e, 200L);
        }
    }

    private void m() {
        Handler handler = f14575c;
        if (handler != null) {
            handler.removeCallbacks(f14577e);
            f14575c = null;
        }
    }

    public void a() {
        l();
    }

    @Override // b.e.a.a.a.c.a.InterfaceC0040a
    public void a(View view, b.e.a.a.a.c.a aVar, JSONObject jSONObject) {
        c cVarC;
        if (b.e.a.a.a.d.f.d(view) && (cVarC = this.i.c(view)) != c.UNDERLYING_VIEW) {
            JSONObject jSONObjectA = aVar.a(view);
            b.e.a.a.a.d.b.a(jSONObject, jSONObjectA);
            if (!a(view, jSONObjectA)) {
                b(view, jSONObjectA);
                a(view, aVar, jSONObjectA, cVarC);
            }
            this.g++;
        }
    }

    public void b() {
        c();
        this.f14578f.clear();
        f14574b.post(new com.iab.omid.library.ironsrc.walking.a(this));
    }

    public void c() {
        m();
    }

    void d() {
        this.i.c();
        long jA = b.e.a.a.a.d.d.a();
        b.e.a.a.a.c.a aVarA = this.h.a();
        if (this.i.b().size() > 0) {
            for (String str : this.i.b()) {
                JSONObject jSONObjectA = aVarA.a(null);
                a(str, this.i.b(str), jSONObjectA);
                b.e.a.a.a.d.b.a(jSONObjectA);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(str);
                this.j.b(jSONObjectA, hashSet, jA);
            }
        }
        if (this.i.a().size() > 0) {
            JSONObject jSONObjectA2 = aVarA.a(null);
            a(null, aVarA, jSONObjectA2, c.PARENT_VIEW);
            b.e.a.a.a.d.b.a(jSONObjectA2);
            this.j.a(jSONObjectA2, this.i.a(), jA);
        } else {
            this.j.a();
        }
        this.i.d();
    }
}
