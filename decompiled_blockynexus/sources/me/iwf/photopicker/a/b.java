package me.iwf.photopicker.a;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import me.iwf.photopicker.R;

/* JADX INFO: compiled from: RecyclerItemClickListener.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f22891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    GestureDetector f22892b;

    /* JADX INFO: compiled from: RecyclerItemClickListener.java */
    public interface a {
        void a(View view, int i);
    }

    public b(Context context, a aVar) {
        this.f22891a = aVar;
        this.f22892b = new GestureDetector(context, new me.iwf.photopicker.a.a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (viewFindChildViewUnder == null || this.f22891a == null || !this.f22892b.onTouchEvent(motionEvent)) {
            return false;
        }
        if (!(viewFindChildViewUnder instanceof ViewGroup)) {
            return true;
        }
        View viewFindViewById = viewFindChildViewUnder.findViewById(R.id.iv_photo);
        View viewFindViewById2 = viewFindChildViewUnder.findViewById(R.id.iv_cancel);
        if (viewFindViewById == null || viewFindViewById2 == null) {
            this.f22891a.a(viewFindChildViewUnder, recyclerView.getChildLayoutPosition(viewFindChildViewUnder));
            return true;
        }
        if (motionEvent.getX() >= viewFindChildViewUnder.getRight() || motionEvent.getX() <= viewFindChildViewUnder.getRight() - viewFindViewById2.getWidth() || motionEvent.getY() <= viewFindChildViewUnder.getTop() || motionEvent.getY() >= viewFindChildViewUnder.getTop() + viewFindViewById2.getHeight()) {
            this.f22891a.a(viewFindViewById, recyclerView.getChildLayoutPosition(viewFindChildViewUnder));
            return true;
        }
        this.f22891a.a(viewFindViewById2, recyclerView.getChildLayoutPosition(viewFindChildViewUnder));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
