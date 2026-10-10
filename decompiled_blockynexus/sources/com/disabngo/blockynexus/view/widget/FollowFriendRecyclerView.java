package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.main.S;

/* JADX INFO: loaded from: classes.dex */
public class FollowFriendRecyclerView extends FrameLayout {
    private RecyclerView rvHeader;

    public FollowFriendRecyclerView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.follow_friend_recycler_view, this);
        this.rvHeader = (RecyclerView) findViewById(R.id.rv_header);
    }

    public void setAdapter(com.disabngo.blockynexus.view.fragment.partyhall.q qVar) {
        this.rvHeader.setAdapter(qVar);
    }

    public void setLayoutManager(RecyclerView.i iVar) {
        this.rvHeader.setLayoutManager(iVar);
    }

    public FollowFriendRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setAdapter(S s) {
        this.rvHeader.setAdapter(s);
    }

    public FollowFriendRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
