package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SmoothCalendarLayoutManager.java */
/* JADX INFO: loaded from: classes2.dex */
class B extends LinearLayoutManager {
    B(Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.t tVar, int i) {
        A a2 = new A(this, recyclerView.getContext());
        a2.setTargetPosition(i);
        startSmoothScroll(a2);
    }
}
