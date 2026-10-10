package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.LayoutInflaterFactory2C0343v;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BackStackRecord.java */
/* JADX INFO: loaded from: classes.dex */
final class C0323a extends F implements AbstractC0336n.a, LayoutInflaterFactory2C0343v.e {
    final LayoutInflaterFactory2C0343v s;
    boolean t;
    int u = -1;

    public C0323a(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v) {
        this.s = layoutInflaterFactory2C0343v;
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    @Override // androidx.fragment.app.F
    public F b(Fragment fragment) {
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = fragment.mFragmentManager;
        if (layoutInflaterFactory2C0343v == null || layoutInflaterFactory2C0343v == this.s) {
            super.b(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.F
    public F c(Fragment fragment) {
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = fragment.mFragmentManager;
        if (layoutInflaterFactory2C0343v == null || layoutInflaterFactory2C0343v == this.s) {
            super.c(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.F
    public F d(Fragment fragment) {
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = fragment.mFragmentManager;
        if (layoutInflaterFactory2C0343v == null || layoutInflaterFactory2C0343v == this.s) {
            super.d(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.F
    public F e(Fragment fragment) {
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = fragment.mFragmentManager;
        if (layoutInflaterFactory2C0343v == null || layoutInflaterFactory2C0343v == this.s) {
            super.e(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.F
    public boolean f() {
        return this.f1416a.isEmpty();
    }

    void g() {
        int size = this.f1416a.size();
        for (int i = 0; i < size; i++) {
            F.a aVar = this.f1416a.get(i);
            Fragment fragment = aVar.f1423b;
            if (fragment != null) {
                fragment.setNextTransition(this.f1421f, this.g);
            }
            switch (aVar.f1422a) {
                case 1:
                    fragment.setNextAnim(aVar.f1424c);
                    this.s.a(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1422a);
                case 3:
                    fragment.setNextAnim(aVar.f1425d);
                    this.s.p(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1425d);
                    this.s.i(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1424c);
                    this.s.u(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1425d);
                    this.s.e(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1424c);
                    this.s.c(fragment);
                    break;
                case 8:
                    this.s.t(fragment);
                    break;
                case 9:
                    this.s.t(null);
                    break;
                case 10:
                    this.s.a(fragment, aVar.h);
                    break;
            }
            if (!this.q && aVar.f1422a != 1 && fragment != null) {
                this.s.m(fragment);
            }
        }
        if (this.q) {
            return;
        }
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = this.s;
        layoutInflaterFactory2C0343v.a(layoutInflaterFactory2C0343v.s, true);
    }

    @Override // androidx.fragment.app.AbstractC0336n.a
    public String getName() {
        return this.j;
    }

    boolean h() {
        for (int i = 0; i < this.f1416a.size(); i++) {
            if (b(this.f1416a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        if (this.r != null) {
            for (int i = 0; i < this.r.size(); i++) {
                this.r.get(i).run();
            }
            this.r = null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.u >= 0) {
            sb.append(" #");
            sb.append(this.u);
        }
        if (this.j != null) {
            sb.append(" ");
            sb.append(this.j);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.j);
            printWriter.print(" mIndex=");
            printWriter.print(this.u);
            printWriter.print(" mCommitted=");
            printWriter.println(this.t);
            if (this.f1421f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1421f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.f1417b != 0 || this.f1418c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1417b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1418c));
            }
            if (this.f1419d != 0 || this.f1420e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1419d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1420e));
            }
            if (this.k != 0 || this.l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.l);
            }
            if (this.m != 0 || this.n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.n);
            }
        }
        if (this.f1416a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1416a.size();
        for (int i = 0; i < size; i++) {
            F.a aVar = this.f1416a.get(i);
            switch (aVar.f1422a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1422a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1423b);
            if (z) {
                if (aVar.f1424c != 0 || aVar.f1425d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1424c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1425d));
                }
                if (aVar.f1426e != 0 || aVar.f1427f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1426e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1427f));
                }
            }
        }
    }

    void b(int i) {
        if (this.h) {
            if (LayoutInflaterFactory2C0343v.f1531c) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f1416a.size();
            for (int i2 = 0; i2 < size; i2++) {
                F.a aVar = this.f1416a.get(i2);
                Fragment fragment = aVar.f1423b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (LayoutInflaterFactory2C0343v.f1531c) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1423b + " to " + aVar.f1423b.mBackStackNesting);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.F
    public void c() {
        e();
        this.s.b((LayoutInflaterFactory2C0343v.e) this, false);
    }

    @Override // androidx.fragment.app.F
    public void d() {
        e();
        this.s.b((LayoutInflaterFactory2C0343v.e) this, true);
    }

    boolean c(int i) {
        int size = this.f1416a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f1416a.get(i2).f1423b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.F
    public int b() {
        return a(true);
    }

    void b(boolean z) {
        for (int size = this.f1416a.size() - 1; size >= 0; size--) {
            F.a aVar = this.f1416a.get(size);
            Fragment fragment = aVar.f1423b;
            if (fragment != null) {
                fragment.setNextTransition(LayoutInflaterFactory2C0343v.e(this.f1421f), this.g);
            }
            switch (aVar.f1422a) {
                case 1:
                    fragment.setNextAnim(aVar.f1427f);
                    this.s.p(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1422a);
                case 3:
                    fragment.setNextAnim(aVar.f1426e);
                    this.s.a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f1426e);
                    this.s.u(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f1427f);
                    this.s.i(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f1426e);
                    this.s.c(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f1427f);
                    this.s.e(fragment);
                    break;
                case 8:
                    this.s.t(null);
                    break;
                case 9:
                    this.s.t(fragment);
                    break;
                case 10:
                    this.s.a(fragment, aVar.g);
                    break;
            }
            if (!this.q && aVar.f1422a != 3 && fragment != null) {
                this.s.m(fragment);
            }
        }
        if (this.q || !z) {
            return;
        }
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = this.s;
        layoutInflaterFactory2C0343v.a(layoutInflaterFactory2C0343v.s, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment b(java.util.ArrayList<androidx.fragment.app.Fragment> r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.fragment.app.F$a> r0 = r5.f1416a
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<androidx.fragment.app.F$a> r2 = r5.f1416a
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.F$a r2 = (androidx.fragment.app.F.a) r2
            int r3 = r2.f1422a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.Lifecycle$State r3 = r2.g
            r2.h = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f1423b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f1423b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f1423b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0323a.b(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    private static boolean b(F.a aVar) {
        Fragment fragment = aVar.f1423b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // androidx.fragment.app.F
    void a(int i, Fragment fragment, String str, int i2) {
        super.a(i, fragment, str, i2);
        fragment.mFragmentManager = this.s;
    }

    @Override // androidx.fragment.app.F
    public F a(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager == this.s) {
            if (state.isAtLeast(Lifecycle.State.CREATED)) {
                super.a(fragment, state);
                return this;
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + Lifecycle.State.CREATED);
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.s);
    }

    @Override // androidx.fragment.app.F
    public int a() {
        return a(false);
    }

    int a(boolean z) {
        if (!this.t) {
            if (LayoutInflaterFactory2C0343v.f1531c) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new androidx.core.f.b("FragmentManager"));
                a("  ", printWriter);
                printWriter.close();
            }
            this.t = true;
            if (this.h) {
                this.u = this.s.b(this);
            } else {
                this.u = -1;
            }
            this.s.a(this, z);
            return this.u;
        }
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.LayoutInflaterFactory2C0343v.e
    public boolean a(ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2) {
        if (LayoutInflaterFactory2C0343v.f1531c) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.h) {
            return true;
        }
        this.s.a(this);
        return true;
    }

    boolean a(ArrayList<C0323a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1416a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f1416a.get(i4).f1423b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0323a c0323a = arrayList.get(i6);
                    int size2 = c0323a.f1416a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = c0323a.f1416a.get(i7).f1423b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.fragment.app.Fragment a(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r4 = r18
            r3 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.F$a> r5 = r0.f1416a
            int r5 = r5.size()
            if (r3 >= r5) goto Lbe
            java.util.ArrayList<androidx.fragment.app.F$a> r5 = r0.f1416a
            java.lang.Object r5 = r5.get(r3)
            androidx.fragment.app.F$a r5 = (androidx.fragment.app.F.a) r5
            int r6 = r5.f1422a
            r7 = 0
            r8 = 1
            if (r6 == r8) goto Lb6
            r9 = 2
            r10 = 3
            r11 = 9
            if (r6 == r9) goto L58
            if (r6 == r10) goto L41
            r9 = 6
            if (r6 == r9) goto L41
            r7 = 7
            if (r6 == r7) goto Lb6
            r7 = 8
            if (r6 == r7) goto L31
            goto Lbb
        L31:
            java.util.ArrayList<androidx.fragment.app.F$a> r6 = r0.f1416a
            androidx.fragment.app.F$a r7 = new androidx.fragment.app.F$a
            r7.<init>(r11, r4)
            r6.add(r3, r7)
            int r3 = r3 + 1
            androidx.fragment.app.Fragment r4 = r5.f1423b
            goto Lbb
        L41:
            androidx.fragment.app.Fragment r6 = r5.f1423b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f1423b
            if (r5 != r4) goto Lbb
            java.util.ArrayList<androidx.fragment.app.F$a> r4 = r0.f1416a
            androidx.fragment.app.F$a r6 = new androidx.fragment.app.F$a
            r6.<init>(r11, r5)
            r4.add(r3, r6)
            int r3 = r3 + 1
            r4 = r7
            goto Lbb
        L58:
            androidx.fragment.app.Fragment r6 = r5.f1423b
            int r9 = r6.mContainerId
            int r12 = r17.size()
            int r12 = r12 - r8
            r13 = r4
            r4 = r3
            r3 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r9) goto La1
            if (r14 != r6) goto L74
            r3 = 1
            goto La1
        L74:
            if (r14 != r13) goto L83
            java.util.ArrayList<androidx.fragment.app.F$a> r13 = r0.f1416a
            androidx.fragment.app.F$a r15 = new androidx.fragment.app.F$a
            r15.<init>(r11, r14)
            r13.add(r4, r15)
            int r4 = r4 + 1
            r13 = r7
        L83:
            androidx.fragment.app.F$a r15 = new androidx.fragment.app.F$a
            r15.<init>(r10, r14)
            int r2 = r5.f1424c
            r15.f1424c = r2
            int r2 = r5.f1426e
            r15.f1426e = r2
            int r2 = r5.f1425d
            r15.f1425d = r2
            int r2 = r5.f1427f
            r15.f1427f = r2
            java.util.ArrayList<androidx.fragment.app.F$a> r2 = r0.f1416a
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r8
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r3 == 0) goto Lae
            java.util.ArrayList<androidx.fragment.app.F$a> r2 = r0.f1416a
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lb3
        Lae:
            r5.f1422a = r8
            r1.add(r6)
        Lb3:
            r3 = r4
            r4 = r13
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.f1423b
            r1.add(r2)
        Lbb:
            int r3 = r3 + r8
            goto L7
        Lbe:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0323a.a(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    void a(Fragment.b bVar) {
        for (int i = 0; i < this.f1416a.size(); i++) {
            F.a aVar = this.f1416a.get(i);
            if (b(aVar)) {
                aVar.f1423b.setOnStartEnterTransitionListener(bVar);
            }
        }
    }
}
