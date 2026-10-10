package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
class H extends J {
    H(RecyclerView.i iVar) {
        super(iVar, null);
    }

    @Override // androidx.recyclerview.widget.J
    public int a() {
        return this.f1815a.getWidth();
    }

    @Override // androidx.recyclerview.widget.J
    public int b() {
        return this.f1815a.getWidth() - this.f1815a.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.J
    public int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1815a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int d(View view) {
        return this.f1815a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int e(View view) {
        this.f1815a.getTransformedBoundingBox(view, true, this.f1817c);
        return this.f1817c.right;
    }

    @Override // androidx.recyclerview.widget.J
    public int f() {
        return this.f1815a.getPaddingLeft();
    }

    @Override // androidx.recyclerview.widget.J
    public int g() {
        return (this.f1815a.getWidth() - this.f1815a.getPaddingLeft()) - this.f1815a.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.J
    public void a(int i) {
        this.f1815a.offsetChildrenHorizontal(i);
    }

    @Override // androidx.recyclerview.widget.J
    public int b(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1815a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int f(View view) {
        this.f1815a.getTransformedBoundingBox(view, true, this.f1817c);
        return this.f1817c.left;
    }

    @Override // androidx.recyclerview.widget.J
    public int a(View view) {
        return this.f1815a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int c() {
        return this.f1815a.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.J
    public int d() {
        return this.f1815a.getWidthMode();
    }

    @Override // androidx.recyclerview.widget.J
    public int e() {
        return this.f1815a.getHeightMode();
    }
}
