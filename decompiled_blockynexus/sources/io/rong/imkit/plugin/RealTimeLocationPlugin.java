package io.rong.imkit.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.location.AMapRealTimeActivity;
import io.rong.imkit.plugin.location.AMapRealTimeActivity2D;
import io.rong.imkit.plugin.location.LocationManager;
import io.rong.imkit.plugin.location.LocationManager2D;

/* JADX INFO: loaded from: classes5.dex */
public class RealTimeLocationPlugin implements IPluginModule {
    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_ext_plugin_location_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.rc_plugin_location_sharing);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        if (fragment.getActivity() == null) {
            return;
        }
        int iCheckCallingOrSelfPermission = fragment.getActivity().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION");
        int iCheckCallingOrSelfPermission2 = fragment.getActivity().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
        int iCheckCallingOrSelfPermission3 = fragment.getActivity().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE");
        if (iCheckCallingOrSelfPermission == -1 || iCheckCallingOrSelfPermission2 == -1 || iCheckCallingOrSelfPermission3 == -1) {
            Toast.makeText(fragment.getActivity(), fragment.getActivity().getResources().getString(R.string.rc_ext_location_permission_failed), 0).show();
            return;
        }
        int iJoinLocationSharing = rongExtension.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? LocationManager2D.getInstance().joinLocationSharing() : LocationManager.getInstance().joinLocationSharing();
        if (iJoinLocationSharing == 0) {
            fragment.getActivity().startActivity(rongExtension.getContext().getResources().getBoolean(R.bool.rc_location_2D) ? new Intent(fragment.getActivity(), (Class<?>) AMapRealTimeActivity2D.class) : new Intent(fragment.getActivity(), (Class<?>) AMapRealTimeActivity.class));
        } else if (iJoinLocationSharing == 1) {
            Toast.makeText(fragment.getActivity(), R.string.rc_network_exception, 0).show();
        } else if (iJoinLocationSharing == 2) {
            Toast.makeText(fragment.getActivity(), R.string.rc_location_sharing_exceed_max, 0).show();
        }
    }
}
