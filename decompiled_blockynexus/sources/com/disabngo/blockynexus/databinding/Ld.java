package com.disabngo.blockynexus.databinding;

import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.e.b.t.C0927f;

/* JADX INFO: compiled from: FragmentEnsureEmailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
class Ld implements androidx.databinding.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Md f7645a;

    Ld(Md md) {
        this.f7645a = md;
    }

    @Override // androidx.databinding.f
    public void a() {
        String strA = androidx.databinding.a.e.a(this.f7645a.f7607a);
        C0927f c0927f = this.f7645a.f7608b;
        if (c0927f != null) {
            ObservableField<String> observableField = c0927f.f10183e;
            if (observableField != null) {
                observableField.set(strA);
            }
        }
    }
}
