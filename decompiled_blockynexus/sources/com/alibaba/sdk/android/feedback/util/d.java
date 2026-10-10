package com.alibaba.sdk.android.feedback.util;

import android.media.MediaRecorder;
import com.just.agentweb.WebIndicator;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3716a;

    d(c cVar) {
        this.f3716a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3716a.f3710a = c.a(j.f3723b);
        if (this.f3716a.f3710a == null) {
            this.f3716a.b("createAudioFile fail");
            return;
        }
        if (this.f3716a.f3712c) {
            return;
        }
        try {
            if (this.f3716a.f3711b == null) {
                this.f3716a.f3711b = new MediaRecorder();
            }
            this.f3716a.f3711b.setAudioSource(1);
            this.f3716a.f3711b.setOutputFormat(3);
            this.f3716a.f3711b.setAudioEncoder(1);
            this.f3716a.f3711b.setAudioSamplingRate(WebIndicator.MAX_UNIFORM_SPEED_DURATION);
            this.f3716a.f3711b.setAudioEncodingBitRate(67000);
            this.f3716a.f3711b.setOutputFile(this.f3716a.f3710a.getAbsolutePath());
            this.f3716a.f3711b.prepare();
            try {
                try {
                    if (this.f3716a.f3711b != null) {
                        this.f3716a.f3713d = System.currentTimeMillis();
                        this.f3716a.f3711b.start();
                    }
                    this.f3716a.f3712c = true;
                } catch (RuntimeException unused) {
                    if (this.f3716a.f3711b != null) {
                        this.f3716a.f3711b.reset();
                        this.f3716a.f3711b.release();
                    }
                    this.f3716a.f3711b = null;
                    this.f3716a.g();
                }
            } catch (RuntimeException unused2) {
                this.f3716a.f3711b = null;
                this.f3716a.g();
            }
        } catch (IOException e2) {
            if (this.f3716a.f3711b != null) {
                this.f3716a.f3711b.reset();
                this.f3716a.f3711b.release();
                this.f3716a.f3711b = null;
            }
            e2.printStackTrace();
            this.f3716a.g();
        } catch (IllegalStateException e3) {
            if (this.f3716a.f3711b != null) {
                this.f3716a.f3711b.reset();
                this.f3716a.f3711b.release();
                this.f3716a.f3711b = null;
            }
            e3.printStackTrace();
            this.f3716a.g();
        } catch (RuntimeException e4) {
            try {
                if (this.f3716a.f3711b != null) {
                    this.f3716a.f3711b.reset();
                    this.f3716a.f3711b.release();
                }
            } catch (RuntimeException unused3) {
            }
            this.f3716a.f3711b = null;
            e4.printStackTrace();
            this.f3716a.g();
        }
    }
}
