package io.rong.imkit.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.adapter.BaseAdapter;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class PublicServiceSubscribeListFragment extends DispatchResultFragment {
    private PublicServiceListAdapter mAdapter;

    /* JADX INFO: renamed from: io.rong.imkit.fragment.PublicServiceSubscribeListFragment$2, reason: invalid class name */
    class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
            String[] strArr = new String[1];
            final PublicServiceProfile item = PublicServiceSubscribeListFragment.this.mAdapter.getItem(i);
            if (item.getConversationType() == Conversation.ConversationType.PUBLIC_SERVICE) {
                if (PublicServiceSubscribeListFragment.this.getActivity() == null) {
                    return false;
                }
                strArr[0] = PublicServiceSubscribeListFragment.this.getActivity().getString(R.string.rc_pub_service_info_unfollow);
                OptionsPopupDialog.newInstance(view.getContext(), strArr).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.fragment.PublicServiceSubscribeListFragment.2.1
                    @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
                    public void onOptionsItemClicked(int i2) {
                        Conversation.PublicServiceType publicServiceType;
                        if (item.getConversationType() == Conversation.ConversationType.APP_PUBLIC_SERVICE) {
                            publicServiceType = Conversation.PublicServiceType.APP_PUBLIC_SERVICE;
                        } else if (item.getConversationType() == Conversation.ConversationType.PUBLIC_SERVICE) {
                            publicServiceType = Conversation.PublicServiceType.PUBLIC_SERVICE;
                        } else {
                            System.err.print("the public service type is error!!");
                            publicServiceType = null;
                        }
                        RongIMClient.getInstance().unsubscribePublicService(publicServiceType, item.getTargetId(), new RongIMClient.OperationCallback() { // from class: io.rong.imkit.fragment.PublicServiceSubscribeListFragment.2.1.1
                            @Override // io.rong.imlib.RongIMClient.Callback
                            public void onError(RongIMClient.ErrorCode errorCode) {
                            }

                            @Override // io.rong.imlib.RongIMClient.Callback
                            public void onSuccess() {
                                PublicServiceSubscribeListFragment.this.mAdapter.remove(i);
                                PublicServiceSubscribeListFragment.this.mAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }).show();
            }
            return true;
        }
    }

    private class PublicServiceListAdapter extends BaseAdapter<PublicServiceProfile> {
        LayoutInflater mInflater;

        class ViewHolder {
            TextView introduction;
            TextView name;
            AsyncImageView portrait;

            ViewHolder() {
            }
        }

        public PublicServiceListAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override // io.rong.imkit.widget.adapter.BaseAdapter, android.widget.Adapter
        public int getCount() {
            return super.getCount();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // io.rong.imkit.widget.adapter.BaseAdapter
        protected View newView(Context context, int i, ViewGroup viewGroup) {
            View viewInflate = this.mInflater.inflate(R.layout.rc_item_public_service_list, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.portrait = (AsyncImageView) viewInflate.findViewById(R.id.portrait);
            viewHolder.name = (TextView) viewInflate.findViewById(R.id.name);
            viewHolder.introduction = (TextView) viewInflate.findViewById(R.id.introduction);
            viewInflate.setTag(viewHolder);
            return viewInflate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.rong.imkit.widget.adapter.BaseAdapter
        public void bindView(View view, int i, PublicServiceProfile publicServiceProfile) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            if (publicServiceProfile != null) {
                viewHolder.portrait.setResource(publicServiceProfile.getPortraitUri());
                viewHolder.name.setText(publicServiceProfile.getName());
                viewHolder.introduction.setText(publicServiceProfile.getIntroduction());
            }
        }

        @Override // io.rong.imkit.widget.adapter.BaseAdapter, android.widget.Adapter
        public PublicServiceProfile getItem(int i) {
            return (PublicServiceProfile) super.getItem(i);
        }
    }

    private void getDBData() {
        RongIM.getInstance().getPublicServiceList(new RongIMClient.ResultCallback<PublicServiceProfileList>() { // from class: io.rong.imkit.fragment.PublicServiceSubscribeListFragment.3
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(PublicServiceProfileList publicServiceProfileList) {
                Iterator<PublicServiceProfile> it = publicServiceProfileList.getPublicServiceData().iterator();
                while (it.hasNext()) {
                    RongUserInfoManager.getInstance().setPublicServiceProfile(it.next());
                }
                PublicServiceSubscribeListFragment.this.mAdapter.clear();
                PublicServiceSubscribeListFragment.this.mAdapter.addCollection(publicServiceProfileList.getPublicServiceData());
                PublicServiceSubscribeListFragment.this.mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // io.rong.imkit.fragment.BaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // io.rong.imkit.fragment.UriFragment
    protected void initFragment(Uri uri) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.rc_fr_public_service_sub_list, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RongContext.getInstance().getEventBus().unregister(this);
        super.onDestroyView();
    }

    public void onEvent(Event.PublicServiceFollowableEvent publicServiceFollowableEvent) {
        if (publicServiceFollowableEvent != null) {
            getDBData();
        }
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ListView listView = (ListView) view.findViewById(R.id.rc_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.fragment.PublicServiceSubscribeListFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                PublicServiceProfile item = PublicServiceSubscribeListFragment.this.mAdapter.getItem(i);
                RongIM.getInstance().startConversation(PublicServiceSubscribeListFragment.this.getActivity(), item.getConversationType(), item.getTargetId(), item.getName());
            }
        });
        listView.setOnItemLongClickListener(new AnonymousClass2());
        this.mAdapter = new PublicServiceListAdapter(getActivity());
        listView.setAdapter((ListAdapter) this.mAdapter);
        getDBData();
        RongContext.getInstance().getEventBus().register(this);
    }
}
