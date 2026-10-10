package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: NestedScrollingParentHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1268b;

    public q(ViewGroup viewGroup) {
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f1268b = i;
        } else {
            this.f1267a = i;
        }
    }

    public int a() {
        return this.f1267a | this.f1268b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i) {
        if (i == 1) {
            this.f1268b = 0;
        } else {
            this.f1267a = 0;
        }
    }
}
