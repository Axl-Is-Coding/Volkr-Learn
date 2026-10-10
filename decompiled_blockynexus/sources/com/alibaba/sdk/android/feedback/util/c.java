package com.alibaba.sdk.android.feedback.util;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f3710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaRecorder f3711b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f3714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IWxCallback f3715f;
    private final long g;
    private final long h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3712c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3713d = 0;
    private Runnable i = new e(this);

    public c(IWxCallback iWxCallback, long j, long j2) {
        this.f3715f = iWxCallback;
        this.g = j * 1000;
        this.h = j2 * 1000;
    }

    public static File a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            return File.createTempFile("record_" + System.currentTimeMillis(), "", file);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        f();
        IWxCallback iWxCallback = this.f3715f;
        if (iWxCallback != null) {
            iWxCallback.onError(0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str;
        com.alibaba.sdk.android.feedback.xblink.i.g.a("ChattingRecorder", "stopRecord");
        this.f3714e.removeCallbacks(this.i);
        if (!this.f3712c) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("ChattingRecorder", "not start");
            return;
        }
        MediaRecorder mediaRecorder = this.f3711b;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            this.f3711b.release();
            this.f3711b = null;
        }
        this.f3712c = false;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f3713d;
        if (jCurrentTimeMillis < this.h) {
            str = "RecordTimeShort";
        } else {
            if (this.f3710a != null) {
                if (this.f3715f != null) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("ChattingRecorder", "stopRecord callback");
                    n.a("AudioRecordingSuccess", null);
                    this.f3715f.onSuccess(this.f3710a.getAbsolutePath(), Integer.valueOf((int) (jCurrentTimeMillis / 1000)));
                    str = "onSuccess";
                    com.alibaba.sdk.android.feedback.xblink.i.g.a("ChattingRecorder", str);
                }
                d();
            }
            str = "createAudioFile fail";
        }
        n.a("AudioRecordingFailed", str);
        b(str);
        com.alibaba.sdk.android.feedback.xblink.i.g.a("ChattingRecorder", str);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        File file = this.f3710a;
        if (file != null) {
            try {
                file.delete();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        f();
        IWxCallback iWxCallback = this.f3715f;
        if (iWxCallback != null) {
            iWxCallback.onError(0, "recordExceptionCaught");
        }
    }

    public void a() {
        if (this.f3714e == null) {
            HandlerThread handlerThread = new HandlerThread("ChattingRecorder");
            handlerThread.start();
            this.f3714e = new Handler(handlerThread.getLooper());
        }
        this.f3714e.post(new d(this));
        this.f3714e.postDelayed(this.i, this.g);
    }

    public void b() {
        Handler handler = this.f3714e;
        if (handler != null) {
            handler.post(new f(this));
        }
    }

    public void c() {
        if (this.f3712c) {
            this.f3714e.post(new g(this));
        }
    }

    public void d() {
        Handler handler = this.f3714e;
        if (handler != null) {
            handler.post(new h(this));
        }
    }
}
