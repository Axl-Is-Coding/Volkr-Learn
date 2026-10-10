package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0372w implements RecyclerView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ItemTouchHelper f2042a;

    C0372w(ItemTouchHelper itemTouchHelper) {
        this.f2042a = itemTouchHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public int a(int i, int i2) {
        ItemTouchHelper itemTouchHelper = this.f2042a;
        View view = itemTouchHelper.x;
        if (view == null) {
            return i2;
        }
        int iIndexOfChild = itemTouchHelper.y;
        if (iIndexOfChild == -1) {
            iIndexOfChild = itemTouchHelper.r.indexOfChild(view);
            this.f2042a.y = iIndexOfChild;
        }
        return i2 == i + (-1) ? iIndexOfChild : i2 < iIndexOfChild ? i2 : i2 + 1;
    }
}
