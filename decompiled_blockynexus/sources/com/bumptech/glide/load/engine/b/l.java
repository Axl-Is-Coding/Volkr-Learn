package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.e.a.d;
import com.bumptech.glide.e.n;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.e.i<com.bumptech.glide.load.h, String> f4532a = new com.bumptech.glide.e.i<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.core.f.e<a> f4533b = com.bumptech.glide.e.a.d.a(10, new k(this));

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SafeKeyGenerator.java */
    static final class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageDigest f4534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.e.a.g f4535b = com.bumptech.glide.e.a.g.a();

        a(MessageDigest messageDigest) {
            this.f4534a = messageDigest;
        }

        @Override // com.bumptech.glide.e.a.d.c
        public com.bumptech.glide.e.a.g b() {
            return this.f4535b;
        }
    }

    private String b(com.bumptech.glide.load.h hVar) {
        a aVarA = this.f4533b.a();
        com.bumptech.glide.e.l.a(aVarA);
        a aVar = aVarA;
        try {
            hVar.updateDiskCacheKey(aVar.f4534a);
            return n.a(aVar.f4534a.digest());
        } finally {
            this.f4533b.a(aVar);
        }
    }

    public String a(com.bumptech.glide.load.h hVar) {
        String strA;
        synchronized (this.f4532a) {
            strA = this.f4532a.a(hVar);
        }
        if (strA == null) {
            strA = b(hVar);
        }
        synchronized (this.f4532a) {
            this.f4532a.b(hVar, strA);
        }
        return strA;
    }
}
