package b.h.a;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.just.agentweb.WebIndicator;
import java.io.File;

/* JADX INFO: compiled from: GameRecord.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2766a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f2768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MediaRecorder f2770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f2771f;

    public c(Looper looper, String str, b bVar) {
        super(looper);
        this.f2771f = bVar;
        this.f2767b = str;
        File file = new File(this.f2767b);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private synchronized void b() {
        b bVar;
        this.f2768c = SystemClock.elapsedRealtime();
        try {
            if (this.f2770e != null) {
                this.f2770e.reset();
                this.f2770e.release();
                this.f2770e = null;
            }
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
            } catch (Exception e3) {
                try {
                    try {
                        if (this.f2770e != null) {
                            this.f2770e.reset();
                            this.f2770e.release();
                            this.f2770e = null;
                        }
                        e3.printStackTrace();
                        bVar = this.f2771f;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        Log.e("GameRecord", "Exception e: " + e3.toString());
                        bVar = this.f2771f;
                        bVar.onRecordFailure(0);
                    }
                    bVar.onRecordFailure(0);
                } catch (Throwable th) {
                    this.f2771f.onRecordFailure(0);
                    throw th;
                }
            }
        }
        this.f2770e = new MediaRecorder();
        try {
            this.f2770e.setAudioSamplingRate(WebIndicator.MAX_UNIFORM_SPEED_DURATION);
            this.f2770e.setAudioEncodingBitRate(7950);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.f2770e.setAudioChannels(1);
        this.f2770e.setAudioSource(1);
        this.f2770e.setOutputFormat(6);
        this.f2770e.setAudioEncoder(3);
        this.f2769d = new File(this.f2767b, "temp_record_" + System.currentTimeMillis() + ".voice").getPath();
        this.f2770e.setOutputFile(this.f2769d);
        this.f2770e.setMaxDuration(60000);
        this.f2770e.prepare();
        this.f2770e.start();
    }

    private synchronized void c() {
        if (this.f2770e != null) {
            try {
                try {
                    this.f2770e.stop();
                    this.f2770e.reset();
                    this.f2770e.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f2768c);
                File file = new File(this.f2769d);
                if (this.f2769d == null || iElapsedRealtime <= 1000 || !file.exists()) {
                    this.f2771f.onRecordFailure(iElapsedRealtime);
                    file.delete();
                } else {
                    this.f2771f.onRecordSuccess(iElapsedRealtime, this.f2769d);
                }
            } finally {
                this.f2770e = null;
            }
        }
    }

    public synchronized void a() {
        if (this.f2770e != null) {
            try {
                try {
                    this.f2770e.stop();
                    this.f2770e.reset();
                    this.f2770e.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.f2770e = null;
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            b();
        } else if (i == 2) {
            c();
        } else if (i == 3) {
            a();
        }
        a("------------------------------------------- what: " + message.what);
    }

    private void a(String str) {
        Log.e(f2766a, str);
    }
}
