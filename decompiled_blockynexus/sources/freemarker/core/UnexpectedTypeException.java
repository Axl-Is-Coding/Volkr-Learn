package freemarker.core;

import com.alibaba.android.arouter.utils.Consts;
import freemarker.template.TemplateException;

/* JADX INFO: loaded from: classes5.dex */
public class UnexpectedTypeException extends TemplateException {
    public UnexpectedTypeException(Environment environment, String str) {
        super(str, environment);
    }

    private static kc newDesciptionBuilder(Hb hb, String str, freemarker.template.E e2, String str2, Class[] clsArr, Environment environment) throws InvalidReferenceException {
        Object[] objArrExplainTypeError;
        if (e2 == null) {
            throw InvalidReferenceException.getInstance(hb, environment);
        }
        kc kcVar = new kc(unexpectedTypeErrorDescription(str2, hb, str, e2));
        kcVar.a(hb);
        kcVar.a(true);
        if ((e2 instanceof lc) && (objArrExplainTypeError = ((lc) e2).explainTypeError(clsArr)) != null) {
            kcVar.a(objArrExplainTypeError);
        }
        return kcVar;
    }

    private static Object[] unexpectedTypeErrorDescription(String str, Hb hb, String str2, freemarker.template.E e2) {
        Object[] objArr = new Object[7];
        objArr[0] = "Expected ";
        objArr[1] = new dc(str);
        objArr[2] = ", but ";
        objArr[3] = str2 == null ? hb != null ? "this" : "the expression" : new Object[]{"assignment target variable ", new gc(str2)};
        objArr[4] = " has evaluated to ";
        objArr[5] = new dc(new fc(e2));
        objArr[6] = str2 == null ? ":" : Consts.DOT;
        return objArr;
    }

    UnexpectedTypeException(Environment environment, kc kcVar) {
        super(null, environment, null, kcVar);
    }

    UnexpectedTypeException(Hb hb, freemarker.template.E e2, String str, Class[] clsArr, Environment environment) throws InvalidReferenceException {
        super(null, environment, hb, newDesciptionBuilder(hb, null, e2, str, clsArr, environment));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    UnexpectedTypeException(Hb hb, freemarker.template.E e2, String str, Class[] clsArr, String str2, Environment environment) throws InvalidReferenceException {
        kc kcVarNewDesciptionBuilder = newDesciptionBuilder(hb, null, e2, str, clsArr, environment);
        kcVarNewDesciptionBuilder.a(str2);
        super(null, environment, hb, kcVarNewDesciptionBuilder);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    UnexpectedTypeException(Hb hb, freemarker.template.E e2, String str, Class[] clsArr, String[] strArr, Environment environment) throws InvalidReferenceException {
        kc kcVarNewDesciptionBuilder = newDesciptionBuilder(hb, null, e2, str, clsArr, environment);
        kcVarNewDesciptionBuilder.b((Object[]) strArr);
        super(null, environment, hb, kcVarNewDesciptionBuilder);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    UnexpectedTypeException(String str, freemarker.template.E e2, String str2, Class[] clsArr, String[] strArr, Environment environment) throws InvalidReferenceException {
        kc kcVarNewDesciptionBuilder = newDesciptionBuilder(null, str, e2, str2, clsArr, environment);
        kcVarNewDesciptionBuilder.b((Object[]) strArr);
        super(null, environment, null, kcVarNewDesciptionBuilder);
    }
}
