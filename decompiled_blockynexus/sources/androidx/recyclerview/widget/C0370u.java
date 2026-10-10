package androidx.recyclerview.widget;

import android.animation.Animator;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0370u extends ItemTouchHelper.c {
    final /* synthetic */ int o;
    final /* synthetic */ RecyclerView.w p;
    final /* synthetic */ ItemTouchHelper q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0370u(ItemTouchHelper itemTouchHelper, RecyclerView.w wVar, int i, int i2, float f2, float f3, float f4, float f5, int i3, RecyclerView.w wVar2) {
        super(wVar, i, i2, f2, f3, f4, f5);
        this.q = itemTouchHelper;
        this.o = i3;
        this.p = wVar2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.c, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.l) {
            return;
        }
        if (this.o <= 0) {
            ItemTouchHelper itemTouchHelper = this.q;
            itemTouchHelper.m.clearView(itemTouchHelper.r, this.p);
        } else {
            this.q.f1801a.add(this.p.itemView);
            this.i = true;
            int i = this.o;
            if (i > 0) {
                this.q.a(this, i);
            }
        }
        ItemTouchHelper itemTouchHelper2 = this.q;
        View view = itemTouchHelper2.x;
        View view2 = this.p.itemView;
        if (view == view2) {
            itemTouchHelper2.c(view2);
        }
    }
}
