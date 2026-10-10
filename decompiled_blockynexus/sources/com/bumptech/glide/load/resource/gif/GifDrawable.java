package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.e.l;
import com.bumptech.glide.load.o;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends Drawable implements Animatable, Animatable2Compat, GifFrameLoader.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GifState f4716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4721f;
    private int g;
    private boolean h;
    private Paint i;
    private Rect j;
    private List<Animatable2Compat.AnimationCallback> k;

    static final class GifState extends Drawable.ConstantState {
        final GifFrameLoader frameLoader;

        GifState(GifFrameLoader gifFrameLoader) {
            this.frameLoader = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, com.bumptech.glide.gifdecoder.a aVar, o<Bitmap> oVar, int i, int i2, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(com.bumptech.glide.c.a(context), aVar, i, i2, oVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback findCallback() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect h() {
        if (this.j == null) {
            this.j = new Rect();
        }
        return this.j;
    }

    private Paint i() {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        return this.i;
    }

    private void j() {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.k.get(i).a(this);
            }
        }
    }

    private void k() {
        this.f4721f = 0;
    }

    private void l() {
        l.a(!this.f4719d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f4716a.frameLoader.getFrameCount() == 1) {
            invalidateSelf();
        } else {
            if (this.f4717b) {
                return;
            }
            this.f4717b = true;
            this.f4716a.frameLoader.subscribe(this);
            invalidateSelf();
        }
    }

    private void m() {
        this.f4717b = false;
        this.f4716a.frameLoader.unsubscribe(this);
    }

    public void a(o<Bitmap> oVar, Bitmap bitmap) {
        this.f4716a.frameLoader.setFrameTransformation(oVar, bitmap);
    }

    public ByteBuffer b() {
        return this.f4716a.frameLoader.getBuffer();
    }

    public Bitmap c() {
        return this.f4716a.frameLoader.getFirstFrame();
    }

    public int d() {
        return this.f4716a.frameLoader.getFrameCount();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4719d) {
            return;
        }
        if (this.h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), h());
            this.h = false;
        }
        canvas.drawBitmap(this.f4716a.frameLoader.getCurrentFrame(), (Rect) null, h(), i());
    }

    public int e() {
        return this.f4716a.frameLoader.getCurrentIndex();
    }

    public int f() {
        return this.f4716a.frameLoader.getSize();
    }

    public void g() {
        this.f4719d = true;
        this.f4716a.frameLoader.clear();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f4716a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4716a.frameLoader.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4716a.frameLoader.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4717b;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        i().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        i().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        l.a(!this.f4719d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f4720e = z;
        if (!z) {
            m();
        } else if (this.f4718c) {
            l();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f4718c = true;
        k();
        if (this.f4720e) {
            l();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f4718c = false;
        m();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.b
    public void a() {
        if (findCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f4721f++;
        }
        int i = this.g;
        if (i == -1 || this.f4721f < i) {
            return;
        }
        j();
        stop();
    }

    GifDrawable(GifState gifState) {
        this.f4720e = true;
        this.g = -1;
        l.a(gifState);
        this.f4716a = gifState;
    }
}
