package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f2189a = {2, 1, 3, 4};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PathMotion f2190b = new Y();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadLocal<a.a.b<Animator, a>> f2191c = new ThreadLocal<>();
    AbstractC0385ea G;
    private b H;
    private a.a.b<String, String> I;
    private ArrayList<ha> w;
    private ArrayList<ha> x;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2192d = getClass().getName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f2193e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f2194f = -1;
    private TimeInterpolator g = null;
    ArrayList<Integer> h = new ArrayList<>();
    ArrayList<View> i = new ArrayList<>();
    private ArrayList<String> j = null;
    private ArrayList<Class<?>> k = null;
    private ArrayList<Integer> l = null;
    private ArrayList<View> m = null;
    private ArrayList<Class<?>> n = null;
    private ArrayList<String> o = null;
    private ArrayList<Integer> p = null;
    private ArrayList<View> q = null;
    private ArrayList<Class<?>> r = null;
    private ia s = new ia();
    private ia t = new ia();
    TransitionSet u = null;
    private int[] v = f2189a;
    private ViewGroup y = null;
    boolean z = false;
    ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<c> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    private PathMotion J = f2190b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f2195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ha f2197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Ga f2198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Transition f2199e;

        a(View view, String str, Transition transition, Ga ga, ha haVar) {
            this.f2195a = view;
            this.f2196b = str;
            this.f2197c = haVar;
            this.f2198d = ga;
            this.f2199e = transition;
        }
    }

    public static abstract class b {
        public abstract Rect a(Transition transition);
    }

    public interface c {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);

        void e(Transition transition);
    }

    public Transition() {
    }

    private static boolean a(int i) {
        return i >= 1 && i <= 4;
    }

    private static int[] b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(strTrim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(strTrim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(strTrim)) {
                iArr[i] = 2;
            } else if ("itemId".equalsIgnoreCase(strTrim)) {
                iArr[i] = 4;
            } else {
                if (!strTrim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            }
            i++;
        }
        return iArr;
    }

    private static a.a.b<Animator, a> q() {
        a.a.b<Animator, a> bVar = f2191c.get();
        if (bVar != null) {
            return bVar;
        }
        a.a.b<Animator, a> bVar2 = new a.a.b<>();
        f2191c.set(bVar2);
        return bVar2;
    }

    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        return null;
    }

    public Transition a(long j) {
        this.f2194f = j;
        return this;
    }

    public abstract void a(ha haVar);

    public long c() {
        return this.f2194f;
    }

    public abstract void c(ha haVar);

    protected void cancel() {
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).cancel();
        }
        ArrayList<c> arrayList = this.E;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.E.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((c) arrayList2.get(i)).e(this);
        }
    }

    public Transition d(View view) {
        this.i.remove(view);
        return this;
    }

    public TimeInterpolator e() {
        return this.g;
    }

    public String f() {
        return this.f2192d;
    }

    public PathMotion g() {
        return this.J;
    }

    public b getEpicenterCallback() {
        return this.H;
    }

    public AbstractC0385ea h() {
        return this.G;
    }

    public long i() {
        return this.f2193e;
    }

    public List<Integer> j() {
        return this.h;
    }

    public List<String> k() {
        return this.j;
    }

    public List<Class<?>> l() {
        return this.k;
    }

    public List<View> m() {
        return this.i;
    }

    public String[] n() {
        return null;
    }

    protected void o() {
        p();
        a.a.b<Animator, a> bVarQ = q();
        for (Animator animator : this.F) {
            if (bVarQ.containsKey(animator)) {
                p();
                a(animator, bVarQ);
            }
        }
        this.F.clear();
        b();
    }

    protected void p() {
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList2.get(i)).b(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public void setEpicenterCallback(b bVar) {
        this.H = bVar;
    }

    public String toString() {
        return a("");
    }

    private void c(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.l;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.m;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.n;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.n.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ha haVar = new ha(view);
                    if (z) {
                        c(haVar);
                    } else {
                        a(haVar);
                    }
                    haVar.f2248c.add(this);
                    b(haVar);
                    if (z) {
                        a(this.s, view, haVar);
                    } else {
                        a(this.t, view, haVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.p;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.q;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.r;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.r.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                c(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.g = timeInterpolator;
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Transition mo4clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.F = new ArrayList<>();
            transition.s = new ia();
            transition.t = new ia();
            transition.w = null;
            transition.x = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Rect d() {
        b bVar = this.H;
        if (bVar == null) {
            return null;
        }
        return bVar.a(this);
    }

    public void e(View view) {
        if (this.C) {
            if (!this.D) {
                a.a.b<Animator, a> bVarQ = q();
                int size = bVarQ.size();
                Ga gaD = va.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    a aVarD = bVarQ.d(i);
                    if (aVarD.f2195a != null && gaD.equals(aVarD.f2198d)) {
                        C0376a.b(bVarQ.b(i));
                    }
                }
                ArrayList<c> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((c) arrayList2.get(i2)).a(this);
                    }
                }
            }
            this.C = false;
        }
    }

    public void a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i = 0; i < iArr.length; i++) {
                if (a(iArr[i])) {
                    if (a(iArr, i)) {
                        throw new IllegalArgumentException("matches contains a duplicate value");
                    }
                } else {
                    throw new IllegalArgumentException("matches contains invalid value");
                }
            }
            this.v = (int[]) iArr.clone();
            return;
        }
        this.v = f2189a;
    }

    private static boolean a(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void a(a.a.b<View, ha> bVar, a.a.b<View, ha> bVar2, a.a.f<View> fVar, a.a.f<View> fVar2) {
        View viewB;
        int iC = fVar.c();
        for (int i = 0; i < iC; i++) {
            View viewC = fVar.c(i);
            if (viewC != null && b(viewC) && (viewB = fVar2.b(fVar.a(i))) != null && b(viewB)) {
                ha haVar = bVar.get(viewC);
                ha haVar2 = bVar2.get(viewB);
                if (haVar != null && haVar2 != null) {
                    this.w.add(haVar);
                    this.x.add(haVar2);
                    bVar.remove(viewC);
                    bVar2.remove(viewB);
                }
            }
        }
    }

    public Transition b(long j) {
        this.f2193e = j;
        return this;
    }

    private void b(a.a.b<View, ha> bVar, a.a.b<View, ha> bVar2) {
        ha haVarRemove;
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View viewB = bVar.b(size);
            if (viewB != null && b(viewB) && (haVarRemove = bVar2.remove(viewB)) != null && b(haVarRemove.f2247b)) {
                this.w.add(bVar.c(size));
                this.x.add(haVarRemove);
            }
        }
    }

    private void a(a.a.b<View, ha> bVar, a.a.b<View, ha> bVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null && b(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && b(view)) {
                ha haVar = bVar.get(viewValueAt);
                ha haVar2 = bVar2.get(view);
                if (haVar != null && haVar2 != null) {
                    this.w.add(haVar);
                    this.x.add(haVar2);
                    bVar.remove(viewValueAt);
                    bVar2.remove(view);
                }
            }
        }
    }

    public void c(View view) {
        if (this.D) {
            return;
        }
        a.a.b<Animator, a> bVarQ = q();
        int size = bVarQ.size();
        Ga gaD = va.d(view);
        for (int i = size - 1; i >= 0; i--) {
            a aVarD = bVarQ.d(i);
            if (aVarD.f2195a != null && gaD.equals(aVarD.f2198d)) {
                C0376a.a(bVarQ.b(i));
            }
        }
        ArrayList<c> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.E.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((c) arrayList2.get(i2)).c(this);
            }
        }
        this.C = true;
    }

    boolean b(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.l;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.m;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.n;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.n.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.o != null && ViewCompat.t(view) != null && this.o.contains(ViewCompat.t(view))) {
            return false;
        }
        if ((this.h.size() == 0 && this.i.size() == 0 && (((arrayList = this.k) == null || arrayList.isEmpty()) && ((arrayList2 = this.j) == null || arrayList2.isEmpty()))) || this.h.contains(Integer.valueOf(id)) || this.i.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.j;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.t(view))) {
            return true;
        }
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.k.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X.f2215c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jB = androidx.core.content.a.i.b(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (jB >= 0) {
            a(jB);
        }
        long jB2 = androidx.core.content.a.i.b(typedArrayObtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (jB2 > 0) {
            b(jB2);
        }
        int iC = androidx.core.content.a.i.c(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iC > 0) {
            a(AnimationUtils.loadInterpolator(context, iC));
        }
        String strA = androidx.core.content.a.i.a(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strA != null) {
            a(b(strA));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(a.a.b<View, ha> bVar, a.a.b<View, ha> bVar2, a.a.b<String, View> bVar3, a.a.b<String, View> bVar4) {
        View view;
        int size = bVar3.size();
        for (int i = 0; i < size; i++) {
            View viewD = bVar3.d(i);
            if (viewD != null && b(viewD) && (view = bVar4.get(bVar3.b(i))) != null && b(view)) {
                ha haVar = bVar.get(viewD);
                ha haVar2 = bVar2.get(view);
                if (haVar != null && haVar2 != null) {
                    this.w.add(haVar);
                    this.x.add(haVar2);
                    bVar.remove(viewD);
                    bVar2.remove(view);
                }
            }
        }
    }

    public ha b(View view, boolean z) {
        TransitionSet transitionSet = this.u;
        if (transitionSet != null) {
            return transitionSet.b(view, z);
        }
        return (z ? this.s : this.t).f2249a.get(view);
    }

    private void a(a.a.b<View, ha> bVar, a.a.b<View, ha> bVar2) {
        for (int i = 0; i < bVar.size(); i++) {
            ha haVarD = bVar.d(i);
            if (b(haVarD.f2247b)) {
                this.w.add(haVarD);
                this.x.add(null);
            }
        }
        for (int i2 = 0; i2 < bVar2.size(); i2++) {
            ha haVarD2 = bVar2.d(i2);
            if (b(haVarD2.f2247b)) {
                this.x.add(haVarD2);
                this.w.add(null);
            }
        }
    }

    protected void b() {
        this.B--;
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList2.get(i)).d(this);
                }
            }
            for (int i2 = 0; i2 < this.s.f2251c.c(); i2++) {
                View viewC = this.s.f2251c.c(i2);
                if (viewC != null) {
                    ViewCompat.c(viewC, false);
                }
            }
            for (int i3 = 0; i3 < this.t.f2251c.c(); i3++) {
                View viewC2 = this.t.f2251c.c(i3);
                if (viewC2 != null) {
                    ViewCompat.c(viewC2, false);
                }
            }
            this.D = true;
        }
    }

    private void a(ia iaVar, ia iaVar2) {
        a.a.b<View, ha> bVar = new a.a.b<>(iaVar.f2249a);
        a.a.b<View, ha> bVar2 = new a.a.b<>(iaVar2.f2249a);
        int i = 0;
        while (true) {
            int[] iArr = this.v;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    b(bVar, bVar2);
                } else if (i2 == 2) {
                    a(bVar, bVar2, iaVar.f2252d, iaVar2.f2252d);
                } else if (i2 == 3) {
                    a(bVar, bVar2, iaVar.f2250b, iaVar2.f2250b);
                } else if (i2 == 4) {
                    a(bVar, bVar2, iaVar.f2251c, iaVar2.f2251c);
                }
                i++;
            } else {
                a(bVar, bVar2);
                return;
            }
        }
    }

    public Transition b(c cVar) {
        ArrayList<c> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    void b(ha haVar) {
        String[] strArrA;
        if (this.G == null || haVar.f2246a.isEmpty() || (strArrA = this.G.a()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strArrA.length) {
                z = true;
                break;
            } else if (!haVar.f2246a.containsKey(strArrA[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.G.a(haVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(android.view.ViewGroup r21, androidx.transition.ia r22, androidx.transition.ia r23, java.util.ArrayList<androidx.transition.ha> r24, java.util.ArrayList<androidx.transition.ha> r25) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.a(android.view.ViewGroup, androidx.transition.ia, androidx.transition.ia, java.util.ArrayList, java.util.ArrayList):void");
    }

    private void a(Animator animator, a.a.b<Animator, a> bVar) {
        if (animator != null) {
            animator.addListener(new Z(this, bVar));
            a(animator);
        }
    }

    public Transition a(View view) {
        this.i.add(view);
        return this;
    }

    void a(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        a.a.b<String, String> bVar;
        a(z);
        if ((this.h.size() <= 0 && this.i.size() <= 0) || (((arrayList = this.j) != null && !arrayList.isEmpty()) || ((arrayList2 = this.k) != null && !arrayList2.isEmpty()))) {
            c(viewGroup, z);
        } else {
            for (int i = 0; i < this.h.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(this.h.get(i).intValue());
                if (viewFindViewById != null) {
                    ha haVar = new ha(viewFindViewById);
                    if (z) {
                        c(haVar);
                    } else {
                        a(haVar);
                    }
                    haVar.f2248c.add(this);
                    b(haVar);
                    if (z) {
                        a(this.s, viewFindViewById, haVar);
                    } else {
                        a(this.t, viewFindViewById, haVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                View view = this.i.get(i2);
                ha haVar2 = new ha(view);
                if (z) {
                    c(haVar2);
                } else {
                    a(haVar2);
                }
                haVar2.f2248c.add(this);
                b(haVar2);
                if (z) {
                    a(this.s, view, haVar2);
                } else {
                    a(this.t, view, haVar2);
                }
            }
        }
        if (z || (bVar = this.I) == null) {
            return;
        }
        int size = bVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.s.f2252d.remove(this.I.b(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.s.f2252d.put(this.I.d(i4), view2);
            }
        }
    }

    private static void a(ia iaVar, View view, ha haVar) {
        iaVar.f2249a.put(view, haVar);
        int id = view.getId();
        if (id >= 0) {
            if (iaVar.f2250b.indexOfKey(id) >= 0) {
                iaVar.f2250b.put(id, null);
            } else {
                iaVar.f2250b.put(id, view);
            }
        }
        String strT = ViewCompat.t(view);
        if (strT != null) {
            if (iaVar.f2252d.containsKey(strT)) {
                iaVar.f2252d.put(strT, null);
            } else {
                iaVar.f2252d.put(strT, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (iaVar.f2251c.c(itemIdAtPosition) >= 0) {
                    View viewB = iaVar.f2251c.b(itemIdAtPosition);
                    if (viewB != null) {
                        ViewCompat.c(viewB, false);
                        iaVar.f2251c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.c(view, true);
                iaVar.f2251c.c(itemIdAtPosition, view);
            }
        }
    }

    void a(boolean z) {
        if (z) {
            this.s.f2249a.clear();
            this.s.f2250b.clear();
            this.s.f2251c.b();
        } else {
            this.t.f2249a.clear();
            this.t.f2250b.clear();
            this.t.f2251c.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:
    
        if (r3 < 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        r7 = r6.x;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0035, code lost:
    
        r7 = r6.w;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        return r7.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.transition.ha a(android.view.View r7, boolean r8) {
        /*
            r6 = this;
            androidx.transition.TransitionSet r0 = r6.u
            if (r0 == 0) goto L9
            androidx.transition.ha r7 = r0.a(r7, r8)
            return r7
        L9:
            if (r8 == 0) goto Le
            java.util.ArrayList<androidx.transition.ha> r0 = r6.w
            goto L10
        Le:
            java.util.ArrayList<androidx.transition.ha> r0 = r6.x
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = -1
            r4 = 0
        L1a:
            if (r4 >= r2) goto L2e
            java.lang.Object r5 = r0.get(r4)
            androidx.transition.ha r5 = (androidx.transition.ha) r5
            if (r5 != 0) goto L25
            return r1
        L25:
            android.view.View r5 = r5.f2247b
            if (r5 != r7) goto L2b
            r3 = r4
            goto L2e
        L2b:
            int r4 = r4 + 1
            goto L1a
        L2e:
            if (r3 < 0) goto L3e
            if (r8 == 0) goto L35
            java.util.ArrayList<androidx.transition.ha> r7 = r6.x
            goto L37
        L35:
            java.util.ArrayList<androidx.transition.ha> r7 = r6.w
        L37:
            java.lang.Object r7 = r7.get(r3)
            r1 = r7
            androidx.transition.ha r1 = (androidx.transition.ha) r1
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.a(android.view.View, boolean):androidx.transition.ha");
    }

    void a(ViewGroup viewGroup) {
        a aVar;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        a(this.s, this.t);
        a.a.b<Animator, a> bVarQ = q();
        int size = bVarQ.size();
        Ga gaD = va.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animatorB = bVarQ.b(i);
            if (animatorB != null && (aVar = bVarQ.get(animatorB)) != null && aVar.f2195a != null && gaD.equals(aVar.f2198d)) {
                ha haVar = aVar.f2197c;
                View view = aVar.f2195a;
                ha haVarB = b(view, true);
                ha haVarA = a(view, true);
                if (haVarB == null && haVarA == null) {
                    haVarA = this.t.f2249a.get(view);
                }
                if (!(haVarB == null && haVarA == null) && aVar.f2199e.a(haVar, haVarA)) {
                    if (!animatorB.isRunning() && !animatorB.isStarted()) {
                        bVarQ.remove(animatorB);
                    } else {
                        animatorB.cancel();
                    }
                }
            }
        }
        a(viewGroup, this.s, this.t, this.w, this.x);
        o();
    }

    public boolean a(ha haVar, ha haVar2) {
        if (haVar == null || haVar2 == null) {
            return false;
        }
        String[] strArrN = n();
        if (strArrN != null) {
            for (String str : strArrN) {
                if (!a(haVar, haVar2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = haVar.f2246a.keySet().iterator();
        while (it.hasNext()) {
            if (a(haVar, haVar2, it.next())) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(ha haVar, ha haVar2, String str) {
        Object obj = haVar.f2246a.get(str);
        Object obj2 = haVar2.f2246a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void a(Animator animator) {
        if (animator == null) {
            b();
            return;
        }
        if (c() >= 0) {
            animator.setDuration(c());
        }
        if (i() >= 0) {
            animator.setStartDelay(i() + animator.getStartDelay());
        }
        if (e() != null) {
            animator.setInterpolator(e());
        }
        animator.addListener(new C0377aa(this));
        animator.start();
    }

    public Transition a(c cVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(cVar);
        return this;
    }

    public void a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.J = f2190b;
        } else {
            this.J = pathMotion;
        }
    }

    public void a(AbstractC0385ea abstractC0385ea) {
        this.G = abstractC0385ea;
    }

    String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f2194f != -1) {
            str2 = str2 + "dur(" + this.f2194f + ") ";
        }
        if (this.f2193e != -1) {
            str2 = str2 + "dly(" + this.f2193e + ") ";
        }
        if (this.g != null) {
            str2 = str2 + "interp(" + this.g + ") ";
        }
        if (this.h.size() <= 0 && this.i.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.h.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.h.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.h.get(i);
            }
            str3 = str4;
        }
        if (this.i.size() > 0) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.i.get(i2);
            }
        }
        return str3 + ")";
    }
}
