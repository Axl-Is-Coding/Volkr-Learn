package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.C0389ga;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    private static final String[] K = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};
    private static final TypeEvaluator<Matrix> L = new C0396n();
    private static final Property<ImageView, Matrix> M = new C0397o(Matrix.class, "animatedTransform");

    public ChangeImageTransform() {
    }

    private static Matrix b(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i = C0398p.f2276a[imageView.getScaleType().ordinal()];
            if (i == 1) {
                return d(imageView);
            }
            if (i == 2) {
                return a(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    private void d(ha haVar) {
        View view = haVar.f2247b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = haVar.f2246a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", b(imageView));
        }
    }

    @Override // androidx.transition.Transition
    public void a(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public void c(ha haVar) {
        d(haVar);
    }

    @Override // androidx.transition.Transition
    public String[] n() {
        return K;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ObjectAnimator c(ImageView imageView) {
        Property<ImageView, Matrix> property = M;
        TypeEvaluator<Matrix> typeEvaluator = L;
        Matrix matrix = J.f2174a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    @Override // androidx.transition.Transition
    public Animator a(ViewGroup viewGroup, ha haVar, ha haVar2) {
        if (haVar == null || haVar2 == null) {
            return null;
        }
        Rect rect = (Rect) haVar.f2246a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) haVar2.f2246a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) haVar.f2246a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) haVar2.f2246a.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) haVar2.f2247b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return c(imageView);
        }
        if (matrix == null) {
            matrix = J.f2174a;
        }
        if (matrix2 == null) {
            matrix2 = J.f2174a;
        }
        M.set(imageView, matrix);
        return a(imageView, matrix, matrix2);
    }

    private static Matrix d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    private ObjectAnimator a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) M, (TypeEvaluator) new C0389ga.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    private static Matrix a(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f2 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f3 = intrinsicHeight;
        float fMax = Math.max(width / f2, height / f3);
        int iRound = Math.round((width - (f2 * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (f3 * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }
}
