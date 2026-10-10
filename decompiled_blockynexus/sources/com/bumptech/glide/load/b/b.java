package com.bumptech.glide.load.b;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
class b implements ImageDecoder.OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f4331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f4332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DecodeFormat f4333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ DownsampleStrategy f4334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PreferredColorSpace f4335f;
    final /* synthetic */ c g;

    b(c cVar, int i, int i2, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
        this.g = cVar;
        this.f4330a = i;
        this.f4331b = i2;
        this.f4332c = z;
        this.f4333d = decodeFormat;
        this.f4334e = downsampleStrategy;
        this.f4335f = preferredColorSpace;
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    @SuppressLint({"Override"})
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.g.f4339a.a(this.f4330a, this.f4331b, this.f4332c, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f4333d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a(this));
        Size size = imageInfo.getSize();
        int width = this.f4330a;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f4331b;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f4334e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            imageDecoder.setTargetColorSpace(ColorSpace.get(this.f4335f == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut() ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        } else if (i >= 26) {
            imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        }
    }
}
