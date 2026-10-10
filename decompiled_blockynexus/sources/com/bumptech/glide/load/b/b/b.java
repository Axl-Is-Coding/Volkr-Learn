package com.bumptech.glide.load.b.b;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.l;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.engine.x;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: compiled from: DrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends Drawable> implements C<T>, x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f4337a;

    public b(T t) {
        l.a(t);
        this.f4337a = t;
    }

    @Override // com.bumptech.glide.load.engine.x
    public void initialize() {
        T t = this.f4337a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof GifDrawable) {
            ((GifDrawable) t).c().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.C
    public final T get() {
        Drawable.ConstantState constantState = this.f4337a.getConstantState();
        return constantState == null ? this.f4337a : (T) constantState.newDrawable();
    }
}
