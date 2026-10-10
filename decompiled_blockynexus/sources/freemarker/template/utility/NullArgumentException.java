package freemarker.template.utility;

/* JADX INFO: loaded from: classes5.dex */
public class NullArgumentException extends IllegalArgumentException {
    public NullArgumentException(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The \"");
        stringBuffer.append(str);
        stringBuffer.append("\" argument can't be null");
        super(stringBuffer.toString());
    }

    public static void check(String str, Object obj) {
        if (obj == null) {
            throw new NullArgumentException(str);
        }
    }

    public static void check(Object obj) {
        if (obj == null) {
            throw new NullArgumentException("Argument can't be null");
        }
    }
}
