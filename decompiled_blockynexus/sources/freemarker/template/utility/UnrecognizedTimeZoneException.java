package freemarker.template.utility;

/* JADX INFO: loaded from: classes5.dex */
public class UnrecognizedTimeZoneException extends Exception {
    private final String timeZoneName;

    public UnrecognizedTimeZoneException(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized time zone: ");
        stringBuffer.append(h.e(str));
        super(stringBuffer.toString());
        this.timeZoneName = str;
    }

    public String getTimeZoneName() {
        return this.timeZoneName;
    }
}
