package io.rong.imkit.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;
import io.rong.imkit.RongExtension;

/* JADX INFO: loaded from: classes5.dex */
public interface IPluginModule {
    Drawable obtainDrawable(Context context);

    String obtainTitle(Context context);

    void onActivityResult(int i, int i2, Intent intent);

    void onClick(Fragment fragment, RongExtension rongExtension);
}
