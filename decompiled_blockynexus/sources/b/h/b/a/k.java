package b.h.b.a;

import android.app.Activity;
import android.content.Context;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: compiled from: GameResCopy.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2796a = "updateRes.tar.gz";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f2798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2799d;

    /* JADX INFO: compiled from: GameResCopy.java */
    class a implements Runnable {
        a() {
        }

        public /* synthetic */ void a() {
            k.this.f2798c.e();
        }

        public /* synthetic */ void b() {
            k.this.f2798c.c();
        }

        public /* synthetic */ void c() {
            k.this.f2798c.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (157286400 >= CommonHelper.getLessMemorySize()) {
                ((Activity) k.this.f2797b).runOnUiThread(new Runnable() { // from class: b.h.b.a.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2787a.c();
                    }
                });
                return;
            }
            int iA = k.this.a();
            int iB = k.this.b();
            int iC = k.this.c();
            if (iA == -1 || iB == -1 || iC == -1) {
                ((Activity) k.this.f2797b).runOnUiThread(new Runnable() { // from class: b.h.b.a.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2789a.b();
                    }
                });
            } else if (k.this.f2797b instanceof Activity) {
                ((Activity) k.this.f2797b).runOnUiThread(new Runnable() { // from class: b.h.b.a.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2788a.a();
                    }
                });
            } else {
                k.this.f2798c.e();
            }
        }
    }

    public k(Context context, String str, h hVar) {
        ReportDataAdapter.onEvent(context, ReportEvent.APP_SOURCE_CHECK_START);
        this.f2797b = context;
        this.f2798c = hVar;
        this.f2799d = str;
        BaseApplication.getThreadPool().setName("game-res-copy-engine");
        BaseApplication.getThreadPool().execute(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        return new l(this.f2797b, this.f2799d, 1, this.f2798c).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        return new l(this.f2797b, this.f2799d, 2, this.f2798c).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        return new l(this.f2797b, this.f2799d, 3, this.f2798c).a();
    }
}
