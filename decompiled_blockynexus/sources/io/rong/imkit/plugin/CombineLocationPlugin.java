package io.rong.imkit.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import io.rong.common.LibStorageUtils;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.location.AMapLocationActivity;
import io.rong.imkit.plugin.location.AMapLocationActivity2D;
import io.rong.imkit.plugin.location.AMapRealTimeActivity;
import io.rong.imkit.plugin.location.AMapRealTimeActivity2D;
import io.rong.imkit.plugin.location.LocationManager;
import io.rong.imkit.plugin.location.LocationManager2D;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imkit.utilities.PermissionCheckUtil;

/* JADX INFO: loaded from: classes5.dex */
public class CombineLocationPlugin implements IPluginModule, IPluginRequestPermissionResultCallback {
    private void sendOrShareLocation(final Fragment fragment, final RongExtension rongExtension) {
        OptionsPopupDialog.newInstance(fragment.getActivity(), new String[]{fragment.getString(R.string.rc_plugin_location_message), fragment.getString(R.string.rc_plugin_location_sharing)}).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.plugin.CombineLocationPlugin.1
            @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
            public void onOptionsItemClicked(int i) {
                if (i == 0) {
                    rongExtension.startActivityForPluginResult(rongExtension.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? new Intent(fragment.getActivity(), (Class<?>) AMapLocationActivity2D.class) : new Intent(fragment.getActivity(), (Class<?>) AMapLocationActivity.class), 1, CombineLocationPlugin.this);
                    return;
                }
                if (i == 1) {
                    int iJoinLocationSharing = rongExtension.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? LocationManager2D.getInstance().joinLocationSharing() : LocationManager.getInstance().joinLocationSharing();
                    if (iJoinLocationSharing == 0) {
                        Intent intent = rongExtension.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? new Intent(fragment.getActivity(), (Class<?>) AMapRealTimeActivity2D.class) : new Intent(fragment.getActivity(), (Class<?>) AMapRealTimeActivity.class);
                        if (fragment.getActivity() != null) {
                            fragment.getActivity().startActivity(intent);
                            return;
                        }
                        return;
                    }
                    if (iJoinLocationSharing == 1) {
                        Toast.makeText(fragment.getActivity(), R.string.rc_network_exception, 0).show();
                    } else if (iJoinLocationSharing == 2) {
                        Toast.makeText(fragment.getActivity(), R.string.rc_location_sharing_exceed_max, 0).show();
                    }
                }
            }
        }).show();
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_ext_plugin_location_selector);
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
        String[] strArr = LibStorageUtils.isBuildAndTargetForQ(fragment.getContext()) ? new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission.ACCESS_NETWORK_STATE"} : new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_NETWORK_STATE"};
        if (PermissionCheckUtil.checkPermissions(fragment.getActivity(), strArr)) {
            sendOrShareLocation(fragment, rongExtension);
        } else {
            rongExtension.requestPermissionForPluginResult(strArr, 255, this);
        }
    }

    @Override // io.rong.imkit.plugin.IPluginRequestPermissionResultCallback
    public boolean onRequestPermissionResult(Fragment fragment, RongExtension rongExtension, int i, String[] strArr, int[] iArr) {
        if (PermissionCheckUtil.checkPermissions(fragment.getActivity(), strArr)) {
            sendOrShareLocation(fragment, rongExtension);
            return true;
        }
        if (fragment.getActivity() == null) {
            return true;
        }
        rongExtension.showRequestPermissionFailedAlter(PermissionCheckUtil.getNotGrantedPermissionMsg(fragment.getActivity(), strArr, iArr));
        return true;
    }
}
