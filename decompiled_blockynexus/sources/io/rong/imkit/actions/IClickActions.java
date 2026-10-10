package io.rong.imkit.actions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes5.dex */
public interface IClickActions {
    Drawable obtainDrawable(Context context);

    void onClick(Fragment fragment);
}
