package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MaterialCalendarGridView f13348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ x f13349b;

    w(x xVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f13349b = xVar;
        this.f13348a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f13348a.getAdapter().e(i)) {
            this.f13349b.f13352c.a(this.f13348a.getAdapter().getItem(i).longValue());
        }
    }
}
