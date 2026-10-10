package com.google.android.material.datepicker;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class MaterialDatePicker$1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f13287a;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Iterator it = this.f13287a.f13331d.iterator();
        if (!it.hasNext()) {
            this.f13287a.dismiss();
        } else {
            this.f13287a.h();
            throw null;
        }
    }
}
