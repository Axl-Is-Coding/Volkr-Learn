package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class DownsampleStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownsampleStrategy f4650a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DownsampleStrategy f4651b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DownsampleStrategy f4652c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DownsampleStrategy f4653d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DownsampleStrategy f4654e = new d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DownsampleStrategy f4655f = new f();
    public static final DownsampleStrategy g = f4654e;
    public static final com.bumptech.glide.load.k<DownsampleStrategy> h = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", g);
    static final boolean i;

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    private static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i, int i2, int i3, int i4) {
            if (Math.min(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    private static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    private static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return b(i, i2, i3, i4) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.f4652c.a(i, i2, i3, i4);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, DownsampleStrategy.f4652c.b(i, i2, i3, i4));
        }
    }

    private static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    private static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return DownsampleStrategy.i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i, int i2, int i3, int i4) {
            if (DownsampleStrategy.i) {
                return Math.min(i3 / i, i4 / i2);
            }
            if (Math.max(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    private static class f extends DownsampleStrategy {
        f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    static {
        i = Build.VERSION.SDK_INT >= 19;
    }

    public abstract SampleSizeRounding a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
