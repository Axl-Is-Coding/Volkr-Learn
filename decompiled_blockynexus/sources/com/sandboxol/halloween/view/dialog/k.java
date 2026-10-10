package com.sandboxol.halloween.view.dialog;

import com.warkiz.widget.IndicatorSeekBar;

/* JADX INFO: compiled from: HalloweenCurrencyDialog.java */
/* JADX INFO: loaded from: classes4.dex */
class k implements com.warkiz.widget.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f18692a;

    k(m mVar) {
        this.f18692a = mVar;
    }

    @Override // com.warkiz.widget.h
    public void a(IndicatorSeekBar indicatorSeekBar) {
    }

    @Override // com.warkiz.widget.h
    public void a(com.warkiz.widget.i iVar) {
        m mVar = this.f18692a;
        mVar.g.set(Integer.valueOf(mVar.f18695b * iVar.f21392b));
    }

    @Override // com.warkiz.widget.h
    public void b(IndicatorSeekBar indicatorSeekBar) {
    }
}
