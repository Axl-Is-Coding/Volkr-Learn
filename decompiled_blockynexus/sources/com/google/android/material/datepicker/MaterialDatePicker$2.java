package com.google.android.material.datepicker;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class MaterialDatePicker$2 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f13288a;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Iterator it = this.f13288a.f13332e.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
        this.f13288a.dismiss();
    }
}
