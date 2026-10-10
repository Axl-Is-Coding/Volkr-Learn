package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.C;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MultiTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class i<T> implements o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<? extends o<T>> f4629a;

    @SafeVarargs
    public i(o<T>... oVarArr) {
        if (oVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f4629a = Arrays.asList(oVarArr);
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f4629a.equals(((i) obj).f4629a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return this.f4629a.hashCode();
    }

    @Override // com.bumptech.glide.load.o
    public C<T> transform(Context context, C<T> c2, int i, int i2) {
        Iterator<? extends o<T>> it = this.f4629a.iterator();
        C<T> c3 = c2;
        while (it.hasNext()) {
            C<T> cTransform = it.next().transform(context, c3, i, i2);
            if (c3 != null && !c3.equals(c2) && !c3.equals(cTransform)) {
                c3.recycle();
            }
            c3 = cTransform;
        }
        return c3;
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator<? extends o<T>> it = this.f4629a.iterator();
        while (it.hasNext()) {
            it.next().updateDiskCacheKey(messageDigest);
        }
    }
}
