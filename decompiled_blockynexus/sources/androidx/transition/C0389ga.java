package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: renamed from: androidx.transition.ga, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TransitionUtils.java */
/* JADX INFO: loaded from: classes.dex */
class C0389ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f2240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f2241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f2242c;

    /* JADX INFO: renamed from: androidx.transition.ga$a */
    /* JADX INFO: compiled from: TransitionUtils.java */
    static class a implements TypeEvaluator<Matrix> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float[] f2243a = new float[9];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f2244b = new float[9];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Matrix f2245c = new Matrix();

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f2243a);
            matrix2.getValues(this.f2244b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f2244b;
                float f3 = fArr[i];
                float[] fArr2 = this.f2243a;
                fArr[i] = fArr2[i] + ((f3 - fArr2[i]) * f2);
            }
            this.f2245c.setValues(this.f2244b);
            return this.f2245c;
        }
    }

    static {
        f2240a = Build.VERSION.SDK_INT >= 19;
        f2241b = Build.VERSION.SDK_INT >= 18;
        f2242c = Build.VERSION.SDK_INT >= 28;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        va.b(view, matrix);
        va.c(viewGroup, matrix);
        RectF rectF = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.left);
        int iRound2 = Math.round(rectF.top);
        int iRound3 = Math.round(rectF.right);
        int iRound4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmapA = a(view, matrix, rectF, viewGroup);
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, FileTypeUtils.GIGABYTE));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(android.view.View r9, android.graphics.Matrix r10, android.graphics.RectF r11, android.view.ViewGroup r12) {
        /*
            boolean r0 = androidx.transition.C0389ga.f2240a
            r1 = 0
            if (r0 == 0) goto L13
            boolean r0 = r9.isAttachedToWindow()
            r0 = r0 ^ 1
            if (r12 != 0) goto Le
            goto L14
        Le:
            boolean r2 = r12.isAttachedToWindow()
            goto L15
        L13:
            r0 = 0
        L14:
            r2 = 0
        L15:
            boolean r3 = androidx.transition.C0389ga.f2241b
            r4 = 0
            if (r3 == 0) goto L34
            if (r0 == 0) goto L34
            if (r2 != 0) goto L1f
            return r4
        L1f:
            android.view.ViewParent r1 = r9.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.indexOfChild(r9)
            android.view.ViewGroupOverlay r3 = r12.getOverlay()
            r3.add(r9)
            r8 = r2
            r2 = r1
            r1 = r8
            goto L35
        L34:
            r2 = r4
        L35:
            float r3 = r11.width()
            int r3 = java.lang.Math.round(r3)
            float r5 = r11.height()
            int r5 = java.lang.Math.round(r5)
            if (r3 <= 0) goto L9b
            if (r5 <= 0) goto L9b
            r4 = 1065353216(0x3f800000, float:1.0)
            r6 = 1233125376(0x49800000, float:1048576.0)
            int r7 = r3 * r5
            float r7 = (float) r7
            float r6 = r6 / r7
            float r4 = java.lang.Math.min(r4, r6)
            float r3 = (float) r3
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            float r5 = (float) r5
            float r5 = r5 * r4
            int r5 = java.lang.Math.round(r5)
            float r6 = r11.left
            float r6 = -r6
            float r11 = r11.top
            float r11 = -r11
            r10.postTranslate(r6, r11)
            r10.postScale(r4, r4)
            boolean r11 = androidx.transition.C0389ga.f2242c
            if (r11 == 0) goto L8a
            android.graphics.Picture r11 = new android.graphics.Picture
            r11.<init>()
            android.graphics.Canvas r3 = r11.beginRecording(r3, r5)
            r3.concat(r10)
            r9.draw(r3)
            r11.endRecording()
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r11)
            goto L9b
        L8a:
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r3, r5, r11)
            android.graphics.Canvas r11 = new android.graphics.Canvas
            r11.<init>(r4)
            r11.concat(r10)
            r9.draw(r11)
        L9b:
            boolean r10 = androidx.transition.C0389ga.f2241b
            if (r10 == 0) goto Lab
            if (r0 == 0) goto Lab
            android.view.ViewGroupOverlay r10 = r12.getOverlay()
            r10.remove(r9)
            r2.addView(r9, r1)
        Lab:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.C0389ga.a(android.view.View, android.graphics.Matrix, android.graphics.RectF, android.view.ViewGroup):android.graphics.Bitmap");
    }

    static Animator a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
