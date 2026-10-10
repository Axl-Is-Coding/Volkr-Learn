package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
class C implements k.a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f4638a = ByteBuffer.allocate(4);

    C() {
    }

    @Override // com.bumptech.glide.load.k.a
    public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.f4638a) {
            this.f4638a.position(0);
            messageDigest.update(this.f4638a.putInt(num.intValue()).array());
        }
    }
}
