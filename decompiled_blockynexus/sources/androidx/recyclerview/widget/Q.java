package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C0352b;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class Q implements C0352b.InterfaceC0031b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f1842a;

    Q(RecyclerView recyclerView) {
        this.f1842a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public int a() {
        return this.f1842a.getChildCount();
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public void addView(View view, int i) {
        this.f1842a.addView(view, i);
        this.f1842a.dispatchChildAttached(view);
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public void b() {
        int iA = a();
        for (int i = 0; i < iA; i++) {
            View viewA = a(i);
            this.f1842a.dispatchChildDetached(viewA);
            viewA.clearAnimation();
        }
        this.f1842a.removeAllViews();
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public int c(View view) {
        return this.f1842a.indexOfChild(view);
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public void d(View view) {
        RecyclerView.w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onLeftHiddenState(this.f1842a);
        }
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public View a(int i) {
        return this.f1842a.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public void c(int i) {
        View childAt = this.f1842a.getChildAt(i);
        if (childAt != null) {
            this.f1842a.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        this.f1842a.removeViewAt(i);
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        RecyclerView.w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + this.f1842a.exceptionLabel());
            }
            childViewHolderInt.clearTmpDetachFlag();
        }
        this.f1842a.attachViewToParent(view, i, layoutParams);
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public RecyclerView.w b(View view) {
        return RecyclerView.getChildViewHolderInt(view);
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public void b(int i) {
        RecyclerView.w childViewHolderInt;
        View viewA = a(i);
        if (viewA != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(viewA)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + this.f1842a.exceptionLabel());
            }
            childViewHolderInt.addFlags(256);
        }
        this.f1842a.detachViewFromParent(i);
    }

    @Override // androidx.recyclerview.widget.C0352b.InterfaceC0031b
    public void a(View view) {
        RecyclerView.w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(this.f1842a);
        }
    }
}
