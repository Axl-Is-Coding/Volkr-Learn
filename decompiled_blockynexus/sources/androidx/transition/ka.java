package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ViewGroupOverlayApi14.java */
/* JADX INFO: loaded from: classes.dex */
class ka extends qa implements ma {
    ka(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static ka a(ViewGroup viewGroup) {
        return (ka) qa.c(viewGroup);
    }

    @Override // androidx.transition.ma
    public void b(View view) {
        this.f2282a.b(view);
    }

    @Override // androidx.transition.ma
    public void a(View view) {
        this.f2282a.a(view);
    }
}
