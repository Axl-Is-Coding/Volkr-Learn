package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A04' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EnumC14126v {
    public static byte[] A01;
    public static String[] A02;
    public static final /* synthetic */ EnumC14126v[] A03;
    public static final EnumC14126v A04;
    public static final EnumC14126v A05;
    public static final EnumC14126v A06;
    public String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[0].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "";
            strArr[1] = "";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 17);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{61, 52, 69, 81, 74, 67, 47, 51, 49, 42, 35, 79, 80, 87, 84, 36, Utf8.REPLACEMENT_BYTE, 54, 70, 25, 2, 11, 120, 127, 124};
    }

    public static void A02() {
        A02 = new String[]{"fU4XiUh", "4ASLCGhodwv3fY7yqE", "BFhkWaiQLcBXUQO4Yi7KFwSjCE1nMNEL", "IBfibZ8IWoONy44J9jH8jZ0p3ibNlB3T", "FmTm3wR2K52Lz7zbwKhVmki4cB", "JxTEYV1Vluo7DhPyeTARHiExSqxbiuYf", "t7Mb3YBBhyhswQ5hXIhgNczDQ93Q9bzO", "oX4F1jUgCDnefIZx9v8TRjWfCJBhCFOT"};
    }

    static {
        A02();
        A01();
        A06 = new EnumC14126v(A00(19, 6, 91), 0, A00(8, 7, 115));
        A05 = new EnumC14126v(A00(15, 4, 102), 1, A00(3, 5, 19));
        String strA00 = A00(0, 3, 97);
        A04 = new EnumC14126v(strA00, 2, strA00);
        A03 = new EnumC14126v[]{A06, A05, A04};
    }

    public EnumC14126v(String str, int i, String str2) {
        this.A00 = str2;
    }

    public final String A03() {
        return this.A00;
    }

    public static EnumC14126v valueOf(String str) {
        return (EnumC14126v) Enum.valueOf(EnumC14126v.class, str);
    }

    public static EnumC14126v[] values() {
        return (EnumC14126v[]) A03.clone();
    }
}
