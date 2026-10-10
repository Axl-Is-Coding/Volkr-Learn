package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.C0294g;

/* JADX INFO: renamed from: androidx.appcompat.widget.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
class C0295h extends I {
    final /* synthetic */ C0294g j;
    final /* synthetic */ C0294g.d k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0295h(C0294g.d dVar, View view, C0294g c0294g) {
        super(view);
        this.k = dVar;
        this.j = c0294g;
    }

    @Override // androidx.appcompat.widget.I
    public androidx.appcompat.view.menu.m a() {
        C0294g.e eVar = C0294g.this.y;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    @Override // androidx.appcompat.widget.I
    public boolean b() {
        C0294g.this.j();
        return true;
    }

    @Override // androidx.appcompat.widget.I
    public boolean c() {
        C0294g c0294g = C0294g.this;
        if (c0294g.A != null) {
            return false;
        }
        c0294g.e();
        return true;
    }
}
