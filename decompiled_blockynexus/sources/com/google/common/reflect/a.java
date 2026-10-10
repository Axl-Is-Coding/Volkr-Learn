package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: Element.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends AccessibleObject implements Member {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AccessibleObject f13990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Member f13991b;

    <M extends AccessibleObject & Member> a(M m) {
        com.google.common.base.m.a(m);
        this.f13990a = m;
        this.f13991b = m;
    }

    public TypeToken<?> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.f13991b.equals(aVar.f13991b);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f13990a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f13990a.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f13990a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.f13991b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f13991b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f13991b.getName();
    }

    public int hashCode() {
        return this.f13991b.hashCode();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.f13990a.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f13990a.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f13991b.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z) throws SecurityException {
        this.f13990a.setAccessible(z);
    }

    public String toString() {
        return this.f13991b.toString();
    }
}
