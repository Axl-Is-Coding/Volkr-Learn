package androidx.transition;

import android.animation.AnimatorListenerAdapter;
import androidx.transition.ChangeBounds;

/* JADX INFO: renamed from: androidx.transition.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0392j extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ChangeBounds.a f2253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ChangeBounds f2254b;
    private ChangeBounds.a mViewBounds;

    C0392j(ChangeBounds changeBounds, ChangeBounds.a aVar) {
        this.f2254b = changeBounds;
        this.f2253a = aVar;
        this.mViewBounds = this.f2253a;
    }
}
