package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.o;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: compiled from: RequestOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends a<f> {
    private static f centerCropOptions;
    private static f centerInsideOptions;
    private static f circleCropOptions;
    private static f fitCenterOptions;
    private static f noAnimationOptions;
    private static f noTransformOptions;
    private static f skipMemoryCacheFalseOptions;
    private static f skipMemoryCacheTrueOptions;

    public static f bitmapTransform(o<Bitmap> oVar) {
        return new f().transform(oVar);
    }

    public static f centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new f().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    public static f centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new f().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    public static f circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new f().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    public static f decodeTypeOf(Class<?> cls) {
        return new f().decode(cls);
    }

    public static f diskCacheStrategyOf(p pVar) {
        return new f().diskCacheStrategy(pVar);
    }

    public static f downsampleOf(DownsampleStrategy downsampleStrategy) {
        return new f().downsample(downsampleStrategy);
    }

    public static f encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new f().encodeFormat(compressFormat);
    }

    public static f encodeQualityOf(int i) {
        return new f().encodeQuality(i);
    }

    public static f errorOf(Drawable drawable) {
        return new f().error(drawable);
    }

    public static f fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new f().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    public static f formatOf(DecodeFormat decodeFormat) {
        return new f().format(decodeFormat);
    }

    public static f frameOf(long j) {
        return new f().frame(j);
    }

    public static f noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new f().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    public static f noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new f().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    public static <T> f option(k<T> kVar, T t) {
        return new f().set(kVar, t);
    }

    public static f overrideOf(int i, int i2) {
        return new f().override(i, i2);
    }

    public static f placeholderOf(Drawable drawable) {
        return new f().placeholder(drawable);
    }

    public static f priorityOf(Priority priority) {
        return new f().priority(priority);
    }

    public static f signatureOf(com.bumptech.glide.load.h hVar) {
        return new f().signature(hVar);
    }

    public static f sizeMultiplierOf(float f2) {
        return new f().sizeMultiplier(f2);
    }

    public static f skipMemoryCacheOf(boolean z) {
        if (z) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new f().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new f().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    public static f timeoutOf(int i) {
        return new f().timeout(i);
    }

    public static f errorOf(int i) {
        return new f().error(i);
    }

    public static f overrideOf(int i) {
        return overrideOf(i, i);
    }

    public static f placeholderOf(int i) {
        return new f().placeholder(i);
    }
}
