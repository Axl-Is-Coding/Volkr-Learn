package com.twitter.sdk.android.tweetui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetui.internal.AspectRatioFrameLayout;
import com.twitter.sdk.android.tweetui.internal.MediaBadgeView;
import com.twitter.sdk.android.tweetui.internal.TweetMediaView;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractTweetView extends RelativeLayout {
    static final double DEFAULT_ASPECT_RATIO = 1.7777777777777777d;
    static final int DEFAULT_STYLE = R.style.tw__TweetLightStyle;
    static final String EMPTY_STRING = "";
    static final long INVALID_ID = -1;
    static final double MEDIA_BG_DARK_OPACITY = 0.12d;
    static final double MEDIA_BG_LIGHT_OPACITY = 0.08d;
    static final double SECONDARY_TEXT_COLOR_DARK_OPACITY = 0.35d;
    static final double SECONDARY_TEXT_COLOR_LIGHT_OPACITY = 0.4d;
    static final String TAG = "TweetUi";
    int actionColor;
    int actionHighlightColor;
    TextView contentView;
    final a dependencyProvider;
    TextView fullNameView;
    private s linkClickListener;
    MediaBadgeView mediaBadgeView;
    int mediaBgColor;
    AspectRatioFrameLayout mediaContainer;
    private Uri permalinkUri;
    int photoErrorResId;
    int primaryTextColor;
    TextView screenNameView;
    int secondaryTextColor;
    int styleResId;
    com.twitter.sdk.android.core.models.m tweet;
    boolean tweetActionsEnabled;
    E tweetLinkClickListener;
    F tweetMediaClickListener;
    TweetMediaView tweetMediaView;

    class PermalinkClickListener implements View.OnClickListener {
        PermalinkClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AbstractTweetView.this.getPermalinkUri() == null) {
                return;
            }
            AbstractTweetView.this.launchPermalink();
        }
    }

    static class a {
        a() {
        }

        Picasso a() {
            return L.c().b();
        }

        L b() {
            return L.c();
        }
    }

    AbstractTweetView(Context context, AttributeSet attributeSet, int i, a aVar) {
        super(context, attributeSet, i);
        this.dependencyProvider = aVar;
        inflateView(context);
        findSubviews();
    }

    private void inflateView(Context context) {
        LayoutInflater.from(context).inflate(getLayout(), (ViewGroup) this, true);
    }

    private void setName(com.twitter.sdk.android.core.models.m mVar) {
        User user;
        if (mVar == null || (user = mVar.D) == null) {
            this.fullNameView.setText("");
        } else {
            this.fullNameView.setText(N.a(user.name));
        }
    }

    private void setPermalinkLauncher() {
        setOnClickListener(new PermalinkClickListener());
    }

    private void setScreenName(com.twitter.sdk.android.core.models.m mVar) {
        User user;
        if (mVar == null || (user = mVar.D) == null) {
            this.screenNameView.setText("");
        } else {
            this.screenNameView.setText(UserUtils.a(N.a(user.screenName)));
        }
    }

    @TargetApi(16)
    private void setText(com.twitter.sdk.android.core.models.m mVar) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.contentView.setImportantForAccessibility(2);
        }
        CharSequence charSequenceA = N.a(getLinkifiedText(mVar));
        com.twitter.sdk.android.tweetui.internal.k.a(this.contentView);
        if (TextUtils.isEmpty(charSequenceA)) {
            this.contentView.setText("");
            this.contentView.setVisibility(8);
        } else {
            this.contentView.setText(charSequenceA);
            this.contentView.setVisibility(0);
        }
    }

    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        E e2 = this.tweetLinkClickListener;
        if (e2 != null) {
            e2.a(this.tweet, str);
            return;
        }
        if (com.twitter.sdk.android.core.h.b(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)))) {
            return;
        }
        com.twitter.sdk.android.core.n.e().e(TAG, "Activity cannot be found to open URL");
    }

    protected void clearTweetMedia() {
        this.mediaContainer.setVisibility(8);
    }

    void findSubviews() {
        this.fullNameView = (TextView) findViewById(R.id.tw__tweet_author_full_name);
        this.screenNameView = (TextView) findViewById(R.id.tw__tweet_author_screen_name);
        this.mediaContainer = (AspectRatioFrameLayout) findViewById(R.id.tw__aspect_ratio_media_container);
        this.tweetMediaView = (TweetMediaView) findViewById(R.id.tweet_media_view);
        this.contentView = (TextView) findViewById(R.id.tw__tweet_text);
        this.mediaBadgeView = (MediaBadgeView) findViewById(R.id.tw__tweet_media_badge);
    }

    protected double getAspectRatio(MediaEntity mediaEntity) {
        MediaEntity.Sizes sizes;
        MediaEntity.Size size;
        int i;
        int i2;
        if (mediaEntity == null || (sizes = mediaEntity.sizes) == null || (size = sizes.medium) == null || (i = size.w) == 0 || (i2 = size.h) == 0) {
            return DEFAULT_ASPECT_RATIO;
        }
        double d2 = i;
        double d3 = i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    protected abstract double getAspectRatioForPhotoEntity(int i);

    abstract int getLayout();

    protected s getLinkClickListener() {
        if (this.linkClickListener == null) {
            this.linkClickListener = new s() { // from class: com.twitter.sdk.android.tweetui.a
                @Override // com.twitter.sdk.android.tweetui.s
                public final void a(String str) {
                    this.f20364a.a(str);
                }
            };
        }
        return this.linkClickListener;
    }

    protected CharSequence getLinkifiedText(com.twitter.sdk.android.core.models.m mVar) {
        C2776n c2776nA = this.dependencyProvider.b().d().a(mVar);
        if (c2776nA == null) {
            return null;
        }
        com.twitter.sdk.android.core.models.d dVar = mVar.H;
        return J.a(c2776nA, getLinkClickListener(), this.actionColor, this.actionHighlightColor, M.c(mVar), dVar != null && com.twitter.sdk.android.core.internal.p.c(dVar));
    }

    Uri getPermalinkUri() {
        return this.permalinkUri;
    }

    public com.twitter.sdk.android.core.models.m getTweet() {
        return this.tweet;
    }

    public long getTweetId() {
        com.twitter.sdk.android.core.models.m mVar = this.tweet;
        if (mVar == null) {
            return -1L;
        }
        return mVar.i;
    }

    boolean isTweetUiEnabled() {
        if (isInEditMode()) {
            return false;
        }
        try {
            this.dependencyProvider.b();
            return true;
        } catch (IllegalStateException e2) {
            com.twitter.sdk.android.core.n.e().e(TAG, e2.getMessage());
            setEnabled(false);
            return false;
        }
    }

    void launchPermalink() {
        if (com.twitter.sdk.android.core.h.b(getContext(), new Intent("android.intent.action.VIEW", getPermalinkUri()))) {
            return;
        }
        com.twitter.sdk.android.core.n.e().e(TAG, "Activity cannot be found to open permalink URI");
    }

    void render() {
        com.twitter.sdk.android.core.models.m mVarA = M.a(this.tweet);
        setName(mVarA);
        setScreenName(mVarA);
        setTweetMedia(mVarA);
        setText(mVarA);
        setContentDescription(mVarA);
        if (M.b(this.tweet)) {
            setPermalinkUri(this.tweet.D.screenName, Long.valueOf(getTweetId()));
        } else {
            this.permalinkUri = null;
        }
        setPermalinkLauncher();
    }

    void setContentDescription(com.twitter.sdk.android.core.models.m mVar) {
        if (!M.b(mVar)) {
            setContentDescription(getResources().getString(R.string.tw__loading_tweet));
            return;
        }
        C2776n c2776nA = this.dependencyProvider.b().d().a(mVar);
        String str = c2776nA != null ? c2776nA.f20437a : null;
        long jA = D.a(mVar.f20239b);
        setContentDescription(getResources().getString(R.string.tw__tweet_content_description, N.a(mVar.D.name), N.a(str), N.a(jA != -1 ? DateFormat.getDateInstance().format(new Date(jA)) : null)));
    }

    void setPermalinkUri(String str, Long l) {
        if (l.longValue() <= 0) {
            return;
        }
        this.permalinkUri = M.a(str, l.longValue());
    }

    public void setTweet(com.twitter.sdk.android.core.models.m mVar) {
        this.tweet = mVar;
        render();
    }

    public void setTweetLinkClickListener(E e2) {
        this.tweetLinkClickListener = e2;
    }

    final void setTweetMedia(com.twitter.sdk.android.core.models.m mVar) {
        clearTweetMedia();
        if (mVar == null) {
            return;
        }
        com.twitter.sdk.android.core.models.d dVar = mVar.H;
        if (dVar != null && com.twitter.sdk.android.core.internal.p.c(dVar)) {
            com.twitter.sdk.android.core.models.d dVar2 = mVar.H;
            com.twitter.sdk.android.core.models.g gVarA = com.twitter.sdk.android.core.internal.p.a(dVar2);
            String strB = com.twitter.sdk.android.core.internal.p.b(dVar2);
            if (gVarA == null || TextUtils.isEmpty(strB)) {
                return;
            }
            setViewsForMedia(getAspectRatio(gVarA));
            this.tweetMediaView.setVineCard(mVar);
            this.mediaBadgeView.setVisibility(0);
            this.mediaBadgeView.setCard(dVar2);
            return;
        }
        if (com.twitter.sdk.android.tweetui.internal.l.f(mVar)) {
            MediaEntity mediaEntityD = com.twitter.sdk.android.tweetui.internal.l.d(mVar);
            setViewsForMedia(getAspectRatio(mediaEntityD));
            this.tweetMediaView.setTweetMediaEntities(this.tweet, Collections.singletonList(mediaEntityD));
            this.mediaBadgeView.setVisibility(0);
            this.mediaBadgeView.setMediaEntity(mediaEntityD);
            return;
        }
        if (com.twitter.sdk.android.tweetui.internal.l.e(mVar)) {
            List<MediaEntity> listB = com.twitter.sdk.android.tweetui.internal.l.b(mVar);
            setViewsForMedia(getAspectRatioForPhotoEntity(listB.size()));
            this.tweetMediaView.setTweetMediaEntities(mVar, listB);
            this.mediaBadgeView.setVisibility(8);
        }
    }

    public void setTweetMediaClickListener(F f2) {
        this.tweetMediaClickListener = f2;
        this.tweetMediaView.setTweetMediaClickListener(f2);
    }

    void setViewsForMedia(double d2) {
        this.mediaContainer.setVisibility(0);
        this.mediaContainer.setAspectRatio(d2);
        this.tweetMediaView.setVisibility(0);
    }

    protected double getAspectRatio(com.twitter.sdk.android.core.models.g gVar) {
        int i;
        int i2;
        if (gVar == null || (i = gVar.f20228b) == 0 || (i2 = gVar.f20227a) == 0) {
            return DEFAULT_ASPECT_RATIO;
        }
        double d2 = i;
        double d3 = i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }
}
