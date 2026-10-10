package com.twitter.sdk.android.core.identity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import com.twitter.sdk.android.core.R;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.w;
import com.twitter.sdk.android.core.y;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class TwitterLoginButton extends Button {
    static final String ERROR_MSG_NO_ACTIVITY = "TwitterLoginButton requires an activity. Override getActivity to provide the activity for this button.";
    static final String TAG = "Twitter";
    final WeakReference<Activity> activityRef;
    volatile h authClient;
    com.twitter.sdk.android.core.c<y> callback;
    View.OnClickListener onClickListener;

    private class LoginClickListener implements View.OnClickListener {
        private LoginClickListener() {
        }

        private void a(Activity activity) {
            if (activity == null || activity.isFinishing()) {
                com.twitter.sdk.android.core.internal.f.a(TwitterLoginButton.TAG, TwitterLoginButton.ERROR_MSG_NO_ACTIVITY);
            }
        }

        private void checkCallback(com.twitter.sdk.android.core.c cVar) {
            if (cVar == null) {
                com.twitter.sdk.android.core.internal.f.a(TwitterLoginButton.TAG, "Callback must not be null, did you call setCallback?");
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            checkCallback(TwitterLoginButton.this.callback);
            a(TwitterLoginButton.this.activityRef.get());
            TwitterLoginButton.this.getTwitterAuthClient().a(TwitterLoginButton.this.activityRef.get(), TwitterLoginButton.this.callback);
            View.OnClickListener onClickListener = TwitterLoginButton.this.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public TwitterLoginButton(Context context) {
        this(context, null);
    }

    private void checkTwitterCoreAndEnable() {
        if (isInEditMode()) {
            return;
        }
        try {
            w.g();
        } catch (IllegalStateException e2) {
            n.e().e(TAG, e2.getMessage());
            setEnabled(false);
        }
    }

    @TargetApi(21)
    private void setupButton() {
        Resources resources = getResources();
        super.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.tw__ic_logo_default), (Drawable) null, (Drawable) null, (Drawable) null);
        super.setCompoundDrawablePadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_drawable_padding));
        super.setText(R.string.tw__login_btn_txt);
        super.setTextColor(resources.getColor(R.color.tw__solid_white));
        super.setTextSize(0, resources.getDimensionPixelSize(R.dimen.tw__login_btn_text_size));
        super.setTypeface(Typeface.DEFAULT_BOLD);
        super.setPadding(resources.getDimensionPixelSize(R.dimen.tw__login_btn_left_padding), 0, resources.getDimensionPixelSize(R.dimen.tw__login_btn_right_padding), 0);
        super.setBackgroundResource(R.drawable.tw__login_btn);
        super.setOnClickListener(new LoginClickListener());
        if (Build.VERSION.SDK_INT >= 21) {
            super.setAllCaps(false);
        }
    }

    protected Activity getActivity() {
        if ((getContext() instanceof ContextThemeWrapper) && (((ContextThemeWrapper) getContext()).getBaseContext() instanceof Activity)) {
            return (Activity) ((ContextThemeWrapper) getContext()).getBaseContext();
        }
        if (getContext() instanceof Activity) {
            return (Activity) getContext();
        }
        if (isInEditMode()) {
            return null;
        }
        throw new IllegalStateException(ERROR_MSG_NO_ACTIVITY);
    }

    public com.twitter.sdk.android.core.c<y> getCallback() {
        return this.callback;
    }

    h getTwitterAuthClient() {
        if (this.authClient == null) {
            synchronized (TwitterLoginButton.class) {
                if (this.authClient == null) {
                    this.authClient = new h();
                }
            }
        }
        return this.authClient;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == getTwitterAuthClient().a()) {
            getTwitterAuthClient().a(i, i2, intent);
        }
    }

    public void setCallback(com.twitter.sdk.android.core.c<y> cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Callback cannot be null");
        }
        this.callback = cVar;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public TwitterLoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.buttonStyle);
    }

    public TwitterLoginButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    TwitterLoginButton(Context context, AttributeSet attributeSet, int i, h hVar) {
        super(context, attributeSet, i);
        this.activityRef = new WeakReference<>(getActivity());
        this.authClient = hVar;
        setupButton();
        checkTwitterCoreAndEnable();
    }
}
