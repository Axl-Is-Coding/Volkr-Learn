package freemarker.template;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class SimpleNumber implements J, Serializable {
    private final Number value;

    public SimpleNumber(Number number) {
        this.value = number;
    }

    @Override // freemarker.template.J
    public Number getAsNumber() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }

    public SimpleNumber(byte b2) {
        this.value = new Byte(b2);
    }

    public SimpleNumber(short s) {
        this.value = new Short(s);
    }

    public SimpleNumber(int i) {
        this.value = new Integer(i);
    }

    public SimpleNumber(long j) {
        this.value = new Long(j);
    }

    public SimpleNumber(float f2) {
        this.value = new Float(f2);
    }

    public SimpleNumber(double d2) {
        this.value = new Double(d2);
    }
}
