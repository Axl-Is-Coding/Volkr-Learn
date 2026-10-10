package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* JADX INFO: compiled from: ImageViewAction.java */
/* JADX INFO: loaded from: classes5.dex */
class s extends AbstractC2746a<ImageView> {
    InterfaceC2757l m;

    s(Picasso picasso, ImageView imageView, C c2, int i, int i2, int i3, Drawable drawable, String str, Object obj, InterfaceC2757l interfaceC2757l, boolean z) {
        super(picasso, imageView, c2, i, i2, i3, drawable, str, obj, z);
        this.m = interfaceC2757l;
    }

    @Override // com.squareup.picasso.AbstractC2746a
    public void a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.f19276c.get();
        if (imageView == null) {
            return;
        }
        Picasso picasso = this.f19274a;
        z.a(imageView, picasso.g, bitmap, loadedFrom, this.f19277d, picasso.o);
        InterfaceC2757l interfaceC2757l = this.m;
        if (interfaceC2757l != null) {
            interfaceC2757l.onSuccess();
        }
    }

    @Override // com.squareup.picasso.AbstractC2746a
    public void b() {
        ImageView imageView = (ImageView) this.f19276c.get();
        if (imageView == null) {
            return;
        }
        int i = this.g;
        if (i != 0) {
            imageView.setImageResource(i);
        } else {
            Drawable drawable = this.h;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        InterfaceC2757l interfaceC2757l = this.m;
        if (interfaceC2757l != null) {
            interfaceC2757l.onError();
        }
    }

    @Override // com.squareup.picasso.AbstractC2746a
    void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }
}
