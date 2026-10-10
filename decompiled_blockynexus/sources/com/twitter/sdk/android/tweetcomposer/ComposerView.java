package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.D;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetcomposer.f;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class ComposerView extends LinearLayout {
    ImageView avatarView;
    f.a callbacks;
    TextView charCountView;
    ImageView closeView;
    View divider;
    private Picasso imageLoader;
    ImageView imageView;
    ColorDrawable mediaBg;
    ObservableScrollView scrollView;
    Button tweetButton;
    EditText tweetEditView;

    public ComposerView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.imageLoader = Picasso.a(getContext());
        this.mediaBg = new ColorDrawable(context.getResources().getColor(R.color.tw__composer_light_gray));
        LinearLayout.inflate(context, R.layout.tw__composer_view, this);
    }

    public /* synthetic */ void a(View view) {
        this.callbacks.a();
    }

    public /* synthetic */ void b(View view) {
        this.callbacks.a(getTweetText());
    }

    void findSubviews() {
        this.avatarView = (ImageView) findViewById(R.id.tw__author_avatar);
        this.closeView = (ImageView) findViewById(R.id.tw__composer_close);
        this.tweetEditView = (EditText) findViewById(R.id.tw__edit_tweet);
        this.charCountView = (TextView) findViewById(R.id.tw__char_count);
        this.tweetButton = (Button) findViewById(R.id.tw__post_tweet);
        this.scrollView = (ObservableScrollView) findViewById(R.id.tw__composer_scroll_view);
        this.divider = findViewById(R.id.tw__composer_profile_divider);
        this.imageView = (ImageView) findViewById(R.id.tw__image_view);
    }

    String getTweetText() {
        return this.tweetEditView.getText().toString();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        findSubviews();
        this.closeView.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetcomposer.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20298a.a(view);
            }
        });
        this.tweetButton.setOnClickListener(new View.OnClickListener() { // from class: com.twitter.sdk.android.tweetcomposer.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20299a.b(view);
            }
        });
        this.tweetEditView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.twitter.sdk.android.tweetcomposer.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f20296a.a(textView, i, keyEvent);
            }
        });
        this.tweetEditView.addTextChangedListener(new g(this));
        this.scrollView.setScrollViewListener(new ObservableScrollView.a() { // from class: com.twitter.sdk.android.tweetcomposer.b
            @Override // com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView.a
            public final void a(int i) {
                this.f20297a.a(i);
            }
        });
    }

    void postTweetEnabled(boolean z) {
        this.tweetButton.setEnabled(z);
    }

    void setCallbacks(f.a aVar) {
        this.callbacks = aVar;
    }

    void setCharCount(int i) {
        this.charCountView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i)));
    }

    void setCharCountTextStyle(int i) {
        this.charCountView.setTextAppearance(getContext(), i);
    }

    void setImageView(Uri uri) {
        if (this.imageLoader != null) {
            this.imageView.setVisibility(0);
            this.imageLoader.a(uri).a(this.imageView);
        }
    }

    void setProfilePhotoView(User user) {
        String strA = UserUtils.a(user, UserUtils.AvatarSize.REASONABLY_SMALL);
        Picasso picasso = this.imageLoader;
        if (picasso != null) {
            D dA = picasso.a(strA);
            dA.a(this.mediaBg);
            dA.a(this.avatarView);
        }
    }

    void setTweetText(String str) {
        this.tweetEditView.setText(str);
    }

    public ComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        this.callbacks.a(getTweetText());
        return true;
    }

    public /* synthetic */ void a(int i) {
        if (i > 0) {
            this.divider.setVisibility(0);
        } else {
            this.divider.setVisibility(4);
        }
    }

    public ComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
