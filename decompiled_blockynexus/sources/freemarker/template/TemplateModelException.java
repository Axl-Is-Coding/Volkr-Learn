package freemarker.template;

import freemarker.core.Environment;
import freemarker.core.kc;

/* JADX INFO: loaded from: classes5.dex */
public class TemplateModelException extends TemplateException {
    public TemplateModelException() {
        this((String) null, (Exception) null);
    }

    public TemplateModelException(String str) {
        this(str, (Exception) null);
    }

    public TemplateModelException(Exception exc) {
        this((String) null, exc);
    }

    public TemplateModelException(Throwable th) {
        this((String) null, th);
    }

    public TemplateModelException(String str, Exception exc) {
        super(str, exc, (Environment) null);
    }

    public TemplateModelException(String str, Throwable th) {
        super(str, th, (Environment) null);
    }

    protected TemplateModelException(Throwable th, Environment environment, String str, boolean z) {
        super(str, th, environment);
    }

    protected TemplateModelException(Throwable th, Environment environment, kc kcVar, boolean z) {
        super(th, environment, null, kcVar);
    }
}
