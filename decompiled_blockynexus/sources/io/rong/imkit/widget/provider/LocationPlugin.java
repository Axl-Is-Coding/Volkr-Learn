package io.rong.imkit.widget.provider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongExtension;
import io.rong.imkit.RongIM;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Message;
import io.rong.message.LocationMessage;

/* JADX INFO: loaded from: classes5.dex */
public class LocationPlugin implements IPluginModule {
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
    public void onClick(Fragment fragment, final RongExtension rongExtension) {
        if (RongContext.getInstance() == null || RongContext.getInstance().getLocationProvider() == null || fragment.getActivity() == null) {
            return;
        }
        RongContext.getInstance().getLocationProvider().onStartLocation(fragment.getActivity().getApplicationContext(), new RongIM.LocationProvider.LocationCallback() { // from class: io.rong.imkit.widget.provider.LocationPlugin.1
            @Override // io.rong.imkit.RongIM.LocationProvider.LocationCallback
            public void onFailure(String str) {
            }

            @Override // io.rong.imkit.RongIM.LocationProvider.LocationCallback
            public void onSuccess(LocationMessage locationMessage) {
                RongIM.getInstance().sendLocationMessage(Message.obtain(rongExtension.getTargetId(), rongExtension.getConversationType(), locationMessage), null, null, null);
            }
        });
    }
}
