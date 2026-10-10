package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    interface a {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    interface b {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, new c(byteBuffer));
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new com.bumptech.glide.load.b(inputStream));
    }

    private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, b bVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType imageTypeA = bVar.a(list.get(i));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        return a(list, new d(parcelFileDescriptorRewinder, bVar));
    }

    public static int a(List<ImageHeaderParser> list, InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new e(inputStream, bVar));
    }

    public static int a(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        return a(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    private static int a(List<ImageHeaderParser> list, a aVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iA = aVar.a(list.get(i));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }
}
