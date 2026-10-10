package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: DataRewinderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e.a<?> f4378a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f4379b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DataRewinderRegistry.java */
    static final class a implements e<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f4380a;

        a(Object obj) {
            this.f4380a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        public Object a() {
            return this.f4380a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void b() {
        }
    }

    public synchronized void a(e.a<?> aVar) {
        this.f4379b.put(aVar.a(), aVar);
    }

    public synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        com.bumptech.glide.e.l.a(t);
        aVar = this.f4379b.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f4379b.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f4378a;
        }
        return (e<T>) aVar.a(t);
    }
}
