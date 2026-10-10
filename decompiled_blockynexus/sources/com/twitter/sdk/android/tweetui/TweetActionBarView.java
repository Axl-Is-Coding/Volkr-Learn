package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class TweetActionBarView extends LinearLayout {
    com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> actionCallback;
    final a dependencyProvider;
    ToggleImageButton likeButton;
    ImageButton shareButton;

    static class a {
        a() {
        }

        L a() {
            return L.c();
        }
    }

    public TweetActionBarView(Context context) {
        this(context, null, new a());
    }

    void findSubviews() {
        this.likeButton = (ToggleImageButton) findViewById(R.id.tw__tweet_like_button);
        this.shareButton = (ImageButton) findViewById(R.id.tw__tweet_share_button);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        findSubviews();
    }

    void setLike(com.twitter.sdk.android.core.models.m mVar) {
        L lA = this.dependencyProvider.a();
        if (mVar != null) {
            this.likeButton.setToggledOn(mVar.g);
            this.likeButton.setOnClickListener(new LikeTweetAction(mVar, lA, this.actionCallback));
        }
    }

    void setOnActionCallback(com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        this.actionCallback = cVar;
    }

    void setShare(com.twitter.sdk.android.core.models.m mVar) {
        L lA = this.dependencyProvider.a();
        if (mVar != null) {
            this.shareButton.setOnClickListener(new ShareTweetAction(mVar, lA));
        }
    }

    void setTweet(com.twitter.sdk.android.core.models.m mVar) {
        setLike(mVar);
        setShare(mVar);
    }

    public TweetActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new a());
    }

    TweetActionBarView(Context context, AttributeSet attributeSet, a aVar) {
        super(context, attributeSet);
        this.dependencyProvider = aVar;
    }
}
