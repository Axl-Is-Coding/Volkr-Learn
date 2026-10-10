package freemarker.ext.beans;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: DateModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class B extends C2860f implements freemarker.template.u {
    static final freemarker.ext.util.e g = new A();
    private final int h;

    public B(Date date, C2867m c2867m) {
        super(date, c2867m);
        if (date instanceof java.sql.Date) {
            this.h = 2;
            return;
        }
        if (date instanceof Time) {
            this.h = 1;
        } else if (date instanceof Timestamp) {
            this.h = 3;
        } else {
            this.h = c2867m.c();
        }
    }

    @Override // freemarker.template.u
    public Date b() {
        return (Date) this.f21587d;
    }
}
