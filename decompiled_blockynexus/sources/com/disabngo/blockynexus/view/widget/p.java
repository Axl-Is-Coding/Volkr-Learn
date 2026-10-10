package com.disabngo.blockynexus.view.widget;

import android.database.DataSetObserver;

/* JADX INFO: compiled from: LabelsView.java */
/* JADX INFO: loaded from: classes.dex */
class p extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LabelsView f12108a;

    p(LabelsView labelsView) {
        this.f12108a = labelsView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f12108a.notifyAdapter();
    }
}
