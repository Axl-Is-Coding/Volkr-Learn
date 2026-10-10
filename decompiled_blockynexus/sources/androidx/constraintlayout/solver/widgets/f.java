package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* JADX INFO: compiled from: ConstraintWidget.java */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f855b = new int[ConstraintWidget.DimensionBehaviour.values().length];

    static {
        try {
            f855b[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f855b[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f855b[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f855b[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f854a = new int[ConstraintAnchor.Type.values().length];
        try {
            f854a[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f854a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f854a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f854a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f854a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f854a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f854a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f854a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f854a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
        } catch (NoSuchFieldError unused13) {
        }
    }
}
