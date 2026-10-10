package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: BufferedSource.java */
/* JADX INFO: loaded from: classes.dex */
public interface e extends s, ReadableByteChannel {
    long a(byte b2) throws IOException;

    void a(long j) throws IOException;

    void a(byte[] bArr) throws IOException;

    @Deprecated
    c c();

    f c(long j) throws IOException;

    String e(long j) throws IOException;

    boolean e() throws IOException;

    InputStream f();

    byte[] g(long j) throws IOException;

    byte h() throws IOException;

    void h(long j) throws IOException;

    short i() throws IOException;

    int j() throws IOException;

    short k() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    String p() throws IOException;
}
