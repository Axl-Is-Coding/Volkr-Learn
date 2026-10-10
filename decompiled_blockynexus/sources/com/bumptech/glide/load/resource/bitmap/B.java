package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
class B implements k.a<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f4637a = ByteBuffer.allocate(8);

    B() {
    }

    @Override // com.bumptech.glide.load.k.a
    public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
        messageDigest.update(bArr);
        synchronized (this.f4637a) {
            this.f4637a.position(0);
            messageDigest.update(this.f4637a.putLong(l.longValue()).array());
        }
    }
}
