package com.bytedance.sdk.openadsdk.core.video.f;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.HashMap;

/* JADX INFO: compiled from: MediaUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MediaUtils.java */
    public interface InterfaceC0083b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC0083b interfaceC0083b) {
        new a(interfaceC0083b, j).execute(str);
    }

    /* JADX INFO: compiled from: MediaUtils.java */
    public static class a extends AsyncTask<String, Integer, Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private InterfaceC0083b f6491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f6492b;

        public a(InterfaceC0083b interfaceC0083b, long j) {
            this.f6492b = 0L;
            this.f6491a = interfaceC0083b;
            this.f6492b = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap frameAtTime = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.f6492b * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                o.c("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0083b interfaceC0083b = this.f6491a;
            if (interfaceC0083b != null) {
                interfaceC0083b.a(bitmap);
            }
        }
    }
}
