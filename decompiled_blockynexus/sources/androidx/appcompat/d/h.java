package androidx.appcompat.d;

import android.view.View;
import androidx.core.view.G;
import androidx.core.view.H;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
/* JADX INFO: loaded from: classes.dex */
class h extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f389a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f390b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f391c;

    h(i iVar) {
        this.f391c = iVar;
    }

    void a() {
        this.f390b = 0;
        this.f389a = false;
        this.f391c.b();
    }

    @Override // androidx.core.view.G
    public void b(View view) {
        int i = this.f390b + 1;
        this.f390b = i;
        if (i == this.f391c.f392a.size()) {
            G g = this.f391c.f395d;
            if (g != null) {
                g.b(null);
            }
            a();
        }
    }

    @Override // androidx.core.view.H, androidx.core.view.G
    public void c(View view) {
        if (this.f389a) {
            return;
        }
        this.f389a = true;
        G g = this.f391c.f395d;
        if (g != null) {
            g.c(null);
        }
    }
}
