package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class NonSequenceOrCollectionException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateCollectionModel;
    static /* synthetic */ Class class$freemarker$template$TemplateSequenceModel;

    static {
        Class[] clsArr = new Class[2];
        Class clsClass$ = class$freemarker$template$TemplateSequenceModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateSequenceModel");
            class$freemarker$template$TemplateSequenceModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        Class clsClass$2 = class$freemarker$template$TemplateCollectionModel;
        if (clsClass$2 == null) {
            clsClass$2 = class$("freemarker.template.TemplateCollectionModel");
            class$freemarker$template$TemplateCollectionModel = clsClass$2;
        }
        clsArr[1] = clsClass$2;
        EXPECTED_TYPES = clsArr;
    }

    public NonSequenceOrCollectionException(Environment environment) {
        super(environment, "Expecting sequence or collection value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonSequenceOrCollectionException(String str, Environment environment) {
        super(environment, str);
    }

    NonSequenceOrCollectionException(Environment environment, kc kcVar) {
        super(environment, kcVar);
    }

    NonSequenceOrCollectionException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "sequence or collection", EXPECTED_TYPES, environment);
    }

    NonSequenceOrCollectionException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "sequence or collection", EXPECTED_TYPES, str, environment);
    }

    NonSequenceOrCollectionException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, "sequence or collection", EXPECTED_TYPES, strArr, environment);
    }
}
