package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FragmentTransition.java */
/* JADX INFO: loaded from: classes.dex */
class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1462a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final U f1463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final U f1464c;

    /* JADX INFO: compiled from: FragmentTransition.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Fragment f1465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0323a f1467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Fragment f1468d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1469e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public C0323a f1470f;

        a() {
        }
    }

    static {
        f1463b = Build.VERSION.SDK_INT >= 21 ? new P() : null;
        f1464c = a();
    }

    private static U a() {
        try {
            return (U) Class.forName("androidx.transition.A").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void b(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v, int i, a aVar, View view, a.a.b<String, String> bVar) {
        Fragment fragment;
        Fragment fragment2;
        U uA;
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0343v.u.a() ? (ViewGroup) layoutInflaterFactory2C0343v.u.a(i) : null;
        if (viewGroup == null || (uA = a((fragment2 = aVar.f1468d), (fragment = aVar.f1465a))) == null) {
            return;
        }
        boolean z = aVar.f1466b;
        boolean z2 = aVar.f1469e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objA = a(uA, fragment, z);
        Object objB = b(uA, fragment2, z2);
        Object objB2 = b(uA, viewGroup, view, bVar, aVar, arrayList2, arrayList, objA, objB);
        if (objA == null && objB2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        ArrayList<View> arrayListA = a(uA, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListA2 = a(uA, objA, fragment, arrayList, view);
        a(arrayListA2, 4);
        Object objA2 = a(uA, objA, obj, objB2, fragment, z);
        if (objA2 != null) {
            a(uA, obj, fragment2, arrayListA);
            ArrayList<String> arrayListA3 = uA.a(arrayList);
            uA.a(objA2, objA, arrayListA2, obj, arrayListA, objB2, arrayList);
            uA.a(viewGroup, objA2);
            uA.a(viewGroup, arrayList2, arrayList, arrayListA3, bVar);
            a(arrayListA2, 0);
            uA.b(objB2, arrayList2, arrayList);
        }
    }

    static void a(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v, ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (layoutInflaterFactory2C0343v.s < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            C0323a c0323a = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(c0323a, (SparseArray<a>) sparseArray, z);
            } else {
                a(c0323a, (SparseArray<a>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(layoutInflaterFactory2C0343v.t.c());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                a.a.b<String, String> bVarA = a(iKeyAt, arrayList, arrayList2, i, i2);
                a aVar = (a) sparseArray.valueAt(i4);
                if (z) {
                    b(layoutInflaterFactory2C0343v, iKeyAt, aVar, view, bVarA);
                } else {
                    a(layoutInflaterFactory2C0343v, iKeyAt, aVar, view, bVarA);
                }
            }
        }
    }

    private static a.a.b<String, String> a(int i, ArrayList<C0323a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        a.a.b<String, String> bVar = new a.a.b<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0323a c0323a = arrayList.get(i4);
            if (c0323a.c(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = c0323a.o;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = c0323a.o;
                        arrayList4 = c0323a.p;
                    } else {
                        ArrayList<String> arrayList6 = c0323a.o;
                        arrayList3 = c0323a.p;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = bVar.remove(str2);
                        if (strRemove != null) {
                            bVar.put(str, strRemove);
                        } else {
                            bVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return bVar;
    }

    private static Object b(U u, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return u.b(exitTransition);
    }

    private static Object b(U u, ViewGroup viewGroup, View view, a.a.b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = aVar.f1465a;
        Fragment fragment2 = aVar.f1468d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar.f1466b;
        Object objA = bVar.isEmpty() ? null : a(u, fragment, fragment2, z);
        a.a.b<String, View> bVarB = b(u, bVar, objA, aVar);
        a.a.b<String, View> bVarA = a(u, bVar, objA, aVar);
        if (bVar.isEmpty()) {
            if (bVarB != null) {
                bVarB.clear();
            }
            if (bVarA != null) {
                bVarA.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, bVarB, bVar.keySet());
            a(arrayList2, bVarA, bVar.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, bVarB, true);
        if (obj3 != null) {
            arrayList2.add(view);
            u.b(obj3, view, arrayList);
            a(u, obj3, obj2, bVarB, aVar.f1469e, aVar.f1470f);
            Rect rect2 = new Rect();
            View viewA = a(bVarA, aVar, obj, z);
            if (viewA != null) {
                u.a(obj, rect2);
            }
            rect = rect2;
            view2 = viewA;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.view.s.a(viewGroup, new I(fragment, fragment2, z, bVarA, view2, u, rect));
        return obj3;
    }

    private static void a(U u, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            u.a(obj, fragment.getView(), arrayList);
            androidx.core.view.s.a(fragment.mContainer, new G(arrayList));
        }
    }

    private static void a(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v, int i, a aVar, View view, a.a.b<String, String> bVar) {
        Fragment fragment;
        Fragment fragment2;
        U uA;
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0343v.u.a() ? (ViewGroup) layoutInflaterFactory2C0343v.u.a(i) : null;
        if (viewGroup == null || (uA = a((fragment2 = aVar.f1468d), (fragment = aVar.f1465a))) == null) {
            return;
        }
        boolean z = aVar.f1466b;
        boolean z2 = aVar.f1469e;
        Object objA = a(uA, fragment, z);
        Object objB = b(uA, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objA2 = a(uA, viewGroup, view, bVar, aVar, (ArrayList<View>) arrayList, arrayList2, objA, objB);
        if (objA == null && objA2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        ArrayList<View> arrayListA = a(uA, obj, fragment2, (ArrayList<View>) arrayList, view);
        Object obj2 = (arrayListA == null || arrayListA.isEmpty()) ? null : obj;
        uA.a(objA, view);
        Object objA3 = a(uA, objA, obj2, objA2, fragment, aVar.f1466b);
        if (objA3 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            uA.a(objA3, objA, arrayList3, obj2, arrayListA, objA2, arrayList2);
            a(uA, viewGroup, fragment, view, arrayList2, objA, arrayList3, obj2, arrayListA);
            uA.a((View) viewGroup, arrayList2, (Map<String, String>) bVar);
            uA.a(viewGroup, objA3);
            uA.a(viewGroup, arrayList2, (Map<String, String>) bVar);
        }
    }

    private static a.a.b<String, View> b(U u, a.a.b<String, String> bVar, Object obj, a aVar) {
        androidx.core.app.q exitTransitionCallback;
        ArrayList<String> arrayList;
        if (!bVar.isEmpty() && obj != null) {
            Fragment fragment = aVar.f1468d;
            a.a.b<String, View> bVar2 = new a.a.b<>();
            u.a((Map<String, View>) bVar2, fragment.requireView());
            C0323a c0323a = aVar.f1470f;
            if (aVar.f1469e) {
                exitTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = c0323a.p;
            } else {
                exitTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = c0323a.o;
            }
            bVar2.a((Collection<?>) arrayList);
            if (exitTransitionCallback != null) {
                exitTransitionCallback.a(arrayList, bVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = bVar2.get(str);
                    if (view == null) {
                        bVar.remove(str);
                    } else if (!str.equals(ViewCompat.t(view))) {
                        bVar.put(ViewCompat.t(view), bVar.remove(str));
                    }
                }
            } else {
                bVar.a((Collection<?>) bVar2.keySet());
            }
            return bVar2;
        }
        bVar.clear();
        return null;
    }

    private static void a(U u, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        androidx.core.view.s.a(viewGroup, new H(obj, u, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static U a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        U u = f1463b;
        if (u != null && a(u, arrayList)) {
            return f1463b;
        }
        U u2 = f1464c;
        if (u2 != null && a(u2, arrayList)) {
            return f1464c;
        }
        if (f1463b == null && f1464c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static void b(C0323a c0323a, SparseArray<a> sparseArray, boolean z) {
        if (c0323a.s.u.a()) {
            for (int size = c0323a.f1416a.size() - 1; size >= 0; size--) {
                a(c0323a, c0323a.f1416a.get(size), sparseArray, true, z);
            }
        }
    }

    private static boolean a(U u, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!u.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(U u, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return u.c(u.b(sharedElementEnterTransition));
    }

    private static Object a(U u, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return u.b(enterTransition);
    }

    private static void a(ArrayList<View> arrayList, a.a.b<String, View> bVar, Collection<String> collection) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View viewD = bVar.d(size);
            if (collection.contains(ViewCompat.t(viewD))) {
                arrayList.add(viewD);
            }
        }
    }

    private static Object a(U u, ViewGroup viewGroup, View view, a.a.b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object objA;
        a.a.b<String, String> bVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = aVar.f1465a;
        Fragment fragment2 = aVar.f1468d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar.f1466b;
        if (bVar.isEmpty()) {
            bVar2 = bVar;
            objA = null;
        } else {
            objA = a(u, fragment, fragment2, z);
            bVar2 = bVar;
        }
        a.a.b<String, View> bVarB = b(u, bVar2, objA, aVar);
        if (bVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(bVarB.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(fragment, fragment2, z, bVarB, true);
        if (obj3 != null) {
            rect = new Rect();
            u.b(obj3, view, arrayList);
            a(u, obj3, obj2, bVarB, aVar.f1469e, aVar.f1470f);
            if (obj != null) {
                u.a(obj, rect);
            }
        } else {
            rect = null;
        }
        androidx.core.view.s.a(viewGroup, new J(u, bVar, obj3, aVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    static a.a.b<String, View> a(U u, a.a.b<String, String> bVar, Object obj, a aVar) {
        androidx.core.app.q enterTransitionCallback;
        ArrayList<String> arrayList;
        String strA;
        Fragment fragment = aVar.f1465a;
        View view = fragment.getView();
        if (!bVar.isEmpty() && obj != null && view != null) {
            a.a.b<String, View> bVar2 = new a.a.b<>();
            u.a((Map<String, View>) bVar2, view);
            C0323a c0323a = aVar.f1467c;
            if (aVar.f1466b) {
                enterTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = c0323a.o;
            } else {
                enterTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = c0323a.p;
            }
            if (arrayList != null) {
                bVar2.a((Collection<?>) arrayList);
                bVar2.a((Collection<?>) bVar.values());
            }
            if (enterTransitionCallback != null) {
                enterTransitionCallback.a(arrayList, bVar2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view2 = bVar2.get(str);
                    if (view2 == null) {
                        String strA2 = a(bVar, str);
                        if (strA2 != null) {
                            bVar.remove(strA2);
                        }
                    } else if (!str.equals(ViewCompat.t(view2)) && (strA = a(bVar, str)) != null) {
                        bVar.put(strA, ViewCompat.t(view2));
                    }
                }
            } else {
                a(bVar, bVar2);
            }
            return bVar2;
        }
        bVar.clear();
        return null;
    }

    private static String a(a.a.b<String, String> bVar, String str) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(bVar.d(i))) {
                return bVar.b(i);
            }
        }
        return null;
    }

    static View a(a.a.b<String, View> bVar, a aVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        C0323a c0323a = aVar.f1467c;
        if (obj == null || bVar == null || (arrayList = c0323a.o) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = c0323a.o.get(0);
        } else {
            str = c0323a.p.get(0);
        }
        return bVar.get(str);
    }

    private static void a(U u, Object obj, Object obj2, a.a.b<String, View> bVar, boolean z, C0323a c0323a) {
        String str;
        ArrayList<String> arrayList = c0323a.o;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = c0323a.p.get(0);
        } else {
            str = c0323a.o.get(0);
        }
        View view = bVar.get(str);
        u.c(obj, view);
        if (obj2 != null) {
            u.c(obj2, view);
        }
    }

    private static void a(a.a.b<String, String> bVar, a.a.b<String, View> bVar2) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            if (!bVar2.containsKey(bVar.d(size))) {
                bVar.c(size);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, a.a.b<String, View> bVar, boolean z2) {
        androidx.core.app.q enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = bVar == null ? 0 : bVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(bVar.b(i));
                arrayList.add(bVar.d(i));
            }
            if (z2) {
                enterTransitionCallback.b(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.a(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    static ArrayList<View> a(U u, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            u.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        u.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static Object a(U u, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean allowEnterTransitionOverlap;
        if (obj == null || obj2 == null || fragment == null) {
            allowEnterTransitionOverlap = true;
        } else if (z) {
            allowEnterTransitionOverlap = fragment.getAllowReturnTransitionOverlap();
        } else {
            allowEnterTransitionOverlap = fragment.getAllowEnterTransitionOverlap();
        }
        if (allowEnterTransitionOverlap) {
            return u.b(obj2, obj, obj3);
        }
        return u.a(obj2, obj, obj3);
    }

    public static void a(C0323a c0323a, SparseArray<a> sparseArray, boolean z) {
        int size = c0323a.f1416a.size();
        for (int i = 0; i < size; i++) {
            a(c0323a, c0323a.f1416a.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(androidx.fragment.app.C0323a r16, androidx.fragment.app.F.a r17, android.util.SparseArray<androidx.fragment.app.K.a> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.K.a(androidx.fragment.app.a, androidx.fragment.app.F$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }
}
