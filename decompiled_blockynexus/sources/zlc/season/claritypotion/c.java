package zlc.season.claritypotion;

import android.app.Activity;
import android.app.Application;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;

/* JADX INFO: compiled from: ActivityTracker.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<WeakReference<Activity>> f23649a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f23650b = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Activity activity) {
        if (!i.a(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Must in Main Thread!");
        }
        a(this.f23649a, activity);
    }

    public final void a(Application application) {
        i.b(application, "application");
        application.registerActivityLifecycleCallbacks(this.f23650b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Activity activity) {
        if (i.a(Looper.myLooper(), Looper.getMainLooper())) {
            this.f23649a.add(new WeakReference<>(activity));
            return;
        }
        throw new IllegalStateException("Must in Main Thread!");
    }

    private final <T> void a(List<WeakReference<T>> list, T t) {
        T next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            } else {
                next = it.next();
                if (((WeakReference) next).get() == t) {
                    break;
                }
            }
        }
        WeakReference weakReference = next;
        if (list == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
        n.a(list).remove(weakReference);
    }
}
