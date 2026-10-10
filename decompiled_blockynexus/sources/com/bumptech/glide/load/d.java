package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
class d implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ParcelFileDescriptorRewinder f4354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.bumptech.glide.load.engine.a.b f4355b;

    d(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.a.b bVar) {
        this.f4354a = parcelFileDescriptorRewinder;
        this.f4355b = bVar;
    }

    @Override // com.bumptech.glide.load.g.b
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
        RecyclableBufferedInputStream recyclableBufferedInputStream = null;
        try {
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f4354a.a().getFileDescriptor()), this.f4355b);
            try {
                ImageHeaderParser.ImageType imageTypeA = imageHeaderParser.a(recyclableBufferedInputStream2);
                try {
                    recyclableBufferedInputStream2.close();
                } catch (IOException unused) {
                }
                this.f4354a.a();
                return imageTypeA;
            } catch (Throwable th) {
                th = th;
                recyclableBufferedInputStream = recyclableBufferedInputStream2;
                if (recyclableBufferedInputStream != null) {
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f4354a.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
