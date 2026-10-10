package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.GalleryImageView;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.twitter.sdk.android.tweetui.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GalleryAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class C2777r extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<MediaEntity> f20451a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Context f20452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SwipeToDismissTouchListener.a f20453c;

    C2777r(Context context, SwipeToDismissTouchListener.a aVar) {
        this.f20452b = context;
        this.f20453c = aVar;
    }

    void a(List<MediaEntity> list) {
        this.f20451a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.f20451a.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        GalleryImageView galleryImageView = new GalleryImageView(this.f20452b);
        galleryImageView.setSwipeToDismissCallback(this.f20453c);
        viewGroup.addView(galleryImageView);
        Picasso.a(this.f20452b).a(this.f20451a.get(i).mediaUrlHttps).a(galleryImageView);
        return galleryImageView;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
