package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* JADX INFO: renamed from: androidx.transition.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0382d extends Property<Drawable, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f2232a;

    C0382d(Class cls, String str) {
        super(cls, str);
        this.f2232a = new Rect();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.f2232a);
        this.f2232a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.f2232a);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.f2232a);
        Rect rect = this.f2232a;
        return new PointF(rect.left, rect.top);
    }
}
