package io.rong.imkit.plugin;

import androidx.fragment.app.Fragment;
import io.rong.imkit.RongExtension;

/* JADX INFO: loaded from: classes5.dex */
public interface IPluginRequestPermissionResultCallback {
    public static final int REQUEST_CODE_PERMISSION_PLUGIN = 255;

    boolean onRequestPermissionResult(Fragment fragment, RongExtension rongExtension, int i, String[] strArr, int[] iArr);
}
