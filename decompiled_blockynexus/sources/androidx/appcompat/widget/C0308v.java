package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: renamed from: androidx.appcompat.widget.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatProgressBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0308v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f715a = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProgressBar f716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f717c;

    C0308v(ProgressBar progressBar) {
        this.f716b = progressBar;
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    void a(AttributeSet attributeSet, int i) {
        ia iaVarA = ia.a(this.f716b.getContext(), attributeSet, f715a, i, 0);
        Drawable drawableC = iaVarA.c(0);
        if (drawableC != null) {
            this.f716b.setIndeterminateDrawable(a(drawableC));
        }
        Drawable drawableC2 = iaVarA.c(1);
        if (drawableC2 != null) {
            this.f716b.setProgressDrawable(a(drawableC2, false));
        }
        iaVarA.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable a(Drawable drawable, boolean z) {
        if (drawable instanceof androidx.core.graphics.drawable.c) {
            androidx.core.graphics.drawable.c cVar = (androidx.core.graphics.drawable.c) drawable;
            Drawable drawableA = cVar.a();
            if (drawableA == null) {
                return drawable;
            }
            cVar.a(a(drawableA, z));
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        }
        if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (this.f717c == null) {
            this.f717c = bitmap;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(b());
        shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
        return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
    }

    private Drawable a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableA = a(animationDrawable.getFrame(i), true);
            drawableA.setLevel(10000);
            animationDrawable2.addFrame(drawableA, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    Bitmap a() {
        return this.f717c;
    }
}
