package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ReflectionCallableMemberDescriptor.java */
/* JADX INFO: loaded from: classes5.dex */
final class fa extends AbstractC2871q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Member f21590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Class[] f21591b;

    fa(Method method, Class[] clsArr) {
        this.f21590a = method;
        this.f21591b = clsArr;
    }

    @Override // freemarker.ext.beans.AbstractC2871q
    freemarker.template.E a(C2867m c2867m, Object obj, Object[] objArr) throws IllegalAccessException, TemplateModelException, InvocationTargetException {
        return c2867m.a(obj, (Method) this.f21590a, objArr);
    }

    @Override // freemarker.ext.beans.AbstractC2871q
    Class[] b() {
        return this.f21591b;
    }

    @Override // freemarker.ext.beans.AbstractC2871q
    boolean c() {
        return this.f21590a instanceof Constructor;
    }

    @Override // freemarker.ext.beans.AbstractC2871q
    boolean d() {
        return (this.f21590a.getModifiers() & 8) != 0;
    }

    boolean e() {
        return xa.c(this.f21590a);
    }

    @Override // freemarker.ext.beans.AbstractC2871q
    String a() {
        return xa.d(this.f21590a);
    }

    fa(Constructor constructor, Class[] clsArr) {
        this.f21590a = constructor;
        this.f21591b = clsArr;
    }
}
