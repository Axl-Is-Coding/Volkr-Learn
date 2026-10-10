package com.facebook.ads.redexgen.X;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.m;
import io.rong.common.dlog.DLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class EI extends ViewGroup implements SA {
    public static byte[] A18;
    public static String[] A19;
    public static final Interpolator A1A;
    public static final boolean A1B;
    public static final boolean A1C;
    public static final boolean A1D;
    public static final boolean A1E;
    public static final boolean A1F;
    public static final boolean A1G;
    public static final int[] A1H;
    public static final int[] A1I;
    public static final Class<?>[] A1J;
    public SP A00;
    public C13173c A01;
    public SQ A02;
    public RunnableC13303p A03;
    public AnonymousClass42 A04;
    public C4A A05;

    @VisibleForTesting
    public C4E A06;
    public C4N A07;
    public C4V A08;
    public C1928Sh A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;

    @VisibleForTesting
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public float A0L;
    public float A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public int A0S;
    public int A0T;
    public int A0U;
    public int A0V;
    public int A0W;
    public int A0X;
    public VelocityTracker A0Y;
    public EdgeEffect A0Z;
    public EdgeEffect A0a;
    public EdgeEffect A0b;
    public EdgeEffect A0c;
    public C12922b A0d;
    public AnonymousClass45 A0e;
    public AnonymousClass48 A0f;
    public C4H A0g;
    public C4I A0h;
    public C4J A0i;
    public RecyclerView$SavedState A0j;
    public Runnable A0k;
    public List<RecyclerView.OnChildAttachStateChangeListener> A0l;
    public List<C4J> A0m;
    public boolean A0n;
    public boolean A0o;
    public final Rect A0p;
    public final RectF A0q;
    public final C4M A0r;
    public final C4T A0s;
    public final C13444e A0t;
    public final Runnable A0u;
    public final ArrayList<C4B> A0v;

    @VisibleForTesting
    public final List<C4W> A0w;
    public final int A0x;
    public final int A0y;
    public final Rect A0z;
    public final AccessibilityManager A10;
    public final C1926Sd A11;
    public final InterfaceC13434d A12;
    public final ArrayList<C4I> A13;
    public final int[] A14;
    public final int[] A15;
    public final int[] A16;
    public final int[] A17;

    public static String A0J(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A18, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0X() {
        A18 = new byte[]{-74, -74, -96, -74, -20, -1, -5, ci.k, -74, -34, 5, 2, -6, -5, 8, -74, -56, -48, -100, -33, -35, -22, -22, -21, -16, -100, -34, -31, -100, -30, -21, -15, -22, -32, -100, -34, -15, -16, -100, -27, -16, -100, -27, -17, -100, -22, -31, -33, -31, -17, -17, -35, -18, -11, -100, -30, -21, -18, -100, 126, -57, -47, 126, -65, -54, -48, -61, -65, -62, -41, 126, -65, -46, -46, -65, -63, -58, -61, -62, 126, -46, -51, 126, -65, 126, -80, -61, -63, -41, -63, -54, -61, -48, -76, -57, -61, -43, -104, -12, 61, 71, -12, 66, 67, 72, -12, 53, -12, 56, 61, 70, 57, 55, 72, -12, 55, 60, 61, 64, 56, -12, 67, 58, -12, -93, -15, -14, -9, -93, -23, -14, -8, -15, -25, -79, -93, -57, -20, -25, -93, -28, -15, -4, -93, -48, -14, -9, -20, -14, -15, -56, -7, -24, -15, -9, -10, -93, -22, -24, -9, -93, -10, -18, -20, -13, -13, -24, -25, -62, -45, -57, 8, 11, 8, 23, 27, 12, 25, -31, -117, 127, -62, -50, -51, -45, -60, -41, -45, -103, -56, -68, 8, -3, 21, 11, 17, ci.n, -42, 9, -18, 67, 65, 55, 60, 53, -18, 50, 51, 52, 47, 67, 58, 66, -18, 68, 47, 58, 67, 51, -67, -37, -26, -26, -33, -34, -102, -20, -33, -25, -23, -16, -33, -66, -33, -18, -37, -35, -30, -33, -34, -48, -29, -33, -15, -102, -15, -29, -18, -30, -102, -37, -102, -16, -29, -33, -15, -102, -15, -30, -29, -35, -30, -102, -29, -19, -102, -24, -23, -18, -102, -32, -26, -37, -31, -31, -33, -34, -102, -37, -19, -102, -18, -25, -22, -102, -34, -33, -18, -37, -35, -30, -33, -34, -88, -80, -50, -37, -37, -36, -31, -115, -48, -50, -39, -39, -115, -31, -43, -42, -32, -115, -38, -46, -31, -43, -36, -47, -115, -42, -37, -115, -50, -115, -32, -48, -33, -36, -39, -39, -115, -48, -50, -39, -39, -49, -50, -48, -40, -101, -115, -64, -48, -33, -36, -39, -39, -115, -48, -50, -39, -39, -49, -50, -48, -40, -32, -115, -38, -42, -44, -43, -31, -49, -46, -115, -33, -30, -37, -115, -47, -30, -33, -42, -37, -44, -115, -50, -115, -38, -46, -50, -32, -30, -33, -46, -115, -109, -115, -39, -50, -26, -36, -30, -31, -115, -35, -50, -32, -32, -115, -28, -43, -46, -33, -46, -115, -26, -36, -30, -115, -48, -50, -37, -37, -36, -31, -115, -48, -43, -50, -37, -44, -46, -115, -31, -43, -46, -65, -46, -48, -26, -48, -39, -46, -33, -61, -42, -46, -28, -115, -47, -50, -31, -50, -101, -115, -82, -37, -26, -115, -38, -46, -31, -43, -36, -47, -115, -48, -50, -39, -39, -115, -31, -43, -50, -31, -115, -38, -42, -44, -43, -31, -115, -48, -43, -50, -37, -44, -46, -115, -31, -43, -46, -115, -32, -31, -33, -30, -48, -31, -30, -33, -46, -36, -45, -115, -31, -43, -46, -115, -65, -46, -48, -26, -48, -39, -46, -33, -61, -42, -46, -28, -115, -36, -33, -115, -31, -43, -46, -115, -50, -47, -50, -35, -31, -46, -33, -115, -48, -36, -37, -31, -46, -37, -31, -32, -115, -32, -43, -36, -30, -39, -47, -115, -49, -46, -115, -35, -36, -32, -31, -35, -36, -37, -46, -47, -115, -31, -36, -31, -43, -46, -115, -37, -46, -27, -31, -115, -45, -33, -50, -38, -46, -101, -55, -25, -12, -12, -11, -6, -90, -23, -25, -14, -14, -90, -6, -18, -17, -7, -90, -13, -21, -6, -18, -11, -22, -90, -3, -18, -17, -14, -21, -90, -40, -21, -23, -1, -23, -14, -21, -8, -36, -17, -21, -3, -90, -17, -7, -90, -23, -11, -13, -10, -5, -6, -17, -12, -19, -90, -25, -90, -14, -25, -1, -11, -5, -6, -90, -11, -8, -90, -7, -23, -8, -11, -14, -14, -17, -12, -19, -28, 2, ci.m, ci.m, ci.n, 21, -63, 7, ci.k, 10, ci.m, 8, -63, 24, 10, 21, 9, ci.n, 22, 21, -63, 2, -63, -19, 2, 26, ci.n, 22, 21, -18, 2, ci.m, 2, 8, 6, 19, -63, 20, 6, 21, -49, -63, -28, 2, ci.k, ci.k, -63, 20, 6, 21, -19, 2, 26, ci.n, 22, 21, -18, 2, ci.m, 2, 8, 6, 19, -63, 24, 10, 21, 9, -63, 2, -63, ci.m, ci.n, ci.m, -50, ci.m, 22, ci.k, ci.k, -63, 2, 19, 8, 22, ci.l, 6, ci.m, 21, -49, -35, -5, 8, 8, 9, ci.l, -70, ci.k, -3, 12, 9, 6, 6, -70, ci.l, 9, -70, 10, 9, ci.k, 3, ci.l, 3, 9, 8, -70, -5, -70, -26, -5, 19, 9, ci.m, ci.l, -25, -5, 8, -5, 1, -1, 12, -70, ci.k, -1, ci.l, -56, -70, -35, -5, 6, 6, -70, ci.k, -1, ci.l, -26, -5, 19, 9, ci.m, ci.l, -25, -5, 8, -5, 1, -1, 12, -70, 17, 3, ci.l, 2, -70, -5, -70, 8, 9, 8, -57, 8, ci.m, 6, 6, -70, -5, 12, 1, ci.m, 7, -1, 8, ci.l, -56, -33, -3, 10, 10, 11, ci.n, -68, ci.m, -1, ci.l, 11, 8, 8, -68, 19, 5, ci.n, 4, 11, 17, ci.n, -68, -3, -68, -24, -3, 21, 11, 17, ci.n, -23, -3, 10, -3, 3, 1, ci.l, -68, ci.m, 1, ci.n, -54, -68, -33, -3, 8, 8, -68, ci.m, 1, ci.n, -24, -3, 21, 11, 17, ci.n, -23, -3, 10, -3, 3, 1, ci.l, -68, 19, 5, ci.n, 4, -68, -3, -68, 10, 11, 10, -55, 10, 17, 8, 8, -68, -3, ci.l, 3, 17, 9, 1, 10, ci.n, -54, -29, 1, ci.l, ci.l, ci.m, 20, -64, 19, ci.k, ci.m, ci.m, 20, 8, -64, 19, 3, 18, ci.m, 12, 12, -64, 23, 9, 20, 8, ci.m, 21, 20, -64, 1, -64, -20, 1, 25, ci.m, 21, 20, -19, 1, ci.l, 1, 7, 5, 18, -64, 19, 5, 20, -50, -64, -29, 1, 12, 12, -64, 19, 5, 20, -20, 1, 25, ci.m, 21, 20, -19, 1, ci.l, 1, 7, 5, 18, -64, 23, 9, 20, 8, 
        -64, 1, -64, ci.l, ci.m, ci.l, -51, ci.l, 21, 12, 12, -64, 1, 18, 7, 21, ci.k, 5, ci.l, 20, -50, -18, 25, -54, 24, 25, 30, -54, 29, ci.m, 30, -10, 11, 35, 25, 31, 30, -16, 28, 25, 36, ci.m, 24, -54, 19, 24, -54, 22, 11, 35, 25, 31, 30, -54, 25, 28, -54, 29, ci.k, 28, 25, 22, 22, -52, -7, -7, -10, -7, -89, -9, -7, -10, -22, -20, -6, -6, -16, -11, -18, -89, -6, -22, -7, -10, -13, -13, -62, -89, -9, -10, -16, -11, -5, -20, -7, -89, -16, -11, -21, -20, -1, -89, -19, -10, -7, -89, -16, -21, -89, -7, ci.l, 38, 28, 34, 33, -6, ci.l, 27, ci.l, 20, 18, 31, -51, -53, -20, -99, -34, -31, -34, -19, -15, -30, -17, -99, -34, -15, -15, -34, -32, -27, -30, -31, -72, -99, -16, -24, -26, -19, -19, -26, -21, -28, -99, -23, -34, -10, -20, -14, -15, -52, -19, -98, -22, -33, -9, -19, -13, -14, -98, -21, -33, -20, -33, -27, -29, -16, -98, -33, -14, -14, -33, -31, -26, -29, -30, -71, -98, -15, -23, -25, -18, -18, -25, -20, -27, -98, -22, -33, -9, -19, -13, -14, -1, 33, 30, 17, 27, 20, 28, -49, 38, 23, 24, 27, 20, -49, 28, ci.n, 35, 18, 23, 24, 29, 22, -49, 18, 23, ci.n, 29, 22, 20, 19, -49, 37, 24, 20, 38, -49, 23, 30, 27, 19, 20, 33, 34, -49, 38, 24, 35, 23, -49, 35, 23, 20, -49, 29, 20, 38, 30, 29, 20, 34, -35, -49, 3, 23, 20, -49, 31, 33, 20, -36, 27, ci.n, 40, 30, 36, 35, -49, 24, 29, 21, 30, 33, 28, ci.n, 35, 24, 30, 29, -49, 21, 30, 33, -49, 35, 23, 20, -49, 18, 23, ci.n, 29, 22, 20, -49, 23, 30, 27, 19, 20, 33, -49, 5, 9, -45, -7, 40, 31, 31, -4, 33, 41, 20, 31, 28, 23, 20, 39, 24, -3, 1, -53, -6, 25, -9, 12, 36, 26, 32, 31, -7, -3, -57, -9, 8, 25, 27, ci.n, 8, 19, -16, 21, 29, 8, 19, ci.n, 11, 8, 27, 12, -14, -10, -64, -13, 3, 18, ci.m, 12, 12, -10, 9, 7, 29, 7, ci.n, 9, 22, -6, ci.k, 9, 27, 1, 20, 18, 40, 18, 27, 20, 33, 5, 24, 20, 38, -49, 19, 30, 20, 34, -49, 29, 30, 35, -49, 34, 36, 31, 31, 30, 33, 35, -49, 34, 18, 33, 30, 27, 27, 24, 29, 22, -49, 35, 30, -49, ci.n, 29, -49, ci.n, 17, 34, 30, 27, 36, 35, 20, -49, 31, 30, 34, 24, 35, 24, 30, 29, -35, -49, 4, 34, 20, -49, 34, 18, 33, 30, 27, 27, 3, 30, -1, 30, 34, 24, 35, 24, 30, 29, -49, 24, 29, 34, 35, 20, ci.n, 19, -72, -53, -55, -33, -55, -46, -53, -40, -68, -49, -53, -35, -122, -50, -57, -39, -122, -44, -43, -122, -78, -57, -33, -43, -37, -38, -77, -57, -44, -57, -51, -53, -40, 29, 64, 56, -23, 45, 50, 47, 47, 46, 59, 46, 55, 61, -23, 31, 50, 46, 64, 17, 56, 53, 45, 46, 59, 60, -23, 49, 42, Utf8.REPLACEMENT_BYTE, 46, -23, 61, 49, 46, -23, 60, 42, 54, 46, -23, 44, 49, 42, 55, 48, 46, -23, 18, ci.k, -9, -23, 29, 49, 50, 60, -23, 54, 50, 48, 49, 61, -23, 49, 42, 57, 57, 46, 55, -23, 45, 62, 46, -23, 61, 56, -23, 50, 55, 44, 56, 55, 60, 50, 60, 61, 46, 55, 61, -23, 10, 45, 42, 57, 61, 46, 59, -23, 62, 57, 45, 42, 61, 46, -23, 46, Utf8.REPLACEMENT_BYTE, 46, 55, 61, 60, -23, 56, 59, -23, 50, 47, -23, 61, 49, 46, -23, 21, 42, 66, 56, 62, 61, 22, 42, 55, 42, 48, 46, 59, -23, 53, 42, 66, 60, -23, 56, 62, 61, -23, 61, 49, 46, -23, 60, 42, 54, 46, -23, 31, 50, 46, 64, -23, 54, 62, 53, 61, 50, 57, 53, 46, -23, 61, 50, 54, 46, 60, -9, -45, -23, 31, 50, 46, 64, 17, 56, 53, 45, 46, 59, -23, -6, 3, -10, 25, 17, -62, 6, 11, 8, 8, 7, 20, 7, ci.n, 22, -62, -8, 11, 7, 25, -22, 17, ci.l, 6, 7, 20, 21, -62, 10, 3, 24, 7, -62, 22, 10, 7, -62, 21, 3, ci.m, 7, -62, 21, 22, 3, 4, ci.l, 7, -62, -21, -26, -48, -62, -11, 22, 3, 4, ci.l, 7, -62, -21, -26, 21, -62, 11, ci.n, -62, 27, 17, 23, 20, -62, 3, 6, 3, 18, 22, 7, 20, -62, -17, -9, -11, -10, -62, -28, -25, -62, 23, ci.n, 11, 19, 23, 7, -62, 3, ci.n, 6, -62, -11, -22, -15, -9, -18, -26, -62, -16, -15, -10, -62, 5, 10, 3, ci.n, 9, 7, -48, -84, -62, -8, 11, 7, 25, -22, 17, ci.l, 6, 7, 20, -62, -45, -36, -29, -10, -14, 4, -83, 7, 9, 9, 11, 25, 25, ci.m, 8, ci.m, 18, ci.m, 26, 31, 31, 36, 45, 32, 30, 47, 36, 42, 41, -37, 40, 48, 46, 47, -37, 29, 32, -37, 28, 29, 46, 42, 39, 48, 47, 32, -23, -37, 45, 32, 30, 32, 36, 49, 32, 31, -11, -38, -52, -37, -70, -54, -39, -42, -45, -45, -48, -43, -50, -69, -42, -36, -54, -49, -70, -45, -42, -41, -113, -112, -95, -121, -55, -56, -53, -121, -56, -39, -50, -36, -44, -52, -43, -37, -121, -54, -42, -43, -38, -37, -56, -43, -37, -121};
    }

    public static void A0Y() {
        A19 = new String[]{"EzQ8zede2M", "Jhjgeach8ubRdn89CHbftPIFCkhy8Cmz", "AI0RoC", "LwFgY3t3Qwi2PJUU36Pvm2", "gOCwMU1oDfpLVyXTNaTi7eQdHjis00sx", "GZYggCcl1OWg4VOzBYKk2kBvqjxmktta", "Te26Sy6xLG0KtVPzJaOHws0Kts3F9NRb", "K773CdyIAwEU"};
    }

    static {
        A0Y();
        A0X();
        A1I = new int[]{R.attr.nestedScrollingEnabled};
        A1H = new int[]{R.attr.clipToPadding};
        A1C = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        A1B = Build.VERSION.SDK_INT >= 23;
        A1D = Build.VERSION.SDK_INT >= 16;
        A1E = Build.VERSION.SDK_INT >= 21;
        A1F = Build.VERSION.SDK_INT <= 15;
        A1G = Build.VERSION.SDK_INT <= 15;
        A1J = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        A1A = new Interpolator() { // from class: com.facebook.ads.redexgen.X.41
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public EI(Context context) {
        this(context, null);
    }

    public EI(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EI(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A11 = new C1926Sd(this);
        this.A0r = new C4M(this);
        this.A0t = new C13444e();
        this.A0u = new Runnable() { // from class: com.facebook.ads.redexgen.X.3z
            @Override // java.lang.Runnable
            public final void run() {
                if (!this.A00.A0D || this.A00.isLayoutRequested()) {
                    return;
                }
                if (!this.A00.A0F) {
                    this.A00.requestLayout();
                } else if (this.A00.A0I) {
                    this.A00.A0J = true;
                } else {
                    this.A00.A1K();
                }
            }
        };
        this.A0p = new Rect();
        this.A0z = new Rect();
        this.A0q = new RectF();
        this.A0v = new ArrayList<>();
        this.A13 = new ArrayList<>();
        this.A0O = 0;
        this.A0C = false;
        this.A0U = 0;
        this.A0N = 0;
        this.A05 = new EL();
        this.A0W = 0;
        this.A0V = -1;
        this.A0L = Float.MIN_VALUE;
        this.A0M = Float.MIN_VALUE;
        this.A0o = true;
        this.A08 = new C4V(this);
        this.A02 = A1E ? new SQ() : null;
        this.A0s = new C4T();
        this.A0G = false;
        this.A0H = false;
        this.A0f = new C1923Sa(this);
        this.A0K = false;
        this.A14 = new int[2];
        this.A17 = new int[2];
        this.A16 = new int[2];
        this.A15 = new int[2];
        this.A0w = new ArrayList();
        this.A0k = new Runnable() { // from class: com.facebook.ads.redexgen.X.40
            @Override // java.lang.Runnable
            public final void run() {
                if (this.A00.A05 != null) {
                    this.A00.A05.A0D();
                }
                this.A00.A0K = false;
            }
        };
        this.A12 = new SX(this);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, A1H, i, 0);
            this.A0B = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.A0B = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A0X = viewConfiguration.getScaledTouchSlop();
        this.A0L = C13102u.A00(viewConfiguration, context);
        this.A0M = C13102u.A01(viewConfiguration, context);
        this.A0y = viewConfiguration.getScaledMinimumFlingVelocity();
        this.A0x = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.A05.A0A(this.A0f);
        A0g();
        A0P();
        if (C2t.A00(this) == 0) {
            C2t.A09(this, 1);
        }
        this.A10 = (AccessibilityManager) getContext().getSystemService(A0J(1831, 13, 81));
        setAccessibilityDelegateCompat(new C1928Sh(this));
        setDescendantFocusability(262144);
        setNestedScrollingEnabled(true);
    }

    private int A0B(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private final long A0C(C4W c4w) {
        return this.A04.A0C() ? c4w.A0L() : c4w.A03;
    }

    @Nullable
    private View A0D() {
        C4W c4wA0E;
        int i = this.A0s.A01 != -1 ? this.A0s.A01 : 0;
        int iA03 = this.A0s.A03();
        for (int i2 = i; i2 < iA03; i2++) {
            C4W c4wA0E2 = A0E(i2);
            if (c4wA0E2 == null) {
                break;
            }
            if (c4wA0E2.A0H.hasFocusable()) {
                return c4wA0E2.A0H;
            }
        }
        for (int iMin = Math.min(iA03, i) - 1; iMin >= 0 && (c4wA0E = A0E(iMin)) != null; iMin--) {
            if (c4wA0E.A0H.hasFocusable()) {
                return c4wA0E.A0H;
            }
        }
        return null;
    }

    private final C4W A0E(int i) {
        if (this.A0C) {
            return null;
        }
        int iA07 = this.A01.A07();
        C4W c4w = null;
        for (int i2 = 0; i2 < iA07; i2++) {
            C4W c4wA0G = A0G(this.A01.A0B(i2));
            if (c4wA0G != null && !c4wA0G.A0d() && A1E(c4wA0G) == i) {
                if (this.A01.A0L(c4wA0G.A0H)) {
                    c4w = c4wA0G;
                } else {
                    return c4wA0G;
                }
            }
        }
        return c4w;
    }

    private final C4W A0F(long j) {
        AnonymousClass42 anonymousClass42 = this.A04;
        if (anonymousClass42 == null || !anonymousClass42.A0C()) {
            return null;
        }
        int iA07 = this.A01.A07();
        C4W c4w = null;
        for (int i = 0; i < iA07; i++) {
            C4W c4wA0G = A0G(this.A01.A0B(i));
            if (c4wA0G != null && !c4wA0G.A0d()) {
                long jA0L = c4wA0G.A0L();
                String[] strArr = A19;
                if (strArr[3].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A19;
                strArr2[2] = "zZZE93";
                strArr2[7] = "VhF552wVYFMR";
                if (jA0L != j) {
                    continue;
                } else if (this.A01.A0L(c4wA0G.A0H)) {
                    c4w = c4wA0G;
                } else {
                    return c4wA0G;
                }
            }
        }
        return c4w;
    }

    public static C4W A0G(View view) {
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[6] = "BAOGG7B6SgQWpjs0haC4kmkQlPV7A4k9";
        strArr[4] = "PAhaNRNZ3VZ1U75Bha3wwWQKZTmx8jYI";
        return ((C4F) layoutParams).A00;
    }

    @Nullable
    private final C4W A0H(View view) {
        View viewA1G = A1G(view);
        if (viewA1G == null) {
            return null;
        }
        return A1I(viewA1G);
    }

    @Nullable
    public static EI A0I(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        boolean z = view instanceof EI;
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[1] = "St3OXKQiThZ0lO5vTnfaG6NXMltPJG5W";
        strArr[1] = "St3OXKQiThZ0lO5vTnfaG6NXMltPJG5W";
        if (z) {
            return (EI) view;
        }
        ViewGroup parent = (ViewGroup) view;
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            EI descendant = A0I(parent.getChildAt(i));
            if (descendant != null) {
                return descendant;
            }
        }
        return null;
    }

    private void A0K() {
        A0U();
        setScrollState(0);
    }

    private void A0L() {
        int i = this.A0P;
        this.A0P = 0;
        if (i != 0) {
            boolean zA1t = A1t();
            String[] strArr = A19;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[3] = "eU2cwXbbXfV7oR8qPBCYPw";
            strArr2[0] = "cj1lHsGs8Y";
            if (zA1t) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(DLog.CRS);
                C3C.A01(accessibilityEventObtain, i);
                sendAccessibilityEventUnchecked(accessibilityEventObtain);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01aa A[PHI: r7
      0x01aa: PHI (r7v1 com.facebook.ads.redexgen.X.4W) = (r7v0 com.facebook.ads.redexgen.X.4W), (r7v2 com.facebook.ads.redexgen.X.4W) binds: [B:53:0x01a7, B:50:0x018a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0M() {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A0M():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0N() {
        /*
            r6 = this;
            r6.A1L()
            r6.A1M()
            com.facebook.ads.redexgen.X.4T r1 = r6.A0s
            r0 = 6
            r1.A04(r0)
            com.facebook.ads.redexgen.X.SP r0 = r6.A00
            r0.A0H()
            com.facebook.ads.redexgen.X.4T r1 = r6.A0s
            com.facebook.ads.redexgen.X.42 r0 = r6.A04
            int r0 = r0.A0E()
            r1.A03 = r0
            com.facebook.ads.redexgen.X.4T r2 = r6.A0s
            r4 = 0
            r2.A00 = r4
            r2.A09 = r4
            com.facebook.ads.redexgen.X.4E r1 = r6.A06
            com.facebook.ads.redexgen.X.4M r0 = r6.A0r
            r1.A1z(r0, r2)
            com.facebook.ads.redexgen.X.4T r3 = r6.A0s
            r3.A0D = r4
            r0 = 0
            r6.A0j = r0
            boolean r0 = r3.A0C
            if (r0 == 0) goto L72
            com.facebook.ads.redexgen.X.4A r5 = r6.A05
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 3
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L8a
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "QyMu0uKDVMcIUQ2WaaKkjpUJvINNzfF4"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "jnZHkwnP1Z9tC9uQsacmbdRp3FaoK01F"
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L72
            r0 = 1
        L57:
            r3.A0C = r0
            com.facebook.ads.redexgen.X.4T r3 = r6.A0s
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto L74
            r0 = 4
            r3.A04 = r0
            r6.A1N()
            r6.A1s(r4)
            return
        L72:
            r0 = 0
            goto L57
        L74:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "3IsVIAoReRfPbfS1EeUcjIwVgXkj1JVv"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "3IsVIAoReRfPbfS1EeUcjIwVgXkj1JVv"
            r0 = 1
            r2[r0] = r1
            r0 = 4
            r3.A04 = r0
            r6.A1N()
            r6.A1s(r4)
            return
        L8a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A0N():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0O() {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A0O():void");
    }

    private void A0P() {
        this.A01 = new C13173c(new SY(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Q() {
        /*
            r7 = this;
            boolean r0 = r7.A0C
            if (r0 == 0) goto Le
            com.facebook.ads.redexgen.X.SP r0 = r7.A00
            r0.A0J()
            com.facebook.ads.redexgen.X.4E r0 = r7.A06
            r0.A1N(r7)
        Le:
            boolean r0 = r7.A11()
            if (r0 == 0) goto L51
            com.facebook.ads.redexgen.X.SP r0 = r7.A00
            r0.A0I()
        L19:
            boolean r0 = r7.A0G
            r3 = 0
            if (r0 != 0) goto L22
            boolean r0 = r7.A0H
            if (r0 == 0) goto L4f
        L22:
            r6 = 1
        L23:
            com.facebook.ads.redexgen.X.4T r4 = r7.A0s
            boolean r0 = r7.A0D
            if (r0 == 0) goto L6f
            com.facebook.ads.redexgen.X.4A r0 = r7.A05
            if (r0 == 0) goto L6f
            boolean r0 = r7.A0C
            if (r0 != 0) goto L39
            if (r6 != 0) goto L39
            com.facebook.ads.redexgen.X.4E r0 = r7.A06
            boolean r0 = r0.A09
            if (r0 == 0) goto L6f
        L39:
            boolean r5 = r7.A0C
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L57
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L4f:
            r6 = 0
            goto L23
        L51:
            com.facebook.ads.redexgen.X.SP r0 = r7.A00
            r0.A0H()
            goto L19
        L57:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "q3lLGfTGOOnJqHZydaTklLew08TAvgTY"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "cayAc0YyiA2wrQyaXaOul4VyYlz5tKdZ"
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L6d
            com.facebook.ads.redexgen.X.42 r0 = r7.A04
            boolean r0 = r0.A0C()
            if (r0 == 0) goto L6f
        L6d:
            r0 = 1
            goto L70
        L6f:
            r0 = 0
        L70:
            r4.A0C = r0
            com.facebook.ads.redexgen.X.4T r1 = r7.A0s
            boolean r0 = r1.A0C
            if (r0 == 0) goto L85
            if (r6 == 0) goto L85
            boolean r0 = r7.A0C
            if (r0 != 0) goto L85
            boolean r0 = r7.A11()
            if (r0 == 0) goto L85
            r3 = 1
        L85:
            r1.A0B = r3
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto La1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "gWU7AH"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "O2IXTNL1mXfE"
            r0 = 7
            r2[r0] = r1
            return
        La1:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "vAY5NMbknnGVxibfJ54Fdf4KbFDo9MxQ"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "vAY5NMbknnGVxibfJ54Fdf4KbFDo9MxQ"
            r0 = 5
            r2[r0] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A0Q():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0R() {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A0R():void");
    }

    private void A0S() {
        boolean zIsFinished = false;
        EdgeEffect edgeEffect = this.A0a;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.A0a.isFinished();
        }
        EdgeEffect edgeEffect2 = this.A0c;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.A0c.isFinished();
        }
        EdgeEffect edgeEffect3 = this.A0b;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.A0b.isFinished();
        }
        EdgeEffect edgeEffect4 = this.A0Z;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.A0Z.isFinished();
        }
        if (zIsFinished) {
            C2t.A07(this);
        }
    }

    private void A0T() {
        C4T c4t = this.A0s;
        c4t.A08 = -1L;
        c4t.A01 = -1;
        c4t.A02 = -1;
    }

    private void A0U() {
        VelocityTracker velocityTracker = this.A0Y;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        A1Y(0);
        A0S();
    }

    private void A0V() {
        int iA0H;
        View focusedChild = null;
        if (this.A0o && hasFocus() && this.A04 != null) {
            focusedChild = getFocusedChild();
        }
        C4W c4wA0H = focusedChild == null ? null : A0H(focusedChild);
        if (c4wA0H == null) {
            A0T();
            return;
        }
        this.A0s.A08 = this.A04.A0C() ? c4wA0H.A0L() : -1L;
        C4T c4t = this.A0s;
        if (this.A0C) {
            iA0H = -1;
        } else {
            iA0H = c4wA0H.A0d() ? c4wA0H.A01 : c4wA0H.A0H();
        }
        c4t.A01 = iA0H;
        this.A0s.A02 = A0B(c4wA0H.A0H);
    }

    private void A0W() {
        this.A08.A09();
        C4E c4e = this.A06;
        if (c4e != null) {
            c4e.A0y();
        }
    }

    private final void A0Z() {
        int iA07 = this.A01.A07();
        for (int i = 0; i < iA07; i++) {
            C13173c c13173c = this.A01;
            String[] strArr = A19;
            String str = strArr[3];
            String str2 = strArr[0];
            int length = str.length();
            int i2 = str2.length();
            if (length == i2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[3] = "VFyFJGthyduvDNyVUqu48D";
            strArr2[0] = "uBjdUWzzez";
            C4W c4wA0G = A0G(c13173c.A0B(i));
            if (!c4wA0G.A0i()) {
                c4wA0G.A0N();
            }
        }
        this.A0r.A0L();
    }

    private final void A0a() {
        AnonymousClass42 anonymousClass42 = this.A04;
        String strA0J = A0J(1370, 12, 79);
        if (anonymousClass42 == null) {
            Log.e(strA0J, A0J(1123, 36, 40));
            return;
        }
        if (this.A06 == null) {
            Log.e(strA0J, A0J(1159, 43, 41));
            return;
        }
        C4T c4t = this.A0s;
        c4t.A0A = false;
        if (c4t.A04 == 1) {
            A0M();
            this.A06.A1P(this);
            A0N();
        } else if (this.A00.A0L() || this.A06.A0i() != getWidth() || this.A06.A0Y() != getHeight()) {
            this.A06.A1P(this);
            A0N();
        } else {
            this.A06.A1P(this);
        }
        A0O();
    }

    private final void A0b() {
        int i;
        for (int size = this.A0w.size() - 1; size >= 0; size--) {
            C4W c4w = this.A0w.get(size);
            if (c4w.A0H.getParent() == this && !c4w.A0i() && (i = c4w.A02) != -1) {
                C2t.A09(c4w.A0H, i);
                c4w.A02 = -1;
            }
        }
        this.A0w.clear();
    }

    private final void A0c() {
        if (this.A0Z != null) {
            return;
        }
        this.A0Z = new EdgeEffect(getContext());
        if (this.A0B) {
            this.A0Z.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.A0Z.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    private final void A0d() {
        if (this.A0a != null) {
            return;
        }
        this.A0a = new EdgeEffect(getContext());
        if (this.A0B) {
            EdgeEffect edgeEffect = this.A0a;
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int measuredWidth = getMeasuredWidth() - getPaddingLeft();
            String[] strArr = A19;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "GMHrLIeJxdXYoHZyaa7kSwSfzExGbrBL";
            strArr2[4] = "0YT1HYXH3vPYSlLI8aOL6WZeFeHH6VHe";
            edgeEffect.setSize(measuredHeight, measuredWidth - getPaddingRight());
            return;
        }
        this.A0a.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    private final void A0e() {
        if (this.A0b != null) {
            return;
        }
        this.A0b = new EdgeEffect(getContext());
        if (this.A0B) {
            this.A0b.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.A0b.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    private final void A0f() {
        if (this.A0c != null) {
            return;
        }
        this.A0c = new EdgeEffect(getContext());
        if (this.A0B) {
            this.A0c.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            return;
        }
        EdgeEffect edgeEffect = this.A0c;
        int measuredWidth = getMeasuredWidth();
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "10JS50";
        strArr[7] = "NY78MD5eAiV9";
        edgeEffect.setSize(measuredWidth, getMeasuredHeight());
    }

    private final void A0g() {
        this.A00 = new SP(new SZ(this));
    }

    private final void A0h() {
        this.A0Z = null;
        this.A0c = null;
        this.A0b = null;
        this.A0a = null;
    }

    private final void A0i() {
        int iA07 = this.A01.A07();
        for (int i = 0; i < iA07; i++) {
            ((C4F) this.A01.A0B(i).getLayoutParams()).A01 = true;
        }
        this.A0r.A0N();
    }

    private final void A0j() {
        int iA07 = this.A01.A07();
        for (int i = 0; i < iA07; i++) {
            C4W c4wA0G = A0G(this.A01.A0B(i));
            if (c4wA0G != null && !c4wA0G.A0i()) {
                c4wA0G.A0U(6);
            }
        }
        A0i();
        this.A0r.A0O();
    }

    private final void A0k() {
        int iA07 = this.A01.A07();
        for (int i = 0; i < iA07; i++) {
            C4W c4wA0G = A0G(this.A01.A0B(i));
            if (!c4wA0G.A0i()) {
                c4wA0G.A0S();
            }
        }
    }

    private void A0l(float f2, float f3, float f4, float f5) {
        boolean z = false;
        if (f3 < WheelView.DividerConfig.FILL) {
            A0d();
            C3T.A00(this.A0a, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
            z = true;
        } else if (f3 > WheelView.DividerConfig.FILL) {
            A0e();
            C3T.A00(this.A0b, f3 / getWidth(), f4 / getHeight());
            z = true;
        }
        if (f5 < WheelView.DividerConfig.FILL) {
            A0f();
            C3T.A00(this.A0c, (-f5) / getHeight(), f2 / getWidth());
            z = true;
        } else if (f5 > WheelView.DividerConfig.FILL) {
            A0c();
            C3T.A00(this.A0Z, f5 / getHeight(), 1.0f - (f2 / getWidth()));
            z = true;
        }
        if (z || f3 != WheelView.DividerConfig.FILL || f5 != WheelView.DividerConfig.FILL) {
            C2t.A07(this);
        }
    }

    private final void A0m(int i) {
        C4E c4e = this.A06;
        C4J c4j = this.A0i;
        if (c4j != null) {
            c4j.A0V(this, i);
        }
        List<C4J> list = this.A0m;
        String[] strArr = A19;
        if (strArr[2].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A19;
        strArr2[2] = "mB2qLC";
        strArr2[7] = "mQXIqdAaLius";
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.A0m.get(size).A0V(this, i);
            }
        }
    }

    private final void A0n(int i, int i2, Interpolator interpolator) {
        C4E c4e = this.A06;
        if (c4e == null) {
            Log.e(A0J(1370, 12, 79), A0J(924, 97, 75));
            return;
        }
        boolean z = this.A0I;
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "pqK8Y9";
        strArr[7] = "UiASdGbGWO9v";
        if (z) {
            return;
        }
        if (!c4e.A25()) {
            i = 0;
        }
        if (!this.A06.A26()) {
            i2 = 0;
        }
        if (i != 0 || i2 != 0) {
            this.A08.A0E(i, i2, interpolator);
        }
    }

    private void A0o(long j, C4W other, C4W c4w) {
        int iA06 = this.A01.A06();
        for (int i = 0; i < iA06; i++) {
            C4W c4wA0G = A0G(this.A01.A0A(i));
            if (c4wA0G != other && A0C(c4wA0G) == j) {
                AnonymousClass42 anonymousClass42 = this.A04;
                String strA0J = A0J(1, 17, 65);
                if (anonymousClass42 != null && anonymousClass42.A0C()) {
                    throw new IllegalStateException(A0J(1696, 130, 77) + c4wA0G + strA0J + other + A1J());
                }
                throw new IllegalStateException(A0J(1508, 188, 116) + c4wA0G + strA0J + other + A1J());
            }
        }
        Log.e(A0J(1370, 12, 79), A0J(1202, 111, 90) + c4w + A0J(18, 41, 39) + other + A1J());
    }

    private void A0p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) != this.A0V) {
            return;
        }
        int i = actionIndex == 0 ? 1 : 0;
        this.A0V = motionEvent.getPointerId(i);
        int x = (int) (motionEvent.getX(i) + 0.5f);
        this.A0S = x;
        this.A0Q = x;
        int y = (int) (motionEvent.getY(i) + 0.5f);
        this.A0T = y;
        this.A0R = y;
    }

    public static void A0q(View view, Rect insets) {
        C4F c4f = (C4F) view.getLayoutParams();
        Rect rect = c4f.A03;
        insets.set((view.getLeft() - rect.left) - c4f.leftMargin, (view.getTop() - rect.top) - c4f.topMargin, view.getRight() + rect.right + c4f.rightMargin, view.getBottom() + rect.bottom + c4f.bottomMargin);
    }

    private void A0r(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.A0p.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C4F) {
            C4F c4f = (C4F) layoutParams;
            if (!c4f.A01) {
                Rect rect = c4f.A03;
                this.A0p.left -= rect.left;
                this.A0p.right += rect.right;
                this.A0p.top -= rect.top;
                this.A0p.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.A0p);
            offsetRectIntoDescendantCoords(view, this.A0p);
        }
        this.A06.A1f(this, view, this.A0p, !this.A0D, view2 == null);
    }

    private void A0s(AnonymousClass42 anonymousClass42, boolean z, boolean z2) {
        AnonymousClass42 anonymousClass422 = this.A04;
        if (anonymousClass422 != null) {
            C1926Sd c1926Sd = this.A11;
            String[] strArr = A19;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "W0We85FJJqvSsXa60a6gd4EA7hDdiGkp";
            strArr2[4] = "7sp9VzUFxAlBM78ItapDbGKr6NkpOVCZ";
            anonymousClass422.A0A(c1926Sd);
        }
        if (!z || z2) {
            A1P();
        }
        this.A00.A0J();
        AnonymousClass42 anonymousClass423 = this.A04;
        this.A04 = anonymousClass42;
        if (anonymousClass42 != null) {
            anonymousClass42.A09(this.A11);
        }
        C4E c4e = this.A06;
        this.A0r.A0Z(anonymousClass423, this.A04, z);
        this.A0s.A0D = true;
        A1R();
    }

    private void A0t(C4W c4w) {
        View view = c4w.A0H;
        boolean z = view.getParent() == this;
        this.A0r.A0d(A1I(view));
        if (c4w.A0f()) {
            C13173c c13173c = this.A01;
            String[] strArr = A19;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "yAMck033yUmsKAwrNaBuaPdrYuAtD8a4";
            strArr2[4] = "2F1g5meBaFaT8Ughfaz4Efd5BOFwzFG2";
            c13173c.A0I(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.A01.A0K(view, true);
        } else {
            this.A01.A0F(view);
        }
    }

    public static void A0u(@NonNull C4W c4w) {
        if (c4w.A09 != null) {
            WeakReference<EI> weakReference = c4w.A09;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[6] = "Lp0Vudgnjyr9htx58aJuOXSG6zR0Rms0";
            strArr[4] = "QnOoNSP4qihOpTYseackLt73SA9jbFjz";
            EI ei = weakReference.get();
            while (ei != null) {
                if (ei == c4w.A0H) {
                    return;
                }
                Object parent = ei.getParent();
                if (parent instanceof View) {
                    ei = (View) parent;
                } else {
                    ei = null;
                }
            }
            c4w.A09 = null;
        }
    }

    private void A0v(@NonNull C4W c4w, @NonNull C4W c4w2, @NonNull AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492, boolean z, boolean z2) {
        c4w.A0a(false);
        if (z) {
            A0t(c4w);
        }
        if (c4w != c4w2) {
            if (z2) {
                A0t(c4w2);
            }
            c4w.A06 = c4w2;
            A0t(c4w);
            this.A0r.A0d(c4w);
            c4w2.A0a(false);
            c4w2.A07 = c4w;
        }
        if (this.A05.A0L(c4w, c4w2, anonymousClass49, anonymousClass492)) {
            A1O();
        }
    }

    private void A0z(int[] iArr) {
        int minPositionPreLayout = this.A01.A06();
        if (minPositionPreLayout == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int pos = Integer.MAX_VALUE;
        int i = Integer.MIN_VALUE;
        for (int i2 = 0; i2 < minPositionPreLayout; i2++) {
            C4W c4wA0G = A0G(this.A01.A0A(i2));
            if (!c4wA0G.A0i()) {
                int iA0J = c4wA0G.A0J();
                if (iA0J < pos) {
                    pos = iA0J;
                }
                if (iA0J > i) {
                    i = iA0J;
                }
            }
        }
        iArr[0] = pos;
        iArr[1] = i;
    }

    private boolean A10() {
        int iA06 = this.A01.A06();
        for (int i = 0; i < iA06; i++) {
            C4W c4wA0G = A0G(this.A01.A0A(i));
            if (c4wA0G != null && !c4wA0G.A0i() && c4wA0G.A0g()) {
                return true;
            }
        }
        return false;
    }

    private boolean A11() {
        return this.A05 != null && this.A06.A27();
    }

    private boolean A13(int i, int i2) {
        A0z(this.A14);
        int[] iArr = this.A14;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private final boolean A14(int nestedScrollAxis, int i) {
        C4E c4e = this.A06;
        if (c4e == null) {
            Log.e(A0J(1370, 12, 79), A0J(651, 89, 76));
            return false;
        }
        if (this.A0I) {
            return false;
        }
        boolean zA25 = c4e.A25();
        boolean zA26 = this.A06.A26();
        if (!zA25 || Math.abs(nestedScrollAxis) < this.A0y) {
            nestedScrollAxis = 0;
        }
        if (!zA26 || Math.abs(i) < this.A0y) {
            i = 0;
        }
        if ((nestedScrollAxis != 0 || i != 0) && !dispatchNestedPreFling(nestedScrollAxis, i)) {
            boolean z = zA25 || zA26;
            dispatchNestedFling(nestedScrollAxis, i, z);
            C4H c4h = this.A0g;
            if (c4h != null && c4h.A0D(nestedScrollAxis, i)) {
                return true;
            }
            if (z) {
                int i2 = 0;
                if (zA25) {
                    i2 = 0 | 1;
                }
                if (zA26) {
                    i2 |= 2;
                }
                A1x(i2, 1);
                int i3 = this.A0x;
                int iMax = Math.max(-i3, Math.min(nestedScrollAxis, i3));
                int i4 = this.A0x;
                this.A08.A0A(iMax, Math.max(-i4, Math.min(i, i4)));
                return true;
            }
        }
        return false;
    }

    private final boolean A15(int unconsumedY, int consumedX, MotionEvent motionEvent) {
        int i = 0;
        int i2 = 0;
        int iA1i = 0;
        int iA1j = 0;
        A1K();
        if (this.A04 != null) {
            A1L();
            A1M();
            C2G.A01(A0J(1361, 9, 75));
            A1m(this.A0s);
            if (unconsumedY != 0) {
                iA1i = this.A06.A1i(unconsumedY, this.A0r, this.A0s);
                i = unconsumedY - iA1i;
            }
            if (consumedX != 0) {
                iA1j = this.A06.A1j(consumedX, this.A0r, this.A0s);
                i2 = consumedX - iA1j;
            }
            C2G.A00();
            A1Q();
            A1N();
            A1s(false);
        }
        if (!this.A0v.isEmpty()) {
            invalidate();
        }
        if (A1y(iA1i, iA1j, i, i2, this.A17, 0)) {
            int consumedY = this.A0S;
            int[] iArr = this.A17;
            int unconsumedX = iArr[0];
            this.A0S = consumedY - unconsumedX;
            int consumedY2 = this.A0T;
            int unconsumedX2 = iArr[1];
            this.A0T = consumedY2 - unconsumedX2;
            if (motionEvent != null) {
                int unconsumedX3 = iArr[0];
                float f2 = unconsumedX3;
                int unconsumedX4 = iArr[1];
                motionEvent.offsetLocation(f2, unconsumedX4);
            }
            int[] iArr2 = this.A15;
            int i3 = iArr2[0];
            int[] iArr3 = this.A17;
            int unconsumedX5 = iArr3[0];
            int i4 = i3 + unconsumedX5;
            String[] strArr = A19;
            String str = strArr[6];
            String str2 = strArr[4];
            int consumedY3 = str.charAt(17);
            int unconsumedX6 = str2.charAt(17);
            if (consumedY3 != unconsumedX6) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[1] = "TzjapWGLjdNwrlMHhQTvw0KTjubTnl9R";
            strArr2[1] = "TzjapWGLjdNwrlMHhQTvw0KTjubTnl9R";
            iArr2[0] = i4;
            int consumedY4 = iArr2[1];
            int unconsumedX7 = iArr3[1];
            iArr2[1] = consumedY4 + unconsumedX7;
        } else {
            int consumedY5 = getOverScrollMode();
            if (consumedY5 != 2) {
                if (motionEvent != null && !C2Z.A00(motionEvent, m.a.p)) {
                    float x = motionEvent.getX();
                    float f3 = i;
                    float y = motionEvent.getY();
                    float f4 = i2;
                    int consumedY6 = A19[1].length();
                    if (consumedY6 != 32) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A19;
                    strArr3[1] = "Rb7Wd2rB1Bk4FJnk1H23iqiZozoKDKpI";
                    strArr3[1] = "Rb7Wd2rB1Bk4FJnk1H23iqiZozoKDKpI";
                    A0l(x, f3, y, f4);
                }
                A1a(unconsumedY, consumedX);
            }
        }
        if (iA1i != 0 || iA1j != 0) {
            A1c(iA1i, iA1j);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (iA1i == 0 && iA1j == 0) ? false : true;
    }

    private boolean A16(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.A0h != null) {
            if (action == 0) {
                this.A0h = null;
            } else {
                if (action == 3 || action == 1) {
                    this.A0h = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.A13.size();
            for (int i = 0; i < size; i++) {
                C4I c4i = this.A13.get(i);
                if (c4i.onInterceptTouchEvent(this, motionEvent)) {
                    this.A0h = c4i;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean A17(MotionEvent motionEvent) {
        int listenerCount = motionEvent.getAction();
        if (listenerCount == 3 || listenerCount == 0) {
            this.A0h = null;
        }
        int size = this.A13.size();
        for (int i = 0; i < size; i++) {
            C4I c4i = this.A13.get(i);
            if (c4i.onInterceptTouchEvent(this, motionEvent) && listenerCount != 3) {
                this.A0h = c4i;
                return true;
            }
        }
        return false;
    }

    private boolean A18(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i == 2 || i == 1) {
            if ((i == 2) ^ (this.A06.A0b() == 1)) {
                i2 = 66;
            } else {
                i2 = 17;
            }
            if (A19(view, view2, i2)) {
                return true;
            }
            if (i == 2) {
                return A19(view, view2, 130);
            }
            return A19(view, view2, 33);
        }
        return A19(view, view2, i);
    }

    private boolean A19(View view, View view2, int i) {
        this.A0p.set(0, 0, view.getWidth(), view.getHeight());
        this.A0z.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.A0p);
        offsetDescendantRectToMyCoords(view2, this.A0z);
        if (i == 17) {
            return (this.A0p.right > this.A0z.right || this.A0p.left >= this.A0z.right) && this.A0p.left > this.A0z.left;
        }
        String[] strArr = A19;
        if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A19;
        strArr2[1] = "Yc6OUsH3chOpt4vkJfacRirYduge3wUm";
        strArr2[1] = "Yc6OUsH3chOpt4vkJfacRirYduge3wUm";
        if (i == 33) {
            return (this.A0p.bottom > this.A0z.bottom || this.A0p.top >= this.A0z.bottom) && this.A0p.top > this.A0z.top;
        }
        if (i == 66) {
            return (this.A0p.left < this.A0z.left || this.A0p.right <= this.A0z.left) && this.A0p.right < this.A0z.right;
        }
        if (i == 130) {
            return (this.A0p.top < this.A0z.top || this.A0p.bottom <= this.A0z.top) && this.A0p.bottom < this.A0z.bottom;
        }
        throw new IllegalArgumentException(A0J(1844, 37, 102) + i + A1J());
    }

    private final boolean A1A(AccessibilityEvent accessibilityEvent) {
        if (A1v()) {
            int iA00 = 0;
            if (accessibilityEvent != null) {
                iA00 = C3C.A00(accessibilityEvent);
            }
            if (iA00 == 0) {
                iA00 = 0;
            }
            this.A0P |= iA00;
            return true;
        }
        return false;
    }

    public final int A1D(View view) {
        C4W c4wA0G = A0G(view);
        if (c4wA0G != null) {
            return c4wA0G.A0J();
        }
        return -1;
    }

    public final int A1E(C4W c4w) {
        if (!c4w.A0l(524) && c4w.A0b()) {
            return this.A00.A0F(c4w.A03);
        }
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "S0wUd1";
        strArr[7] = "zF1SY7WsjbFG";
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        if (r3 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Rect A1F(android.view.View r9) {
        /*
            r8 = this;
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            com.facebook.ads.redexgen.X.4F r6 = (com.facebook.ads.redexgen.X.C4F) r6
            boolean r0 = r6.A01
            if (r0 != 0) goto Ld
            android.graphics.Rect r0 = r6.A03
            return r0
        Ld:
            com.facebook.ads.redexgen.X.4T r0 = r8.A0s
            boolean r0 = r0.A07()
            if (r0 == 0) goto L44
            boolean r0 = r6.A01()
            if (r0 != 0) goto L41
            boolean r3 = r6.A03()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L33
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L33:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "R8RZJpxNRYJLmE7KdaIYiTLeL7r3Y7bS"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "BRrnvNJfpVwihHaR5a5gEdBxu0vp26qH"
            r0 = 4
            r2[r0] = r1
            if (r3 == 0) goto L44
        L41:
            android.graphics.Rect r0 = r6.A03
            return r0
        L44:
            android.graphics.Rect r5 = r6.A03
            r4 = 0
            r5.set(r4, r4, r4, r4)
            java.util.ArrayList<com.facebook.ads.redexgen.X.4B> r0 = r8.A0v
            int r3 = r0.size()
            r2 = 0
        L51:
            if (r2 >= r3) goto L8e
            android.graphics.Rect r0 = r8.A0p
            r0.set(r4, r4, r4, r4)
            java.util.ArrayList<com.facebook.ads.redexgen.X.4B> r0 = r8.A0v
            java.lang.Object r7 = r0.get(r2)
            com.facebook.ads.redexgen.X.4B r7 = (com.facebook.ads.redexgen.X.C4B) r7
            android.graphics.Rect r1 = r8.A0p
            com.facebook.ads.redexgen.X.4T r0 = r8.A0s
            r7.A01(r1, r9, r8, r0)
            int r1 = r5.left
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.left
            int r1 = r1 + r0
            r5.left = r1
            int r1 = r5.top
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.top
            int r1 = r1 + r0
            r5.top = r1
            int r1 = r5.right
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.right
            int r1 = r1 + r0
            r5.right = r1
            int r1 = r5.bottom
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.bottom
            int r1 = r1 + r0
            r5.bottom = r1
            int r2 = r2 + 1
            goto L51
        L8e:
            r6.A01 = r4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A1F(android.view.View):android.graphics.Rect");
    }

    @Nullable
    public final View A1G(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C4W A1H(int r9, boolean r10) {
        /*
            r8 = this;
            com.facebook.ads.redexgen.X.3c r0 = r8.A01
            int r6 = r0.A07()
            r1 = 0
            r5 = 0
        L8:
            if (r5 >= r6) goto L5f
            com.facebook.ads.redexgen.X.3c r0 = r8.A01
            android.view.View r0 = r0.A0B(r5)
            com.facebook.ads.redexgen.X.4W r4 = A0G(r0)
            if (r4 == 0) goto L22
            boolean r0 = r4.A0d()
            if (r0 != 0) goto L22
            if (r10 == 0) goto L25
            int r0 = r4.A03
            if (r0 == r9) goto L2c
        L22:
            int r5 = r5 + 1
            goto L8
        L25:
            int r0 = r4.A0J()
            if (r0 == r9) goto L2c
            goto L22
        L2c:
            com.facebook.ads.redexgen.X.3c r7 = r8.A01
            android.view.View r3 = r4.A0H
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 6
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L4a
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L4a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "j0pgcyCAMmCuelBFBaEKhw82BLWYdvOX"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "bxiKg4TrHtXBSvyNTaSo7IOhyUGlGIW4"
            r0 = 4
            r2[r0] = r1
            boolean r0 = r7.A0L(r3)
            if (r0 == 0) goto L5e
            r1 = r4
            goto L22
        L5e:
            return r4
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A1H(int, boolean):com.facebook.ads.redexgen.X.4W");
    }

    public final C4W A1I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return A0G(view);
        }
        throw new IllegalArgumentException(A0J(1826, 5, 56) + view + A0J(98, 26, 127) + this);
    }

    public final String A1J() {
        return A0J(0, 1, 65) + super.toString() + A0J(169, 10, 82) + this.A04 + A0J(189, 9, 71) + this.A06 + A0J(179, 10, 10) + getContext();
    }

    public final void A1K() {
        boolean z = this.A0D;
        String strA0J = A0J(1313, 17, 94);
        if (!z || this.A0C) {
            C2G.A01(strA0J);
            A0a();
            C2G.A00();
            return;
        }
        if (!this.A00.A0K()) {
            return;
        }
        if (this.A00.A0M(4)) {
            boolean zA0M = this.A00.A0M(11);
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[6] = "e84NaKOnn7I9zpRn8aasqpcOMtbsg9mo";
            strArr[4] = "iuEMZhfSQYSf3gJ7Ya7A7FZe771rQXKi";
            if (!zA0M) {
                C2G.A01(A0J(1341, 20, 82));
                A1L();
                A1M();
                this.A00.A0I();
                if (!this.A0J) {
                    if (A10()) {
                        A0a();
                    } else {
                        this.A00.A0G();
                    }
                }
                A1s(true);
                A1N();
                C2G.A00();
                return;
            }
        }
        if (this.A00.A0K()) {
            C2G.A01(strA0J);
            A0a();
            C2G.A00();
        }
    }

    public final void A1L() {
        this.A0O++;
        if (this.A0O == 1 && !this.A0I) {
            this.A0J = false;
        }
    }

    public final void A1M() {
        this.A0U++;
    }

    public final void A1N() {
        A1r(true);
    }

    public final void A1O() {
        if (!this.A0K && this.A0F) {
            C2t.A0C(this, this.A0k);
            this.A0K = true;
        }
    }

    public final void A1P() {
        C4A c4a = this.A05;
        if (c4a != null) {
            c4a.A0C();
        }
        C4E c4e = this.A06;
        if (c4e != null) {
            c4e.A1J(this.A0r);
            this.A06.A1H(this.A0r);
        }
        this.A0r.A0Q();
    }

    public final void A1Q() {
        int iA06 = this.A01.A06();
        for (int i = 0; i < iA06; i++) {
            View viewA0A = this.A01.A0A(i);
            C4W c4wA1I = A1I(viewA0A);
            if (c4wA1I != null && c4wA1I.A07 != null) {
                View view = c4wA1I.A07.A0H;
                int left = viewA0A.getLeft();
                int top = viewA0A.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    int width = view.getWidth();
                    String[] strArr = A19;
                    String str = strArr[2];
                    String str2 = strArr[7];
                    int top2 = str.length();
                    if (top2 == str2.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A19;
                    strArr2[3] = "Uubm7UlJXcXPQblsDCbwus";
                    strArr2[0] = "kvvVMTFBun";
                    view.layout(left, top, width + left, view.getHeight() + top);
                }
            }
        }
    }

    public final void A1R() {
        this.A0C = true;
        A0j();
    }

    public final void A1S() {
        setScrollState(0);
        A0W();
    }

    public final void A1T(int i) {
        C4E c4e = this.A06;
        if (c4e == null) {
            return;
        }
        c4e.A1u(i);
        awakenScrollBars();
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "0QEBPr";
        strArr[7] = "MYIDRbA0xlXg";
    }

    public final void A1U(int i) {
        int iA06 = this.A01.A06();
        for (int i2 = 0; i2 < iA06; i2++) {
            this.A01.A0A(i2).offsetLeftAndRight(i);
        }
    }

    public final void A1V(int i) {
        int iA06 = this.A01.A06();
        for (int i2 = 0; i2 < iA06; i2++) {
            this.A01.A0A(i2).offsetTopAndBottom(i);
        }
    }

    public final void A1W(int i) {
        if (this.A0I) {
            return;
        }
        A1S();
        C4E c4e = this.A06;
        if (c4e == null) {
            String strA0J = A0J(1370, 12, 79);
            String[] strArr = A19;
            if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "bKq2dxkRCeugdKx9Xa6GvrcP2g1fh08B";
            strArr2[4] = "kU2aPHyT0THRQATybaGwdbwAtHBBu9qc";
            Log.e(strA0J, A0J(740, 94, 69));
            return;
        }
        c4e.A1u(i);
        awakenScrollBars();
    }

    public final void A1X(int i) {
        if (this.A0I) {
            return;
        }
        C4E c4e = this.A06;
        String[] strArr = A19;
        if (strArr[3].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A19;
        strArr2[6] = "WdHf0lV4QkHUB6jMNa4hJVyYAF4qnaeC";
        strArr2[4] = "5gGhKJie0DBDDFfkhapEv4fZOrT4upMj";
        if (c4e != null) {
            c4e.A22(this, this.A0s, i);
            return;
        }
        String[] strArr3 = A19;
        if (strArr3[6].charAt(17) != strArr3[4].charAt(17)) {
            String[] strArr4 = A19;
            strArr4[6] = "tnW8WJDd0hyAXA7zkanproBVQy0r1bMC";
            strArr4[4] = "4Fp0w8uFB0Hn5lDXLaIQvmhL07bdVyXH";
            Log.e(A0J(1370, 10, 13), A0J(858, 46, 16));
            return;
        }
        String[] strArr5 = A19;
        strArr5[3] = "z3A7CLBHtBtrAEYqxn9jPo";
        strArr5[0] = "loKczzo2gT";
        Log.e(A0J(1370, 12, 79), A0J(924, 97, 75));
    }

    public final void A1Y(int i) {
        getScrollingChildHelper().A04(i);
    }

    public final void A1Z(int i, int i2) {
        if (i < 0) {
            A0d();
            this.A0a.onAbsorb(-i);
        } else if (i > 0) {
            A0e();
            this.A0b.onAbsorb(i);
        }
        if (i2 < 0) {
            A0f();
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[1] = "gyhAwDIMjNJoK3bJ2ki6wxmL7XFPannX";
            strArr[1] = "gyhAwDIMjNJoK3bJ2ki6wxmL7XFPannX";
            this.A0c.onAbsorb(-i2);
        } else if (i2 > 0) {
            A0c();
            this.A0Z.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            C2t.A07(this);
        }
    }

    public final void A1a(int i, int i2) {
        boolean zIsFinished = false;
        EdgeEffect edgeEffect = this.A0a;
        if (edgeEffect != null && !edgeEffect.isFinished() && i > 0) {
            this.A0a.onRelease();
            zIsFinished = this.A0a.isFinished();
        }
        EdgeEffect edgeEffect2 = this.A0b;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.A0b.onRelease();
            zIsFinished |= this.A0b.isFinished();
        }
        EdgeEffect edgeEffect3 = this.A0c;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            EdgeEffect edgeEffect4 = this.A0c;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "CkvbraPTkuNHVjG6c5toq1";
            strArr[0] = "anwNoWvWLV";
            edgeEffect4.onRelease();
            zIsFinished |= this.A0c.isFinished();
        }
        EdgeEffect edgeEffect5 = this.A0Z;
        if (edgeEffect5 != null && !edgeEffect5.isFinished() && i2 < 0) {
            this.A0Z.onRelease();
            zIsFinished |= this.A0Z.isFinished();
        }
        if (zIsFinished) {
            C2t.A07(this);
        }
    }

    public final void A1b(int i, int i2) {
        setMeasuredDimension(C4E.A00(i, getPaddingLeft() + getPaddingRight(), C2t.A03(this)), C4E.A00(i2, getPaddingTop() + getPaddingBottom(), C2t.A02(this)));
    }

    public final void A1c(int scrollY, int i) {
        this.A0N++;
        int scrollX = getScrollX();
        int scrollY2 = getScrollY();
        onScrollChanged(scrollX, scrollY2, scrollX, scrollY2);
        C4J c4j = this.A0i;
        if (c4j != null) {
            c4j.A0W(this, scrollY, i);
        }
        List<C4J> list = this.A0m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.A0m.get(size).A0W(this, scrollY, i);
            }
        }
        this.A0N--;
    }

    public final void A1d(int i, int i2) {
        int iA07 = this.A01.A07();
        for (int i3 = 0; i3 < iA07; i3++) {
            C4W c4wA0G = A0G(this.A01.A0B(i3));
            if (c4wA0G != null && !c4wA0G.A0i()) {
                int i4 = c4wA0G.A03;
                if (A19[5].charAt(2) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[1] = "WfIl2QLxhpsV1cZ5bwDa0wyCBTSIuEWm";
                strArr[1] = "WfIl2QLxhpsV1cZ5bwDa0wyCBTSIuEWm";
                if (i4 >= i) {
                    c4wA0G.A0X(i2, false);
                    this.A0s.A0D = true;
                }
            }
        }
        this.A0r.A0S(i, i2);
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1e(int r12, int r13) {
        /*
            r11 = this;
            com.facebook.ads.redexgen.X.3c r0 = r11.A01
            int r7 = r0.A07()
            if (r12 >= r13) goto L7c
            r6 = r12
            r5 = r13
            r4 = -1
        Lb:
            r3 = 0
        Lc:
            if (r3 >= r7) goto L80
            com.facebook.ads.redexgen.X.3c r0 = r11.A01
            android.view.View r0 = r0.A0B(r3)
            com.facebook.ads.redexgen.X.4W r9 = A0G(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L2c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2c:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "SA2Eyd"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "XMtlHmP9rGs3"
            r0 = 7
            r2[r0] = r1
            if (r9 == 0) goto L42
            int r0 = r9.A03
            if (r0 < r6) goto L42
            int r0 = r9.A03
            if (r0 <= r5) goto L45
        L42:
            int r3 = r3 + 1
            goto Lc
        L45:
            int r10 = r9.A03
            r8 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 6
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L69
            if (r10 != r12) goto L78
        L5e:
            int r0 = r13 - r12
            r9.A0X(r0, r8)
        L63:
            com.facebook.ads.redexgen.X.4T r1 = r11.A0s
            r0 = 1
            r1.A0D = r0
            goto L42
        L69:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "BcaezuMb6aDfAWKozakh45MfYrs0kuIc"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "5erwLY6dW1OUzDMynaZgWLcHWlHtC3ze"
            r0 = 4
            r2[r0] = r1
            if (r10 != r12) goto L78
            goto L5e
        L78:
            r9.A0X(r4, r8)
            goto L63
        L7c:
            r6 = r13
            r5 = r12
            r4 = 1
            goto Lb
        L80:
            com.facebook.ads.redexgen.X.4M r0 = r11.A0r
            r0.A0T(r12, r13)
            r11.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.A1e(int, int):void");
    }

    public final void A1f(int i, int i2) {
        A0n(i, i2, null);
    }

    public final void A1g(int positionEnd, int i, Object obj) {
        int iA07 = this.A01.A07();
        int i2 = positionEnd + i;
        for (int i3 = 0; i3 < iA07; i3++) {
            View viewA0B = this.A01.A0B(i3);
            C4W c4wA0G = A0G(viewA0B);
            if (c4wA0G != null && !c4wA0G.A0i()) {
                int i4 = c4wA0G.A03;
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[2] = "87XYbE";
                strArr[7] = "GV1T0vfadOcw";
                if (i4 >= positionEnd && c4wA0G.A03 < i2) {
                    c4wA0G.A0U(2);
                    c4wA0G.A0Z(obj);
                    ((C4F) viewA0B.getLayoutParams()).A01 = true;
                }
            }
        }
        this.A0r.A0U(positionEnd, i);
    }

    public final void A1h(int childCount, int i, boolean z) {
        int i2 = childCount + i;
        int iA07 = this.A01.A07();
        for (int i3 = 0; i3 < iA07; i3++) {
            C4W c4wA0G = A0G(this.A01.A0B(i3));
            if (c4wA0G != null && !c4wA0G.A0i()) {
                if (c4wA0G.A03 >= i2) {
                    c4wA0G.A0X(-i, z);
                    this.A0s.A0D = true;
                } else if (c4wA0G.A03 >= childCount) {
                    c4wA0G.A0W(childCount - 1, -i, z);
                    if (A19[1].length() != 32) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A19;
                    strArr[2] = "dcjb0S";
                    strArr[7] = "CcIDXd599Ygw";
                    this.A0s.A0D = true;
                } else {
                    continue;
                }
            }
        }
        this.A0r.A0V(childCount, i, z);
        requestLayout();
    }

    public final void A1i(View view) {
        int i;
        A0G(view);
        AnonymousClass42 anonymousClass42 = this.A04;
        List<RecyclerView.OnChildAttachStateChangeListener> list = this.A0l;
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[5] = "qDYnzfveQxKkK3O0opuqDthRtcgsED9a";
        strArr[5] = "qDYnzfveQxKkK3O0opuqDthRtcgsED9a";
        if (list != null && list.size() - 1 >= 0) {
            this.A0l.get(i);
            throw null;
        }
    }

    public final void A1j(View view) {
        int i;
        A0G(view);
        AnonymousClass42 anonymousClass42 = this.A04;
        if (this.A0l != null && r0.size() - 1 >= 0) {
            this.A0l.get(i);
            throw null;
        }
    }

    public final void A1k(C4J c4j) {
        if (this.A0m == null) {
            this.A0m = new ArrayList();
        }
        this.A0m.add(c4j);
    }

    public final void A1l(C4J c4j) {
        List<C4J> list = this.A0m;
        if (list != null) {
            list.remove(c4j);
        }
    }

    public final void A1m(C4T c4t) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.A08.A01;
            c4t.A06 = overScroller.getFinalX() - overScroller.getCurrX();
            c4t.A07 = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            c4t.A06 = 0;
            c4t.A07 = 0;
        }
    }

    public final void A1n(C4W c4w, AnonymousClass49 anonymousClass49) {
        c4w.A0V(0, 8192);
        if (this.A0s.A0E && c4w.A0g() && !c4w.A0d() && !c4w.A0i()) {
            this.A0t.A09(A0C(c4w), c4w);
        }
        this.A0t.A0G(c4w, anonymousClass49);
    }

    public final void A1o(@NonNull C4W c4w, @Nullable AnonymousClass49 anonymousClass49, @NonNull AnonymousClass49 anonymousClass492) {
        c4w.A0a(false);
        if (this.A05.A0I(c4w, anonymousClass49, anonymousClass492)) {
            A1O();
        }
    }

    public final void A1p(@NonNull C4W c4w, @NonNull AnonymousClass49 anonymousClass49, @Nullable AnonymousClass49 anonymousClass492) {
        A0t(c4w);
        c4w.A0a(false);
        if (this.A05.A0J(c4w, anonymousClass49, anonymousClass492)) {
            A1O();
        }
    }

    public final void A1q(String str) {
        if (A1v()) {
            if (str == null) {
                throw new IllegalStateException(A0J(574, 77, 49) + A1J());
            }
            throw new IllegalStateException(str);
        }
        if (this.A0N > 0) {
            Log.w(A0J(1370, 12, 79), A0J(294, 280, 24), new IllegalStateException(A0J(0, 0, 62) + A1J()));
        }
    }

    public final void A1r(boolean z) {
        this.A0U--;
        if (this.A0U < 1) {
            this.A0U = 0;
            if (z) {
                A0L();
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[6] = "clcdgLago0QzUCUQna9RqUvMnx3zufId";
                strArr[4] = "dGTmnJIudyc2xKqsUaVYnInX4VXDIHXZ";
                A0b();
            }
        }
    }

    public final void A1s(boolean z) {
        if (this.A0O < 1) {
            this.A0O = 1;
        }
        if (!z) {
            this.A0J = false;
        }
        if (this.A0O == 1) {
            if (z && this.A0J && !this.A0I && this.A06 != null && this.A04 != null) {
                A0a();
            }
            if (!this.A0I) {
                this.A0J = false;
            }
        }
        this.A0O--;
    }

    public final boolean A1t() {
        AccessibilityManager accessibilityManager = this.A10;
        if (accessibilityManager != null) {
            boolean zIsEnabled = accessibilityManager.isEnabled();
            String[] strArr = A19;
            if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[5] = "qqYNnQooq1iBe19qNxONRBmcR9jcXf5d";
            strArr2[5] = "qqYNnQooq1iBe19qNxONRBmcR9jcXf5d";
            if (zIsEnabled) {
                return true;
            }
        }
        return false;
    }

    public final boolean A1u() {
        return !this.A0D || this.A0C || this.A00.A0K();
    }

    public final boolean A1v() {
        return this.A0U > 0;
    }

    public final boolean A1w(int i) {
        return getScrollingChildHelper().A0A(i);
    }

    public final boolean A1x(int i, int i2) {
        return getScrollingChildHelper().A0C(i, i2);
    }

    public final boolean A1y(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().A0E(i, i2, i3, i4, iArr, i5);
    }

    public final boolean A1z(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().A0G(i, i2, iArr, iArr2, i3);
    }

    public final boolean A20(View view) {
        A1L();
        boolean zA0M = this.A01.A0M(view);
        if (zA0M) {
            C4W c4wA0G = A0G(view);
            this.A0r.A0d(c4wA0G);
            this.A0r.A0c(c4wA0G);
        }
        A1s(!zA0M);
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[3] = "2BT72D7B0XXfHPWJs3DbS8";
        strArr[0] = "RgGvPpmRJD";
        return zA0M;
    }

    public final boolean A21(C4W c4w) {
        C4A c4a = this.A05;
        return c4a == null || c4a.A0G(c4w, c4w.A0M());
    }

    @VisibleForTesting
    public final boolean A22(C4W c4w, int i) {
        if (A1v()) {
            c4w.A02 = i;
            this.A0w.add(c4w);
            return false;
        }
        C2t.A09(c4w.A0H, i);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        C4E c4e = this.A06;
        if (c4e != null) {
            boolean zA1h = c4e.A1h(this, arrayList, i, i2);
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[2] = "qzNrCd";
            strArr[7] = "bMAkXN6Kp1Dd";
            if (zA1h) {
                return;
            }
        }
        super.addFocusables(arrayList, i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C4F) && this.A06.A1d((C4F) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        C4E c4e = this.A06;
        if (c4e != null && c4e.A25()) {
            return this.A06.A1k(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        C4E c4e = this.A06;
        if (c4e != null && c4e.A25()) {
            return this.A06.A1l(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        C4E c4e = this.A06;
        if (c4e == null) {
            return 0;
        }
        boolean zA25 = c4e.A25();
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[1] = "GzwOa56ahdwGOmec9vc3XIggLcxaXOnz";
        strArr[1] = "GzwOa56ahdwGOmec9vc3XIggLcxaXOnz";
        if (zA25) {
            return this.A06.A1m(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        C4E c4e = this.A06;
        if (c4e == null) {
            return 0;
        }
        boolean zA26 = c4e.A26();
        String[] strArr = A19;
        if (strArr[3].length() != strArr[0].length()) {
            String[] strArr2 = A19;
            strArr2[2] = "Wsbuah";
            strArr2[7] = "lDl9g1VSjrmk";
            if (!zA26) {
                return 0;
            }
            C4E c4e2 = this.A06;
            String[] strArr3 = A19;
            if (strArr3[3].length() != strArr3[0].length()) {
                String[] strArr4 = A19;
                strArr4[5] = "sfYwg45p3roym5legx720iFNlg07mmUN";
                strArr4[5] = "sfYwg45p3roym5legx720iFNlg07mmUN";
                return c4e2.A1n(this.A0s);
            }
        }
        throw new RuntimeException();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        C4E c4e = this.A06;
        if (c4e != null && c4e.A26()) {
            return this.A06.A1o(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        C4E c4e = this.A06;
        if (c4e == null || !c4e.A26()) {
            return 0;
        }
        C4E c4e2 = this.A06;
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[6] = "NPPquBudgt65Kfhzva46C14iIBYgw5ng";
        strArr[4] = "gzaMlk0wrsXS1BjbnaI8sjsGlzE0u55w";
        return c4e2.A1p(this.A0s);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().A09(f2, f3, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().A08(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().A0F(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().A0D(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0159  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r8) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View focusSearch(android.view.View r9, int r10) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.focusSearch(android.view.View, int):android.view.View");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C4E c4e = this.A06;
        if (c4e != null) {
            return c4e.A1t();
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1J());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        C4E c4e = this.A06;
        if (c4e != null) {
            return c4e.A0w(getContext(), attributeSet);
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1J());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C4E c4e = this.A06;
        if (c4e != null) {
            C4F c4fA0x = c4e.A0x(layoutParams);
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "4uZ9QAUZcjEo06EXHPHPN1";
            strArr[0] = "ePNmh1lbEA";
            return c4fA0x;
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1J());
    }

    public AnonymousClass42 getAdapter() {
        return this.A04;
    }

    @Override // android.view.View
    public int getBaseline() {
        C4E c4e = this.A06;
        if (c4e != null) {
            int iA0W = c4e.A0W();
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[1] = "WUntfQVcja1qFzj09nDprclvV6sI7lKs";
            strArr[1] = "WUntfQVcja1qFzj09nDprclvV6sI7lKs";
            return iA0W;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        AnonymousClass45 anonymousClass45 = this.A0e;
        if (anonymousClass45 == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return anonymousClass45.onGetChildDrawingOrder(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.A0B;
    }

    public C1928Sh getCompatAccessibilityDelegate() {
        return this.A09;
    }

    public C4A getItemAnimator() {
        return this.A05;
    }

    public C4E getLayoutManager() {
        return this.A06;
    }

    public int getMaxFlingVelocity() {
        return this.A0x;
    }

    public int getMinFlingVelocity() {
        return this.A0y;
    }

    public long getNanoTime() {
        if (A1E) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public C4H getOnFlingListener() {
        return this.A0g;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.A0o;
    }

    public C4L getRecycledViewPool() {
        return this.A0r.A0I();
    }

    public int getScrollState() {
        return this.A0W;
    }

    private C12922b getScrollingChildHelper() {
        if (this.A0d == null) {
            this.A0d = new C12922b(this);
        }
        return this.A0d;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().A06();
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.A0F;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().A07();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0U = 0;
        boolean z = true;
        this.A0F = true;
        if (!this.A0D || isLayoutRequested()) {
            z = false;
        }
        this.A0D = z;
        C4E c4e = this.A06;
        if (c4e != null) {
            c4e.A1O(this);
        }
        this.A0K = false;
        if (A1E) {
            this.A03 = RunnableC13303p.A07.get();
            if (this.A03 == null) {
                this.A03 = new RunnableC13303p();
                Display displayA04 = C2t.A04(this);
                float f2 = 60.0f;
                if (!isInEditMode() && displayA04 != null) {
                    float refreshRate = displayA04.getRefreshRate();
                    String[] strArr = A19;
                    if (strArr[2].length() == strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A19;
                    strArr2[3] = "HPKMSTrO6rgllPECADdom7";
                    strArr2[0] = "yPSN9KqlOS";
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                this.A03.A00 = (long) (1.0E9f / f2);
                RunnableC13303p.A07.set(this.A03);
            }
            this.A03.A0A(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        RunnableC13303p runnableC13303p;
        super.onDetachedFromWindow();
        C4A c4a = this.A05;
        if (c4a != null) {
            c4a.A0C();
        }
        A1S();
        this.A0F = false;
        C4E c4e = this.A06;
        if (c4e != null) {
            c4e.A1V(this, this.A0r);
        }
        this.A0w.clear();
        removeCallbacks(this.A0k);
        this.A0t.A08();
        if (A1E && (runnableC13303p = this.A03) != null) {
            runnableC13303p.A0B(this);
            this.A03 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.A0v.size();
        for (int i = 0; i < size; i++) {
            this.A0v.get(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.4E r0 = r6.A06
            r5 = 0
            if (r0 != 0) goto L6
            return r5
        L6:
            boolean r3 = r6.A0I
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto L1b
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "hfCCVZ"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "6Rxn0wTGDCgs"
            r0 = 7
            r2[r0] = r1
            if (r3 == 0) goto L2a
            return r5
        L2a:
            int r1 = r7.getAction()
            r0 = 8
            if (r1 != r0) goto L6b
            int r0 = r7.getSource()
            r0 = r0 & 2
            if (r0 == 0) goto L70
            com.facebook.ads.redexgen.X.4E r0 = r6.A06
            boolean r0 = r0.A26()
            if (r0 == 0) goto L6e
            r0 = 9
            float r0 = r7.getAxisValue(r0)
            float r0 = -r0
        L49:
            com.facebook.ads.redexgen.X.4E r1 = r6.A06
            boolean r1 = r1.A25()
            if (r1 == 0) goto L6c
            r1 = 10
            float r1 = r7.getAxisValue(r1)
        L57:
            r3 = 0
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L60
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 == 0) goto L6b
        L60:
            float r2 = r6.A0L
            float r2 = r2 * r1
            int r2 = (int) r2
            float r1 = r6.A0M
            float r1 = r1 * r0
            int r0 = (int) r1
            r6.A15(r2, r0, r7)
        L6b:
            return r5
        L6c:
            r1 = 0
            goto L57
        L6e:
            r0 = 0
            goto L49
        L70:
            int r4 = r7.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.EI.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L98
            r4 = r4 & r3
            if (r4 == 0) goto Lb5
        L87:
            r0 = 26
            float r1 = r7.getAxisValue(r0)
            com.facebook.ads.redexgen.X.4E r0 = r6.A06
            boolean r0 = r0.A26()
            if (r0 == 0) goto La8
            float r0 = -r1
            r1 = 0
            goto L57
        L98:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.EI.A19
            java.lang.String r1 = "SrYzqcFycO4E61WX0CCI79FBiQDWLxq8"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "SrYzqcFycO4E61WX0CCI79FBiQDWLxq8"
            r0 = 5
            r2[r0] = r1
            r4 = r4 & r3
            if (r4 == 0) goto Lb5
            goto L87
        La8:
            com.facebook.ads.redexgen.X.4E r0 = r6.A06
            boolean r0 = r0.A25()
            if (r0 == 0) goto Lb2
            r0 = 0
            goto L57
        Lb2:
            r0 = 0
            r1 = 0
            goto L57
        Lb5:
            r0 = 0
            r1 = 0
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.A0I) {
            return false;
        }
        if (A17(motionEvent)) {
            A0K();
            return true;
        }
        C4E c4e = this.A06;
        if (c4e == null) {
            return false;
        }
        boolean zA25 = c4e.A25();
        boolean zA26 = this.A06.A26();
        if (this.A0Y == null) {
            this.A0Y = VelocityTracker.obtain();
        }
        this.A0Y.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        String[] strArr = A19;
        String str = strArr[2];
        String str2 = strArr[7];
        int length = str.length();
        int action = str2.length();
        if (length == action) {
            throw new RuntimeException();
        }
        String[] strArr2 = A19;
        strArr2[3] = "Oz3Y31ex0QABqFtFM6aXix";
        strArr2[0] = "OpGO9pAa6R";
        if (actionMasked == 0) {
            boolean startScroll = this.A0n;
            if (startScroll) {
                this.A0n = false;
            }
            this.A0V = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.A0S = x;
            this.A0Q = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.A0T = y;
            this.A0R = y;
            if (this.A0W == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.A15;
            iArr[1] = 0;
            iArr[0] = 0;
            int nestedScrollAxis = 0;
            if (zA25) {
                nestedScrollAxis = 0 | 1;
            }
            if (zA26) {
                nestedScrollAxis |= 2;
            }
            A1x(nestedScrollAxis, 0);
        } else if (actionMasked == 1) {
            this.A0Y.clear();
            A1Y(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.A0V);
            if (iFindPointerIndex < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(A0J(1063, 46, 50));
                int index = this.A0V;
                sb.append(index);
                sb.append(A0J(124, 45, 46));
                Log.e(A0J(1370, 12, 79), sb.toString());
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int x3 = this.A0W;
            if (x3 != 1) {
                int x4 = this.A0Q;
                int i = x2 - x4;
                int x5 = this.A0R;
                int i2 = y2 - x5;
                boolean z = false;
                if (zA25 && Math.abs(i) > this.A0X) {
                    this.A0S = x2;
                    z = true;
                }
                if (zA26 && Math.abs(i2) > this.A0X) {
                    this.A0T = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            A0K();
        } else if (actionMasked == 5) {
            this.A0V = motionEvent.getPointerId(actionIndex);
            int x6 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.A0S = x6;
            this.A0Q = x6;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.A0T = y3;
            this.A0R = y3;
        } else if (actionMasked == 6) {
            A0p(motionEvent);
        }
        int action2 = this.A0W;
        return action2 == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C2G.A01(A0J(1330, 11, 86));
        A0a();
        C2G.A00();
        this.A0D = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
    
        if (r3 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
    
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00df, code lost:
    
        if (r3 != false) goto L39;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (A1v()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof RecyclerView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.A0j = (RecyclerView$SavedState) parcelable;
        super.onRestoreInstanceState(this.A0j.A02());
        if (this.A06 != null && this.A0j.A00 != null) {
            this.A06.A1x(this.A0j.A00);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        RecyclerView$SavedState recyclerView$SavedState = new RecyclerView$SavedState(super.onSaveInstanceState());
        RecyclerView$SavedState recyclerView$SavedState2 = this.A0j;
        if (recyclerView$SavedState2 != null) {
            recyclerView$SavedState.A03(recyclerView$SavedState2);
        } else {
            C4E c4e = this.A06;
            if (c4e != null) {
                recyclerView$SavedState.A00 = c4e.A1q();
            } else {
                recyclerView$SavedState.A00 = null;
            }
        }
        return recyclerView$SavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            A0h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0220  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EI.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        C4W c4wA0G = A0G(view);
        if (c4wA0G != null) {
            if (c4wA0G.A0f()) {
                c4wA0G.A0Q();
            } else if (!c4wA0G.A0i()) {
                throw new IllegalArgumentException(A0J(219, 75, 37) + c4wA0G + A1J());
            }
        }
        view.clearAnimation();
        A1j(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!this.A06.A1g(this, this.A0s, view, view2) && view2 != null) {
            A0r(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.A06.A1e(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.A13.size();
        for (int i = 0; i < size; i++) {
            this.A13.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.A0O == 0 && !this.A0I) {
            super.requestLayout();
        } else {
            this.A0J = true;
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        C4E c4e = this.A06;
        if (c4e == null) {
            Log.e(A0J(1370, 12, 79), A0J(834, 90, 71));
            return;
        }
        if (this.A0I) {
            return;
        }
        boolean zA25 = c4e.A25();
        boolean zA26 = this.A06.A26();
        if (zA25 || zA26) {
            if (!zA25) {
                i = 0;
            }
            A15(i, zA26 ? i2 : 0, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        Log.w(A0J(1370, 12, 79), A0J(1382, 93, 90));
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (A1A(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C1928Sh c1928Sh) {
        this.A09 = c1928Sh;
        C2t.A0A(this, this.A09);
    }

    public void setAdapter(AnonymousClass42 anonymousClass42) {
        setLayoutFrozen(false);
        A0s(anonymousClass42, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(AnonymousClass45 anonymousClass45) {
        if (anonymousClass45 == this.A0e) {
            return;
        }
        this.A0e = anonymousClass45;
        setChildrenDrawingOrderEnabled(this.A0e != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.A0B) {
            A0h();
        }
        this.A0B = z;
        super.setClipToPadding(z);
        if (this.A0D) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.A0E = z;
    }

    public void setItemAnimator(C4A c4a) {
        C4A c4a2 = this.A05;
        if (c4a2 != null) {
            c4a2.A0C();
            this.A05.A0A(null);
        }
        this.A05 = c4a;
        C4A c4a3 = this.A05;
        if (c4a3 != null) {
            AnonymousClass48 anonymousClass48 = this.A0f;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "lbql160khUomfa8gG92Y7q";
            strArr[0] = "AtGY6u7EZb";
            c4a3.A0A(anonymousClass48);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.A0r.A0R(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.A0I) {
            A1q(A0J(1021, 42, 85));
            if (!z) {
                this.A0I = false;
                if (this.A0J && this.A06 != null && this.A04 != null) {
                    requestLayout();
                }
                this.A0J = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent cancelEvent = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
            onTouchEvent(cancelEvent);
            this.A0I = true;
            this.A0n = true;
            A1S();
        }
    }

    public void setLayoutManager(C4E c4e) {
        if (c4e == this.A06) {
            return;
        }
        A1S();
        if (this.A06 != null) {
            C4A c4a = this.A05;
            if (c4a != null) {
                c4a.A0C();
            }
            this.A06.A1J(this.A0r);
            this.A06.A1H(this.A0r);
            this.A0r.A0Q();
            if (this.A0F) {
                this.A06.A1V(this, this.A0r);
            }
            this.A06.A1Q(null);
            this.A06 = null;
        } else {
            this.A0r.A0Q();
        }
        this.A01.A0C();
        this.A06 = c4e;
        if (c4e != null) {
            EI ei = c4e.A03;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[6] = "5zwSvF43vthb6lIFeaOoDRJ244Dq07FI";
            strArr[4] = "COyIsU8he0MLuT7wFa9x9SZ5A7LzgdfA";
            if (ei == null) {
                this.A06.A1Q(this);
                if (this.A0F) {
                    this.A06.A1O(this);
                }
            } else {
                throw new IllegalArgumentException(A0J(1109, 14, 88) + c4e + A0J(59, 39, 9) + c4e.A03.A1J());
            }
        }
        this.A0r.A0P();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().A05(z);
    }

    public void setOnFlingListener(@Nullable C4H c4h) {
        this.A0g = c4h;
    }

    @Deprecated
    public void setOnScrollListener(C4J c4j) {
        this.A0i = c4j;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.A0o = z;
    }

    public void setRecycledViewPool(C4L c4l) {
        this.A0r.A0a(c4l);
    }

    public void setRecyclerListener(C4N c4n) {
        this.A07 = c4n;
    }

    public void setScrollState(int i) {
        if (i == this.A0W) {
            return;
        }
        this.A0W = i;
        if (i != 2) {
            A0W();
        }
        A0m(i);
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w(A0J(1370, 12, 79), A0J(1881, 47, 18) + i + A0J(198, 21, 121));
            } else {
                this.A0X = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.A0X = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(C4U c4u) {
        this.A0r.A0b(c4u);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().A0B(i);
    }

    @Override // android.view.View, com.facebook.ads.redexgen.X.InterfaceC12912a
    public final void stopNestedScroll() {
        getScrollingChildHelper().A03();
    }
}
