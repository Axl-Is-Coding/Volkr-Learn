package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

/* JADX INFO: compiled from: Snapshot.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<a> f875e = new ArrayList<>();

    /* JADX INFO: compiled from: Snapshot.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ConstraintAnchor f876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ConstraintAnchor f877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ConstraintAnchor.Strength f879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f880e;

        public a(ConstraintAnchor constraintAnchor) {
            this.f876a = constraintAnchor;
            this.f877b = constraintAnchor.g();
            this.f878c = constraintAnchor.b();
            this.f879d = constraintAnchor.f();
            this.f880e = constraintAnchor.a();
        }

        public void a(ConstraintWidget constraintWidget) {
            constraintWidget.a(this.f876a.h()).a(this.f877b, this.f878c, this.f879d, this.f880e);
        }

        public void b(ConstraintWidget constraintWidget) {
            this.f876a = constraintWidget.a(this.f876a.h());
            ConstraintAnchor constraintAnchor = this.f876a;
            if (constraintAnchor != null) {
                this.f877b = constraintAnchor.g();
                this.f878c = this.f876a.b();
                this.f879d = this.f876a.f();
                this.f880e = this.f876a.a();
                return;
            }
            this.f877b = null;
            this.f878c = 0;
            this.f879d = ConstraintAnchor.Strength.STRONG;
            this.f880e = 0;
        }
    }

    public q(ConstraintWidget constraintWidget) {
        this.f871a = constraintWidget.v();
        this.f872b = constraintWidget.w();
        this.f873c = constraintWidget.s();
        this.f874d = constraintWidget.i();
        ArrayList<ConstraintAnchor> arrayListB = constraintWidget.b();
        int size = arrayListB.size();
        for (int i = 0; i < size; i++) {
            this.f875e.add(new a(arrayListB.get(i)));
        }
    }

    public void a(ConstraintWidget constraintWidget) {
        constraintWidget.r(this.f871a);
        constraintWidget.s(this.f872b);
        constraintWidget.o(this.f873c);
        constraintWidget.g(this.f874d);
        int size = this.f875e.size();
        for (int i = 0; i < size; i++) {
            this.f875e.get(i).a(constraintWidget);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        this.f871a = constraintWidget.v();
        this.f872b = constraintWidget.w();
        this.f873c = constraintWidget.s();
        this.f874d = constraintWidget.i();
        int size = this.f875e.size();
        for (int i = 0; i < size; i++) {
            this.f875e.get(i).b(constraintWidget);
        }
    }
}
