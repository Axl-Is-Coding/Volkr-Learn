package freemarker.ext.beans;

import com.google.firebase.FirebaseError;
import com.sandboxol.common.config.HttpCode;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
class OverloadedNumberUtil {
    static /* synthetic */ Class A;
    static /* synthetic */ Class B;
    static /* synthetic */ Class C;
    static /* synthetic */ Class D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static /* synthetic */ Class f21549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21554f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    static /* synthetic */ Class i;
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;
    static /* synthetic */ Class l;
    static /* synthetic */ Class m;
    static /* synthetic */ Class n;
    static /* synthetic */ Class o;
    static /* synthetic */ Class p;
    static /* synthetic */ Class q;
    static /* synthetic */ Class r;
    static /* synthetic */ Class s;
    static /* synthetic */ Class t;
    static /* synthetic */ Class u;
    static /* synthetic */ Class v;
    static /* synthetic */ Class w;
    static /* synthetic */ Class x;
    static /* synthetic */ Class y;
    static /* synthetic */ Class z;

    static final class BigIntegerOrByte extends BigIntegerOrPrimitive {
        BigIntegerOrByte(BigInteger bigInteger) {
            super(bigInteger);
        }
    }

    static final class BigIntegerOrDouble extends BigIntegerOrFPPrimitive {
        BigIntegerOrDouble(BigInteger bigInteger) {
            super(bigInteger);
        }
    }

    static abstract class BigIntegerOrFPPrimitive extends BigIntegerOrPrimitive {
        BigIntegerOrFPPrimitive(BigInteger bigInteger) {
            super(bigInteger);
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public double doubleValue() {
            return this.n.longValue();
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public float floatValue() {
            return this.n.longValue();
        }
    }

    static final class BigIntegerOrFloat extends BigIntegerOrFPPrimitive {
        BigIntegerOrFloat(BigInteger bigInteger) {
            super(bigInteger);
        }
    }

    static final class BigIntegerOrInteger extends BigIntegerOrPrimitive {
        BigIntegerOrInteger(BigInteger bigInteger) {
            super(bigInteger);
        }
    }

    static final class BigIntegerOrLong extends BigIntegerOrPrimitive {
        BigIntegerOrLong(BigInteger bigInteger) {
            super(bigInteger);
        }
    }

    static abstract class BigIntegerOrPrimitive extends NumberWithFallbackType {
        protected final BigInteger n;

        BigIntegerOrPrimitive(BigInteger bigInteger) {
            this.n = bigInteger;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }
    }

    static final class BigIntegerOrShort extends BigIntegerOrPrimitive {
        BigIntegerOrShort(BigInteger bigInteger) {
            super(bigInteger);
        }
    }

    static final class DoubleOrByte extends DoubleOrWholeNumber {
        private final byte w;

        DoubleOrByte(Double d2, byte b2) {
            super(d2);
            this.w = b2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public byte byteValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public short shortValue() {
            return this.w;
        }
    }

    static final class DoubleOrFloat extends NumberWithFallbackType {
        private final Double n;

        DoubleOrFloat(Double d2) {
            this.n = d2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public double doubleValue() {
            return this.n.doubleValue();
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public float floatValue() {
            return this.n.floatValue();
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }
    }

    static final class DoubleOrInteger extends DoubleOrWholeNumber {
        private final int w;

        DoubleOrInteger(Double d2, int i) {
            super(d2);
            this.w = i;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }
    }

    static final class DoubleOrIntegerOrFloat extends DoubleOrWholeNumber {
        private final int w;

        DoubleOrIntegerOrFloat(Double d2, int i) {
            super(d2);
            this.w = i;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }
    }

    static final class DoubleOrLong extends DoubleOrWholeNumber {
        private final long w;

        DoubleOrLong(Double d2, long j) {
            super(d2);
            this.w = j;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }
    }

    static final class DoubleOrShort extends DoubleOrWholeNumber {
        private final short w;

        DoubleOrShort(Double d2, short s) {
            super(d2);
            this.w = s;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public short shortValue() {
            return this.w;
        }
    }

    static abstract class DoubleOrWholeNumber extends NumberWithFallbackType {
        private final Double n;

        protected DoubleOrWholeNumber(Double d2) {
            this.n = d2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public double doubleValue() {
            return this.n.doubleValue();
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }
    }

    static final class FloatOrByte extends FloatOrWholeNumber {
        private final byte w;

        FloatOrByte(Float f2, byte b2) {
            super(f2);
            this.w = b2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public byte byteValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public short shortValue() {
            return this.w;
        }
    }

    static final class FloatOrInteger extends FloatOrWholeNumber {
        private final int w;

        FloatOrInteger(Float f2, int i) {
            super(f2);
            this.w = i;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }
    }

    static final class FloatOrShort extends FloatOrWholeNumber {
        private final short w;

        FloatOrShort(Float f2, short s) {
            super(f2);
            this.w = s;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public short shortValue() {
            return this.w;
        }
    }

    static abstract class FloatOrWholeNumber extends NumberWithFallbackType {
        private final Float n;

        FloatOrWholeNumber(Float f2) {
            this.n = f2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public float floatValue() {
            return this.n.floatValue();
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }
    }

    static final class IntegerBigDecimal extends NumberWithFallbackType {
        private final BigDecimal n;

        IntegerBigDecimal(BigDecimal bigDecimal) {
            this.n = bigDecimal;
        }

        public BigInteger bigIntegerValue() {
            return this.n.toBigInteger();
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }
    }

    static class IntegerOrByte extends IntegerOrSmallerInteger {
        private final byte w;

        IntegerOrByte(Integer num, byte b2) {
            super(num);
            this.w = b2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public byte byteValue() {
            return this.w;
        }
    }

    static class IntegerOrShort extends IntegerOrSmallerInteger {
        private final short w;

        IntegerOrShort(Integer num, short s) {
            super(num);
            this.w = s;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public short shortValue() {
            return this.w;
        }
    }

    static abstract class IntegerOrSmallerInteger extends NumberWithFallbackType {
        private final Integer n;

        protected IntegerOrSmallerInteger(Integer num) {
            this.n = num;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.n.intValue();
        }
    }

    static class LongOrByte extends LongOrSmallerInteger {
        private final byte w;

        LongOrByte(Long l, byte b2) {
            super(l);
            this.w = b2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public byte byteValue() {
            return this.w;
        }
    }

    static class LongOrInteger extends LongOrSmallerInteger {
        private final int w;

        LongOrInteger(Long l, int i) {
            super(l);
            this.w = i;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public int intValue() {
            return this.w;
        }
    }

    static class LongOrShort extends LongOrSmallerInteger {
        private final short w;

        LongOrShort(Long l, short s) {
            super(l);
            this.w = s;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public short shortValue() {
            return this.w;
        }
    }

    static abstract class LongOrSmallerInteger extends NumberWithFallbackType {
        private final Long n;

        protected LongOrSmallerInteger(Long l) {
            this.n = l;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public long longValue() {
            return this.n.longValue();
        }
    }

    static abstract class NumberWithFallbackType extends Number implements Comparable {
        NumberWithFallbackType() {
        }

        @Override // java.lang.Number
        public byte byteValue() {
            return getSourceNumber().byteValue();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            Object sourceNumber = getSourceNumber();
            if (sourceNumber instanceof Comparable) {
                return ((Comparable) sourceNumber).compareTo(obj);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(sourceNumber.getClass().getName());
            stringBuffer.append(" is not Comparable.");
            throw new ClassCastException(stringBuffer.toString());
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return getSourceNumber().doubleValue();
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return getSourceNumber().equals(((NumberWithFallbackType) obj).getSourceNumber());
        }

        @Override // java.lang.Number
        public float floatValue() {
            return getSourceNumber().floatValue();
        }

        protected abstract Number getSourceNumber();

        public int hashCode() {
            return getSourceNumber().hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            return getSourceNumber().intValue();
        }

        @Override // java.lang.Number
        public long longValue() {
            return getSourceNumber().longValue();
        }

        @Override // java.lang.Number
        public short shortValue() {
            return getSourceNumber().shortValue();
        }

        public String toString() {
            return getSourceNumber().toString();
        }
    }

    static class ShortOrByte extends NumberWithFallbackType {
        private final Short n;
        private final byte w;

        protected ShortOrByte(Short sh, byte b2) {
            this.n = sh;
            this.w = b2;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public byte byteValue() {
            return this.w;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType
        protected Number getSourceNumber() {
            return this.n;
        }

        @Override // freemarker.ext.beans.OverloadedNumberUtil.NumberWithFallbackType, java.lang.Number
        public short shortValue() {
            return this.n.shortValue();
        }
    }

    static Number a(Number number, int i2) throws Throwable {
        Class<?> cls = number.getClass();
        Class<?> clsA = f21549a;
        if (clsA == null) {
            clsA = a("java.math.BigDecimal");
            f21549a = clsA;
        }
        if (cls == clsA) {
            BigDecimal bigDecimal = (BigDecimal) number;
            return ((i2 & 316) == 0 || (i2 & 704) == 0 || !freemarker.template.utility.c.a(bigDecimal)) ? bigDecimal : new IntegerBigDecimal(bigDecimal);
        }
        Class<?> clsA2 = f21550b;
        if (clsA2 == null) {
            clsA2 = a("java.lang.Integer");
            f21550b = clsA2;
        }
        if (cls == clsA2) {
            int iIntValue = number.intValue();
            return ((i2 & 4) == 0 || iIntValue > 127 || iIntValue < -128) ? ((i2 & 8) == 0 || iIntValue > 32767 || iIntValue < -32768) ? number : new IntegerOrShort((Integer) number, (short) iIntValue) : new IntegerOrByte((Integer) number, (byte) iIntValue);
        }
        Class<?> clsA3 = f21551c;
        if (clsA3 == null) {
            clsA3 = a("java.lang.Long");
            f21551c = clsA3;
        }
        if (cls == clsA3) {
            long jLongValue = number.longValue();
            return ((i2 & 4) == 0 || jLongValue > 127 || jLongValue < -128) ? ((i2 & 8) == 0 || jLongValue > 32767 || jLongValue < -32768) ? ((i2 & 16) == 0 || jLongValue > 2147483647L || jLongValue < -2147483648L) ? number : new LongOrInteger((Long) number, (int) jLongValue) : new LongOrShort((Long) number, (short) jLongValue) : new LongOrByte((Long) number, (byte) jLongValue);
        }
        Class<?> clsA4 = f21552d;
        if (clsA4 == null) {
            clsA4 = a("java.lang.Double");
            f21552d = clsA4;
        }
        boolean z2 = false;
        if (cls == clsA4) {
            double dDoubleValue = number.doubleValue();
            if ((i2 & 316) != 0 && dDoubleValue <= 9.007199254740992E15d && dDoubleValue >= -9.007199254740992E15d) {
                long jLongValue2 = number.longValue();
                double d2 = jLongValue2;
                Double.isNaN(d2);
                double d3 = dDoubleValue - d2;
                if (d3 == 0.0d) {
                    z2 = true;
                } else if (d3 > 0.0d) {
                    if (d3 >= 1.0E-6d) {
                        if (d3 > 0.999999d) {
                            jLongValue2++;
                        }
                    }
                } else if (d3 <= -1.0E-6d) {
                    if (d3 < -0.999999d) {
                        jLongValue2--;
                    }
                }
                if ((i2 & 4) != 0 && jLongValue2 <= 127 && jLongValue2 >= -128) {
                    return new DoubleOrByte((Double) number, (byte) jLongValue2);
                }
                if ((i2 & 8) != 0 && jLongValue2 <= 32767 && jLongValue2 >= -32768) {
                    return new DoubleOrShort((Double) number, (short) jLongValue2);
                }
                if ((i2 & 16) != 0 && jLongValue2 <= 2147483647L && jLongValue2 >= -2147483648L) {
                    int i3 = (int) jLongValue2;
                    return ((i2 & 64) == 0 || i3 < -16777216 || i3 > 16777216) ? new DoubleOrInteger((Double) number, i3) : new DoubleOrIntegerOrFloat((Double) number, i3);
                }
                if ((i2 & 32) != 0) {
                    if (z2) {
                        return new DoubleOrLong((Double) number, jLongValue2);
                    }
                    if (jLongValue2 >= -2147483648L && jLongValue2 <= 2147483647L) {
                        return new DoubleOrLong((Double) number, jLongValue2);
                    }
                }
            }
            return ((i2 & 64) == 0 || dDoubleValue < -3.4028234663852886E38d || dDoubleValue > 3.4028234663852886E38d) ? number : new DoubleOrFloat((Double) number);
        }
        Class<?> clsA5 = f21553e;
        if (clsA5 == null) {
            clsA5 = a("java.lang.Float");
            f21553e = clsA5;
        }
        if (cls == clsA5) {
            float fFloatValue = number.floatValue();
            if ((i2 & 316) != 0 && fFloatValue <= 1.6777216E7f && fFloatValue >= -1.6777216E7f) {
                int iIntValue2 = number.intValue();
                double d4 = fFloatValue - iIntValue2;
                if (d4 == 0.0d) {
                    z2 = true;
                } else if (iIntValue2 >= -128 && iIntValue2 <= 127) {
                    if (d4 > 0.0d) {
                        if (d4 >= 1.0E-5d) {
                            if (d4 > 0.99999d) {
                                iIntValue2++;
                            }
                        }
                    } else if (d4 <= -1.0E-5d) {
                        if (d4 < -0.99999d) {
                            iIntValue2--;
                        }
                    }
                }
                if ((i2 & 4) != 0 && iIntValue2 <= 127 && iIntValue2 >= -128) {
                    return new FloatOrByte((Float) number, (byte) iIntValue2);
                }
                if ((i2 & 8) != 0 && iIntValue2 <= 32767 && iIntValue2 >= -32768) {
                    return new FloatOrShort((Float) number, (short) iIntValue2);
                }
                if ((i2 & 16) != 0) {
                    return new FloatOrInteger((Float) number, iIntValue2);
                }
                if ((i2 & 32) != 0) {
                    return z2 ? new FloatOrInteger((Float) number, iIntValue2) : new FloatOrByte((Float) number, (byte) iIntValue2);
                }
            }
            return number;
        }
        Class<?> clsA6 = f21554f;
        if (clsA6 == null) {
            clsA6 = a("java.lang.Byte");
            f21554f = clsA6;
        }
        if (cls == clsA6) {
            return number;
        }
        Class<?> clsA7 = g;
        if (clsA7 == null) {
            clsA7 = a("java.lang.Short");
            g = clsA7;
        }
        if (cls == clsA7) {
            short sShortValue = number.shortValue();
            return ((i2 & 4) == 0 || sShortValue > 127 || sShortValue < -128) ? number : new ShortOrByte((Short) number, (byte) sShortValue);
        }
        Class<?> clsA8 = h;
        if (clsA8 == null) {
            clsA8 = a("java.math.BigInteger");
            h = clsA8;
        }
        if (cls == clsA8 && (i2 & 252) != 0) {
            BigInteger bigInteger = (BigInteger) number;
            int iBitLength = bigInteger.bitLength();
            if ((i2 & 4) != 0 && iBitLength <= 7) {
                return new BigIntegerOrByte(bigInteger);
            }
            if ((i2 & 8) != 0 && iBitLength <= 15) {
                return new BigIntegerOrShort(bigInteger);
            }
            if ((i2 & 16) != 0 && iBitLength <= 31) {
                return new BigIntegerOrInteger(bigInteger);
            }
            if ((i2 & 32) != 0 && iBitLength <= 63) {
                return new BigIntegerOrLong(bigInteger);
            }
            if ((i2 & 64) != 0 && (iBitLength <= 24 || (iBitLength == 25 && bigInteger.getLowestSetBit() >= 24))) {
                return new BigIntegerOrFloat(bigInteger);
            }
            if ((i2 & 128) != 0 && (iBitLength <= 53 || (iBitLength == 54 && bigInteger.getLowestSetBit() >= 53))) {
                return new BigIntegerOrDouble(bigInteger);
            }
        }
        return number;
    }

    static int b(Class cls, Class cls2) throws Throwable {
        if (cls2 == cls) {
            return 0;
        }
        Class clsA = f21550b;
        if (clsA == null) {
            clsA = a("java.lang.Integer");
            f21550b = clsA;
        }
        if (cls2 == clsA) {
            Class clsA2 = i;
            if (clsA2 == null) {
                clsA2 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA2;
            }
            if (cls == clsA2) {
                return 31003;
            }
            Class clsA3 = f21549a;
            if (clsA3 == null) {
                clsA3 = a("java.math.BigDecimal");
                f21549a = clsA3;
            }
            if (cls == clsA3) {
                return 41003;
            }
            Class clsA4 = f21551c;
            if (clsA4 == null) {
                clsA4 = a("java.lang.Long");
                f21551c = clsA4;
            }
            if (cls == clsA4) {
                return Integer.MAX_VALUE;
            }
            Class clsA5 = f21552d;
            if (clsA5 == null) {
                clsA5 = a("java.lang.Double");
                f21552d = clsA5;
            }
            if (cls == clsA5) {
                return Integer.MAX_VALUE;
            }
            Class clsA6 = f21553e;
            if (clsA6 == null) {
                clsA6 = a("java.lang.Float");
                f21553e = clsA6;
            }
            if (cls == clsA6) {
                return Integer.MAX_VALUE;
            }
            Class clsA7 = f21554f;
            if (clsA7 == null) {
                clsA7 = a("java.lang.Byte");
                f21554f = clsA7;
            }
            if (cls == clsA7) {
                return 10003;
            }
            Class clsA8 = h;
            if (clsA8 == null) {
                clsA8 = a("java.math.BigInteger");
                h = clsA8;
            }
            if (cls == clsA8) {
                return Integer.MAX_VALUE;
            }
            Class clsA9 = j;
            if (clsA9 == null) {
                clsA9 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA9;
            }
            if (cls == clsA9) {
                return 21003;
            }
            Class clsA10 = k;
            if (clsA10 == null) {
                clsA10 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA10;
            }
            if (cls == clsA10) {
                return Integer.MAX_VALUE;
            }
            Class clsA11 = l;
            if (clsA11 == null) {
                clsA11 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA11;
            }
            if (cls == clsA11) {
                return 22003;
            }
            Class clsA12 = m;
            if (clsA12 == null) {
                clsA12 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA12;
            }
            if (cls == clsA12) {
                return 22003;
            }
            Class clsA13 = n;
            if (clsA13 == null) {
                clsA13 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA13;
            }
            if (cls == clsA13) {
                return Integer.MAX_VALUE;
            }
            Class clsA14 = o;
            if (clsA14 == null) {
                clsA14 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA14;
            }
            if (cls == clsA14) {
                return 0;
            }
            Class clsA15 = p;
            if (clsA15 == null) {
                clsA15 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA15;
            }
            if (cls == clsA15) {
                return 22003;
            }
            Class clsA16 = q;
            if (clsA16 == null) {
                clsA16 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA16;
            }
            if (cls == clsA16) {
                return 21003;
            }
            Class clsA17 = g;
            if (clsA17 == null) {
                clsA17 = a("java.lang.Short");
                g = clsA17;
            }
            if (cls == clsA17) {
                return 10003;
            }
            Class clsA18 = r;
            if (clsA18 == null) {
                clsA18 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA18;
            }
            if (cls == clsA18) {
                return 21003;
            }
            Class clsA19 = s;
            if (clsA19 == null) {
                clsA19 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA19;
            }
            if (cls == clsA19) {
                return 10003;
            }
            Class clsA20 = t;
            if (clsA20 == null) {
                clsA20 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA20;
            }
            if (cls == clsA20) {
                return 21003;
            }
            Class clsA21 = u;
            if (clsA21 == null) {
                clsA21 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA21;
            }
            if (cls == clsA21) {
                return 21003;
            }
            Class clsA22 = v;
            if (clsA22 == null) {
                clsA22 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA22;
            }
            if (cls == clsA22) {
                return 21003;
            }
            Class clsA23 = w;
            if (clsA23 == null) {
                clsA23 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA23;
            }
            if (cls == clsA23) {
                return 16003;
            }
            Class clsA24 = x;
            if (clsA24 == null) {
                clsA24 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA24;
            }
            if (cls == clsA24) {
                return Integer.MAX_VALUE;
            }
            Class clsA25 = y;
            if (clsA25 == null) {
                clsA25 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA25;
            }
            if (cls == clsA25) {
                return Integer.MAX_VALUE;
            }
            Class clsA26 = z;
            if (clsA26 == null) {
                clsA26 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA26;
            }
            if (cls == clsA26) {
                return Integer.MAX_VALUE;
            }
            Class clsA27 = A;
            if (clsA27 == null) {
                clsA27 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA27;
            }
            if (cls == clsA27) {
                return 16003;
            }
            Class clsA28 = B;
            if (clsA28 == null) {
                clsA28 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA28;
            }
            if (cls == clsA28) {
                return 0;
            }
            Class clsA29 = C;
            if (clsA29 == null) {
                clsA29 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA29;
            }
            if (cls == clsA29) {
                return 22003;
            }
            Class clsA30 = D;
            if (clsA30 == null) {
                clsA30 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA30;
            }
            return cls == clsA30 ? 16003 : Integer.MAX_VALUE;
        }
        Class clsA31 = f21551c;
        if (clsA31 == null) {
            clsA31 = a("java.lang.Long");
            f21551c = clsA31;
        }
        if (cls2 == clsA31) {
            Class clsA32 = f21550b;
            if (clsA32 == null) {
                clsA32 = a("java.lang.Integer");
                f21550b = clsA32;
            }
            if (cls == clsA32) {
                return 10004;
            }
            Class clsA33 = i;
            if (clsA33 == null) {
                clsA33 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA33;
            }
            if (cls == clsA33) {
                return 31004;
            }
            Class clsA34 = f21549a;
            if (clsA34 == null) {
                clsA34 = a("java.math.BigDecimal");
                f21549a = clsA34;
            }
            if (cls == clsA34) {
                return 41004;
            }
            Class clsA35 = f21552d;
            if (clsA35 == null) {
                clsA35 = a("java.lang.Double");
                f21552d = clsA35;
            }
            if (cls == clsA35) {
                return Integer.MAX_VALUE;
            }
            Class clsA36 = f21553e;
            if (clsA36 == null) {
                clsA36 = a("java.lang.Float");
                f21553e = clsA36;
            }
            if (cls == clsA36) {
                return Integer.MAX_VALUE;
            }
            Class clsA37 = f21554f;
            if (clsA37 == null) {
                clsA37 = a("java.lang.Byte");
                f21554f = clsA37;
            }
            if (cls == clsA37) {
                return 10004;
            }
            Class clsA38 = h;
            if (clsA38 == null) {
                clsA38 = a("java.math.BigInteger");
                h = clsA38;
            }
            if (cls == clsA38) {
                return Integer.MAX_VALUE;
            }
            Class clsA39 = j;
            if (clsA39 == null) {
                clsA39 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA39;
            }
            if (cls == clsA39) {
                return 0;
            }
            Class clsA40 = k;
            if (clsA40 == null) {
                clsA40 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA40;
            }
            if (cls == clsA40) {
                return Integer.MAX_VALUE;
            }
            Class clsA41 = l;
            if (clsA41 == null) {
                clsA41 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA41;
            }
            if (cls == clsA41) {
                return 21004;
            }
            Class clsA42 = m;
            if (clsA42 == null) {
                clsA42 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA42;
            }
            if (cls == clsA42) {
                return 21004;
            }
            Class clsA43 = n;
            if (clsA43 == null) {
                clsA43 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA43;
            }
            if (cls == clsA43) {
                return 21004;
            }
            Class clsA44 = o;
            if (clsA44 == null) {
                clsA44 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA44;
            }
            if (cls == clsA44) {
                return 10004;
            }
            Class clsA45 = p;
            if (clsA45 == null) {
                clsA45 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA45;
            }
            if (cls == clsA45) {
                return 21004;
            }
            Class clsA46 = q;
            if (clsA46 == null) {
                clsA46 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA46;
            }
            if (cls == clsA46) {
                return 0;
            }
            Class clsA47 = g;
            if (clsA47 == null) {
                clsA47 = a("java.lang.Short");
                g = clsA47;
            }
            if (cls == clsA47) {
                return 10004;
            }
            Class clsA48 = r;
            if (clsA48 == null) {
                clsA48 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA48;
            }
            if (cls == clsA48) {
                return 0;
            }
            Class clsA49 = s;
            if (clsA49 == null) {
                clsA49 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA49;
            }
            if (cls == clsA49) {
                return 10004;
            }
            Class clsA50 = t;
            if (clsA50 == null) {
                clsA50 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA50;
            }
            if (cls == clsA50) {
                return 21004;
            }
            Class clsA51 = u;
            if (clsA51 == null) {
                clsA51 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA51;
            }
            if (cls == clsA51) {
                return 21004;
            }
            Class clsA52 = v;
            if (clsA52 == null) {
                clsA52 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA52;
            }
            if (cls == clsA52) {
                return 21004;
            }
            Class clsA53 = w;
            if (clsA53 == null) {
                clsA53 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA53;
            }
            if (cls == clsA53) {
                return 15004;
            }
            Class clsA54 = x;
            if (clsA54 == null) {
                clsA54 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA54;
            }
            if (cls == clsA54) {
                return 15004;
            }
            Class clsA55 = y;
            if (clsA55 == null) {
                clsA55 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA55;
            }
            if (cls == clsA55) {
                return Integer.MAX_VALUE;
            }
            Class clsA56 = z;
            if (clsA56 == null) {
                clsA56 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA56;
            }
            if (cls == clsA56) {
                return Integer.MAX_VALUE;
            }
            Class clsA57 = A;
            if (clsA57 == null) {
                clsA57 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA57;
            }
            if (cls == clsA57) {
                return 15004;
            }
            Class clsA58 = B;
            if (clsA58 == null) {
                clsA58 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA58;
            }
            if (cls == clsA58) {
                return 10004;
            }
            Class clsA59 = C;
            if (clsA59 == null) {
                clsA59 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA59;
            }
            if (cls == clsA59) {
                return 21004;
            }
            Class clsA60 = D;
            if (clsA60 == null) {
                clsA60 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA60;
            }
            return cls == clsA60 ? 15004 : Integer.MAX_VALUE;
        }
        Class clsA61 = f21552d;
        if (clsA61 == null) {
            clsA61 = a("java.lang.Double");
            f21552d = clsA61;
        }
        if (cls2 == clsA61) {
            Class clsA62 = f21550b;
            if (clsA62 == null) {
                clsA62 = a("java.lang.Integer");
                f21550b = clsA62;
            }
            if (cls == clsA62) {
                return 20007;
            }
            Class clsA63 = i;
            if (clsA63 == null) {
                clsA63 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA63;
            }
            if (cls == clsA63) {
                return 32007;
            }
            Class clsA64 = f21549a;
            if (clsA64 == null) {
                clsA64 = a("java.math.BigDecimal");
                f21549a = clsA64;
            }
            if (cls == clsA64) {
                return 32007;
            }
            Class clsA65 = f21551c;
            if (clsA65 == null) {
                clsA65 = a("java.lang.Long");
                f21551c = clsA65;
            }
            if (cls == clsA65) {
                return 30007;
            }
            Class clsA66 = f21553e;
            if (clsA66 == null) {
                clsA66 = a("java.lang.Float");
                f21553e = clsA66;
            }
            if (cls == clsA66) {
                return 10007;
            }
            Class clsA67 = f21554f;
            if (clsA67 == null) {
                clsA67 = a("java.lang.Byte");
                f21554f = clsA67;
            }
            if (cls == clsA67) {
                return 20007;
            }
            Class clsA68 = h;
            if (clsA68 == null) {
                clsA68 = a("java.math.BigInteger");
                h = clsA68;
            }
            if (cls == clsA68) {
                return Integer.MAX_VALUE;
            }
            Class clsA69 = j;
            if (clsA69 == null) {
                clsA69 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA69;
            }
            if (cls == clsA69) {
                return 21007;
            }
            Class clsA70 = k;
            if (clsA70 == null) {
                clsA70 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA70;
            }
            if (cls == clsA70) {
                return 0;
            }
            Class clsA71 = l;
            if (clsA71 == null) {
                clsA71 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA71;
            }
            if (cls == clsA71) {
                return 0;
            }
            Class clsA72 = m;
            if (clsA72 == null) {
                clsA72 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA72;
            }
            if (cls == clsA72) {
                return 0;
            }
            Class clsA73 = n;
            if (clsA73 == null) {
                clsA73 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA73;
            }
            if (cls == clsA73) {
                return 0;
            }
            Class clsA74 = o;
            if (clsA74 == null) {
                clsA74 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA74;
            }
            if (cls == clsA74) {
                return 20007;
            }
            Class clsA75 = p;
            if (clsA75 == null) {
                clsA75 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA75;
            }
            if (cls == clsA75) {
                return 0;
            }
            Class clsA76 = q;
            if (clsA76 == null) {
                clsA76 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA76;
            }
            if (cls == clsA76) {
                return 21007;
            }
            Class clsA77 = g;
            if (clsA77 == null) {
                clsA77 = a("java.lang.Short");
                g = clsA77;
            }
            if (cls == clsA77) {
                return 20007;
            }
            Class clsA78 = r;
            if (clsA78 == null) {
                clsA78 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA78;
            }
            if (cls == clsA78) {
                return 21007;
            }
            Class clsA79 = s;
            if (clsA79 == null) {
                clsA79 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA79;
            }
            if (cls == clsA79) {
                return 20007;
            }
            Class clsA80 = t;
            if (clsA80 == null) {
                clsA80 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA80;
            }
            if (cls == clsA80) {
                return 10007;
            }
            Class clsA81 = u;
            if (clsA81 == null) {
                clsA81 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA81;
            }
            if (cls == clsA81) {
                return 10007;
            }
            Class clsA82 = v;
            if (clsA82 == null) {
                clsA82 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA82;
            }
            if (cls == clsA82) {
                return 10007;
            }
            Class clsA83 = w;
            if (clsA83 == null) {
                clsA83 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA83;
            }
            if (cls == clsA83) {
                return 20007;
            }
            Class clsA84 = x;
            if (clsA84 == null) {
                clsA84 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA84;
            }
            if (cls == clsA84) {
                return 30007;
            }
            Class clsA85 = y;
            if (clsA85 == null) {
                clsA85 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA85;
            }
            if (cls == clsA85) {
                return 20007;
            }
            Class clsA86 = z;
            if (clsA86 == null) {
                clsA86 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA86;
            }
            if (cls == clsA86) {
                return 20007;
            }
            Class clsA87 = A;
            if (clsA87 == null) {
                clsA87 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA87;
            }
            if (cls == clsA87) {
                return 20007;
            }
            Class clsA88 = B;
            if (clsA88 == null) {
                clsA88 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA88;
            }
            if (cls == clsA88) {
                return 20007;
            }
            Class clsA89 = C;
            if (clsA89 == null) {
                clsA89 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA89;
            }
            if (cls == clsA89) {
                return 0;
            }
            Class clsA90 = D;
            if (clsA90 == null) {
                clsA90 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA90;
            }
            return cls == clsA90 ? 20007 : Integer.MAX_VALUE;
        }
        Class clsA91 = f21553e;
        if (clsA91 == null) {
            clsA91 = a("java.lang.Float");
            f21553e = clsA91;
        }
        if (cls2 == clsA91) {
            Class clsA92 = f21550b;
            if (clsA92 == null) {
                clsA92 = a("java.lang.Integer");
                f21550b = clsA92;
            }
            if (cls == clsA92) {
                return 30006;
            }
            Class clsA93 = i;
            if (clsA93 == null) {
                clsA93 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA93;
            }
            if (cls == clsA93) {
                return 33006;
            }
            Class clsA94 = f21549a;
            if (clsA94 == null) {
                clsA94 = a("java.math.BigDecimal");
                f21549a = clsA94;
            }
            if (cls == clsA94) {
                return 33006;
            }
            Class clsA95 = f21551c;
            if (clsA95 == null) {
                clsA95 = a("java.lang.Long");
                f21551c = clsA95;
            }
            if (cls == clsA95) {
                return 40006;
            }
            Class clsA96 = f21552d;
            if (clsA96 == null) {
                clsA96 = a("java.lang.Double");
                f21552d = clsA96;
            }
            if (cls == clsA96) {
                return Integer.MAX_VALUE;
            }
            Class clsA97 = f21554f;
            if (clsA97 == null) {
                clsA97 = a("java.lang.Byte");
                f21554f = clsA97;
            }
            if (cls == clsA97) {
                return 20006;
            }
            Class clsA98 = h;
            if (clsA98 == null) {
                clsA98 = a("java.math.BigInteger");
                h = clsA98;
            }
            if (cls == clsA98) {
                return Integer.MAX_VALUE;
            }
            Class clsA99 = j;
            if (clsA99 == null) {
                clsA99 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA99;
            }
            if (cls == clsA99) {
                return 30006;
            }
            Class clsA100 = k;
            if (clsA100 == null) {
                clsA100 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA100;
            }
            if (cls == clsA100) {
                return 30006;
            }
            Class clsA101 = l;
            if (clsA101 == null) {
                clsA101 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA101;
            }
            if (cls == clsA101) {
                return 23006;
            }
            Class clsA102 = m;
            if (clsA102 == null) {
                clsA102 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA102;
            }
            if (cls == clsA102) {
                return 30006;
            }
            Class clsA103 = n;
            if (clsA103 == null) {
                clsA103 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA103;
            }
            if (cls == clsA103) {
                return 40006;
            }
            Class clsA104 = o;
            if (clsA104 == null) {
                clsA104 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA104;
            }
            if (cls == clsA104) {
                return 24006;
            }
            Class clsA105 = p;
            if (clsA105 == null) {
                clsA105 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA105;
            }
            if (cls == clsA105) {
                return 23006;
            }
            Class clsA106 = q;
            if (clsA106 == null) {
                clsA106 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA106;
            }
            if (cls == clsA106) {
                return 24006;
            }
            Class clsA107 = g;
            if (clsA107 == null) {
                clsA107 = a("java.lang.Short");
                g = clsA107;
            }
            if (cls == clsA107) {
                return 20006;
            }
            Class clsA108 = r;
            if (clsA108 == null) {
                clsA108 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA108;
            }
            if (cls == clsA108) {
                return 24006;
            }
            Class clsA109 = s;
            if (clsA109 == null) {
                clsA109 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA109;
            }
            if (cls == clsA109) {
                return 20006;
            }
            Class clsA110 = t;
            if (clsA110 == null) {
                clsA110 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA110;
            }
            if (cls == clsA110) {
                return 0;
            }
            Class clsA111 = u;
            if (clsA111 == null) {
                clsA111 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA111;
            }
            if (cls == clsA111) {
                return 0;
            }
            Class clsA112 = v;
            if (clsA112 == null) {
                clsA112 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA112;
            }
            if (cls == clsA112) {
                return 0;
            }
            Class clsA113 = w;
            if (clsA113 == null) {
                clsA113 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA113;
            }
            if (cls == clsA113) {
                return 30006;
            }
            Class clsA114 = x;
            if (clsA114 == null) {
                clsA114 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA114;
            }
            if (cls == clsA114) {
                return 40006;
            }
            Class clsA115 = y;
            if (clsA115 == null) {
                clsA115 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA115;
            }
            if (cls == clsA115) {
                return 40006;
            }
            Class clsA116 = z;
            if (clsA116 == null) {
                clsA116 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA116;
            }
            if (cls == clsA116) {
                return 24006;
            }
            Class clsA117 = A;
            if (clsA117 == null) {
                clsA117 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA117;
            }
            if (cls == clsA117) {
                return 24006;
            }
            Class clsA118 = B;
            if (clsA118 == null) {
                clsA118 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA118;
            }
            if (cls == clsA118) {
                return 24006;
            }
            Class clsA119 = C;
            if (clsA119 == null) {
                clsA119 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA119;
            }
            if (cls == clsA119) {
                return 23006;
            }
            Class clsA120 = D;
            if (clsA120 == null) {
                clsA120 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA120;
            }
            return cls == clsA120 ? 24006 : Integer.MAX_VALUE;
        }
        Class clsA121 = f21554f;
        if (clsA121 == null) {
            clsA121 = a("java.lang.Byte");
            f21554f = clsA121;
        }
        if (cls2 == clsA121) {
            Class clsA122 = f21550b;
            if (clsA122 == null) {
                clsA122 = a("java.lang.Integer");
                f21550b = clsA122;
            }
            if (cls == clsA122) {
                return Integer.MAX_VALUE;
            }
            Class clsA123 = i;
            if (clsA123 == null) {
                clsA123 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA123;
            }
            if (cls == clsA123) {
                return 35001;
            }
            Class clsA124 = f21549a;
            if (clsA124 == null) {
                clsA124 = a("java.math.BigDecimal");
                f21549a = clsA124;
            }
            if (cls == clsA124) {
                return 45001;
            }
            Class clsA125 = f21551c;
            if (clsA125 == null) {
                clsA125 = a("java.lang.Long");
                f21551c = clsA125;
            }
            if (cls == clsA125) {
                return Integer.MAX_VALUE;
            }
            Class clsA126 = f21552d;
            if (clsA126 == null) {
                clsA126 = a("java.lang.Double");
                f21552d = clsA126;
            }
            if (cls == clsA126) {
                return Integer.MAX_VALUE;
            }
            Class clsA127 = f21553e;
            if (clsA127 == null) {
                clsA127 = a("java.lang.Float");
                f21553e = clsA127;
            }
            if (cls == clsA127) {
                return Integer.MAX_VALUE;
            }
            Class clsA128 = h;
            if (clsA128 == null) {
                clsA128 = a("java.math.BigInteger");
                h = clsA128;
            }
            if (cls == clsA128) {
                return Integer.MAX_VALUE;
            }
            Class clsA129 = j;
            if (clsA129 == null) {
                clsA129 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA129;
            }
            if (cls == clsA129) {
                return Integer.MAX_VALUE;
            }
            Class clsA130 = k;
            if (clsA130 == null) {
                clsA130 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA130;
            }
            if (cls == clsA130) {
                return Integer.MAX_VALUE;
            }
            Class clsA131 = l;
            if (clsA131 == null) {
                clsA131 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA131;
            }
            if (cls == clsA131) {
                return Integer.MAX_VALUE;
            }
            Class clsA132 = m;
            if (clsA132 == null) {
                clsA132 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA132;
            }
            if (cls == clsA132) {
                return Integer.MAX_VALUE;
            }
            Class clsA133 = n;
            if (clsA133 == null) {
                clsA133 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA133;
            }
            if (cls == clsA133) {
                return Integer.MAX_VALUE;
            }
            Class clsA134 = o;
            if (clsA134 == null) {
                clsA134 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA134;
            }
            if (cls == clsA134) {
                return 22001;
            }
            Class clsA135 = p;
            if (clsA135 == null) {
                clsA135 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA135;
            }
            if (cls == clsA135) {
                return 25001;
            }
            Class clsA136 = q;
            if (clsA136 == null) {
                clsA136 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA136;
            }
            if (cls == clsA136) {
                return 23001;
            }
            Class clsA137 = g;
            if (clsA137 == null) {
                clsA137 = a("java.lang.Short");
                g = clsA137;
            }
            if (cls == clsA137) {
                return Integer.MAX_VALUE;
            }
            Class clsA138 = r;
            if (clsA138 == null) {
                clsA138 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA138;
            }
            if (cls == clsA138) {
                return Integer.MAX_VALUE;
            }
            Class clsA139 = s;
            if (clsA139 == null) {
                clsA139 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA139;
            }
            if (cls == clsA139) {
                return 21001;
            }
            Class clsA140 = t;
            if (clsA140 == null) {
                clsA140 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA140;
            }
            if (cls == clsA140) {
                return Integer.MAX_VALUE;
            }
            Class clsA141 = u;
            if (clsA141 == null) {
                clsA141 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA141;
            }
            if (cls == clsA141) {
                return 23001;
            }
            Class clsA142 = v;
            if (clsA142 == null) {
                clsA142 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA142;
            }
            if (cls == clsA142) {
                return Integer.MAX_VALUE;
            }
            Class clsA143 = w;
            if (clsA143 == null) {
                clsA143 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA143;
            }
            if (cls == clsA143) {
                return Integer.MAX_VALUE;
            }
            Class clsA144 = x;
            if (clsA144 == null) {
                clsA144 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA144;
            }
            if (cls == clsA144) {
                return Integer.MAX_VALUE;
            }
            Class clsA145 = y;
            if (clsA145 == null) {
                clsA145 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA145;
            }
            if (cls == clsA145) {
                return Integer.MAX_VALUE;
            }
            Class clsA146 = z;
            if (clsA146 == null) {
                clsA146 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA146;
            }
            if (cls == clsA146) {
                return Integer.MAX_VALUE;
            }
            Class clsA147 = A;
            if (clsA147 == null) {
                clsA147 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA147;
            }
            if (cls == clsA147) {
                return 18001;
            }
            Class clsA148 = B;
            if (clsA148 == null) {
                clsA148 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA148;
            }
            if (cls == clsA148) {
                return Integer.MAX_VALUE;
            }
            Class clsA149 = C;
            if (clsA149 == null) {
                clsA149 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA149;
            }
            if (cls == clsA149) {
                return Integer.MAX_VALUE;
            }
            Class clsA150 = D;
            if (clsA150 == null) {
                clsA150 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA150;
            }
            if (cls == clsA150) {
            }
            return Integer.MAX_VALUE;
        }
        Class clsA151 = g;
        if (clsA151 == null) {
            clsA151 = a("java.lang.Short");
            g = clsA151;
        }
        if (cls2 == clsA151) {
            Class clsA152 = f21550b;
            if (clsA152 == null) {
                clsA152 = a("java.lang.Integer");
                f21550b = clsA152;
            }
            if (cls == clsA152) {
                return Integer.MAX_VALUE;
            }
            Class clsA153 = i;
            if (clsA153 == null) {
                clsA153 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA153;
            }
            if (cls == clsA153) {
                return 34002;
            }
            Class clsA154 = f21549a;
            if (clsA154 == null) {
                clsA154 = a("java.math.BigDecimal");
                f21549a = clsA154;
            }
            if (cls == clsA154) {
                return 44002;
            }
            Class clsA155 = f21551c;
            if (clsA155 == null) {
                clsA155 = a("java.lang.Long");
                f21551c = clsA155;
            }
            if (cls == clsA155) {
                return Integer.MAX_VALUE;
            }
            Class clsA156 = f21552d;
            if (clsA156 == null) {
                clsA156 = a("java.lang.Double");
                f21552d = clsA156;
            }
            if (cls == clsA156) {
                return Integer.MAX_VALUE;
            }
            Class clsA157 = f21553e;
            if (clsA157 == null) {
                clsA157 = a("java.lang.Float");
                f21553e = clsA157;
            }
            if (cls == clsA157) {
                return Integer.MAX_VALUE;
            }
            Class clsA158 = f21554f;
            if (clsA158 == null) {
                clsA158 = a("java.lang.Byte");
                f21554f = clsA158;
            }
            if (cls == clsA158) {
                return HttpCode.UN_KNOW;
            }
            Class clsA159 = h;
            if (clsA159 == null) {
                clsA159 = a("java.math.BigInteger");
                h = clsA159;
            }
            if (cls == clsA159) {
                return Integer.MAX_VALUE;
            }
            Class clsA160 = j;
            if (clsA160 == null) {
                clsA160 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA160;
            }
            if (cls == clsA160) {
                return Integer.MAX_VALUE;
            }
            Class clsA161 = k;
            if (clsA161 == null) {
                clsA161 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA161;
            }
            if (cls == clsA161) {
                return Integer.MAX_VALUE;
            }
            Class clsA162 = l;
            if (clsA162 == null) {
                clsA162 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA162;
            }
            if (cls == clsA162) {
                return Integer.MAX_VALUE;
            }
            Class clsA163 = m;
            if (clsA163 == null) {
                clsA163 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA163;
            }
            if (cls == clsA163) {
                return Integer.MAX_VALUE;
            }
            Class clsA164 = n;
            if (clsA164 == null) {
                clsA164 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA164;
            }
            if (cls == clsA164) {
                return Integer.MAX_VALUE;
            }
            Class clsA165 = o;
            if (clsA165 == null) {
                clsA165 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA165;
            }
            if (cls == clsA165) {
                return 21002;
            }
            Class clsA166 = p;
            if (clsA166 == null) {
                clsA166 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA166;
            }
            if (cls == clsA166) {
                return 24002;
            }
            Class clsA167 = q;
            if (clsA167 == null) {
                clsA167 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA167;
            }
            if (cls == clsA167) {
                return 22002;
            }
            Class clsA168 = r;
            if (clsA168 == null) {
                clsA168 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA168;
            }
            if (cls == clsA168) {
                return 22002;
            }
            Class clsA169 = s;
            if (clsA169 == null) {
                clsA169 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA169;
            }
            if (cls == clsA169) {
                return 0;
            }
            Class clsA170 = t;
            if (clsA170 == null) {
                clsA170 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA170;
            }
            if (cls == clsA170) {
                return Integer.MAX_VALUE;
            }
            Class clsA171 = u;
            if (clsA171 == null) {
                clsA171 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA171;
            }
            if (cls == clsA171) {
                return 22002;
            }
            Class clsA172 = v;
            if (clsA172 == null) {
                clsA172 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA172;
            }
            if (cls == clsA172) {
                return 22002;
            }
            Class clsA173 = w;
            if (clsA173 == null) {
                clsA173 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA173;
            }
            if (cls == clsA173) {
                return Integer.MAX_VALUE;
            }
            Class clsA174 = x;
            if (clsA174 == null) {
                clsA174 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA174;
            }
            if (cls == clsA174) {
                return Integer.MAX_VALUE;
            }
            Class clsA175 = y;
            if (clsA175 == null) {
                clsA175 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA175;
            }
            if (cls == clsA175) {
                return Integer.MAX_VALUE;
            }
            Class clsA176 = z;
            if (clsA176 == null) {
                clsA176 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA176;
            }
            if (cls == clsA176) {
                return Integer.MAX_VALUE;
            }
            Class clsA177 = A;
            if (clsA177 == null) {
                clsA177 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA177;
            }
            if (cls == clsA177) {
                return FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH;
            }
            Class clsA178 = B;
            if (clsA178 == null) {
                clsA178 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA178;
            }
            if (cls == clsA178) {
                return 21002;
            }
            Class clsA179 = C;
            if (clsA179 == null) {
                clsA179 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA179;
            }
            if (cls == clsA179) {
                return 24002;
            }
            Class clsA180 = D;
            if (clsA180 == null) {
                clsA180 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA180;
            }
            if (cls == clsA180) {
                return FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH;
            }
            return Integer.MAX_VALUE;
        }
        Class clsA181 = f21549a;
        if (clsA181 == null) {
            clsA181 = a("java.math.BigDecimal");
            f21549a = clsA181;
        }
        if (cls2 == clsA181) {
            Class clsA182 = f21550b;
            if (clsA182 == null) {
                clsA182 = a("java.lang.Integer");
                f21550b = clsA182;
            }
            if (cls == clsA182) {
                return 20008;
            }
            Class clsA183 = i;
            if (clsA183 == null) {
                clsA183 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA183;
            }
            if (cls == clsA183) {
                return 0;
            }
            Class clsA184 = f21551c;
            if (clsA184 == null) {
                clsA184 = a("java.lang.Long");
                f21551c = clsA184;
            }
            if (cls == clsA184) {
                return 20008;
            }
            Class clsA185 = f21552d;
            if (clsA185 == null) {
                clsA185 = a("java.lang.Double");
                f21552d = clsA185;
            }
            if (cls == clsA185) {
                return 20008;
            }
            Class clsA186 = f21553e;
            if (clsA186 == null) {
                clsA186 = a("java.lang.Float");
                f21553e = clsA186;
            }
            if (cls == clsA186) {
                return 20008;
            }
            Class clsA187 = f21554f;
            if (clsA187 == null) {
                clsA187 = a("java.lang.Byte");
                f21554f = clsA187;
            }
            if (cls == clsA187) {
                return 20008;
            }
            Class clsA188 = h;
            if (clsA188 == null) {
                clsA188 = a("java.math.BigInteger");
                h = clsA188;
            }
            if (cls == clsA188) {
                return 10008;
            }
            Class clsA189 = j;
            if (clsA189 == null) {
                clsA189 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA189;
            }
            if (cls == clsA189) {
                return 20008;
            }
            Class clsA190 = k;
            if (clsA190 == null) {
                clsA190 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA190;
            }
            if (cls == clsA190) {
                return 20008;
            }
            Class clsA191 = l;
            if (clsA191 == null) {
                clsA191 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA191;
            }
            if (cls == clsA191) {
                return 20008;
            }
            Class clsA192 = m;
            if (clsA192 == null) {
                clsA192 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA192;
            }
            if (cls == clsA192) {
                return 20008;
            }
            Class clsA193 = n;
            if (clsA193 == null) {
                clsA193 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA193;
            }
            if (cls == clsA193) {
                return 20008;
            }
            Class clsA194 = o;
            if (clsA194 == null) {
                clsA194 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA194;
            }
            if (cls == clsA194) {
                return 20008;
            }
            Class clsA195 = p;
            if (clsA195 == null) {
                clsA195 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA195;
            }
            if (cls == clsA195) {
                return 20008;
            }
            Class clsA196 = q;
            if (clsA196 == null) {
                clsA196 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA196;
            }
            if (cls == clsA196) {
                return 20008;
            }
            Class clsA197 = g;
            if (clsA197 == null) {
                clsA197 = a("java.lang.Short");
                g = clsA197;
            }
            if (cls == clsA197) {
                return 20008;
            }
            Class clsA198 = r;
            if (clsA198 == null) {
                clsA198 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA198;
            }
            if (cls == clsA198) {
                return 20008;
            }
            Class clsA199 = s;
            if (clsA199 == null) {
                clsA199 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA199;
            }
            if (cls == clsA199) {
                return 20008;
            }
            Class clsA200 = t;
            if (clsA200 == null) {
                clsA200 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA200;
            }
            if (cls == clsA200) {
                return 20008;
            }
            Class clsA201 = u;
            if (clsA201 == null) {
                clsA201 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA201;
            }
            if (cls == clsA201) {
                return 20008;
            }
            Class clsA202 = v;
            if (clsA202 == null) {
                clsA202 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA202;
            }
            if (cls == clsA202) {
                return 20008;
            }
            Class clsA203 = w;
            if (clsA203 == null) {
                clsA203 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA203;
            }
            if (cls == clsA203) {
                return 10008;
            }
            Class clsA204 = x;
            if (clsA204 == null) {
                clsA204 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA204;
            }
            if (cls == clsA204) {
                return 10008;
            }
            Class clsA205 = y;
            if (clsA205 == null) {
                clsA205 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA205;
            }
            if (cls == clsA205) {
                return 10008;
            }
            Class clsA206 = z;
            if (clsA206 == null) {
                clsA206 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA206;
            }
            if (cls == clsA206) {
                return 10008;
            }
            Class clsA207 = A;
            if (clsA207 == null) {
                clsA207 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA207;
            }
            if (cls == clsA207) {
                return 10008;
            }
            Class clsA208 = B;
            if (clsA208 == null) {
                clsA208 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA208;
            }
            if (cls == clsA208) {
                return 20008;
            }
            Class clsA209 = C;
            if (clsA209 == null) {
                clsA209 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA209;
            }
            if (cls == clsA209) {
                return 20008;
            }
            Class clsA210 = D;
            if (clsA210 == null) {
                clsA210 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA210;
            }
            return cls == clsA210 ? 10008 : Integer.MAX_VALUE;
        }
        Class clsA211 = h;
        if (clsA211 == null) {
            clsA211 = a("java.math.BigInteger");
            h = clsA211;
        }
        if (cls2 == clsA211) {
            Class clsA212 = f21550b;
            if (clsA212 == null) {
                clsA212 = a("java.lang.Integer");
                f21550b = clsA212;
            }
            if (cls == clsA212) {
                return 10005;
            }
            Class clsA213 = i;
            if (clsA213 == null) {
                clsA213 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerBigDecimal");
                i = clsA213;
            }
            if (cls == clsA213) {
                return 10005;
            }
            Class clsA214 = f21549a;
            if (clsA214 == null) {
                clsA214 = a("java.math.BigDecimal");
                f21549a = clsA214;
            }
            if (cls == clsA214) {
                return 40005;
            }
            Class clsA215 = f21551c;
            if (clsA215 == null) {
                clsA215 = a("java.lang.Long");
                f21551c = clsA215;
            }
            if (cls == clsA215) {
                return 10005;
            }
            Class clsA216 = f21552d;
            if (clsA216 == null) {
                clsA216 = a("java.lang.Double");
                f21552d = clsA216;
            }
            if (cls == clsA216) {
                return Integer.MAX_VALUE;
            }
            Class clsA217 = f21553e;
            if (clsA217 == null) {
                clsA217 = a("java.lang.Float");
                f21553e = clsA217;
            }
            if (cls == clsA217) {
                return Integer.MAX_VALUE;
            }
            Class clsA218 = f21554f;
            if (clsA218 == null) {
                clsA218 = a("java.lang.Byte");
                f21554f = clsA218;
            }
            if (cls == clsA218) {
                return 10005;
            }
            Class clsA219 = j;
            if (clsA219 == null) {
                clsA219 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrInteger");
                j = clsA219;
            }
            if (cls == clsA219) {
                return 10005;
            }
            Class clsA220 = k;
            if (clsA220 == null) {
                clsA220 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrFloat");
                k = clsA220;
            }
            if (cls == clsA220) {
                return Integer.MAX_VALUE;
            }
            Class clsA221 = l;
            if (clsA221 == null) {
                clsA221 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrIntegerOrFloat");
                l = clsA221;
            }
            if (cls == clsA221) {
                return 21005;
            }
            Class clsA222 = m;
            if (clsA222 == null) {
                clsA222 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrInteger");
                m = clsA222;
            }
            if (cls == clsA222) {
                return 21005;
            }
            Class clsA223 = n;
            if (clsA223 == null) {
                clsA223 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrLong");
                n = clsA223;
            }
            if (cls == clsA223) {
                return 21005;
            }
            Class clsA224 = o;
            if (clsA224 == null) {
                clsA224 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrByte");
                o = clsA224;
            }
            if (cls == clsA224) {
                return 10005;
            }
            Class clsA225 = p;
            if (clsA225 == null) {
                clsA225 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrByte");
                p = clsA225;
            }
            if (cls == clsA225) {
                return 21005;
            }
            Class clsA226 = q;
            if (clsA226 == null) {
                clsA226 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrByte");
                q = clsA226;
            }
            if (cls == clsA226) {
                return 10005;
            }
            Class clsA227 = g;
            if (clsA227 == null) {
                clsA227 = a("java.lang.Short");
                g = clsA227;
            }
            if (cls == clsA227) {
                return 10005;
            }
            Class clsA228 = r;
            if (clsA228 == null) {
                clsA228 = a("freemarker.ext.beans.OverloadedNumberUtil$LongOrShort");
                r = clsA228;
            }
            if (cls == clsA228) {
                return 10005;
            }
            Class clsA229 = s;
            if (clsA229 == null) {
                clsA229 = a("freemarker.ext.beans.OverloadedNumberUtil$ShortOrByte");
                s = clsA229;
            }
            if (cls == clsA229) {
                return 10005;
            }
            Class clsA230 = t;
            if (clsA230 == null) {
                clsA230 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrInteger");
                t = clsA230;
            }
            if (cls == clsA230) {
                return 25005;
            }
            Class clsA231 = u;
            if (clsA231 == null) {
                clsA231 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrByte");
                u = clsA231;
            }
            if (cls == clsA231) {
                return 25005;
            }
            Class clsA232 = v;
            if (clsA232 == null) {
                clsA232 = a("freemarker.ext.beans.OverloadedNumberUtil$FloatOrShort");
                v = clsA232;
            }
            if (cls == clsA232) {
                return 25005;
            }
            Class clsA233 = w;
            if (clsA233 == null) {
                clsA233 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrInteger");
                w = clsA233;
            }
            if (cls == clsA233) {
                return 0;
            }
            Class clsA234 = x;
            if (clsA234 == null) {
                clsA234 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrLong");
                x = clsA234;
            }
            if (cls == clsA234) {
                return 0;
            }
            Class clsA235 = y;
            if (clsA235 == null) {
                clsA235 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrDouble");
                y = clsA235;
            }
            if (cls == clsA235) {
                return 0;
            }
            Class clsA236 = z;
            if (clsA236 == null) {
                clsA236 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrFloat");
                z = clsA236;
            }
            if (cls == clsA236) {
                return 0;
            }
            Class clsA237 = A;
            if (clsA237 == null) {
                clsA237 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrByte");
                A = clsA237;
            }
            if (cls == clsA237) {
                return 0;
            }
            Class clsA238 = B;
            if (clsA238 == null) {
                clsA238 = a("freemarker.ext.beans.OverloadedNumberUtil$IntegerOrShort");
                B = clsA238;
            }
            if (cls == clsA238) {
                return 10005;
            }
            Class clsA239 = C;
            if (clsA239 == null) {
                clsA239 = a("freemarker.ext.beans.OverloadedNumberUtil$DoubleOrShort");
                C = clsA239;
            }
            if (cls == clsA239) {
                return 21005;
            }
            Class clsA240 = D;
            if (clsA240 == null) {
                clsA240 = a("freemarker.ext.beans.OverloadedNumberUtil$BigIntegerOrShort");
                D = clsA240;
            }
            if (cls == clsA240) {
                return 0;
            }
        }
        return Integer.MAX_VALUE;
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static int a(Class cls, Class cls2) throws Throwable {
        Class clsC = freemarker.template.utility.a.c(cls);
        Class clsC2 = freemarker.template.utility.a.c(cls2);
        if (clsC == clsC2) {
            return 0;
        }
        Class clsA = f21550b;
        if (clsA == null) {
            clsA = a("java.lang.Integer");
            f21550b = clsA;
        }
        if (clsC == clsA) {
            Class clsA2 = f21551c;
            if (clsA2 == null) {
                clsA2 = a("java.lang.Long");
                f21551c = clsA2;
            }
            if (clsC2 == clsA2) {
                return 1;
            }
            Class clsA3 = f21552d;
            if (clsA3 == null) {
                clsA3 = a("java.lang.Double");
                f21552d = clsA3;
            }
            if (clsC2 == clsA3) {
                return 4;
            }
            Class clsA4 = f21553e;
            if (clsA4 == null) {
                clsA4 = a("java.lang.Float");
                f21553e = clsA4;
            }
            if (clsC2 == clsA4) {
                return 3;
            }
            Class clsA5 = f21554f;
            if (clsA5 == null) {
                clsA5 = a("java.lang.Byte");
                f21554f = clsA5;
            }
            if (clsC2 == clsA5) {
                return -2;
            }
            Class clsA6 = g;
            if (clsA6 == null) {
                clsA6 = a("java.lang.Short");
                g = clsA6;
            }
            if (clsC2 == clsA6) {
                return -1;
            }
            Class clsA7 = f21549a;
            if (clsA7 == null) {
                clsA7 = a("java.math.BigDecimal");
                f21549a = clsA7;
            }
            if (clsC2 == clsA7) {
                return 5;
            }
            Class clsA8 = h;
            if (clsA8 == null) {
                clsA8 = a("java.math.BigInteger");
                h = clsA8;
            }
            return clsC2 == clsA8 ? 2 : 0;
        }
        Class clsA9 = f21551c;
        if (clsA9 == null) {
            clsA9 = a("java.lang.Long");
            f21551c = clsA9;
        }
        if (clsC == clsA9) {
            Class clsA10 = f21550b;
            if (clsA10 == null) {
                clsA10 = a("java.lang.Integer");
                f21550b = clsA10;
            }
            if (clsC2 == clsA10) {
                return -1;
            }
            Class clsA11 = f21552d;
            if (clsA11 == null) {
                clsA11 = a("java.lang.Double");
                f21552d = clsA11;
            }
            if (clsC2 == clsA11) {
                return 3;
            }
            Class clsA12 = f21553e;
            if (clsA12 == null) {
                clsA12 = a("java.lang.Float");
                f21553e = clsA12;
            }
            if (clsC2 == clsA12) {
                return 2;
            }
            Class clsA13 = f21554f;
            if (clsA13 == null) {
                clsA13 = a("java.lang.Byte");
                f21554f = clsA13;
            }
            if (clsC2 == clsA13) {
                return -3;
            }
            Class clsA14 = g;
            if (clsA14 == null) {
                clsA14 = a("java.lang.Short");
                g = clsA14;
            }
            if (clsC2 == clsA14) {
                return -2;
            }
            Class clsA15 = f21549a;
            if (clsA15 == null) {
                clsA15 = a("java.math.BigDecimal");
                f21549a = clsA15;
            }
            if (clsC2 == clsA15) {
                return 4;
            }
            Class clsA16 = h;
            if (clsA16 == null) {
                clsA16 = a("java.math.BigInteger");
                h = clsA16;
            }
            return clsC2 == clsA16 ? 1 : 0;
        }
        Class clsA17 = f21552d;
        if (clsA17 == null) {
            clsA17 = a("java.lang.Double");
            f21552d = clsA17;
        }
        if (clsC == clsA17) {
            Class clsA18 = f21550b;
            if (clsA18 == null) {
                clsA18 = a("java.lang.Integer");
                f21550b = clsA18;
            }
            if (clsC2 == clsA18) {
                return -4;
            }
            Class clsA19 = f21551c;
            if (clsA19 == null) {
                clsA19 = a("java.lang.Long");
                f21551c = clsA19;
            }
            if (clsC2 == clsA19) {
                return -3;
            }
            Class clsA20 = f21553e;
            if (clsA20 == null) {
                clsA20 = a("java.lang.Float");
                f21553e = clsA20;
            }
            if (clsC2 == clsA20) {
                return -1;
            }
            Class clsA21 = f21554f;
            if (clsA21 == null) {
                clsA21 = a("java.lang.Byte");
                f21554f = clsA21;
            }
            if (clsC2 == clsA21) {
                return -6;
            }
            Class clsA22 = g;
            if (clsA22 == null) {
                clsA22 = a("java.lang.Short");
                g = clsA22;
            }
            if (clsC2 == clsA22) {
                return -5;
            }
            Class clsA23 = f21549a;
            if (clsA23 == null) {
                clsA23 = a("java.math.BigDecimal");
                f21549a = clsA23;
            }
            if (clsC2 == clsA23) {
                return 1;
            }
            Class clsA24 = h;
            if (clsA24 == null) {
                clsA24 = a("java.math.BigInteger");
                h = clsA24;
            }
            return clsC2 == clsA24 ? -2 : 0;
        }
        Class clsA25 = f21553e;
        if (clsA25 == null) {
            clsA25 = a("java.lang.Float");
            f21553e = clsA25;
        }
        if (clsC == clsA25) {
            Class clsA26 = f21550b;
            if (clsA26 == null) {
                clsA26 = a("java.lang.Integer");
                f21550b = clsA26;
            }
            if (clsC2 == clsA26) {
                return -3;
            }
            Class clsA27 = f21551c;
            if (clsA27 == null) {
                clsA27 = a("java.lang.Long");
                f21551c = clsA27;
            }
            if (clsC2 == clsA27) {
                return -2;
            }
            Class clsA28 = f21552d;
            if (clsA28 == null) {
                clsA28 = a("java.lang.Double");
                f21552d = clsA28;
            }
            if (clsC2 == clsA28) {
                return 1;
            }
            Class clsA29 = f21554f;
            if (clsA29 == null) {
                clsA29 = a("java.lang.Byte");
                f21554f = clsA29;
            }
            if (clsC2 == clsA29) {
                return -5;
            }
            Class clsA30 = g;
            if (clsA30 == null) {
                clsA30 = a("java.lang.Short");
                g = clsA30;
            }
            if (clsC2 == clsA30) {
                return -4;
            }
            Class clsA31 = f21549a;
            if (clsA31 == null) {
                clsA31 = a("java.math.BigDecimal");
                f21549a = clsA31;
            }
            if (clsC2 == clsA31) {
                return 2;
            }
            Class clsA32 = h;
            if (clsA32 == null) {
                clsA32 = a("java.math.BigInteger");
                h = clsA32;
            }
            return clsC2 == clsA32 ? -1 : 0;
        }
        Class clsA33 = f21554f;
        if (clsA33 == null) {
            clsA33 = a("java.lang.Byte");
            f21554f = clsA33;
        }
        if (clsC == clsA33) {
            Class clsA34 = f21550b;
            if (clsA34 == null) {
                clsA34 = a("java.lang.Integer");
                f21550b = clsA34;
            }
            if (clsC2 == clsA34) {
                return 2;
            }
            Class clsA35 = f21551c;
            if (clsA35 == null) {
                clsA35 = a("java.lang.Long");
                f21551c = clsA35;
            }
            if (clsC2 == clsA35) {
                return 3;
            }
            Class clsA36 = f21552d;
            if (clsA36 == null) {
                clsA36 = a("java.lang.Double");
                f21552d = clsA36;
            }
            if (clsC2 == clsA36) {
                return 6;
            }
            Class clsA37 = f21553e;
            if (clsA37 == null) {
                clsA37 = a("java.lang.Float");
                f21553e = clsA37;
            }
            if (clsC2 == clsA37) {
                return 5;
            }
            Class clsA38 = g;
            if (clsA38 == null) {
                clsA38 = a("java.lang.Short");
                g = clsA38;
            }
            if (clsC2 == clsA38) {
                return 1;
            }
            Class clsA39 = f21549a;
            if (clsA39 == null) {
                clsA39 = a("java.math.BigDecimal");
                f21549a = clsA39;
            }
            if (clsC2 == clsA39) {
                return 7;
            }
            Class clsA40 = h;
            if (clsA40 == null) {
                clsA40 = a("java.math.BigInteger");
                h = clsA40;
            }
            return clsC2 == clsA40 ? 4 : 0;
        }
        Class clsA41 = g;
        if (clsA41 == null) {
            clsA41 = a("java.lang.Short");
            g = clsA41;
        }
        if (clsC == clsA41) {
            Class clsA42 = f21550b;
            if (clsA42 == null) {
                clsA42 = a("java.lang.Integer");
                f21550b = clsA42;
            }
            if (clsC2 == clsA42) {
                return 1;
            }
            Class clsA43 = f21551c;
            if (clsA43 == null) {
                clsA43 = a("java.lang.Long");
                f21551c = clsA43;
            }
            if (clsC2 == clsA43) {
                return 2;
            }
            Class clsA44 = f21552d;
            if (clsA44 == null) {
                clsA44 = a("java.lang.Double");
                f21552d = clsA44;
            }
            if (clsC2 == clsA44) {
                return 5;
            }
            Class clsA45 = f21553e;
            if (clsA45 == null) {
                clsA45 = a("java.lang.Float");
                f21553e = clsA45;
            }
            if (clsC2 == clsA45) {
                return 4;
            }
            Class clsA46 = f21554f;
            if (clsA46 == null) {
                clsA46 = a("java.lang.Byte");
                f21554f = clsA46;
            }
            if (clsC2 == clsA46) {
                return -1;
            }
            Class clsA47 = f21549a;
            if (clsA47 == null) {
                clsA47 = a("java.math.BigDecimal");
                f21549a = clsA47;
            }
            if (clsC2 == clsA47) {
                return 6;
            }
            Class clsA48 = h;
            if (clsA48 == null) {
                clsA48 = a("java.math.BigInteger");
                h = clsA48;
            }
            return clsC2 == clsA48 ? 3 : 0;
        }
        Class clsA49 = f21549a;
        if (clsA49 == null) {
            clsA49 = a("java.math.BigDecimal");
            f21549a = clsA49;
        }
        if (clsC == clsA49) {
            Class clsA50 = f21550b;
            if (clsA50 == null) {
                clsA50 = a("java.lang.Integer");
                f21550b = clsA50;
            }
            if (clsC2 == clsA50) {
                return -5;
            }
            Class clsA51 = f21551c;
            if (clsA51 == null) {
                clsA51 = a("java.lang.Long");
                f21551c = clsA51;
            }
            if (clsC2 == clsA51) {
                return -4;
            }
            Class clsA52 = f21552d;
            if (clsA52 == null) {
                clsA52 = a("java.lang.Double");
                f21552d = clsA52;
            }
            if (clsC2 == clsA52) {
                return -1;
            }
            Class clsA53 = f21553e;
            if (clsA53 == null) {
                clsA53 = a("java.lang.Float");
                f21553e = clsA53;
            }
            if (clsC2 == clsA53) {
                return -2;
            }
            Class clsA54 = f21554f;
            if (clsA54 == null) {
                clsA54 = a("java.lang.Byte");
                f21554f = clsA54;
            }
            if (clsC2 == clsA54) {
                return -7;
            }
            Class clsA55 = g;
            if (clsA55 == null) {
                clsA55 = a("java.lang.Short");
                g = clsA55;
            }
            if (clsC2 == clsA55) {
                return -6;
            }
            Class clsA56 = h;
            if (clsA56 == null) {
                clsA56 = a("java.math.BigInteger");
                h = clsA56;
            }
            return clsC2 == clsA56 ? -3 : 0;
        }
        Class clsA57 = h;
        if (clsA57 == null) {
            clsA57 = a("java.math.BigInteger");
            h = clsA57;
        }
        if (clsC == clsA57) {
            Class clsA58 = f21550b;
            if (clsA58 == null) {
                clsA58 = a("java.lang.Integer");
                f21550b = clsA58;
            }
            if (clsC2 == clsA58) {
                return -2;
            }
            Class clsA59 = f21551c;
            if (clsA59 == null) {
                clsA59 = a("java.lang.Long");
                f21551c = clsA59;
            }
            if (clsC2 == clsA59) {
                return -1;
            }
            Class clsA60 = f21552d;
            if (clsA60 == null) {
                clsA60 = a("java.lang.Double");
                f21552d = clsA60;
            }
            if (clsC2 == clsA60) {
                return 2;
            }
            Class clsA61 = f21553e;
            if (clsA61 == null) {
                clsA61 = a("java.lang.Float");
                f21553e = clsA61;
            }
            if (clsC2 == clsA61) {
                return 1;
            }
            Class clsA62 = f21554f;
            if (clsA62 == null) {
                clsA62 = a("java.lang.Byte");
                f21554f = clsA62;
            }
            if (clsC2 == clsA62) {
                return -4;
            }
            Class clsA63 = g;
            if (clsA63 == null) {
                clsA63 = a("java.lang.Short");
                g = clsA63;
            }
            if (clsC2 == clsA63) {
                return -3;
            }
            Class clsA64 = f21549a;
            if (clsA64 == null) {
                clsA64 = a("java.math.BigDecimal");
                f21549a = clsA64;
            }
            if (clsC2 == clsA64) {
                return 3;
            }
        }
        return 0;
    }
}
