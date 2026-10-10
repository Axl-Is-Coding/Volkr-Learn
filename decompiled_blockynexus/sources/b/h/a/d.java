package b.h.a;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

/* JADX INFO: compiled from: PlayVoice.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends Handler implements MediaPlayer.OnCompletionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2772a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinkedList<String> f2773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaPlayer f2774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f2776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2777f;

    public d(Looper looper, b bVar) {
        super(looper);
        this.f2773b = new LinkedList<>();
        this.f2776e = bVar;
    }

    private void c(String str) {
        if (str != null) {
            this.f2773b.add(0, str);
        }
        if (this.f2777f) {
            return;
        }
        try {
            if (this.f2774c != null) {
                if (this.f2774c.isPlaying()) {
                    return;
                }
            }
        } catch (IllegalStateException unused) {
            Log.e("PlayVoice", "noPlaying");
        }
        c();
    }

    private void d() {
        try {
            try {
                if (!this.f2775d.isEmpty()) {
                    this.f2776e.onPlayStop(this.f2775d);
                    this.f2775d = "";
                }
                if (this.f2774c != null && this.f2774c.isPlaying()) {
                    this.f2774c.stop();
                    this.f2774c.release();
                }
            } catch (RuntimeException unused) {
                Log.e("PlayVoice", "noPlaying");
            }
        } finally {
            this.f2774c = null;
        }
    }

    public void a() {
        try {
            if (this.f2774c == null || !this.f2774c.isPlaying()) {
                return;
            }
            this.f2777f = true;
            this.f2774c.pause();
            Log.d("PlayVoice", "pause success");
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        MediaPlayer mediaPlayer;
        if (!this.f2777f || (mediaPlayer = this.f2774c) == null) {
            return;
        }
        try {
            this.f2777f = false;
            mediaPlayer.start();
            Log.d("PlayVoice", "resume success");
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                this.f2774c.release();
                this.f2774c = null;
            } catch (Exception unused) {
                this.f2774c = null;
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 11:
                d();
                c((String) message.obj);
                break;
            case 12:
                a((String) message.obj);
                break;
            case 13:
                d();
                break;
            case 14:
                d();
                this.f2773b.clear();
                break;
        }
        b("------------------------------------------- what: " + message.what);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.reset();
            mediaPlayer.release();
            this.f2776e.onPlayStop(this.f2775d);
            this.f2775d = "";
            c();
        } catch (Exception e2) {
            Log.e("PlayVoice", e2.toString());
        }
    }

    private void a(String str) {
        if (str != null) {
            this.f2773b.add(str);
        }
        if (this.f2777f) {
            return;
        }
        try {
            if (this.f2774c != null) {
                if (this.f2774c.isPlaying()) {
                    return;
                }
            }
        } catch (IllegalStateException unused) {
            Log.e("PlayVoice", "noPlaying");
        }
        c();
    }

    private void c() {
        Log.d("PlayVoice", "playNext");
        if (this.f2773b.size() <= 0) {
            return;
        }
        try {
            if (this.f2774c != null) {
                if (this.f2774c.isPlaying()) {
                    this.f2774c.stop();
                    this.f2774c.release();
                }
                this.f2777f = false;
                this.f2774c = null;
            }
        } catch (RuntimeException unused) {
            Log.e("PlayVoice", "noPlaying");
        }
        this.f2774c = new MediaPlayer();
        this.f2774c.setOnCompletionListener(this);
        this.f2774c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: b.h.a.a
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
        this.f2775d = this.f2773b.remove();
        File file = new File(this.f2775d);
        if (file.exists()) {
            Log.e("PlayVoice", "file.exists()true");
            try {
                this.f2774c.setDataSource(new FileInputStream(file).getFD());
                this.f2774c.prepare();
                this.f2776e.onPlayStart(this.f2775d);
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        Log.e("PlayVoice", "file.exists()false");
        c();
    }

    private void b(String str) {
        Log.e(f2772a, str);
    }
}
