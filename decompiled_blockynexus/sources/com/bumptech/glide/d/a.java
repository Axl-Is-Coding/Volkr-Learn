package com.bumptech.glide.d;

import android.content.Context;
import com.bumptech.glide.e.n;
import com.bumptech.glide.load.h;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: AndroidResourceSignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f4138b;

    private a(int i, h hVar) {
        this.f4137a = i;
        this.f4138b = hVar;
    }

    public static h a(Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.a(context));
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4137a == aVar.f4137a && this.f4138b.equals(aVar.f4138b);
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return n.a(this.f4138b, this.f4137a);
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f4138b.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f4137a).array());
    }
}
