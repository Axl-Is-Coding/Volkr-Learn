package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.a.h;

/* JADX INFO: compiled from: TintTypedArray.java */
/* JADX INFO: loaded from: classes.dex */
public class ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypedArray f660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypedValue f661c;

    private ia(Context context, TypedArray typedArray) {
        this.f659a = context;
        this.f660b = typedArray;
    }

    public static ia a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ia(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i) {
        int resourceId;
        return (!this.f660b.hasValue(i) || (resourceId = this.f660b.getResourceId(i, 0)) == 0) ? this.f660b.getDrawable(i) : androidx.appcompat.a.a.a.b(this.f659a, resourceId);
    }

    public Drawable c(int i) {
        int resourceId;
        if (!this.f660b.hasValue(i) || (resourceId = this.f660b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0305s.b().a(this.f659a, resourceId, true);
    }

    public String d(int i) {
        return this.f660b.getString(i);
    }

    public CharSequence e(int i) {
        return this.f660b.getText(i);
    }

    public int f(int i, int i2) {
        return this.f660b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f660b.getResourceId(i, i2);
    }

    public static ia a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ia(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int d(int i, int i2) {
        return this.f660b.getInt(i, i2);
    }

    public int e(int i, int i2) {
        return this.f660b.getInteger(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f660b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f660b.hasValue(i);
    }

    public static ia a(Context context, int i, int[] iArr) {
        return new ia(context, context.obtainStyledAttributes(i, iArr));
    }

    public int c(int i, int i2) {
        return this.f660b.getDimensionPixelSize(i, i2);
    }

    public Typeface a(int i, int i2, h.a aVar) {
        int resourceId = this.f660b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f661c == null) {
            this.f661c = new TypedValue();
        }
        return androidx.core.content.a.h.a(this.f659a, resourceId, this.f661c, i2, aVar);
    }

    public float b(int i, float f2) {
        return this.f660b.getFloat(i, f2);
    }

    public int b(int i, int i2) {
        return this.f660b.getDimensionPixelOffset(i, i2);
    }

    public boolean a(int i, boolean z) {
        return this.f660b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.f660b.getColor(i, i2);
    }

    public ColorStateList a(int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f660b.hasValue(i) || (resourceId = this.f660b.getResourceId(i, 0)) == 0 || (colorStateListA = androidx.appcompat.a.a.a.a(this.f659a, resourceId)) == null) ? this.f660b.getColorStateList(i) : colorStateListA;
    }

    public float a(int i, float f2) {
        return this.f660b.getDimension(i, f2);
    }

    public void a() {
        this.f660b.recycle();
    }
}
