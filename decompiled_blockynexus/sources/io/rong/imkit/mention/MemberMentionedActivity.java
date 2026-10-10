package io.rong.imkit.mention;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.RongIM;
import io.rong.imkit.mention.SideBar;
import io.rong.imkit.tools.CharacterParser;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Discussion;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MemberMentionedActivity extends RongBaseNoActionbarActivity {
    private Handler handler = new Handler();
    private MembersAdapter mAdapter;
    private List<MemberInfo> mAllMemberList;
    private ListView mListView;

    private class MemberInfo {
        String letter;
        UserInfo userInfo;

        MemberInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        public String getLetter() {
            return this.letter;
        }

        public void setLetter(String str) {
            this.letter = str;
        }
    }

    class MembersAdapter extends BaseAdapter implements SectionIndexer {
        private List<MemberInfo> mList = new ArrayList();

        MembersAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mList.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int i) {
            for (int i2 = 0; i2 < getCount(); i2++) {
                if (this.mList.get(i2).getLetter().toUpperCase().charAt(0) == i) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int i) {
            return this.mList.get(i).getLetter().charAt(0);
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return new Object[0];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = MemberMentionedActivity.this.new ViewHolder();
                viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_mention_list_item, (ViewGroup) null);
                viewHolder.name = (TextView) viewInflate.findViewById(R.id.rc_user_name);
                viewHolder.portrait = (AsyncImageView) viewInflate.findViewById(R.id.rc_user_portrait);
                viewHolder.letter = (TextView) viewInflate.findViewById(R.id.letter);
                viewInflate.setTag(viewHolder);
            } else {
                viewInflate = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            UserInfo userInfo = this.mList.get(i).userInfo;
            if (userInfo != null) {
                viewHolder.name.setText(userInfo.getName());
                viewHolder.portrait.setAvatar(userInfo.getPortraitUri());
            }
            if (i == getPositionForSection(getSectionForPosition(i))) {
                viewHolder.letter.setVisibility(0);
                viewHolder.letter.setText(this.mList.get(i).getLetter());
            } else {
                viewHolder.letter.setVisibility(8);
            }
            return viewInflate;
        }

        public void setData(List<MemberInfo> list) {
            this.mList = list;
        }

        @Override // android.widget.Adapter
        public MemberInfo getItem(int i) {
            return this.mList.get(i);
        }
    }

    public static class PinyinComparator implements Comparator<MemberInfo> {
        public static PinyinComparator instance;

        public static PinyinComparator getInstance() {
            if (instance == null) {
                instance = new PinyinComparator();
            }
            return instance;
        }

        @Override // java.util.Comparator
        public int compare(MemberInfo memberInfo, MemberInfo memberInfo2) {
            if (memberInfo.getLetter().equals("@") || memberInfo2.getLetter().equals("#")) {
                return -1;
            }
            if (memberInfo.getLetter().equals("#") || memberInfo2.getLetter().equals("@")) {
                return 1;
            }
            return memberInfo.getLetter().compareTo(memberInfo2.getLetter());
        }
    }

    class ViewHolder {
        TextView letter;
        TextView name;
        AsyncImageView portrait;

        ViewHolder() {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.rc_mention_members);
        EditText editText = (EditText) findViewById(R.id.rc_edit_text);
        this.mListView = (ListView) findViewById(R.id.rc_list);
        SideBar sideBar = (SideBar) findViewById(R.id.rc_sidebar);
        sideBar.setTextView((TextView) findViewById(R.id.rc_popup_bg));
        this.mAdapter = new MembersAdapter();
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mAllMemberList = new ArrayList();
        String stringExtra = getIntent().getStringExtra("targetId");
        Conversation.ConversationType value = Conversation.ConversationType.setValue(getIntent().getIntExtra("conversationType", 0));
        RongIM.IGroupMembersProvider groupMembersProvider = RongMentionManager.getInstance().getGroupMembersProvider();
        if (value.equals(Conversation.ConversationType.GROUP) && groupMembersProvider != null) {
            groupMembersProvider.getGroupMembers(stringExtra, new RongIM.IGroupMemberCallback() { // from class: io.rong.imkit.mention.MemberMentionedActivity.1
                @Override // io.rong.imkit.RongIM.IGroupMemberCallback
                public void onGetGroupMembersResult(final List<UserInfo> list) {
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    MemberMentionedActivity.this.handler.post(new Runnable() { // from class: io.rong.imkit.mention.MemberMentionedActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            for (int i = 0; i < list.size(); i++) {
                                UserInfo userInfo = (UserInfo) list.get(i);
                                if (userInfo != null && !userInfo.getUserId().equals(RongIMClient.getInstance().getCurrentUserId())) {
                                    MemberInfo memberInfo = MemberMentionedActivity.this.new MemberInfo(userInfo);
                                    String selling = CharacterParser.getInstance().getSelling(userInfo.getName());
                                    String upperCase = (selling == null || selling.length() <= 0) ? "#" : selling.substring(0, 1).toUpperCase();
                                    if (upperCase.matches("[A-Z]")) {
                                        memberInfo.setLetter(upperCase.toUpperCase());
                                    } else {
                                        memberInfo.setLetter("#");
                                    }
                                    MemberMentionedActivity.this.mAllMemberList.add(memberInfo);
                                }
                            }
                            Collections.sort(MemberMentionedActivity.this.mAllMemberList, PinyinComparator.getInstance());
                            MemberMentionedActivity.this.mAdapter.setData(MemberMentionedActivity.this.mAllMemberList);
                            MemberMentionedActivity.this.mAdapter.notifyDataSetChanged();
                        }
                    });
                }
            });
        } else if (value.equals(Conversation.ConversationType.DISCUSSION)) {
            RongIMClient.getInstance().getDiscussion(stringExtra, new RongIMClient.ResultCallback<Discussion>() { // from class: io.rong.imkit.mention.MemberMentionedActivity.2
                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onError(RongIMClient.ErrorCode errorCode) {
                }

                @Override // io.rong.imlib.RongIMClient.ResultCallback
                public void onSuccess(Discussion discussion) {
                    Iterator<String> it = discussion.getMemberIdList().iterator();
                    while (it.hasNext()) {
                        UserInfo userInfo = RongUserInfoManager.getInstance().getUserInfo(it.next());
                        if (userInfo != null && !userInfo.getUserId().equals(RongIMClient.getInstance().getCurrentUserId())) {
                            MemberInfo memberInfo = MemberMentionedActivity.this.new MemberInfo(userInfo);
                            String selling = CharacterParser.getInstance().getSelling(userInfo.getName());
                            String upperCase = (selling == null || selling.length() <= 0) ? "#" : selling.substring(0, 1).toUpperCase();
                            if (upperCase.matches("[A-Z]")) {
                                memberInfo.setLetter(upperCase.toUpperCase());
                            } else {
                                memberInfo.setLetter("#");
                            }
                            MemberMentionedActivity.this.mAllMemberList.add(memberInfo);
                        }
                    }
                    Collections.sort(MemberMentionedActivity.this.mAllMemberList, PinyinComparator.getInstance());
                    MemberMentionedActivity.this.mAdapter.setData(MemberMentionedActivity.this.mAllMemberList);
                    MemberMentionedActivity.this.mAdapter.notifyDataSetChanged();
                }
            });
        }
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.mention.MemberMentionedActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                MemberMentionedActivity.this.finish();
                MemberInfo item = MemberMentionedActivity.this.mAdapter.getItem(i);
                if (item == null || item.userInfo == null) {
                    return;
                }
                RongMentionManager.getInstance().mentionMember(item.userInfo);
            }
        });
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() { // from class: io.rong.imkit.mention.MemberMentionedActivity.4
            @Override // io.rong.imkit.mention.SideBar.OnTouchingLetterChangedListener
            public void onTouchingLetterChanged(String str) {
                int positionForSection = MemberMentionedActivity.this.mAdapter.getPositionForSection(str.charAt(0));
                if (positionForSection != -1) {
                    MemberMentionedActivity.this.mListView.setSelection(positionForSection);
                }
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: io.rong.imkit.mention.MemberMentionedActivity.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                List<MemberInfo> arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(charSequence.toString())) {
                    arrayList = MemberMentionedActivity.this.mAllMemberList;
                } else {
                    arrayList.clear();
                    for (MemberInfo memberInfo : MemberMentionedActivity.this.mAllMemberList) {
                        String name = memberInfo.userInfo.getName();
                        if (name != null && (name.contains(charSequence) || CharacterParser.getInstance().getSelling(name).startsWith(charSequence.toString()))) {
                            arrayList.add(memberInfo);
                        }
                    }
                }
                Collections.sort(arrayList, PinyinComparator.getInstance());
                MemberMentionedActivity.this.mAdapter.setData(arrayList);
                MemberMentionedActivity.this.mAdapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.rc_btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.mention.MemberMentionedActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MemberMentionedActivity.this.finish();
            }
        });
    }
}
