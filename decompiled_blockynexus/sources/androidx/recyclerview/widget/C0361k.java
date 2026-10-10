package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.recyclerview.widget.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class C0361k extends Y {
    private static TimeInterpolator h;
    private ArrayList<RecyclerView.w> i = new ArrayList<>();
    private ArrayList<RecyclerView.w> j = new ArrayList<>();
    private ArrayList<b> k = new ArrayList<>();
    private ArrayList<a> l = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.w>> m = new ArrayList<>();
    ArrayList<ArrayList<b>> n = new ArrayList<>();
    ArrayList<ArrayList<a>> o = new ArrayList<>();
    ArrayList<RecyclerView.w> p = new ArrayList<>();
    ArrayList<RecyclerView.w> q = new ArrayList<>();
    ArrayList<RecyclerView.w> r = new ArrayList<>();
    ArrayList<RecyclerView.w> s = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: androidx.recyclerview.widget.k$b */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.w f2002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2005d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2006e;

        b(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
            this.f2002a = wVar;
            this.f2003b = i;
            this.f2004c = i2;
            this.f2005d = i3;
            this.f2006e = i4;
        }
    }

    private void u(RecyclerView.w wVar) {
        View view = wVar.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.r.add(wVar);
        viewPropertyAnimatorAnimate.setDuration(f()).alpha(WheelView.DividerConfig.FILL).setListener(new C0356f(this, wVar, viewPropertyAnimatorAnimate, view)).start();
    }

    private void v(RecyclerView.w wVar) {
        if (h == null) {
            h = new ValueAnimator().getInterpolator();
        }
        wVar.itemView.animate().setInterpolator(h);
        d(wVar);
    }

    @Override // androidx.recyclerview.widget.Y
    public boolean a(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
        View view = wVar.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) wVar.itemView.getTranslationY());
        v(wVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            j(wVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.k.add(new b(wVar, translationX, translationY, i3, i4));
        return true;
    }

    void b(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
        View view = wVar.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(WheelView.DividerConfig.FILL);
        }
        if (i6 != 0) {
            view.animate().translationY(WheelView.DividerConfig.FILL);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.q.add(wVar);
        viewPropertyAnimatorAnimate.setDuration(e()).setListener(new C0358h(this, wVar, i5, view, i6, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d(RecyclerView.w wVar) {
        View view = wVar.itemView;
        view.animate().cancel();
        int size = this.k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.k.get(size).f2002a == wVar) {
                view.setTranslationY(WheelView.DividerConfig.FILL);
                view.setTranslationX(WheelView.DividerConfig.FILL);
                j(wVar);
                this.k.remove(size);
            }
        }
        a(this.l, wVar);
        if (this.i.remove(wVar)) {
            view.setAlpha(1.0f);
            l(wVar);
        }
        if (this.j.remove(wVar)) {
            view.setAlpha(1.0f);
            h(wVar);
        }
        for (int size2 = this.o.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.o.get(size2);
            a(arrayList, wVar);
            if (arrayList.isEmpty()) {
                this.o.remove(size2);
            }
        }
        for (int size3 = this.n.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.n.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f2002a == wVar) {
                    view.setTranslationY(WheelView.DividerConfig.FILL);
                    view.setTranslationX(WheelView.DividerConfig.FILL);
                    j(wVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.n.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.w> arrayList3 = this.m.get(size5);
            if (arrayList3.remove(wVar)) {
                view.setAlpha(1.0f);
                h(wVar);
                if (arrayList3.isEmpty()) {
                    this.m.remove(size5);
                }
            }
        }
        this.r.remove(wVar);
        this.p.remove(wVar);
        this.s.remove(wVar);
        this.q.remove(wVar);
        j();
    }

    @Override // androidx.recyclerview.widget.Y
    public boolean f(RecyclerView.w wVar) {
        v(wVar);
        wVar.itemView.setAlpha(WheelView.DividerConfig.FILL);
        this.j.add(wVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.Y
    public boolean g(RecyclerView.w wVar) {
        v(wVar);
        this.i.add(wVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void i() {
        boolean z = !this.i.isEmpty();
        boolean z2 = !this.k.isEmpty();
        boolean z3 = !this.l.isEmpty();
        boolean z4 = !this.j.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.w> it = this.i.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.i.clear();
            if (z2) {
                ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.k);
                this.n.add(arrayList);
                this.k.clear();
                RunnableC0353c runnableC0353c = new RunnableC0353c(this, arrayList);
                if (z) {
                    ViewCompat.a(arrayList.get(0).f2002a.itemView, runnableC0353c, f());
                } else {
                    runnableC0353c.run();
                }
            }
            if (z3) {
                ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.l);
                this.o.add(arrayList2);
                this.l.clear();
                RunnableC0354d runnableC0354d = new RunnableC0354d(this, arrayList2);
                if (z) {
                    ViewCompat.a(arrayList2.get(0).f1996a.itemView, runnableC0354d, f());
                } else {
                    runnableC0354d.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.w> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.j);
                this.m.add(arrayList3);
                this.j.clear();
                RunnableC0355e runnableC0355e = new RunnableC0355e(this, arrayList3);
                if (z || z2 || z3) {
                    ViewCompat.a(arrayList3.get(0).itemView, runnableC0355e, (z ? f() : 0L) + Math.max(z2 ? e() : 0L, z3 ? d() : 0L));
                } else {
                    runnableC0355e.run();
                }
            }
        }
    }

    void j() {
        if (g()) {
            return;
        }
        a();
    }

    void t(RecyclerView.w wVar) {
        View view = wVar.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.p.add(wVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(c()).setListener(new C0357g(this, wVar, view, viewPropertyAnimatorAnimate)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: androidx.recyclerview.widget.k$a */
    /* JADX INFO: compiled from: DefaultItemAnimator.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.w f1996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.w f1997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1999d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2000e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2001f;

        private a(RecyclerView.w wVar, RecyclerView.w wVar2) {
            this.f1996a = wVar;
            this.f1997b = wVar2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1996a + ", newHolder=" + this.f1997b + ", fromX=" + this.f1998c + ", fromY=" + this.f1999d + ", toX=" + this.f2000e + ", toY=" + this.f2001f + '}';
        }

        a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4) {
            this(wVar, wVar2);
            this.f1998c = i;
            this.f1999d = i2;
            this.f2000e = i3;
            this.f2001f = i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean g() {
        return (this.j.isEmpty() && this.l.isEmpty() && this.k.isEmpty() && this.i.isEmpty() && this.q.isEmpty() && this.r.isEmpty() && this.p.isEmpty() && this.s.isEmpty() && this.n.isEmpty() && this.m.isEmpty() && this.o.isEmpty()) ? false : true;
    }

    private void b(a aVar) {
        RecyclerView.w wVar = aVar.f1996a;
        if (wVar != null) {
            a(aVar, wVar);
        }
        RecyclerView.w wVar2 = aVar.f1997b;
        if (wVar2 != null) {
            a(aVar, wVar2);
        }
    }

    @Override // androidx.recyclerview.widget.Y
    public boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4) {
        if (wVar == wVar2) {
            return a(wVar, i, i2, i3, i4);
        }
        float translationX = wVar.itemView.getTranslationX();
        float translationY = wVar.itemView.getTranslationY();
        float alpha = wVar.itemView.getAlpha();
        v(wVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        wVar.itemView.setTranslationX(translationX);
        wVar.itemView.setTranslationY(translationY);
        wVar.itemView.setAlpha(alpha);
        if (wVar2 != null) {
            v(wVar2);
            wVar2.itemView.setTranslationX(-i5);
            wVar2.itemView.setTranslationY(-i6);
            wVar2.itemView.setAlpha(WheelView.DividerConfig.FILL);
        }
        this.l.add(new a(wVar, wVar2, i, i2, i3, i4));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void b() {
        int size = this.k.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.k.get(size);
            View view = bVar.f2002a.itemView;
            view.setTranslationY(WheelView.DividerConfig.FILL);
            view.setTranslationX(WheelView.DividerConfig.FILL);
            j(bVar.f2002a);
            this.k.remove(size);
        }
        for (int size2 = this.i.size() - 1; size2 >= 0; size2--) {
            l(this.i.get(size2));
            this.i.remove(size2);
        }
        int size3 = this.j.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.w wVar = this.j.get(size3);
            wVar.itemView.setAlpha(1.0f);
            h(wVar);
            this.j.remove(size3);
        }
        for (int size4 = this.l.size() - 1; size4 >= 0; size4--) {
            b(this.l.get(size4));
        }
        this.l.clear();
        if (g()) {
            for (int size5 = this.n.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.n.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f2002a.itemView;
                    view2.setTranslationY(WheelView.DividerConfig.FILL);
                    view2.setTranslationX(WheelView.DividerConfig.FILL);
                    j(bVar2.f2002a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.n.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.m.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.w> arrayList2 = this.m.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.w wVar2 = arrayList2.get(size8);
                    wVar2.itemView.setAlpha(1.0f);
                    h(wVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.o.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.o.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.o.remove(arrayList3);
                    }
                }
            }
            a(this.r);
            a(this.q);
            a(this.p);
            a(this.s);
            a();
        }
    }

    void a(a aVar) {
        RecyclerView.w wVar = aVar.f1996a;
        View view = wVar == null ? null : wVar.itemView;
        RecyclerView.w wVar2 = aVar.f1997b;
        View view2 = wVar2 != null ? wVar2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(d());
            this.s.add(aVar.f1996a);
            duration.translationX(aVar.f2000e - aVar.f1998c);
            duration.translationY(aVar.f2001f - aVar.f1999d);
            duration.alpha(WheelView.DividerConfig.FILL).setListener(new C0359i(this, aVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.s.add(aVar.f1997b);
            viewPropertyAnimatorAnimate.translationX(WheelView.DividerConfig.FILL).translationY(WheelView.DividerConfig.FILL).setDuration(d()).alpha(1.0f).setListener(new C0360j(this, aVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    private void a(List<a> list, RecyclerView.w wVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, wVar) && aVar.f1996a == null && aVar.f1997b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, RecyclerView.w wVar) {
        boolean z = false;
        if (aVar.f1997b == wVar) {
            aVar.f1997b = null;
        } else {
            if (aVar.f1996a != wVar) {
                return false;
            }
            aVar.f1996a = null;
            z = true;
        }
        wVar.itemView.setAlpha(1.0f);
        wVar.itemView.setTranslationX(WheelView.DividerConfig.FILL);
        wVar.itemView.setTranslationY(WheelView.DividerConfig.FILL);
        a(wVar, z);
        return true;
    }

    void a(List<RecyclerView.w> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.w wVar, List<Object> list) {
        return !list.isEmpty() || super.a(wVar, list);
    }
}
