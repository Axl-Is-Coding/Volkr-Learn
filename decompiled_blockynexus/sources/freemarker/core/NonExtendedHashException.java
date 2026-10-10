package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonExtendedHashException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateHashModelEx;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateHashModelEx;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateHashModelEx");
            class$freemarker$template$TemplateHashModelEx = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonExtendedHashException(Environment environment) {
        super(environment, "Expecting extended hash value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonExtendedHashException(String str, Environment environment) {
        super(environment, str);
    }

    NonExtendedHashException(Environment environment, kc kcVar) {
        super(environment, kcVar);
    }

    NonExtendedHashException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "extended hash", EXPECTED_TYPES, environment);
    }

    NonExtendedHashException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "extended hash", EXPECTED_TYPES, str, environment);
    }

    NonExtendedHashException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "extended hash", EXPECTED_TYPES, strArr, environment);
    }
}
