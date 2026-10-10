package com.bumptech.glide.c;

import com.bumptech.glide.load.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ResourceDecoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f4128a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f4129b = new HashMap();

    /* JADX INFO: compiled from: ResourceDecoderRegistry.java */
    private static class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f4130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<R> f4131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final m<T, R> f4132c;

        public a(Class<T> cls, Class<R> cls2, m<T, R> mVar) {
            this.f4130a = cls;
            this.f4131b = cls2;
            this.f4132c = mVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f4130a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4131b);
        }
    }

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f4128a);
        this.f4128a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f4128a.add(it.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f4128a.add(str);
            }
        }
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f4128a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f4129b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f4131b)) {
                        arrayList.add(aVar.f4131b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<m<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f4128a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f4129b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f4132c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, m<T, R> mVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, mVar));
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> arrayList;
        if (!this.f4128a.contains(str)) {
            this.f4128a.add(str);
        }
        arrayList = this.f4129b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f4129b.put(str, arrayList);
        }
        return arrayList;
    }
}
