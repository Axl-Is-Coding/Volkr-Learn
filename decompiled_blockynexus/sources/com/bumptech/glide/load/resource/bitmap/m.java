package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.t;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: Downsampler.java */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<DecodeFormat> f4679a = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<PreferredColorSpace> f4680b = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final com.bumptech.glide.load.k<DownsampleStrategy> f4681c = DownsampleStrategy.h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<Boolean> f4682d = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<Boolean> f4683e = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<String> f4684f = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    private static final a g = new l();
    private static final Set<ImageHeaderParser.ImageType> h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final Queue<BitmapFactory.Options> i = com.bumptech.glide.e.n.a(0);
    private final com.bumptech.glide.load.engine.a.e j;
    private final DisplayMetrics k;
    private final com.bumptech.glide.load.engine.a.b l;
    private final List<ImageHeaderParser> m;
    private final s n = s.a();

    /* JADX INFO: compiled from: Downsampler.java */
    public interface a {
        void a();

        void a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap) throws IOException;
    }

    public m(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.m = list;
        com.bumptech.glide.e.l.a(displayMetrics);
        this.k = displayMetrics;
        com.bumptech.glide.e.l.a(eVar);
        this.j = eVar;
        com.bumptech.glide.e.l.a(bVar);
        this.l = bVar;
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (i) {
            i.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    private static int[] b(t tVar, BitmapFactory.Options options, a aVar, com.bumptech.glide.load.engine.a.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(tVar, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public com.bumptech.glide.load.engine.C<Bitmap> a(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.l lVar) throws IOException {
        return a(inputStream, i2, i3, lVar, g);
    }

    public com.bumptech.glide.load.engine.C<Bitmap> a(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.l lVar, a aVar) throws IOException {
        return a(new t.a(inputStream, this.m, this.l), i2, i3, lVar, aVar);
    }

    public com.bumptech.glide.load.engine.C<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, com.bumptech.glide.load.l lVar) throws IOException {
        return a(new t.b(parcelFileDescriptor, this.m, this.l), i2, i3, lVar, g);
    }

    private com.bumptech.glide.load.engine.C<Bitmap> a(t tVar, int i2, int i3, com.bumptech.glide.load.l lVar, a aVar) throws IOException {
        byte[] bArr = (byte[]) this.l.a(65536, byte[].class);
        BitmapFactory.Options optionsA = a();
        optionsA.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) lVar.a(f4679a);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) lVar.a(f4680b);
        try {
            return C0503e.a(a(tVar, optionsA, (DownsampleStrategy) lVar.a(DownsampleStrategy.h), decodeFormat, preferredColorSpace, lVar.a(f4683e) != null && ((Boolean) lVar.a(f4683e)).booleanValue(), i2, i3, ((Boolean) lVar.a(f4682d)).booleanValue(), aVar), this.j);
        } finally {
            c(optionsA);
            this.l.put(bArr);
        }
    }

    private static boolean b(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private Bitmap a(t tVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i2, int i3, boolean z2, a aVar) throws IOException {
        int i4;
        int i5;
        int i6;
        m mVar;
        int iRound;
        int iRound2;
        int i7;
        ColorSpace colorSpace;
        long jA = com.bumptech.glide.e.h.a();
        int[] iArrB = b(tVar, options, aVar, this.j);
        boolean z3 = false;
        int i8 = iArrB[0];
        int i9 = iArrB[1];
        String str = options.outMimeType;
        boolean z4 = (i8 == -1 || i9 == -1) ? false : z;
        int iB = tVar.b();
        int iA = z.a(iB);
        boolean zB = z.b(iB);
        if (i2 != Integer.MIN_VALUE) {
            i4 = i3;
            i5 = i2;
        } else if (a(iA)) {
            i4 = i3;
            i5 = i9;
        } else {
            i4 = i3;
            i5 = i8;
        }
        if (i4 == Integer.MIN_VALUE) {
            i6 = a(iA) ? i8 : i9;
        } else {
            i6 = i4;
        }
        ImageHeaderParser.ImageType imageTypeC = tVar.c();
        a(imageTypeC, tVar, aVar, this.j, downsampleStrategy, iA, i8, i9, i5, i6, options);
        a(tVar, decodeFormat, z4, zB, options, i5, i6);
        boolean z5 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z5) {
            mVar = this;
            if (mVar.a(imageTypeC)) {
                if (i8 < 0 || i9 < 0 || !z2 || !z5) {
                    float f2 = b(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i10 = options.inSampleSize;
                    float f3 = i10;
                    int iCeil = (int) Math.ceil(i8 / f3);
                    int iCeil2 = (int) Math.ceil(i9 / f3);
                    iRound = Math.round(iCeil * f2);
                    iRound2 = Math.round(iCeil2 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i8 + "x" + i9 + "], sampleSize: " + i10 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    iRound = i5;
                    iRound2 = i6;
                }
                if (iRound > 0 && iRound2 > 0) {
                    a(options, mVar.j, iRound, iRound2);
                }
            }
        } else {
            mVar = this;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z3 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z3 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i11 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap bitmapA = a(tVar, options, aVar, mVar.j);
        aVar.a(mVar.j, bitmapA);
        if (Log.isLoggable("Downsampler", 2)) {
            i7 = iB;
            a(i8, i9, str, options, bitmapA, i2, i3, jA);
        } else {
            i7 = iB;
        }
        Bitmap bitmapA2 = null;
        if (bitmapA != null) {
            bitmapA.setDensity(mVar.k.densityDpi);
            bitmapA2 = z.a(mVar.j, bitmapA, i7);
            if (!bitmapA.equals(bitmapA2)) {
                mVar.j.a(bitmapA);
            }
        }
        return bitmapA2;
    }

    private static void a(ImageHeaderParser.ImageType imageType, t tVar, a aVar, com.bumptech.glide.load.engine.a.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int iMin;
        int iMax;
        int iFloor;
        double dFloor;
        int iRound;
        if (i3 > 0 && i4 > 0) {
            if (a(i2)) {
                i8 = i3;
                i7 = i4;
            } else {
                i7 = i3;
                i8 = i4;
            }
            float fB = downsampleStrategy.b(i7, i8, i5, i6);
            if (fB > WheelView.DividerConfig.FILL) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRoundingA = downsampleStrategy.a(i7, i8, i5, i6);
                if (sampleSizeRoundingA != null) {
                    float f2 = i7;
                    float f3 = i8;
                    int iC = i7 / c(fB * f2);
                    int iC2 = i8 / c(fB * f3);
                    if (sampleSizeRoundingA == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        iMin = Math.max(iC, iC2);
                    } else {
                        iMin = Math.min(iC, iC2);
                    }
                    if (Build.VERSION.SDK_INT > 23 || !f4684f.contains(options.outMimeType)) {
                        iMax = Math.max(1, Integer.highestOneBit(iMin));
                        if (sampleSizeRoundingA == DownsampleStrategy.SampleSizeRounding.MEMORY && iMax < 1.0f / fB) {
                            iMax <<= 1;
                        }
                    } else {
                        iMax = 1;
                    }
                    options.inSampleSize = iMax;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float fMin = Math.min(iMax, 8);
                        iFloor = (int) Math.ceil(f2 / fMin);
                        iRound = (int) Math.ceil(f3 / fMin);
                        int i9 = iMax / 8;
                        if (i9 > 0) {
                            iFloor /= i9;
                            iRound /= i9;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType != ImageHeaderParser.ImageType.WEBP && imageType != ImageHeaderParser.ImageType.WEBP_A) {
                                if (i7 % iMax == 0 && i8 % iMax == 0) {
                                    iFloor = i7 / iMax;
                                    iRound = i8 / iMax;
                                } else {
                                    int[] iArrB = b(tVar, options, aVar, eVar);
                                    iFloor = iArrB[0];
                                    iRound = iArrB[1];
                                }
                            } else if (Build.VERSION.SDK_INT >= 24) {
                                float f4 = iMax;
                                iFloor = Math.round(f2 / f4);
                                iRound = Math.round(f3 / f4);
                            } else {
                                float f5 = iMax;
                                iFloor = (int) Math.floor(f2 / f5);
                                dFloor = Math.floor(f3 / f5);
                            }
                        } else {
                            float f6 = iMax;
                            iFloor = (int) Math.floor(f2 / f6);
                            dFloor = Math.floor(f3 / f6);
                        }
                        iRound = (int) dFloor;
                    }
                    double dB = downsampleStrategy.b(iFloor, iRound, i5, i6);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options.inTargetDensity = a(dB);
                        options.inDensity = b(dB);
                    }
                    if (b(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
        }
    }

    private static int a(double d2) {
        int iB = b(d2);
        double d3 = iB;
        Double.isNaN(d3);
        int iC = c(d3 * d2);
        double d4 = iC / iB;
        Double.isNaN(d4);
        double d5 = iC;
        Double.isNaN(d5);
        return c((d2 / d4) * d5);
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return h.contains(imageType);
    }

    private void a(t tVar, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.n.a(i2, i3, options, z, z2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean zHasAlpha = false;
            try {
                zHasAlpha = tVar.c().hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                }
            }
            options.inPreferredConfig = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(com.bumptech.glide.load.resource.bitmap.t r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.m.a r7, com.bumptech.glide.load.engine.a.e r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.a()
            r5.a()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.z.a()
            r4.lock()
            android.graphics.Bitmap r5 = r5.a(r6)     // Catch: java.lang.Throwable -> L25 java.lang.IllegalArgumentException -> L27
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.z.a()
            r6.unlock()
            return r5
        L25:
            r5 = move-exception
            goto L52
        L27:
            r4 = move-exception
            java.io.IOException r1 = a(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L25
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L38
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L25
        L38:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L51
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L50
            r8.a(r0)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L50
            r0 = 0
            r6.inBitmap = r0     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L50
            android.graphics.Bitmap r5 = a(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L50
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.z.a()
            r6.unlock()
            return r5
        L50:
            throw r1     // Catch: java.lang.Throwable -> L25
        L51:
            throw r1     // Catch: java.lang.Throwable -> L25
        L52:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.z.a()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.m.a(com.bumptech.glide.load.resource.bitmap.t, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.m$a, com.bumptech.glide.load.engine.a.e):android.graphics.Bitmap");
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + a(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.e.h.a(j));
    }

    private static String a(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, com.bumptech.glide.load.engine.a.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i2, i3, config);
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options optionsPoll;
        synchronized (i) {
            optionsPoll = i.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            d(optionsPoll);
        }
        return optionsPoll;
    }
}
