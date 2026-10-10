package freemarker.core;

import freemarker.template.TemplateModelException;

/* JADX INFO: loaded from: classes5.dex */
public class _TemplateModelException extends TemplateModelException {
    public _TemplateModelException(String str) {
        super(str);
    }

    static Object[] modelHasStoredNullDescription(Class cls, freemarker.template.E e2) {
        return new Object[]{"The FreeMarker value exists, but has nothing inside it; the TemplateModel object (class: ", e2.getClass().getName(), ") has returned a null instead of a ", freemarker.template.utility.a.a(cls), ". ", "This is possibly a bug in the non-FreeMarker code that builds the data-model."};
    }

    public _TemplateModelException(Throwable th, String str) {
        this(th, (Environment) null, str);
    }

    public _TemplateModelException(Environment environment, String str) {
        this((Throwable) null, environment, str);
    }

    public _TemplateModelException(Throwable th, Environment environment) {
        this(th, environment, (String) null);
    }

    public _TemplateModelException(Throwable th) {
        this(th, (Environment) null, (String) null);
    }

    public _TemplateModelException(Throwable th, Environment environment, String str) {
        super(th, environment, str, true);
    }

    public _TemplateModelException(kc kcVar) {
        this((Environment) null, kcVar);
    }

    public _TemplateModelException(Environment environment, kc kcVar) {
        this((Throwable) null, environment, kcVar);
    }

    public _TemplateModelException(Throwable th, Environment environment, kc kcVar) {
        super(th, environment, kcVar, true);
    }

    public _TemplateModelException(Object[] objArr) {
        this((Environment) null, objArr);
    }

    public _TemplateModelException(Environment environment, Object[] objArr) {
        this((Throwable) null, environment, objArr);
    }

    public _TemplateModelException(Throwable th, Object[] objArr) {
        this(th, (Environment) null, objArr);
    }

    public _TemplateModelException(Throwable th, Environment environment, Object[] objArr) {
        super(th, environment, new kc(objArr), true);
    }

    public _TemplateModelException(Hb hb, Object[] objArr) {
        this(hb, (Environment) null, objArr);
    }

    public _TemplateModelException(Hb hb, Environment environment, Object[] objArr) {
        this(hb, (Throwable) null, environment, objArr);
    }

    public _TemplateModelException(Hb hb, Throwable th, Environment environment, Object[] objArr) {
        kc kcVar = new kc(objArr);
        kcVar.a(hb);
        super(th, environment, kcVar, true);
    }

    public _TemplateModelException(Hb hb, String str) {
        this(hb, (Environment) null, str);
    }

    public _TemplateModelException(Hb hb, Environment environment, String str) {
        this(hb, (Throwable) null, environment, str);
    }

    public _TemplateModelException(Hb hb, Throwable th, Environment environment, String str) {
        kc kcVar = new kc(str);
        kcVar.a(hb);
        super(th, environment, kcVar, true);
    }
}
