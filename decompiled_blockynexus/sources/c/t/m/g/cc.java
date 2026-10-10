package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import c.t.m.g.qc;
import io.rong.imageloader.core.download.BaseImageDownloader;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class cc implements InterfaceC0418d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ac f3103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3106d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3108f;
    protected AbstractC0442l i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3107e = 5000;
    private int g = 0;
    protected AtomicInteger h = new AtomicInteger(0);

    public cc(ac acVar) {
        this.f3103a = acVar;
        String str = acVar.f3086a;
        this.f3104b = str;
        this.f3105c = str;
        this.f3106d = acVar.f3091f;
        this.f3108f = SystemClock.elapsedRealtime();
    }

    public C0457q a() {
        C0457q c0457qA;
        try {
            this.f3107e = qc.a.a("app_http_proxy_timeout", 0, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, 5000);
            if (this.f3106d <= 0) {
                this.f3106d = qc.a.a("app_req_timeout", 1000, 1000000, 15000);
            }
            if (this.f3103a.m > 0 && this.f3103a.m < this.f3106d) {
                this.f3106d = this.f3103a.m;
            }
            int i = this.f3106d;
            while (true) {
                c0457qA = a(i);
                int iA = C0455pa.a((int) (((long) this.f3106d) - (SystemClock.elapsedRealtime() - this.f3108f)), this.f3106d);
                if (c0457qA.f3344a != 0 || c0457qA.f3346c < 300 || c0457qA.f3346c >= 400 || !this.f3103a.f3090e || iA <= 200) {
                    break;
                }
                String strA = c0457qA.a("location");
                if (TextUtils.isEmpty(strA)) {
                    c0457qA.f3344a = -6;
                    break;
                }
                this.f3105c = strA;
                this.g++;
                if (this.g > 5) {
                    c0457qA.f3344a = -5;
                    break;
                }
                this.i.a(true);
                i = iA;
            }
            boolean z = this.f3103a.j;
            if (this.f3103a.p) {
                this.i.j = true;
                this.i.i = true;
                this.i.k = this.f3103a.m;
            } else {
                this.i.k = SystemClock.elapsedRealtime() - this.f3108f;
            }
            this.i.a(false);
            return c0457qA;
        } catch (Throwable th) {
            th.printStackTrace();
            return new C0457q(-1, C0455pa.a(th));
        }
    }

    protected abstract C0457q a(int i);
}
