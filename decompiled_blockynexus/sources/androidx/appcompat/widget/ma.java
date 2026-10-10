package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: compiled from: ToolbarWidgetWrapper.java */
/* JADX INFO: loaded from: classes.dex */
class ma extends androidx.core.view.H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f669a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ToolbarWidgetWrapper f671c;

    ma(ToolbarWidgetWrapper toolbarWidgetWrapper, int i) {
        this.f671c = toolbarWidgetWrapper;
        this.f670b = i;
    }

    @Override // androidx.core.view.H, androidx.core.view.G
    public void a(View view) {
        this.f669a = true;
    }

    @Override // androidx.core.view.G
    public void b(View view) {
        if (this.f669a) {
            return;
        }
        this.f671c.f614a.setVisibility(this.f670b);
    }

    @Override // androidx.core.view.H, androidx.core.view.G
    public void c(View view) {
        this.f671c.f614a.setVisibility(0);
    }
}
