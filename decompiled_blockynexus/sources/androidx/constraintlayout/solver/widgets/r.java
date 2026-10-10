package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

/* JADX INFO: compiled from: WidgetContainer.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> va = new ArrayList<>();

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void D() {
        this.va.clear();
        super.D();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void H() {
        super.H();
        ArrayList<ConstraintWidget> arrayList = this.va;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.va.get(i);
            constraintWidget.b(g(), h());
            if (!(constraintWidget instanceof g)) {
                constraintWidget.H();
            }
        }
    }

    public g J() {
        ConstraintWidget constraintWidgetK = k();
        g gVar = this instanceof g ? (g) this : null;
        while (constraintWidgetK != null) {
            ConstraintWidget constraintWidgetK2 = constraintWidgetK.k();
            if (constraintWidgetK instanceof g) {
                gVar = (g) constraintWidgetK;
            }
            constraintWidgetK = constraintWidgetK2;
        }
        return gVar;
    }

    public void K() {
        H();
        ArrayList<ConstraintWidget> arrayList = this.va;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.va.get(i);
            if (constraintWidget instanceof r) {
                ((r) constraintWidget).K();
            }
        }
    }

    public void L() {
        this.va.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void a(androidx.constraintlayout.solver.c cVar) {
        super.a(cVar);
        int size = this.va.size();
        for (int i = 0; i < size; i++) {
            this.va.get(i).a(cVar);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        this.va.add(constraintWidget);
        if (constraintWidget.k() != null) {
            ((r) constraintWidget.k()).c(constraintWidget);
        }
        constraintWidget.a((ConstraintWidget) this);
    }

    public void c(ConstraintWidget constraintWidget) {
        this.va.remove(constraintWidget);
        constraintWidget.a((ConstraintWidget) null);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void b(int i, int i2) {
        super.b(i, i2);
        int size = this.va.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.va.get(i3).b(o(), p());
        }
    }
}
