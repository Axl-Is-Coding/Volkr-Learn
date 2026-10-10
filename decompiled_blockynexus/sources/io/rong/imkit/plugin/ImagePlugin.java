package io.rong.imkit.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.plugin.image.PictureSelectorActivity;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public class ImagePlugin implements IPluginModule, IPluginRequestPermissionResultCallback {
    Conversation.ConversationType conversationType;
    String targetId;

    @Override // io.rong.imkit.plugin.IPluginModule
    public Drawable obtainDrawable(Context context) {
        return b.c(context, R.drawable.rc_ext_plugin_image_selector);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public String obtainTitle(Context context) {
        return context.getString(R.string.rc_plugin_image);
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // io.rong.imkit.plugin.IPluginModule
    public void onClick(Fragment fragment, RongExtension rongExtension) {
        this.conversationType = rongExtension.getConversationType();
        this.targetId = rongExtension.getTargetId();
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
        if (PermissionCheckUtil.checkPermissions(fragment.getContext(), strArr)) {
            rongExtension.startActivityForPluginResult(new Intent(fragment.getActivity(), (Class<?>) PictureSelectorActivity.class), 23, this);
        } else {
            rongExtension.requestPermissionForPluginResult(strArr, 255, this);
        }
    }

    @Override // io.rong.imkit.plugin.IPluginRequestPermissionResultCallback
    public boolean onRequestPermissionResult(Fragment fragment, RongExtension rongExtension, int i, String[] strArr, int[] iArr) {
        if (PermissionCheckUtil.checkPermissions(fragment.getActivity(), strArr)) {
            rongExtension.startActivityForPluginResult(new Intent(fragment.getActivity(), (Class<?>) PictureSelectorActivity.class), 23, this);
            return true;
        }
        if (fragment.getActivity() == null) {
            return true;
        }
        rongExtension.showRequestPermissionFailedAlter(PermissionCheckUtil.getNotGrantedPermissionMsg(fragment.getActivity(), strArr, iArr));
        return true;
    }
}
