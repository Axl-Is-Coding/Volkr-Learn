package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: Month.java */
/* JADX INFO: loaded from: classes2.dex */
final class u implements Comparable<u>, Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f13337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f13339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f13340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f13341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f13342f;
    final long g;

    private u(Calendar calendar) {
        calendar.set(5, 1);
        this.f13337a = C.a(calendar);
        this.f13339c = this.f13337a.get(2);
        this.f13340d = this.f13337a.get(1);
        this.f13341e = this.f13337a.getMaximum(7);
        this.f13342f = this.f13337a.getActualMaximum(5);
        this.f13338b = C.c().format(this.f13337a.getTime());
        this.g = this.f13337a.getTimeInMillis();
    }

    static u a(int i, int i2) {
        Calendar calendarB = C.b();
        calendarB.set(1, i);
        calendarB.set(2, i2);
        return new u(calendarB);
    }

    static u e() {
        return new u(C.a());
    }

    int b(u uVar) {
        if (this.f13337a instanceof GregorianCalendar) {
            return ((uVar.f13340d - this.f13340d) * 12) + (uVar.f13339c - this.f13339c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    long c() {
        return this.f13337a.getTimeInMillis();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f13339c == uVar.f13339c && this.f13340d == uVar.f13340d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f13339c), Integer.valueOf(this.f13340d)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13340d);
        parcel.writeInt(this.f13339c);
    }

    u c(int i) {
        Calendar calendarA = C.a(this.f13337a);
        calendarA.add(2, i);
        return new u(calendarA);
    }

    long b(int i) {
        Calendar calendarA = C.a(this.f13337a);
        calendarA.set(5, i);
        return calendarA.getTimeInMillis();
    }

    int a() {
        int firstDayOfWeek = this.f13337a.get(7) - this.f13337a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f13341e : firstDayOfWeek;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        return this.f13337a.compareTo(uVar.f13337a);
    }

    String b() {
        return this.f13338b;
    }
}
