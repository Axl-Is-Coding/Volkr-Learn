package io.rong.rtlog.upload;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import io.rong.common.fwlog.IFwLogConsolePrinter;

/* JADX INFO: loaded from: classes5.dex */
public class RtFwLogConsolePrinter implements IFwLogConsolePrinter {
    private static final String LOG_TAG_FORMAT = "[RC:%s][%s]";
    private boolean isReleaseMode;

    public RtFwLogConsolePrinter(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        this.isReleaseMode = applicationInfo == null || (applicationInfo.flags & 2) == 0;
    }

    @Override // io.rong.common.fwlog.IFwLogConsolePrinter
    public void printLog(long j, int i, String str, String str2, String str3, int i2) {
        String str4 = String.format(LOG_TAG_FORMAT, str2, str);
        if (!this.isReleaseMode || i <= i2) {
            if (i == 0 || i == 1) {
                Log.e(str4, str3);
                return;
            }
            if (i == 2) {
                Log.w(str4, str3);
            } else if (i == 3) {
                Log.i(str4, str3);
            } else {
                if (i != 4) {
                    return;
                }
                Log.d(str4, str3);
            }
        }
    }
}
