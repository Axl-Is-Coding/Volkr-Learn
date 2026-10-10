package com.twitter.sdk.android.tweetui;

import android.view.View;
import com.twitter.sdk.android.core.TwitterApiException;
import com.twitter.sdk.android.core.TwitterException;

/* JADX INFO: loaded from: classes5.dex */
class LikeTweetAction extends BaseTweetAction implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.twitter.sdk.android.core.models.m f20350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final I f20351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final L f20352d;

    static class a extends com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ToggleImageButton f20353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.twitter.sdk.android.core.models.m f20354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> f20355c;

        a(ToggleImageButton toggleImageButton, com.twitter.sdk.android.core.models.m mVar, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
            this.f20353a = toggleImageButton;
            this.f20354b = mVar;
            this.f20355c = cVar;
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(com.twitter.sdk.android.core.k<com.twitter.sdk.android.core.models.m> kVar) {
            this.f20355c.a(kVar);
        }

        @Override // com.twitter.sdk.android.core.c
        public void a(TwitterException twitterException) {
            if (!(twitterException instanceof TwitterApiException)) {
                this.f20353a.setToggledOn(this.f20354b.g);
                this.f20355c.a(twitterException);
                return;
            }
            int errorCode = ((TwitterApiException) twitterException).getErrorCode();
            if (errorCode == 139) {
                com.twitter.sdk.android.core.models.n nVar = new com.twitter.sdk.android.core.models.n();
                nVar.a(this.f20354b);
                nVar.a(true);
                this.f20355c.a(new com.twitter.sdk.android.core.k<>(nVar.a(), null));
                return;
            }
            if (errorCode != 144) {
                this.f20353a.setToggledOn(this.f20354b.g);
                this.f20355c.a(twitterException);
                return;
            }
            com.twitter.sdk.android.core.models.n nVar2 = new com.twitter.sdk.android.core.models.n();
            nVar2.a(this.f20354b);
            nVar2.a(false);
            this.f20355c.a(new com.twitter.sdk.android.core.k<>(nVar2.a(), null));
        }
    }

    LikeTweetAction(com.twitter.sdk.android.core.models.m mVar, L l, com.twitter.sdk.android.core.c<com.twitter.sdk.android.core.models.m> cVar) {
        super(cVar);
        this.f20350b = mVar;
        this.f20352d = l;
        this.f20351c = l.d();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof ToggleImageButton) {
            ToggleImageButton toggleImageButton = (ToggleImageButton) view;
            com.twitter.sdk.android.core.models.m mVar = this.f20350b;
            if (mVar.g) {
                this.f20351c.c(mVar.i, new a(toggleImageButton, mVar, getActionCallback()));
            } else {
                this.f20351c.a(mVar.i, new a(toggleImageButton, mVar, getActionCallback()));
            }
        }
    }
}
