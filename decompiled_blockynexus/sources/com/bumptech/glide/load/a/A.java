package com.bumptech.glide.load.a;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class A implements com.bumptech.glide.load.a<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4213a;

    public A(com.bumptech.glide.load.engine.a.b bVar) {
        this.f4213a = bVar;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(InputStream inputStream, File file, com.bumptech.glide.load.l lVar) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.f4213a.a(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                }
            } catch (IOException e2) {
                e = e2;
            }
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream;
                    if (Log.isLoggable("StreamEncoder", 3)) {
                        Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    this.f4213a.put(bArr);
                    return z;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.f4213a.put(bArr);
                    throw th;
                }
                this.f4213a.put(bArr);
                return z;
            }
            fileOutputStream.close();
            z = true;
            fileOutputStream.close();
            this.f4213a.put(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
