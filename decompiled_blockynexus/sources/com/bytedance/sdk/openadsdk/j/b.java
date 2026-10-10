package com.bytedance.sdk.openadsdk.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.just.agentweb.DefaultWebClient;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: TrackAdUrlImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.sdk.openadsdk.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f7006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f7007c = Executors.newSingleThreadExecutor();

    /* JADX INFO: compiled from: TrackAdUrlImpl.java */
    @SuppressLint({"StaticFieldLeak"})
    private class a extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f7012b;

        boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith(DefaultWebClient.HTTP_SCHEME) || str.startsWith(DefaultWebClient.HTTPS_SCHEME));
        }

        private a(f fVar) {
            this.f7012b = fVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            m mVar;
            if (!com.bytedance.sdk.openadsdk.core.g.g.a() || !a(this.f7012b.b())) {
                return null;
            }
            if (this.f7012b.c() == 0) {
                b.this.f7006b.c(this.f7012b);
                return null;
            }
            while (true) {
                if (this.f7012b.c() <= 0 || isCancelled()) {
                    break;
                }
                try {
                    if (this.f7012b.c() == 5) {
                        b.this.f7006b.a(this.f7012b);
                    }
                } catch (Throwable unused) {
                }
                if (!q.a(b.this.c())) {
                    break;
                }
                String strB = this.f7012b.b();
                i iVarA = i.a();
                new j(0, strB, iVarA).setRetryPolicy(com.bytedance.sdk.openadsdk.g.d.b().a(10000)).build(com.bytedance.sdk.openadsdk.g.d.a(b.this.c()).d());
                try {
                    mVar = iVarA.get();
                } catch (Throwable unused2) {
                    mVar = null;
                }
                if (mVar == null || !mVar.a()) {
                    if (o.c()) {
                        o.c("trackurl", "track fail : " + this.f7012b.b());
                    }
                    this.f7012b.a(this.f7012b.c() - 1);
                    if (this.f7012b.c() == 0) {
                        b.this.f7006b.c(this.f7012b);
                        if (o.c()) {
                            o.c("trackurl", "track fail and delete : " + this.f7012b.b());
                        }
                    } else {
                        b.this.f7006b.b(this.f7012b);
                    }
                } else {
                    b.this.f7006b.c(this.f7012b);
                    if (o.c()) {
                        o.c("trackurl", "track success : " + this.f7012b.b());
                    }
                }
            }
            return null;
        }
    }

    public b(Context context, g gVar) {
        this.f7005a = context;
        this.f7006b = gVar;
    }

    public static com.bytedance.sdk.openadsdk.j.a d() {
        return d.c();
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void b() {
        try {
            this.f7007c.shutdownNow();
        } catch (Throwable unused) {
        }
    }

    public Context c() {
        Context context = this.f7005a;
        return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<f> list) {
        if (com.bytedance.sdk.openadsdk.utils.m.b(list)) {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                new a(it.next()).executeOnExecutor(this.f7007c, new Void[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a(List<String> list) {
        if (com.bytedance.sdk.openadsdk.core.g.g.a() && com.bytedance.sdk.openadsdk.utils.m.b(list)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                new a(new f(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), 5)).executeOnExecutor(this.f7007c, new Void[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a() {
        this.f7007c.submit(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.b.1
            @Override // java.lang.Runnable
            public void run() {
                final List<f> listA = b.this.f7006b.a();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.j.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.b(listA);
                    }
                });
            }
        });
    }
}
