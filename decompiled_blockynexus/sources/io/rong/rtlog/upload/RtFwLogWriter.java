package io.rong.rtlog.upload;

import android.content.Context;
import io.rong.common.fwlog.IFwLogWriter;
import io.rong.common.rlog.RLog;
import io.rong.imlib.common.NetUtils;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class RtFwLogWriter implements IFwLogWriter {
    private Context context;
    private final String TAG = RtFwLogWriter.class.getCanonicalName();
    private Executor nativeExecutor = Executors.newSingleThreadExecutor();
    private final int MAX_CONTENT_SIZE = 1024;

    public RtFwLogWriter(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // io.rong.common.fwlog.IFwLogWriter
    public void write(final int i, final String str, final String str2, final String str3, final long j) {
        this.nativeExecutor.execute(new Runnable() { // from class: io.rong.rtlog.upload.RtFwLogWriter.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = i;
                if (i2 >= 0 && i2 <= 4) {
                    int i3 = ((i2 == 1 || i2 == 2) && !NetUtils.getCacheNetworkAvailable(RtFwLogWriter.this.context)) ? 3 : i2;
                    String str4 = str3;
                    if (str4 != null && str4.getBytes().length > 1024) {
                        str4 = new String(Arrays.copyOf(str3.getBytes(), 1024));
                    }
                    RtLogNativeProxy.writeLog(i3, str, str2, str4, j);
                    return;
                }
                RLog.e(RtFwLogWriter.this.TAG, "write log with invalid level:" + i + ",tag:" + str2 + " ,metaJson:" + str3 + " ,timestamp:" + j);
            }
        });
    }
}
