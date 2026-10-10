package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourceManagerInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static M f557b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakHashMap<Context, a.a.j<ColorStateList>> f559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a.a.b<String, d> f560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a.a.j<String> f561f;
    private final WeakHashMap<Context, a.a.f<WeakReference<Drawable.ConstantState>>> g = new WeakHashMap<>(0);
    private TypedValue h;
    private boolean i;
    private e j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PorterDuff.Mode f556a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f558c = new c(6);

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.M.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.M.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class c extends a.a.g<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    interface e {
        ColorStateList a(Context context, int i);

        PorterDuff.Mode a(int i);

        Drawable a(M m, Context context, int i);

        boolean a(Context context, int i, Drawable drawable);

        boolean b(Context context, int i, Drawable drawable);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class f implements d {
        f() {
        }

        @Override // androidx.appcompat.widget.M.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.k.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    public static synchronized M a() {
        if (f557b == null) {
            f557b = new M();
            a(f557b);
        }
        return f557b;
    }

    private Drawable c(Context context, int i) {
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue typedValue = this.h;
        context.getResources().getValue(i, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        e eVar = this.j;
        Drawable drawableA2 = eVar == null ? null : eVar.a(this, context, i);
        if (drawableA2 != null) {
            drawableA2.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jA, drawableA2);
        }
        return drawableA2;
    }

    private ColorStateList d(Context context, int i) {
        a.a.j<ColorStateList> jVar;
        WeakHashMap<Context, a.a.j<ColorStateList>> weakHashMap = this.f559d;
        if (weakHashMap == null || (jVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return jVar.a(i);
    }

    private Drawable e(Context context, int i) {
        int next;
        a.a.b<String, d> bVar = this.f560e;
        if (bVar == null || bVar.isEmpty()) {
            return null;
        }
        a.a.j<String> jVar = this.f561f;
        if (jVar != null) {
            String strA = jVar.a(i);
            if ("appcompat_skip_skip".equals(strA) || (strA != null && this.f560e.get(strA) == null)) {
                return null;
            }
        } else {
            this.f561f = new a.a.j<>();
        }
        if (this.h == null) {
            this.h = new TypedValue();
        }
        TypedValue typedValue = this.h;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f561f.a(i, name);
                d dVar = this.f560e.get(name);
                if (dVar != null) {
                    drawableA = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableA != null) {
                    drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jA, drawableA);
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableA == null) {
            this.f561f.a(i, "appcompat_skip_skip");
        }
        return drawableA;
    }

    synchronized ColorStateList b(Context context, int i) {
        ColorStateList colorStateListD;
        colorStateListD = d(context, i);
        if (colorStateListD == null) {
            colorStateListD = this.j == null ? null : this.j.a(context, i);
            if (colorStateListD != null) {
                a(context, i, colorStateListD);
            }
        }
        return colorStateListD;
    }

    private static void a(M m) {
        if (Build.VERSION.SDK_INT < 24) {
            m.a("vector", new f());
            m.a("animated-vector", new b());
            m.a("animated-selector", new a());
        }
    }

    private void b(Context context) {
        if (this.i) {
            return;
        }
        this.i = true;
        Drawable drawableA = a(context, R.drawable.abc_vector_test);
        if (drawableA == null || !a(drawableA)) {
            this.i = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public synchronized void a(e eVar) {
        this.j = eVar;
    }

    public synchronized Drawable a(Context context, int i) {
        return a(context, i, false);
    }

    synchronized Drawable a(Context context, int i, boolean z) {
        Drawable drawableE;
        b(context);
        drawableE = e(context, i);
        if (drawableE == null) {
            drawableE = c(context, i);
        }
        if (drawableE == null) {
            drawableE = androidx.core.content.b.c(context, i);
        }
        if (drawableE != null) {
            drawableE = a(context, i, z, drawableE);
        }
        if (drawableE != null) {
            F.b(drawableE);
        }
        return drawableE;
    }

    public synchronized void a(Context context) {
        a.a.f<WeakReference<Drawable.ConstantState>> fVar = this.g.get(context);
        if (fVar != null) {
            fVar.b();
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList colorStateListB = b(context, i);
        if (colorStateListB != null) {
            if (F.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableI = androidx.core.graphics.drawable.a.i(drawable);
            androidx.core.graphics.drawable.a.a(drawableI, colorStateListB);
            PorterDuff.Mode modeA = a(i);
            if (modeA == null) {
                return drawableI;
            }
            androidx.core.graphics.drawable.a.a(drawableI, modeA);
            return drawableI;
        }
        e eVar = this.j;
        if ((eVar == null || !eVar.b(context, i, drawable)) && !a(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    private synchronized Drawable a(Context context, long j) {
        a.a.f<WeakReference<Drawable.ConstantState>> fVar = this.g.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceB = fVar.b(j);
        if (weakReferenceB != null) {
            Drawable.ConstantState constantState = weakReferenceB.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.a(j);
        }
        return null;
    }

    private synchronized boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        a.a.f<WeakReference<Drawable.ConstantState>> fVar = this.g.get(context);
        if (fVar == null) {
            fVar = new a.a.f<>();
            this.g.put(context, fVar);
        }
        fVar.c(j, new WeakReference<>(constantState));
        return true;
    }

    synchronized Drawable a(Context context, sa saVar, int i) {
        Drawable drawableE = e(context, i);
        if (drawableE == null) {
            drawableE = saVar.a(i);
        }
        if (drawableE == null) {
            return null;
        }
        return a(context, i, false, drawableE);
    }

    boolean a(Context context, int i, Drawable drawable) {
        e eVar = this.j;
        return eVar != null && eVar.a(context, i, drawable);
    }

    private void a(String str, d dVar) {
        if (this.f560e == null) {
            this.f560e = new a.a.b<>();
        }
        this.f560e.put(str, dVar);
    }

    PorterDuff.Mode a(int i) {
        e eVar = this.j;
        if (eVar == null) {
            return null;
        }
        return eVar.a(i);
    }

    private void a(Context context, int i, ColorStateList colorStateList) {
        if (this.f559d == null) {
            this.f559d = new WeakHashMap<>();
        }
        a.a.j<ColorStateList> jVar = this.f559d.get(context);
        if (jVar == null) {
            jVar = new a.a.j<>();
            this.f559d.put(context, jVar);
        }
        jVar.a(i, colorStateList);
    }

    static void a(Drawable drawable, ga gaVar, int[] iArr) {
        if (F.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (gaVar.f657d || gaVar.f656c) {
            drawable.setColorFilter(a(gaVar.f657d ? gaVar.f654a : null, gaVar.f656c ? gaVar.f655b : f556a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA;
        porterDuffColorFilterA = f558c.a(i, mode);
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new PorterDuffColorFilter(i, mode);
            f558c.a(i, mode, porterDuffColorFilterA);
        }
        return porterDuffColorFilterA;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.k) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
