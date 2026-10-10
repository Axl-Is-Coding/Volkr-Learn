package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes.dex */
class I extends J {
    I(RecyclerView.i iVar) {
        super(iVar, null);
    }

    @Override // androidx.recyclerview.widget.J
    public int a() {
        return this.f1815a.getHeight();
    }

    @Override // androidx.recyclerview.widget.J
    public int b() {
        return this.f1815a.getHeight() - this.f1815a.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.J
    public int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1815a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int d(View view) {
        return this.f1815a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int e(View view) {
        this.f1815a.getTransformedBoundingBox(view, true, this.f1817c);
        return this.f1817c.bottom;
    }

    @Override // androidx.recyclerview.widget.J
    public int f() {
        return this.f1815a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.J
    public int g() {
        return (this.f1815a.getHeight() - this.f1815a.getPaddingTop()) - this.f1815a.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.J
    public void a(int i) {
        this.f1815a.offsetChildrenVertical(i);
    }

    @Override // androidx.recyclerview.widget.J
    public int b(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1815a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int f(View view) {
        this.f1815a.getTransformedBoundingBox(view, true, this.f1817c);
        return this.f1817c.top;
    }

    @Override // androidx.recyclerview.widget.J
    public int a(View view) {
        return this.f1815a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.J
    public int c() {
        return this.f1815a.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.J
    public int d() {
        return this.f1815a.getHeightMode();
    }

    @Override // androidx.recyclerview.widget.J
    public int e() {
        return this.f1815a.getWidthMode();
    }
}
