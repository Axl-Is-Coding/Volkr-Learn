package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.w;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.engine.z;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Registry {
    private final com.bumptech.glide.c.d h = new com.bumptech.glide.c.d();
    private final com.bumptech.glide.c.c i = new com.bumptech.glide.c.c();
    private final androidx.core.f.e<List<Throwable>> j = com.bumptech.glide.e.a.d.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f4076a = new w(this.j);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.c.a f4077b = new com.bumptech.glide.c.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.c.e f4078c = new com.bumptech.glide.c.e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.c.f f4079d = new com.bumptech.glide.c.f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.data.g f4080e = new com.bumptech.glide.load.data.g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.b.d.f f4081f = new com.bumptech.glide.load.b.d.f();
    private final com.bumptech.glide.c.b g = new com.bumptech.glide.c.b();

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, List<u<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        a(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.j<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f4078c.b(cls, cls2)) {
            for (Class cls5 : this.f4081f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.j(cls, cls4, cls5, this.f4078c.a(cls, cls4), this.f4081f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, com.bumptech.glide.load.a<Data> aVar) {
        this.f4077b.a(cls, aVar);
        return this;
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> listA = this.h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.f4076a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f4078c.b(it.next(), cls2)) {
                    if (!this.f4081f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.h.a(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, m<Data, TResource> mVar) {
        a("legacy_append", cls, cls2, mVar);
        return this;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, m<Data, TResource> mVar) {
        this.f4078c.a(str, mVar, cls, cls2);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f4078c.a(arrayList);
        return this;
    }

    public <TResource> Registry a(Class<TResource> cls, n<TResource> nVar) {
        this.f4079d.a(cls, nVar);
        return this;
    }

    public Registry a(e.a<?> aVar) {
        this.f4080e.a(aVar);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.b.d.e<TResource, Transcode> eVar) {
        this.f4081f.a(cls, cls2, eVar);
        return this;
    }

    public Registry a(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, v<Model, Data> vVar) {
        this.f4076a.a(cls, cls2, vVar);
        return this;
    }

    public <Data, TResource, Transcode> z<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        z<Data, TResource, Transcode> zVarA = this.i.a(cls, cls2, cls3);
        if (this.i.a(zVarA)) {
            return null;
        }
        if (zVarA == null) {
            List<com.bumptech.glide.load.engine.j<Data, TResource, Transcode>> listC = c(cls, cls2, cls3);
            zVarA = listC.isEmpty() ? null : new z<>(cls, cls2, cls3, listC, this.j);
            this.i.a(cls, cls2, cls3, zVarA);
        }
        return zVarA;
    }

    public <X> com.bumptech.glide.load.a<X> c(X x) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> aVarA = this.f4077b.a(x.getClass());
        if (aVarA != null) {
            return aVarA;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean b(C<?> c2) {
        return this.f4079d.a(c2.a()) != null;
    }

    public <X> com.bumptech.glide.load.data.e<X> b(X x) {
        return this.f4080e.a(x);
    }

    public <X> n<X> a(C<X> c2) throws NoResultEncoderAvailableException {
        n<X> nVarA = this.f4079d.a(c2.a());
        if (nVarA != null) {
            return nVarA;
        }
        throw new NoResultEncoderAvailableException(c2.a());
    }

    public <Model> List<u<Model, ?>> a(Model model) {
        return this.f4076a.a(model);
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> listA = this.g.a();
        if (listA.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listA;
    }
}
