package com.google.android.material.l;

import android.graphics.Matrix;
import com.google.android.material.l.o;

/* JADX INFO: compiled from: MaterialShapeDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements o.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f13512a;

    g(i iVar) {
        this.f13512a = iVar;
    }

    @Override // com.google.android.material.l.o.a
    public void a(q qVar, Matrix matrix, int i) {
        this.f13512a.f13517c[i] = qVar.a(matrix);
    }

    @Override // com.google.android.material.l.o.a
    public void b(q qVar, Matrix matrix, int i) {
        this.f13512a.f13518d[i] = qVar.a(matrix);
    }
}
