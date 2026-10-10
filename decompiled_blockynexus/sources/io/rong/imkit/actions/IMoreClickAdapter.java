package io.rong.imkit.actions;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface IMoreClickAdapter {
    void bindView(ViewGroup viewGroup, Fragment fragment, List<IClickActions> list);

    void hideMoreActionLayout();

    boolean isMoreActionShown();

    void setMoreActionEnable(boolean z);
}
