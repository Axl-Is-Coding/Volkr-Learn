package com.bumptech.glide.e;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ByteBufferUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<byte[]> f4148a = new AtomicReference<>();

    /* JADX INFO: compiled from: ByteBufferUtil.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f4151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final byte[] f4153c;

        b(byte[] bArr, int i, int i2) {
            this.f4153c = bArr;
            this.f4151a = i;
            this.f4152b = i2;
        }
    }

    public static ByteBuffer a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (Throwable th) {
                    fileChannel = channel;
                    th = th;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public static InputStream b(ByteBuffer byteBuffer) {
        return new C0053a(byteBuffer);
    }

    private static b c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    /* JADX INFO: renamed from: com.bumptech.glide.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferUtil.java */
    private static class C0053a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f4149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4150b = -1;

        C0053a(ByteBuffer byteBuffer) {
            this.f4149a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f4149a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f4150b = this.f4149a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f4149a.hasRemaining()) {
                return this.f4149a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            if (this.f4150b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f4149a.position(this.f4150b);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            if (!this.f4149a.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j, available());
            ByteBuffer byteBuffer = this.f4149a;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!this.f4149a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i2, available());
            this.f4149a.get(bArr, i, iMin);
            return iMin;
        }
    }

    public static void a(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        b bVarC = c(byteBuffer);
        if (bVarC != null && bVarC.f4151a == 0 && bVarC.f4152b == bVarC.f4153c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static ByteBuffer a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f4148a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i = inputStream.read(andSet);
            if (i >= 0) {
                byteArrayOutputStream.write(andSet, 0, i);
            } else {
                f4148a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }
}
