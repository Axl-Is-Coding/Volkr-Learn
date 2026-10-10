package io.rong.imkit.utilities.videocompressor;

import android.os.AsyncTask;
import io.rong.imkit.utilities.videocompressor.VideoController;

/* JADX INFO: loaded from: classes5.dex */
public class VideoCompress {
    private static final String TAG = "VideoCompress";

    public interface CompressListener {
        void onFail();

        void onProgress(float f2);

        void onStart();

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static class VideoCompressTask extends AsyncTask<String, Float, Boolean> {
        private CompressListener mListener;

        public VideoCompressTask(CompressListener compressListener) {
            this.mListener = compressListener;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            CompressListener compressListener = this.mListener;
            if (compressListener != null) {
                compressListener.onStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(VideoController.getInstance().convertVideo(strArr[0], strArr[1], new VideoController.CompressProgressListener() { // from class: io.rong.imkit.utilities.videocompressor.VideoCompress.VideoCompressTask.1
                @Override // io.rong.imkit.utilities.videocompressor.VideoController.CompressProgressListener
                public void onProgress(float f2) {
                    VideoCompressTask.this.publishProgress(Float.valueOf(f2));
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (this.mListener != null) {
                if (bool.booleanValue()) {
                    this.mListener.onSuccess();
                } else {
                    this.mListener.onFail();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Float... fArr) {
            super.onProgressUpdate((Object[]) fArr);
            CompressListener compressListener = this.mListener;
            if (compressListener != null) {
                compressListener.onProgress(fArr[0].floatValue());
            }
        }
    }

    public static VideoCompressTask compressVideo(String str, String str2, CompressListener compressListener) {
        VideoCompressTask videoCompressTask = new VideoCompressTask(compressListener);
        videoCompressTask.execute(str, str2);
        return videoCompressTask;
    }
}
