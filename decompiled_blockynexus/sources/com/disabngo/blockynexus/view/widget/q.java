package com.disabngo.blockynexus.view.widget;

import androidx.databinding.Observable;

/* JADX INFO: compiled from: MainGuideView.java */
/* JADX INFO: loaded from: classes.dex */
class q extends Observable.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainGuideView f12109a;

    q(MainGuideView mainGuideView) {
        this.f12109a = mainGuideView;
    }

    @Override // androidx.databinding.Observable.a
    public void onPropertyChanged(Observable observable, int i) {
        if (((Boolean) this.f12109a.isShowGuide.get()).booleanValue()) {
            this.f12109a.initCountDownTimer();
        } else {
            this.f12109a.stopCountDownTimer();
        }
    }
}
