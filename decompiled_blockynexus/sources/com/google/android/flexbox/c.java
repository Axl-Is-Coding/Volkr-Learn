package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FlexLine.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f13066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f13067f;
    int g;
    int h;
    int i;
    float j;
    float k;
    int l;
    int m;
    int o;
    int p;
    boolean q;
    boolean r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13062a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13063b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f13064c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f13065d = Integer.MIN_VALUE;
    List<Integer> n = new ArrayList();

    c() {
    }

    public int a() {
        return this.g;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.h - this.i;
    }

    void a(View view, int i, int i2, int i3, int i4) {
        b bVar = (b) view.getLayoutParams();
        this.f13062a = Math.min(this.f13062a, (view.getLeft() - bVar.w()) - i);
        this.f13063b = Math.min(this.f13063b, (view.getTop() - bVar.o()) - i2);
        this.f13064c = Math.max(this.f13064c, view.getRight() + bVar.x() + i3);
        this.f13065d = Math.max(this.f13065d, view.getBottom() + bVar.v() + i4);
    }
}
