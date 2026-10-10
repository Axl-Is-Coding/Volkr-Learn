package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MaterialCalendar f13318b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(MaterialCalendar materialCalendar, Context context, int i, boolean z, int i2) {
        super(context, i, z);
        this.f13318b = materialCalendar;
        this.f13317a = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    protected void calculateExtraLayoutSpace(RecyclerView.t tVar, int[] iArr) {
        if (this.f13317a == 0) {
            iArr[0] = this.f13318b.m.getWidth();
            iArr[1] = this.f13318b.m.getWidth();
        } else {
            iArr[0] = this.f13318b.m.getHeight();
            iArr[1] = this.f13318b.m.getHeight();
        }
    }
}
