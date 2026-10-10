package org.apache.commons.compress.compressors.a;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: GzipCompressorInputStream.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends org.apache.commons.compress.compressors.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputStream f23538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f23540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Inflater f23542f;
    private final CRC32 g;
    private boolean h;
    private final byte[] i;
    private final b j;

    public a(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    private boolean a(boolean z) throws IOException {
        int i = this.f23538b.read();
        int i2 = this.f23538b.read();
        if (i == -1 && !z) {
            return false;
        }
        if (i != 31 || i2 != 139) {
            throw new IOException(z ? "Input is not in the .gz format" : "Garbage after a valid .gz stream");
        }
        DataInputStream dataInputStream = new DataInputStream(this.f23538b);
        int unsignedByte = dataInputStream.readUnsignedByte();
        if (unsignedByte != 8) {
            throw new IOException("Unsupported compression method " + unsignedByte + " in the .gz header");
        }
        int unsignedByte2 = dataInputStream.readUnsignedByte();
        if ((unsignedByte2 & 224) != 0) {
            throw new IOException("Reserved flags are set in the .gz header");
        }
        this.j.a(org.apache.commons.compress.a.b.a(dataInputStream, 4) * 1000);
        int unsignedByte3 = dataInputStream.readUnsignedByte();
        if (unsignedByte3 == 2) {
            this.j.a(9);
        } else if (unsignedByte3 == 4) {
            this.j.a(1);
        }
        this.j.b(dataInputStream.readUnsignedByte());
        if ((unsignedByte2 & 4) != 0) {
            int unsignedByte4 = (dataInputStream.readUnsignedByte() << 8) | dataInputStream.readUnsignedByte();
            while (true) {
                int i3 = unsignedByte4 - 1;
                if (unsignedByte4 <= 0) {
                    break;
                }
                dataInputStream.readUnsignedByte();
                unsignedByte4 = i3;
            }
        }
        if ((unsignedByte2 & 8) != 0) {
            this.j.b(new String(a(dataInputStream), "ISO-8859-1"));
        }
        if ((unsignedByte2 & 16) != 0) {
            this.j.a(new String(a(dataInputStream), "ISO-8859-1"));
        }
        if ((unsignedByte2 & 2) != 0) {
            dataInputStream.readShort();
        }
        this.f23542f.reset();
        this.g.reset();
        return true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Inflater inflater = this.f23542f;
        if (inflater != null) {
            inflater.end();
            this.f23542f = null;
        }
        InputStream inputStream = this.f23538b;
        if (inputStream != System.in) {
            inputStream.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.i, 0, 1) == -1) {
            return -1;
        }
        return this.i[0] & 255;
    }

    public a(InputStream inputStream, boolean z) throws IOException {
        this.f23540d = new byte[8192];
        this.f23542f = new Inflater(true);
        this.g = new CRC32();
        this.h = false;
        this.i = new byte[1];
        this.j = new b();
        if (inputStream.markSupported()) {
            this.f23538b = inputStream;
        } else {
            this.f23538b = new BufferedInputStream(inputStream);
        }
        this.f23539c = z;
        a(true);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.h) {
            return -1;
        }
        int i3 = i;
        int i4 = 0;
        while (i2 > 0) {
            if (this.f23542f.needsInput()) {
                this.f23538b.mark(this.f23540d.length);
                this.f23541e = this.f23538b.read(this.f23540d);
                int i5 = this.f23541e;
                if (i5 == -1) {
                    throw new EOFException();
                }
                this.f23542f.setInput(this.f23540d, 0, i5);
            }
            try {
                int iInflate = this.f23542f.inflate(bArr, i3, i2);
                this.g.update(bArr, i3, iInflate);
                i3 += iInflate;
                i2 -= iInflate;
                i4 += iInflate;
                a(iInflate);
                if (this.f23542f.finished()) {
                    this.f23538b.reset();
                    long remaining = this.f23541e - this.f23542f.getRemaining();
                    if (this.f23538b.skip(remaining) != remaining) {
                        throw new IOException();
                    }
                    this.f23541e = 0;
                    DataInputStream dataInputStream = new DataInputStream(this.f23538b);
                    if (org.apache.commons.compress.a.b.a(dataInputStream, 4) != this.g.getValue()) {
                        throw new IOException("Gzip-compressed data is corrupt (CRC32 error)");
                    }
                    if (org.apache.commons.compress.a.b.a(dataInputStream, 4) != (this.f23542f.getBytesWritten() & 4294967295L)) {
                        throw new IOException("Gzip-compressed data is corrupt(uncompressed size mismatch)");
                    }
                    if (!this.f23539c || !a(false)) {
                        this.f23542f.end();
                        this.f23542f = null;
                        this.h = true;
                        if (i4 == 0) {
                            return -1;
                        }
                        return i4;
                    }
                }
            } catch (DataFormatException unused) {
                throw new IOException("Gzip-compressed data is corrupt");
            }
        }
        return i4;
    }

    private static byte[] a(DataInput dataInput) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int unsignedByte = dataInput.readUnsignedByte();
            if (unsignedByte != 0) {
                byteArrayOutputStream.write(unsignedByte);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
