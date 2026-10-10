package com.google.android.material.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.i.f;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import com.google.android.material.l.i;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: BadgeDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends Drawable implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f13139a = R.style.Widget_MaterialComponents_Badge;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f13140b = R.attr.badgeStyle;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference<Context> f13141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f13142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p f13143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f13144f;
    private final float g;
    private final float h;
    private final float i;
    private final a j;
    private float k;
    private float l;
    private int m;
    private float n;
    private float o;
    private float p;
    private WeakReference<View> q;
    private WeakReference<ViewGroup> r;

    /* JADX INFO: compiled from: BadgeDrawable.java */
    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new com.google.android.material.b.a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f13149e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CharSequence f13150f;
        private int g;
        private int h;

        public a(Context context) {
            this.f13147c = 255;
            this.f13148d = -1;
            this.f13146b = new f(context, R.style.TextAppearance_MaterialComponents_Badge).f13431b.getDefaultColor();
            this.f13150f = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.g = R.plurals.mtrl_badge_content_description;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f13145a);
            parcel.writeInt(this.f13146b);
            parcel.writeInt(this.f13147c);
            parcel.writeInt(this.f13148d);
            parcel.writeInt(this.f13149e);
            parcel.writeString(this.f13150f.toString());
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
        }

        protected a(Parcel parcel) {
            this.f13147c = 255;
            this.f13148d = -1;
            this.f13145a = parcel.readInt();
            this.f13146b = parcel.readInt();
            this.f13147c = parcel.readInt();
            this.f13148d = parcel.readInt();
            this.f13149e = parcel.readInt();
            this.f13150f = parcel.readString();
            this.g = parcel.readInt();
            this.h = parcel.readInt();
        }
    }

    private b(Context context) {
        this.f13141c = new WeakReference<>(context);
        s.b(context);
        Resources resources = context.getResources();
        this.f13144f = new Rect();
        this.f13142d = new i();
        this.g = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.i = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.h = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        this.f13143e = new p(this);
        this.f13143e.b().setTextAlign(Paint.Align.CENTER);
        this.j = new a(context);
        f(R.style.TextAppearance_MaterialComponents_Badge);
    }

    static b a(Context context, a aVar) {
        b bVar = new b(context);
        bVar.a(aVar);
        return bVar;
    }

    private void b(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayA = s.a(context, attributeSet, R.styleable.Badge, i, i2, new int[0]);
        d(typedArrayA.getInt(R.styleable.Badge_maxCharacterCount, 4));
        if (typedArrayA.hasValue(R.styleable.Badge_number)) {
            e(typedArrayA.getInt(R.styleable.Badge_number, 0));
        }
        a(a(context, typedArrayA, R.styleable.Badge_backgroundColor));
        if (typedArrayA.hasValue(R.styleable.Badge_badgeTextColor)) {
            c(a(context, typedArrayA, R.styleable.Badge_badgeTextColor));
        }
        b(typedArrayA.getInt(R.styleable.Badge_badgeGravity, 8388661));
        typedArrayA.recycle();
    }

    private String g() {
        if (d() <= this.m) {
            return Integer.toString(d());
        }
        Context context = this.f13141c.get();
        return context == null ? "" : context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.m), "+");
    }

    private void h() {
        Context context = this.f13141c.get();
        WeakReference<View> weakReference = this.q;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f13144f);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<ViewGroup> weakReference2 = this.r;
        ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
        if (viewGroup != null || c.f13151a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        a(context, rect2, view);
        c.a(this.f13144f, this.k, this.l, this.o, this.p);
        this.f13142d.a(this.n);
        if (rect.equals(this.f13144f)) {
            return;
        }
        this.f13142d.setBounds(this.f13144f);
    }

    private void i() {
        Double.isNaN(c());
        this.m = ((int) Math.pow(10.0d, r0 - 1.0d)) - 1;
    }

    public void c(int i) {
        this.j.f13146b = i;
        if (this.f13143e.b().getColor() != i) {
            this.f13143e.b().setColor(i);
            invalidateSelf();
        }
    }

    public int d() {
        if (f()) {
            return this.j.f13148d;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f13142d.draw(canvas);
        if (f()) {
            a(canvas);
        }
    }

    public a e() {
        return this.j;
    }

    public boolean f() {
        return this.j.f13148d != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.j.f13147c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f13144f.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f13144f.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.p.a
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.j.f13147c = i;
        this.f13143e.b().setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private void f(int i) {
        Context context = this.f13141c.get();
        if (context == null) {
            return;
        }
        a(new f(context, i));
    }

    public void e(int i) {
        int iMax = Math.max(0, i);
        if (this.j.f13148d != iMax) {
            this.j.f13148d = iMax;
            this.f13143e.a(true);
            h();
            invalidateSelf();
        }
    }

    public static b a(Context context) {
        return a(context, null, f13140b, f13139a);
    }

    public void d(int i) {
        if (this.j.f13149e != i) {
            this.j.f13149e = i;
            i();
            this.f13143e.a(true);
            h();
            invalidateSelf();
        }
    }

    private static b a(Context context, AttributeSet attributeSet, int i, int i2) {
        b bVar = new b(context);
        bVar.b(context, attributeSet, i, i2);
        return bVar;
    }

    public int c() {
        return this.j.f13149e;
    }

    private void a(a aVar) {
        d(aVar.f13149e);
        if (aVar.f13148d != -1) {
            e(aVar.f13148d);
        }
        a(aVar.f13145a);
        c(aVar.f13146b);
        b(aVar.h);
    }

    private static int a(Context context, TypedArray typedArray, int i) {
        return com.google.android.material.i.c.a(context, typedArray, i).getDefaultColor();
    }

    public void a(View view, ViewGroup viewGroup) {
        this.q = new WeakReference<>(view);
        this.r = new WeakReference<>(viewGroup);
        h();
        invalidateSelf();
    }

    public void b(int i) {
        if (this.j.h != i) {
            this.j.h = i;
            WeakReference<View> weakReference = this.q;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.q.get();
            WeakReference<ViewGroup> weakReference2 = this.r;
            a(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void a(int i) {
        this.j.f13145a = i;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (this.f13142d.f() != colorStateListValueOf) {
            this.f13142d.a(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public CharSequence b() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (f()) {
            if (this.j.g <= 0 || (context = this.f13141c.get()) == null) {
                return null;
            }
            return context.getResources().getQuantityString(this.j.g, d(), Integer.valueOf(d()));
        }
        return this.j.f13150f;
    }

    @Override // com.google.android.material.internal.p.a
    public void a() {
        invalidateSelf();
    }

    private void a(f fVar) {
        Context context;
        if (this.f13143e.a() == fVar || (context = this.f13141c.get()) == null) {
            return;
        }
        this.f13143e.a(fVar, context);
        h();
    }

    private void a(Context context, Rect rect, View view) {
        int i = this.j.h;
        if (i != 8388691 && i != 8388693) {
            this.l = rect.top;
        } else {
            this.l = rect.bottom;
        }
        if (d() <= 9) {
            this.n = !f() ? this.g : this.h;
            float f2 = this.n;
            this.p = f2;
            this.o = f2;
        } else {
            this.n = this.h;
            this.p = this.n;
            this.o = (this.f13143e.a(g()) / 2.0f) + this.i;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(f() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int i2 = this.j.h;
        if (i2 != 8388659 && i2 != 8388691) {
            this.k = ViewCompat.m(view) == 0 ? (rect.right + this.o) - dimensionPixelSize : (rect.left - this.o) + dimensionPixelSize;
        } else {
            this.k = ViewCompat.m(view) == 0 ? (rect.left - this.o) + dimensionPixelSize : (rect.right + this.o) - dimensionPixelSize;
        }
    }

    private void a(Canvas canvas) {
        Rect rect = new Rect();
        String strG = g();
        this.f13143e.b().getTextBounds(strG, 0, strG.length(), rect);
        canvas.drawText(strG, this.k, this.l + (rect.height() / 2), this.f13143e.b());
    }
}
