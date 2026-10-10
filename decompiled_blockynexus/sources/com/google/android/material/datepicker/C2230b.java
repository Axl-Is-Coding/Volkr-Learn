package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.material.datepicker.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CalendarConstraints.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2230b implements Parcelable {
    public static final Parcelable.Creator<C2230b> CREATOR = new C2229a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f13292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f13293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u f13294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f13295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f13297f;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.b$a */
    /* JADX INFO: compiled from: CalendarConstraints.java */
    public interface a extends Parcelable {
        boolean b(long j);
    }

    /* synthetic */ C2230b(u uVar, u uVar2, u uVar3, a aVar, C2229a c2229a) {
        this(uVar, uVar2, uVar3, aVar);
    }

    public a a() {
        return this.f13295d;
    }

    u b() {
        return this.f13293b;
    }

    int c() {
        return this.f13297f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    u e() {
        return this.f13294c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2230b)) {
            return false;
        }
        C2230b c2230b = (C2230b) obj;
        return this.f13292a.equals(c2230b.f13292a) && this.f13293b.equals(c2230b.f13293b) && this.f13294c.equals(c2230b.f13294c) && this.f13295d.equals(c2230b.f13295d);
    }

    u f() {
        return this.f13292a;
    }

    int h() {
        return this.f13296e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f13292a, this.f13293b, this.f13294c, this.f13295d});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f13292a, 0);
        parcel.writeParcelable(this.f13293b, 0);
        parcel.writeParcelable(this.f13294c, 0);
        parcel.writeParcelable(this.f13295d, 0);
    }

    private C2230b(u uVar, u uVar2, u uVar3, a aVar) {
        this.f13292a = uVar;
        this.f13293b = uVar2;
        this.f13294c = uVar3;
        this.f13295d = aVar;
        if (uVar.compareTo(uVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (uVar3.compareTo(uVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f13297f = uVar.b(uVar2) + 1;
        this.f13296e = (uVar2.f13340d - uVar.f13340d) + 1;
    }
}
