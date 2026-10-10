package me.iwf.photopicker.a;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: RecyclerItemClickListener.java */
/* JADX INFO: loaded from: classes5.dex */
class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f22890a;

    a(b bVar) {
        this.f22890a = bVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
