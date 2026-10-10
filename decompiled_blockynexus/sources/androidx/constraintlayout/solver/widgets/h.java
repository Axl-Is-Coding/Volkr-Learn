package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ConstraintWidgetGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ConstraintWidget> f856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    List<ConstraintWidget> f861f;
    List<ConstraintWidget> g;
    HashSet<ConstraintWidget> h;
    HashSet<ConstraintWidget> i;
    List<ConstraintWidget> j;
    List<ConstraintWidget> k;

    h(List<ConstraintWidget> list) {
        this.f857b = -1;
        this.f858c = -1;
        this.f859d = false;
        this.f860e = new int[]{this.f857b, this.f858c};
        this.f861f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f856a = list;
    }

    public List<ConstraintWidget> a(int i) {
        if (i == 0) {
            return this.f861f;
        }
        if (i == 1) {
            return this.g;
        }
        return null;
    }

    Set<ConstraintWidget> b(int i) {
        if (i == 0) {
            return this.h;
        }
        if (i == 1) {
            return this.i;
        }
        return null;
    }

    void a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            this.h.add(constraintWidget);
        } else if (i == 1) {
            this.i.add(constraintWidget);
        }
    }

    void b() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            a(this.k.get(i));
        }
    }

    List<ConstraintWidget> a() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        int size = this.f856a.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f856a.get(i);
            if (!constraintWidget.ja) {
                a((ArrayList<ConstraintWidget>) this.j, constraintWidget);
            }
        }
        this.k.clear();
        this.k.addAll(this.f856a);
        this.k.removeAll(this.j);
        return this.j;
    }

    h(List<ConstraintWidget> list, boolean z) {
        this.f857b = -1;
        this.f858c = -1;
        this.f859d = false;
        this.f860e = new int[]{this.f857b, this.f858c};
        this.f861f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f856a = list;
        this.f859d = z;
    }

    private void a(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (constraintWidget.la) {
            return;
        }
        arrayList.add(constraintWidget);
        constraintWidget.la = true;
        if (constraintWidget.y()) {
            return;
        }
        if (constraintWidget instanceof k) {
            k kVar = (k) constraintWidget;
            int i = kVar.wa;
            for (int i2 = 0; i2 < i; i2++) {
                a(arrayList, kVar.va[i2]);
            }
        }
        int length = constraintWidget.D.length;
        for (int i3 = 0; i3 < length; i3++) {
            ConstraintAnchor constraintAnchor = constraintWidget.D[i3].f838d;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget2 = constraintAnchor.f836b;
                if (constraintAnchor != null && constraintWidget2 != constraintWidget.k()) {
                    a(arrayList, constraintWidget2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.constraintlayout.solver.widgets.ConstraintWidget r7) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.h.a(androidx.constraintlayout.solver.widgets.ConstraintWidget):void");
    }
}
