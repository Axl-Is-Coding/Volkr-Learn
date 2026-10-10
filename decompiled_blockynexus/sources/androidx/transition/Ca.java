package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: Visibility.java */
/* JADX INFO: loaded from: classes.dex */
class Ca extends C0379ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f2130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f2131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f2132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Visibility f2133d;

    Ca(Visibility visibility, ViewGroup viewGroup, View view, View view2) {
        this.f2133d = visibility;
        this.f2130a = viewGroup;
        this.f2131b = view;
        this.f2132c = view2;
    }

    @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
    public void a(Transition transition) {
        if (this.f2131b.getParent() == null) {
            na.a(this.f2130a).a(this.f2131b);
        } else {
            this.f2133d.cancel();
        }
    }

    @Override // androidx.transition.C0379ba, androidx.transition.Transition.c
    public void c(Transition transition) {
        na.a(this.f2130a).b(this.f2131b);
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        this.f2132c.setTag(R.id.save_overlay_view, null);
        na.a(this.f2130a).b(this.f2131b);
        transition.b(this);
    }
}
