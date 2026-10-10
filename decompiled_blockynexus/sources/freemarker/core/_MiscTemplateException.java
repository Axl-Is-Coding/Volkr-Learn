package freemarker.core;

import freemarker.template.TemplateException;

/* JADX INFO: loaded from: classes5.dex */
public class _MiscTemplateException extends TemplateException {
    public _MiscTemplateException(String str) {
        super(str, (Environment) null);
    }

    public _MiscTemplateException(Environment environment, String str) {
        super(str, environment);
    }

    public _MiscTemplateException(Throwable th, String str) {
        this(th, (Environment) null, str);
    }

    public _MiscTemplateException(Throwable th, Environment environment) {
        this(th, environment, (String) null);
    }

    public _MiscTemplateException(Throwable th) {
        this(th, (Environment) null, (String) null);
    }

    public _MiscTemplateException(Throwable th, Environment environment, String str) {
        super(str, th, environment);
    }

    public _MiscTemplateException(kc kcVar) {
        this((Environment) null, kcVar);
    }

    public _MiscTemplateException(Environment environment, kc kcVar) {
        this((Throwable) null, environment, kcVar);
    }

    public _MiscTemplateException(Throwable th, Environment environment, kc kcVar) {
        super(th, environment, null, kcVar);
    }

    public _MiscTemplateException(Object[] objArr) {
        this((Environment) null, objArr);
    }

    public _MiscTemplateException(Environment environment, Object[] objArr) {
        this((Throwable) null, environment, objArr);
    }

    public _MiscTemplateException(Throwable th, Object[] objArr) {
        this(th, (Environment) null, objArr);
    }

    public _MiscTemplateException(Throwable th, Environment environment, Object[] objArr) {
        super(th, environment, null, new kc(objArr));
    }

    public _MiscTemplateException(Hb hb, Object[] objArr) {
        this(hb, (Environment) null, objArr);
    }

    public _MiscTemplateException(Hb hb, Environment environment, Object[] objArr) {
        this(hb, (Throwable) null, environment, objArr);
    }

    public _MiscTemplateException(Hb hb, Throwable th, Environment environment, Object[] objArr) {
        kc kcVar = new kc(objArr);
        kcVar.a(hb);
        super(th, environment, hb, kcVar);
    }

    public _MiscTemplateException(Hb hb, String str) {
        this(hb, (Environment) null, str);
    }

    public _MiscTemplateException(Hb hb, Environment environment, String str) {
        this(hb, (Throwable) null, environment, str);
    }

    public _MiscTemplateException(Hb hb, Throwable th, Environment environment, String str) {
        kc kcVar = new kc(str);
        kcVar.a(hb);
        super(th, environment, hb, kcVar);
    }
}
