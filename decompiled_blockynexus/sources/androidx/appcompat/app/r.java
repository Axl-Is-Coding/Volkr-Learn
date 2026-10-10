package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.H;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class r extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f319a;

    r(s sVar) {
        this.f319a = sVar;
    }

    @Override // androidx.core.view.G
    public void b(View view) {
        this.f319a.f320a.u.setAlpha(1.0f);
        this.f319a.f320a.x.a((androidx.core.view.G) null);
        this.f319a.f320a.x = null;
    }

    @Override // androidx.core.view.H, androidx.core.view.G
    public void c(View view) {
        this.f319a.f320a.u.setVisibility(0);
    }
}
