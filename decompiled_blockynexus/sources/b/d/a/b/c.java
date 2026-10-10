package b.d.a.b;

import java.util.Date;

/* JADX INFO: compiled from: DateHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static Date a(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    public static long a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
