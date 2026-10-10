package io.rong.imkit.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.location.AMapLocationActivity;
import io.rong.imkit.plugin.location.AMapLocationActivity2D;
import io.rong.imkit.utilities.PermissionCheckUtil;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultLocationPlugin implements IPluginModule, IPluginRequestPermissionResultCallback {
    private void startLocationActivity(Fragment fragment, RongExtension rongExtension) {
        rongExtension.startActivityForPluginResult(rongExtension.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? new Intent(fragment.getActivity(), (Class<?>) AMapLocationActivity2D.class) : new Intent(fragment.getActivity(), (Class<?>) AMapLocationActivity.class), 1, this);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return context.getResources().getDrawable(R.drawable.rc_ext_plugin_location_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.rc_plugin_location);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_NETWORK_STATE"};
        if (PermissionCheckUtil.checkPermissions(fragment.getActivity(), strArr)) {
            startLocationActivity(fragment, rongExtension);
        } else {
            rongExtension.requestPermissionForPluginResult(strArr, 255, this);
        }
    }

    @Override // io.rong.imkit.plugin.IPluginRequestPermissionResultCallback
    public boolean onRequestPermissionResult(Fragment fragment, RongExtension rongExtension, int i, String[] strArr, int[] iArr) {
        if (PermissionCheckUtil.checkPermissions(fragment.getActivity(), strArr)) {
            startLocationActivity(fragment, rongExtension);
            return true;
        }
        if (fragment.getActivity() == null) {
            return true;
        }
        rongExtension.showRequestPermissionFailedAlter(PermissionCheckUtil.getNotGrantedPermissionMsg(fragment.getActivity(), strArr, iArr));
        return true;
    }
}
