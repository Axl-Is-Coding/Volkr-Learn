package com.sandboxol.file.f;

import android.text.TextUtils;
import com.sandboxol.file.entity.CdnConfigDetail;
import com.sandboxol.file.entity.DownloadInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: CdnsUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static void a(int i, DownloadInfo[] downloadInfoArr) {
        if (downloadInfoArr == null || downloadInfoArr.length <= 0) {
            return;
        }
        for (DownloadInfo downloadInfo : downloadInfoArr) {
            a(i, downloadInfo);
        }
    }

    private static void a(int i, DownloadInfo downloadInfo) {
        try {
            if (downloadInfo.getCdns() != null && downloadInfo.getCdns().size() != 0) {
                ArrayList arrayList = new ArrayList(downloadInfo.getCdns());
                int size = i % arrayList.size();
                if (TextUtils.isEmpty(((CdnConfigDetail) arrayList.get(size)).getUrl())) {
                    return;
                }
                downloadInfo.setUrl(((CdnConfigDetail) arrayList.get(size)).getUrl());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
