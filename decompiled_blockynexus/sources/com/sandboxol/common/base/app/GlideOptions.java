package com.sandboxol.common.base.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.o;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.f;

/* JADX INFO: loaded from: classes3.dex */
public final class GlideOptions extends f implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    public static GlideOptions bitmapTransform(o<Bitmap> oVar) {
        return new GlideOptions().transform(oVar);
    }

    public static GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    public static GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    public static GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    public static GlideOptions decodeTypeOf(Class<?> cls) {
        return new GlideOptions().decode(cls);
    }

    public static GlideOptions diskCacheStrategyOf(p pVar) {
        return new GlideOptions().diskCacheStrategy(pVar);
    }

    public static GlideOptions downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    public static GlideOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    public static GlideOptions encodeQualityOf(int i) {
        return new GlideOptions().encodeQuality(i);
    }

    public static GlideOptions errorOf(Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    public static GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    public static GlideOptions formatOf(DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    public static GlideOptions frameOf(long j) {
        return new GlideOptions().frame(j);
    }

    public static GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    public static GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    public static <T> GlideOptions option(k<T> kVar, T t) {
        return new GlideOptions().set(kVar, t);
    }

    public static GlideOptions overrideOf(int i, int i2) {
        return new GlideOptions().override(i, i2);
    }

    public static GlideOptions placeholderOf(Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    public static GlideOptions priorityOf(Priority priority) {
        return new GlideOptions().priority(priority);
    }

    public static GlideOptions signatureOf(h hVar) {
        return new GlideOptions().signature(hVar);
    }

    public static GlideOptions sizeMultiplierOf(float f2) {
        return new GlideOptions().sizeMultiplier(f2);
    }

    public static GlideOptions skipMemoryCacheOf(boolean z) {
        return new GlideOptions().skipMemoryCache(z);
    }

    public static GlideOptions timeoutOf(int i) {
        return new GlideOptions().timeout(i);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a apply(com.bumptech.glide.request.a aVar) {
        return apply((com.bumptech.glide.request.a<?>) aVar);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a decode(Class cls) {
        return decode((Class<?>) cls);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a optionalTransform(o oVar) {
        return optionalTransform((o<Bitmap>) oVar);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a set(k kVar, Object obj) {
        return set((k<Object>) kVar, obj);
    }

    @Override // com.bumptech.glide.request.a
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transform(o oVar) {
        return transform((o<Bitmap>) oVar);
    }

    @Override // com.bumptech.glide.request.a
    @SafeVarargs
    @Deprecated
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transforms(o[] oVarArr) {
        return transforms((o<Bitmap>[]) oVarArr);
    }

    public static GlideOptions errorOf(int i) {
        return new GlideOptions().error(i);
    }

    public static GlideOptions overrideOf(int i) {
        return new GlideOptions().override(i);
    }

    public static GlideOptions placeholderOf(int i) {
        return new GlideOptions().placeholder(i);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions apply(com.bumptech.glide.request.a<?> aVar) {
        return (GlideOptions) super.apply(aVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions autoClone() {
        return (GlideOptions) super.autoClone();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions centerCrop() {
        return (GlideOptions) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions centerInside() {
        return (GlideOptions) super.centerInside();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions circleCrop() {
        return (GlideOptions) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions decode(Class<?> cls) {
        return (GlideOptions) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions disallowHardwareConfig() {
        return (GlideOptions) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions diskCacheStrategy(p pVar) {
        return (GlideOptions) super.diskCacheStrategy(pVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions dontAnimate() {
        return (GlideOptions) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions dontTransform() {
        return (GlideOptions) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions downsample(DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (GlideOptions) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions encodeQuality(int i) {
        return (GlideOptions) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions fitCenter() {
        return (GlideOptions) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions format(DecodeFormat decodeFormat) {
        return (GlideOptions) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions frame(long j) {
        return (GlideOptions) super.frame(j);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions lock() {
        super.lock();
        return this;
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions onlyRetrieveFromCache(boolean z) {
        return (GlideOptions) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions optionalCenterCrop() {
        return (GlideOptions) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions optionalCenterInside() {
        return (GlideOptions) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions optionalCircleCrop() {
        return (GlideOptions) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions optionalFitCenter() {
        return (GlideOptions) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions priority(Priority priority) {
        return (GlideOptions) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.a
    public <Y> GlideOptions set(k<Y> kVar, Y y) {
        return (GlideOptions) super.set((k) kVar, (Object) y);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions signature(h hVar) {
        return (GlideOptions) super.signature(hVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions sizeMultiplier(float f2) {
        return (GlideOptions) super.sizeMultiplier(f2);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions skipMemoryCache(boolean z) {
        return (GlideOptions) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions theme(Resources.Theme theme) {
        return (GlideOptions) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions timeout(int i) {
        return (GlideOptions) super.timeout(i);
    }

    @Override // com.bumptech.glide.request.a
    @SafeVarargs
    @Deprecated
    public final GlideOptions transforms(o<Bitmap>... oVarArr) {
        return (GlideOptions) super.transforms(oVarArr);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions useAnimationPool(boolean z) {
        return (GlideOptions) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return (GlideOptions) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.a
    /* JADX INFO: renamed from: clone */
    public GlideOptions mo39clone() {
        return (GlideOptions) super.mo39clone();
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions error(Drawable drawable) {
        return (GlideOptions) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions fallback(Drawable drawable) {
        return (GlideOptions) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions optionalTransform(o<Bitmap> oVar) {
        return (GlideOptions) super.optionalTransform(oVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions override(int i, int i2) {
        return (GlideOptions) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions placeholder(Drawable drawable) {
        return (GlideOptions) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.a
    @SafeVarargs
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transform(o[] oVarArr) {
        return transform((o<Bitmap>[]) oVarArr);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions error(int i) {
        return (GlideOptions) super.error(i);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions fallback(int i) {
        return (GlideOptions) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.a
    public <Y> GlideOptions optionalTransform(Class<Y> cls, o<Y> oVar) {
        return (GlideOptions) super.optionalTransform((Class) cls, (o) oVar);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions override(int i) {
        return (GlideOptions) super.override(i);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions placeholder(int i) {
        return (GlideOptions) super.placeholder(i);
    }

    @Override // com.bumptech.glide.request.a
    public GlideOptions transform(o<Bitmap> oVar) {
        return (GlideOptions) super.transform(oVar);
    }

    @Override // com.bumptech.glide.request.a
    @SafeVarargs
    public final GlideOptions transform(o<Bitmap>... oVarArr) {
        return (GlideOptions) super.transform(oVarArr);
    }

    @Override // com.bumptech.glide.request.a
    public <Y> GlideOptions transform(Class<Y> cls, o<Y> oVar) {
        return (GlideOptions) super.transform((Class) cls, (o) oVar);
    }
}
