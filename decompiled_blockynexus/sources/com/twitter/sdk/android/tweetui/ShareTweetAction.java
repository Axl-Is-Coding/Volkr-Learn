package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.twitter.sdk.android.core.models.User;
import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: loaded from: classes5.dex */
class ShareTweetAction implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.twitter.sdk.android.core.models.m f20357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final L f20358b;

    ShareTweetAction(com.twitter.sdk.android.core.models.m mVar, L l) {
        this.f20357a = mVar;
        this.f20358b = l;
    }

    String a(Resources resources) {
        int i = R.string.tw__share_content_format;
        com.twitter.sdk.android.core.models.m mVar = this.f20357a;
        return resources.getString(i, mVar.D.screenName, Long.toString(mVar.i));
    }

    String b(Resources resources) {
        int i = R.string.tw__share_subject_format;
        User user = this.f20357a.D;
        return resources.getString(i, user.name, user.screenName);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onClick(view.getContext(), view.getResources());
    }

    void onClick(Context context, Resources resources) {
        com.twitter.sdk.android.core.models.m mVar = this.f20357a;
        if (mVar == null || mVar.D == null) {
            return;
        }
        a(Intent.createChooser(a(b(resources), a(resources)), resources.getString(R.string.tw__share_tweet)), context);
    }

    void a(Intent intent, Context context) {
        if (com.twitter.sdk.android.core.h.b(context, intent)) {
            return;
        }
        com.twitter.sdk.android.core.n.e().e("TweetUi", "Activity cannot be found to handle share intent");
    }

    Intent a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setType(NanoHTTPD.MIME_PLAINTEXT);
        return intent;
    }
}
