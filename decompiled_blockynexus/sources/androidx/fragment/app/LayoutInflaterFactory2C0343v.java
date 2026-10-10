package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C0344r;
import androidx.lifecycle.Lifecycle;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.analytics.pro.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class LayoutInflaterFactory2C0343v extends AbstractC0336n implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f1531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Interpolator f1532d = new DecelerateInterpolator(2.5f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Interpolator f1533e = new DecelerateInterpolator(1.5f);
    boolean A;
    boolean B;
    ArrayList<C0323a> C;
    ArrayList<Boolean> D;
    ArrayList<Fragment> E;
    ArrayList<g> H;
    private z I;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<e> f1534f;
    boolean g;
    ArrayList<C0323a> k;
    ArrayList<Fragment> l;
    private OnBackPressedDispatcher m;
    ArrayList<C0323a> o;
    ArrayList<Integer> p;
    ArrayList<AbstractC0336n.c> q;
    AbstractC0335m t;
    AbstractC0332j u;
    Fragment v;
    Fragment w;
    boolean x;
    boolean y;
    boolean z;
    int h = 0;
    final ArrayList<Fragment> i = new ArrayList<>();
    final HashMap<String, Fragment> j = new HashMap<>();
    private final androidx.activity.c n = new C0337o(this, false);
    private final CopyOnWriteArrayList<c> r = new CopyOnWriteArrayList<>();
    int s = 0;
    Bundle F = null;
    SparseArray<Parcelable> G = null;
    Runnable J = new RunnableC0338p(this);

    /* JADX INFO: renamed from: androidx.fragment.app.v$c */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AbstractC0336n.b f1542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f1543b;
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$d */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f1544a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$e */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    interface e {
        boolean a(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$f */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    private class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f1547c;

        f(String str, int i, int i2) {
            this.f1545a = str;
            this.f1546b = i;
            this.f1547c = i2;
        }

        @Override // androidx.fragment.app.LayoutInflaterFactory2C0343v.e
        public boolean a(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = LayoutInflaterFactory2C0343v.this.w;
            if (fragment == null || this.f1546b >= 0 || this.f1545a != null || !fragment.getChildFragmentManager().g()) {
                return LayoutInflaterFactory2C0343v.this.a(arrayList, arrayList2, this.f1545a, this.f1546b, this.f1547c);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$g */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    static class g implements Fragment.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f1549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final C0323a f1550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1551c;

        g(C0323a c0323a, boolean z) {
            this.f1549a = z;
            this.f1550b = c0323a;
        }

        @Override // androidx.fragment.app.Fragment.b
        public void a() {
            this.f1551c++;
        }

        @Override // androidx.fragment.app.Fragment.b
        public void b() {
            this.f1551c--;
            if (this.f1551c != 0) {
                return;
            }
            this.f1550b.s.C();
        }

        public void c() {
            C0323a c0323a = this.f1550b;
            c0323a.s.a(c0323a, this.f1549a, false, false);
        }

        public void d() {
            boolean z = this.f1551c > 0;
            LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = this.f1550b.s;
            int size = layoutInflaterFactory2C0343v.i.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = layoutInflaterFactory2C0343v.i.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            C0323a c0323a = this.f1550b;
            c0323a.s.a(c0323a, this.f1549a, !z, true);
        }

        public boolean e() {
            return this.f1551c == 0;
        }
    }

    LayoutInflaterFactory2C0343v() {
    }

    private void E() {
        this.j.values().removeAll(Collections.singleton(null));
    }

    private void F() {
        if (y()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void G() {
        this.g = false;
        this.D.clear();
        this.C.clear();
    }

    private void H() {
        for (Fragment fragment : this.j.values()) {
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    a(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    private void I() {
        if (this.H != null) {
            while (!this.H.isEmpty()) {
                this.H.remove(0).d();
            }
        }
    }

    private void J() {
        ArrayList<e> arrayList = this.f1534f;
        if (arrayList == null || arrayList.isEmpty()) {
            this.n.a(c() > 0 && j(this.v));
        } else {
            this.n.a(true);
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
        AbstractC0335m abstractC0335m = this.t;
        if (abstractC0335m != null) {
            try {
                abstractC0335m.a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    public static int b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    public static int e(int i) {
        if (i == 4097) {
            return m.a.p;
        }
        if (i == 4099) {
            return m.a.f20901c;
        }
        if (i != 8194) {
            return 0;
        }
        return m.a.f20899a;
    }

    private void v(Fragment fragment) {
        if (fragment == null || this.j.get(fragment.mWho) != fragment) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    void A() {
        if (this.q != null) {
            for (int i = 0; i < this.q.size(); i++) {
                this.q.get(i).onBackStackChanged();
            }
        }
    }

    Parcelable B() {
        ArrayList<String> arrayList;
        int size;
        I();
        H();
        t();
        this.y = true;
        C0325c[] c0325cArr = null;
        if (this.j.isEmpty()) {
            return null;
        }
        ArrayList<C> arrayList2 = new ArrayList<>(this.j.size());
        boolean z = false;
        for (Fragment fragment : this.j.values()) {
            if (fragment != null) {
                if (fragment.mFragmentManager != this) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                    throw null;
                }
                C c2 = new C(fragment);
                arrayList2.add(c2);
                if (fragment.mState <= 0 || c2.m != null) {
                    c2.m = fragment.mSavedFragmentState;
                } else {
                    c2.m = r(fragment);
                    String str = fragment.mTargetWho;
                    if (str != null) {
                        Fragment fragment2 = this.j.get(str);
                        if (fragment2 == null) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTargetWho));
                            throw null;
                        }
                        if (c2.m == null) {
                            c2.m = new Bundle();
                        }
                        a(c2.m, "android:target_state", fragment2);
                        int i = fragment.mTargetRequestCode;
                        if (i != 0) {
                            c2.m.putInt("android:target_req_state", i);
                        }
                    }
                }
                if (f1531c) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + c2.m);
                }
                z = true;
            }
        }
        if (!z) {
            if (f1531c) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.i.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            for (Fragment fragment3 : this.i) {
                arrayList.add(fragment3.mWho);
                if (fragment3.mFragmentManager != this) {
                    a(new IllegalStateException("Failure saving state: active " + fragment3 + " was removed from the FragmentManager"));
                    throw null;
                }
                if (f1531c) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment3.mWho + "): " + fragment3);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<C0323a> arrayList3 = this.k;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            c0325cArr = new C0325c[size];
            for (int i2 = 0; i2 < size; i2++) {
                c0325cArr[i2] = new C0325c(this.k.get(i2));
                if (f1531c) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.k.get(i2));
                }
            }
        }
        x xVar = new x();
        xVar.f1552a = arrayList2;
        xVar.f1553b = arrayList;
        xVar.f1554c = c0325cArr;
        Fragment fragment4 = this.w;
        if (fragment4 != null) {
            xVar.f1555d = fragment4.mWho;
        }
        xVar.f1556e = this.h;
        return xVar;
    }

    void C() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.H == null || this.H.isEmpty()) ? false : true;
            if (this.f1534f != null && this.f1534f.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.t.d().removeCallbacks(this.J);
                this.t.d().post(this.J);
                J();
            }
        }
    }

    void D() {
        for (Fragment fragment : this.j.values()) {
            if (fragment != null) {
                o(fragment);
            }
        }
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public boolean b() {
        boolean zT = t();
        I();
        return zT;
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public int c() {
        ArrayList<C0323a> arrayList = this.k;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    boolean d(int i) {
        return this.s >= i;
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public List<Fragment> e() {
        List<Fragment> list;
        if (this.i.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.i) {
            list = (List) this.i.clone();
        }
        return list;
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public void f() {
        a((e) new f(null, -1, 0), false);
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public boolean g() {
        F();
        return a((String) null, -1, 0);
    }

    C0344r h(Fragment fragment) {
        return this.I.d(fragment);
    }

    public void i(Fragment fragment) {
        if (f1531c) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
    }

    boolean j(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = fragment.mFragmentManager;
        return fragment == layoutInflaterFactory2C0343v.v() && j(layoutInflaterFactory2C0343v.v);
    }

    void k(Fragment fragment) {
        if (this.j.get(fragment.mWho) != null) {
            return;
        }
        this.j.put(fragment.mWho, fragment);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                b(fragment);
            } else {
                q(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (f1531c) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void l(Fragment fragment) {
        if (this.j.get(fragment.mWho) == null) {
            return;
        }
        if (f1531c) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.j.values()) {
            if (fragment2 != null && fragment.mWho.equals(fragment2.mTargetWho)) {
                fragment2.mTarget = fragment;
                fragment2.mTargetWho = null;
            }
        }
        this.j.put(fragment.mWho, null);
        q(fragment);
        String str = fragment.mTargetWho;
        if (str != null) {
            fragment.mTarget = this.j.get(str);
        }
        fragment.initState();
    }

    void m(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.j.containsKey(fragment.mWho)) {
            if (f1531c) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.s + "since it is not added to " + this);
                return;
            }
            return;
        }
        int iMin = this.s;
        if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, 0);
        }
        a(fragment, iMin, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            Fragment fragmentW = w(fragment);
            if (fragmentW != null) {
                View view = fragmentW.mView;
                ViewGroup viewGroup = fragment.mContainer;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.mView, iIndexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > WheelView.DividerConfig.FILL) {
                    fragment.mView.setAlpha(f2);
                }
                fragment.mPostponedAlpha = WheelView.DividerConfig.FILL;
                fragment.mIsNewlyAdded = false;
                a aVarA = a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                if (aVarA != null) {
                    Animation animation = aVarA.f1535a;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        aVarA.f1536b.setTarget(fragment.mView);
                        aVarA.f1536b.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            d(fragment);
        }
    }

    void n(Fragment fragment) {
        a(fragment, this.s, 0, 0, false);
    }

    public void o(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.g) {
                this.B = true;
            } else {
                fragment.mDeferStart = false;
                a(fragment, this.s, 0, 0, false);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f1544a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (str2 == null || !C0334l.b(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment fragmentA = resourceId != -1 ? a(resourceId) : null;
        if (fragmentA == null && string != null) {
            fragmentA = a(string);
        }
        if (fragmentA == null && id != -1) {
            fragmentA = a(id);
        }
        if (f1531c) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragmentA);
        }
        if (fragmentA == null) {
            Fragment fragmentA2 = d().a(context.getClassLoader(), str2);
            fragmentA2.mFromLayout = true;
            fragmentA2.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentA2.mContainerId = id;
            fragmentA2.mTag = string;
            fragmentA2.mInLayout = true;
            fragmentA2.mFragmentManager = this;
            AbstractC0335m abstractC0335m = this.t;
            fragmentA2.mHost = abstractC0335m;
            fragmentA2.onInflate(abstractC0335m.c(), attributeSet, fragmentA2.mSavedFragmentState);
            a(fragmentA2, true);
            fragment = fragmentA2;
        } else {
            if (fragmentA.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            fragmentA.mInLayout = true;
            AbstractC0335m abstractC0335m2 = this.t;
            fragmentA.mHost = abstractC0335m2;
            fragmentA.onInflate(abstractC0335m2.c(), attributeSet, fragmentA.mSavedFragmentState);
            fragment = fragmentA;
        }
        if (this.s >= 1 || !fragment.mFromLayout) {
            n(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    public void p(Fragment fragment) {
        if (f1531c) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.i) {
                this.i.remove(fragment);
            }
            if (x(fragment)) {
                this.x = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    void q(Fragment fragment) {
        if (y()) {
            if (f1531c) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.I.e(fragment) && f1531c) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    Bundle r(Fragment fragment) {
        Bundle bundle;
        if (this.F == null) {
            this.F = new Bundle();
        }
        fragment.performSaveInstanceState(this.F);
        d(fragment, this.F, false);
        if (this.F.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.F;
            this.F = null;
        }
        if (fragment.mView != null) {
            s(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    void s() {
        if (this.B) {
            this.B = false;
            D();
        }
    }

    public boolean t() {
        c(true);
        boolean z = false;
        while (b(this.C, this.D)) {
            this.g = true;
            try {
                c(this.C, this.D);
                G();
                z = true;
            } catch (Throwable th) {
                G();
                throw th;
            }
        }
        J();
        s();
        E();
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.v;
        if (fragment != null) {
            androidx.core.f.a.a(fragment, sb);
        } else {
            androidx.core.f.a.a(this.t, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    LayoutInflater.Factory2 u() {
        return this;
    }

    public void u(Fragment fragment) {
        if (f1531c) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    void w() {
        t();
        if (this.n.b()) {
            g();
        } else {
            this.m.a();
        }
    }

    public boolean x() {
        return this.A;
    }

    public boolean y() {
        return this.y || this.z;
    }

    public void z() {
        this.y = false;
        this.z = false;
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    private boolean x(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.h();
    }

    public void c(Fragment fragment) {
        if (f1531c) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.i.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (f1531c) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.i) {
                this.i.add(fragment);
            }
            fragment.mAdded = true;
            if (x(fragment)) {
                this.x = true;
            }
        }
    }

    void d(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            a aVarA = a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (aVarA == null || (animator = aVarA.f1536b) == null) {
                if (aVarA != null) {
                    fragment.mView.startAnimation(aVarA.f1535a);
                    aVarA.f1535a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    aVarA.f1536b.addListener(new C0341t(this, viewGroup, view, fragment));
                }
                aVarA.f1536b.start();
            }
        }
        if (fragment.mAdded && x(fragment)) {
            this.x = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    void f(Fragment fragment) {
        if (!fragment.mFromLayout || fragment.mPerformedCreateView) {
            return;
        }
        fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view == null) {
            fragment.mInnerView = null;
            return;
        }
        fragment.mInnerView = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.mHidden) {
            fragment.mView.setVisibility(8);
        }
        fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
        a(fragment, fragment.mView, fragment.mSavedFragmentState, false);
    }

    void h(Fragment fragment, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).h(fragment, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.g(this, fragment);
            }
        }
    }

    public void n() {
        f(3);
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public AbstractC0336n.a b(int i) {
        return this.k.get(i);
    }

    z g(Fragment fragment) {
        return this.I.c(fragment);
    }

    public Fragment v() {
        return this.w;
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$a */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f1535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f1536b;

        a(Animation animation) {
            this.f1535a = animation;
            this.f1536b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f1535a = null;
            this.f1536b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    void b(Fragment fragment) {
        if (y()) {
            if (f1531c) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.I.a(fragment) && f1531c) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    void g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).g(fragment, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.f(this, fragment);
            }
        }
    }

    void s(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.G;
        if (sparseArray == null) {
            this.G = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.G);
        if (this.G.size() > 0) {
            fragment.mSavedViewState = this.G;
            this.G = null;
        }
    }

    private Fragment w(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.i.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
                Fragment fragment2 = this.i.get(iIndexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public void i() {
        this.y = false;
        this.z = false;
        f(2);
    }

    public void j() {
        this.y = false;
        this.z = false;
        f(1);
    }

    /* JADX INFO: renamed from: androidx.fragment.app.v$b */
    /* JADX INFO: compiled from: FragmentManagerImpl.java */
    private static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f1537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final View f1538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1541e;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1541e = true;
            this.f1537a = viewGroup;
            this.f1538b = view;
            addAnimation(animation);
            this.f1537a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f1541e = true;
            if (this.f1539c) {
                return !this.f1540d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f1539c = true;
                androidx.core.view.s.a(this.f1537a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1539c || !this.f1541e) {
                this.f1537a.endViewTransition(this.f1538b);
                this.f1540d = true;
            } else {
                this.f1541e = false;
                this.f1537a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f2) {
            this.f1541e = true;
            if (this.f1539c) {
                return !this.f1540d;
            }
            if (!super.getTransformation(j, transformation, f2)) {
                this.f1539c = true;
                androidx.core.view.s.a(this.f1537a, this);
            }
            return true;
        }
    }

    public void e(Fragment fragment) {
        if (f1531c) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (f1531c) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.i) {
                this.i.remove(fragment);
            }
            if (x(fragment)) {
                this.x = true;
            }
            fragment.mAdded = false;
        }
    }

    void o() {
        J();
        v(this.w);
    }

    public void q() {
        this.y = false;
        this.z = false;
        f(3);
    }

    public void k() {
        this.A = true;
        t();
        f(0);
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.m != null) {
            this.n.c();
            this.m = null;
        }
    }

    public Fragment b(String str) {
        Fragment fragmentFindFragmentByWho;
        for (Fragment fragment : this.j.values()) {
            if (fragment != null && (fragmentFindFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    boolean h() {
        boolean zX = false;
        for (Fragment fragment : this.j.values()) {
            if (fragment != null) {
                zX = x(fragment);
            }
            if (zX) {
                return true;
            }
        }
        return false;
    }

    public void t(Fragment fragment) {
        if (fragment != null && (this.j.get(fragment.mWho) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.w;
        this.w = fragment;
        v(fragment2);
        v(this.w);
    }

    private void f(int i) {
        try {
            this.g = true;
            a(i, false);
            this.g = false;
            t();
        } catch (Throwable th) {
            this.g = false;
            throw th;
        }
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public F a() {
        return new C0323a(this);
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public void a(int i, int i2) {
        if (i >= 0) {
            a((e) new f(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public int b(C0323a c0323a) {
        synchronized (this) {
            if (this.p != null && this.p.size() > 0) {
                int iIntValue = this.p.remove(this.p.size() - 1).intValue();
                if (f1531c) {
                    Log.v("FragmentManager", "Adding back stack index " + iIntValue + " with " + c0323a);
                }
                this.o.set(iIntValue, c0323a);
                return iIntValue;
            }
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            int size = this.o.size();
            if (f1531c) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0323a);
            }
            this.o.add(c0323a);
            return size;
        }
    }

    public void l() {
        f(1);
    }

    public void p() {
        this.y = false;
        this.z = false;
        f(4);
    }

    private boolean a(String str, int i, int i2) {
        t();
        c(true);
        Fragment fragment = this.w;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().g()) {
            return true;
        }
        boolean zA = a(this.C, this.D, str, i, i2);
        if (zA) {
            this.g = true;
            try {
                c(this.C, this.D);
            } finally {
                G();
            }
        }
        J();
        s();
        E();
        return zA;
    }

    public void c(int i) {
        synchronized (this) {
            this.o.set(i, null);
            if (this.p == null) {
                this.p = new ArrayList<>();
            }
            if (f1531c) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.p.add(Integer.valueOf(i));
        }
    }

    public void r() {
        this.z = true;
        f(2);
    }

    void f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).f(fragment, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.e(this, fragment);
            }
        }
    }

    void e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).e(fragment, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.d(this, fragment);
            }
        }
    }

    private void c(boolean z) {
        if (!this.g) {
            if (this.t != null) {
                if (Looper.myLooper() == this.t.d().getLooper()) {
                    if (!z) {
                        F();
                    }
                    if (this.C == null) {
                        this.C = new ArrayList<>();
                        this.D = new ArrayList<>();
                    }
                    this.g = true;
                    try {
                        a((ArrayList<C0323a>) null, (ArrayList<Boolean>) null);
                        return;
                    } finally {
                        this.g = false;
                    }
                }
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public void b(e eVar, boolean z) {
        if (z && (this.t == null || this.A)) {
            return;
        }
        c(z);
        if (eVar.a(this.C, this.D)) {
            this.g = true;
            try {
                c(this.C, this.D);
            } finally {
                G();
            }
        }
        J();
        s();
        E();
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
            return;
        }
        a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public C0334l d() {
        if (super.d() == AbstractC0336n.f1514a) {
            Fragment fragment = this.v;
            if (fragment != null) {
                return fragment.mFragmentManager.d();
            }
            a(new C0342u(this));
        }
        return super.d();
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public Fragment a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.j.get(string);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public void m() {
        for (int i = 0; i < this.i.size(); i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public Fragment.c a(Fragment fragment) {
        Bundle bundleR;
        if (fragment.mFragmentManager == this) {
            if (fragment.mState <= 0 || (bundleR = r(fragment)) == null) {
                return null;
            }
            return new Fragment.c(bundleR);
        }
        a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    void d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).d(fragment, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.c(this, fragment);
            }
        }
    }

    private void b(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = arrayList.get(i5).q;
        ArrayList<Fragment> arrayList3 = this.E;
        if (arrayList3 == null) {
            this.E = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.E.addAll(this.i);
        Fragment fragmentV = v();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            C0323a c0323a = arrayList.get(i6);
            if (!arrayList2.get(i6).booleanValue()) {
                fragmentV = c0323a.a(this.E, fragmentV);
            } else {
                fragmentV = c0323a.b(this.E, fragmentV);
            }
            z2 = z2 || c0323a.h;
        }
        this.E.clear();
        if (!z) {
            K.a(this, arrayList, arrayList2, i, i2, false);
        }
        a(arrayList, arrayList2, i, i2);
        if (z) {
            a.a.d<Fragment> dVar = new a.a.d<>();
            a(dVar);
            int iA = a(arrayList, arrayList2, i, i2, dVar);
            b(dVar);
            i3 = iA;
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            K.a(this, arrayList, arrayList2, i, i3, true);
            a(this.s, true);
        }
        while (i5 < i2) {
            C0323a c0323a2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = c0323a2.u) >= 0) {
                c(i4);
                c0323a2.u = -1;
            }
            c0323a2.i();
            i5++;
        }
        if (z2) {
            A();
        }
    }

    private void c(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 != null && arrayList.size() == arrayList2.size()) {
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).q) {
                    if (i2 != i) {
                        b(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).q) {
                            i2++;
                        }
                    }
                    b(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                b(arrayList, arrayList2, i2, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.j.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.j.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.i.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                Fragment fragment2 = this.i.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.l;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                Fragment fragment3 = this.l.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<C0323a> arrayList2 = this.k;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                C0323a c0323a = this.k.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(c0323a.toString());
                c0323a.a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.o != null && (size2 = this.o.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj = (C0323a) this.o.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.p != null && this.p.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.p.toArray()));
            }
        }
        ArrayList<e> arrayList3 = this.f1534f;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = (e) this.f1534f.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.u);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.y);
        printWriter.print(" mStopped=");
        printWriter.print(this.z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.A);
        if (this.x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.x);
        }
    }

    void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).d(fragment, bundle, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.d(this, fragment, bundle);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).c(fragment, bundle, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.c(this, fragment, bundle);
            }
        }
    }

    void c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).c(fragment, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.b(this, fragment);
            }
        }
    }

    private void b(a.a.d<Fragment> dVar) {
        int size = dVar.size();
        for (int i = 0; i < size; i++) {
            Fragment fragmentE = dVar.e(i);
            if (!fragmentE.mAdded) {
                View viewRequireView = fragmentE.requireView();
                fragmentE.mPostponedAlpha = viewRequireView.getAlpha();
                viewRequireView.setAlpha(WheelView.DividerConfig.FILL);
            }
        }
    }

    private boolean b(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f1534f != null && this.f1534f.size() != 0) {
                int size = this.f1534f.size();
                boolean zA = false;
                for (int i = 0; i < size; i++) {
                    zA |= this.f1534f.get(i).a(arrayList, arrayList2);
                }
                this.f1534f.clear();
                this.t.d().removeCallbacks(this.J);
                return zA;
            }
            return false;
        }
    }

    public void b(boolean z) {
        for (int size = this.i.size() - 1; size >= 0; size--) {
            Fragment fragment = this.i.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean b(Menu menu) {
        if (this.s < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.i.size(); i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean b(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (int i = 0; i < this.i.size(); i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void b(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).b(fragment, context, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.b(this, fragment, context);
            }
        }
    }

    void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).b(fragment, bundle, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.b(this, fragment, bundle);
            }
        }
    }

    static a a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f1532d);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(f1533e);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new a(animationSet);
    }

    void b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).b(fragment, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.a(this, fragment);
            }
        }
    }

    static a a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(f1533e);
        alphaAnimation.setDuration(220L);
        return new a(alphaAnimation);
    }

    a a(Fragment fragment, int i, boolean z, int i2) {
        int iB;
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new a(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new a(animatorOnCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(this.t.c().getResources().getResourceTypeName(nextAnim));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.t.c(), nextAnim);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.t.c(), nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!zEquals) {
                        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.t.c(), nextAnim);
                        if (animationLoadAnimation2 != null) {
                            return new a(animationLoadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i == 0 || (iB = b(i, z)) < 0) {
            return null;
        }
        switch (iB) {
            case 1:
                return a(1.125f, 1.0f, WheelView.DividerConfig.FILL, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, WheelView.DividerConfig.FILL);
            case 3:
                return a(0.975f, 1.0f, WheelView.DividerConfig.FILL, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, WheelView.DividerConfig.FILL);
            case 5:
                return a(WheelView.DividerConfig.FILL, 1.0f);
            case 6:
                return a(1.0f, WheelView.DividerConfig.FILL);
            default:
                if (i2 == 0 && this.t.h()) {
                    i2 = this.t.g();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:275:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 1284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.LayoutInflaterFactory2C0343v.a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    private void a(Fragment fragment, a aVar, int i) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        Animation animation = aVar.f1535a;
        if (animation != null) {
            b bVar = new b(animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            bVar.setAnimationListener(new r(this, viewGroup, fragment));
            fragment.mView.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.f1536b;
        fragment.setAnimator(animator);
        animator.addListener(new C0340s(this, viewGroup, view, fragment));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    void a(int i, boolean z) {
        AbstractC0335m abstractC0335m;
        if (this.t == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.s) {
            this.s = i;
            int size = this.i.size();
            for (int i2 = 0; i2 < size; i2++) {
                m(this.i.get(i2));
            }
            for (Fragment fragment : this.j.values()) {
                if (fragment != null && (fragment.mRemoving || fragment.mDetached)) {
                    if (!fragment.mIsNewlyAdded) {
                        m(fragment);
                    }
                }
            }
            D();
            if (this.x && (abstractC0335m = this.t) != null && this.s == 4) {
                abstractC0335m.i();
                this.x = false;
            }
        }
    }

    public void a(Fragment fragment, boolean z) {
        if (f1531c) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        k(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.i.contains(fragment)) {
            synchronized (this.i) {
                this.i.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (x(fragment)) {
                this.x = true;
            }
            if (z) {
                n(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public Fragment a(int i) {
        for (int size = this.i.size() - 1; size >= 0; size--) {
            Fragment fragment = this.i.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.j.values()) {
            if (fragment2 != null && fragment2.mFragmentId == i) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.AbstractC0336n
    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.i.size() - 1; size >= 0; size--) {
                Fragment fragment = this.i.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.j.values()) {
            if (fragment2 != null && str.equals(fragment2.mTag)) {
                return fragment2;
            }
        }
        return null;
    }

    public void a(e eVar, boolean z) {
        if (!z) {
            F();
        }
        synchronized (this) {
            if (!this.A && this.t != null) {
                if (this.f1534f == null) {
                    this.f1534f = new ArrayList<>();
                }
                this.f1534f.add(eVar);
                C();
                return;
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void a(int i, C0323a c0323a) {
        synchronized (this) {
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            int size = this.o.size();
            if (i < size) {
                if (f1531c) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0323a);
                }
                this.o.set(i, c0323a);
            } else {
                while (size < i) {
                    this.o.add(null);
                    if (this.p == null) {
                        this.p = new ArrayList<>();
                    }
                    if (f1531c) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.p.add(Integer.valueOf(size));
                    size++;
                }
                if (f1531c) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0323a);
                }
                this.o.add(c0323a);
            }
        }
    }

    private void a(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<g> arrayList3 = this.H;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            g gVar = this.H.get(i);
            if (arrayList != null && !gVar.f1549a && (iIndexOf2 = arrayList.indexOf(gVar.f1550b)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                this.H.remove(i);
                i--;
                size--;
                gVar.c();
            } else if (gVar.e() || (arrayList != null && gVar.f1550b.a(arrayList, 0, arrayList.size()))) {
                this.H.remove(i);
                i--;
                size--;
                if (arrayList != null && !gVar.f1549a && (iIndexOf = arrayList.indexOf(gVar.f1550b)) != -1 && arrayList2.get(iIndexOf).booleanValue()) {
                    gVar.c();
                } else {
                    gVar.d();
                }
            }
            i++;
        }
    }

    private int a(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, a.a.d<Fragment> dVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C0323a c0323a = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (c0323a.h() && !c0323a.a(arrayList, i4 + 1, i2)) {
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
                g gVar = new g(c0323a, zBooleanValue);
                this.H.add(gVar);
                c0323a.a(gVar);
                if (zBooleanValue) {
                    c0323a.g();
                } else {
                    c0323a.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, c0323a);
                }
                a(dVar);
            }
        }
        return i3;
    }

    void a(C0323a c0323a, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0323a.b(z3);
        } else {
            c0323a.g();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0323a);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            K.a(this, (ArrayList<C0323a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.s, true);
        }
        for (Fragment fragment : this.j.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && c0323a.c(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > WheelView.DividerConfig.FILL) {
                    fragment.mView.setAlpha(f2);
                }
                if (z3) {
                    fragment.mPostponedAlpha = WheelView.DividerConfig.FILL;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    private static void a(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0323a c0323a = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                c0323a.b(-1);
                c0323a.b(i == i2 + (-1));
            } else {
                c0323a.b(1);
                c0323a.g();
            }
            i++;
        }
    }

    private void a(a.a.d<Fragment> dVar) {
        int i = this.s;
        if (i < 1) {
            return;
        }
        int iMin = Math.min(i, 3);
        int size = this.i.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.i.get(i2);
            if (fragment.mState < iMin) {
                a(fragment, iMin, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    dVar.add(fragment);
                }
            }
        }
    }

    void a(C0323a c0323a) {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        this.k.add(c0323a);
    }

    boolean a(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        ArrayList<C0323a> arrayList3 = this.k;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.k.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.k.size() - 1;
                while (size >= 0) {
                    C0323a c0323a = this.k.get(size);
                    if ((str != null && str.equals(c0323a.getName())) || (i >= 0 && i == c0323a.u)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        C0323a c0323a2 = this.k.get(size);
                        if (str == null || !str.equals(c0323a2.getName())) {
                            if (i < 0 || i != c0323a2.u) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.k.size() - 1) {
                return false;
            }
            for (int size3 = this.k.size() - 1; size3 > size; size3--) {
                arrayList.add(this.k.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    void a(Parcelable parcelable) {
        C next;
        if (parcelable == null) {
            return;
        }
        x xVar = (x) parcelable;
        if (xVar.f1552a == null) {
            return;
        }
        for (Fragment fragment : this.I.c()) {
            if (f1531c) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<C> it = xVar.f1552a.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.f1405b.equals(fragment.mWho)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (next == null) {
                if (f1531c) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + xVar.f1552a);
                }
                a(fragment, 1, 0, 0, false);
                fragment.mRemoving = true;
                a(fragment, 0, 0, 0, false);
            } else {
                next.n = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                Fragment fragment2 = fragment.mTarget;
                fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
                fragment.mTarget = null;
                Bundle bundle = next.m;
                if (bundle != null) {
                    bundle.setClassLoader(this.t.c().getClassLoader());
                    fragment.mSavedViewState = next.m.getSparseParcelableArray("android:view_state");
                    fragment.mSavedFragmentState = next.m;
                }
            }
        }
        this.j.clear();
        for (C c2 : xVar.f1552a) {
            if (c2 != null) {
                Fragment fragmentA = c2.a(this.t.c().getClassLoader(), d());
                fragmentA.mFragmentManager = this;
                if (f1531c) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentA.mWho + "): " + fragmentA);
                }
                this.j.put(fragmentA.mWho, fragmentA);
                c2.n = null;
            }
        }
        this.i.clear();
        ArrayList<String> arrayList = xVar.f1553b;
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment fragment3 = this.j.get(str);
                if (fragment3 != null) {
                    fragment3.mAdded = true;
                    if (f1531c) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragment3);
                    }
                    if (!this.i.contains(fragment3)) {
                        synchronized (this.i) {
                            this.i.add(fragment3);
                        }
                    } else {
                        throw new IllegalStateException("Already added " + fragment3);
                    }
                } else {
                    a(new IllegalStateException("No instantiated fragment for (" + str + ")"));
                    throw null;
                }
            }
        }
        C0325c[] c0325cArr = xVar.f1554c;
        if (c0325cArr != null) {
            this.k = new ArrayList<>(c0325cArr.length);
            int i = 0;
            while (true) {
                C0325c[] c0325cArr2 = xVar.f1554c;
                if (i >= c0325cArr2.length) {
                    break;
                }
                C0323a c0323aA = c0325cArr2[i].a(this);
                if (f1531c) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + c0323aA.u + "): " + c0323aA);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
                    c0323aA.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.k.add(c0323aA);
                int i2 = c0323aA.u;
                if (i2 >= 0) {
                    a(i2, c0323aA);
                }
                i++;
            }
        } else {
            this.k = null;
        }
        String str2 = xVar.f1555d;
        if (str2 != null) {
            this.w = this.j.get(str2);
            v(this.w);
        }
        this.h = xVar.f1556e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(AbstractC0335m abstractC0335m, AbstractC0332j abstractC0332j, Fragment fragment) {
        if (this.t == null) {
            this.t = abstractC0335m;
            this.u = abstractC0332j;
            this.v = fragment;
            if (this.v != null) {
                J();
            }
            if (abstractC0335m instanceof androidx.activity.d) {
                androidx.activity.d dVar = (androidx.activity.d) abstractC0335m;
                this.m = dVar.getOnBackPressedDispatcher();
                androidx.lifecycle.g gVar = dVar;
                if (fragment != null) {
                    gVar = fragment;
                }
                this.m.addCallback(gVar, this.n);
            }
            if (fragment != null) {
                this.I = fragment.mFragmentManager.g(fragment);
                return;
            } else if (abstractC0335m instanceof androidx.lifecycle.s) {
                this.I = z.a(((androidx.lifecycle.s) abstractC0335m).getViewModelStore());
                return;
            } else {
                this.I = new z(false);
                return;
            }
        }
        throw new IllegalStateException("Already attached");
    }

    public void a(boolean z) {
        for (int size = this.i.size() - 1; size >= 0; size--) {
            Fragment fragment = this.i.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i = 0; i < this.i.size(); i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.s < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.i.size(); i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.l != null) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                Fragment fragment2 = this.l.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.l = arrayList;
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (int i = 0; i < this.i.size(); i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.s < 1) {
            return;
        }
        for (int i = 0; i < this.i.size(); i++) {
            Fragment fragment = this.i.get(i);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void a(Fragment fragment, Lifecycle.State state) {
        if (this.j.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void a(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).a(fragment, context, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.a(this, fragment, context);
            }
        }
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).a(fragment, bundle, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.a(this, fragment, bundle);
            }
        }
    }

    void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            AbstractC0336n fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflaterFactory2C0343v) {
                ((LayoutInflaterFactory2C0343v) fragmentManager).a(fragment, view, bundle, true);
            }
        }
        for (c cVar : this.r) {
            if (!z || cVar.f1543b) {
                cVar.f1542a.a(this, fragment, view, bundle);
            }
        }
    }
}
