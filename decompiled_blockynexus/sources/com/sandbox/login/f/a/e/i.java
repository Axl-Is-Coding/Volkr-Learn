package com.sandbox.login.f.a.e;

import android.content.Context;
import androidx.databinding.Observable;
import com.sandboxol.center.utils.DialogUtilsWrap;

/* JADX INFO: compiled from: AccountRecordItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ m f15858b;

    i(m mVar, Context context) {
        this.f15858b = mVar;
        this.f15857a = context;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        if (((Boolean) this.f15858b.f15863b.get()).booleanValue()) {
            DialogUtilsWrap.newsInstant().showLoadingDialog(this.f15857a);
        } else {
            DialogUtilsWrap.newsInstant().hideLoadingDialog();
        }
    }
}
