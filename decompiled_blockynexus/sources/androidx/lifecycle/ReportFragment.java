package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f1594a;

    interface a {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f1594a);
        a(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.f1594a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        b(this.f1594a);
        a(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.f1594a);
        a(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    private void a(Lifecycle.Event event) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof j) {
            ((j) activity).getLifecycle().b(event);
        } else if (activity instanceof g) {
            Lifecycle lifecycle = ((g) activity).getLifecycle();
            if (lifecycle instanceof i) {
                ((i) lifecycle).b(event);
            }
        }
    }
}
