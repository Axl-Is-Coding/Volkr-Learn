package com.bumptech.glide;

import com.bumptech.glide.l;

/* JADX INFO: compiled from: TransitionOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l<CHILD extends l<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bumptech.glide.request.a.c<? super TranscodeType> f4212a = com.bumptech.glide.request.a.a.a();

    final com.bumptech.glide.request.a.c<? super TranscodeType> b() {
        return this.f4212a;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m58clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
