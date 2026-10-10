package com.bumptech.glide.load.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MultiModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
class x<Model, Data> implements u<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<u<Model, Data>> f4303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.core.f.e<List<Throwable>> f4304b;

    x(List<u<Model, Data>> list, androidx.core.f.e<List<Throwable>> eVar) {
        this.f4303a = list;
        this.f4304b = eVar;
    }

    @Override // com.bumptech.glide.load.a.u
    public u.a<Data> buildLoadData(Model model, int i, int i2, com.bumptech.glide.load.l lVar) {
        u.a<Data> aVarBuildLoadData;
        int size = this.f4303a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.h hVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            u<Model, Data> uVar = this.f4303a.get(i3);
            if (uVar.handles(model) && (aVarBuildLoadData = uVar.buildLoadData(model, i, i2, lVar)) != null) {
                hVar = aVarBuildLoadData.f4296a;
                arrayList.add(aVarBuildLoadData.f4298c);
            }
        }
        if (arrayList.isEmpty() || hVar == null) {
            return null;
        }
        return new u.a<>(hVar, new a(arrayList, this.f4304b));
    }

    @Override // com.bumptech.glide.load.a.u
    public boolean handles(Model model) {
        Iterator<u<Model, Data>> it = this.f4303a.iterator();
        while (it.hasNext()) {
            if (it.next().handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f4303a.toArray()) + '}';
    }

    /* JADX INFO: compiled from: MultiModelLoader.java */
    static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.bumptech.glide.load.data.d<Data>> f4305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.f.e<List<Throwable>> f4306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Priority f4308d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d.a<? super Data> f4309e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<Throwable> f4310f;
        private boolean g;

        a(List<com.bumptech.glide.load.data.d<Data>> list, androidx.core.f.e<List<Throwable>> eVar) {
            this.f4306b = eVar;
            com.bumptech.glide.e.l.a(list);
            this.f4305a = list;
            this.f4307c = 0;
        }

        private void d() {
            if (this.g) {
                return;
            }
            if (this.f4307c < this.f4305a.size() - 1) {
                this.f4307c++;
                a(this.f4308d, this.f4309e);
            } else {
                com.bumptech.glide.e.l.a(this.f4310f);
                this.f4309e.a((Exception) new GlideException("Fetch failed", new ArrayList(this.f4310f)));
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            this.f4308d = priority;
            this.f4309e = aVar;
            this.f4310f = this.f4306b.a();
            this.f4305a.get(this.f4307c).a(priority, this);
            if (this.g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> list = this.f4310f;
            if (list != null) {
                this.f4306b.a(list);
            }
            this.f4310f = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f4305a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource c() {
            return this.f4305a.get(0).c();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.g = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f4305a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f4305a.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(Data data) {
            if (data != null) {
                this.f4309e.a(data);
            } else {
                d();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(Exception exc) {
            List<Throwable> list = this.f4310f;
            com.bumptech.glide.e.l.a(list);
            list.add(exc);
            d();
        }
    }
}
