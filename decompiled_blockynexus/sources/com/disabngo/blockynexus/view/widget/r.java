package com.disabngo.blockynexus.view.widget;

import android.os.CountDownTimer;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: MainGuideView.java */
/* JADX INFO: loaded from: classes.dex */
class r extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainGuideView f12110a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r(MainGuideView mainGuideView, long j, long j2) {
        super(j, j2);
        this.f12110a = mainGuideView;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f12110a.main.setVisibility(8);
        this.f12110a.isShowGuide.set(false);
        ReportDataAdapter.onEvent(this.f12110a.getContext(), EventConstant.HOME_NOV_PASS);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
