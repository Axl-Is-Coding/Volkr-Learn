package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f4645a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f4646b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        int a(byte[] bArr, int i) throws IOException;

        short b() throws IOException;

        long skip(long j) throws IOException;
    }

    private static final class a implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4647a;

        a(ByteBuffer byteBuffer) {
            this.f4647a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws Reader.EndOfFileException {
            return (b() << 8) | b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short b() throws Reader.EndOfFileException {
            if (this.f4647a.remaining() >= 1) {
                return (short) (this.f4647a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) {
            int iMin = (int) Math.min(this.f4647a.remaining(), j);
            ByteBuffer byteBuffer = this.f4647a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] bArr, int i) {
            int iMin = Math.min(i, this.f4647a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f4647a.get(bArr, 0, iMin);
            return iMin;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4648a;

        b(byte[] bArr, int i) {
            this.f4648a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        void a(ByteOrder byteOrder) {
            this.f4648a.order(byteOrder);
        }

        int b(int i) {
            if (a(i, 4)) {
                return this.f4648a.getInt(i);
            }
            return -1;
        }

        int a() {
            return this.f4648a.remaining();
        }

        short a(int i) {
            if (a(i, 2)) {
                return this.f4648a.getShort(i);
            }
            return (short) -1;
        }

        private boolean a(int i, int i2) {
            return this.f4648a.remaining() - i >= i2;
        }
    }

    private static final class c implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f4649a;

        c(InputStream inputStream) {
            this.f4649a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws IOException {
            return (b() << 8) | b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short b() throws IOException {
            int i = this.f4649a.read();
            if (i != -1) {
                return (short) i;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.f4649a.skip(j2);
                if (jSkip <= 0) {
                    if (this.f4649a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a(byte[] bArr, int i) throws IOException {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.f4649a.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i2;
        }
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private int b(Reader reader) throws IOException {
        short sB;
        int iA;
        long j;
        long jSkip;
        do {
            short sB2 = reader.b();
            if (sB2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sB2));
                }
                return -1;
            }
            sB = reader.b();
            if (sB == 218) {
                return -1;
            }
            if (sB == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iA = reader.a() - 2;
            if (sB == 225) {
                return iA;
            }
            j = iA;
            jSkip = reader.skip(j);
        } while (jSkip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sB) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
        com.bumptech.glide.e.l.a(inputStream);
        return a(new c(inputStream));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        com.bumptech.glide.e.l.a(byteBuffer);
        return a(new a(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        com.bumptech.glide.e.l.a(inputStream);
        c cVar = new c(inputStream);
        com.bumptech.glide.e.l.a(bVar);
        return a(cVar, bVar);
    }

    private ImageHeaderParser.ImageType a(Reader reader) throws IOException {
        try {
            int iA = reader.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iB = (iA << 8) | reader.b();
            if (iB == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iB2 = (iB << 8) | reader.b();
            if (iB2 == -1991225785) {
                reader.skip(21L);
                try {
                    return reader.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iB2 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if (((reader.a() << 16) | reader.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (reader.a() << 16) | reader.a();
            if ((iA2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = iA2 & 255;
            if (i == 88) {
                reader.skip(4L);
                return (reader.b() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i == 76) {
                reader.skip(4L);
                return (reader.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private int a(Reader reader, com.bumptech.glide.load.engine.a.b bVar) throws IOException {
        try {
            int iA = reader.a();
            if (!a(iA)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
                }
                return -1;
            }
            int iB = b(reader);
            if (iB == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.a(iB, byte[].class);
            try {
                return a(reader, bArr, iB);
            } finally {
                bVar.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private int a(Reader reader, byte[] bArr, int i) throws IOException {
        int iA = reader.a(bArr, i);
        if (iA != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + iA);
            }
            return -1;
        }
        if (a(bArr, i)) {
            return a(new b(bArr, i));
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    private boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f4645a.length;
        if (!z) {
            return z;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f4645a;
            if (i2 >= bArr2.length) {
                return z;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i = 0; i < sA2; i++) {
            int iA = a(iB, i);
            short sA3 = bVar.a(iA);
            if (sA3 == 274) {
                short sA4 = bVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iA + 4);
                    if (iB2 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i2 = iB2 + f4646b[sA4];
                        if (i2 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                            }
                        } else {
                            int i3 = iA + 8;
                            if (i3 >= 0 && i3 <= bVar.a()) {
                                if (i2 >= 0 && i2 + i3 <= bVar.a()) {
                                    return bVar.a(i3);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) sA3));
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }
}
