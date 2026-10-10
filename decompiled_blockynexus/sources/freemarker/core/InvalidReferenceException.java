package freemarker.core;

import com.tendcloud.tenddata.cp;
import freemarker.template.TemplateException;

/* JADX INFO: loaded from: classes5.dex */
public class InvalidReferenceException extends TemplateException {
    static final InvalidReferenceException FAST_INSTANCE;
    private static final String[] TIP;
    private static final String TIP_JSP_TAGLIBS = "The \"JspTaglibs\" variable isn't a core FreeMarker feature; it's only available when templates are invoked through freemarker.ext.servlet.FreemarkerServlet (or other custom FreeMarker-JSP integration solution).";
    private static final String TIP_LAST_STEP_DOT = "It's the step after the last dot that caused this error, not those before it.";
    private static final String TIP_LAST_STEP_SQUARE_BRACKET = "It's the final [] step that caused this error, not those before it.";
    private static final String[] TIP_MISSING_ASSIGNMENT_TARGET;
    private static final String TIP_NO_DOLLAR = "Variable references must not start with \"$\", unless the \"$\" is really part of the variable name.";

    static {
        Environment environmentD = Environment.d();
        try {
            Environment.a((Environment) null);
            FAST_INSTANCE = new InvalidReferenceException("Invalid reference. Details are unavilable, as this should have been handled by an FTL construct. If it wasn't, that's problably a bug in FreeMarker.", null);
            Environment.a(environmentD);
            TIP = new String[]{"If the failing expression is known to be legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, or use ", "<#if myOptionalVar??>", "when-present", "<#else>", "when-missing", "</#if>", ". (These only cover the last step of the expression; to cover the whole expression, use parenthesis: (myOptionalVar.foo)!myDefault, (myOptionalVar.foo)??"};
            TIP_MISSING_ASSIGNMENT_TARGET = new String[]{"If the target variable is known to be legally null or missing sometimes, instead of something like ", "<#assign x += 1>", ", you could write ", "<#if x??>", "<#assign x += 1>", "</#if>", " or ", "<#assign x = (x!0) + 1>"};
        } catch (Throwable th) {
            Environment.a(environmentD);
            throw th;
        }
    }

    public InvalidReferenceException(Environment environment) {
        super("Invalid reference: The expression has evaluated to null or refers to something that doesn't exist.", environment);
    }

    private static boolean endsWithDollarVariable(Hb hb) {
        return ((hb instanceof Kb) && ((Kb) hb).m().startsWith("$")) || ((hb instanceof C2851yb) && ((C2851yb) hb).m().startsWith("$"));
    }

    static InvalidReferenceException getInstance(Hb hb, Environment environment) {
        if (environment != null && environment.f()) {
            return FAST_INSTANCE;
        }
        if (hb == null) {
            return new InvalidReferenceException(environment);
        }
        kc kcVar = new kc("The following has evaluated to null or missing:");
        kcVar.a(hb);
        if (endsWithDollarVariable(hb)) {
            kcVar.b(new Object[]{TIP_NO_DOLLAR, TIP});
        } else if (hb instanceof C2851yb) {
            String strM = ((C2851yb) hb).m();
            String str = null;
            if ("size".equals(strM)) {
                str = "To query the size of a collection or map use ?size, like myList?size";
            } else if (cp.a.LENGTH.equals(strM)) {
                str = "To query the length of a string use ?length, like myString?size";
            }
            kcVar.b(str == null ? new Object[]{TIP_LAST_STEP_DOT, TIP} : new Object[]{TIP_LAST_STEP_DOT, str, TIP});
        } else if ((hb instanceof Kb) && ((Kb) hb).m().equals("JspTaglibs")) {
            kcVar.b(new Object[]{TIP_JSP_TAGLIBS, TIP});
        } else {
            kcVar.a((Object[]) TIP);
        }
        return new InvalidReferenceException(kcVar, environment, hb);
    }

    public InvalidReferenceException(String str, Environment environment) {
        super(str, environment);
    }

    InvalidReferenceException(kc kcVar, Environment environment, Hb hb) {
        super(null, environment, hb, kcVar);
    }

    static InvalidReferenceException getInstance(String str, String str2, Environment environment) {
        if (environment != null && environment.f()) {
            return FAST_INSTANCE;
        }
        kc kcVar = new kc(new Object[]{"The target variable of the assignment, ", new gc(str), ", was null or missing, but the \"", str2, "\" operator needs to get its value before assigning to it."});
        if (str.startsWith("$")) {
            kcVar.b(new Object[]{TIP_NO_DOLLAR, TIP_MISSING_ASSIGNMENT_TARGET});
        } else {
            kcVar.a((Object[]) TIP_MISSING_ASSIGNMENT_TARGET);
        }
        return new InvalidReferenceException(kcVar, environment, null);
    }
}
