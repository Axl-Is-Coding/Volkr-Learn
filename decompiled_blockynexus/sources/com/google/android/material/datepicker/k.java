package com.google.android.material.datepicker;

import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements MaterialCalendar.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MaterialCalendar f13319a;

    k(MaterialCalendar materialCalendar) {
        this.f13319a = materialCalendar;
    }

    @Override // com.google.android.material.datepicker.MaterialCalendar.a
    public void a(long j) {
        if (this.f13319a.h.a().b(j)) {
            this.f13319a.g.d(j);
            Iterator it = this.f13319a.f13356a.iterator();
            while (it.hasNext()) {
                ((y) it.next()).a(this.f13319a.g.C());
            }
            this.f13319a.m.getAdapter().notifyDataSetChanged();
            if (this.f13319a.l != null) {
                this.f13319a.l.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
