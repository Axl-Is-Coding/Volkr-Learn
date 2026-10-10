package androidx.appcompat.app;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ActionBarDrawerToggle$1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0281a f197a;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0281a c0281a = this.f197a;
        if (c0281a.f282a) {
            c0281a.a();
            throw null;
        }
        View.OnClickListener onClickListener = c0281a.f283b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
