package io.rong.imkit.emoticon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public interface IEmoticonTab {
    Drawable obtainTabDrawable(Context context);

    View obtainTabPager(Context context);

    void onTableSelected(int i);
}
