package com.sandboxol.greendao;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.facebook.internal.AnalyticsEvents;
import com.sandboxol.common.DataBinderMapperImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f18403a = new SparseIntArray(0);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f18404a = new SparseArray<>(36);

        static {
            f18404a.put(0, "_all");
            f18404a.put(1, "showEmptyView");
            f18404a.put(2, "item");
            f18404a.put(3, "refreshing");
            f18404a.put(4, "emptyText");
            f18404a.put(5, "viewModel");
            f18404a.put(6, "ViewModel");
            f18404a.put(7, "loadingMore");
            f18404a.put(8, "videoId");
            f18404a.put(9, "gameTitle");
            f18404a.put(10, "dislikeNumber");
            f18404a.put(11, "featuredPlay");
            f18404a.put(12, "title");
            f18404a.put(13, "evaluateStatus");
            f18404a.put(14, "videoUrl");
            f18404a.put(15, "bannerPic");
            f18404a.put(16, "youtubeUrl");
            f18404a.put(17, "alias");
            f18404a.put(18, "videoTime");
            f18404a.put(19, "tag");
            f18404a.put(20, "gameDetail");
            f18404a.put(21, "gameId");
            f18404a.put(22, "images");
            f18404a.put(23, "nickName");
            f18404a.put(24, "authorInfo");
            f18404a.put(25, "authorId");
            f18404a.put(26, "isPublish");
            f18404a.put(27, "tagName");
            f18404a.put(28, "gameCoverPic");
            f18404a.put(29, "playAmount");
            f18404a.put(30, "videoPic");
            f18404a.put(31, "authorName");
            f18404a.put(32, "authorPicUrl");
            f18404a.put(33, "likeNumber");
            f18404a.put(34, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.greendao.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0153b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f18405a = new HashMap<>(0);
    }

    @Override // androidx.databinding.b
    public List<androidx.databinding.b> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.a());
        arrayList.add(new DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return a.f18404a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View view, int i) {
        if (f18403a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = C0153b.f18405a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f18403a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
