package com.google.android.material.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.google.android.material.l.q;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends q.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f13552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Matrix f13553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ q f13554d;

    p(q qVar, List list, Matrix matrix) {
        this.f13554d = qVar;
        this.f13552b = list;
        this.f13553c = matrix;
    }

    @Override // com.google.android.material.l.q.f
    public void a(Matrix matrix, com.google.android.material.k.a aVar, int i, Canvas canvas) {
        Iterator it = this.f13552b.iterator();
        while (it.hasNext()) {
            ((q.f) it.next()).a(this.f13553c, aVar, i, canvas);
        }
    }
}
