package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
class f implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ParcelFileDescriptorRewinder f4626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.bumptech.glide.load.engine.a.b f4627b;

    f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.a.b bVar) {
        this.f4626a = parcelFileDescriptorRewinder;
        this.f4627b = bVar;
    }

    @Override // com.bumptech.glide.load.g.a
    public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
        RecyclableBufferedInputStream recyclableBufferedInputStream = null;
        try {
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f4626a.a().getFileDescriptor()), this.f4627b);
            try {
                int iA = imageHeaderParser.a(recyclableBufferedInputStream2, this.f4627b);
                try {
                    recyclableBufferedInputStream2.close();
                } catch (IOException unused) {
                }
                this.f4626a.a();
                return iA;
            } catch (Throwable th) {
                th = th;
                recyclableBufferedInputStream = recyclableBufferedInputStream2;
                if (recyclableBufferedInputStream != null) {
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f4626a.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
