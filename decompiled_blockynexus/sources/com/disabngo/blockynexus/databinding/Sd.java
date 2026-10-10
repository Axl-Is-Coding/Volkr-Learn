package com.disabngo.blockynexus.databinding;

import androidx.databinding.ObservableField;

/* JADX INFO: compiled from: FragmentForgetPasswordByEmailOrQuestionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
class Sd implements androidx.databinding.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Td f7870a;

    Sd(Td td) {
        this.f7870a = td;
    }

    @Override // androidx.databinding.f
    public void a() {
        String strA = androidx.databinding.a.e.a(this.f7870a.f7833a);
        com.disabngo.blockynexus.e.b.w.h hVar = this.f7870a.f7837e;
        if (hVar != null) {
            ObservableField<String> observableField = hVar.g;
            if (observableField != null) {
                observableField.set(strA);
            }
        }
    }
}
