package freemarker.core;

/* JADX INFO: compiled from: _DelayedOrdinal.java */
/* JADX INFO: loaded from: classes5.dex */
public class hc extends ec {
    public hc(Object obj) {
        super(obj);
    }

    @Override // freemarker.core.ec
    protected String a(Object obj) {
        if (!(obj instanceof Number)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("");
            stringBuffer.append(obj);
            return stringBuffer.toString();
        }
        long jLongValue = ((Number) obj).longValue();
        long j = jLongValue % 10;
        if (j == 1 && jLongValue % 100 != 11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(jLongValue);
            stringBuffer2.append("st");
            return stringBuffer2.toString();
        }
        if (j == 2 && jLongValue % 100 != 12) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(jLongValue);
            stringBuffer3.append("nd");
            return stringBuffer3.toString();
        }
        if (j != 3 || jLongValue % 100 == 13) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(jLongValue);
            stringBuffer4.append("th");
            return stringBuffer4.toString();
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append(jLongValue);
        stringBuffer5.append("rd");
        return stringBuffer5.toString();
    }
}
