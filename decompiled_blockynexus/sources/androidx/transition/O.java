package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: compiled from: Scene.java */
/* JADX INFO: loaded from: classes.dex */
public class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f2182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f2183b;

    public void a() {
        Runnable runnable;
        if (a(this.f2182a) != this || (runnable = this.f2183b) == null) {
            return;
        }
        runnable.run();
    }

    static void a(ViewGroup viewGroup, O o) {
        viewGroup.setTag(R.id.transition_current_scene, o);
    }

    public static O a(ViewGroup viewGroup) {
        return (O) viewGroup.getTag(R.id.transition_current_scene);
    }
}
