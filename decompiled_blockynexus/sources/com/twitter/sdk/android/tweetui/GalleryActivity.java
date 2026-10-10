package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GalleryActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    GalleryItem f20331a;

    public static class GalleryItem implements Serializable {
        public final List<MediaEntity> mediaEntities;
        public final int mediaEntityIndex;
        public final long tweetId;

        public GalleryItem(int i, List<MediaEntity> list) {
            this(0L, i, list);
        }

        public GalleryItem(long j, int i, List<MediaEntity> list) {
            this.tweetId = j;
            this.mediaEntityIndex = i;
            this.mediaEntities = list;
        }
    }

    GalleryItem a() {
        MediaEntity mediaEntity = (MediaEntity) getIntent().getSerializableExtra("MEDIA_ENTITY");
        return mediaEntity != null ? new GalleryItem(0, Collections.singletonList(mediaEntity)) : (GalleryItem) getIntent().getSerializableExtra("GALLERY_ITEM");
    }

    ViewPager.e b() {
        return new p(this);
    }

    SwipeToDismissTouchListener.a getSwipeToDismissCallback() {
        return new q(this);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__gallery_activity);
        this.f20331a = a();
        C2777r c2777r = new C2777r(this, getSwipeToDismissCallback());
        c2777r.a(this.f20331a.mediaEntities);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tw__view_pager);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.tw__gallery_page_margin));
        viewPager.addOnPageChangeListener(b());
        viewPager.setAdapter(c2777r);
        viewPager.setCurrentItem(this.f20331a.mediaEntityIndex);
    }
}
