package com.sandboxol.imchat.module;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.widget.provider.TakingPicturesActivity;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoPlugin implements IPluginModule {
    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_camera_image_selector_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.rc_camera);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        Intent intent = new Intent();
        intent.setClass(fragment.getContext(), TakingPicturesActivity.class);
        fragment.startActivityForResult(intent, 24);
    }
}
