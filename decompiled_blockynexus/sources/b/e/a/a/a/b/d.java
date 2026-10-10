package b.e.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static d f2560a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2561b;

    private d() {
    }

    public static d a() {
        return f2560a;
    }

    public void a(Context context) {
        this.f2561b = context != null ? context.getApplicationContext() : null;
    }

    public Context b() {
        return this.f2561b;
    }
}
