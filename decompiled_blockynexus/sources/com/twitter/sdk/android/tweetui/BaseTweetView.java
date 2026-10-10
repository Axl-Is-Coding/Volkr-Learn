package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetui.AbstractTweetView;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseTweetView extends AbstractTweetView {
    ColorDrawable avatarMediaBg;
    ImageView avatarView;
    int birdLogoResId;
    View bottomSeparator;
    int containerBgColor;
    ViewGroup quoteTweetHolder;
    QuoteTweetView quoteTweetView;
    int retweetIconResId;
    TextView retweetedByView;
    TextView timestampView;
    TweetActionBarView tweetActionBarView;
    ImageView twitterLogoView;

    BaseTweetView(Context context, com.twitter.sdk.android.core.models.m mVar) {
        this(context, mVar, AbstractTweetView.DEFAULT_STYLE);
    }

    private void initAttributes(int i) {
        this.styleResId = i;
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i, R.styleable.tw__TweetView);
        try {
            setStyleAttributes(typedArrayObtainStyledAttributes);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void initTweetActions() {
        setTweetActionsEnabled(this.tweetActionsEnabled);
        this.tweetActionBarView.setOnActionCallback(new w(this, this.dependencyProvider.b().d(), null));
    }

    private void initXmlAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.tw__TweetView, 0, 0);
        try {
            setXmlDataAttributes(typedArrayObtainStyledAttributes);
            setStyleAttributes(typedArrayObtainStyledAttributes);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void loadTweet() {
        this.dependencyProvider.b().d().b(getTweetId(), new C2773k(this, getTweetId()));
    }

    private void setStyleAttributes(TypedArray typedArray) {
        this.containerBgColor = typedArray.getColor(R.styleable.tw__TweetView_tw__container_bg_color, getResources().getColor(R.color.tw__tweet_light_container_bg_color));
        this.primaryTextColor = typedArray.getColor(R.styleable.tw__TweetView_tw__primary_text_color, getResources().getColor(R.color.tw__tweet_light_primary_text_color));
        this.actionColor = typedArray.getColor(R.styleable.tw__TweetView_tw__action_color, getResources().getColor(R.color.tw__tweet_action_color));
        this.actionHighlightColor = typedArray.getColor(R.styleable.tw__TweetView_tw__action_highlight_color, getResources().getColor(R.color.tw__tweet_action_light_highlight_color));
        this.tweetActionsEnabled = typedArray.getBoolean(R.styleable.tw__TweetView_tw__tweet_actions_enabled, false);
        boolean zA = C2774l.a(this.containerBgColor);
        if (zA) {
            this.photoErrorResId = R.drawable.tw__ic_tweet_photo_error_light;
            this.birdLogoResId = R.drawable.tw__ic_logo_blue;
            this.retweetIconResId = R.drawable.tw__ic_retweet_light;
        } else {
            this.photoErrorResId = R.drawable.tw__ic_tweet_photo_error_dark;
            this.birdLogoResId = R.drawable.tw__ic_logo_white;
            this.retweetIconResId = R.drawable.tw__ic_retweet_dark;
        }
        this.secondaryTextColor = C2774l.a(zA ? 0.4d : 0.35d, zA ? -1 : -16777216, this.primaryTextColor);
        this.mediaBgColor = C2774l.a(zA ? 0.08d : 0.12d, zA ? -16777216 : -1, this.containerBgColor);
        this.avatarMediaBg = new ColorDrawable(this.mediaBgColor);
    }

    private void setTimestamp(com.twitter.sdk.android.core.models.m mVar) {
        String str;
        this.timestampView.setText((mVar == null || (str = mVar.f20239b) == null || !D.c(str)) ? "" : D.b(D.a(getResources(), System.currentTimeMillis(), Long.valueOf(D.a(mVar.f20239b)).longValue())));
    }

    private void setXmlDataAttributes(TypedArray typedArray) {
        long jLongValue = N.a(typedArray.getString(R.styleable.tw__TweetView_tw__tweet_id), -1L).longValue();
        if (jLongValue <= 0) {
            throw new IllegalArgumentException("Invalid tw__tweet_id");
        }
        setPermalinkUri(null, Long.valueOf(jLongValue));
        com.twitter.sdk.android.core.models.n nVar = new com.twitter.sdk.android.core.models.n();
        nVar.a(jLongValue);
        this.tweet = nVar.a();
    }

    public /* synthetic */ void a(com.twitter.sdk.android.core.models.m mVar, View view) {
        E e2 = this.tweetLinkClickListener;
        if (e2 != null) {
            e2.a(mVar, M.b(mVar.D.screenName));
            return;
        }
        if (com.twitter.sdk.android.core.h.b(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(M.b(mVar.D.screenName))))) {
            return;
        }
        com.twitter.sdk.android.core.n.e().e("TweetUi", "Activity cannot be found to open URL");
    }

    protected void applyStyles() {
        setBackgroundColor(this.containerBgColor);
        this.fullNameView.setTextColor(this.primaryTextColor);
        this.screenNameView.setTextColor(this.secondaryTextColor);
        this.contentView.setTextColor(this.primaryTextColor);
        this.tweetMediaView.setMediaBgColor(this.mediaBgColor);
        this.tweetMediaView.setPhotoErrorResId(this.photoErrorResId);
        this.avatarView.setImageDrawable(this.avatarMediaBg);
        this.timestampView.setTextColor(this.secondaryTextColor);
        this.twitterLogoView.setImageResource(this.birdLogoResId);
        this.retweetedByView.setTextColor(this.secondaryTextColor);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    void findSubviews() {
        super.findSubviews();
        this.avatarView = (ImageView) findViewById(R.id.tw__tweet_author_avatar);
        this.timestampView = (TextView) findViewById(R.id.tw__tweet_timestamp);
        this.twitterLogoView = (ImageView) findViewById(R.id.tw__twitter_logo);
        this.retweetedByView = (TextView) findViewById(R.id.tw__tweet_retweeted_by);
        this.tweetActionBarView = (TweetActionBarView) findViewById(R.id.tw__tweet_action_bar);
        this.quoteTweetHolder = (ViewGroup) findViewById(R.id.quote_tweet_holder);
        this.bottomSeparator = findViewById(R.id.bottom_separator);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ com.twitter.sdk.android.core.models.m getTweet() {
        return super.getTweet();
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ long getTweetId() {
        return super.getTweetId();
    }

    void linkifyProfilePhotoView(final com.twitter.sdk.android.core.models.m mVar) {
        if (mVar == null || mVar.D == null) {
            return;
        }
        this.avatarView.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20366a.a(mVar, view);
            }
        });
        this.avatarView.setOnTouchListener(new View.OnTouchListener() { // from class: com.twitter.sdk.android.tweetui.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f20365a.a(view, motionEvent);
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (isTweetUiEnabled()) {
            initTweetActions();
            loadTweet();
        }
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    void render() {
        super.render();
        com.twitter.sdk.android.core.models.m mVarA = M.a(this.tweet);
        setProfilePhotoView(mVarA);
        linkifyProfilePhotoView(mVarA);
        setTimestamp(mVarA);
        setTweetActions(this.tweet);
        showRetweetedBy(this.tweet);
        setQuoteTweet(this.tweet);
    }

    public void setOnActionCallback(com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        this.tweetActionBarView.setOnActionCallback(new w(this, this.dependencyProvider.b().d(), cVar));
        this.tweetActionBarView.setTweet(this.tweet);
    }

    void setProfilePhotoView(com.twitter.sdk.android.core.models.m mVar) {
        User user;
        Picasso picassoA = this.dependencyProvider.a();
        if (picassoA == null) {
            return;
        }
        com.squareup.picasso.D dA = picassoA.a((mVar == null || (user = mVar.D) == null) ? null : UserUtils.a(user, UserUtils.AvatarSize.REASONABLY_SMALL));
        dA.a(this.avatarMediaBg);
        dA.a(this.avatarView);
    }

    void setQuoteTweet(com.twitter.sdk.android.core.models.m mVar) {
        this.quoteTweetView = null;
        this.quoteTweetHolder.removeAllViews();
        if (mVar == null || !M.c(mVar)) {
            this.quoteTweetHolder.setVisibility(8);
            return;
        }
        this.quoteTweetView = new QuoteTweetView(getContext());
        this.quoteTweetView.setStyle(this.primaryTextColor, this.secondaryTextColor, this.actionColor, this.actionHighlightColor, this.mediaBgColor, this.photoErrorResId);
        this.quoteTweetView.setTweet(mVar.v);
        this.quoteTweetView.setTweetLinkClickListener(this.tweetLinkClickListener);
        this.quoteTweetView.setTweetMediaClickListener(this.tweetMediaClickListener);
        this.quoteTweetHolder.setVisibility(0);
        this.quoteTweetHolder.addView(this.quoteTweetView);
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public /* bridge */ /* synthetic */ void setTweet(com.twitter.sdk.android.core.models.m mVar) {
        super.setTweet(mVar);
    }

    void setTweetActions(com.twitter.sdk.android.core.models.m mVar) {
        this.tweetActionBarView.setTweet(mVar);
    }

    public void setTweetActionsEnabled(boolean z) {
        this.tweetActionsEnabled = z;
        if (this.tweetActionsEnabled) {
            this.tweetActionBarView.setVisibility(0);
            this.bottomSeparator.setVisibility(8);
        } else {
            this.tweetActionBarView.setVisibility(8);
            this.bottomSeparator.setVisibility(0);
        }
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public void setTweetLinkClickListener(E e2) {
        super.setTweetLinkClickListener(e2);
        QuoteTweetView quoteTweetView = this.quoteTweetView;
        if (quoteTweetView != null) {
            quoteTweetView.setTweetLinkClickListener(e2);
        }
    }

    @Override // com.twitter.sdk.android.tweetui.AbstractTweetView
    public void setTweetMediaClickListener(F f2) {
        super.setTweetMediaClickListener(f2);
        QuoteTweetView quoteTweetView = this.quoteTweetView;
        if (quoteTweetView != null) {
            quoteTweetView.setTweetMediaClickListener(f2);
        }
    }

    void showRetweetedBy(com.twitter.sdk.android.core.models.m mVar) {
        if (mVar == null || mVar.y == null) {
            this.retweetedByView.setVisibility(8);
        } else {
            this.retweetedByView.setText(getResources().getString(R.string.tw__retweeted_by_format, mVar.D.name));
            this.retweetedByView.setVisibility(0);
        }
    }

    BaseTweetView(Context context, com.twitter.sdk.android.core.models.m mVar, int i) {
        this(context, mVar, i, new AbstractTweetView.a());
    }

    BaseTweetView(Context context, com.twitter.sdk.android.core.models.m mVar, int i, AbstractTweetView.a aVar) {
        super(context, null, i, aVar);
        initAttributes(i);
        applyStyles();
        if (isTweetUiEnabled()) {
            initTweetActions();
            setTweet(mVar);
        }
    }

    public BaseTweetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseTweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, new AbstractTweetView.a());
        initXmlAttributes(context, attributeSet);
        applyStyles();
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        ImageView imageView = (ImageView) view;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                view.performClick();
            } else if (action != 3) {
                return false;
            }
            imageView.getDrawable().clearColorFilter();
            imageView.invalidate();
            return false;
        }
        imageView.getDrawable().setColorFilter(getResources().getColor(R.color.tw__black_opacity_10), PorterDuff.Mode.SRC_ATOP);
        imageView.invalidate();
        return false;
    }
}
