package freemarker.core;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: classes5.dex */
public class _ObjectBuilderSettingEvaluationException extends Exception {
    public _ObjectBuilderSettingEvaluationException(String str, Throwable th) {
        super(str, th);
    }

    public _ObjectBuilderSettingEvaluationException(String str) {
        super(str);
    }

    public _ObjectBuilderSettingEvaluationException(String str, String str2, int i) {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Expression syntax error: Expected a(n) ");
        stringBuffer.append(str);
        stringBuffer.append(", but ");
        if (i < str2.length()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("found character ");
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("");
            stringBuffer3.append(str2.charAt(i));
            stringBuffer2.append(freemarker.template.utility.h.e(stringBuffer3.toString()));
            stringBuffer2.append(" at position ");
            stringBuffer2.append(i + 1);
            stringBuffer2.append(Consts.DOT);
            string = stringBuffer2.toString();
        } else {
            string = "the end of the parsed string was reached.";
        }
        stringBuffer.append(string);
        super(stringBuffer.toString());
    }
}
