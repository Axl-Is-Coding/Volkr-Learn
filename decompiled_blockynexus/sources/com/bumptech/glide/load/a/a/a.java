package com.bumptech.glide.load.a.a;

import com.bumptech.glide.load.a.l;
import com.bumptech.glide.load.a.t;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.y;
import com.bumptech.glide.load.k;
import java.io.InputStream;

/* JADX INFO: compiled from: HttpGlideUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements u<l, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<Integer> f4230a = k.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t<l, l> f4231b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpGlideUrlLoader.java */
    public static class C0057a implements v<l, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t<l, l> f4232a = new t<>(500);

        @Override // com.bumptech.glide.load.a.v
        public u<l, InputStream> build(y yVar) {
            return new a(this.f4232a);
        }
    }

    public a(t<l, l> tVar) {
        this.f4231b = tVar;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<InputStream> buildLoadData(l lVar, int i, int i2, com.bumptech.glide.load.l lVar2) {
        t<l, l> tVar = this.f4231b;
        if (tVar != null) {
            l lVarA = tVar.a(lVar, 0, 0);
            if (lVarA == null) {
                this.f4231b.a(lVar, 0, 0, lVar);
            } else {
                lVar = lVarA;
            }
        }
        return new u.a<>(lVar, new com.bumptech.glide.load.data.k(lVar, ((Integer) lVar2.a(f4230a)).intValue()));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(l lVar) {
        return true;
    }
}
