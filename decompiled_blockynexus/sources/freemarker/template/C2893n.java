package freemarker.template;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: renamed from: freemarker.template.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SimpleDate.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2893n implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Date f21732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21733b;

    public C2893n(java.sql.Date date) {
        this(date, 2);
    }

    @Override // freemarker.template.u
    public Date b() {
        return this.f21732a;
    }

    public String toString() {
        return this.f21732a.toString();
    }

    public C2893n(Time time) {
        this(time, 1);
    }

    public C2893n(Timestamp timestamp) {
        this(timestamp, 3);
    }

    public C2893n(Date date, int i) {
        if (date != null) {
            this.f21732a = date;
            this.f21733b = i;
            return;
        }
        throw new IllegalArgumentException("date == null");
    }
}
