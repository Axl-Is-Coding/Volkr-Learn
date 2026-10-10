package com.google.android.material.datepicker;

import android.view.View;
import androidx.core.view.C0313a;
import com.google.android.material.R;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends C0313a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MaterialCalendar f13323d;

    m(MaterialCalendar materialCalendar) {
        this.f13323d = materialCalendar;
    }

    @Override // androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        bVar.e(this.f13323d.o.getVisibility() == 0 ? this.f13323d.getString(R.string.mtrl_picker_toggle_to_year_selection) : this.f13323d.getString(R.string.mtrl_picker_toggle_to_day_selection));
    }
}
