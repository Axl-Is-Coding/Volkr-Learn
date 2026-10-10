package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: ImageViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2171a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f2172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2173c;

    static void a(ImageView imageView, Matrix matrix) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
                return;
            }
            return;
        }
        if (i >= 21) {
            b(imageView, matrix);
            return;
        }
        Drawable drawable2 = imageView.getDrawable();
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            Matrix matrix2 = null;
            a();
            Field field = f2172b;
            if (field != null) {
                try {
                    Matrix matrix3 = (Matrix) field.get(imageView);
                    if (matrix3 == null) {
                        try {
                            matrix2 = new Matrix();
                            f2172b.set(imageView, matrix2);
                        } catch (IllegalAccessException unused) {
                            matrix2 = matrix3;
                        }
                    } else {
                        matrix2 = matrix3;
                    }
                } catch (IllegalAccessException unused2) {
                }
            }
            if (matrix2 != null) {
                matrix2.set(matrix);
            }
            imageView.invalidate();
        }
    }

    @SuppressLint({"NewApi"})
    private static void b(ImageView imageView, Matrix matrix) {
        if (f2171a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f2171a = false;
            }
        }
    }

    private static void a() {
        if (f2173c) {
            return;
        }
        try {
            f2172b = ImageView.class.getDeclaredField("mDrawMatrix");
            f2172b.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        f2173c = true;
    }
}
