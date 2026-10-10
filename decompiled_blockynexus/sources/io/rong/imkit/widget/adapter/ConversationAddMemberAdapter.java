package io.rong.imkit.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imlib.model.UserInfo;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationAddMemberAdapter extends BaseAdapter<UserInfo> {
    private OnDeleteIconListener mDeleteIconListener;
    private LayoutInflater mInflater;
    private String mCreatorId = null;
    private Boolean isDeleteState = false;

    public interface OnDeleteIconListener {
        void onDeleteIconClick(View view, int i);
    }

    class ViewHolder {
        ImageView mDeleteIcon;
        ImageView mMemberDeIcon;
        AsyncImageView mMemberIcon;
        TextView mMemberName;

        ViewHolder() {
        }
    }

    public ConversationAddMemberAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public String getCreatorId() {
        return this.mCreatorId;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) == null) {
            return 0L;
        }
        return r3.hashCode();
    }

    public boolean isDeleteState() {
        return this.isDeleteState.booleanValue();
    }

    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    protected View newView(Context context, int i, ViewGroup viewGroup) {
        View viewInflate = this.mInflater.inflate(R.layout.rc_item_conversation_member, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.mMemberIcon = (AsyncImageView) findViewById(viewInflate, android.R.id.icon);
        viewHolder.mMemberName = (TextView) findViewById(viewInflate, android.R.id.text1);
        viewHolder.mDeleteIcon = (ImageView) findViewById(viewInflate, android.R.id.icon1);
        viewHolder.mMemberDeIcon = (ImageView) findViewById(viewInflate, android.R.id.icon2);
        viewInflate.setTag(viewHolder);
        return viewInflate;
    }

    public void setCreatorId(String str) {
        this.mCreatorId = str;
    }

    public void setDeleteIconListener(OnDeleteIconListener onDeleteIconListener) {
        this.mDeleteIconListener = onDeleteIconListener;
    }

    public void setDeleteState(boolean z) {
        this.isDeleteState = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.rong.imkit.widget.adapter.BaseAdapter
    public void bindView(View view, final int i, UserInfo userInfo) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if (userInfo.getUserId().equals("RongAddBtn") || userInfo.getUserId().equals("RongDelBtn")) {
            viewHolder.mMemberIcon.setVisibility(4);
            viewHolder.mMemberDeIcon.setVisibility(0);
            if (userInfo.getUserId().equals("RongAddBtn")) {
                viewHolder.mMemberDeIcon.setImageResource(R.drawable.rc_ic_setting_friends_add);
            } else {
                viewHolder.mMemberDeIcon.setImageResource(R.drawable.rc_ic_setting_friends_delete);
            }
            viewHolder.mMemberName.setVisibility(4);
            viewHolder.mDeleteIcon.setVisibility(8);
            return;
        }
        viewHolder.mMemberIcon.setVisibility(0);
        viewHolder.mMemberDeIcon.setVisibility(8);
        if (userInfo.getPortraitUri() != null) {
            viewHolder.mMemberIcon.setResource(userInfo.getPortraitUri().toString(), R.drawable.rc_default_portrait);
        }
        if (userInfo.getName() != null) {
            viewHolder.mMemberName.setText(userInfo.getName());
        } else {
            viewHolder.mMemberName.setText("");
        }
        if (!isDeleteState() || userInfo.getUserId().equals(getCreatorId())) {
            viewHolder.mDeleteIcon.setVisibility(4);
        } else {
            viewHolder.mDeleteIcon.setVisibility(0);
            viewHolder.mDeleteIcon.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.adapter.ConversationAddMemberAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConversationAddMemberAdapter.this.mDeleteIconListener != null) {
                        ConversationAddMemberAdapter.this.mDeleteIconListener.onDeleteIconClick(view2, i);
                    }
                }
            });
        }
    }
}
