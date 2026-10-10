package com.disabngo.blockynexus.databinding;

import androidx.databinding.ObservableField;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.lf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentSecretQuestionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
class C0645lf implements androidx.databinding.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0667nf f8555a;

    C0645lf(C0667nf c0667nf) {
        this.f8555a = c0667nf;
    }

    @Override // androidx.databinding.f
    public void a() {
        String strA = androidx.databinding.a.e.a(this.f8555a.m);
        com.disabngo.blockynexus.e.b.fa.l lVar = this.f8555a.g;
        if (lVar != null) {
            ObservableField<String> observableField = lVar.k;
            if (observableField != null) {
                observableField.set(strA);
            }
        }
    }
}
