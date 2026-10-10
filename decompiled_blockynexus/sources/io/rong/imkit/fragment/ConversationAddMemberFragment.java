package io.rong.imkit.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.adapter.ConversationAddMemberAdapter;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ConversationAddMemberFragment extends BaseFragment implements AdapterView.OnItemClickListener, ConversationAddMemberAdapter.OnDeleteIconListener {
    static final int PREPARE_LIST = 1;
    static final int REMOVE_ITEM = 2;
    static final int SHOW_TOAST = 3;
    private ConversationAddMemberAdapter mAdapter;
    private Conversation.ConversationType mConversationType;
    private GridView mGridList;
    private List<String> mIdList = new ArrayList();
    private ArrayList<UserInfo> mMembers = new ArrayList<>();
    private String mTargetId;

    private void initData() {
        if (this.mConversationType.equals(Conversation.ConversationType.DISCUSSION)) {
            RongIM.getInstance().getDiscussion(this.mTargetId, new RongIMClient.ResultCallback<Discussion>() { // from class: io.rong.imkit.fragment.ConversationAddMemberFragment.2
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                    ConversationAddMemberFragment.this.getHandler().sendEmptyMessage(3);
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Discussion discussion) {
                    ConversationAddMemberFragment.this.mIdList = discussion.getMemberIdList();
                    ConversationAddMemberFragment.this.mAdapter.setCreatorId(discussion.getCreatorId());
                    Message message = new Message();
                    message.what = 1;
                    message.obj = ConversationAddMemberFragment.this.mIdList;
                    ConversationAddMemberFragment.this.getHandler().sendMessage(message);
                }
            });
            return;
        }
        if (this.mConversationType.equals(Conversation.ConversationType.PRIVATE)) {
            this.mIdList.add(this.mTargetId);
            Message message = new Message();
            message.what = 1;
            message.obj = this.mIdList;
            getHandler().sendMessage(message);
        }
    }

    @Override // io.rong.imkit.fragment.BaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            int i2 = 0;
            for (String str : (List) message.obj) {
                if (i2 >= 50) {
                    break;
                }
                UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(str);
                if (userInfo == null) {
                    this.mMembers.add(new UserInfo(str, null, null));
                } else {
                    this.mMembers.add(userInfo);
                }
                i2++;
            }
            this.mMembers.add(new UserInfo("RongAddBtn", null, null));
            String currentUserId = RongIM.getInstance().getCurrentUserId();
            if (this.mAdapter.getCreatorId() != null && this.mConversationType.equals(Conversation.ConversationType.DISCUSSION) && currentUserId.equals(this.mAdapter.getCreatorId())) {
                this.mMembers.add(new UserInfo("RongDelBtn", null, null));
            }
            this.mAdapter.addCollection(this.mMembers);
            this.mAdapter.notifyDataSetChanged();
        } else if (i == 2) {
            this.mAdapter.remove(((Integer) message.obj).intValue());
            this.mAdapter.notifyDataSetChanged();
        }
        return true;
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RongContext.getInstance().getEventBus().register(this);
        if (getActivity() != null) {
            Intent intent = getActivity().getIntent();
            if (intent.getData() != null) {
                String lastPathSegment = intent.getData().getLastPathSegment();
                if (lastPathSegment != null) {
                    this.mConversationType = Conversation.ConversationType.valueOf(lastPathSegment.toUpperCase(Locale.US));
                }
                this.mTargetId = intent.getData().getQueryParameter("targetId");
            }
        }
        this.mAdapter = new ConversationAddMemberAdapter(getActivity());
        this.mAdapter.setDeleteIconListener(this);
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_fr_conversation_member_list, (ViewGroup) null);
        this.mGridList = (GridView) findViewById(viewInflate, R.id.rc_list);
        return viewInflate;
    }

    @Override // io.rong.imkit.widget.adapter.ConversationAddMemberAdapter.OnDeleteIconListener
    public void onDeleteIconClick(View view, final int i) {
        RongIM.getInstance().removeMemberFromDiscussion(this.mTargetId, this.mAdapter.getItem(i).getUserId(), new RongIMClient.OperationCallback() { // from class: io.rong.imkit.fragment.ConversationAddMemberFragment.3
            @Override // io.rong.imlib.RongIMClient.Callback
            public void onError(RongIMClient.ErrorCode errorCode) {
                ConversationAddMemberFragment.this.getHandler().sendEmptyMessage(3);
            }

            @Override // io.rong.imlib.RongIMClient.Callback
            public void onSuccess() {
                Message message = new Message();
                message.what = 2;
                message.obj = Integer.valueOf(i);
                ConversationAddMemberFragment.this.getHandler().sendMessage(message);
            }
        });
    }

    public void onEventMainThread(UserInfo userInfo) {
        int count = this.mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            UserInfo item = this.mAdapter.getItem(i);
            if (userInfo.getUserId().equals(item.getUserId())) {
                item.setName(userInfo.getName());
                item.setPortraitUri(userInfo.getPortraitUri());
                ConversationAddMemberAdapter conversationAddMemberAdapter = this.mAdapter;
                GridView gridView = this.mGridList;
                conversationAddMemberAdapter.getView(i, gridView.getChildAt(i - gridView.getFirstVisiblePosition()), this.mGridList);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        UserInfo item = this.mAdapter.getItem(i);
        if (item.getUserId().equals("RongDelBtn")) {
            this.mAdapter.setDeleteState(true);
            int count = this.mAdapter.getCount();
            this.mAdapter.remove(count - 1);
            this.mAdapter.remove(count - 2);
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        if (item.getUserId().equals("RongAddBtn")) {
            if (RongContext.getInstance().getMemberSelectListener() == null) {
                throw new ExceptionInInitializerError("The OnMemberSelectListener hasn't been set!");
            }
            RongContext.getInstance().getMemberSelectListener().startSelectMember(getActivity(), this.mConversationType, this.mTargetId);
        }
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public void onRestoreUI() {
        initData();
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mGridList.setAdapter((ListAdapter) this.mAdapter);
        this.mGridList.setOnItemClickListener(this);
        this.mGridList.setOnTouchListener(new View.OnTouchListener() { // from class: io.rong.imkit.fragment.ConversationAddMemberFragment.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (1 != motionEvent.getAction() || !ConversationAddMemberFragment.this.mAdapter.isDeleteState()) {
                    return false;
                }
                ConversationAddMemberFragment.this.mAdapter.add(new UserInfo("RongAddBtn", null, null));
                String currentUserId = RongIM.getInstance().getCurrentUserId();
                if (ConversationAddMemberFragment.this.mAdapter.getCreatorId() != null && ConversationAddMemberFragment.this.mConversationType.equals(Conversation.ConversationType.DISCUSSION) && currentUserId.equals(ConversationAddMemberFragment.this.mAdapter.getCreatorId())) {
                    ConversationAddMemberFragment.this.mAdapter.add(new UserInfo("RongDelBtn", null, null));
                }
                ConversationAddMemberFragment.this.mAdapter.setDeleteState(false);
                ConversationAddMemberFragment.this.mAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
