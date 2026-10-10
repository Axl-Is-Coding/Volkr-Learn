package com.google.common.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* JADX INFO: compiled from: Invokable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T, R> extends com.google.common.reflect.a implements GenericDeclaration {

    /* JADX INFO: compiled from: Invokable.java */
    static class a<T> extends b<T, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Constructor<?> f13992c;

        a(Constructor<?> constructor) {
            super(constructor);
            this.f13992c = constructor;
        }

        private boolean c() {
            Class<?> declaringClass = this.f13992c.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            return declaringClass.getEnclosingMethod() != null ? !Modifier.isStatic(r1.getModifiers()) : (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        Type[] b() {
            Type[] genericParameterTypes = this.f13992c.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f13992c.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f13992c.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Invokable.java */
    static class C0133b<T> extends b<T, Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Method f13993c;

        C0133b(Method method) {
            super(method);
            this.f13993c = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f13993c.getTypeParameters();
        }
    }

    <M extends AccessibleObject & Member> b(M m) {
        super(m);
    }

    @Override // com.google.common.reflect.a
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.reflect.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    @Override // com.google.common.reflect.a
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.reflect.a
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
