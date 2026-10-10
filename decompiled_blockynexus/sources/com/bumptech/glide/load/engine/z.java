package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: LoadPath.java */
/* JADX INFO: loaded from: classes.dex */
public class z<Data, ResourceType, Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<Data> f4622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.core.f.e<List<Throwable>> f4623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<? extends j<Data, ResourceType, Transcode>> f4624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4625d;

    public z(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<j<Data, ResourceType, Transcode>> list, androidx.core.f.e<List<Throwable>> eVar) {
        this.f4622a = cls;
        this.f4623b = eVar;
        com.bumptech.glide.e.l.a(list);
        this.f4624c = list;
        this.f4625d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public C<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, com.bumptech.glide.load.l lVar, int i, int i2, j.a<ResourceType> aVar) throws GlideException {
        List<Throwable> listA = this.f4623b.a();
        com.bumptech.glide.e.l.a(listA);
        List<Throwable> list = listA;
        try {
            return a(eVar, lVar, i, i2, aVar, list);
        } finally {
            this.f4623b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f4624c.toArray()) + '}';
    }

    private C<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, com.bumptech.glide.load.l lVar, int i, int i2, j.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f4624c.size();
        C<Transcode> cA = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                cA = this.f4624c.get(i3).a(eVar, i, i2, lVar, aVar);
            } catch (GlideException e2) {
                list.add(e2);
            }
            if (cA != null) {
                break;
            }
        }
        if (cA != null) {
            return cA;
        }
        throw new GlideException(this.f4625d, new ArrayList(list));
    }
}
