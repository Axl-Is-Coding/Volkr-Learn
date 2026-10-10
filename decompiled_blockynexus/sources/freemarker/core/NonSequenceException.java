package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonSequenceException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateSequenceModel;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateSequenceModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateSequenceModel");
            class$freemarker$template$TemplateSequenceModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonSequenceException(Environment environment) {
        super(environment, "Expecting sequence value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonSequenceException(String str, Environment environment) {
        super(environment, str);
    }

    NonSequenceException(Environment environment, kc kcVar) {
        super(environment, kcVar);
    }

    NonSequenceException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "sequence", EXPECTED_TYPES, environment);
    }

    NonSequenceException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "sequence", EXPECTED_TYPES, str, environment);
    }

    NonSequenceException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "sequence", EXPECTED_TYPES, strArr, environment);
    }
}
