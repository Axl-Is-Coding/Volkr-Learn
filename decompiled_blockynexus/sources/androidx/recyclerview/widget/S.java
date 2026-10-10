package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0351a;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: RecyclerView.java */
/* JADX INFO: loaded from: classes.dex */
class S implements C0351a.InterfaceC0030a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f1894a;

    S(RecyclerView recyclerView) {
        this.f1894a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public RecyclerView.w a(int i) {
        RecyclerView.w wVarFindViewHolderForPosition = this.f1894a.findViewHolderForPosition(i, true);
        if (wVarFindViewHolderForPosition == null || this.f1894a.mChildHelper.c(wVarFindViewHolderForPosition.itemView)) {
            return null;
        }
        return wVarFindViewHolderForPosition;
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public void b(int i, int i2) {
        this.f1894a.offsetPositionRecordsForRemove(i, i2, false);
        this.f1894a.mItemsAddedOrRemoved = true;
    }

    void c(C0351a.b bVar) {
        int i = bVar.f1941a;
        if (i == 1) {
            RecyclerView recyclerView = this.f1894a;
            recyclerView.mLayout.onItemsAdded(recyclerView, bVar.f1942b, bVar.f1944d);
            return;
        }
        if (i == 2) {
            RecyclerView recyclerView2 = this.f1894a;
            recyclerView2.mLayout.onItemsRemoved(recyclerView2, bVar.f1942b, bVar.f1944d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.f1894a;
            recyclerView3.mLayout.onItemsUpdated(recyclerView3, bVar.f1942b, bVar.f1944d, bVar.f1943c);
        } else {
            if (i != 8) {
                return;
            }
            RecyclerView recyclerView4 = this.f1894a;
            recyclerView4.mLayout.onItemsMoved(recyclerView4, bVar.f1942b, bVar.f1944d, 1);
        }
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public void d(int i, int i2) {
        this.f1894a.offsetPositionRecordsForRemove(i, i2, true);
        RecyclerView recyclerView = this.f1894a;
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.f1885d += i2;
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public void a(int i, int i2, Object obj) {
        this.f1894a.viewRangeUpdate(i, i2, obj);
        this.f1894a.mItemsChanged = true;
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public void b(C0351a.b bVar) {
        c(bVar);
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public void a(C0351a.b bVar) {
        c(bVar);
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public void a(int i, int i2) {
        this.f1894a.offsetPositionRecordsForMove(i, i2);
        this.f1894a.mItemsAddedOrRemoved = true;
    }

    @Override // androidx.recyclerview.widget.C0351a.InterfaceC0030a
    public void c(int i, int i2) {
        this.f1894a.offsetPositionRecordsForInsert(i, i2);
        this.f1894a.mItemsAddedOrRemoved = true;
    }
}
