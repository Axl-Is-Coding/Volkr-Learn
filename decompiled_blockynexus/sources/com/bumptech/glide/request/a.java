package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.e.n;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.o;
import com.bumptech.glide.load.resource.bitmap.C0501c;
import com.bumptech.glide.load.resource.bitmap.D;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.i;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.a;
import java.util.Map;

/* JADX INFO: compiled from: BaseRequestOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;
    private p diskCacheStrategy = p.f4585e;
    private Priority priority = Priority.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private com.bumptech.glide.load.h signature = com.bumptech.glide.d.c.a();
    private boolean isTransformationAllowed = true;
    private l options = new l();
    private Map<Class<?>, o<?>> transformations = new com.bumptech.glide.e.b();
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    private boolean isSet(int i) {
        return isSet(this.fields, i);
    }

    private static boolean isSet(int i, int i2) {
        return (i & i2) != 0;
    }

    private T optionalScaleOnlyTransform(DownsampleStrategy downsampleStrategy, o<Bitmap> oVar) {
        return (T) scaleOnlyTransform(downsampleStrategy, oVar, false);
    }

    private T scaleOnlyTransform(DownsampleStrategy downsampleStrategy, o<Bitmap> oVar) {
        return (T) scaleOnlyTransform(downsampleStrategy, oVar, true);
    }

    private T self() {
        return this;
    }

    private T selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        self();
        return this;
    }

    public T apply(a<?> aVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().apply(aVar);
        }
        if (isSet(aVar.fields, 2)) {
            this.sizeMultiplier = aVar.sizeMultiplier;
        }
        if (isSet(aVar.fields, USE_UNLIMITED_SOURCE_GENERATORS_POOL)) {
            this.useUnlimitedSourceGeneratorsPool = aVar.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(aVar.fields, 1048576)) {
            this.useAnimationPool = aVar.useAnimationPool;
        }
        if (isSet(aVar.fields, 4)) {
            this.diskCacheStrategy = aVar.diskCacheStrategy;
        }
        if (isSet(aVar.fields, 8)) {
            this.priority = aVar.priority;
        }
        if (isSet(aVar.fields, 16)) {
            this.errorPlaceholder = aVar.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(aVar.fields, 32)) {
            this.errorId = aVar.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(aVar.fields, 64)) {
            this.placeholderDrawable = aVar.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(aVar.fields, 128)) {
            this.placeholderId = aVar.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(aVar.fields, 256)) {
            this.isCacheable = aVar.isCacheable;
        }
        if (isSet(aVar.fields, 512)) {
            this.overrideWidth = aVar.overrideWidth;
            this.overrideHeight = aVar.overrideHeight;
        }
        if (isSet(aVar.fields, 1024)) {
            this.signature = aVar.signature;
        }
        if (isSet(aVar.fields, 4096)) {
            this.resourceClass = aVar.resourceClass;
        }
        if (isSet(aVar.fields, 8192)) {
            this.fallbackDrawable = aVar.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(aVar.fields, FALLBACK_ID)) {
            this.fallbackId = aVar.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(aVar.fields, 32768)) {
            this.theme = aVar.theme;
        }
        if (isSet(aVar.fields, 65536)) {
            this.isTransformationAllowed = aVar.isTransformationAllowed;
        }
        if (isSet(aVar.fields, TRANSFORMATION_REQUIRED)) {
            this.isTransformationRequired = aVar.isTransformationRequired;
        }
        if (isSet(aVar.fields, 2048)) {
            this.transformations.putAll(aVar.transformations);
            this.isScaleOnlyOrNoTransform = aVar.isScaleOnlyOrNoTransform;
        }
        if (isSet(aVar.fields, ONLY_RETRIEVE_FROM_CACHE)) {
            this.onlyRetrieveFromCache = aVar.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            this.fields &= -2049;
            this.isTransformationRequired = false;
            this.fields &= -131073;
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= aVar.fields;
        this.options.a(aVar.options);
        selfOrThrowIfLocked();
        return this;
    }

    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return (T) lock();
    }

    public T centerCrop() {
        return (T) transform(DownsampleStrategy.f4654e, new i());
    }

    public T centerInside() {
        return (T) scaleOnlyTransform(DownsampleStrategy.f4653d, new j());
    }

    public T circleCrop() {
        return (T) transform(DownsampleStrategy.f4653d, new k());
    }

    public T decode(Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().decode(cls);
        }
        com.bumptech.glide.e.l.a(cls);
        this.resourceClass = cls;
        this.fields |= 4096;
        selfOrThrowIfLocked();
        return this;
    }

    public T disallowHardwareConfig() {
        return (T) set(m.f4683e, false);
    }

    public T diskCacheStrategy(p pVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().diskCacheStrategy(pVar);
        }
        com.bumptech.glide.e.l.a(pVar);
        this.diskCacheStrategy = pVar;
        this.fields |= 4;
        selfOrThrowIfLocked();
        return this;
    }

    public T dontAnimate() {
        return (T) set(com.bumptech.glide.load.resource.gif.g.f4738b, true);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().dontTransform();
        }
        this.transformations.clear();
        this.fields &= -2049;
        this.isTransformationRequired = false;
        this.fields &= -131073;
        this.isTransformationAllowed = false;
        this.fields |= 65536;
        this.isScaleOnlyOrNoTransform = true;
        selfOrThrowIfLocked();
        return this;
    }

    public T downsample(DownsampleStrategy downsampleStrategy) {
        com.bumptech.glide.load.k kVar = DownsampleStrategy.h;
        com.bumptech.glide.e.l.a(downsampleStrategy);
        return (T) set(kVar, downsampleStrategy);
    }

    public T encodeFormat(Bitmap.CompressFormat compressFormat) {
        com.bumptech.glide.load.k kVar = C0501c.f4669b;
        com.bumptech.glide.e.l.a(compressFormat);
        return (T) set(kVar, compressFormat);
    }

    public T encodeQuality(int i) {
        return (T) set(C0501c.f4668a, Integer.valueOf(i));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == aVar.errorId && n.b(this.errorPlaceholder, aVar.errorPlaceholder) && this.placeholderId == aVar.placeholderId && n.b(this.placeholderDrawable, aVar.placeholderDrawable) && this.fallbackId == aVar.fallbackId && n.b(this.fallbackDrawable, aVar.fallbackDrawable) && this.isCacheable == aVar.isCacheable && this.overrideHeight == aVar.overrideHeight && this.overrideWidth == aVar.overrideWidth && this.isTransformationRequired == aVar.isTransformationRequired && this.isTransformationAllowed == aVar.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == aVar.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == aVar.onlyRetrieveFromCache && this.diskCacheStrategy.equals(aVar.diskCacheStrategy) && this.priority == aVar.priority && this.options.equals(aVar.options) && this.transformations.equals(aVar.transformations) && this.resourceClass.equals(aVar.resourceClass) && n.b(this.signature, aVar.signature) && n.b(this.theme, aVar.theme);
    }

    public T error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        this.fields |= 16;
        this.errorId = 0;
        this.fields &= -33;
        selfOrThrowIfLocked();
        return this;
    }

    public T fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        this.fields |= 8192;
        this.fallbackId = 0;
        this.fields &= -16385;
        selfOrThrowIfLocked();
        return this;
    }

    public T fitCenter() {
        return (T) scaleOnlyTransform(DownsampleStrategy.f4652c, new r());
    }

    public T format(DecodeFormat decodeFormat) {
        com.bumptech.glide.e.l.a(decodeFormat);
        return (T) set(m.f4679a, decodeFormat).set(com.bumptech.glide.load.resource.gif.g.f4737a, decodeFormat);
    }

    public T frame(long j) {
        return (T) set(D.f4639a, Long.valueOf(j));
    }

    public final p getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final l getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final com.bumptech.glide.load.h getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, o<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return n.a(this.theme, n.a(this.signature, n.a(this.resourceClass, n.a(this.transformations, n.a(this.options, n.a(this.priority, n.a(this.diskCacheStrategy, n.a(this.onlyRetrieveFromCache, n.a(this.useUnlimitedSourceGeneratorsPool, n.a(this.isTransformationAllowed, n.a(this.isTransformationRequired, n.a(this.overrideWidth, n.a(this.overrideHeight, n.a(this.isCacheable, n.a(this.fallbackDrawable, n.a(this.fallbackId, n.a(this.placeholderDrawable, n.a(this.placeholderId, n.a(this.errorPlaceholder, n.a(this.errorId, n.a(this.sizeMultiplier)))))))))))))))))))));
    }

    protected boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return n.b(this.overrideWidth, this.overrideHeight);
    }

    public T lock() {
        this.isLocked = true;
        self();
        return this;
    }

    public T onlyRetrieveFromCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= ONLY_RETRIEVE_FROM_CACHE;
        selfOrThrowIfLocked();
        return this;
    }

    public T optionalCenterCrop() {
        return (T) optionalTransform(DownsampleStrategy.f4654e, new i());
    }

    public T optionalCenterInside() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.f4653d, new j());
    }

    public T optionalCircleCrop() {
        return (T) optionalTransform(DownsampleStrategy.f4654e, new k());
    }

    public T optionalFitCenter() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.f4652c, new r());
    }

    final T optionalTransform(DownsampleStrategy downsampleStrategy, o<Bitmap> oVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().optionalTransform(downsampleStrategy, oVar);
        }
        downsample(downsampleStrategy);
        return (T) transform(oVar, false);
    }

    public T override(int i, int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().override(i, i2);
        }
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.fields |= 512;
        selfOrThrowIfLocked();
        return this;
    }

    public T placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        this.fields |= 64;
        this.placeholderId = 0;
        this.fields &= -129;
        selfOrThrowIfLocked();
        return this;
    }

    public T priority(Priority priority) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().priority(priority);
        }
        com.bumptech.glide.e.l.a(priority);
        this.priority = priority;
        this.fields |= 8;
        selfOrThrowIfLocked();
        return this;
    }

    public <Y> T set(com.bumptech.glide.load.k<Y> kVar, Y y) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().set(kVar, y);
        }
        com.bumptech.glide.e.l.a(kVar);
        com.bumptech.glide.e.l.a(y);
        this.options.a(kVar, y);
        selfOrThrowIfLocked();
        return this;
    }

    public T signature(com.bumptech.glide.load.h hVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().signature(hVar);
        }
        com.bumptech.glide.e.l.a(hVar);
        this.signature = hVar;
        this.fields |= 1024;
        selfOrThrowIfLocked();
        return this;
    }

    public T sizeMultiplier(float f2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().sizeMultiplier(f2);
        }
        if (f2 < WheelView.DividerConfig.FILL || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f2;
        this.fields |= 2;
        selfOrThrowIfLocked();
        return this;
    }

    public T skipMemoryCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 256;
        selfOrThrowIfLocked();
        return this;
    }

    public T theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 32768;
        selfOrThrowIfLocked();
        return this;
    }

    public T timeout(int i) {
        return (T) set(com.bumptech.glide.load.a.a.a.f4230a, Integer.valueOf(i));
    }

    final T transform(DownsampleStrategy downsampleStrategy, o<Bitmap> oVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().transform(downsampleStrategy, oVar);
        }
        downsample(downsampleStrategy);
        return (T) transform(oVar);
    }

    @Deprecated
    public T transforms(o<Bitmap>... oVarArr) {
        return (T) transform((o<Bitmap>) new com.bumptech.glide.load.i(oVarArr), true);
    }

    public T useAnimationPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 1048576;
        selfOrThrowIfLocked();
        return this;
    }

    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= USE_UNLIMITED_SOURCE_GENERATORS_POOL;
        selfOrThrowIfLocked();
        return this;
    }

    private T scaleOnlyTransform(DownsampleStrategy downsampleStrategy, o<Bitmap> oVar, boolean z) {
        T t = z ? (T) transform(downsampleStrategy, oVar) : (T) optionalTransform(downsampleStrategy, oVar);
        t.isScaleOnlyOrNoTransform = true;
        return t;
    }

    @Override // 
    /* JADX INFO: renamed from: clone */
    public T mo39clone() {
        try {
            T t = (T) super.clone();
            t.options = new l();
            t.options.a(this.options);
            t.transformations = new com.bumptech.glide.e.b();
            t.transformations.putAll(this.transformations);
            t.isLocked = false;
            t.isAutoCloneEnabled = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public T optionalTransform(o<Bitmap> oVar) {
        return (T) transform(oVar, false);
    }

    public T transform(o<Bitmap> oVar) {
        return (T) transform(oVar, true);
    }

    public <Y> T optionalTransform(Class<Y> cls, o<Y> oVar) {
        return (T) transform(cls, oVar, false);
    }

    public T transform(o<Bitmap>... oVarArr) {
        if (oVarArr.length > 1) {
            return (T) transform((o<Bitmap>) new com.bumptech.glide.load.i(oVarArr), true);
        }
        if (oVarArr.length == 1) {
            return (T) transform(oVarArr[0]);
        }
        selfOrThrowIfLocked();
        return this;
    }

    public T override(int i) {
        return (T) override(i, i);
    }

    public T error(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().error(i);
        }
        this.errorId = i;
        this.fields |= 32;
        this.errorPlaceholder = null;
        this.fields &= -17;
        selfOrThrowIfLocked();
        return this;
    }

    public T fallback(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().fallback(i);
        }
        this.fallbackId = i;
        this.fields |= FALLBACK_ID;
        this.fallbackDrawable = null;
        this.fields &= -8193;
        selfOrThrowIfLocked();
        return this;
    }

    public T placeholder(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().placeholder(i);
        }
        this.placeholderId = i;
        this.fields |= 128;
        this.placeholderDrawable = null;
        this.fields &= -65;
        selfOrThrowIfLocked();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    T transform(o<Bitmap> oVar, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().transform(oVar, z);
        }
        com.bumptech.glide.load.resource.bitmap.p pVar = new com.bumptech.glide.load.resource.bitmap.p(oVar, z);
        transform(Bitmap.class, oVar, z);
        transform(Drawable.class, pVar, z);
        pVar.a();
        transform(BitmapDrawable.class, pVar, z);
        transform(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(oVar), z);
        selfOrThrowIfLocked();
        return this;
    }

    <Y> T transform(Class<Y> cls, o<Y> oVar, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo39clone().transform(cls, oVar, z);
        }
        com.bumptech.glide.e.l.a(cls);
        com.bumptech.glide.e.l.a(oVar);
        this.transformations.put(cls, oVar);
        this.fields |= 2048;
        this.isTransformationAllowed = true;
        this.fields |= 65536;
        this.isScaleOnlyOrNoTransform = false;
        if (z) {
            this.fields |= TRANSFORMATION_REQUIRED;
            this.isTransformationRequired = true;
        }
        selfOrThrowIfLocked();
        return this;
    }

    public <Y> T transform(Class<Y> cls, o<Y> oVar) {
        return (T) transform(cls, oVar, true);
    }
}
