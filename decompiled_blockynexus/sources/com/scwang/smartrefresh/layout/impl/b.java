package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.a.k;
import com.scwang.smartrefresh.layout.c.c;

/* JADX INFO: compiled from: ScrollBoundaryDeciderAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f19178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f19179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19180c = true;

    @Override // com.scwang.smartrefresh.layout.a.k
    public boolean a(View view) {
        k kVar = this.f19179b;
        return kVar != null ? kVar.a(view) : c.a(view, this.f19178a);
    }

    @Override // com.scwang.smartrefresh.layout.a.k
    public boolean b(View view) {
        k kVar = this.f19179b;
        return kVar != null ? kVar.b(view) : c.a(view, this.f19178a, this.f19180c);
    }
}
