package zlc.season.claritypotion;

import android.app.Activity;
import android.os.Bundle;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: ActivityTracker.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f23648a;

    b(c cVar) {
        this.f23648a = cVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        i.b(activity, "activity");
        this.f23648a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        i.b(activity, "activity");
        this.f23648a.b(activity);
    }
}
