package io.rong.imkit;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import io.rong.imkit.emoticon.EmoticonTabAdapter;

/* JADX INFO: loaded from: classes5.dex */
public interface IRongExtensionState {
    void changeView(RongExtension rongExtension);

    void hideEmoticonBoard(ImageView imageView, EmoticonTabAdapter emoticonTabAdapter);

    void onClick(RongExtension rongExtension, View view);

    boolean onEditTextTouch(RongExtension rongExtension, View view, MotionEvent motionEvent);
}
