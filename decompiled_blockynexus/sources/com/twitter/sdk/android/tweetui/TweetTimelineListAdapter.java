package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.twitter.sdk.android.core.TwitterException;

/* JADX INFO: loaded from: classes5.dex */
public class TweetTimelineListAdapter extends A<com.twitter.sdk.android.core.models.m> {
    protected com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> actionCallback;
    protected final int styleResId;
    protected L tweetUi;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> f20360a;

        public Builder setOnActionCallback(com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
            this.f20360a = cVar;
            return this;
        }
    }

    public TweetTimelineListAdapter(Context context, x<com.twitter.sdk.android.core.models.m> xVar) {
        this(context, xVar, R.style.tw__TweetLightStyle, null);
    }

    @Override // com.twitter.sdk.android.tweetui.A, android.widget.Adapter
    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    @Override // com.twitter.sdk.android.tweetui.A, android.widget.Adapter
    public /* bridge */ /* synthetic */ long getItemId(int i) {
        return super.getItemId(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.twitter.sdk.android.core.models.m item = getItem(i);
        if (view != null) {
            ((BaseTweetView) view).setTweet(item);
            return view;
        }
        CompactTweetView compactTweetView = new CompactTweetView(this.context, item, this.styleResId);
        compactTweetView.setOnActionCallback(this.actionCallback);
        return compactTweetView;
    }

    @Override // com.twitter.sdk.android.tweetui.A, android.widget.BaseAdapter
    public /* bridge */ /* synthetic */ void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // com.twitter.sdk.android.tweetui.A, android.widget.BaseAdapter
    public /* bridge */ /* synthetic */ void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
    }

    @Override // com.twitter.sdk.android.tweetui.A
    public /* bridge */ /* synthetic */ void refresh(com.twitter.sdk.android.core.c cVar) {
        super.refresh(cVar);
    }

    @Override // com.twitter.sdk.android.tweetui.A, android.widget.BaseAdapter, android.widget.Adapter
    public /* bridge */ /* synthetic */ void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
    }

    @Override // com.twitter.sdk.android.tweetui.A, android.widget.BaseAdapter, android.widget.Adapter
    public /* bridge */ /* synthetic */ void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
    }

    TweetTimelineListAdapter(Context context, x<com.twitter.sdk.android.core.models.m> xVar, int i, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        this(context, new z(xVar), i, cVar, L.c());
    }

    static class a extends com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        z<com.twitter.sdk.android.core.models.m> f20361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> f20362b;

        a(z<com.twitter.sdk.android.core.models.m> zVar, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
            this.f20361a = zVar;
            this.f20362b = cVar;
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.models.m> kVar) {
            this.f20361a.a(kVar.f20217a);
            com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar = this.f20362b;
            if (cVar != null) {
                cVar.a(kVar);
            }
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(TwitterException twitterException) {
            com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar = this.f20362b;
            if (cVar != null) {
                cVar.a(twitterException);
            }
        }
    }

    TweetTimelineListAdapter(Context context, z<com.twitter.sdk.android.core.models.m> zVar, int i, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar, L l) {
        super(context, zVar);
        this.styleResId = i;
        this.actionCallback = new a(zVar, cVar);
        this.tweetUi = l;
    }
}
