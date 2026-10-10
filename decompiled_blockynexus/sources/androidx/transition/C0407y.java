package androidx.transition;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.transition.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTransitionSupport.java */
/* JADX INFO: loaded from: classes.dex */
class C0407y extends C0379ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f2310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f2311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f2312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f2313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ArrayList f2314f;
    final /* synthetic */ A g;

    C0407y(A a2, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = a2;
        this.f2309a = obj;
        this.f2310b = arrayList;
        this.f2311c = obj2;
        this.f2312d = arrayList2;
        this.f2313e = obj3;
        this.f2314f = arrayList3;
    }

    @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
    public void b(Transition transition) {
        Object obj = this.f2309a;
        if (obj != null) {
            this.g.a(obj, this.f2310b, (ArrayList<View>) null);
        }
        Object obj2 = this.f2311c;
        if (obj2 != null) {
            this.g.a(obj2, this.f2312d, (ArrayList<View>) null);
        }
        Object obj3 = this.f2313e;
        if (obj3 != null) {
            this.g.a(obj3, this.f2314f, (ArrayList<View>) null);
        }
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        transition.b(this);
    }
}
