package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: HttpDate.java */
/* JADX INFO: loaded from: classes5.dex */
class c extends ThreadLocal<DateFormat> {
    c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public DateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(okhttp3.a.e.p);
        return simpleDateFormat;
    }
}
