package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.e;
import io.rong.common.dlog.DLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AccessibilityNodeInfo f1230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1231c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1232d = -1;

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1233a = new a(1, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1234b = new a(2, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f1235c = new a(4, null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f1236d = new a(8, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f1237e = new a(16, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f1238f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(256, null, e.b.class);
        public static final a j = new a(512, null, e.b.class);
        public static final a k = new a(1024, null, e.c.class);
        public static final a l = new a(DLog.CRS, null, e.c.class);
        public static final a m = new a(4096, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, null, e.g.class);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null, e.h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object L;
        private final int M;
        private final Class<? extends e.a> N;
        protected final e O;

        static {
            w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, e.C0016e.class);
            y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, e.f.class);
            I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, e.d.class);
            J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getLabel();
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.L;
            return obj2 == null ? aVar.L == null : obj2.equals(aVar.L);
        }

        public int hashCode() {
            Object obj = this.L;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends e.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        public boolean a(View view, Bundle bundle) {
            e.a aVarNewInstance;
            if (this.O == null) {
                return false;
            }
            e.a aVar = null;
            Class<? extends e.a> cls = this.N;
            if (cls != null) {
                try {
                    aVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    aVarNewInstance.a(bundle);
                    aVar = aVarNewInstance;
                } catch (Exception e3) {
                    e = e3;
                    aVar = aVarNewInstance;
                    Class<? extends e.a> cls2 = this.N;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e);
                }
            }
            return this.O.a(view, aVar);
        }

        a(Object obj, int i2, CharSequence charSequence, e eVar, Class<? extends e.a> cls) {
            this.M = i2;
            this.O = eVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.L = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.L = obj;
            }
            this.N = cls;
        }

        public a a(CharSequence charSequence, e eVar) {
            return new a(null, this.M, charSequence, eVar, this.N);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f1240a;

        c(Object obj) {
            this.f1240a = obj;
        }

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 21 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2)) : i5 >= 19 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new c(null);
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1230b = accessibilityNodeInfo;
    }

    private void A() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1230b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f1230b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f1230b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f1230b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private boolean B() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public static b a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    public static b b(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    private static String c(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case DLog.CRS /* 2048 */:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static b x() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public void c(View view, int i) {
        this.f1232d = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1230b.setSource(view, i);
        }
    }

    public void d(View view) {
        this.f1232d = -1;
        this.f1230b.setSource(view);
    }

    public void e(boolean z) {
        this.f1230b.setClickable(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1230b;
        if (accessibilityNodeInfo == null) {
            if (bVar.f1230b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(bVar.f1230b)) {
            return false;
        }
        return this.f1232d == bVar.f1232d && this.f1231c == bVar.f1231c;
    }

    public void f(CharSequence charSequence) {
        this.f1230b.setPackageName(charSequence);
    }

    public int g() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1230b.getMovementGranularities();
        }
        return 0;
    }

    public void h(boolean z) {
        this.f1230b.setEnabled(z);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1230b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i(boolean z) {
        this.f1230b.setFocusable(z);
    }

    public void j(boolean z) {
        this.f1230b.setFocused(z);
    }

    public boolean k() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1230b.isAccessibilityFocused();
        }
        return false;
    }

    public boolean l() {
        return this.f1230b.isCheckable();
    }

    public boolean m() {
        return this.f1230b.isChecked();
    }

    public boolean n() {
        return this.f1230b.isClickable();
    }

    public void o(boolean z) {
        this.f1230b.setSelected(z);
    }

    public boolean p() {
        return this.f1230b.isFocusable();
    }

    public boolean q() {
        return this.f1230b.isFocused();
    }

    public boolean r() {
        return this.f1230b.isLongClickable();
    }

    public boolean s() {
        return this.f1230b.isPassword();
    }

    public boolean t() {
        return this.f1230b.isScrollable();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(h());
        sb.append("; className: ");
        sb.append(d());
        sb.append("; text: ");
        sb.append(i());
        sb.append("; contentDescription: ");
        sb.append(e());
        sb.append("; viewId: ");
        sb.append(j());
        sb.append("; checkable: ");
        sb.append(l());
        sb.append("; checked: ");
        sb.append(m());
        sb.append("; focusable: ");
        sb.append(p());
        sb.append("; focused: ");
        sb.append(q());
        sb.append("; selected: ");
        sb.append(u());
        sb.append("; clickable: ");
        sb.append(n());
        sb.append("; longClickable: ");
        sb.append(r());
        sb.append("; enabled: ");
        sb.append(o());
        sb.append("; password: ");
        sb.append(s());
        sb.append("; scrollable: " + t());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> listA = a();
            for (int i = 0; i < listA.size(); i++) {
                a aVar = listA.get(i);
                String strC = c(aVar.a());
                if (strC.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    strC = aVar.b().toString();
                }
                sb.append(strC);
                if (i != listA.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int iB = b();
            while (iB != 0) {
                int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iB);
                iB &= iNumberOfTrailingZeros ^ (-1);
                sb.append(c(iNumberOfTrailingZeros));
                if (iB != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean u() {
        return this.f1230b.isSelected();
    }

    public boolean v() {
        return Build.VERSION.SDK_INT >= 26 ? this.f1230b.isShowingHintText() : d(4);
    }

    public boolean w() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1230b.isVisibleToUser();
        }
        return false;
    }

    public void y() {
        this.f1230b.recycle();
    }

    public AccessibilityNodeInfo z() {
        return this.f1230b;
    }

    public static b a(b bVar) {
        return a(AccessibilityNodeInfo.obtain(bVar.f1230b));
    }

    private SparseArray<WeakReference<ClickableSpan>> e(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayF = f(view);
        if (sparseArrayF != null) {
            return sparseArrayF;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> f(View view) {
        return (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    public int b() {
        return this.f1230b.getActions();
    }

    public CharSequence h() {
        return this.f1230b.getPackageName();
    }

    public CharSequence i() {
        if (!B()) {
            return this.f1230b.getText();
        }
        List<Integer> listA = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> listA2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> listA3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> listA4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1230b.getText(), 0, this.f1230b.getText().length()));
        for (int i = 0; i < listA.size(); i++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(listA4.get(i).intValue(), this, f().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), listA.get(i).intValue(), listA2.get(i).intValue(), listA3.get(i).intValue());
        }
        return spannableString;
    }

    public String j() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f1230b.getViewIdResourceName();
        }
        return null;
    }

    public void l(boolean z) {
        this.f1230b.setLongClickable(z);
    }

    public void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1230b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public void n(boolean z) {
        this.f1230b.setScrollable(z);
    }

    public boolean o() {
        return this.f1230b.isEnabled();
    }

    public void p(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1230b.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void q(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1230b.setVisibleToUser(z);
        }
    }

    private void g(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayF = f(view);
        if (sparseArrayF != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < sparseArrayF.size(); i++) {
                if (sparseArrayF.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sparseArrayF.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public void a(View view) {
        this.f1230b.addChild(view);
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1230b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
        return false;
    }

    public void d(Rect rect) {
        this.f1230b.setBoundsInScreen(rect);
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1230b.setContentInvalid(z);
        }
    }

    public void h(CharSequence charSequence) {
        this.f1230b.setText(charSequence);
    }

    public void k(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1230b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.accessibility.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityNodeInfoCompat.java */
    public static class C0015b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f1239a;

        C0015b(Object obj) {
            this.f1239a = obj;
        }

        public static C0015b a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            return i4 >= 21 ? new C0015b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3)) : i4 >= 19 ? new C0015b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new C0015b(null);
        }

        public static C0015b a(int i, int i2, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new C0015b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new C0015b(null);
        }
    }

    public void a(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1230b.addChild(view, i);
        }
    }

    public int c() {
        return this.f1230b.getChildCount();
    }

    public void d(boolean z) {
        this.f1230b.setChecked(z);
    }

    public void b(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1230b.setMovementGranularities(i);
        }
    }

    public void c(View view) {
        this.f1231c = -1;
        this.f1230b.setParent(view);
    }

    public CharSequence d() {
        return this.f1230b.getClassName();
    }

    public CharSequence e() {
        return this.f1230b.getContentDescription();
    }

    public Bundle f() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f1230b.getExtras();
        }
        return new Bundle();
    }

    public void a(int i) {
        this.f1230b.addAction(i);
    }

    public void d(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1230b.setError(charSequence);
        }
    }

    public void e(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f1230b.setHintText(charSequence);
        } else if (i >= 19) {
            this.f1230b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f1230b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f1230b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void b(View view, int i) {
        this.f1231c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1230b.setParent(view, i);
        }
    }

    @Deprecated
    public void c(Rect rect) {
        this.f1230b.setBoundsInParent(rect);
    }

    private boolean d(int i) {
        Bundle bundleF = f();
        return bundleF != null && (bundleF.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public void c(boolean z) {
        this.f1230b.setCheckable(z);
    }

    public void c(CharSequence charSequence) {
        this.f1230b.setContentDescription(charSequence);
    }

    public void b(Rect rect) {
        this.f1230b.getBoundsInScreen(rect);
    }

    public void g(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1230b.setDismissable(z);
        }
    }

    public void b(CharSequence charSequence) {
        this.f1230b.setClassName(charSequence);
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1230b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f1240a);
        }
    }

    public void g(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f1230b.setPaneTitle(charSequence);
        } else if (i >= 19) {
            this.f1230b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1230b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
    }

    public void b(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1230b.setCanOpenPopup(z);
        }
    }

    public boolean a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1230b.performAction(i, bundle);
        }
        return false;
    }

    @Deprecated
    public void a(Rect rect) {
        this.f1230b.getBoundsInParent(rect);
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1230b.setAccessibilityFocused(z);
        }
    }

    public void a(CharSequence charSequence, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i < 19 || i >= 26) {
            return;
        }
        A();
        g(view);
        ClickableSpan[] clickableSpanArrA = a(charSequence);
        if (clickableSpanArrA == null || clickableSpanArrA.length <= 0) {
            return;
        }
        f().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", androidx.core.R.id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> sparseArrayE = e(view);
        for (int i2 = 0; clickableSpanArrA != null && i2 < clickableSpanArrA.length; i2++) {
            int iA = a(clickableSpanArrA[i2], sparseArrayE);
            sparseArrayE.put(iA, new WeakReference<>(clickableSpanArrA[i2]));
            a(clickableSpanArrA[i2], (Spanned) charSequence, iA);
        }
    }

    public static ClickableSpan[] a(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f1229a;
        f1229a = i2 + 1;
        return i2;
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1230b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((C0015b) obj).f1239a);
        }
    }

    public List<a> a() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f1230b.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new a(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private void a(int i, boolean z) {
        Bundle bundleF = f();
        if (bundleF != null) {
            int i2 = bundleF.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ (-1));
            if (!z) {
                i = 0;
            }
            bundleF.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
