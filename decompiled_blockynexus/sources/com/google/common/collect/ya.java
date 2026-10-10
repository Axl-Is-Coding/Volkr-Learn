package com.google.common.collect;

import com.google.common.collect.oa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Serialization.java */
/* JADX INFO: loaded from: classes2.dex */
final class ya {

    /* JADX INFO: compiled from: Serialization.java */
    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f13968a;

        void a(T t, Object obj) {
            try {
                this.f13968a.set(t, obj);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        private a(Field field) {
            this.f13968a = field;
            field.setAccessible(true);
        }

        void a(T t, int i) {
            try {
                this.f13968a.set(t, Integer.valueOf(i));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static int a(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    static <E> void a(oa<E> oaVar, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(oaVar.entrySet().size());
        for (oa.a<E> aVar : oaVar.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> void a(oa<E> oaVar, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            oaVar.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    static <K, V> void a(ha<K, V> haVar, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(haVar.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : haVar.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    static <T> a<T> a(Class<T> cls, String str) {
        try {
            return new a<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }
}
