package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: WrappedDrawableState.java */
/* JADX INFO: loaded from: classes.dex */
final class f extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f1177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ColorStateList f1178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f1179d;

    f(f fVar) {
        this.f1178c = null;
        this.f1179d = d.f1170a;
        if (fVar != null) {
            this.f1176a = fVar.f1176a;
            this.f1177b = fVar.f1177b;
            this.f1178c = fVar.f1178c;
            this.f1179d = fVar.f1179d;
        }
    }

    boolean a() {
        return this.f1177b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f1176a;
        Drawable.ConstantState constantState = this.f1177b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
