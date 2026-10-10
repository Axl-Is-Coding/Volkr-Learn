package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonNodeException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateNodeModel;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateNodeModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateNodeModel");
            class$freemarker$template$TemplateNodeModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonNodeException(Environment environment) {
        super(environment, "Expecting node value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonNodeException(String str, Environment environment) {
        super(environment, str);
    }

    NonNodeException(Environment environment, kc kcVar) {
        super(environment, kcVar);
    }

    NonNodeException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "node", EXPECTED_TYPES, environment);
    }

    NonNodeException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "node", EXPECTED_TYPES, str, environment);
    }

    NonNodeException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "node", EXPECTED_TYPES, strArr, environment);
    }
}
