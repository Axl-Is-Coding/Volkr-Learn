package freemarker.core;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes5.dex */
public class NonMethodException extends UnexpectedTypeException {
    private static final Class[] EXPECTED_TYPES;
    static /* synthetic */ Class class$freemarker$template$TemplateMethodModel;

    static {
        Class[] clsArr = new Class[1];
        Class clsClass$ = class$freemarker$template$TemplateMethodModel;
        if (clsClass$ == null) {
            clsClass$ = class$("freemarker.template.TemplateMethodModel");
            class$freemarker$template$TemplateMethodModel = clsClass$;
        }
        clsArr[0] = clsClass$;
        EXPECTED_TYPES = clsArr;
    }

    public NonMethodException(Environment environment) {
        super(environment, "Expecting method value here");
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public NonMethodException(String str, Environment environment) {
        super(environment, str);
    }

    NonMethodException(Environment environment, kc kcVar) {
        super(environment, kcVar);
    }

    NonMethodException(Hb hb, freemarker.template.E e2, Environment environment) throws InvalidReferenceException {
        super(hb, e2, FirebaseAnalytics.Param.METHOD, EXPECTED_TYPES, environment);
    }

    NonMethodException(Hb hb, freemarker.template.E e2, String str, Environment environment) throws InvalidReferenceException {
        super(hb, e2, FirebaseAnalytics.Param.METHOD, EXPECTED_TYPES, str, environment);
    }

    NonMethodException(Hb hb, freemarker.template.E e2, String[] strArr, Environment environment) throws InvalidReferenceException {
        super(hb, e2, FirebaseAnalytics.Param.METHOD, EXPECTED_TYPES, strArr, environment);
    }
}
