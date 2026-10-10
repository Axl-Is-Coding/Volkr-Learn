package com.bumptech.glide.load.engine;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DecodePath.java */
/* JADX INFO: loaded from: classes.dex */
public class j<DataType, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<DataType> f4576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.m<DataType, ResourceType>> f4577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.b.d.e<ResourceType, Transcode> f4578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.core.f.e<List<Throwable>> f4579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f4580e;

    /* JADX INFO: compiled from: DecodePath.java */
    interface a<ResourceType> {
        C<ResourceType> a(C<ResourceType> c2);
    }

    public j(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.m<DataType, ResourceType>> list, com.bumptech.glide.load.b.d.e<ResourceType, Transcode> eVar, androidx.core.f.e<List<Throwable>> eVar2) {
        this.f4576a = cls;
        this.f4577b = list;
        this.f4578c = eVar;
        this.f4579d = eVar2;
        this.f4580e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public C<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, com.bumptech.glide.load.l lVar, a<ResourceType> aVar) throws GlideException {
        return this.f4578c.a(aVar.a(a(eVar, i, i2, lVar)), lVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f4576a + ", decoders=" + this.f4577b + ", transcoder=" + this.f4578c + '}';
    }

    private C<ResourceType> a(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, com.bumptech.glide.load.l lVar) throws GlideException {
        List<Throwable> listA = this.f4579d.a();
        com.bumptech.glide.e.l.a(listA);
        List<Throwable> list = listA;
        try {
            return a(eVar, i, i2, lVar, list);
        } finally {
            this.f4579d.a(list);
        }
    }

    private C<ResourceType> a(com.bumptech.glide.load.data.e<DataType> eVar, int i, int i2, com.bumptech.glide.load.l lVar, List<Throwable> list) throws GlideException {
        int size = this.f4577b.size();
        C<ResourceType> cA = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.bumptech.glide.load.m<DataType, ResourceType> mVar = this.f4577b.get(i3);
            try {
                if (mVar.a(eVar.a(), lVar)) {
                    cA = mVar.a(eVar.a(), i, i2, lVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + mVar, e2);
                }
                list.add(e2);
            }
            if (cA != null) {
                break;
            }
        }
        if (cA != null) {
            return cA;
        }
        throw new GlideException(this.f4580e, new ArrayList(list));
    }
}
