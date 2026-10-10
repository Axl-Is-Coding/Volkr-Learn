package com.google.gson.internal;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Excluder implements com.google.gson.y, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Excluder f14102a = new Excluder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14106e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f14103b = -1.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14104c = 136;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14105d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.google.gson.b> f14107f = Collections.emptyList();
    private List<com.google.gson.b> g = Collections.emptyList();

    private boolean b(Class<?> cls, boolean z) {
        Iterator<com.google.gson.b> it = (z ? this.f14107f : this.g).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    @Override // com.google.gson.y
    public <T> com.google.gson.x<T> a(com.google.gson.j jVar, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zA = a(rawType);
        boolean z = zA || b(rawType, true);
        boolean z2 = zA || b(rawType, false);
        if (z || z2) {
            return new q(this, z2, z, jVar, typeToken);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m62clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.f14104c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f14103b != -1.0d && !a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f14106e && ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f14105d && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<com.google.gson.b> list = z ? this.f14107f : this.g;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.c cVar = new com.google.gson.c(field);
        Iterator<com.google.gson.b> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(cVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        if (this.f14103b == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.f14105d && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.value() <= this.f14103b;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.value() > this.f14103b;
    }
}
