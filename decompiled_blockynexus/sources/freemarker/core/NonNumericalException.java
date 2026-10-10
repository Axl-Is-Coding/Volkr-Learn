package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonNumericalException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateNumberModel;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateNumberModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateNumberModel");
            class$freemarker$template$TemplateNumberModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonNumericalException(Environment environment) {
        super(environment, "Expecting numerical value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static NonNumericalException newMalformedNumberException(Hb hb, String str, Environment environment) {
        kc kcVar = new kc(new Object[]{"Can't convert this string to number: ", new gc(str)});
        kcVar.a(hb);
        return new NonNumericalException(kcVar, environment);
    }

    public NonNumericalException(String str, Environment environment) {
        super(environment, str);
    }

    NonNumericalException(kc kcVar, Environment environment) {
        super(environment, kcVar);
    }

    NonNumericalException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "number", EXPECTED_TYPES, environment);
    }

    NonNumericalException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "number", EXPECTED_TYPES, str, environment);
    }

    NonNumericalException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "number", EXPECTED_TYPES, strArr, environment);
    }

    NonNumericalException(String str, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(str, e2, "number", EXPECTED_TYPES, strArr, environment);
    }
}
