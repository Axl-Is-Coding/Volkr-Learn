package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewUtilsBase.java */
/* JADX INFO: loaded from: classes.dex */
class Ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f2123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f2125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f2127e;

    Ba() {
    }

    public void a(View view, float f2) {
        Float f3 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public float b(View view) {
        Float f2 = (Float) view.getTag(R.id.save_non_transition_alpha);
        return f2 != null ? view.getAlpha() / f2.floatValue() : view.getAlpha();
    }

    public void c(View view) {
        if (view.getTag(R.id.save_non_transition_alpha) == null) {
            view.setTag(R.id.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void c(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            c((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    public void b(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            b((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void a(View view, Matrix matrix) {
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArr = this.f2127e;
            if (fArr == null) {
                fArr = new float[9];
                this.f2127e = fArr;
            }
            matrix.getValues(fArr);
            float f2 = fArr[3];
            float fSqrt = ((float) Math.sqrt(1.0f - (f2 * f2))) * (fArr[0] < WheelView.DividerConfig.FILL ? -1 : 1);
            float degrees = (float) Math.toDegrees(Math.atan2(f2, fSqrt));
            float f3 = fArr[0] / fSqrt;
            float f4 = fArr[4] / fSqrt;
            float f5 = fArr[2];
            float f6 = fArr[5];
            view.setPivotX(WheelView.DividerConfig.FILL);
            view.setPivotY(WheelView.DividerConfig.FILL);
            view.setTranslationX(f5);
            view.setTranslationY(f6);
            view.setRotation(degrees);
            view.setScaleX(f3);
            view.setScaleY(f4);
            return;
        }
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setTranslationX(WheelView.DividerConfig.FILL);
        view.setTranslationY(WheelView.DividerConfig.FILL);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(WheelView.DividerConfig.FILL);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        a();
        Method method = f2123a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void a(View view, int i) {
        if (!f2126d) {
            try {
                f2125c = View.class.getDeclaredField("mViewFlags");
                f2125c.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f2126d = true;
        }
        Field field = f2125c;
        if (field != null) {
            try {
                f2125c.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private void a() {
        if (f2124b) {
            return;
        }
        try {
            f2123a = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f2123a.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e2);
        }
        f2124b = true;
    }
}
