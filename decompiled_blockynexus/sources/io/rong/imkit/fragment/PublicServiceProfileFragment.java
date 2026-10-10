package io.rong.imkit.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.F;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongContext;
import io.rong.imkit.RongIM;
import io.rong.imkit.model.Event;
import io.rong.imkit.userInfoCache.RongUserInfoManager;
import io.rong.imkit.widget.AsyncImageView;
import io.rong.imkit.widget.LoadingDialogFragment;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.PublicServiceProfile;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class PublicServiceProfileFragment extends DispatchResultFragment {
    public static final String AGS_PUBLIC_ACCOUNT_INFO = "arg_public_account_info";
    private TextView mAccountTV;
    private Conversation.ConversationType mConversationType;
    private TextView mDescriptionTV;
    private Button mEnterBtn;
    private Button mFollowBtn;
    private LoadingDialogFragment mLoadingDialogFragment;
    private TextView mNameTV;
    private AsyncImageView mPortraitIV;
    PublicServiceProfile mPublicAccountInfo;
    private String mTargetId;
    private Button mUnfollowBtn;
    private String name;

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(final PublicServiceProfile publicServiceProfile) {
        if (publicServiceProfile != null) {
            this.mPortraitIV.setResource(publicServiceProfile.getPortraitUri());
            this.mNameTV.setText(publicServiceProfile.getName());
            this.mAccountTV.setText(String.format(getResources().getString(R.string.rc_pub_service_info_account), publicServiceProfile.getTargetId()));
            this.mDescriptionTV.setText(publicServiceProfile.getIntroduction());
            boolean zIsFollow = publicServiceProfile.isFollow();
            if (publicServiceProfile.isGlobal()) {
                if (getFragmentManager() != null) {
                    F fA = getFragmentManager().a();
                    fA.a(R.id.rc_layout, SetConversationNotificationFragment.newInstance());
                    fA.b();
                }
                this.mFollowBtn.setVisibility(8);
                this.mEnterBtn.setVisibility(0);
                this.mUnfollowBtn.setVisibility(8);
            } else if (zIsFollow) {
                if (getFragmentManager() != null) {
                    F fA2 = getFragmentManager().a();
                    fA2.a(R.id.rc_layout, SetConversationNotificationFragment.newInstance());
                    fA2.b();
                }
                this.mFollowBtn.setVisibility(8);
                this.mEnterBtn.setVisibility(0);
                this.mUnfollowBtn.setVisibility(0);
            } else {
                this.mFollowBtn.setVisibility(0);
                this.mEnterBtn.setVisibility(8);
                this.mUnfollowBtn.setVisibility(8);
            }
            this.mEnterBtn.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.PublicServiceProfileFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RongIM.PublicServiceBehaviorListener publicServiceBehaviorListener = RongContext.getInstance().getPublicServiceBehaviorListener();
                    if (publicServiceBehaviorListener == null || !publicServiceBehaviorListener.onEnterConversationClick(view.getContext(), publicServiceProfile)) {
                        if (PublicServiceProfileFragment.this.getActivity() != null) {
                            PublicServiceProfileFragment.this.getActivity().finish();
                        }
                        RongIM.getInstance().startConversation(PublicServiceProfileFragment.this.getActivity(), publicServiceProfile.getConversationType(), publicServiceProfile.getTargetId(), publicServiceProfile.getName());
                    }
                }
            });
            this.mFollowBtn.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.PublicServiceProfileFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(final View view) {
                    Conversation.PublicServiceType publicServiceType;
                    if (PublicServiceProfileFragment.this.mConversationType == Conversation.ConversationType.APP_PUBLIC_SERVICE) {
                        publicServiceType = Conversation.PublicServiceType.APP_PUBLIC_SERVICE;
                    } else if (PublicServiceProfileFragment.this.mConversationType == Conversation.ConversationType.PUBLIC_SERVICE) {
                        publicServiceType = Conversation.PublicServiceType.PUBLIC_SERVICE;
                    } else {
                        System.err.print("the public service type is error!!");
                        publicServiceType = null;
                    }
                    RongIM.getInstance().subscribePublicService(publicServiceType, publicServiceProfile.getTargetId(), new RongIMClient.OperationCallback() { // from class: io.rong.imkit.fragment.PublicServiceProfileFragment.3.1
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                            PublicServiceProfileFragment.this.mLoadingDialogFragment.dismiss();
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            PublicServiceProfileFragment.this.mLoadingDialogFragment.dismiss();
                            PublicServiceProfileFragment.this.mFollowBtn.setVisibility(8);
                            PublicServiceProfileFragment.this.mEnterBtn.setVisibility(0);
                            PublicServiceProfileFragment.this.mUnfollowBtn.setVisibility(0);
                            RongUserInfoManager.getInstance().setPublicServiceProfile(publicServiceProfile);
                            RongContext.getInstance().getEventBus().post(Event.PublicServiceFollowableEvent.obtain(publicServiceProfile.getTargetId(), publicServiceProfile.getConversationType(), true));
                            RongIM.PublicServiceBehaviorListener publicServiceBehaviorListener = RongContext.getInstance().getPublicServiceBehaviorListener();
                            if (publicServiceBehaviorListener == null || !publicServiceBehaviorListener.onFollowClick(view.getContext(), publicServiceProfile)) {
                                if (PublicServiceProfileFragment.this.getActivity() != null) {
                                    PublicServiceProfileFragment.this.getActivity().finish();
                                }
                                RongIM.getInstance().startConversation(PublicServiceProfileFragment.this.getActivity(), publicServiceProfile.getConversationType(), publicServiceProfile.getTargetId(), publicServiceProfile.getName());
                            }
                        }
                    });
                    PublicServiceProfileFragment.this.mLoadingDialogFragment.show(PublicServiceProfileFragment.this.getFragmentManager());
                }
            });
            this.mUnfollowBtn.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.fragment.PublicServiceProfileFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(final View view) {
                    Conversation.PublicServiceType publicServiceType;
                    if (PublicServiceProfileFragment.this.mConversationType == Conversation.ConversationType.APP_PUBLIC_SERVICE) {
                        publicServiceType = Conversation.PublicServiceType.APP_PUBLIC_SERVICE;
                    } else if (PublicServiceProfileFragment.this.mConversationType == Conversation.ConversationType.PUBLIC_SERVICE) {
                        publicServiceType = Conversation.PublicServiceType.PUBLIC_SERVICE;
                    } else {
                        System.err.print("the public service type is error!!");
                        publicServiceType = null;
                    }
                    RongIM.getInstance().unsubscribePublicService(publicServiceType, publicServiceProfile.getTargetId(), new RongIMClient.OperationCallback() { // from class: io.rong.imkit.fragment.PublicServiceProfileFragment.4.1
                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onError(RongIMClient.ErrorCode errorCode) {
                        }

                        @Override // io.rong.imlib.RongIMClient.Callback
                        public void onSuccess() {
                            PublicServiceProfileFragment.this.mFollowBtn.setVisibility(0);
                            PublicServiceProfileFragment.this.mEnterBtn.setVisibility(8);
                            PublicServiceProfileFragment.this.mUnfollowBtn.setVisibility(8);
                            RongContext.getInstance().getEventBus().post(Event.PublicServiceFollowableEvent.obtain(publicServiceProfile.getTargetId(), publicServiceProfile.getConversationType(), false));
                            RongIM.PublicServiceBehaviorListener publicServiceBehaviorListener = RongContext.getInstance().getPublicServiceBehaviorListener();
                            if ((publicServiceBehaviorListener == null || !publicServiceBehaviorListener.onUnFollowClick(view.getContext(), publicServiceProfile)) && PublicServiceProfileFragment.this.getActivity() != null) {
                                PublicServiceProfileFragment.this.getActivity().finish();
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // io.rong.imkit.fragment.BaseFragment, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // io.rong.imkit.fragment.UriFragment
    protected void initFragment(Uri uri) {
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.mPublicAccountInfo = (PublicServiceProfile) getActivity().getIntent().getParcelableExtra(AGS_PUBLIC_ACCOUNT_INFO);
        }
        if (uri != null) {
            PublicServiceProfile publicServiceProfile = this.mPublicAccountInfo;
            if (publicServiceProfile != null) {
                this.mConversationType = publicServiceProfile.getConversationType();
                this.mTargetId = this.mPublicAccountInfo.getTargetId();
                this.name = this.mPublicAccountInfo.getName();
            } else {
                String lastPathSegment = uri.getLastPathSegment();
                this.mConversationType = Conversation.ConversationType.valueOf(!TextUtils.isEmpty(lastPathSegment) ? lastPathSegment.toUpperCase(Locale.US) : "");
                this.mTargetId = uri.getQueryParameter("targetId");
                this.name = uri.getQueryParameter("name");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_fr_public_service_inf, viewGroup, false);
        this.mPortraitIV = (AsyncImageView) viewInflate.findViewById(R.id.portrait);
        this.mNameTV = (TextView) viewInflate.findViewById(R.id.name);
        this.mAccountTV = (TextView) viewInflate.findViewById(R.id.account);
        this.mDescriptionTV = (TextView) viewInflate.findViewById(R.id.description);
        this.mEnterBtn = (Button) viewInflate.findViewById(R.id.enter);
        this.mFollowBtn = (Button) viewInflate.findViewById(R.id.follow);
        this.mUnfollowBtn = (Button) viewInflate.findViewById(R.id.unfollow);
        return viewInflate;
    }

    @Override // io.rong.imkit.fragment.UriFragment, io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLoadingDialogFragment = LoadingDialogFragment.newInstance("", getResources().getString(R.string.rc_notice_data_is_loading));
        PublicServiceProfile publicServiceProfile = this.mPublicAccountInfo;
        if (publicServiceProfile != null) {
            initData(publicServiceProfile);
            return;
        }
        if (TextUtils.isEmpty(this.mTargetId)) {
            return;
        }
        Conversation.PublicServiceType publicServiceType = null;
        Conversation.ConversationType conversationType = this.mConversationType;
        if (conversationType == Conversation.ConversationType.APP_PUBLIC_SERVICE) {
            publicServiceType = Conversation.PublicServiceType.APP_PUBLIC_SERVICE;
        } else if (conversationType == Conversation.ConversationType.PUBLIC_SERVICE) {
            publicServiceType = Conversation.PublicServiceType.PUBLIC_SERVICE;
        } else {
            System.err.print("the public service type is error!!");
        }
        RongIM.getInstance().getPublicServiceProfile(publicServiceType, this.mTargetId, new RongIMClient.ResultCallback<PublicServiceProfile>() { // from class: io.rong.imkit.fragment.PublicServiceProfileFragment.1
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
                RLog.e("PublicServiceProfileFragment", "Failure to get data!!!");
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(PublicServiceProfile publicServiceProfile2) {
                if (publicServiceProfile2 != null) {
                    PublicServiceProfileFragment.this.initData(publicServiceProfile2);
                    RongUserInfoManager.getInstance().setPublicServiceProfile(publicServiceProfile2);
                }
            }
        });
    }
}
