package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final RecyclerView.i f1815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Rect f1817c;

    /* synthetic */ J(RecyclerView.i iVar, H h) {
        this(iVar);
    }

    public static J a(RecyclerView.i iVar, int i) {
        if (i == 0) {
            return a(iVar);
        }
        if (i == 1) {
            return b(iVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static J b(RecyclerView.i iVar) {
        return new I(iVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f1816b) {
            return 0;
        }
        return g() - this.f1816b;
    }

    public void i() {
        this.f1816b = g();
    }

    private J(RecyclerView.i iVar) {
        this.f1816b = Integer.MIN_VALUE;
        this.f1817c = new Rect();
        this.f1815a = iVar;
    }

    public static J a(RecyclerView.i iVar) {
        return new H(iVar);
    }
}
