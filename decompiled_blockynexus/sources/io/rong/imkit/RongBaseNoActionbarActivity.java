package io.rong.imkit;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import io.rong.imkit.utilities.LangUtils;

/* JADX INFO: loaded from: classes5.dex */
public class RongBaseNoActionbarActivity extends FragmentActivity {
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(LangUtils.getConfigurationContext(context));
    }
}
