package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.view.C0313a;
import androidx.core.view.accessibility.b;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.common.dlog.DLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f1209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f1211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f1212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static WeakHashMap<View, String> f1213f;
    private static Field h;
    private static ThreadLocal<Rect> j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f1208a = new AtomicInteger(1);
    private static WeakHashMap<View, F> g = null;
    private static boolean i = false;
    private static final int[] k = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    private static AccessibilityPaneVisibilityManager l = new AccessibilityPaneVisibilityManager();

    static class AccessibilityPaneVisibilityManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1214a = new WeakHashMap<>();

        AccessibilityPaneVisibilityManager() {
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    ViewCompat.a(view, 16);
                }
                this.f1214a.put(view, Boolean.valueOf(z2));
            }
        }

        private void registerForLayoutCallback(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void unregisterForLayoutCallback(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.f1214a.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            registerForLayoutCallback(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f1216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1217c;

        a(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= 19;
        }

        abstract T a(View view);

        abstract void a(View view, T t);

        abstract boolean a(T t, T t2);

        void b(View view, T t) {
            if (b()) {
                a(view, (Object) t);
            } else if (a() && a(b(view), t)) {
                ViewCompat.p(view);
                view.setTag(this.f1215a, t);
                ViewCompat.a(view, 0);
            }
        }

        a(int i, Class<T> cls, int i2, int i3) {
            this.f1215a = i;
            this.f1216b = cls;
            this.f1217c = i3;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        T b(View view) {
            if (b()) {
                return a(view);
            }
            if (!a()) {
                return null;
            }
            T t = (T) view.getTag(this.f1215a);
            if (this.f1216b.isInstance(t)) {
                return t;
            }
            return null;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f1217c;
        }
    }

    public interface b {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    protected ViewCompat() {
    }

    public static boolean A(View view) {
        Boolean boolB = b().b(view);
        if (boolB == null) {
            return false;
        }
        return boolB.booleanValue();
    }

    public static boolean B(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean C(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean D(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof l) {
            return ((l) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean E(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static boolean F(View view) {
        Boolean boolB = e().b(view);
        if (boolB == null) {
            return false;
        }
        return boolB.booleanValue();
    }

    public static void G(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void H(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void I(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof l) {
            ((l) view).stopNestedScroll();
        }
    }

    private static View.AccessibilityDelegate J(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : K(view);
    }

    private static View.AccessibilityDelegate K(View view) {
        if (i) {
            return null;
        }
        if (h == null) {
            try {
                h = View.class.getDeclaredField("mAccessibilityDelegate");
                h.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return null;
            }
        }
        try {
            Object obj = h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            i = true;
            return null;
        }
    }

    private static List<b.a> L(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    private static void M(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, androidx.core.view.accessibility.b bVar) {
        view.onInitializeAccessibilityNodeInfo(bVar.z());
    }

    public static C0313a b(View view) {
        View.AccessibilityDelegate accessibilityDelegateJ = J(view);
        if (accessibilityDelegateJ == null) {
            return null;
        }
        return accessibilityDelegateJ instanceof C0313a.C0014a ? ((C0313a.C0014a) accessibilityDelegateJ).f1225a : new C0313a(accessibilityDelegateJ);
    }

    private static Rect c() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i2, view);
            a(view, 0);
        }
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).a(view, keyEvent);
    }

    public static void e(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static void f(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static void g(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(View view, int i2) {
        if (view instanceof InterfaceC0322j) {
            ((InterfaceC0322j) view).stopNestedScroll(i2);
        } else if (i2 == 0) {
            I(view);
        }
    }

    public static float i(View view) {
        return Build.VERSION.SDK_INT >= 21 ? view.getElevation() : WheelView.DividerConfig.FILL;
    }

    public static boolean j(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f1212e) {
            try {
                f1211d = View.class.getDeclaredField("mMinHeight");
                f1211d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1212e = true;
        }
        Field field = f1211d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f1210c) {
            try {
                f1209b = View.class.getDeclaredField("mMinWidth");
                f1209b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1210c = true;
        }
        Field field = f1209b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    static C0313a p(View view) {
        C0313a c0313aB = b(view);
        if (c0313aB == null) {
            c0313aB = new C0313a();
        }
        a(view, c0313aB);
        return c0313aB;
    }

    public static int q(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static int r(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static ViewParent s(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    public static String t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f1213f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static float u(View view) {
        return Build.VERSION.SDK_INT >= 21 ? view.getTranslationZ() : WheelView.DividerConfig.FILL;
    }

    public static int v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static float w(View view) {
        return Build.VERSION.SDK_INT >= 21 ? view.getZ() : WheelView.DividerConfig.FILL;
    }

    public static boolean x(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean z(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void a(View view, C0313a c0313a) {
        if (c0313a == null && (J(view) instanceof C0313a.C0014a)) {
            c0313a = new C0313a();
        }
        view.setAccessibilityDelegate(c0313a == null ? null : c0313a.a());
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f1218a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1219b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f1220c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WeakReference<KeyEvent> f1221d = null;

        c() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.f1220c == null) {
                this.f1220c = new SparseArray<>();
            }
            return this.f1220c;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1219b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewB = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewB != null) {
                            return viewB;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((b) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        static c a(View view) {
            c cVar = (c) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            view.setTag(R.id.tag_unhandled_key_event_manager, cVar2);
            return cVar2;
        }

        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1219b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f1218a.isEmpty()) {
                return;
            }
            synchronized (f1218a) {
                if (this.f1219b == null) {
                    this.f1219b = new WeakHashMap<>();
                }
                for (int size = f1218a.size() - 1; size >= 0; size--) {
                    View view = f1218a.get(size).get();
                    if (view == null) {
                        f1218a.remove(size);
                    } else {
                        this.f1219b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f1219b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View viewB = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewB != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(viewB));
                }
            }
            return viewB != null;
        }

        boolean a(KeyEvent keyEvent) {
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1221d;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f1221d = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayA = a();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayA.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayA.valueAt(iIndexOfKey);
                sparseArrayA.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayA.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && ViewCompat.B(view)) {
                c(view, keyEvent);
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList e(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof v) {
            return ((v) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static Rect g(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    private static void i(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            M(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                M((View) parent);
            }
        }
    }

    private static void j(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            M(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                M((View) parent);
            }
        }
    }

    public static CharSequence d(View view) {
        return d().b(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode f(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof v) {
            return ((v) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static Display h(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (B(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    private static a<CharSequence> d() {
        return new y(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static void c(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    private static a<Boolean> e() {
        return new x(R.id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void b(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static int c(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static J b(View view, J j2) {
        if (Build.VERSION.SDK_INT < 21) {
            return j2;
        }
        WindowInsets windowInsetsH = j2.h();
        WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsH);
        if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsH)) {
            windowInsetsH = new WindowInsets(windowInsetsOnApplyWindowInsets);
        }
        return J.a(windowInsetsH);
    }

    public static void c(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (i3 >= 21) {
            Rect rectC = c();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectC.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectC.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            j(view, i2);
            if (z && rectC.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectC);
                return;
            }
            return;
        }
        j(view, i2);
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void a(View view, b.a aVar, CharSequence charSequence, androidx.core.view.accessibility.e eVar) {
        if (eVar == null && charSequence == null) {
            d(view, aVar.a());
        } else {
            a(view, aVar.a(charSequence, eVar));
        }
    }

    public static void b(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (i3 >= 21) {
            Rect rectC = c();
            boolean z = false;
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectC.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectC.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            i(view, i2);
            if (z && rectC.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectC);
                return;
            }
            return;
        }
        i(view, i2);
    }

    private static void a(View view, b.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            p(view);
            a(aVar.a(), view);
            L(view).add(aVar);
            a(view, 0);
        }
    }

    private static void a(int i2, View view) {
        List<b.a> listL = L(view);
        for (int i3 = 0; i3 < listL.size(); i3++) {
            if (listL.get(i3).a() == i2) {
                listL.remove(i3);
                return;
            }
        }
    }

    public static void a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    public static F a(View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        F f2 = g.get(view);
        if (f2 != null) {
            return f2;
        }
        F f3 = new F(view);
        g.put(view, f3);
        return f3;
    }

    private static a<Boolean> b() {
        return new z(R.id.tag_accessibility_heading, Boolean.class, 28);
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f1213f == null) {
            f1213f = new WeakHashMap<>();
        }
        f1213f.put(view, str);
    }

    public static void a(View view, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (rVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new w(rVar));
            }
        }
    }

    public static J a(View view, J j2) {
        if (Build.VERSION.SDK_INT < 21) {
            return j2;
        }
        WindowInsets windowInsetsH = j2.h();
        WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsH);
        if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsH)) {
            windowInsetsH = new WindowInsets(windowInsetsDispatchApplyWindowInsets);
        }
        return J.a(windowInsetsH);
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof v) {
            ((v) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
                return;
            }
            return;
        }
        if (view instanceof v) {
            ((v) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, t tVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (tVar != null ? tVar.a() : null));
        }
    }

    public static int a() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = f1208a.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f1208a.compareAndSet(i2, i3));
        return i2;
    }

    static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return c.a(view).a(keyEvent);
    }

    public static void a(View view, boolean z) {
        b().b(view, Boolean.valueOf(z));
    }

    static void a(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = d(view) != null;
            if (c(view) == 0 && (!z || view.getVisibility() != 0)) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            accessibilityEventObtain.setEventType(z ? 32 : DLog.CRS);
            accessibilityEventObtain.setContentChangeTypes(i2);
            view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
        }
    }
}
