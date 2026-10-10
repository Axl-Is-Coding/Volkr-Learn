package b.e.a.a.a.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import io.rong.common.LibStorageUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f2545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f2547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2548e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f2544a = context;
        this.f2545b = (AudioManager) context.getSystemService(LibStorageUtils.AUDIO);
        this.f2546c = aVar;
        this.f2547d = cVar;
    }

    private boolean a(float f2) {
        return f2 != this.f2548e;
    }

    private float c() {
        return this.f2546c.a(this.f2545b.getStreamVolume(3), this.f2545b.getStreamMaxVolume(3));
    }

    private void d() {
        this.f2547d.a(this.f2548e);
    }

    public void a() {
        this.f2548e = c();
        d();
        this.f2544a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void b() {
        this.f2544a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        super.onChange(z);
        float fC = c();
        if (a(fC)) {
            this.f2548e = fC;
            d();
        }
    }
}
