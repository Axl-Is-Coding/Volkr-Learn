package freemarker.core;

/* JADX INFO: compiled from: _DelayedAOrAn.java */
/* JADX INFO: loaded from: classes5.dex */
public class dc extends ec {
    public dc(Object obj) {
        super(obj);
    }

    @Override // freemarker.core.ec
    protected String a(Object obj) {
        String string = obj.toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Ob.a(string));
        stringBuffer.append(" ");
        stringBuffer.append(string);
        return stringBuffer.toString();
    }
}
