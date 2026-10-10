package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: DrawableAlphaProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property<Drawable, Integer> f13088a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f13089b;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f13089b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f13089b.containsKey(drawable)) {
            return this.f13089b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f13089b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
