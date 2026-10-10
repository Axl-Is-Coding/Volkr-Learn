package com.sandboxol.center.download.utils;

import android.content.Context;
import com.sandboxol.center.download.entity.MergeBuilder;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.file.entity.DownloadInfo;
import com.sandboxol.file.entity.UnzipInfo;
import com.sandboxol.file.entity.VerifyInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessUtils {
    public static DownloadInfo[] filterDownloadInfo(MergeBuilder mergeBuilder, boolean z) {
        if (mergeBuilder.getDownloadBuilder().e() == null || mergeBuilder.getDownloadBuilder().e().length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(mergeBuilder.getDownloadBuilder().e()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DownloadInfo downloadInfo = (DownloadInfo) it.next();
            if (z) {
                if (((String) downloadInfo.getT()).equals("COMMON")) {
                    it.remove();
                }
            } else if (!((String) downloadInfo.getT()).equals("COMMON")) {
                it.remove();
            }
        }
        return (DownloadInfo[]) arrayList.toArray(new DownloadInfo[arrayList.size()]);
    }

    public static UnzipInfo[] filterUnzipInfo(MergeBuilder mergeBuilder, boolean z) {
        if (mergeBuilder.getUnzipBuilder().b() == null || mergeBuilder.getUnzipBuilder().b().length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(mergeBuilder.getUnzipBuilder().b()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            UnzipInfo unzipInfo = (UnzipInfo) it.next();
            if (z) {
                if (((String) unzipInfo.getT()).equals("COMMON")) {
                    it.remove();
                }
            } else if (!((String) unzipInfo.getT()).equals("COMMON")) {
                it.remove();
            }
        }
        return (UnzipInfo[]) arrayList.toArray(new UnzipInfo[arrayList.size()]);
    }

    public static VerifyInfo[] filterVerifyInfo(MergeBuilder mergeBuilder, boolean z) {
        if (mergeBuilder.getVerifyBuilder().b() == null || mergeBuilder.getVerifyBuilder().b().length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(mergeBuilder.getVerifyBuilder().b()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            VerifyInfo verifyInfo = (VerifyInfo) it.next();
            if (z) {
                if (((String) verifyInfo.getT()).equals("COMMON")) {
                    it.remove();
                }
            } else if (!((String) verifyInfo.getT()).equals("COMMON")) {
                it.remove();
            }
        }
        return (VerifyInfo[]) arrayList.toArray(new VerifyInfo[arrayList.size()]);
    }

    public static void toast(final Context context, final int i) {
        Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.center.download.utils.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                AppToastUtils.showShortNegativeTipToast(context, i);
            }
        });
    }
}
