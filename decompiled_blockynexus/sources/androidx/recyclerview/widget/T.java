package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.fa;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class T implements fa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f1927a;

    T(RecyclerView.i iVar) {
        this.f1927a = iVar;
    }

    @Override // androidx.recyclerview.widget.fa.b
    public View a(int i) {
        return this.f1927a.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int b() {
        return this.f1927a.getWidth() - this.f1927a.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int a() {
        return this.f1927a.getPaddingLeft();
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int b(View view) {
        return this.f1927a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int a(View view) {
        return this.f1927a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }
}
