package io.rong.imkit.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import io.rong.common.dlog.DLog;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.RongContext;
import io.rong.imkit.fragment.IHistoryDataResultCallback;
import io.rong.imkit.utils.ForwardManager;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.RongSwipeRefreshLayout;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SelectConversationActivity extends RongBaseNoActionbarActivity implements View.OnClickListener, RongSwipeRefreshLayout.OnLoadListener {
    private static final String TAG = "SelectConversationActivity";
    private static final Conversation.ConversationType[] defConversationType = {Conversation.ConversationType.PRIVATE, Conversation.ConversationType.GROUP};
    private TextView btOK;
    private ListAdapter mAdapter;
    private RongSwipeRefreshLayout mRefreshLayout;
    private ArrayList<Conversation> selectedMember = new ArrayList<>();
    private long timestamp = 0;
    private int pageSize = 100;

    private class ForwardItemClickListener implements AdapterView.OnItemClickListener {
        private ForwardItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            View viewFindViewById = view.findViewById(R.id.rc_checkbox);
            Conversation conversation = (Conversation) viewFindViewById.getTag();
            SelectConversationActivity.this.selectedMember.remove(conversation);
            viewFindViewById.setSelected(!viewFindViewById.isSelected());
            if (viewFindViewById.isSelected()) {
                SelectConversationActivity.this.selectedMember.add(conversation);
            }
            if (SelectConversationActivity.this.selectedMember.size() > 0) {
                SelectConversationActivity.this.btOK.setEnabled(true);
            } else {
                SelectConversationActivity.this.btOK.setEnabled(false);
            }
        }
    }

    private class ListAdapter extends BaseAdapter {
        private Activity activity;
        private List<Conversation> allMembers;

        ListAdapter(Activity activity) {
            this.activity = activity;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<Conversation> list = this.allMembers;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<Conversation> list = this.allMembers;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                View viewInflate = LayoutInflater.from(this.activity).inflate(R.layout.rc_listitem_forward_select_member, (ViewGroup) null);
                viewHolder.checkbox = (ImageView) viewInflate.findViewById(R.id.rc_checkbox);
                viewHolder.portrait = (AsyncImageView) viewInflate.findViewById(R.id.rc_user_portrait);
                viewHolder.name = (TextView) viewInflate.findViewById(R.id.rc_user_name);
                viewInflate.setTag(viewHolder);
                view = viewInflate;
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            viewHolder2.checkbox.setTag(this.allMembers.get(i));
            viewHolder2.checkbox.setClickable(false);
            viewHolder2.checkbox.setImageResource(R.drawable.rc_select_conversation_checkbox);
            viewHolder2.checkbox.setEnabled(true);
            Conversation conversation = this.allMembers.get(i);
            viewHolder2.checkbox.setSelected(SelectConversationActivity.this.selectedMember.contains(conversation));
            String conversationTitle = conversation.getConversationTitle();
            String portraitUrl = conversation.getPortraitUrl();
            if (TextUtils.isEmpty(conversationTitle)) {
                conversationTitle = RongContext.getInstance().getConversationTemplate(conversation.getConversationType().getName()).getTitle(conversation.getTargetId());
            }
            if (TextUtils.isEmpty(portraitUrl)) {
                Uri portraitUri = RongContext.getInstance().getConversationTemplate(conversation.getConversationType().getName()).getPortraitUri(conversation.getTargetId());
                portraitUrl = portraitUri != null ? portraitUri.toString() : "";
            }
            if (!TextUtils.isEmpty(portraitUrl)) {
                viewHolder2.portrait.setAvatar(Uri.parse(portraitUrl));
            }
            if (!TextUtils.isEmpty(conversationTitle)) {
                viewHolder2.name.setText(conversationTitle);
            }
            return view;
        }

        void setAllMembers(List<Conversation> list) {
            this.allMembers = list;
        }
    }

    private class ViewHolder {
        ImageView checkbox;
        TextView name;
        AsyncImageView portrait;

        private ViewHolder() {
        }
    }

    private void getConversationList(boolean z) {
        getConversationList(defConversationType, new IHistoryDataResultCallback<List<Conversation>>() { // from class: io.rong.imkit.activity.SelectConversationActivity.1
            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onError() {
                SelectConversationActivity.this.mRefreshLayout.setLoadMoreFinish(false);
            }

            @Override // io.rong.imkit.fragment.IHistoryDataResultCallback
            public void onResult(List<Conversation> list) {
                if (list != null && list.size() > 0) {
                    SelectConversationActivity.this.mAdapter.setAllMembers(list);
                    SelectConversationActivity.this.mAdapter.notifyDataSetChanged();
                }
                if (list == null) {
                    SelectConversationActivity.this.mRefreshLayout.setLoadMoreFinish(false);
                    return;
                }
                if (list.size() > 0 && list.size() <= SelectConversationActivity.this.pageSize) {
                    SelectConversationActivity.this.mRefreshLayout.setLoadMoreFinish(false);
                } else if (list.size() != 0) {
                    SelectConversationActivity.this.mRefreshLayout.setLoadMoreFinish(false);
                } else {
                    SelectConversationActivity.this.mRefreshLayout.setLoadMoreFinish(false);
                    SelectConversationActivity.this.mRefreshLayout.setCanLoading(false);
                }
            }
        }, z);
    }

    private void showSendDialog() {
        if (isFinishing()) {
            return;
        }
        ForwardManager.forwardMessage(this, this.selectedMember);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rc_btn_ok) {
            showSendDialog();
        } else if (id == R.id.rc_btn_cancel) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(DLog.CRS, DLog.CRS);
        requestWindowFeature(1);
        setContentView(R.layout.rc_activity_forward_select);
        this.btOK = (TextView) findViewById(R.id.rc_btn_ok);
        TextView textView = (TextView) findViewById(R.id.rc_btn_cancel);
        this.mRefreshLayout = (RongSwipeRefreshLayout) findViewById(R.id.rc_refresh);
        ListView listView = (ListView) findViewById(R.id.rc_list);
        this.btOK.setEnabled(false);
        this.btOK.setOnClickListener(this);
        textView.setOnClickListener(this);
        this.mRefreshLayout.setCanRefresh(false);
        this.mRefreshLayout.setCanLoading(true);
        this.mRefreshLayout.setOnLoadListener(this);
        this.mAdapter = new ListAdapter(this);
        listView.setAdapter((android.widget.ListAdapter) this.mAdapter);
        listView.setOnItemClickListener(new ForwardItemClickListener());
        if (getIntent() == null) {
            return;
        }
        getConversationList(false);
    }

    @Override // io.rong.imkit.widget.RongSwipeRefreshLayout.OnLoadListener
    public void onLoad() {
        getConversationList(true);
    }

    public void getConversationList(Conversation.ConversationType[] conversationTypeArr, final IHistoryDataResultCallback<List<Conversation>> iHistoryDataResultCallback, boolean z) {
        RongIMClient.getInstance().getConversationListByPage(new RongIMClient.ResultCallback<List<Conversation>>() { // from class: io.rong.imkit.activity.SelectConversationActivity.2
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                IHistoryDataResultCallback iHistoryDataResultCallback2 = iHistoryDataResultCallback;
                if (iHistoryDataResultCallback2 != null) {
                    iHistoryDataResultCallback2.onError();
                }
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Conversation> list) {
                if (SelectConversationActivity.this.isFinishing() || iHistoryDataResultCallback == null) {
                    return;
                }
                if (list != null) {
                    SelectConversationActivity.this.timestamp = list.get(list.size() - 1).getSentTime();
                }
                iHistoryDataResultCallback.onResult(list);
            }
        }, z ? this.timestamp : 0L, this.pageSize, conversationTypeArr);
    }
}
