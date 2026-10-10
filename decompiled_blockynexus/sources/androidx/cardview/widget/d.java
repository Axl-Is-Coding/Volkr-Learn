package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: compiled from: CardViewApi21Impl.java */
/* JADX INFO: loaded from: classes.dex */
class d implements h {
    d() {
    }

    private i j(g gVar) {
        return (i) gVar.b();
    }

    @Override // androidx.cardview.widget.h
    public void a() {
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        gVar.a(new i(colorStateList, f2));
        View viewD = gVar.d();
        viewD.setClipToOutline(true);
        viewD.setElevation(f3);
        c(gVar, f4);
    }

    @Override // androidx.cardview.widget.h
    public float b(g gVar) {
        return j(gVar).b();
    }

    @Override // androidx.cardview.widget.h
    public void c(g gVar, float f2) {
        j(gVar).a(f2, gVar.a(), gVar.c());
        h(gVar);
    }

    @Override // androidx.cardview.widget.h
    public float d(g gVar) {
        return a(gVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.h
    public void e(g gVar) {
        c(gVar, b(gVar));
    }

    @Override // androidx.cardview.widget.h
    public float f(g gVar) {
        return gVar.d().getElevation();
    }

    @Override // androidx.cardview.widget.h
    public void g(g gVar) {
        c(gVar, b(gVar));
    }

    @Override // androidx.cardview.widget.h
    public void h(g gVar) {
        if (!gVar.a()) {
            gVar.a(0, 0, 0, 0);
            return;
        }
        float fB = b(gVar);
        float fA = a(gVar);
        int iCeil = (int) Math.ceil(j.a(fB, fA, gVar.c()));
        int iCeil2 = (int) Math.ceil(j.b(fB, fA, gVar.c()));
        gVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // androidx.cardview.widget.h
    public float i(g gVar) {
        return a(gVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.h
    public void b(g gVar, float f2) {
        gVar.d().setElevation(f2);
    }

    @Override // androidx.cardview.widget.h
    public ColorStateList c(g gVar) {
        return j(gVar).a();
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, float f2) {
        j(gVar).a(f2);
    }

    @Override // androidx.cardview.widget.h
    public float a(g gVar) {
        return j(gVar).c();
    }

    @Override // androidx.cardview.widget.h
    public void a(g gVar, ColorStateList colorStateList) {
        j(gVar).a(colorStateList);
    }
}
