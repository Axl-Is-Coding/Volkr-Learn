package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentContainer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0332j {
    public abstract View a(int i);

    @Deprecated
    public Fragment a(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    public abstract boolean a();
}
