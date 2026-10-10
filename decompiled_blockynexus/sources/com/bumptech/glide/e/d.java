package com.bumptech.glide.e;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: ExceptionCatchingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Queue<d> f4161a = n.a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f4162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IOException f4163c;

    d() {
    }

    public static d a(InputStream inputStream) {
        d dVarPoll;
        synchronized (f4161a) {
            dVarPoll = f4161a.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.b(inputStream);
        return dVarPoll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f4162b.available();
    }

    void b(InputStream inputStream) {
        this.f4162b = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4162b.close();
    }

    public void d() {
        this.f4163c = null;
        this.f4162b = null;
        synchronized (f4161a) {
            f4161a.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f4162b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f4162b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f4162b.read(bArr);
        } catch (IOException e2) {
            this.f4163c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f4162b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f4162b.skip(j);
        } catch (IOException e2) {
            this.f4163c = e2;
            return 0L;
        }
    }

    public IOException b() {
        return this.f4163c;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f4162b.read(bArr, i, i2);
        } catch (IOException e2) {
            this.f4163c = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f4162b.read();
        } catch (IOException e2) {
            this.f4163c = e2;
            return -1;
        }
    }
}
