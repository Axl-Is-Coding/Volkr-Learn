package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonBooleanException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateBooleanModel;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateBooleanModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateBooleanModel");
            class$freemarker$template$TemplateBooleanModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonBooleanException(Environment environment) {
        super(environment, "Expecting boolean value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonBooleanException(String str, Environment environment) {
        super(environment, str);
    }

    NonBooleanException(Environment environment, kc kcVar) {
        super(environment, kcVar);
    }

    NonBooleanException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "boolean", EXPECTED_TYPES, environment);
    }

    NonBooleanException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "boolean", EXPECTED_TYPES, str, environment);
    }

    NonBooleanException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "boolean", EXPECTED_TYPES, strArr, environment);
    }
}
