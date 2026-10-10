package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: TIOStreamTransport.java */
/* JADX INFO: loaded from: classes5.dex */
public class cn extends cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f20840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected OutputStream f20841b;

    protected cn() {
        this.f20840a = null;
        this.f20841b = null;
    }

    @Override // com.umeng.analytics.pro.cp
    public int a(byte[] bArr, int i, int i2) throws cq {
        InputStream inputStream = this.f20840a;
        if (inputStream == null) {
            throw new cq(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new cq(4);
        } catch (IOException e2) {
            throw new cq(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cp
    public void b() throws cq {
    }

    @Override // com.umeng.analytics.pro.cp
    public void b(byte[] bArr, int i, int i2) throws cq {
        OutputStream outputStream = this.f20841b;
        if (outputStream == null) {
            throw new cq(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e2) {
            throw new cq(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void c() {
        InputStream inputStream = this.f20840a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f20840a = null;
        }
        OutputStream outputStream = this.f20841b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.f20841b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void d() throws cq {
        OutputStream outputStream = this.f20841b;
        if (outputStream == null) {
            throw new cq(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e2) {
            throw new cq(0, e2);
        }
    }

    public cn(InputStream inputStream) {
        this.f20840a = null;
        this.f20841b = null;
        this.f20840a = inputStream;
    }

    public cn(OutputStream outputStream) {
        this.f20840a = null;
        this.f20841b = null;
        this.f20841b = outputStream;
    }

    public cn(InputStream inputStream, OutputStream outputStream) {
        this.f20840a = null;
        this.f20841b = null;
        this.f20840a = inputStream;
        this.f20841b = outputStream;
    }
}
