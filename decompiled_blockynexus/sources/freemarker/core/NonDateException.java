package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonDateException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateDateModel;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateDateModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateDateModel");
            class$freemarker$template$TemplateDateModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonDateException(Environment environment) {
        super(environment, "Expecting date/time value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonDateException(String str, Environment environment) {
        super(environment, str);
    }

    NonDateException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "date/time", EXPECTED_TYPES, environment);
    }

    NonDateException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "date/time", EXPECTED_TYPES, str, environment);
    }

    NonDateException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "date/time", EXPECTED_TYPES, strArr, environment);
    }
}
