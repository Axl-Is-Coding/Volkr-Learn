package com.bumptech.glide.load.a;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public interface u<Model, Data> {

    /* JADX INFO: compiled from: ModelLoader.java */
    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.h f4296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.h> f4297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f4298c;

        public a(com.bumptech.glide.load.h hVar, com.bumptech.glide.load.data.d<Data> dVar) {
            this(hVar, Collections.emptyList(), dVar);
        }

        public a(com.bumptech.glide.load.h hVar, List<com.bumptech.glide.load.h> list, com.bumptech.glide.load.data.d<Data> dVar) {
            com.bumptech.glide.e.l.a(hVar);
            this.f4296a = hVar;
            com.bumptech.glide.e.l.a(list);
            this.f4297b = list;
            com.bumptech.glide.e.l.a(dVar);
            this.f4298c = dVar;
        }
    }

    a<Data> buildLoadData(Model model, int i, int i2, com.bumptech.glide.load.l lVar);

    boolean handles(Model model);
}
