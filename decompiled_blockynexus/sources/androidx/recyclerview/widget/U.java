package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.fa;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class U implements fa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f1928a;

    U(RecyclerView.i iVar) {
        this.f1928a = iVar;
    }

    @Override // androidx.recyclerview.widget.fa.b
    public View a(int i) {
        return this.f1928a.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int b() {
        return this.f1928a.getHeight() - this.f1928a.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int a() {
        return this.f1928a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int a(View view) {
        return this.f1928a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.fa.b
    public int b(View view) {
        return this.f1928a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }
}
