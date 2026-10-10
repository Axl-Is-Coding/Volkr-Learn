package com.twitter.sdk.android.tweetui.internal;

import android.os.Build;
import com.facebook.internal.AnalyticsEvents;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.VideoInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TweetMediaUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class l {
    public static VideoInfo.Variant a(MediaEntity mediaEntity) {
        for (VideoInfo.Variant variant : mediaEntity.videoInfo.variants) {
            if (a(variant)) {
                return variant;
            }
        }
        return null;
    }

    public static List<MediaEntity> b(com.twitter.sdk.android.core.models.m mVar) {
        List<MediaEntity> list;
        ArrayList arrayList = new ArrayList();
        com.twitter.sdk.android.core.models.o oVar = mVar.f20242e;
        if (oVar != null && (list = oVar.f20253d) != null && list.size() > 0) {
            for (int i = 0; i <= oVar.f20253d.size() - 1; i++) {
                MediaEntity mediaEntity = oVar.f20253d.get(i);
                if (mediaEntity.type != null && c(mediaEntity)) {
                    arrayList.add(mediaEntity);
                }
            }
        }
        return arrayList;
    }

    public static MediaEntity c(com.twitter.sdk.android.core.models.m mVar) {
        List<MediaEntity> listA = a(mVar);
        for (int size = listA.size() - 1; size >= 0; size--) {
            MediaEntity mediaEntity = listA.get(size);
            if (mediaEntity.type != null && c(mediaEntity)) {
                return mediaEntity;
            }
        }
        return null;
    }

    public static MediaEntity d(com.twitter.sdk.android.core.models.m mVar) {
        for (MediaEntity mediaEntity : a(mVar)) {
            if (mediaEntity.type != null && d(mediaEntity)) {
                return mediaEntity;
            }
        }
        return null;
    }

    public static boolean e(com.twitter.sdk.android.core.models.m mVar) {
        return c(mVar) != null;
    }

    public static boolean f(com.twitter.sdk.android.core.models.m mVar) {
        MediaEntity mediaEntityD = d(mVar);
        return (mediaEntityD == null || a(mediaEntityD) == null) ? false : true;
    }

    public static boolean e(MediaEntity mediaEntity) {
        return !"animated_gif".equals(mediaEntity.type);
    }

    static boolean a(VideoInfo.Variant variant) {
        return (Build.VERSION.SDK_INT >= 21 && "application/x-mpegURL".equals(variant.contentType)) || "video/mp4".equals(variant.contentType);
    }

    static boolean d(MediaEntity mediaEntity) {
        return "video".equals(mediaEntity.type) || "animated_gif".equals(mediaEntity.type);
    }

    static boolean c(MediaEntity mediaEntity) {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO.equals(mediaEntity.type);
    }

    static List<MediaEntity> a(com.twitter.sdk.android.core.models.m mVar) {
        List<MediaEntity> list;
        List<MediaEntity> list2;
        ArrayList arrayList = new ArrayList();
        com.twitter.sdk.android.core.models.o oVar = mVar.f20241d;
        if (oVar != null && (list2 = oVar.f20253d) != null) {
            arrayList.addAll(list2);
        }
        com.twitter.sdk.android.core.models.o oVar2 = mVar.f20242e;
        if (oVar2 != null && (list = oVar2.f20253d) != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static boolean b(MediaEntity mediaEntity) {
        return "animated_gif".equals(mediaEntity.type) || ("video".endsWith(mediaEntity.type) && mediaEntity.videoInfo.durationMillis < 6500);
    }
}
