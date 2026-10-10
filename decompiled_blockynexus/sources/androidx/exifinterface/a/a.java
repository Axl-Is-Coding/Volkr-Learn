package androidx.exifinterface.a;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ExifInterface.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final HashMap<Integer, c>[] A;
    private static final HashMap<String, c>[] B;
    private static final HashSet<String> C;
    private static final HashMap<Integer, Integer> D;
    static final Charset E;
    static final byte[] F;
    private static final Pattern G;
    private static final Pattern H;
    private static SimpleDateFormat i;
    static final c[][] w;
    private static final c[] x;
    private static final c y;
    private static final c z;
    private final String I;
    private final AssetManager.AssetInputStream J;
    private int K;
    private final HashMap<String, b>[] L;
    private Set<Integer> M;
    private ByteOrder N;
    private boolean O;
    private int P;
    private int Q;
    private byte[] R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int X;
    private boolean Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Integer> f1383a = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f1384b = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1385c = {8, 8, 8};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1386d = {4};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1387e = {8};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final byte[] f1388f = {-1, -40, -1};
    private static final byte[] g = {79, 76, 89, 77, 80, 0};
    private static final byte[] h = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    static final String[] j = {"", "BYTE", com.tendcloud.tenddata.a.MF_STRING, "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] k = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] l = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final c[] m = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
    private static final c[] n = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c[] o = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
    private static final c[] p = {new c("InteroperabilityIndex", 1, 2)};
    private static final c[] q = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c r = new c("StripOffsets", 273, 3);
    private static final c[] s = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
    private static final c[] t = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
    private static final c[] u = {new c("AspectFrame", 4371, 3)};
    private static final c[] v = {new c("ColorSpace", 55, 3)};

    /* JADX INFO: compiled from: ExifInterface.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1403b;

        d(long j, long j2) {
            if (j2 == 0) {
                this.f1402a = 0L;
                this.f1403b = 1L;
            } else {
                this.f1402a = j;
                this.f1403b = j2;
            }
        }

        public double a() {
            double d2 = this.f1402a;
            double d3 = this.f1403b;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }

        public String toString() {
            return this.f1402a + "/" + this.f1403b;
        }
    }

    static {
        c[] cVarArr = m;
        w = new c[][]{cVarArr, n, o, p, q, cVarArr, s, t, u, v};
        x = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        y = new c("JPEGInterchangeFormat", 513, 4);
        z = new c("JPEGInterchangeFormatLength", 514, 4);
        c[][] cVarArr2 = w;
        A = new HashMap[cVarArr2.length];
        B = new HashMap[cVarArr2.length];
        C = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        D = new HashMap<>();
        E = Charset.forName("US-ASCII");
        F = "Exif\u0000\u0000".getBytes(E);
        i = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        i.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < w.length; i2++) {
            A[i2] = new HashMap<>();
            B[i2] = new HashMap<>();
            for (c cVar : w[i2]) {
                A[i2].put(Integer.valueOf(cVar.f1398a), cVar);
                B[i2].put(cVar.f1399b, cVar);
            }
        }
        D.put(Integer.valueOf(x[0].f1398a), 5);
        D.put(Integer.valueOf(x[1].f1398a), 1);
        D.put(Integer.valueOf(x[2].f1398a), 2);
        D.put(Integer.valueOf(x[3].f1398a), 3);
        D.put(Integer.valueOf(x[4].f1398a), 7);
        D.put(Integer.valueOf(x[5].f1398a), 8);
        G = Pattern.compile(".*[1-9].*");
        H = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public a(String str) throws Throwable {
        c[][] cVarArr = w;
        this.L = new HashMap[cVarArr.length];
        this.M = new HashSet(cVarArr.length);
        this.N = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        FileInputStream fileInputStream = null;
        this.J = null;
        this.I = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                a((InputStream) fileInputStream2);
                a((Closeable) fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private b b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < w.length; i2++) {
            b bVar = this.L[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    private boolean c(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean d(byte[] bArr) throws IOException {
        C0023a c0023a = new C0023a(bArr);
        this.N = e(c0023a);
        c0023a.a(this.N);
        short s2 = c0023a.readShort();
        c0023a.close();
        return s2 == 85;
    }

    private ByteOrder e(C0023a c0023a) throws IOException {
        short s2 = c0023a.readShort();
        if (s2 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    private void f(C0023a c0023a) throws Throwable {
        HashMap<String, b> map = this.L[4];
        b bVar = map.get("Compression");
        if (bVar == null) {
            this.S = 6;
            a(c0023a, map);
            return;
        }
        this.S = bVar.b(this.N);
        int i2 = this.S;
        if (i2 != 1) {
            if (i2 == 6) {
                a(c0023a, map);
                return;
            } else if (i2 != 7) {
                return;
            }
        }
        if (a((HashMap) map)) {
            b(c0023a, map);
        }
    }

    public String a(String str) {
        b bVarB = b(str);
        if (bVarB != null) {
            if (!C.contains(str)) {
                return bVarB.c(this.N);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = bVarB.f1395a;
                if (i2 != 5 && i2 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + bVarB.f1395a);
                    return null;
                }
                d[] dVarArr = (d[]) bVarB.d(this.N);
                if (dVarArr != null && dVarArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (dVarArr[0].f1402a / dVarArr[0].f1403b)), Integer.valueOf((int) (dVarArr[1].f1402a / dVarArr[1].f1403b)), Integer.valueOf((int) (dVarArr[2].f1402a / dVarArr[2].f1403b)));
                }
                Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                return null;
            }
            try {
                return Double.toString(bVarB.a(this.N));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: androidx.exifinterface.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExifInterface.java */
    private static class C0023a extends InputStream implements DataInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ByteOrder f1389a = ByteOrder.LITTLE_ENDIAN;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final ByteOrder f1390b = ByteOrder.BIG_ENDIAN;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private DataInputStream f1391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ByteOrder f1392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f1393e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1394f;

        public C0023a(InputStream inputStream) throws IOException {
            this.f1392d = ByteOrder.BIG_ENDIAN;
            this.f1391c = new DataInputStream(inputStream);
            this.f1393e = this.f1391c.available();
            this.f1394f = 0;
            this.f1391c.mark(this.f1393e);
        }

        public void a(ByteOrder byteOrder) {
            this.f1392d = byteOrder;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f1391c.available();
        }

        public void b(long j) throws IOException {
            int i = this.f1394f;
            if (i > j) {
                this.f1394f = 0;
                this.f1391c.reset();
                this.f1391c.mark(this.f1393e);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int peek() {
            return this.f1394f;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f1394f++;
            return this.f1391c.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f1394f++;
            return this.f1391c.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f1394f++;
            if (this.f1394f > this.f1393e) {
                throw new EOFException();
            }
            int i = this.f1391c.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f1394f += 2;
            return this.f1391c.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.f1394f += i2;
            if (this.f1394f > this.f1393e) {
                throw new EOFException();
            }
            if (this.f1391c.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f1394f += 4;
            if (this.f1394f > this.f1393e) {
                throw new EOFException();
            }
            int i = this.f1391c.read();
            int i2 = this.f1391c.read();
            int i3 = this.f1391c.read();
            int i4 = this.f1391c.read();
            if ((i | i2 | i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1392d;
            if (byteOrder == f1389a) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == f1390b) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            throw new IOException("Invalid byte order: " + this.f1392d);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f1394f += 8;
            if (this.f1394f > this.f1393e) {
                throw new EOFException();
            }
            int i = this.f1391c.read();
            int i2 = this.f1391c.read();
            int i3 = this.f1391c.read();
            int i4 = this.f1391c.read();
            int i5 = this.f1391c.read();
            int i6 = this.f1391c.read();
            int i7 = this.f1391c.read();
            int i8 = this.f1391c.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1392d;
            if (byteOrder == f1389a) {
                return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8) + ((long) i);
            }
            if (byteOrder == f1390b) {
                return (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8) + ((long) i8);
            }
            throw new IOException("Invalid byte order: " + this.f1392d);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f1394f += 2;
            if (this.f1394f > this.f1393e) {
                throw new EOFException();
            }
            int i = this.f1391c.read();
            int i2 = this.f1391c.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1392d;
            if (byteOrder == f1389a) {
                return (short) ((i2 << 8) + i);
            }
            if (byteOrder == f1390b) {
                return (short) ((i << 8) + i2);
            }
            throw new IOException("Invalid byte order: " + this.f1392d);
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f1394f += 2;
            return this.f1391c.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f1394f++;
            return this.f1391c.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f1394f += 2;
            if (this.f1394f > this.f1393e) {
                throw new EOFException();
            }
            int i = this.f1391c.read();
            int i2 = this.f1391c.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f1392d;
            if (byteOrder == f1389a) {
                return (i2 << 8) + i;
            }
            if (byteOrder == f1390b) {
                return (i << 8) + i2;
            }
            throw new IOException("Invalid byte order: " + this.f1392d);
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            int iMin = Math.min(i, this.f1393e - this.f1394f);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.f1391c.skipBytes(iMin - iSkipBytes);
            }
            this.f1394f += iSkipBytes;
            return iSkipBytes;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f1391c.read(bArr, i, i2);
            this.f1394f += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f1394f += bArr.length;
            if (this.f1394f <= this.f1393e) {
                if (this.f1391c.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public C0023a(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }

        public long b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }
    }

    private boolean b(byte[] bArr) throws IOException {
        C0023a c0023a = new C0023a(bArr);
        this.N = e(c0023a);
        c0023a.a(this.N);
        short s2 = c0023a.readShort();
        c0023a.close();
        return s2 == 20306 || s2 == 21330;
    }

    private void c(C0023a c0023a) throws Throwable {
        b bVar;
        a(c0023a, c0023a.available());
        b(c0023a, 0);
        d(c0023a, 0);
        d(c0023a, 5);
        d(c0023a, 4);
        b((InputStream) c0023a);
        if (this.K != 8 || (bVar = this.L[1].get("MakerNote")) == null) {
            return;
        }
        C0023a c0023a2 = new C0023a(bVar.f1397c);
        c0023a2.a(this.N);
        c0023a2.b(6L);
        b(c0023a2, 9);
        b bVar2 = this.L[9].get("ColorSpace");
        if (bVar2 != null) {
            this.L[1].put("ColorSpace", bVar2);
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f1397c;

        b(int i, int i2, byte[] bArr) {
            this.f1395a = i;
            this.f1396b = i2;
            this.f1397c = bArr;
        }

        public static b a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.k[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new b(3, iArr.length, byteBufferWrap.array());
        }

        public int b(ByteOrder byteOrder) throws Throwable {
            Object objD = d(byteOrder);
            if (objD == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objD instanceof String) {
                return Integer.parseInt((String) objD);
            }
            if (objD instanceof long[]) {
                long[] jArr = (long[]) objD;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objD instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objD;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String c(ByteOrder byteOrder) throws Throwable {
            Object objD = d(byteOrder);
            if (objD == null) {
                return null;
            }
            if (objD instanceof String) {
                return (String) objD;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (objD instanceof long[]) {
                long[] jArr = (long[]) objD;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objD instanceof int[]) {
                int[] iArr = (int[]) objD;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objD instanceof double[]) {
                double[] dArr = (double[]) objD;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objD instanceof d[])) {
                return null;
            }
            d[] dVarArr = (d[]) objD;
            while (i < dVarArr.length) {
                sb.append(dVarArr[i].f1402a);
                sb.append('/');
                sb.append(dVarArr[i].f1403b);
                i++;
                if (i != dVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:166:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object d(java.nio.ByteOrder r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 466
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.a.a.b.d(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + a.j[this.f1395a] + ", data length:" + this.f1397c.length + ")";
        }

        public static b a(int i, ByteOrder byteOrder) {
            return a(new int[]{i}, byteOrder);
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.k[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new b(4, jArr.length, byteBufferWrap.array());
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.E);
            return new b(2, bytes.length, bytes);
        }

        public static b a(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.k[5] * dVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (d dVar : dVarArr) {
                byteBufferWrap.putInt((int) dVar.f1402a);
                byteBufferWrap.putInt((int) dVar.f1403b);
            }
            return new b(5, dVarArr.length, byteBufferWrap.array());
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            return a(new d[]{dVar}, byteOrder);
        }

        public double a(ByteOrder byteOrder) throws Throwable {
            Object objD = d(byteOrder);
            if (objD != null) {
                if (objD instanceof String) {
                    return Double.parseDouble((String) objD);
                }
                if (objD instanceof long[]) {
                    if (((long[]) objD).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objD instanceof int[]) {
                    if (((int[]) objD).length == 1) {
                        return r5[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objD instanceof double[]) {
                    double[] dArr = (double[]) objD;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objD instanceof d[]) {
                    d[] dVarArr = (d[]) objD;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a double value");
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1401d;

        c(String str, int i, int i2) {
            this.f1399b = str;
            this.f1398a = i;
            this.f1400c = i2;
            this.f1401d = -1;
        }

        boolean a(int i) {
            int i2;
            int i3 = this.f1400c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.f1401d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((this.f1400c == 9 || this.f1401d == 9) && i == 8) {
                return true;
            }
            return (this.f1400c == 12 || this.f1401d == 12) && i == 11;
        }

        c(String str, int i, int i2, int i3) {
            this.f1399b = str;
            this.f1398a = i;
            this.f1400c = i2;
            this.f1401d = i3;
        }
    }

    private void d(C0023a c0023a) throws Throwable {
        c(c0023a);
        if (this.L[0].get("JpgFromRaw") != null) {
            a(c0023a, this.X, 5);
        }
        b bVar = this.L[0].get("ISO");
        b bVar2 = this.L[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.L[1].put("PhotographicSensitivity", bVar);
    }

    private void b(C0023a c0023a) throws IOException {
        c0023a.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        c0023a.read(bArr);
        c0023a.skipBytes(4);
        c0023a.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(c0023a, i2, 5);
        c0023a.b(i3);
        c0023a.a(ByteOrder.BIG_ENDIAN);
        int i4 = c0023a.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = c0023a.readUnsignedShort();
            int unsignedShort2 = c0023a.readUnsignedShort();
            if (unsignedShort == r.f1398a) {
                short s2 = c0023a.readShort();
                short s3 = c0023a.readShort();
                b bVarA = b.a((int) s2, this.N);
                b bVarA2 = b.a((int) s3, this.N);
                this.L[0].put("ImageLength", bVarA);
                this.L[0].put("ImageWidth", bVarA2);
                return;
            }
            c0023a.skipBytes(unsignedShort2);
        }
    }

    public a(InputStream inputStream) throws IOException {
        c[][] cVarArr = w;
        this.L = new HashMap[cVarArr.length];
        this.M = new HashSet(cVarArr.length);
        this.N = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.I = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.J = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.J = null;
            }
            a(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }

    private void d(C0023a c0023a, int i2) throws Throwable {
        b bVarA;
        b bVarA2;
        b bVar = this.L[i2].get("DefaultCropSize");
        b bVar2 = this.L[i2].get("SensorTopBorder");
        b bVar3 = this.L[i2].get("SensorLeftBorder");
        b bVar4 = this.L[i2].get("SensorBottomBorder");
        b bVar5 = this.L[i2].get("SensorRightBorder");
        if (bVar == null) {
            if (bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
                int iB = bVar2.b(this.N);
                int iB2 = bVar4.b(this.N);
                int iB3 = bVar5.b(this.N);
                int iB4 = bVar3.b(this.N);
                if (iB2 <= iB || iB3 <= iB4) {
                    return;
                }
                b bVarA3 = b.a(iB2 - iB, this.N);
                b bVarA4 = b.a(iB3 - iB4, this.N);
                this.L[i2].put("ImageLength", bVarA3);
                this.L[i2].put("ImageWidth", bVarA4);
                return;
            }
            c(c0023a, i2);
            return;
        }
        if (bVar.f1395a == 5) {
            d[] dVarArr = (d[]) bVar.d(this.N);
            if (dVarArr != null && dVarArr.length == 2) {
                bVarA = b.a(dVarArr[0], this.N);
                bVarA2 = b.a(dVarArr[1], this.N);
            } else {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                return;
            }
        } else {
            int[] iArr = (int[]) bVar.d(this.N);
            if (iArr != null && iArr.length == 2) {
                bVarA = b.a(iArr[0], this.N);
                bVarA2 = b.a(iArr[1], this.N);
            } else {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
        }
        this.L[i2].put("ImageWidth", bVarA);
        this.L[i2].put("ImageLength", bVarA2);
    }

    public int a(String str, int i2) {
        b bVarB = b(str);
        if (bVarB == null) {
            return i2;
        }
        try {
            return bVarB.b(this.N);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    private void a(InputStream inputStream) throws IOException {
        for (int i2 = 0; i2 < w.length; i2++) {
            try {
                try {
                    this.L[i2] = new HashMap<>();
                } catch (IOException unused) {
                    this.Y = false;
                }
            } finally {
                a();
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.K = a(bufferedInputStream);
        C0023a c0023a = new C0023a(bufferedInputStream);
        switch (this.K) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                c(c0023a);
                break;
            case 4:
                a(c0023a, 0, 0);
                break;
            case 7:
                a(c0023a);
                break;
            case 9:
                b(c0023a);
                break;
            case 10:
                d(c0023a);
                break;
        }
        f(c0023a);
        this.Y = true;
    }

    private void c(C0023a c0023a, int i2) throws IOException {
        b bVar;
        b bVar2 = this.L[i2].get("ImageLength");
        b bVar3 = this.L[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.L[i2].get("JPEGInterchangeFormat")) != null) {
            a(c0023a, bVar.b(this.N), i2);
        }
    }

    private int a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (a(bArr)) {
            return 4;
        }
        if (c(bArr)) {
            return 9;
        }
        if (b(bArr)) {
            return 7;
        }
        return d(bArr) ? 10 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(androidx.exifinterface.a.a.C0023a r24, int r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 807
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.a.a.b(androidx.exifinterface.a.a$a, int):void");
    }

    private static boolean a(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f1388f;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[FALL_THROUGH] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.exifinterface.a.a.C0023a r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.a.a.a(androidx.exifinterface.a.a$a, int, int):void");
    }

    private void a(C0023a c0023a) throws Throwable {
        c(c0023a);
        b bVar = this.L[1].get("MakerNote");
        if (bVar != null) {
            C0023a c0023a2 = new C0023a(bVar.f1397c);
            c0023a2.a(this.N);
            byte[] bArr = new byte[g.length];
            c0023a2.readFully(bArr);
            c0023a2.b(0L);
            byte[] bArr2 = new byte[h.length];
            c0023a2.readFully(bArr2);
            if (Arrays.equals(bArr, g)) {
                c0023a2.b(8L);
            } else if (Arrays.equals(bArr2, h)) {
                c0023a2.b(12L);
            }
            b(c0023a2, 6);
            b bVar2 = this.L[7].get("PreviewImageStart");
            b bVar3 = this.L[7].get("PreviewImageLength");
            if (bVar2 != null && bVar3 != null) {
                this.L[5].put("JPEGInterchangeFormat", bVar2);
                this.L[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.L[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.d(this.N);
                if (iArr != null && iArr.length == 4) {
                    if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                        return;
                    }
                    int i2 = (iArr[2] - iArr[0]) + 1;
                    int i3 = (iArr[3] - iArr[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    b bVarA = b.a(i2, this.N);
                    b bVarA2 = b.a(i3, this.N);
                    this.L[0].put("ImageWidth", bVarA);
                    this.L[0].put("ImageLength", bVarA2);
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    private void b(C0023a c0023a, HashMap map) throws IOException {
        b bVar = (b) map.get("StripOffsets");
        b bVar2 = (b) map.get("StripByteCounts");
        if (bVar == null || bVar2 == null) {
            return;
        }
        long[] jArrA = a(bVar.d(this.N));
        long[] jArrA2 = a(bVar2.d(this.N));
        if (jArrA == null) {
            Log.w("ExifInterface", "stripOffsets should not be null.");
            return;
        }
        if (jArrA2 == null) {
            Log.w("ExifInterface", "stripByteCounts should not be null.");
            return;
        }
        long j2 = 0;
        for (long j3 : jArrA2) {
            j2 += j3;
        }
        byte[] bArr = new byte[(int) j2];
        int i2 = 0;
        int length = 0;
        for (int i3 = 0; i3 < jArrA.length; i3++) {
            int i4 = (int) jArrA[i3];
            int i5 = (int) jArrA2[i3];
            int i6 = i4 - i2;
            if (i6 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
            }
            c0023a.b(i6);
            int i7 = i2 + i6;
            byte[] bArr2 = new byte[i5];
            c0023a.read(bArr2);
            i2 = i7 + i5;
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        this.O = true;
        this.R = bArr;
        this.Q = bArr.length;
    }

    private void a(byte[] bArr, int i2) throws IOException {
        C0023a c0023a = new C0023a(bArr);
        a(c0023a, bArr.length);
        b(c0023a, i2);
    }

    private void a() {
        String strA = a("DateTimeOriginal");
        if (strA != null && a("DateTime") == null) {
            this.L[0].put("DateTime", b.a(strA));
        }
        if (a("ImageWidth") == null) {
            this.L[0].put("ImageWidth", b.a(0L, this.N));
        }
        if (a("ImageLength") == null) {
            this.L[0].put("ImageLength", b.a(0L, this.N));
        }
        if (a("Orientation") == null) {
            this.L[0].put("Orientation", b.a(0L, this.N));
        }
        if (a("LightSource") == null) {
            this.L[1].put("LightSource", b.a(0L, this.N));
        }
    }

    private boolean b(HashMap map) throws IOException {
        b bVar = (b) map.get("ImageLength");
        b bVar2 = (b) map.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.b(this.N) <= 512 && bVar2.b(this.N) <= 512;
    }

    private void b(InputStream inputStream) throws Throwable {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar = this.L[1].get("PixelXDimension");
        b bVar2 = this.L[1].get("PixelYDimension");
        if (bVar != null && bVar2 != null) {
            this.L[0].put("ImageWidth", bVar);
            this.L[0].put("ImageLength", bVar2);
        }
        if (this.L[4].isEmpty() && b(this.L[5])) {
            HashMap<String, b>[] mapArr = this.L;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (b(this.L[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private void a(C0023a c0023a, int i2) throws IOException {
        this.N = e(c0023a);
        c0023a.a(this.N);
        int unsignedShort = c0023a.readUnsignedShort();
        int i3 = this.K;
        if (i3 != 7 && i3 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i4 = c0023a.readInt();
        if (i4 >= 8 && i4 < i2) {
            int i5 = i4 - 8;
            if (i5 <= 0 || c0023a.skipBytes(i5) == i5) {
                return;
            }
            throw new IOException("Couldn't jump to first Ifd: " + i5);
        }
        throw new IOException("Invalid first Ifd offset: " + i4);
    }

    private void a(C0023a c0023a, HashMap map) throws Throwable {
        int i2;
        b bVar = (b) map.get("JPEGInterchangeFormat");
        b bVar2 = (b) map.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int iB = bVar.b(this.N);
        int iMin = Math.min(bVar2.b(this.N), c0023a.available() - iB);
        int i3 = this.K;
        if (i3 != 4 && i3 != 9 && i3 != 10) {
            if (i3 == 7) {
                i2 = this.U;
            }
            if (iB > 0 || iMin <= 0) {
            }
            this.O = true;
            this.P = iB;
            this.Q = iMin;
            if (this.I == null && this.J == null) {
                byte[] bArr = new byte[iMin];
                c0023a.b(iB);
                c0023a.readFully(bArr);
                this.R = bArr;
                return;
            }
            return;
        }
        i2 = this.T;
        iB += i2;
        if (iB > 0) {
        }
    }

    private boolean a(HashMap map) throws Throwable {
        b bVar;
        b bVar2 = (b) map.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.d(this.N);
        if (Arrays.equals(f1385c, iArr)) {
            return true;
        }
        if (this.K != 3 || (bVar = (b) map.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int iB = bVar.b(this.N);
        return (iB == 1 && Arrays.equals(iArr, f1387e)) || (iB == 6 && Arrays.equals(iArr, f1385c));
    }

    private void a(int i2, int i3) throws Throwable {
        if (this.L[i2].isEmpty() || this.L[i3].isEmpty()) {
            return;
        }
        b bVar = this.L[i2].get("ImageLength");
        b bVar2 = this.L[i2].get("ImageWidth");
        b bVar3 = this.L[i3].get("ImageLength");
        b bVar4 = this.L[i3].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int iB = bVar.b(this.N);
        int iB2 = bVar2.b(this.N);
        int iB3 = bVar3.b(this.N);
        int iB4 = bVar4.b(this.N);
        if (iB >= iB3 || iB2 >= iB4) {
            return;
        }
        HashMap<String, b>[] mapArr = this.L;
        HashMap<String, b> map = mapArr[i2];
        mapArr[i2] = mapArr[i3];
        mapArr[i3] = map;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = iArr[i2];
            }
            return jArr;
        }
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }
}
