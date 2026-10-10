package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.C0315c;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.h implements RecyclerView.j {
    private b A;
    private Rect C;
    private long D;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f1804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f1805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f1806f;
    private float g;
    float h;
    float i;
    private float j;
    private float k;
    a m;
    int o;
    private int q;
    RecyclerView r;
    VelocityTracker t;
    private List<RecyclerView.w> u;
    private List<Integer> v;
    C0315c z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<View> f1801a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f1802b = new float[2];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RecyclerView.w f1803c = null;
    int l = -1;
    private int n = 0;
    List<c> p = new ArrayList();
    final Runnable s = new RunnableC0368s(this);
    private RecyclerView.d w = null;
    View x = null;
    int y = -1;
    private final RecyclerView.l B = new C0369t(this);

    public static abstract class a {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new InterpolatorC0373x();
        private static final Interpolator sDragViewScrollCapInterpolator = new InterpolatorC0374y();
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & ABS_HORIZONTAL_DIR_FLAGS;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i5 | i3;
        }

        public static A getDefaultUIUtil() {
            return B.f1779a;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag(0, i2 | i);
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.w wVar, RecyclerView.w wVar2) {
            return true;
        }

        public RecyclerView.w chooseDropTarget(RecyclerView.w wVar, List<RecyclerView.w> list, int i, int i2) {
            int iAbs;
            int bottom;
            int top;
            int iAbs2;
            int left;
            int iAbs3;
            int right;
            int width = i + wVar.itemView.getWidth();
            int height = i2 + wVar.itemView.getHeight();
            int left2 = i - wVar.itemView.getLeft();
            int top2 = i2 - wVar.itemView.getTop();
            int size = list.size();
            RecyclerView.w wVar2 = null;
            int iAbs4 = -1;
            for (int i3 = 0; i3 < size; i3++) {
                RecyclerView.w wVar3 = list.get(i3);
                if (left2 <= 0 || (right = wVar3.itemView.getRight() - width) >= 0 || wVar3.itemView.getRight() <= wVar.itemView.getRight() || (iAbs = Math.abs(right)) <= iAbs4) {
                    iAbs = iAbs4;
                } else {
                    wVar2 = wVar3;
                }
                if (left2 < 0 && (left = wVar3.itemView.getLeft() - i) > 0 && wVar3.itemView.getLeft() < wVar.itemView.getLeft() && (iAbs3 = Math.abs(left)) > iAbs) {
                    iAbs = iAbs3;
                    wVar2 = wVar3;
                }
                if (top2 < 0 && (top = wVar3.itemView.getTop() - i2) > 0 && wVar3.itemView.getTop() < wVar.itemView.getTop() && (iAbs2 = Math.abs(top)) > iAbs) {
                    iAbs = iAbs2;
                    wVar2 = wVar3;
                }
                if (top2 <= 0 || (bottom = wVar3.itemView.getBottom() - height) >= 0 || wVar3.itemView.getBottom() <= wVar.itemView.getBottom() || (iAbs4 = Math.abs(bottom)) <= iAbs) {
                    iAbs4 = iAbs;
                } else {
                    wVar2 = wVar3;
                }
            }
            return wVar2;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.w wVar) {
            B.f1779a.a(wVar.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & RELATIVE_DIR_FLAGS;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i5 | i3;
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.w wVar) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, wVar), ViewCompat.m(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f2, float f3) {
            RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.e() : itemAnimator.f();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.w wVar) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.w wVar);

        public float getSwipeEscapeVelocity(float f2) {
            return f2;
        }

        public float getSwipeThreshold(RecyclerView.w wVar) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f2) {
            return f2;
        }

        boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.w wVar) {
            return (getAbsoluteMovementFlags(recyclerView, wVar) & 16711680) != 0;
        }

        boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.w wVar) {
            return (getAbsoluteMovementFlags(recyclerView, wVar) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int iSignum = (int) (((int) (((int) Math.signum(i2)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))) * sDragScrollInterpolator.getInterpolation(j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? j / 2000.0f : 1.0f));
            return iSignum == 0 ? i2 > 0 ? 1 : -1 : iSignum;
        }

        public abstract boolean isItemViewSwipeEnabled();

        public abstract boolean isLongPressDragEnabled();

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, float f2, float f3, int i, boolean z) {
            B.f1779a.a(canvas, recyclerView, wVar.itemView, f2, f3, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, float f2, float f3, int i, boolean z) {
            B.f1779a.b(canvas, recyclerView, wVar.itemView, f2, f3, i, z);
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, List<c> list, int i, float f2, float f3) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list.get(i2);
                cVar.c();
                int iSave = canvas.save();
                onChildDraw(canvas, recyclerView, cVar.f1813e, cVar.j, cVar.k, cVar.f1814f, false);
                canvas.restoreToCount(iSave);
            }
            if (wVar != null) {
                int iSave2 = canvas.save();
                onChildDraw(canvas, recyclerView, wVar, f2, f3, i, true);
                canvas.restoreToCount(iSave2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar, List<c> list, int i, float f2, float f3) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list.get(i2);
                int iSave = canvas.save();
                onChildDrawOver(canvas, recyclerView, cVar.f1813e, cVar.j, cVar.k, cVar.f1814f, false);
                canvas.restoreToCount(iSave);
            }
            if (wVar != null) {
                int iSave2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, wVar, f2, f3, i, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c cVar2 = list.get(i3);
                if (cVar2.m && !cVar2.i) {
                    list.remove(i3);
                } else if (!cVar2.m) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.w wVar, RecyclerView.w wVar2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView recyclerView, RecyclerView.w wVar, int i, RecyclerView.w wVar2, int i2, int i3, int i4) {
            RecyclerView.i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof d) {
                ((d) layoutManager).prepareForDrop(wVar.itemView, wVar2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(wVar2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(wVar2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(wVar2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(wVar2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.w wVar, int i) {
            if (wVar != null) {
                B.f1779a.b(wVar.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.w wVar, int i);
    }

    private class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1807a = true;

        b() {
        }

        void a() {
            this.f1807a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewB;
            RecyclerView.w childViewHolder;
            if (!this.f1807a || (viewB = ItemTouchHelper.this.b(motionEvent)) == null || (childViewHolder = ItemTouchHelper.this.r.getChildViewHolder(viewB)) == null) {
                return;
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.m.hasDragFlag(itemTouchHelper.r, childViewHolder)) {
                int pointerId = motionEvent.getPointerId(0);
                int i = ItemTouchHelper.this.l;
                if (pointerId == i) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(iFindPointerIndex);
                    float y = motionEvent.getY(iFindPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f1804d = x;
                    itemTouchHelper2.f1805e = y;
                    itemTouchHelper2.i = WheelView.DividerConfig.FILL;
                    itemTouchHelper2.h = WheelView.DividerConfig.FILL;
                    if (itemTouchHelper2.m.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.a(childViewHolder, 2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f1809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f1810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f1811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f1812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final RecyclerView.w f1813e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f1814f;
        final int h;
        boolean i;
        float j;
        float k;
        private float n;
        boolean l = false;
        boolean m = false;
        private final ValueAnimator g = ValueAnimator.ofFloat(WheelView.DividerConfig.FILL, 1.0f);

        c(RecyclerView.w wVar, int i, int i2, float f2, float f3, float f4, float f5) {
            this.f1814f = i2;
            this.h = i;
            this.f1813e = wVar;
            this.f1809a = f2;
            this.f1810b = f3;
            this.f1811c = f4;
            this.f1812d = f5;
            this.g.addUpdateListener(new C0375z(this));
            this.g.setTarget(wVar.itemView);
            this.g.addListener(this);
            a(WheelView.DividerConfig.FILL);
        }

        public void a(long j) {
            this.g.setDuration(j);
        }

        public void b() {
            this.f1813e.setIsRecyclable(false);
            this.g.start();
        }

        public void c() {
            float f2 = this.f1809a;
            float f3 = this.f1811c;
            if (f2 == f3) {
                this.j = this.f1813e.itemView.getTranslationX();
            } else {
                this.j = f2 + (this.n * (f3 - f2));
            }
            float f4 = this.f1810b;
            float f5 = this.f1812d;
            if (f4 == f5) {
                this.k = this.f1813e.itemView.getTranslationY();
            } else {
                this.k = f4 + (this.n * (f5 - f4));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.m) {
                this.f1813e.setIsRecyclable(true);
            }
            this.m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public void a() {
            this.g.cancel();
        }

        public void a(float f2) {
            this.n = f2;
        }
    }

    public interface d {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public ItemTouchHelper(a aVar) {
        this.m = aVar;
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    private void addChildDrawingOrderCallback() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.w == null) {
            this.w = new C0372w(this);
        }
        this.r.setChildDrawingOrderCallback(this.w);
    }

    private void d() {
        this.r.removeItemDecoration(this);
        this.r.removeOnItemTouchListener(this.B);
        this.r.removeOnChildAttachStateChangeListener(this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            this.m.clearView(this.r, this.p.get(0).f1813e);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        e();
        h();
    }

    private void e() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    private void f() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.addItemDecoration(this);
        this.r.addOnItemTouchListener(this.B);
        this.r.addOnChildAttachStateChangeListener(this);
        g();
    }

    private void g() {
        this.A = new b();
        this.z = new C0315c(this.r.getContext(), this.A);
    }

    private void h() {
        b bVar = this.A;
        if (bVar != null) {
            bVar.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    void b() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void b(View view) {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean c() {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.c():boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        float f2;
        float f3;
        this.y = -1;
        if (this.f1803c != null) {
            a(this.f1802b);
            float[] fArr = this.f1802b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = WheelView.DividerConfig.FILL;
            f3 = WheelView.DividerConfig.FILL;
        }
        this.m.onDraw(canvas, recyclerView, this.f1803c, this.p, this.n, f2, f3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        float f2;
        float f3;
        if (this.f1803c != null) {
            a(this.f1802b);
            float[] fArr = this.f1802b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = WheelView.DividerConfig.FILL;
            f3 = WheelView.DividerConfig.FILL;
        }
        this.m.onDrawOver(canvas, recyclerView, this.f1803c, this.p, this.n, f2, f3);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            d();
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f1806f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            f();
        }
    }

    View b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.w wVar = this.f1803c;
        if (wVar != null) {
            View view = wVar.itemView;
            if (a(view, x, y, this.j + this.h, this.k + this.i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            c cVar = this.p.get(size);
            View view2 = cVar.f1813e.itemView;
            if (a(view2, x, y, cVar.j, cVar.k)) {
                return view2;
            }
        }
        return this.r.findChildViewUnder(x, y);
    }

    private void a(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - this.f1803c.itemView.getLeft();
        } else {
            fArr[0] = this.f1803c.itemView.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.f1803c.itemView.getTop();
        } else {
            fArr[1] = this.f1803c.itemView.getTranslationY();
        }
    }

    private int d(RecyclerView.w wVar) {
        if (this.n == 2) {
            return 0;
        }
        int movementFlags = this.m.getMovementFlags(this.r, wVar);
        int iConvertToAbsoluteDirection = (this.m.convertToAbsoluteDirection(movementFlags, ViewCompat.m(this.r)) & 65280) >> 8;
        if (iConvertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & 65280) >> 8;
        if (Math.abs(this.h) > Math.abs(this.i)) {
            int iB = b(wVar, iConvertToAbsoluteDirection);
            if (iB > 0) {
                return (i & iB) == 0 ? a.convertToRelativeDirection(iB, ViewCompat.m(this.r)) : iB;
            }
            int iC = c(wVar, iConvertToAbsoluteDirection);
            if (iC > 0) {
                return iC;
            }
        } else {
            int iC2 = c(wVar, iConvertToAbsoluteDirection);
            if (iC2 > 0) {
                return iC2;
            }
            int iB2 = b(wVar, iConvertToAbsoluteDirection);
            if (iB2 > 0) {
                return (i & iB2) == 0 ? a.convertToRelativeDirection(iB2, ViewCompat.m(this.r)) : iB2;
            }
        }
        return 0;
    }

    public void b(RecyclerView.w wVar) {
        if (!this.m.hasDragFlag(this.r, wVar)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (wVar.itemView.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        b();
        this.i = WheelView.DividerConfig.FILL;
        this.h = WheelView.DividerConfig.FILL;
        a(wVar, 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(androidx.recyclerview.widget.RecyclerView.w r24, int r25) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.a(androidx.recyclerview.widget.RecyclerView$w, int):void");
    }

    private int b(RecyclerView.w wVar, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.h > WheelView.DividerConfig.FILL ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.getSwipeVelocityThreshold(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = xVelocity <= WheelView.DividerConfig.FILL ? 4 : 8;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.m.getSwipeEscapeVelocity(this.f1806f) && fAbs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = this.r.getWidth() * this.m.getSwipeThreshold(wVar);
        if ((i & i2) == 0 || Math.abs(this.h) <= width) {
            return 0;
        }
        return i2;
    }

    private List<RecyclerView.w> c(RecyclerView.w wVar) {
        RecyclerView.w wVar2 = wVar;
        List<RecyclerView.w> list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int boundingBoxMargin = this.m.getBoundingBoxMargin();
        int iRound = Math.round(this.j + this.h) - boundingBoxMargin;
        int iRound2 = Math.round(this.k + this.i) - boundingBoxMargin;
        int i = boundingBoxMargin * 2;
        int width = wVar2.itemView.getWidth() + iRound + i;
        int height = wVar2.itemView.getHeight() + iRound2 + i;
        int i2 = (iRound + width) / 2;
        int i3 = (iRound2 + height) / 2;
        RecyclerView.i layoutManager = this.r.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = layoutManager.getChildAt(i4);
            if (childAt != wVar2.itemView && childAt.getBottom() >= iRound2 && childAt.getTop() <= height && childAt.getRight() >= iRound && childAt.getLeft() <= width) {
                RecyclerView.w childViewHolder = this.r.getChildViewHolder(childAt);
                if (this.m.canDropOver(this.r, this.f1803c, childViewHolder)) {
                    int iAbs = Math.abs(i2 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int iAbs2 = Math.abs(i3 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i5 = (iAbs * iAbs) + (iAbs2 * iAbs2);
                    int size = this.u.size();
                    int i6 = 0;
                    for (int i7 = 0; i7 < size && i5 > this.v.get(i7).intValue(); i7++) {
                        i6++;
                    }
                    this.u.add(i6, childViewHolder);
                    this.v.add(i6, Integer.valueOf(i5));
                }
            }
            i4++;
            wVar2 = wVar;
        }
        return this.u;
    }

    void a(c cVar, int i) {
        this.r.post(new RunnableC0371v(this, cVar, i));
    }

    boolean a() {
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (!this.p.get(i).m) {
                return true;
            }
        }
        return false;
    }

    void a(RecyclerView.w wVar) {
        if (!this.r.isLayoutRequested() && this.n == 2) {
            float moveThreshold = this.m.getMoveThreshold(wVar);
            int i = (int) (this.j + this.h);
            int i2 = (int) (this.k + this.i);
            if (Math.abs(i2 - wVar.itemView.getTop()) >= wVar.itemView.getHeight() * moveThreshold || Math.abs(i - wVar.itemView.getLeft()) >= wVar.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.w> listC = c(wVar);
                if (listC.size() == 0) {
                    return;
                }
                RecyclerView.w wVarChooseDropTarget = this.m.chooseDropTarget(wVar, listC, i, i2);
                if (wVarChooseDropTarget == null) {
                    this.u.clear();
                    this.v.clear();
                    return;
                }
                int adapterPosition = wVarChooseDropTarget.getAdapterPosition();
                int adapterPosition2 = wVar.getAdapterPosition();
                if (this.m.onMove(this.r, wVar, wVarChooseDropTarget)) {
                    this.m.onMoved(this.r, wVar, adapterPosition2, wVarChooseDropTarget, adapterPosition, i, i2);
                }
            }
        }
    }

    private RecyclerView.w c(MotionEvent motionEvent) {
        View viewB;
        RecyclerView.i layoutManager = this.r.getLayoutManager();
        int i = this.l;
        if (i == -1) {
            return null;
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(iFindPointerIndex) - this.f1804d;
        float y = motionEvent.getY(iFindPointerIndex) - this.f1805e;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        int i2 = this.q;
        if (fAbs < i2 && fAbs2 < i2) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.canScrollVertically()) && (viewB = b(motionEvent)) != null) {
            return this.r.getChildViewHolder(viewB);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void a(View view) {
        c(view);
        RecyclerView.w childViewHolder = this.r.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.w wVar = this.f1803c;
        if (wVar != null && childViewHolder == wVar) {
            a((RecyclerView.w) null, 0);
            return;
        }
        a(childViewHolder, false);
        if (this.f1801a.remove(childViewHolder.itemView)) {
            this.m.clearView(this.r, childViewHolder);
        }
    }

    private int c(RecyclerView.w wVar, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.i > WheelView.DividerConfig.FILL ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.getSwipeVelocityThreshold(this.g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = yVelocity <= WheelView.DividerConfig.FILL ? 1 : 2;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.m.getSwipeEscapeVelocity(this.f1806f) && fAbs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = this.r.getHeight() * this.m.getSwipeThreshold(wVar);
        if ((i & i2) == 0 || Math.abs(this.i) <= height) {
            return 0;
        }
        return i2;
    }

    void a(RecyclerView.w wVar, boolean z) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            c cVar = this.p.get(size);
            if (cVar.f1813e == wVar) {
                cVar.l |= z;
                if (!cVar.m) {
                    cVar.a();
                }
                this.p.remove(size);
                return;
            }
        }
    }

    void a(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.w wVarC;
        int absoluteMovementFlags;
        if (this.f1803c != null || i != 2 || this.n == 2 || !this.m.isItemViewSwipeEnabled() || this.r.getScrollState() == 1 || (wVarC = c(motionEvent)) == null || (absoluteMovementFlags = (this.m.getAbsoluteMovementFlags(this.r, wVarC) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f2 = x - this.f1804d;
        float f3 = y - this.f1805e;
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        int i3 = this.q;
        if (fAbs >= i3 || fAbs2 >= i3) {
            if (fAbs > fAbs2) {
                if (f2 < WheelView.DividerConfig.FILL && (absoluteMovementFlags & 4) == 0) {
                    return;
                }
                if (f2 > WheelView.DividerConfig.FILL && (absoluteMovementFlags & 8) == 0) {
                    return;
                }
            } else {
                if (f3 < WheelView.DividerConfig.FILL && (absoluteMovementFlags & 1) == 0) {
                    return;
                }
                if (f3 > WheelView.DividerConfig.FILL && (absoluteMovementFlags & 2) == 0) {
                    return;
                }
            }
            this.i = WheelView.DividerConfig.FILL;
            this.h = WheelView.DividerConfig.FILL;
            this.l = motionEvent.getPointerId(0);
            a(wVarC, 1);
        }
    }

    void c(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }

    c a(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View viewB = b(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            c cVar = this.p.get(size);
            if (cVar.f1813e.itemView == viewB) {
                return cVar;
            }
        }
        return null;
    }

    void a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.h = x - this.f1804d;
        this.i = y - this.f1805e;
        if ((i & 4) == 0) {
            this.h = Math.max(WheelView.DividerConfig.FILL, this.h);
        }
        if ((i & 8) == 0) {
            this.h = Math.min(WheelView.DividerConfig.FILL, this.h);
        }
        if ((i & 1) == 0) {
            this.i = Math.max(WheelView.DividerConfig.FILL, this.i);
        }
        if ((i & 2) == 0) {
            this.i = Math.min(WheelView.DividerConfig.FILL, this.i);
        }
    }
}
