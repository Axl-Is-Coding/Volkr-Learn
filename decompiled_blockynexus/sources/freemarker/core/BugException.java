package freemarker.core;

/* JADX INFO: loaded from: classes5.dex */
public class BugException extends RuntimeException {
    private static final String COMMON_MESSAGE = "A bug was detected in FreeMarker; please report it with stack-trace";

    public BugException() {
        this((Throwable) null);
    }

    public BugException(String str) {
        this(str, null);
    }

    public BugException(Throwable th) {
        super(COMMON_MESSAGE, th);
    }

    public BugException(String str, Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A bug was detected in FreeMarker; please report it with stack-trace: ");
        stringBuffer.append(str);
        super(stringBuffer.toString(), th);
    }

    public BugException(int i) {
        this(String.valueOf(i));
    }
}
