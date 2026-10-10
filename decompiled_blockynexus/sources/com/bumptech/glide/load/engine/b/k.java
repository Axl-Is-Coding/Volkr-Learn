package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.e.a.d;
import com.bumptech.glide.load.engine.b.l;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SafeKeyGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class k implements d.a<l.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f4531a;

    k(l lVar) {
        this.f4531a = lVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.e.a.d.a
    public l.a create() {
        try {
            return new l.a(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
