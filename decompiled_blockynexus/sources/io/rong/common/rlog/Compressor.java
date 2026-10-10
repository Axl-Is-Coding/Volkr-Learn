package io.rong.common.rlog;

import io.rong.common.dlog.LogZipper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class Compressor {
    private ICompressListener mListener;
    private ExecutorService pool = Executors.newSingleThreadExecutor();

    interface ICompressListener {
        void onCompressFinish(boolean z, String str, String str2);
    }

    public Compressor(ICompressListener iCompressListener) {
        this.mListener = iCompressListener;
    }

    public void compress(final String str, final String str2, final ICompressListener iCompressListener) {
        this.pool.submit(new Runnable() { // from class: io.rong.common.rlog.Compressor.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zGzipFile = LogZipper.gzipFile(str, str2);
                ICompressListener iCompressListener2 = iCompressListener;
                if (iCompressListener2 != null) {
                    iCompressListener2.onCompressFinish(zGzipFile, str, str2);
                }
            }
        });
    }

    public void compress(String str, String str2) {
        compress(str, str2, this.mListener);
    }
}
