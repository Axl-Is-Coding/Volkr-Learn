package com.google.android.material.datepicker;

import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import io.rong.common.dlog.DLog;

/* JADX INFO: compiled from: MaterialCalendar.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends RecyclerView.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f13324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MaterialButton f13325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MaterialCalendar f13326c;

    n(MaterialCalendar materialCalendar, x xVar, MaterialButton materialButton) {
        this.f13326c = materialCalendar;
        this.f13324a = xVar;
        this.f13325b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            CharSequence text = this.f13325b.getText();
            if (Build.VERSION.SDK_INT >= 16) {
                recyclerView.announceForAccessibility(text);
            } else {
                recyclerView.sendAccessibilityEvent(DLog.CRS);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int iFindFirstVisibleItemPosition = i < 0 ? this.f13326c.k().findFirstVisibleItemPosition() : this.f13326c.k().findLastVisibleItemPosition();
        this.f13326c.i = this.f13324a.a(iFindFirstVisibleItemPosition);
        this.f13325b.setText(this.f13324a.b(iFindFirstVisibleItemPosition));
    }
}
