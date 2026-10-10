package freemarker.template.utility;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: NumberUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BigDecimal f21746a = BigDecimal.valueOf(-2147483648L);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BigDecimal f21747b = BigDecimal.valueOf(2147483647L);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BigInteger f21748c = f21746a.toBigInteger();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BigInteger f21749d = f21747b.toBigInteger();

    public static boolean a(BigDecimal bigDecimal) {
        return bigDecimal.scale() <= 0 || bigDecimal.setScale(0, 1).compareTo(bigDecimal) == 0;
    }
}
