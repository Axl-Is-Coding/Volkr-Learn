package com.bumptech.glide.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: StrictLineReader.java */
/* JADX INFO: loaded from: classes.dex */
class c extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f4104a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(d dVar, int i) {
        super(i);
        this.f4104a = dVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public String toString() {
        int i = ((ByteArrayOutputStream) this).count;
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, (i <= 0 || ((ByteArrayOutputStream) this).buf[i + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i - 1, this.f4104a.f4106b.name());
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }
}
