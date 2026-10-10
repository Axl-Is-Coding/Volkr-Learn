package com.bytedance.sdk.openadsdk.h;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: RandomAccessFileWrapper.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f6954a;

    /* JADX INFO: compiled from: RandomAccessFileWrapper.java */
    static class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }

    h(File file, String str) throws a {
        try {
            this.f6954a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e2) {
            throw new a(e2);
        }
    }

    void a(long j) throws a {
        try {
            this.f6954a.seek(j);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    void a(byte[] bArr, int i, int i2) throws a {
        try {
            this.f6954a.write(bArr, i, i2);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    int a(byte[] bArr) throws a {
        try {
            return this.f6954a.read(bArr);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    void a() {
        com.bytedance.sdk.openadsdk.h.g.d.a(this.f6954a);
    }
}
