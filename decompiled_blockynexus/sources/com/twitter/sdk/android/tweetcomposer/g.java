package com.twitter.sdk.android.tweetcomposer;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: ComposerView.java */
/* JADX INFO: loaded from: classes5.dex */
class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ComposerView f20308a;

    g(ComposerView composerView) {
        this.f20308a = composerView;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ComposerView composerView = this.f20308a;
        composerView.callbacks.b(composerView.getTweetText());
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
