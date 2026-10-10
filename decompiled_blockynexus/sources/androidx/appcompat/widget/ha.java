package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TintResources.java */
/* JADX INFO: loaded from: classes.dex */
class ha extends N {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f658b;

    public ha(Context context, Resources resources) {
        super(resources);
        this.f658b = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.N, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f658b.get();
        if (drawable != null && context != null) {
            M.a().a(context, i, drawable);
        }
        return drawable;
    }
}
