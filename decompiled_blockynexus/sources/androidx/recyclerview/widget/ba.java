package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SnapHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ba extends RecyclerView.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f1951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f1952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView.m f1953c = new Z(this);

    private void b() {
        this.f1951a.removeOnScrollListener(this.f1953c);
        this.f1951a.setOnFlingListener(null);
    }

    private void c() throws IllegalStateException {
        if (this.f1951a.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f1951a.addOnScrollListener(this.f1953c);
        this.f1951a.setOnFlingListener(this);
    }

    public abstract int a(RecyclerView.i iVar, int i, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public boolean a(int i, int i2) {
        RecyclerView.i layoutManager = this.f1951a.getLayoutManager();
        if (layoutManager == null || this.f1951a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1951a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && b(layoutManager, i, i2);
    }

    public abstract int[] a(RecyclerView.i iVar, View view);

    public abstract View c(RecyclerView.i iVar);

    public int[] b(int i, int i2) {
        this.f1952b.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f1952b.getFinalX(), this.f1952b.getFinalY()};
    }

    public void a(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f1951a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            b();
        }
        this.f1951a = recyclerView;
        if (this.f1951a != null) {
            c();
            this.f1952b = new Scroller(this.f1951a.getContext(), new DecelerateInterpolator());
            a();
        }
    }

    private boolean b(RecyclerView.i iVar, int i, int i2) {
        RecyclerView.s sVarA;
        int iA;
        if (!(iVar instanceof RecyclerView.s.b) || (sVarA = a(iVar)) == null || (iA = a(iVar, i, i2)) == -1) {
            return false;
        }
        sVarA.setTargetPosition(iA);
        iVar.startSmoothScroll(sVarA);
        return true;
    }

    @Deprecated
    protected E b(RecyclerView.i iVar) {
        if (iVar instanceof RecyclerView.s.b) {
            return new aa(this, this.f1951a.getContext());
        }
        return null;
    }

    void a() {
        RecyclerView.i layoutManager;
        View viewC;
        RecyclerView recyclerView = this.f1951a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewC = c(layoutManager)) == null) {
            return;
        }
        int[] iArrA = a(layoutManager, viewC);
        if (iArrA[0] == 0 && iArrA[1] == 0) {
            return;
        }
        this.f1951a.smoothScrollBy(iArrA[0], iArrA[1]);
    }

    protected RecyclerView.s a(RecyclerView.i iVar) {
        return b(iVar);
    }
}
