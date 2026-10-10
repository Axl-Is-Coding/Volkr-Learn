package androidx.transition;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* JADX INFO: renamed from: androidx.transition.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeImageTransform.java */
/* JADX INFO: loaded from: classes.dex */
class C0397o extends Property<ImageView, Matrix> {
    C0397o(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        return null;
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        H.a(imageView, matrix);
    }
}
