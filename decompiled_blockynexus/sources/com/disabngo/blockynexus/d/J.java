package com.disabngo.blockynexus.d;

import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: compiled from: ScrapTimeHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class J {
    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 86400;
        long j3 = (j % 86400) / 3600;
        long j4 = (j % 3600) / 60;
        if (j2 > 0) {
            sb.append(j2 + BaseApplication.getContext().getString(R.string.app_scrap_unit_day));
        }
        if (j3 > 0) {
            if (j4 > 0) {
                sb.append((j3 + (j4 / 60.0f)) + BaseApplication.getContext().getString(R.string.app_scrap_unit_hour));
            } else {
                sb.append(j3 + BaseApplication.getContext().getString(R.string.app_scrap_unit_hour));
            }
        } else if (j4 > 0) {
            sb.append((j4 / 60.0f) + BaseApplication.getContext().getString(R.string.app_scrap_unit_hour));
        }
        return sb.toString();
    }
}
