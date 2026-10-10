package com.facebook.ads.redexgen.X;

import android.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$DecorView;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState;
import com.just.agentweb.WebIndicator;
import com.umeng.analytics.pro.ci;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.37, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass37 extends ViewGroup {
    public static byte[] A0u;
    public static String[] A0v;
    public static final int[] A0w;
    public static final Interpolator A0x;
    public static final AnonymousClass36 A0y;
    public static final Comparator<C13142z> A0z;
    public int A00;
    public AbstractC12952e A01;
    public float A02;
    public float A03;
    public float A04;
    public float A05;
    public float A06;
    public float A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public int A0I;
    public int A0J;
    public int A0K;
    public int A0L;
    public int A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public Drawable A0S;
    public Parcelable A0T;
    public VelocityTracker A0U;
    public EdgeEffect A0V;
    public EdgeEffect A0W;
    public Scroller A0X;
    public AnonymousClass32 A0Y;
    public AnonymousClass32 A0Z;
    public AnonymousClass33 A0a;
    public AnonymousClass34 A0b;
    public ClassLoader A0c;
    public ArrayList<View> A0d;
    public List<ViewPager.OnAdapterChangeListener> A0e;
    public List<AnonymousClass32> A0f;
    public boolean A0g;
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public boolean A0n;
    public boolean A0o;
    public boolean A0p;
    public final Rect A0q;
    public final C13142z A0r;
    public final Runnable A0s;
    public final ArrayList<C13142z> A0t;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0u, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A0u = new byte[]{-99, -70, -69, -99, -62, -14, 3, 9, 7, 20, -62, 5, ci.l, 3, 21, 21, -36, -62, -48, 0, 17, 23, 21, 34, -48, 25, 20, -22, -48, -34, ci.l, 48, 45, 32, 42, 35, 43, 31, 50, 39, 33, -34, 31, 34, 31, 46, 50, 35, 48, -8, -34, -30, 54, 49, 49, -30, 53, 47, 35, 46, 46, -3, -30, 38, 39, 40, 35, 55, 46, 54, 43, 48, 41, -30, 54, 49, -30, -66, -78, -8, 1, 7, 0, -10, -52, -78, -69, -39, -26, -26, -25, -20, -104, -39, -36, -36, -104, -24, -39, -33, -35, -22, -104, -36, -35, -37, -25, -22, -104, -18, -31, -35, -17, -104, -36, -19, -22, -31, -26, -33, -104, -28, -39, -15, -25, -19, -20, -10, 9, 21, 25, 9, 23, 24, 9, 8, -60, 19, 10, 10, 23, 7, 22, 9, 9, 18, -60, 20, 5, 11, 9, -60, ci.n, ci.k, 17, ci.k, 24, -60, -10, 10, 7, -62, 3, 18, 18, ci.l, 11, 5, 3, 22, 11, 17, ci.n, -55, 21, -62, -14, 3, 9, 7, 20, -29, 6, 3, 18, 22, 7, 20, -62, 5, 10, 3, ci.n, 9, 7, 6, -62, 22, 10, 7, -62, 3, 6, 3, 18, 22, 7, 20, -55, 21, -62, 5, 17, ci.n, 22, 7, ci.n, 22, 21, -62, 25, 11, 22, 10, 17, 23, 22, -62, 5, 3, ci.l, ci.l, 11, ci.n, 9, -62, -14, 3, 9, 7, 20, -29, 6, 3, 18, 22, 7, 20, -59, ci.n, 17, 22, 11, 8, 27, -26, 3, 22, 3, -11, 7, 22, -27, 10, 3, ci.n, 9, 7, 6, -61, -62, -25, 26, 18, 7, 5, 22, 7, 6, -62, 3, 6, 3, 18, 22, 7, 20, -62, 11, 22, 7, ci.m, -62, 5, 17, 23, ci.n, 22, -36, -62, -19, 0, -4, ci.l, -25, -8, -2, -4, 9, 25, 42, 42, 39, 47, 11, 27, 42, 39, 36, 36, -40, 44, 42, 33, 29, 28, -40, 44, 39, -40, 30, 33, 38, 28, -40, 30, 39, 27, 45, 43, -40, 26, 25, 43, 29, 28, -40, 39, 38, -40, 38, 39, 38, -27, 27, 32, 33, 36, 28, -40, 27, 45, 42, 42, 29, 38, 44, -40, 30, 39, 27, 45, 43, 29, 28, -40, 46, 33, 29, 47, -40, 76, 75, 45, 62, 68, 66, 48, 64, 79, 76, 73, 73, 66, 65, -3, 65, 70, 65, -3, 75, 76, 81, -3, 64, 62, 73, 73, -3, 80, 82, 77, 66, 79, 64, 73, 62, 80, 80, -3, 70, 74, 77, 73, 66, 74, 66, 75, 81, 62, 81, 70, 76, 75};
    }

    public static void A0D() {
        A0v = new String[]{"Pb5dMBpLoD8olSqqN3M1wt71s6WfJWWx", "mawes8eGWKEfT5kg0DwbKE", "yCX0UAcI", "nBGVAWTalDrx8Q3Q0HTp4hPpqgaJoZ5h", "", "", "gKpLqM1fc4CgqUT7jB7tIrf4xsKdVFyY", "wKHjR3FqXT8StRIGs0zAAfuJmbbhub4H"};
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.facebook.ads.redexgen.X.36] */
    static {
        A0D();
        A0C();
        A0w = new int[]{R.attr.layout_gravity};
        A0z = new Comparator<C13142z>() { // from class: com.facebook.ads.redexgen.X.2v
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(C13142z c13142z, C13142z c13142z2) {
                return c13142z.A02 - c13142z2.A02;
            }
        };
        A0x = new Interpolator() { // from class: com.facebook.ads.redexgen.X.2w
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
        A0y = new Comparator<View>() { // from class: com.facebook.ads.redexgen.X.36
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(View view, View view2) {
                AnonymousClass30 anonymousClass30 = (AnonymousClass30) view.getLayoutParams();
                AnonymousClass30 anonymousClass302 = (AnonymousClass30) view2.getLayoutParams();
                if (anonymousClass30.A05 != anonymousClass302.A05) {
                    return anonymousClass30.A05 ? 1 : -1;
                }
                return anonymousClass30.A02 - anonymousClass302.A02;
            }
        };
    }

    public AnonymousClass37(Context context) {
        super(context);
        this.A0t = new ArrayList<>();
        this.A0r = new C13142z();
        this.A0q = new Rect();
        this.A0O = -1;
        this.A0T = null;
        this.A0c = null;
        this.A02 = -3.4028235E38f;
        this.A07 = Float.MAX_VALUE;
        this.A0L = 1;
        this.A08 = -1;
        this.A0i = true;
        this.A0n = false;
        this.A0s = new Runnable() { // from class: com.facebook.ads.redexgen.X.2x
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.setScrollState(0);
                this.A00.A0g();
            }
        };
        this.A0P = 0;
        A0E();
    }

    private final float A00(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private int A01(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) > this.A0H && Math.abs(i2) > this.A0K) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            i += (int) (f2 + (i >= this.A00 ? 0.4f : 0.6f));
        }
        if (this.A0t.size() > 0) {
            return Math.max(this.A0t.get(0).A02, Math.min(i, this.A0t.get(r1.size() - 1).A02));
        }
        return i;
    }

    private Rect A02(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private C13142z A03() {
        int clientWidth = getClientWidth();
        float scrollOffset = WheelView.DividerConfig.FILL;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : WheelView.DividerConfig.FILL;
        if (clientWidth > 0) {
            float scrollOffset2 = this.A0M;
            scrollOffset = scrollOffset2 / clientWidth;
        }
        int i = -1;
        float leftBound = WheelView.DividerConfig.FILL;
        float rightBound = WheelView.DividerConfig.FILL;
        boolean z = true;
        C13142z c13142z = null;
        int i2 = 0;
        while (i2 < this.A0t.size()) {
            C13142z c13142z2 = this.A0t.get(i2);
            if (!z && c13142z2.A02 != i + 1) {
                c13142z2 = this.A0r;
                c13142z2.A00 = leftBound + rightBound + scrollOffset;
                c13142z2.A02 = i + 1;
                c13142z2.A01 = this.A01.A04(c13142z2.A02);
                i2--;
            }
            leftBound = c13142z2.A00;
            float rightBound2 = c13142z2.A01 + leftBound + scrollOffset;
            if (!z) {
                String[] strArr = A0v;
                if (strArr[4].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0v;
                strArr2[3] = "VrUwTTzuyHD2SkMMCenWDHvarMqbXCCI";
                strArr2[6] = "LX2NnyEsDXWEx3dFbPH8p7fzI1U1dTZ8";
                if (scrollX < leftBound) {
                    return c13142z;
                }
            }
            if (scrollX >= rightBound2) {
                int size = this.A0t.size() - 1;
                String[] strArr3 = A0v;
                if (strArr3[3].charAt(15) != strArr3[6].charAt(15)) {
                    String[] strArr4 = A0v;
                    strArr4[2] = "sbP3P6ChvdnfvWI";
                    strArr4[2] = "sbP3P6ChvdnfvWI";
                    if (i2 != size) {
                        z = false;
                        i = c13142z2.A02;
                        rightBound = c13142z2.A01;
                        c13142z = c13142z2;
                        i2++;
                    }
                } else {
                    String[] strArr5 = A0v;
                    strArr5[1] = "kvGf4Zg53U8bz7GLeUNnCLzy4o";
                    strArr5[1] = "kvGf4Zg53U8bz7GLeUNnCLzy4o";
                    if (i2 != size) {
                        z = false;
                        i = c13142z2.A02;
                        rightBound = c13142z2.A01;
                        c13142z = c13142z2;
                        i2++;
                    }
                }
            }
            return c13142z2;
        }
        return c13142z;
    }

    private final C13142z A04(int i) {
        for (int i2 = 0; i2 < this.A0t.size(); i2++) {
            C13142z c13142z = this.A0t.get(i2);
            if (c13142z.A02 == i) {
                return c13142z;
            }
        }
        return null;
    }

    private final C13142z A05(int i, int i2) {
        C13142z c13142z = new C13142z();
        c13142z.A02 = i;
        c13142z.A03 = this.A01.A08(this, i);
        c13142z.A01 = this.A01.A04(i);
        if (i2 < 0 || i2 >= this.A0t.size()) {
            this.A0t.add(c13142z);
        } else {
            this.A0t.add(i2, c13142z);
        }
        return c13142z;
    }

    private final C13142z A06(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return A07(view);
            }
        }
    }

    private final C13142z A07(View view) {
        for (int i = 0; i < this.A0t.size(); i++) {
            C13142z c13142z = this.A0t.get(i);
            if (this.A01.A0C(view, c13142z.A03)) {
                return c13142z;
            }
        }
        String[] strArr = A0v;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0v;
        strArr2[1] = "T6ty";
        strArr2[1] = "T6ty";
        return null;
    }

    private void A09() {
        this.A0k = false;
        this.A0m = false;
        VelocityTracker velocityTracker = this.A0U;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            String[] strArr = A0v;
            if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0v;
            strArr2[1] = "yoRarqzFlsm2scdQtgnfRphmjo";
            strArr2[1] = "yoRarqzFlsm2scdQtgnfRphmjo";
            this.A0U = null;
        }
    }

    private void A0A() {
        int i = 0;
        while (i < getChildCount()) {
            AnonymousClass30 lp = (AnonymousClass30) getChildAt(i).getLayoutParams();
            if (!lp.A05) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void A0B() {
        if (this.A0F != 0) {
            ArrayList<View> arrayList = this.A0d;
            if (arrayList == null) {
                this.A0d = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.A0d.add(getChildAt(i));
            }
            Collections.sort(this.A0d, A0y);
        }
    }

    private final void A0E() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.A0X = new Scroller(context, A0x);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.A0R = viewConfiguration.getScaledPagingTouchSlop();
        this.A0K = (int) (400.0f * f2);
        this.A0J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.A0V = new EdgeEffect(context);
        this.A0W = new EdgeEffect(context);
        this.A0H = (int) (25.0f * f2);
        this.A0C = (int) (2.0f * f2);
        this.A0E = (int) (16.0f * f2);
        C2t.A0A(this, new SE(this));
        if (C2t.A00(this) == 0) {
            C2t.A09(this, 1);
        }
        C2t.A0B(this, new SD(this));
    }

    private void A0F(int i) {
        AnonymousClass32 anonymousClass32 = this.A0Z;
        List<AnonymousClass32> list = this.A0f;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A0f.get(i2);
            }
        }
        AnonymousClass32 anonymousClass322 = this.A0Y;
    }

    private void A0G(int i) {
        AnonymousClass32 anonymousClass32 = this.A0Z;
        List<AnonymousClass32> list = this.A0f;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A0f.get(i2);
            }
        }
        AnonymousClass32 anonymousClass322 = this.A0Y;
    }

    /* JADX WARN: Incorrect condition in loop: B:152:0x039a */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0H(int r16) {
        /*
            Method dump skipped, instruction units count: 959
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.A0H(int):void");
    }

    private void A0I(int i, float f2, int i2) {
        AnonymousClass32 anonymousClass32 = this.A0Z;
        List<AnonymousClass32> list = this.A0f;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.A0f.get(i3);
            }
        }
        AnonymousClass32 anonymousClass322 = this.A0Y;
    }

    @CallSuper
    private final void A0J(int scrollX, float f2, int paddingLeft) {
        int iMax;
        if (this.A0D > 0) {
            int i = getScrollX();
            int paddingLeft2 = getPaddingLeft();
            int paddingRight = getPaddingRight();
            if (A0v[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0v;
            strArr[3] = "hSwONVQ9BwzgmNPK4tziO3X6uj4eQvsQ";
            strArr[6] = "gKhZoL4mhYlFRC9fFMXnjqdiW6EOuKfZ";
            int width = getWidth();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                AnonymousClass30 anonymousClass30 = (AnonymousClass30) childAt.getLayoutParams();
                if (anonymousClass30.A05) {
                    int i3 = anonymousClass30.A04 & 7;
                    if (i3 == 1) {
                        int childOffset = childAt.getMeasuredWidth();
                        iMax = Math.max((width - childOffset) / 2, paddingLeft2);
                    } else if (i3 == 3) {
                        iMax = paddingLeft2;
                        int childOffset2 = childAt.getWidth();
                        paddingLeft2 += childOffset2;
                    } else if (i3 != 5) {
                        iMax = paddingLeft2;
                    } else {
                        int childOffset3 = childAt.getMeasuredWidth();
                        iMax = (width - paddingRight) - childOffset3;
                        int childOffset4 = childAt.getMeasuredWidth();
                        paddingRight += childOffset4;
                    }
                    int childLeft = childAt.getLeft();
                    int i4 = (iMax + i) - childLeft;
                    if (i4 != 0) {
                        childAt.offsetLeftAndRight(i4);
                    }
                }
            }
        }
        A0I(scrollX, f2, paddingLeft);
        if (this.A0a != null) {
            getScrollX();
            int childCount2 = getChildCount();
            for (int i5 = 0; i5 < childCount2; i5++) {
                View childAt2 = getChildAt(i5);
                if (!((AnonymousClass30) childAt2.getLayoutParams()).A05) {
                    childAt2.getLeft();
                    getClientWidth();
                    throw null;
                }
            }
        }
        this.A0g = true;
    }

    private final void A0K(int i, int i2, int width) {
        int dy;
        int iRound;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.A0X;
        int dx = (scroller == null || scroller.isFinished()) ? 0 : 1;
        if (dx != 0) {
            if (this.A0l) {
                dy = this.A0X.getCurrX();
            } else {
                dy = this.A0X.getStartX();
            }
            this.A0X.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            dy = getScrollX();
        }
        int scrollY = getScrollY();
        int i3 = i - dy;
        int velocity = i2 - scrollY;
        if (i3 == 0 && velocity == 0) {
            A0S(false);
            A0g();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i4 = clientWidth / 2;
        float fA00 = i4 + (i4 * A00(Math.min(1.0f, (Math.abs(i3) * 1.0f) / clientWidth)));
        int halfWidth = Math.abs(width);
        if (halfWidth > 0) {
            float f2 = halfWidth;
            if (A0v[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0v;
            strArr[4] = "";
            strArr[5] = "";
            iRound = Math.round(Math.abs(fA00 / f2) * 1000.0f) * 4;
        } else {
            float fA04 = clientWidth * this.A01.A04(this.A00);
            float fAbs = Math.abs(i3);
            float pageWidth = this.A0M;
            iRound = (int) ((1.0f + (fAbs / (pageWidth + fA04))) * 100.0f);
        }
        int iMin = Math.min(iRound, WebIndicator.DO_END_ANIMATION_DURATION);
        this.A0l = false;
        this.A0X.startScroll(dy, scrollY, i3, velocity, iMin);
        C2t.A07(this);
    }

    private void A0L(int i, int i2, int i3, int i4) {
        if (i2 > 0) {
            ArrayList<C13142z> arrayList = this.A0t;
            String[] strArr = A0v;
            if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0v;
            strArr2[1] = "xS6wP2kv8Ukjp2mlI4OFB7EI";
            strArr2[1] = "xS6wP2kv8Ukjp2mlI4OFB7EI";
            if (!arrayList.isEmpty()) {
                boolean zIsFinished = this.A0X.isFinished();
                if (A0v[1].length() == 12) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0v;
                strArr3[2] = "M3IvNYMGgF0qb538wmgDMK0nNkgqAt";
                strArr3[2] = "M3IvNYMGgF0qb538wmgDMK0nNkgqAt";
                if (!zIsFinished) {
                    this.A0X.setFinalX(getCurrentItem() * getClientWidth());
                    return;
                }
                int oldWidthWithMargin = ((i - getPaddingLeft()) - getPaddingRight()) + i3;
                int xpos = ((i2 - getPaddingLeft()) - getPaddingRight()) + i4;
                scrollTo((int) (oldWidthWithMargin * (getScrollX() / xpos)), getScrollY());
                return;
            }
        }
        C13142z c13142zA04 = A04(this.A00);
        int paddingLeft = (int) (((i - getPaddingLeft()) - getPaddingRight()) * (c13142zA04 != null ? Math.min(c13142zA04.A00, this.A07) : WheelView.DividerConfig.FILL));
        if (paddingLeft != getScrollX()) {
            A0S(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private final void A0M(int i, boolean z) {
        this.A0o = false;
        A0O(i, z, false);
    }

    private void A0N(int destX, boolean z, int i, boolean z2) {
        C13142z c13142zA04 = A04(destX);
        int clientWidth = 0;
        if (c13142zA04 != null) {
            clientWidth = (int) (getClientWidth() * Math.max(this.A02, Math.min(c13142zA04.A00, this.A07)));
        }
        if (A0v[2].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A0v;
        strArr[3] = "qWyJthdIKprwmupmlWytZXkwKuTz6nwm";
        strArr[6] = "fDmSwMvEmt93O90vXMKXMmFP8biUMO95";
        if (z) {
            A0K(clientWidth, 0, i);
            if (z2) {
                A0F(destX);
                return;
            }
            return;
        }
        if (z2) {
            A0F(destX);
        }
        A0S(false);
        scrollTo(clientWidth, 0);
        A0a(clientWidth);
    }

    private final void A0O(int i, boolean z, boolean z2) {
        A0P(i, z, z2, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0P(int r6, boolean r7, boolean r8, int r9) {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.2e r0 = r5.A01
            r1 = 0
            if (r0 == 0) goto Lb
            int r0 = r0.A05()
            if (r0 > 0) goto Lf
        Lb:
            r5.setScrollingCacheEnabled(r1)
            return
        Lf:
            if (r8 != 0) goto L21
            int r0 = r5.A00
            if (r0 != r6) goto L21
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r5.A0t
            int r0 = r0.size()
            if (r0 == 0) goto L21
            r5.setScrollingCacheEnabled(r1)
            return
        L21:
            r2 = 1
            if (r6 >= 0) goto L48
            r6 = 0
        L25:
            int r1 = r5.A0L
            int r4 = r5.A00
            int r0 = r4 + r1
            if (r6 > r0) goto L67
            int r4 = r4 - r1
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.AnonymousClass37.A0v
            r0 = 7
            r1 = r3[r0]
            r0 = 0
            r3 = r3[r0]
            r0 = 10
            char r1 = r1.charAt(r0)
            char r0 = r3.charAt(r0)
            if (r1 == r0) goto L59
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L48:
            com.facebook.ads.redexgen.X.2e r0 = r5.A01
            int r0 = r0.A05()
            if (r6 < r0) goto L25
            com.facebook.ads.redexgen.X.2e r0 = r5.A01
            int r0 = r0.A05()
            int r6 = r0 + (-1)
            goto L25
        L59:
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.AnonymousClass37.A0v
            java.lang.String r1 = "HdD8kb8A1NTv0LjA3C8pNf8B8Uhf5Rjf"
            r0 = 3
            r3[r0] = r1
            java.lang.String r1 = "hEPxY7plOgAB5ujpSYVhyDABeqG0KedF"
            r0 = 6
            r3[r0] = r1
            if (r6 >= r4) goto L7d
        L67:
            r1 = 0
        L68:
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r5.A0t
            int r0 = r0.size()
            if (r1 >= r0) goto L7d
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r5.A0t
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.2z r0 = (com.facebook.ads.redexgen.X.C13142z) r0
            r0.A04 = r2
            int r1 = r1 + 1
            goto L68
        L7d:
            int r0 = r5.A00
            if (r0 == r6) goto L97
        L81:
            boolean r0 = r5.A0i
            if (r0 == 0) goto L90
            r5.A00 = r6
            if (r2 == 0) goto L8c
            r5.A0F(r6)
        L8c:
            r5.requestLayout()
        L8f:
            return
        L90:
            r5.A0H(r6)
            r5.A0N(r6, r7, r9, r2)
            goto L8f
        L97:
            r2 = 0
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.A0P(int, boolean, boolean, int):void");
    }

    private void A0Q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.A08) {
            int i = actionIndex == 0 ? 1 : 0;
            this.A05 = motionEvent.getX(i);
            String[] strArr = A0v;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0v;
            strArr2[4] = "";
            strArr2[5] = "";
            this.A08 = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.A0U;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0R(com.facebook.ads.redexgen.X.C13142z r13, int r14, com.facebook.ads.redexgen.X.C13142z r15) {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.A0R(com.facebook.ads.redexgen.X.2z, int, com.facebook.ads.redexgen.X.2z):void");
    }

    private void A0S(boolean z) {
        boolean z2 = this.A0P == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (true ^ this.A0X.isFinished()) {
                this.A0X.abortAnimation();
                if (A0v[1].length() == 12) {
                    throw new RuntimeException();
                }
                String[] strArr = A0v;
                strArr[1] = "La7";
                strArr[1] = "La7";
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int oldX = this.A0X.getCurrX();
                int x = this.A0X.getCurrY();
                if (scrollX != oldX || scrollY != x) {
                    scrollTo(oldX, x);
                    if (oldX != scrollX) {
                        A0a(oldX);
                    }
                }
            }
        }
        this.A0o = false;
        for (int i = 0; i < this.A0t.size(); i++) {
            C13142z ii = this.A0t.get(i);
            if (ii.A04) {
                z2 = true;
                ii.A04 = false;
            }
        }
        if (z2) {
            if (z) {
                C2t.A0C(this, this.A0s);
            } else {
                this.A0s.run();
            }
        }
    }

    private void A0T(boolean z) {
        int i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (z) {
                i = this.A0N;
            } else {
                i = 0;
            }
            getChildAt(i2).setLayerType(i, null);
        }
    }

    private void A0U(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean A0V() {
        this.A08 = -1;
        A09();
        this.A0V.onRelease();
        this.A0W.onRelease();
        return this.A0V.isFinished() || this.A0W.isFinished();
    }

    private final boolean A0W() {
        int i = this.A00;
        if (i > 0) {
            A0M(i - 1, true);
            return true;
        }
        return false;
    }

    private final boolean A0X() {
        AbstractC12952e abstractC12952e = this.A01;
        if (abstractC12952e != null && this.A00 < abstractC12952e.A05() - 1) {
            A0M(this.A00 + 1, true);
            return true;
        }
        if (A0v[2].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A0v;
        strArr[7] = "AXA5EDUbYu85ntxkUdYhY3hIIlQIUQar";
        strArr[0] = "7HhQN1X94o8BEMOAnE9vO9t08zapWTmy";
        return false;
    }

    private boolean A0Y(float deltaX) {
        boolean z = false;
        float f2 = this.A05 - deltaX;
        this.A05 = deltaX;
        float scrollX = getScrollX() + f2;
        int clientWidth = getClientWidth();
        float over = clientWidth * this.A02;
        float leftBound = this.A07;
        float f3 = clientWidth * leftBound;
        boolean z2 = true;
        boolean z3 = true;
        C13142z c13142z = this.A0t.get(0);
        C13142z c13142z2 = this.A0t.get(r1.size() - 1);
        if (c13142z.A02 != 0) {
            z2 = false;
            float f4 = c13142z.A00;
            int width = A0v[1].length();
            if (width == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0v;
            strArr[1] = com.umeng.analytics.pro.au.at;
            strArr[1] = com.umeng.analytics.pro.au.at;
            over = f4 * clientWidth;
        }
        int width2 = c13142z2.A02;
        if (width2 != this.A01.A05() - 1) {
            z3 = false;
            f3 = c13142z2.A00 * clientWidth;
        }
        if (scrollX < over) {
            if (z2) {
                this.A0V.onPull(Math.abs(over - scrollX) / clientWidth);
                z = true;
            }
            scrollX = over;
        } else if (scrollX > f3) {
            if (z3) {
                EdgeEffect edgeEffect = this.A0W;
                float fAbs = Math.abs(scrollX - f3);
                float f5 = clientWidth;
                String[] strArr2 = A0v;
                String str = strArr2[4];
                String str2 = strArr2[5];
                int width3 = str.length();
                if (width3 != str2.length()) {
                    edgeEffect.onPull(fAbs / f5);
                    z = true;
                } else {
                    String[] strArr3 = A0v;
                    strArr3[1] = "TwKB2lBmR";
                    strArr3[1] = "TwKB2lBmR";
                    edgeEffect.onPull(fAbs / f5);
                    z = true;
                }
            }
            scrollX = f3;
        }
        this.A05 += scrollX - ((int) scrollX);
        int width4 = (int) scrollX;
        scrollTo(width4, getScrollY());
        A0a((int) scrollX);
        return z;
    }

    private final boolean A0Z(float f2, float f3) {
        if (f2 >= this.A0I || f3 <= WheelView.DividerConfig.FILL) {
            if (f2 > getWidth() - this.A0I) {
                if (A0v[2].length() == 14) {
                    throw new RuntimeException();
                }
                String[] strArr = A0v;
                strArr[3] = "LoLbwLodEQ0RZhoADzk4YxqyeMxGbPNe";
                strArr[6] = "uXFtlpuRRgamX4n9Zkql1HjWorEkSQ7b";
                if (f3 < WheelView.DividerConfig.FILL) {
                }
            }
            return false;
        }
        return true;
    }

    private boolean A0a(int i) {
        int size = this.A0t.size();
        String strA08 = A08(381, 53, 117);
        if (size == 0) {
            if (this.A0i) {
                return false;
            }
            this.A0g = false;
            A0J(0, WheelView.DividerConfig.FILL, 0);
            String[] strArr = A0v;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0v;
            strArr2[2] = "c3ramapljB1reDSufYjA";
            strArr2[2] = "c3ramapljB1reDSufYjA";
            if (this.A0g) {
                return false;
            }
            throw new IllegalStateException(strA08);
        }
        C13142z c13142zA03 = A03();
        int clientWidth = getClientWidth();
        int i2 = this.A0M;
        int i3 = c13142zA03.A02;
        float f2 = ((i / clientWidth) - c13142zA03.A00) / (c13142zA03.A01 + (i2 / clientWidth));
        int currentPage = (int) ((clientWidth + i2) * f2);
        this.A0g = false;
        A0J(i3, f2, currentPage);
        if (this.A0g) {
            return true;
        }
        throw new IllegalStateException(strA08);
    }

    private final boolean A0b(int i) {
        View nextFocused = findFocus();
        if (nextFocused == this) {
            nextFocused = null;
        } else if (nextFocused != null) {
            boolean z = false;
            ViewParent parent = nextFocused.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(nextFocused.getClass().getSimpleName());
                for (ViewParent parent2 = nextFocused.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(A08(0, 4, 21));
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e(A08(300, 9, 47), A08(309, 72, 80) + sb.toString());
                nextFocused = null;
            }
        }
        boolean zA0W = false;
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, nextFocused, i);
        if (viewFindNextFocus != null && viewFindNextFocus != nextFocused) {
            if (i == 17) {
                int i2 = A02(this.A0q, viewFindNextFocus).left;
                int currLeft = A02(this.A0q, nextFocused).left;
                zA0W = (nextFocused == null || i2 < currLeft) ? viewFindNextFocus.requestFocus() : A0W();
            } else if (i == 66) {
                int i3 = A02(this.A0q, viewFindNextFocus).left;
                int currLeft2 = A02(this.A0q, nextFocused).left;
                zA0W = (nextFocused == null || i3 > currLeft2) ? viewFindNextFocus.requestFocus() : A0X();
            }
        } else if (i == 17 || i == 1) {
            zA0W = A0W();
        } else if (i == 66 || i == 2) {
            zA0W = A0X();
        }
        if (zA0W) {
            int currLeft3 = SoundEffectConstants.getContantForFocusDirection(i);
            playSoundEffect(currLeft3);
        }
        return zA0W;
    }

    private final boolean A0c(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            if (keyEvent.hasModifiers(2)) {
                return A0W();
            }
            return A0b(17);
        }
        if (keyCode == 22) {
            if (keyEvent.hasModifiers(2)) {
                return A0X();
            }
            return A0b(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return A0b(2);
        }
        boolean zHasModifiers = keyEvent.hasModifiers(1);
        String[] strArr = A0v;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0v;
        strArr2[1] = "lC1XoLB2bpdljamdt6Vm";
        strArr2[1] = "lC1XoLB2bpdljamdt6Vm";
        if (!zHasModifiers) {
            return false;
        }
        return A0b(1);
    }

    public static boolean A0d(@NonNull View view) {
        Class<?> clazz = view.getClass();
        return clazz.getAnnotation(ViewPager$DecorView.class) != null;
    }

    private final boolean A0e(View view, boolean z, int scrollX, int scrollY, int count) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX2 = view.getScrollX();
            int scrollY2 = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (scrollY + scrollX2 >= childAt.getLeft() && scrollY + scrollX2 < childAt.getRight() && count + scrollY2 >= childAt.getTop() && count + scrollY2 < childAt.getBottom()) {
                    int left = (scrollY + scrollX2) - childAt.getLeft();
                    int i = count + scrollY2;
                    if (A0v[1].length() == 12) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0v;
                    strArr[4] = "";
                    strArr[5] = "";
                    if (A0e(childAt, true, scrollX, left, i - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && view.canScrollHorizontally(-scrollX);
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x002a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0f() {
        /*
            r11 = this;
            com.facebook.ads.redexgen.X.2e r0 = r11.A01
            int r3 = r0.A05()
            r11.A0G = r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r11.A0t
            int r1 = r0.size()
            int r0 = r11.A0L
            int r0 = r0 * 2
            r5 = 1
            int r0 = r0 + r5
            r4 = 0
            if (r1 >= r0) goto L7b
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r11.A0t
            int r0 = r0.size()
            if (r0 >= r3) goto L7b
            r10 = 1
        L20:
            int r6 = r11.A00
            r9 = 0
            r2 = 0
        L24:
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r11.A0t
            int r0 = r0.size()
            if (r2 >= r0) goto L7d
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r11.A0t
            java.lang.Object r8 = r0.get(r2)
            com.facebook.ads.redexgen.X.2z r8 = (com.facebook.ads.redexgen.X.C13142z) r8
            com.facebook.ads.redexgen.X.2e r1 = r11.A01
            java.lang.Object r0 = r8.A03
            int r7 = r1.A06(r0)
            r0 = -1
            if (r7 != r0) goto L41
        L3f:
            int r2 = r2 + r5
            goto L24
        L41:
            r0 = -2
            if (r7 != r0) goto L6c
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r0 = r11.A0t
            r0.remove(r2)
            int r2 = r2 + (-1)
            if (r9 != 0) goto L4e
            r9 = 1
        L4e:
            com.facebook.ads.redexgen.X.2e r7 = r11.A01
            int r1 = r8.A02
            java.lang.Object r0 = r8.A03
            r7.A0B(r11, r1, r0)
            r10 = 1
            int r1 = r11.A00
            int r0 = r8.A02
            if (r1 != r0) goto L3f
            int r1 = r11.A00
            int r0 = r3 + (-1)
            int r0 = java.lang.Math.min(r1, r0)
            int r6 = java.lang.Math.max(r4, r0)
            r10 = 1
            goto L3f
        L6c:
            int r0 = r8.A02
            if (r0 == r7) goto L3f
            int r1 = r8.A02
            int r0 = r11.A00
            if (r1 != r0) goto L77
            r6 = r7
        L77:
            r8.A02 = r7
            r10 = 1
            goto L3f
        L7b:
            r10 = 0
            goto L20
        L7d:
            java.util.ArrayList<com.facebook.ads.redexgen.X.2z> r1 = r11.A0t
            java.util.Comparator<com.facebook.ads.redexgen.X.2z> r0 = com.facebook.ads.redexgen.X.AnonymousClass37.A0z
            java.util.Collections.sort(r1, r0)
            if (r10 == 0) goto Lc0
            int r3 = r11.getChildCount()
            r2 = 0
        L8b:
            if (r2 >= r3) goto La1
            android.view.View r0 = r11.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            com.facebook.ads.redexgen.X.30 r1 = (com.facebook.ads.redexgen.X.AnonymousClass30) r1
            boolean r0 = r1.A05
            if (r0 != 0) goto L9e
            r0 = 0
            r1.A00 = r0
        L9e:
            int r2 = r2 + 1
            goto L8b
        La1:
            r11.A0O(r6, r4, r5)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AnonymousClass37.A0v
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 14
            if (r1 == r0) goto Lc1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass37.A0v
            java.lang.String r1 = "iBz2AIJ6C"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "iBz2AIJ6C"
            r0 = 2
            r2[r0] = r1
            r11.requestLayout()
        Lc0:
            return
        Lc1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.A0f():void");
    }

    public final void A0g() {
        A0H(this.A00);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C13142z c13142zA07;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (c13142zA07 = A07(childAt)) != null && c13142zA07.A02 == this.A00) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> arrayList) {
        C13142z c13142zA07;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (c13142zA07 = A07(childAt)) != null && c13142zA07.A02 == this.A00) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        AnonymousClass30 anonymousClass30 = (AnonymousClass30) layoutParams;
        anonymousClass30.A05 |= A0d(view);
        if (this.A0j) {
            if (!anonymousClass30.A05) {
                anonymousClass30.A03 = true;
                addViewInLayout(view, i, layoutParams);
                return;
            }
            throw new IllegalStateException(A08(86, 41, 16));
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (this.A01 == null) {
            return false;
        }
        int scrollX = getClientWidth();
        int scrollX2 = getScrollX();
        return i < 0 ? scrollX2 > ((int) (((float) scrollX) * this.A02)) : i > 0 && scrollX2 < ((int) (((float) scrollX) * this.A07));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof AnonymousClass30) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.A0l = true;
        if (!this.A0X.isFinished() && this.A0X.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.A0X.getCurrX();
            int oldY = this.A0X.getCurrY();
            if (scrollX != currX || scrollY != oldY) {
                scrollTo(currX, oldY);
                if (!A0a(currX)) {
                    this.A0X.abortAnimation();
                    scrollTo(0, oldY);
                }
            }
            C2t.A07(this);
            return;
        }
        A0S(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || A0c(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C13142z ii;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (ii = A07(childAt)) != null) {
                int i2 = ii.A02;
                String[] strArr = A0v;
                if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0v;
                strArr2[4] = "";
                strArr2[5] = "";
                if (i2 == this.A00 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r8) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.A0S;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new AnonymousClass30();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new AnonymousClass30(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public AbstractC12952e getAdapter() {
        return this.A01;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        return ((AnonymousClass30) this.A0d.get(this.A0F == 2 ? (i - 1) - i2 : i2).getLayoutParams()).A01;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getCurrentItem() {
        return this.A00;
    }

    public int getOffscreenPageLimit() {
        return this.A0L;
    }

    public int getPageMargin() {
        return this.A0M;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.A0s);
        Scroller scroller = this.A0X;
        if (scroller != null && !scroller.isFinished()) {
            this.A0X.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x0051 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f2;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            A0V();
            String[] strArr = A0v;
            if (strArr[4].length() == strArr[5].length()) {
                String[] strArr2 = A0v;
                strArr2[2] = "iW5W";
                strArr2[2] = "iW5W";
                return false;
            }
        } else {
            if (action != 0) {
                if (this.A0k) {
                    return true;
                }
                if (this.A0m) {
                    return false;
                }
            }
            if (action != 0) {
                if (action == 2) {
                    int i = this.A08;
                    if (i != -1) {
                        int pointerIndex = motionEvent.findPointerIndex(i);
                        float x = motionEvent.getX(pointerIndex);
                        float x2 = this.A05;
                        float f3 = x - x2;
                        float fAbs = Math.abs(f3);
                        float y = motionEvent.getY(pointerIndex);
                        float dx = this.A04;
                        float fAbs2 = Math.abs(y - dx);
                        if (f3 != WheelView.DividerConfig.FILL && !A0Z(this.A05, f3) && A0e(this, false, (int) f3, (int) x, (int) y)) {
                            this.A05 = x;
                            this.A06 = y;
                            this.A0m = true;
                            return false;
                        }
                        float f4 = this.A0R;
                        if (A0v[1].length() != 12) {
                            String[] strArr3 = A0v;
                            strArr3[7] = "NnThZj9Wv9885vPNkfCF8DoAZte0LwUX";
                            strArr3[0] = "g2aolHvSBW8By3vUeqDyYWaFAgdqNGTo";
                            if (fAbs > f4 && 0.5f * fAbs > fAbs2) {
                                this.A0k = true;
                                A0U(true);
                                setScrollState(1);
                                if (f3 <= WheelView.DividerConfig.FILL) {
                                    f2 = this.A03 - this.A0R;
                                } else {
                                    float f5 = this.A03;
                                    int i2 = this.A0R;
                                    String[] strArr4 = A0v;
                                    if (strArr4[7].charAt(10) != strArr4[0].charAt(10)) {
                                        f2 = f5 + i2;
                                    } else {
                                        String[] strArr5 = A0v;
                                        strArr5[7] = "WpQimEPBWZ8vG05HKhTxshBMY3NNEur0";
                                        strArr5[0] = "BEtp4ufX6D8x3OZlDxdpMoFh1oKQqP0t";
                                        f2 = f5 + i2;
                                    }
                                }
                                this.A05 = f2;
                                this.A06 = y;
                                setScrollingCacheEnabled(true);
                            } else if (fAbs2 > this.A0R) {
                                this.A0m = true;
                            }
                            if (this.A0k && A0Y(x)) {
                                C2t.A07(this);
                            }
                        }
                    }
                } else if (action == 6) {
                    A0Q(motionEvent);
                }
            } else {
                float yDiff = motionEvent.getX();
                this.A03 = yDiff;
                this.A05 = yDiff;
                float y2 = motionEvent.getY();
                this.A04 = y2;
                this.A06 = y2;
                this.A08 = motionEvent.getPointerId(0);
                this.A0m = false;
                this.A0l = true;
                this.A0X.computeScrollOffset();
                if (this.A0P != 2 || Math.abs(this.A0X.getFinalX() - this.A0X.getCurrX()) <= this.A0C) {
                    A0S(false);
                    this.A0k = false;
                } else {
                    this.A0X.abortAnimation();
                    this.A0o = false;
                    A0g();
                    this.A0k = true;
                    A0U(true);
                    setScrollState(1);
                }
            }
            if (this.A0U == null) {
                this.A0U = VelocityTracker.obtain();
            }
            this.A0U.addMovement(motionEvent);
            return this.A0k;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        AnonymousClass30 anonymousClass30;
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        int maxGutterSize = measuredWidth / 10;
        this.A0I = Math.min(maxGutterSize, this.A0E);
        int maxGutterSize2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredWidth2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 < childCount) {
                View childAt = getChildAt(i5);
                int size = childAt.getVisibility();
                if (size != 8) {
                    AnonymousClass30 anonymousClass302 = (AnonymousClass30) childAt.getLayoutParams();
                    int childWidthSize = A0v[1].length();
                    if (childWidthSize == 12) {
                        break;
                    }
                    String[] strArr = A0v;
                    strArr[4] = "";
                    strArr[5] = "";
                    if (anonymousClass302 != null && anonymousClass302.A05) {
                        int i6 = anonymousClass302.A04 & 7;
                        int hgrav = anonymousClass302.A04;
                        int i7 = hgrav & 112;
                        int i8 = Integer.MIN_VALUE;
                        int i9 = Integer.MIN_VALUE;
                        boolean z = i7 == 48 || i7 == 80;
                        boolean z2 = i6 == 3 || i6 == 5;
                        if (z) {
                            i8 = FileTypeUtils.GIGABYTE;
                        } else if (z2) {
                            i9 = FileTypeUtils.GIGABYTE;
                        }
                        if (anonymousClass302.width != -2) {
                            i8 = FileTypeUtils.GIGABYTE;
                            if (anonymousClass302.width != -1) {
                                i3 = anonymousClass302.width;
                            } else {
                                i3 = maxGutterSize2;
                            }
                        } else {
                            i3 = maxGutterSize2;
                        }
                        if (anonymousClass302.height != -2) {
                            i9 = FileTypeUtils.GIGABYTE;
                            if (anonymousClass302.height != -1) {
                                i4 = anonymousClass302.height;
                                if (A0v[1].length() != 12) {
                                    String[] strArr2 = A0v;
                                    strArr2[1] = "VKsSzAx6pk9J5wmYrW5ACp";
                                    strArr2[1] = "VKsSzAx6pk9J5wmYrW5ACp";
                                }
                            } else {
                                i4 = measuredWidth2;
                            }
                        } else {
                            i4 = measuredWidth2;
                        }
                        int widthSpec = View.MeasureSpec.makeMeasureSpec(i3, i8);
                        int heightMode = View.MeasureSpec.makeMeasureSpec(i4, i9);
                        childAt.measure(widthSpec, heightMode);
                        if (z) {
                            int heightMode2 = childAt.getMeasuredHeight();
                            measuredWidth2 -= heightMode2;
                        } else if (z2) {
                            maxGutterSize2 -= childAt.getMeasuredWidth();
                        }
                    }
                }
                i5++;
            } else {
                int heightMode3 = View.MeasureSpec.makeMeasureSpec(maxGutterSize2, FileTypeUtils.GIGABYTE);
                this.A0B = heightMode3;
                int heightMode4 = View.MeasureSpec.makeMeasureSpec(measuredWidth2, FileTypeUtils.GIGABYTE);
                this.A0A = heightMode4;
                this.A0j = true;
                A0g();
                this.A0j = false;
                int childCount2 = getChildCount();
                for (int i10 = 0; i10 < childCount2; i10++) {
                    View childAt2 = getChildAt(i10);
                    if (childAt2.getVisibility() != 8 && ((anonymousClass30 = (AnonymousClass30) childAt2.getLayoutParams()) == null || !anonymousClass30.A05)) {
                        float f2 = maxGutterSize2;
                        String[] strArr3 = A0v;
                        if (strArr3[4].length() == strArr3[5].length()) {
                            String[] strArr4 = A0v;
                            strArr4[1] = "11cm9STM7FlxGR3";
                            strArr4[1] = "11cm9STM7FlxGR3";
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (f2 * anonymousClass30.A00), FileTypeUtils.GIGABYTE);
                            int widthSpec2 = this.A0A;
                            childAt2.measure(iMakeMeasureSpec, widthSpec2);
                        }
                    }
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int index, Rect rect) {
        int i;
        int i2;
        C13142z c13142zA07;
        int end = getChildCount();
        if ((index & 2) != 0) {
            i = 0;
            i2 = 1;
        } else {
            i = end - 1;
            i2 = -1;
            end = -1;
        }
        while (i != end) {
            View childAt = getChildAt(i);
            if (A0v[2].length() == 14) {
                throw new RuntimeException();
            }
            String[] strArr = A0v;
            strArr[3] = "wvs0VrXDMEHK1ZrgMliCmQkmYIqFRPYZ";
            strArr[6] = "yeuyy9yC0QSIfk9tyj8D1No5khczL5F7";
            int i3 = childAt.getVisibility();
            if (i3 == 0 && (c13142zA07 = A07(childAt)) != null) {
                int i4 = c13142zA07.A02;
                int i5 = this.A00;
                if (i4 == i5 && childAt.requestFocus(index, rect)) {
                    return true;
                }
            }
            i += i2;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ViewPager$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ViewPager$SavedState viewPager$SavedState = (ViewPager$SavedState) parcelable;
        super.onRestoreInstanceState(viewPager$SavedState.A02());
        if (this.A01 != null) {
            int i = viewPager$SavedState.A00;
            String[] strArr = A0v;
            if (strArr[3].charAt(15) == strArr[6].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0v;
            strArr2[7] = "Ly8LvMv3iU8o2fiJAVqvd6K7Aqz3gZKY";
            strArr2[0] = "HcNmsPXina8Ul250FP3kUGj1pgK53N1r";
            A0O(i, false, true);
            return;
        }
        this.A0O = viewPager$SavedState.A00;
        this.A0T = viewPager$SavedState.A01;
        this.A0c = viewPager$SavedState.A02;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(super.onSaveInstanceState());
        viewPager$SavedState.A00 = this.A00;
        AbstractC12952e abstractC12952e = this.A01;
        if (abstractC12952e != null) {
            viewPager$SavedState.A01 = abstractC12952e.A07();
        }
        return viewPager$SavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.A0M;
            A0L(i, i3, i5, i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.A0j) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.facebook.ads.redexgen.X.34] */
    public void setAdapter(AbstractC12952e abstractC12952e) {
        AbstractC12952e abstractC12952e2 = this.A01;
        if (abstractC12952e2 != null) {
            abstractC12952e2.A0A(null);
            for (int i = 0; i < this.A0t.size(); i++) {
                C13142z c13142z = this.A0t.get(i);
                this.A01.A0B(this, c13142z.A02, c13142z.A03);
            }
            this.A0t.clear();
            A0A();
            this.A00 = 0;
            scrollTo(0, 0);
        }
        this.A01 = abstractC12952e;
        this.A0G = 0;
        if (this.A01 != null) {
            if (this.A0b == null) {
                this.A0b = new DataSetObserver() { // from class: com.facebook.ads.redexgen.X.34
                    @Override // android.database.DataSetObserver
                    public final void onChanged() {
                        this.A00.A0f();
                    }

                    @Override // android.database.DataSetObserver
                    public final void onInvalidated() {
                        this.A00.A0f();
                    }
                };
            }
            this.A01.A0A(this.A0b);
            this.A0o = false;
            boolean z = this.A0i;
            this.A0i = true;
            this.A0G = this.A01.A05();
            if (this.A0O >= 0) {
                A0O(this.A0O, false, true);
                this.A0O = -1;
                this.A0T = null;
                this.A0c = null;
            } else if (!z) {
                A0g();
            } else {
                requestLayout();
            }
        }
        List<ViewPager.OnAdapterChangeListener> list = this.A0e;
        if (list != null && !list.isEmpty()) {
            int count = this.A0e.size();
            if (0 < count) {
                this.A0e.get(0);
                throw null;
            }
        }
    }

    public void setCurrentItem(int i) {
        this.A0o = false;
        A0O(i, !this.A0i, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(A08(300, 9, 47), A08(127, 31, 60) + i + A08(51, 26, 90) + 1);
            i = 1;
        }
        if (i != this.A0L) {
            this.A0L = i;
            A0g();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(AnonymousClass32 anonymousClass32) {
        this.A0Z = anonymousClass32;
    }

    public void setPageMargin(int width) {
        int i = this.A0M;
        this.A0M = width;
        int width2 = getWidth();
        A0L(width2, width2, width, i);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(C2A.A00(getContext(), i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.A0S = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.A0P == i) {
            return;
        }
        this.A0P = i;
        if (this.A0a != null) {
            A0T(i != 0);
        }
        A0G(i);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.A0p != z) {
            this.A0p = z;
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.A0S;
    }
}
