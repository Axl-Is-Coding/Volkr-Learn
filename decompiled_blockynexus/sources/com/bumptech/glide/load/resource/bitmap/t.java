package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: ImageReader.java */
/* JADX INFO: loaded from: classes.dex */
interface t {

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.data.l f4695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.a.b f4696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f4697c;

        a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.b bVar) {
            com.bumptech.glide.e.l.a(bVar);
            this.f4696b = bVar;
            com.bumptech.glide.e.l.a(list);
            this.f4697c = list;
            this.f4695a = new com.bumptech.glide.load.data.l(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f4695a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public int b() throws IOException {
            return com.bumptech.glide.load.g.a(this.f4697c, this.f4695a.a(), this.f4696b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.g.b(this.f4697c, this.f4695a.a(), this.f4696b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public void a() {
            this.f4695a.c();
        }
    }

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class b implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.a.b f4698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f4699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f4700c;

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.b bVar) {
            com.bumptech.glide.e.l.a(bVar);
            this.f4698a = bVar;
            com.bumptech.glide.e.l.a(list);
            this.f4699b = list;
            this.f4700c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f4700c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public int b() throws IOException {
            return com.bumptech.glide.load.g.a(this.f4699b, this.f4700c, this.f4698a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.t
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.g.b(this.f4699b, this.f4700c, this.f4698a);
        }
    }

    Bitmap a(BitmapFactory.Options options) throws IOException;

    void a();

    int b() throws IOException;

    ImageHeaderParser.ImageType c() throws IOException;
}
