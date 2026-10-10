package com.google.gson;

import com.google.gson.internal.C2271a;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f14261a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f14262b;

    public t(Boolean bool) {
        a(bool);
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f14261a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            this.f14262b = String.valueOf(((Character) obj).charValue());
        } else {
            C2271a.a((obj instanceof Number) || b(obj));
            this.f14262b = obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f14262b == null) {
            return tVar.f14262b == null;
        }
        if (a(this) && a(tVar)) {
            return q().longValue() == tVar.q().longValue();
        }
        if (!(this.f14262b instanceof Number) || !(tVar.f14262b instanceof Number)) {
            return this.f14262b.equals(tVar.f14262b);
        }
        double dDoubleValue = q().doubleValue();
        double dDoubleValue2 = tVar.q().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.p
    public String h() {
        return s() ? q().toString() : r() ? n().toString() : (String) this.f14262b;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f14262b == null) {
            return 31;
        }
        if (a(this)) {
            jDoubleToLongBits = q().longValue();
        } else {
            Object obj = this.f14262b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(q().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean m() {
        return r() ? n().booleanValue() : Boolean.parseBoolean(h());
    }

    Boolean n() {
        return (Boolean) this.f14262b;
    }

    public double o() {
        return s() ? q().doubleValue() : Double.parseDouble(h());
    }

    public long p() {
        return s() ? q().longValue() : Long.parseLong(h());
    }

    public Number q() {
        Object obj = this.f14262b;
        return obj instanceof String ? new LazilyParsedNumber((String) obj) : (Number) obj;
    }

    public boolean r() {
        return this.f14262b instanceof Boolean;
    }

    public boolean s() {
        return this.f14262b instanceof Number;
    }

    public boolean t() {
        return this.f14262b instanceof String;
    }

    public t(Number number) {
        a(number);
    }

    public t(String str) {
        a(str);
    }

    t(Object obj) {
        a(obj);
    }

    @Override // com.google.gson.p
    public int a() {
        return s() ? q().intValue() : Integer.parseInt(h());
    }

    private static boolean a(t tVar) {
        Object obj = tVar.f14262b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }
}
