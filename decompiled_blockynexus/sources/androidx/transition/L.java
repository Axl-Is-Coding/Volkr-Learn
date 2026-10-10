package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: compiled from: PathProperty.java */
/* JADX INFO: loaded from: classes.dex */
class L<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Property<T, PointF> f2175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathMeasure f2176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f2177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f2178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PointF f2179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2180f;

    L(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f2178d = new float[2];
        this.f2179e = new PointF();
        this.f2175a = property;
        this.f2176b = new PathMeasure(path, false);
        this.f2177c = this.f2176b.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f2) {
        this.f2180f = f2.floatValue();
        this.f2176b.getPosTan(this.f2177c * f2.floatValue(), this.f2178d, null);
        PointF pointF = this.f2179e;
        float[] fArr = this.f2178d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f2175a.set(t, pointF);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f2180f);
    }
}
