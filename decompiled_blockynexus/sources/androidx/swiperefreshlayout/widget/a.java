package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: CircleImageView.java */
/* JADX INFO: loaded from: classes.dex */
class a extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f2086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2087b;

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircleImageView.java */
    private class C0034a extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RadialGradient f2088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Paint f2089b = new Paint();

        C0034a(int i) {
            a.this.f2087b = i;
            a((int) rect().width());
        }

        private void a(int i) {
            float f2 = i / 2;
            this.f2088a = new RadialGradient(f2, f2, a.this.f2087b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f2089b.setShader(this.f2088a);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = a.this.getWidth() / 2;
            float height = a.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f2089b);
            canvas.drawCircle(width, height, r0 - a.this.f2087b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    a(Context context, int i) {
        ShapeDrawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f2);
        int i3 = (int) (WheelView.DividerConfig.FILL * f2);
        this.f2087b = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.a(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0034a(this.f2087b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f2087b, i3, i2, 503316480);
            int i4 = this.f2087b;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.a(this, shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f2086a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f2086a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f2087b * 2), getMeasuredHeight() + (this.f2087b * 2));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f2086a = animationListener;
    }
}
