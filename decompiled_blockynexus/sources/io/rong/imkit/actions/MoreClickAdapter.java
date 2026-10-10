package io.rong.imkit.actions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import io.rong.imkit.R;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MoreClickAdapter implements IMoreClickAdapter {
    private MoreActionLayout moreActionLayout;

    @Override // io.rong.imkit.actions.IMoreClickAdapter
    public void bindView(ViewGroup viewGroup, Fragment fragment, List<IClickActions> list) {
        if (this.moreActionLayout == null) {
            Context context = viewGroup.getContext();
            this.moreActionLayout = (MoreActionLayout) LayoutInflater.from(context).inflate(R.layout.rc_ext_actions_container, (ViewGroup) null);
            this.moreActionLayout.setFragment(fragment);
            this.moreActionLayout.addActions(list);
            this.moreActionLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, context.getResources().getDimensionPixelOffset(R.dimen.rc_ext_more_layout_height)));
            viewGroup.addView(this.moreActionLayout);
        }
        this.moreActionLayout.setVisibility(0);
    }

    @Override // io.rong.imkit.actions.IMoreClickAdapter
    public void hideMoreActionLayout() {
        MoreActionLayout moreActionLayout = this.moreActionLayout;
        if (moreActionLayout != null) {
            moreActionLayout.setVisibility(8);
        }
    }

    @Override // io.rong.imkit.actions.IMoreClickAdapter
    public boolean isMoreActionShown() {
        MoreActionLayout moreActionLayout = this.moreActionLayout;
        return moreActionLayout != null && moreActionLayout.getVisibility() == 0;
    }

    @Override // io.rong.imkit.actions.IMoreClickAdapter
    public void setMoreActionEnable(boolean z) {
        MoreActionLayout moreActionLayout = this.moreActionLayout;
        if (moreActionLayout != null) {
            moreActionLayout.refreshView(z);
        }
    }
}
