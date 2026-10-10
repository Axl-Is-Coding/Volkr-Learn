package androidx.recyclerview.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTouchHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0369t implements RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ItemTouchHelper f2038a;

    C0369t(ItemTouchHelper itemTouchHelper) {
        this.f2038a = itemTouchHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int iFindPointerIndex;
        ItemTouchHelper.c cVarA;
        this.f2038a.z.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2038a.l = motionEvent.getPointerId(0);
            this.f2038a.f1804d = motionEvent.getX();
            this.f2038a.f1805e = motionEvent.getY();
            this.f2038a.b();
            ItemTouchHelper itemTouchHelper = this.f2038a;
            if (itemTouchHelper.f1803c == null && (cVarA = itemTouchHelper.a(motionEvent)) != null) {
                ItemTouchHelper itemTouchHelper2 = this.f2038a;
                itemTouchHelper2.f1804d -= cVarA.j;
                itemTouchHelper2.f1805e -= cVarA.k;
                itemTouchHelper2.a(cVarA.f1813e, true);
                if (this.f2038a.f1801a.remove(cVarA.f1813e.itemView)) {
                    ItemTouchHelper itemTouchHelper3 = this.f2038a;
                    itemTouchHelper3.m.clearView(itemTouchHelper3.r, cVarA.f1813e);
                }
                this.f2038a.a(cVarA.f1813e, cVarA.f1814f);
                ItemTouchHelper itemTouchHelper4 = this.f2038a;
                itemTouchHelper4.a(motionEvent, itemTouchHelper4.o, 0);
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            ItemTouchHelper itemTouchHelper5 = this.f2038a;
            itemTouchHelper5.l = -1;
            itemTouchHelper5.a((RecyclerView.w) null, 0);
        } else {
            int i = this.f2038a.l;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                this.f2038a.a(actionMasked, motionEvent, iFindPointerIndex);
            }
        }
        VelocityTracker velocityTracker = this.f2038a.t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return this.f2038a.f1803c != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            this.f2038a.a((RecyclerView.w) null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f2038a.z.a(motionEvent);
        VelocityTracker velocityTracker = this.f2038a.t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (this.f2038a.l == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int iFindPointerIndex = motionEvent.findPointerIndex(this.f2038a.l);
        if (iFindPointerIndex >= 0) {
            this.f2038a.a(actionMasked, motionEvent, iFindPointerIndex);
        }
        ItemTouchHelper itemTouchHelper = this.f2038a;
        RecyclerView.w wVar = itemTouchHelper.f1803c;
        if (wVar == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    itemTouchHelper.a(motionEvent, itemTouchHelper.o, iFindPointerIndex);
                    this.f2038a.a(wVar);
                    ItemTouchHelper itemTouchHelper2 = this.f2038a;
                    itemTouchHelper2.r.removeCallbacks(itemTouchHelper2.s);
                    this.f2038a.s.run();
                    this.f2038a.r.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == this.f2038a.l) {
                    this.f2038a.l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    ItemTouchHelper itemTouchHelper3 = this.f2038a;
                    itemTouchHelper3.a(motionEvent, itemTouchHelper3.o, actionIndex);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = itemTouchHelper.t;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        this.f2038a.a((RecyclerView.w) null, 0);
        this.f2038a.l = -1;
    }
}
