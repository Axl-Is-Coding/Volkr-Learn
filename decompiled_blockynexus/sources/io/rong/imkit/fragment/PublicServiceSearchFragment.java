package io.rong.imkit.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.LoadingDialogFragment;
import io.rong.imkit.widget.adapter.BaseAdapter;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.PublicServiceProfile;
import io.rong.imlib.model.PublicServiceProfileList;

/* JADX INFO: loaded from: classes5.dex */
public class PublicServiceSearchFragment extends DispatchResultFragment {
    private static final String TAG = "PublicServiceSearchFragment";
    private PublicServiceListAdapter mAdapter;
    private EditText mEditText;
    private ListView mListView;
    private LoadingDialogFragment mLoadingDialogFragment;
    private Button mSearchBtn;

    private class PublicServiceListAdapter extends BaseAdapter<PublicServiceProfile> {
        LayoutInflater mInflater;

        class ViewHolder {
            TextView description;
            AsyncImageView portrait;
            TextView title;

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
            View viewInflate = this.mInflater.inflate(R.layout.rc_item_public_service_search, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.portrait = (AsyncImageView) viewInflate.findViewById(R.id.rc_portrait);
            viewHolder.title = (TextView) viewInflate.findViewById(R.id.rc_title);
            viewHolder.description = (TextView) viewInflate.findViewById(R.id.rc_description);
            viewInflate.setTag(viewHolder);
            return viewInflate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.rong.imkit.widget.adapter.BaseAdapter
        public void bindView(View view, int i, PublicServiceProfile publicServiceProfile) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            if (publicServiceProfile != null) {
                viewHolder.portrait.setResource(publicServiceProfile.getPortraitUri());
                viewHolder.title.setText(publicServiceProfile.getName());
                viewHolder.description.setText(publicServiceProfile.getIntroduction());
            }
        }

        @Override // io.rong.imkit.widget.adapter.BaseAdapter, android.widget.Adapter
        public PublicServiceProfile getItem(int i) {
            return (PublicServiceProfile) super.getItem(i);
        }
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
        View viewInflate = layoutInflater.inflate(R.layout.rc_fr_public_service_search, viewGroup, false);
        this.mEditText = (EditText) viewInflate.findViewById(R.id.rc_search_ed);
        this.mSearchBtn = (Button) viewInflate.findViewById(R.id.rc_search_btn);
        this.mListView = (ListView) viewInflate.findViewById(R.id.rc_search_list);
        RongContext.getInstance().getEventBus().register(this);
        return viewInflate;
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        RongContext.getInstance().getEventBus().unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(Event.PublicServiceFollowableEvent publicServiceFollowableEvent) {
        if (publicServiceFollowableEvent == null || getActivity() == null) {
            return;
        }
        RLog.d(TAG, "onEventMainThread PublicAccountIsFollowEvent, follow=" + publicServiceFollowableEvent.isFollow());
        getActivity().finish();
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLoadingDialogFragment = LoadingDialogFragment.newInstance("", getResources().getString(R.string.rc_notice_data_is_loading));
        this.mSearchBtn.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.PublicServiceSearchFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PublicServiceSearchFragment.this.mLoadingDialogFragment.show(PublicServiceSearchFragment.this.getFragmentManager());
                RongIM.getInstance().searchPublicService(RongIMClient.SearchType.FUZZY, PublicServiceSearchFragment.this.mEditText.getText().toString(), new RongIMClient.ResultCallback<PublicServiceProfileList>() { // from class: io.rong.imkit.fragment.PublicServiceSearchFragment.1.1
                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        PublicServiceSearchFragment.this.mLoadingDialogFragment.dismiss();
                    }

                    @Override // io.rong.imlib.RongIMClient.ResultCallback
                    public void onSuccess(PublicServiceProfileList publicServiceProfileList) {
                        PublicServiceSearchFragment.this.mAdapter.clear();
                        PublicServiceSearchFragment.this.mAdapter.addCollection(publicServiceProfileList.getPublicServiceData());
                        PublicServiceSearchFragment.this.mAdapter.notifyDataSetChanged();
                        PublicServiceSearchFragment.this.mLoadingDialogFragment.dismiss();
                    }
                });
            }
        });
        this.mAdapter = new PublicServiceListAdapter(getActivity());
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.fragment.PublicServiceSearchFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                PublicServiceProfile item = PublicServiceSearchFragment.this.mAdapter.getItem(i);
                if (item.isFollow()) {
                    RongIM.getInstance().startConversation(PublicServiceSearchFragment.this.getActivity(), item.getConversationType(), item.getTargetId(), item.getName());
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("rong://" + view2.getContext().getApplicationInfo().packageName).buildUpon().appendPath("publicServiceProfile").appendPath(item.getConversationType().getName().toLowerCase()).appendQueryParameter("targetId", item.getTargetId()).build());
                intent.putExtra(PublicServiceProfileFragment.AGS_PUBLIC_ACCOUNT_INFO, item);
                PublicServiceSearchFragment.this.startActivity(intent);
            }
        });
    }
}
