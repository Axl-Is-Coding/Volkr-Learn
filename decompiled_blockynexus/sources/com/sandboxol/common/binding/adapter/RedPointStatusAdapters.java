package com.sandboxol.common.binding.adapter;

import android.widget.ImageView;
import androidx.databinding.ObservableMap;
import com.sandboxol.common.utils.EventRedPointManager;

/* JADX INFO: loaded from: classes3.dex */
public class RedPointStatusAdapters {
    public static void getAllEventRedPointStatus(ImageView imageView, ObservableMap<String, Integer> observableMap) {
        if (imageView != null) {
            imageView.setVisibility(EventRedPointManager.getInstance().getRedPointWholeStatus() ? 0 : 8);
        }
    }

    public static void setEventRedPointStatus(ImageView imageView, ObservableMap<String, Integer> observableMap, String str) {
        if (imageView == null || observableMap == null || str == null || observableMap.get(str) == null) {
            return;
        }
        imageView.setVisibility(observableMap.get(str).intValue() == 1 ? 0 : 8);
    }
}
