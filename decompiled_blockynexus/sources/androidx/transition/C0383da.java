package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: androidx.transition.da, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TransitionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C0383da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Transition f2233a = new AutoTransition();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<a.a.b<ViewGroup, ArrayList<Transition>>>> f2234b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static ArrayList<ViewGroup> f2235c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: androidx.transition.da$a */
    /* JADX INFO: compiled from: TransitionManager.java */
    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Transition f2236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f2237b;

        a(Transition transition, ViewGroup viewGroup) {
            this.f2236a = transition;
            this.f2237b = viewGroup;
        }

        private void a() {
            this.f2237b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2237b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!C0383da.f2235c.remove(this.f2237b)) {
                return true;
            }
            a.a.b<ViewGroup, ArrayList<Transition>> bVarA = C0383da.a();
            ArrayList<Transition> arrayList = bVarA.get(this.f2237b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                bVarA.put(this.f2237b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f2236a);
            this.f2236a.a(new C0381ca(this, bVarA));
            this.f2236a.a(this.f2237b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).e(this.f2237b);
                }
            }
            this.f2236a.a(this.f2237b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            C0383da.f2235c.remove(this.f2237b);
            ArrayList<Transition> arrayList = C0383da.a().get(this.f2237b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f2237b);
                }
            }
            this.f2236a.a(true);
        }
    }

    static a.a.b<ViewGroup, ArrayList<Transition>> a() {
        a.a.b<ViewGroup, ArrayList<Transition>> bVar;
        WeakReference<a.a.b<ViewGroup, ArrayList<Transition>>> weakReference = f2234b.get();
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            return bVar;
        }
        a.a.b<ViewGroup, ArrayList<Transition>> bVar2 = new a.a.b<>();
        f2234b.set(new WeakReference<>(bVar2));
        return bVar2;
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c(viewGroup);
            }
        }
        if (transition != null) {
            transition.a(viewGroup, true);
        }
        O oA = O.a(viewGroup);
        if (oA != null) {
            oA.a();
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (f2235c.contains(viewGroup) || !ViewCompat.C(viewGroup)) {
            return;
        }
        f2235c.add(viewGroup);
        if (transition == null) {
            transition = f2233a;
        }
        Transition transitionMo4clone = transition.mo4clone();
        c(viewGroup, transitionMo4clone);
        O.a(viewGroup, null);
        b(viewGroup, transitionMo4clone);
    }
}
