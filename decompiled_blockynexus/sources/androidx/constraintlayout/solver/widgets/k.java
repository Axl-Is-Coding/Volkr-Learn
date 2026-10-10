package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends ConstraintWidget {
    protected ConstraintWidget[] va = new ConstraintWidget[4];
    protected int wa = 0;

    public void J() {
        this.wa = 0;
    }

    public void b(ConstraintWidget constraintWidget) {
        int i = this.wa + 1;
        ConstraintWidget[] constraintWidgetArr = this.va;
        if (i > constraintWidgetArr.length) {
            this.va = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.va;
        int i2 = this.wa;
        constraintWidgetArr2[i2] = constraintWidget;
        this.wa = i2 + 1;
    }
}
