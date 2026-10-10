package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: FragmentTransitionCompat21.java */
/* JADX INFO: loaded from: classes.dex */
class N implements Transition.TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f1476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f1477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f1478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f1479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f1480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ArrayList f1481f;
    final /* synthetic */ P g;

    N(P p, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = p;
        this.f1476a = obj;
        this.f1477b = arrayList;
        this.f1478c = obj2;
        this.f1479d = arrayList2;
        this.f1480e = obj3;
        this.f1481f = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Object obj = this.f1476a;
        if (obj != null) {
            this.g.a(obj, this.f1477b, (ArrayList<View>) null);
        }
        Object obj2 = this.f1478c;
        if (obj2 != null) {
            this.g.a(obj2, this.f1479d, (ArrayList<View>) null);
        }
        Object obj3 = this.f1480e;
        if (obj3 != null) {
            this.g.a(obj3, this.f1481f, (ArrayList<View>) null);
        }
    }
}
