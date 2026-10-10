package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends i implements Animatable2Compat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f2319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f2320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Animator.AnimatorListener f2321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<Animatable2Compat.AnimationCallback> f2322f;
    final Drawable.Callback g;

    private static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        k f2324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnimatorSet f2325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<Animator> f2326d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        a.a.b<Animator, String> f2327e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f2323a = aVar.f2323a;
                k kVar = aVar.f2324b;
                if (kVar != null) {
                    Drawable.ConstantState constantState = kVar.getConstantState();
                    if (resources != null) {
                        this.f2324b = (k) constantState.newDrawable(resources);
                    } else {
                        this.f2324b = (k) constantState.newDrawable();
                    }
                    k kVar2 = this.f2324b;
                    kVar2.mutate();
                    this.f2324b = kVar2;
                    this.f2324b.setCallback(callback);
                    this.f2324b.setBounds(aVar.f2324b.getBounds());
                    this.f2324b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.f2326d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2326d = new ArrayList<>(size);
                    this.f2327e = new a.a.b<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f2326d.get(i);
                        Animator animatorClone = animator.clone();
                        String str = aVar.f2327e.get(animator);
                        animatorClone.setTarget(this.f2324b.a(str));
                        this.f2326d.add(animatorClone);
                        this.f2327e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f2325c == null) {
                this.f2325c = new AnimatorSet();
            }
            this.f2325c.playTogether(this.f2326d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2323a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    public static AnimatedVectorDrawableCompat a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.getPlatformCallback());
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.a(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f2318b.f2324b.draw(canvas);
        if (this.f2318b.f2325c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f2342a;
        return drawable != null ? androidx.core.graphics.drawable.a.c(drawable) : this.f2318b.f2324b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2318b.f2323a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f2342a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f2318b.f2324b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f2342a;
        if (drawable == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(drawable.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f2318b.f2324b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f2318b.f2324b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.getOpacity() : this.f2318b.f2324b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayA = androidx.core.content.a.i.a(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f2333e);
                    int resourceId = typedArrayA.getResourceId(0, 0);
                    if (resourceId != 0) {
                        k kVarA = k.a(resources, resourceId, theme);
                        kVarA.a(false);
                        kVarA.setCallback(this.g);
                        k kVar = this.f2318b.f2324b;
                        if (kVar != null) {
                            kVar.setCallback(null);
                        }
                        this.f2318b.f2324b = kVarA;
                    }
                    typedArrayA.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f2334f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2319c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        a(string, f.a(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2318b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f2342a;
        return drawable != null ? androidx.core.graphics.drawable.a.f(drawable) : this.f2318b.f2324b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f2342a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f2318b.f2325c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.isStateful() : this.f2318b.f2324b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2318b.f2324b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.setLevel(i) : this.f2318b.f2324b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2342a;
        return drawable != null ? drawable.setState(iArr) : this.f2318b.f2324b.setState(iArr);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
            return;
        }
        if (animationCallback == null) {
            return;
        }
        if (this.f2322f == null) {
            this.f2322f = new ArrayList<>();
        }
        if (this.f2322f.contains(animationCallback)) {
            return;
        }
        this.f2322f.add(animationCallback);
        if (this.f2321e == null) {
            this.f2321e = new d(this);
        }
        this.f2318b.f2325c.addListener(this.f2321e);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f2318b.f2324b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, z);
        } else {
            this.f2318b.f2324b.setAutoMirrored(z);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.b(drawable, i);
        } else {
            this.f2318b.f2324b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        } else {
            this.f2318b.f2324b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, mode);
        } else {
            this.f2318b.f2324b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f2318b.f2324b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f2318b.f2325c.isStarted()) {
                return;
            }
            this.f2318b.f2325c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2318b.f2325c.end();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        }
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.f2322f;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(animationCallback);
        if (this.f2322f.size() == 0) {
            a();
        }
        return zRemove;
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2342a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2318b.f2324b.setColorFilter(colorFilter);
        }
    }

    private static class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f2328a;

        public b(Drawable.ConstantState constantState) {
            this.f2328a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2328a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2328a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f2342a = this.f2328a.newDrawable();
            animatedVectorDrawableCompat.f2342a.setCallback(animatedVectorDrawableCompat.g);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f2342a = this.f2328a.newDrawable(resources);
            animatedVectorDrawableCompat.f2342a.setCallback(animatedVectorDrawableCompat.g);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f2342a = this.f2328a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f2342a.setCallback(animatedVectorDrawableCompat.g);
            return animatedVectorDrawableCompat;
        }
    }

    private AnimatedVectorDrawableCompat(Context context, a aVar, Resources resources) {
        this.f2320d = null;
        this.f2321e = null;
        this.f2322f = null;
        this.g = new c(this);
        this.f2319c = context;
        if (aVar != null) {
            this.f2318b = aVar;
        } else {
            this.f2318b = new a(context, aVar, this.g, resources);
        }
    }

    private void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2320d == null) {
                    this.f2320d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2320d);
            }
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        }
        return ((AnimatedVectorDrawableCompat) drawable).unregisterAnimationCallback(animationCallback);
    }

    public static void registerAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        } else {
            ((AnimatedVectorDrawableCompat) drawable).registerAnimationCallback(animationCallback);
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f2318b.f2324b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        a aVar = this.f2318b;
        if (aVar.f2326d == null) {
            aVar.f2326d = new ArrayList<>();
            this.f2318b.f2327e = new a.a.b<>();
        }
        this.f2318b.f2326d.add(animator);
        this.f2318b.f2327e.put(animator, str);
    }

    private void a() {
        Animator.AnimatorListener animatorListener = this.f2321e;
        if (animatorListener != null) {
            this.f2318b.f2325c.removeListener(animatorListener);
            this.f2321e = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
