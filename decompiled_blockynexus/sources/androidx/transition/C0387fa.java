package androidx.transition;

/* JADX INFO: renamed from: androidx.transition.fa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TransitionSet.java */
/* JADX INFO: loaded from: classes.dex */
class C0387fa extends C0379ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Transition f2238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TransitionSet f2239b;

    C0387fa(TransitionSet transitionSet, Transition transition) {
        this.f2239b = transitionSet;
        this.f2238a = transition;
    }

    @Override // androidx.transition.Transition.c
    public void d(Transition transition) {
        this.f2238a.o();
        transition.b(this);
    }
}
