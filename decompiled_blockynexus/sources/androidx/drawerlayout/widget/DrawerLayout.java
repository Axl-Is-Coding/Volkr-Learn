package androidx.drawerlayout.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0313a;
import androidx.core.view.C0316d;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.b;
import androidx.customview.b.g;
import cn.qqtheme.framework.widget.WheelView;
import com.uc.crashsdk.export.LogType;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final boolean ALLOW_EDGE_LOCK = false;
    static final boolean CAN_HIDE_DESCENDANTS;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DRAWER_ELEVATION = 10;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private final b mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final e mLeftCallback;
    private final g mLeftDragger;
    private c mListener;
    private List<c> mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList<View> mNonDrawerViews;
    private final e mRightCallback;
    private final g mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;
    private static final int[] THEME_ATTRS = {R.attr.colorPrimaryDark};
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};

    static final class b extends C0313a {
        b() {
        }

        @Override // androidx.core.view.C0313a
        public void a(View view, androidx.core.view.accessibility.b bVar) {
            super.a(view, bVar);
            if (DrawerLayout.includeChildForAccessibility(view)) {
                return;
            }
            bVar.c((View) null);
        }
    }

    public interface c {
        void a(int i);

        void a(View view);

        void a(View view, float f2);

        void b(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private g f1378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f1379c = new androidx.drawerlayout.widget.c(this);

        e(int i) {
            this.f1377a = i;
        }

        public void a(g gVar) {
            this.f1378b = gVar;
        }

        public void b() {
            DrawerLayout.this.removeCallbacks(this.f1379c);
        }

        @Override // androidx.customview.b.g.a
        public boolean b(int i) {
            return false;
        }

        @Override // androidx.customview.b.g.a
        public void c(int i) {
            DrawerLayout.this.updateDrawerState(this.f1377a, i, this.f1378b.c());
        }

        private void c() {
            View viewFindDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(this.f1377a == 3 ? 5 : 3);
            if (viewFindDrawerWithGravity != null) {
                DrawerLayout.this.closeDrawer(viewFindDrawerWithGravity);
            }
        }

        @Override // androidx.customview.b.g.a
        public void a(View view, int i, int i2, int i3, int i4) {
            float width = (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3) ? i + r3 : DrawerLayout.this.getWidth() - i) / view.getWidth();
            DrawerLayout.this.setDrawerViewOffset(view, width);
            view.setVisibility(width == WheelView.DividerConfig.FILL ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.b.g.a
        public boolean b(View view, int i) {
            return DrawerLayout.this.isDrawerView(view) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, this.f1377a) && DrawerLayout.this.getDrawerLockMode(view) == 0;
        }

        @Override // androidx.customview.b.g.a
        public void b(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f1379c, 160L);
        }

        @Override // androidx.customview.b.g.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.b.g.a
        public void a(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f1369c = false;
            c();
        }

        @Override // androidx.customview.b.g.a
        public void a(View view, float f2, float f3) {
            int i;
            float drawerViewOffset = DrawerLayout.this.getDrawerViewOffset(view);
            int width = view.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                i = (f2 > WheelView.DividerConfig.FILL || (f2 == WheelView.DividerConfig.FILL && drawerViewOffset > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < WheelView.DividerConfig.FILL || (f2 == WheelView.DividerConfig.FILL && drawerViewOffset > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f1378b.d(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        void a() {
            View viewFindDrawerWithGravity;
            int width;
            int iD = this.f1378b.d();
            boolean z = this.f1377a == 3;
            if (z) {
                viewFindDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
                width = (viewFindDrawerWithGravity != null ? -viewFindDrawerWithGravity.getWidth() : 0) + iD;
            } else {
                viewFindDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
                width = DrawerLayout.this.getWidth() - iD;
            }
            if (viewFindDrawerWithGravity != null) {
                if (((!z || viewFindDrawerWithGravity.getLeft() >= width) && (z || viewFindDrawerWithGravity.getLeft() <= width)) || DrawerLayout.this.getDrawerLockMode(viewFindDrawerWithGravity) != 0) {
                    return;
                }
                LayoutParams layoutParams = (LayoutParams) viewFindDrawerWithGravity.getLayoutParams();
                this.f1378b.b(viewFindDrawerWithGravity, width, viewFindDrawerWithGravity.getTop());
                layoutParams.f1369c = true;
                DrawerLayout.this.invalidate();
                c();
                DrawerLayout.this.cancelChildViewTouch();
            }
        }

        @Override // androidx.customview.b.g.a
        public void a(int i, int i2) {
            View viewFindDrawerWithGravity;
            if ((i & 1) == 1) {
                viewFindDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
            } else {
                viewFindDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
            }
            if (viewFindDrawerWithGravity == null || DrawerLayout.this.getDrawerLockMode(viewFindDrawerWithGravity) != 0) {
                return;
            }
            this.f1378b.a(viewFindDrawerWithGravity, i2);
        }

        @Override // androidx.customview.b.g.a
        public int a(View view) {
            if (DrawerLayout.this.isDrawerView(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.b.g.a
        public int a(View view, int i, int i2) {
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }
    }

    static {
        CAN_HIDE_DESCENDANTS = Build.VERSION.SDK_INT >= 19;
        SET_DRAWER_SHADOW_FROM_ELEVATION = Build.VERSION.SDK_INT >= 21;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.mChildInvertedMatrix == null) {
                this.mChildInvertedMatrix = new Matrix();
            }
            matrix.invert(this.mChildInvertedMatrix);
            motionEventObtain.transform(this.mChildInvertedMatrix);
        }
        return motionEventObtain;
    }

    static String gravityToString(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f1369c) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        return findVisibleDrawer() != null;
    }

    static boolean includeChildForAccessibility(View view) {
        return (ViewCompat.k(view) == 4 || ViewCompat.k(view) == 2) ? false : true;
    }

    private boolean isInBoundsOfChild(float f2, float f3, View view) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        view.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) f2, (int) f3);
    }

    private boolean mirror(Drawable drawable, int i) {
        if (drawable == null || !androidx.core.graphics.drawable.a.f(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.a(drawable, i);
        return true;
    }

    private Drawable resolveLeftShadow() {
        int iM = ViewCompat.m(this);
        if (iM == 0) {
            Drawable drawable = this.mShadowStart;
            if (drawable != null) {
                mirror(drawable, iM);
                return this.mShadowStart;
            }
        } else {
            Drawable drawable2 = this.mShadowEnd;
            if (drawable2 != null) {
                mirror(drawable2, iM);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int iM = ViewCompat.m(this);
        if (iM == 0) {
            Drawable drawable = this.mShadowEnd;
            if (drawable != null) {
                mirror(drawable, iM);
                return this.mShadowEnd;
            }
        } else {
            Drawable drawable2 = this.mShadowStart;
            if (drawable2 != null) {
                mirror(drawable2, iM);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    private void updateChildrenImportantForAccessibility(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || isDrawerView(childAt)) && !(z && childAt == view)) {
                ViewCompat.f(childAt, 4);
            } else {
                ViewCompat.f(childAt, 1);
            }
        }
    }

    public void addDrawerListener(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(cVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!isDrawerView(childAt)) {
                this.mNonDrawerViews.add(childAt);
            } else if (isDrawerOpen(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.mNonDrawerViews.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.mNonDrawerViews.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.mNonDrawerViews.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (findOpenDrawer() != null || isDrawerView(view)) {
            ViewCompat.f(view, 4);
        } else {
            ViewCompat.f(view, 1);
        }
        if (CAN_HIDE_DESCENDANTS) {
            return;
        }
        ViewCompat.a(view, this.mChildAccessibilityDelegate);
    }

    void cancelChildViewTouch() {
        if (this.mChildrenCanceledTouch) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.mChildrenCanceledTouch = true;
    }

    boolean checkDrawerViewAbsoluteGravity(View view, int i) {
        return (getDrawerViewAbsoluteGravity(view) & i) == i;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void closeDrawer(View view) {
        closeDrawer(view, true);
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = WheelView.DividerConfig.FILL;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i).getLayoutParams()).f1368b);
        }
        this.mScrimOpacity = fMax;
        boolean zA = this.mLeftDragger.a(true);
        boolean zA2 = this.mRightDragger.a(true);
        if (zA || zA2) {
            ViewCompat.G(this);
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.mScrimOpacity <= WheelView.DividerConfig.FILL) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (isInBoundsOfChild(x, y, childAt) && !isContentView(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    void dispatchOnDrawerClosed(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f1370d & 1) == 1) {
            layoutParams.f1370d = 0;
            List<c> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).b(view);
                }
            }
            updateChildrenImportantForAccessibility(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void dispatchOnDrawerOpened(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f1370d & 1) == 0) {
            layoutParams.f1370d = 1;
            List<c> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).a(view);
                }
            }
            updateChildrenImportantForAccessibility(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void dispatchOnDrawerSlide(View view, float f2) {
        List<c> list = this.mListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).a(view, f2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean zIsContentView = isContentView(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i2 = 0;
        if (zIsContentView) {
            int childCount = getChildCount();
            i = width;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < i) {
                            i = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, i, getHeight());
            i2 = i3;
        } else {
            i = width;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        float f2 = this.mScrimOpacity;
        if (f2 > WheelView.DividerConfig.FILL && zIsContentView) {
            this.mScrimPaint.setColor((this.mScrimColor & 16777215) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i2, WheelView.DividerConfig.FILL, i, getHeight(), this.mScrimPaint);
        } else if (this.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view, 3)) {
            int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(WheelView.DividerConfig.FILL, Math.min(right2 / this.mLeftDragger.d(), 1.0f));
            this.mShadowLeftResolved.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.mShadowLeftResolved.setAlpha((int) (fMax * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
        } else if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view, 5)) {
            int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(WheelView.DividerConfig.FILL, Math.min((getWidth() - left2) / this.mRightDragger.d(), 1.0f));
            this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.mShadowRightResolved.setAlpha((int) (fMax2 * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return zDrawChild;
    }

    View findDrawerWithGravity(int i) {
        int iA = C0316d.a(i, ViewCompat.m(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == iA) {
                return childAt;
            }
        }
        return null;
    }

    View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f1370d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        return SET_DRAWER_SHADOW_FROM_ELEVATION ? this.mDrawerElevation : WheelView.DividerConfig.FILL;
    }

    public int getDrawerLockMode(int i) {
        int iM = ViewCompat.m(this);
        if (i == 3) {
            int i2 = this.mLockModeLeft;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iM == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.mLockModeRight;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iM == 0 ? this.mLockModeEnd : this.mLockModeStart;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.mLockModeStart;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iM == 0 ? this.mLockModeLeft : this.mLockModeRight;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.mLockModeEnd;
        if (i8 != 3) {
            return i8;
        }
        int i9 = iM == 0 ? this.mLockModeRight : this.mLockModeLeft;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    public CharSequence getDrawerTitle(int i) {
        int iA = C0316d.a(i, ViewCompat.m(this));
        if (iA == 3) {
            return this.mTitleLeft;
        }
        if (iA == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    int getDrawerViewAbsoluteGravity(View view) {
        return C0316d.a(((LayoutParams) view.getLayoutParams()).f1367a, ViewCompat.m(this));
    }

    float getDrawerViewOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1368b;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    boolean isContentView(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1367a == 0;
    }

    public boolean isDrawerOpen(View view) {
        if (isDrawerView(view)) {
            return (((LayoutParams) view.getLayoutParams()).f1370d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean isDrawerView(View view) {
        int iA = C0316d.a(((LayoutParams) view.getLayoutParams()).f1367a, ViewCompat.m(view));
        return ((iA & 3) == 0 && (iA & 5) == 0) ? false : true;
    }

    public boolean isDrawerVisible(View view) {
        if (isDrawerView(view)) {
            return ((LayoutParams) view.getLayoutParams()).f1368b > WheelView.DividerConfig.FILL;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void moveDrawerToOffset(View view, float f2) {
        float drawerViewOffset = getDrawerViewOffset(view);
        float width = view.getWidth();
        int i = ((int) (width * f2)) - ((int) (drawerViewOffset * width));
        if (!checkDrawerViewAbsoluteGravity(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        setDrawerViewOffset(view, f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.mLastInsets) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.mStatusBarBackground.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.b.g r1 = r6.mLeftDragger
            boolean r1 = r1.b(r7)
            androidx.customview.b.g r2 = r6.mRightDragger
            boolean r2 = r2.b(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L38
        L1e:
            androidx.customview.b.g r7 = r6.mLeftDragger
            boolean r7 = r7.a(r4)
            if (r7 == 0) goto L38
            androidx.drawerlayout.widget.DrawerLayout$e r7 = r6.mLeftCallback
            r7.b()
            androidx.drawerlayout.widget.DrawerLayout$e r7 = r6.mRightCallback
            r7.b()
            goto L38
        L31:
            r6.closeDrawers(r2)
            r6.mDisallowInterceptRequested = r3
            r6.mChildrenCanceledTouch = r3
        L38:
            r7 = 0
            goto L64
        L3a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.mInitialMotionX = r0
            r6.mInitialMotionY = r7
            float r4 = r6.mScrimOpacity
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5f
            androidx.customview.b.g r4 = r6.mLeftDragger
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.b(r0, r7)
            if (r7 == 0) goto L5f
            boolean r7 = r6.isContentView(r7)
            if (r7 == 0) goto L5f
            r7 = 1
            goto L60
        L5f:
            r7 = 0
        L60:
            r6.mDisallowInterceptRequested = r3
            r6.mChildrenCanceledTouch = r3
        L64:
            if (r1 != 0) goto L74
            if (r7 != 0) goto L74
            boolean r7 = r6.hasPeekingDrawer()
            if (r7 != 0) goto L74
            boolean r7 = r6.mChildrenCanceledTouch
            if (r7 == 0) goto L73
            goto L74
        L73:
            r2 = 0
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !hasVisibleDrawer()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewFindVisibleDrawer = findVisibleDrawer();
        if (viewFindVisibleDrawer != null && getDrawerLockMode(viewFindVisibleDrawer) == 0) {
            closeDrawers();
        }
        return viewFindVisibleDrawer != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f2;
        int i5;
        this.mInLayout = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i8, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f3 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (layoutParams.f1368b * f3));
                        f2 = (measuredWidth + i5) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i6 - r11) / f4;
                        i5 = i6 - ((int) (layoutParams.f1368b * f4));
                    }
                    boolean z2 = f2 != layoutParams.f1368b;
                    int i9 = layoutParams.f1367a & 112;
                    if (i9 == 16) {
                        int i10 = i4 - i2;
                        int i11 = (i10 - measuredHeight) / 2;
                        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i11 < i12) {
                            i11 = i12;
                        } else {
                            int i13 = i11 + measuredHeight;
                            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i13 > i10 - i14) {
                                i11 = (i10 - i14) - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                    } else if (i9 != 80) {
                        int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        childAt.layout(i5, i15, measuredWidth + i5, measuredHeight + i15);
                    } else {
                        int i16 = i4 - i2;
                        childAt.layout(i5, (i16 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i16 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    if (z2) {
                        setDrawerViewOffset(childAt, f2);
                    }
                    int i17 = layoutParams.f1368b > WheelView.DividerConfig.FILL ? 0 : 4;
                    if (childAt.getVisibility() != i17) {
                        childAt.setVisibility(i17);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        boolean z = this.mLastInsets != null && ViewCompat.j(this);
        int iM = ViewCompat.m(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int iA = C0316d.a(layoutParams.f1367a, iM);
                    if (ViewCompat.j(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.mLastInsets;
                            if (iA == 3) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            } else if (iA == 5) {
                                windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.mLastInsets;
                        if (iA == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iA == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(i3, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, FileTypeUtils.GIGABYTE));
                } else {
                    if (!isDrawerView(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                        float fI = ViewCompat.i(childAt);
                        float f2 = this.mDrawerElevation;
                        if (fI != f2) {
                            ViewCompat.a(childAt, f2);
                        }
                    }
                    int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(childAt) & 7;
                    boolean z4 = drawerViewAbsoluteGravity == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(drawerViewAbsoluteGravity) + " but this " + TAG + " already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                }
            }
            i4++;
            i3 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewFindDrawerWithGravity;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        int i = dVar.f1373c;
        if (i != 0 && (viewFindDrawerWithGravity = findDrawerWithGravity(i)) != null) {
            openDrawer(viewFindDrawerWithGravity);
        }
        int i2 = dVar.f1374d;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = dVar.f1375e;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = dVar.f1376f;
        if (i4 != 3) {
            setDrawerLockMode(i4, 8388611);
        }
        int i5 = dVar.g;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        resolveShadowDrawables();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z = layoutParams.f1370d == 1;
            boolean z2 = layoutParams.f1370d == 2;
            if (z || z2) {
                dVar.f1373c = layoutParams.f1367a;
                break;
            }
        }
        dVar.f1374d = this.mLockModeLeft;
        dVar.f1375e = this.mLockModeRight;
        dVar.f1376f = this.mLockModeStart;
        dVar.g = this.mLockModeEnd;
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.b.g r0 = r6.mLeftDragger
            r0.a(r7)
            androidx.customview.b.g r0 = r6.mRightDragger
            r0.a(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L69
            if (r0 == r1) goto L22
            r7 = 3
            if (r0 == r7) goto L1a
            goto L79
        L1a:
            r6.closeDrawers(r1)
            r6.mDisallowInterceptRequested = r2
            r6.mChildrenCanceledTouch = r2
            goto L79
        L22:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.b.g r3 = r6.mLeftDragger
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.b(r4, r5)
            if (r3 == 0) goto L62
            boolean r3 = r6.isContentView(r3)
            if (r3 == 0) goto L62
            float r3 = r6.mInitialMotionX
            float r0 = r0 - r3
            float r3 = r6.mInitialMotionY
            float r7 = r7 - r3
            androidx.customview.b.g r3 = r6.mLeftDragger
            int r3 = r3.e()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L62
            android.view.View r7 = r6.findOpenDrawer()
            if (r7 == 0) goto L62
            int r7 = r6.getDrawerLockMode(r7)
            r0 = 2
            if (r7 != r0) goto L60
            goto L62
        L60:
            r7 = 0
            goto L63
        L62:
            r7 = 1
        L63:
            r6.closeDrawers(r7)
            r6.mDisallowInterceptRequested = r2
            goto L79
        L69:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.mInitialMotionX = r0
            r6.mInitialMotionY = r7
            r6.mDisallowInterceptRequested = r2
            r6.mChildrenCanceledTouch = r2
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void openDrawer(View view) {
        openDrawer(view, true);
    }

    public void removeDrawerListener(c cVar) {
        List<c> list;
        if (cVar == null || (list = this.mListeners) == null) {
            return;
        }
        list.remove(cVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.mDisallowInterceptRequested = z;
        if (z) {
            closeDrawers(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    public void setChildInsets(Object obj, boolean z) {
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setDrawerElevation(float f2) {
        this.mDrawerElevation = f2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt)) {
                ViewCompat.a(childAt, this.mDrawerElevation);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        c cVar2 = this.mListener;
        if (cVar2 != null) {
            removeDrawerListener(cVar2);
        }
        if (cVar != null) {
            addDrawerListener(cVar);
        }
        this.mListener = cVar;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        if ((i & 8388611) == 8388611) {
            this.mShadowStart = drawable;
        } else if ((i & 8388613) == 8388613) {
            this.mShadowEnd = drawable;
        } else if ((i & 3) == 3) {
            this.mShadowLeft = drawable;
        } else if ((i & 5) != 5) {
            return;
        } else {
            this.mShadowRight = drawable;
        }
        resolveShadowDrawables();
        invalidate();
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int iA = C0316d.a(i, ViewCompat.m(this));
        if (iA == 3) {
            this.mTitleLeft = charSequence;
        } else if (iA == 5) {
            this.mTitleRight = charSequence;
        }
    }

    void setDrawerViewOffset(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 == layoutParams.f1368b) {
            return;
        }
        layoutParams.f1368b = f2;
        dispatchOnDrawerSlide(view, f2);
    }

    public void setScrimColor(int i) {
        this.mScrimColor = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.mStatusBarBackground = new ColorDrawable(i);
        invalidate();
    }

    void updateDrawerState(int i, int i2, View view) {
        int iF = this.mLeftDragger.f();
        int iF2 = this.mRightDragger.f();
        int i3 = 2;
        if (iF == 1 || iF2 == 1) {
            i3 = 1;
        } else if (iF != 2 && iF2 != 2) {
            i3 = 0;
        }
        if (view != null && i2 == 0) {
            float f2 = ((LayoutParams) view.getLayoutParams()).f1368b;
            if (f2 == WheelView.DividerConfig.FILL) {
                dispatchOnDrawerClosed(view);
            } else if (f2 == 1.0f) {
                dispatchOnDrawerOpened(view);
            }
        }
        if (i3 != this.mDrawerState) {
            this.mDrawerState = i3;
            List<c> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).a(i3);
                }
            }
        }
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void closeDrawer(View view, boolean z) {
        if (!isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.mFirstLayout) {
            layoutParams.f1368b = WheelView.DividerConfig.FILL;
            layoutParams.f1370d = 0;
        } else if (z) {
            layoutParams.f1370d |= 4;
            if (checkDrawerViewAbsoluteGravity(view, 3)) {
                this.mLeftDragger.b(view, -view.getWidth(), view.getTop());
            } else {
                this.mRightDragger.b(view, getWidth(), view.getTop());
            }
        } else {
            moveDrawerToOffset(view, WheelView.DividerConfig.FILL);
            updateDrawerState(layoutParams.f1367a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    void closeDrawers(boolean z) {
        int childCount = getChildCount();
        boolean zB = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z || layoutParams.f1369c)) {
                zB |= checkDrawerViewAbsoluteGravity(childAt, 3) ? this.mLeftDragger.b(childAt, -childAt.getWidth(), childAt.getTop()) : this.mRightDragger.b(childAt, getWidth(), childAt.getTop());
                layoutParams.f1369c = false;
            }
        }
        this.mLeftCallback.b();
        this.mRightCallback.b();
        if (zB) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void openDrawer(View view, boolean z) {
        if (!isDrawerView(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.mFirstLayout) {
            layoutParams.f1368b = 1.0f;
            layoutParams.f1370d = 1;
            updateChildrenImportantForAccessibility(view, true);
        } else if (z) {
            layoutParams.f1370d |= 2;
            if (checkDrawerViewAbsoluteGravity(view, 3)) {
                this.mLeftDragger.b(view, 0, view.getTop());
            } else {
                this.mRightDragger.b(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            moveDrawerToOffset(view, 1.0f);
            updateDrawerState(layoutParams.f1367a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildAccessibilityDelegate = new b();
        this.mScrimColor = DEFAULT_SCRIM_COLOR;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        this.mLeftCallback = new e(3);
        this.mRightCallback = new e(5);
        this.mLeftDragger = g.a(this, 1.0f, this.mLeftCallback);
        this.mLeftDragger.d(1);
        this.mLeftDragger.a(f3);
        this.mLeftCallback.a(this.mLeftDragger);
        this.mRightDragger = g.a(this, 1.0f, this.mRightCallback);
        this.mRightDragger.d(2);
        this.mRightDragger.a(f3);
        this.mRightCallback.a(this.mRightDragger);
        setFocusableInTouchMode(true);
        ViewCompat.f(this, 1);
        ViewCompat.a(this, new a());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.j(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new androidx.drawerlayout.widget.a(this));
                setSystemUiVisibility(LogType.UNEXP_ANR);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
                try {
                    this.mStatusBarBackground = typedArrayObtainStyledAttributes.getDrawable(0);
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            } else {
                this.mStatusBarBackground = null;
            }
        }
        this.mDrawerElevation = f2 * 10.0f;
        this.mNonDrawerViews = new ArrayList<>();
    }

    public void setDrawerLockMode(int i, int i2) {
        View viewFindDrawerWithGravity;
        int iA = C0316d.a(i2, ViewCompat.m(this));
        if (i2 == 3) {
            this.mLockModeLeft = i;
        } else if (i2 == 5) {
            this.mLockModeRight = i;
        } else if (i2 == 8388611) {
            this.mLockModeStart = i;
        } else if (i2 == 8388613) {
            this.mLockModeEnd = i;
        }
        if (i != 0) {
            (iA == 3 ? this.mLeftDragger : this.mRightDragger).b();
        }
        if (i != 1) {
            if (i == 2 && (viewFindDrawerWithGravity = findDrawerWithGravity(iA)) != null) {
                openDrawer(viewFindDrawerWithGravity);
                return;
            }
            return;
        }
        View viewFindDrawerWithGravity2 = findDrawerWithGravity(iA);
        if (viewFindDrawerWithGravity2 != null) {
            closeDrawer(viewFindDrawerWithGravity2);
        }
    }

    public void setStatusBarBackground(int i) {
        this.mStatusBarBackground = i != 0 ? androidx.core.content.b.c(getContext(), i) : null;
        invalidate();
    }

    public boolean isDrawerVisible(int i) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            return isDrawerVisible(viewFindDrawerWithGravity);
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f1368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1370d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1367a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.f1367a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1367a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f1367a = 0;
            this.f1367a = layoutParams.f1367a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1367a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1367a = 0;
        }
    }

    public boolean isDrawerOpen(int i) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            return isDrawerOpen(viewFindDrawerWithGravity);
        }
        return false;
    }

    protected static class d extends androidx.customview.a.c {
        public static final Parcelable.Creator<d> CREATOR = new androidx.drawerlayout.widget.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1374d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1375e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1376f;
        int g;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1373c = 0;
            this.f1373c = parcel.readInt();
            this.f1374d = parcel.readInt();
            this.f1375e = parcel.readInt();
            this.f1376f = parcel.readInt();
            this.g = parcel.readInt();
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1373c);
            parcel.writeInt(this.f1374d);
            parcel.writeInt(this.f1375e);
            parcel.writeInt(this.f1376f);
            parcel.writeInt(this.g);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
            this.f1373c = 0;
        }
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(androidx.core.content.b.c(getContext(), i), i2);
    }

    public int getDrawerLockMode(View view) {
        if (isDrawerView(view)) {
            return getDrawerLockMode(((LayoutParams) view.getLayoutParams()).f1367a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void setDrawerLockMode(int i, View view) {
        if (isDrawerView(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).f1367a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    class a extends C0313a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f1371d = new Rect();

        a() {
        }

        @Override // androidx.core.view.C0313a
        public void a(View view, androidx.core.view.accessibility.b bVar) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.a(view, bVar);
            } else {
                androidx.core.view.accessibility.b bVarA = androidx.core.view.accessibility.b.a(bVar);
                super.a(view, bVarA);
                bVar.d(view);
                Object objS = ViewCompat.s(view);
                if (objS instanceof View) {
                    bVar.c((View) objS);
                }
                a(bVar, bVarA);
                bVarA.y();
                a(bVar, (ViewGroup) view);
            }
            bVar.b((CharSequence) DrawerLayout.class.getName());
            bVar.i(false);
            bVar.j(false);
            bVar.b(b.a.f1233a);
            bVar.b(b.a.f1234b);
        }

        @Override // androidx.core.view.C0313a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // androidx.core.view.C0313a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View viewFindVisibleDrawer = DrawerLayout.this.findVisibleDrawer();
                if (viewFindVisibleDrawer == null) {
                    return true;
                }
                CharSequence drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(viewFindVisibleDrawer));
                if (drawerTitle == null) {
                    return true;
                }
                text.add(drawerTitle);
                return true;
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0313a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS || DrawerLayout.includeChildForAccessibility(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void a(androidx.core.view.accessibility.b bVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.includeChildForAccessibility(childAt)) {
                    bVar.a(childAt);
                }
            }
        }

        private void a(androidx.core.view.accessibility.b bVar, androidx.core.view.accessibility.b bVar2) {
            Rect rect = this.f1371d;
            bVar2.a(rect);
            bVar.c(rect);
            bVar2.b(rect);
            bVar.d(rect);
            bVar.q(bVar2.w());
            bVar.f(bVar2.h());
            bVar.b(bVar2.d());
            bVar.c(bVar2.e());
            bVar.h(bVar2.o());
            bVar.e(bVar2.n());
            bVar.i(bVar2.p());
            bVar.j(bVar2.q());
            bVar.a(bVar2.k());
            bVar.o(bVar2.u());
            bVar.l(bVar2.r());
            bVar.a(bVar2.b());
        }
    }

    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public void closeDrawer(int i, boolean z) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            closeDrawer(viewFindDrawerWithGravity, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
    }

    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void openDrawer(int i, boolean z) {
        View viewFindDrawerWithGravity = findDrawerWithGravity(i);
        if (viewFindDrawerWithGravity != null) {
            openDrawer(viewFindDrawerWithGravity, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
    }
}
