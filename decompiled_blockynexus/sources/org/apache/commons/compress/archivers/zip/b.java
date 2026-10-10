package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import okio.Utf8;

/* JADX INFO: compiled from: NioZipEncoding.java */
/* JADX INFO: loaded from: classes5.dex */
class b implements a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f23529a = {Utf8.REPLACEMENT_BYTE};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23530b = String.valueOf('?');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f23531c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Charset f23532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f23533e;

    b(Charset charset, boolean z) {
        this.f23532d = charset;
        this.f23533e = z;
    }

    private CharsetDecoder a() {
        return !this.f23533e ? this.f23532d.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT) : this.f23532d.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith(f23530b);
    }

    @Override // org.apache.commons.compress.archivers.zip.d
    public String decode(byte[] bArr) throws IOException {
        return a().decode(ByteBuffer.wrap(bArr)).toString();
    }
}
