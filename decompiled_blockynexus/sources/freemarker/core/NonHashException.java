package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonHashException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateHashModel;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateHashModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateHashModel");
            class$freemarker$template$TemplateHashModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonHashException(Environment environment) {
        super(environment, "Expecting hash value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonHashException(String str, Environment environment) {
        super(environment, str);
    }

    NonHashException(Environment environment, kc kcVar) {
        super(environment, kcVar);
    }

    NonHashException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "hash", EXPECTED_TYPES, environment);
    }

    NonHashException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "hash", EXPECTED_TYPES, str, environment);
    }

    NonHashException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "hash", EXPECTED_TYPES, strArr, environment);
    }
}
