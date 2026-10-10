package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: MemberAndArguments.java */
/* JADX INFO: loaded from: classes5.dex */
class P extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2871q f21555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f21556b;

    P(AbstractC2871q abstractC2871q, Object[] objArr) {
        this.f21555a = abstractC2871q;
        this.f21556b = objArr;
    }

    freemarker.template.E a(C2867m c2867m, Object obj) throws IllegalAccessException, TemplateModelException, InvocationTargetException {
        return this.f21555a.a(c2867m, obj, this.f21556b);
    }

    AbstractC2871q a() {
        return this.f21555a;
    }
}
