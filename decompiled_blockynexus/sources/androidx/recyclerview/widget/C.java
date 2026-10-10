package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: LayoutState.java */
/* JADX INFO: loaded from: classes.dex */
class C {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1784e;
    boolean h;
    boolean i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1780a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1785f = 0;
    int g = 0;

    C() {
    }

    boolean a(RecyclerView.t tVar) {
        int i = this.f1782c;
        return i >= 0 && i < tVar.a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1781b + ", mCurrentPosition=" + this.f1782c + ", mItemDirection=" + this.f1783d + ", mLayoutDirection=" + this.f1784e + ", mStartLine=" + this.f1785f + ", mEndLine=" + this.g + '}';
    }

    View a(RecyclerView.o oVar) {
        View viewD = oVar.d(this.f1782c);
        this.f1782c += this.f1783d;
        return viewD;
    }
}
