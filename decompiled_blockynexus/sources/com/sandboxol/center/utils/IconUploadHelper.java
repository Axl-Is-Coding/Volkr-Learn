package com.sandboxol.center.utils;

import android.content.Context;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class IconUploadHelper {
    public static void uploadIcon(Context context, File file, String str, OnResponseListener<String> onResponseListener) {
        UserApi.uploadIcon(context, file, str, onResponseListener);
    }
}
