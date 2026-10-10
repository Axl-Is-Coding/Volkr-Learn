package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class A extends androidx.fragment.app.U {
    @Override // androidx.fragment.app.U
    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.U
    public Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo4clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.U
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.a((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.U
    public void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iQ = transitionSet.q();
            while (i < iQ) {
                a(transitionSet.a(i), arrayList);
                i++;
            }
            return;
        }
        if (a(transition) || !androidx.fragment.app.U.a((List) transition.m())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.a(arrayList.get(i));
            i++;
        }
    }

    @Override // androidx.fragment.app.U
    public void b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> listM = transitionSet.m();
        listM.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.U.a(listM, arrayList.get(i));
        }
        listM.add(view);
        arrayList.add(view);
        a(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.U
    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).setEpicenterCallback(new C0405w(this, rect));
        }
    }

    @Override // androidx.fragment.app.U
    public Object b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.a((Transition) obj3);
        }
        return transitionSet;
    }

    private static boolean a(Transition transition) {
        return (androidx.fragment.app.U.a((List) transition.j()) && androidx.fragment.app.U.a((List) transition.k()) && androidx.fragment.app.U.a((List) transition.l())) ? false : true;
    }

    @Override // androidx.fragment.app.U
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.m().clear();
            transitionSet.m().addAll(arrayList2);
            a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.U
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).a(new C0406x(this, view, arrayList));
    }

    @Override // androidx.fragment.app.U
    public Object a(Object obj, Object obj2, Object obj3) {
        Transition transitionB = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (transitionB != null && transition != null) {
            transitionB = new TransitionSet().a(transitionB).a(transition).b(1);
        } else if (transitionB == null) {
            transitionB = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return transitionB;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionB != null) {
            transitionSet.a(transitionB);
        }
        transitionSet.a(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.U
    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).d(view);
        }
    }

    @Override // androidx.fragment.app.U
    public void a(ViewGroup viewGroup, Object obj) {
        C0383da.a(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.U
    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).a(new C0407y(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.U
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iQ = transitionSet.q();
            while (i < iQ) {
                a((Object) transitionSet.a(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (a(transition)) {
            return;
        }
        List<View> listM = transition.m();
        if (listM.size() == arrayList.size() && listM.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.a(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.d(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.U
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).a(view);
        }
    }

    @Override // androidx.fragment.app.U
    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C0408z(this, rect));
        }
    }
}
