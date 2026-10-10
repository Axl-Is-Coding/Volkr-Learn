package io.rong.imkit.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.dialog.BurnHintDialog;

/* JADX INFO: loaded from: classes5.dex */
public class DestructPlugin implements IPluginModule {
    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_ext_plugin_fire_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.rc_plugin_destruct);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        if (!BurnHintDialog.isFirstClick(fragment.getContext())) {
            new BurnHintDialog().show(fragment.getFragmentManager());
        }
        rongExtension.enterBurnMode();
    }
}
