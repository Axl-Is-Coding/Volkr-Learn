package com.google.common.collect;

import cn.qqtheme.framework.util.ConvertUtils;
import com.google.common.base.Predicates;
import java.util.Collection;

/* JADX INFO: renamed from: com.google.common.collect.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Collections2.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2261p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final com.google.common.base.h f13960a = com.google.common.base.h.a(", ").b("null");

    static boolean a(Collection<?> collection, Object obj) {
        com.google.common.base.m.a(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static boolean a(Collection<?> collection, Collection<?> collection2) {
        return L.a((Iterable) collection2, Predicates.a((Collection) collection));
    }

    static String a(Collection<?> collection) {
        StringBuilder sbA = a(collection.size());
        sbA.append('[');
        f13960a.a(sbA, L.a((Iterable) collection, (com.google.common.base.f) new C2260o(collection)));
        sbA.append(']');
        return sbA.toString();
    }

    static StringBuilder a(int i) {
        C2259n.a(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, ConvertUtils.GB));
    }

    static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
