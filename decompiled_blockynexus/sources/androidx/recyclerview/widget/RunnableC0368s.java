package androidx.recyclerview.widget;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0368s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ItemTouchHelper f2037a;

    RunnableC0368s(ItemTouchHelper itemTouchHelper) {
        this.f2037a = itemTouchHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        ItemTouchHelper itemTouchHelper = this.f2037a;
        if (itemTouchHelper.f1803c == null || !itemTouchHelper.c()) {
            return;
        }
        ItemTouchHelper itemTouchHelper2 = this.f2037a;
        RecyclerView.w wVar = itemTouchHelper2.f1803c;
        if (wVar != null) {
            itemTouchHelper2.a(wVar);
        }
        ItemTouchHelper itemTouchHelper3 = this.f2037a;
        itemTouchHelper3.r.removeCallbacks(itemTouchHelper3.s);
        ViewCompat.a(this.f2037a.r, this);
    }
}
