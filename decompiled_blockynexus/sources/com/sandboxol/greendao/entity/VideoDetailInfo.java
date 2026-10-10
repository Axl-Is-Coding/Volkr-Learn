package com.sandboxol.greendao.entity;

import androidx.databinding.BaseObservable;
import com.sandboxol.greendao.a;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class VideoDetailInfo extends BaseObservable implements Serializable, Cloneable {
    private static final long serialVersionUID = 100;
    private long authorId;
    private String authorName;
    private String authorPicUrl;
    private int dislikeNumber;
    private int evaluateStatus;
    private int isPublish;
    private int likeNumber;
    private long playAmount;
    private Map<String, String> tag;
    private String title;
    private long videoId;
    private String videoPic;
    private long videoTime;
    private String videoUrl;
    private String youtubeUrl;

    public VideoDetailInfo(long j, String str, int i, int i2, int i3, long j2, int i4, String str2, String str3, String str4, long j3, String str5, long j4, String str6, Map<String, String> map) {
        this.authorId = j;
        this.authorName = str;
        this.dislikeNumber = i;
        this.isPublish = i2;
        this.likeNumber = i3;
        this.playAmount = j2;
        this.evaluateStatus = i4;
        this.title = str2;
        this.authorPicUrl = str3;
        this.youtubeUrl = str4;
        this.videoId = j3;
        this.videoPic = str5;
        this.videoTime = j4;
        this.videoUrl = str6;
        this.tag = map;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getAuthorPicUrl() {
        return this.authorPicUrl;
    }

    public int getDislikeNumber() {
        return this.dislikeNumber;
    }

    public int getEvaluateStatus() {
        return this.evaluateStatus;
    }

    public int getIsPublish() {
        return this.isPublish;
    }

    public int getLikeNumber() {
        return this.likeNumber;
    }

    public long getPlayAmount() {
        return this.playAmount;
    }

    public Map<String, String> getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopTag() {
        Map<String, String> map = this.tag;
        if (map == null || map.values().isEmpty()) {
            return null;
        }
        Iterator<String> it = this.tag.values().iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public long getVideoId() {
        return this.videoId;
    }

    public String getVideoPic() {
        return this.videoPic;
    }

    public long getVideoTime() {
        return this.videoTime;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getYoutubeUrl() {
        return this.youtubeUrl;
    }

    public void refreshData(VideoDetailInfo videoDetailInfo) {
        setAuthorId(videoDetailInfo.getAuthorId());
        setAuthorName(videoDetailInfo.getAuthorName());
        setDislikeNumber(videoDetailInfo.getDislikeNumber());
        setIsPublish(videoDetailInfo.getIsPublish());
        setLikeNumber(videoDetailInfo.getLikeNumber());
        setPlayAmount(videoDetailInfo.getPlayAmount());
        setEvaluateStatus(videoDetailInfo.getEvaluateStatus());
        setTitle(videoDetailInfo.getTitle());
        setAuthorPicUrl(videoDetailInfo.getAuthorPicUrl());
        setYoutubeUrl(videoDetailInfo.getYoutubeUrl());
        setVideoId(videoDetailInfo.getVideoId());
        setVideoPic(videoDetailInfo.getVideoPic());
        setVideoTime(videoDetailInfo.getVideoTime());
        setVideoUrl(videoDetailInfo.getVideoUrl());
        setTag(videoDetailInfo.getTag());
    }

    public void setAuthorId(long j) {
        this.authorId = j;
        notifyPropertyChanged(a.j);
    }

    public void setAuthorName(String str) {
        this.authorName = str;
        notifyPropertyChanged(a.o);
    }

    public void setAuthorPicUrl(String str) {
        this.authorPicUrl = str;
        notifyPropertyChanged(a.p);
    }

    public void setDislikeNumber(int i) {
        this.dislikeNumber = i;
        notifyPropertyChanged(a.f18397b);
    }

    public void setEvaluateStatus(int i) {
        this.evaluateStatus = i;
        notifyPropertyChanged(a.f18399d);
    }

    public void setIsPublish(int i) {
        this.isPublish = i;
        notifyPropertyChanged(a.k);
    }

    public void setLikeNumber(int i) {
        this.likeNumber = i;
        notifyPropertyChanged(a.q);
    }

    public void setPlayAmount(long j) {
        this.playAmount = j;
        notifyPropertyChanged(a.m);
    }

    public void setTag(Map<String, String> map) {
        this.tag = map;
        notifyPropertyChanged(a.h);
    }

    public void setTitle(String str) {
        this.title = str;
        notifyPropertyChanged(a.f18398c);
    }

    public void setVideoId(long j) {
        this.videoId = j;
        notifyPropertyChanged(a.f18396a);
    }

    public void setVideoPic(String str) {
        this.videoPic = str;
        notifyPropertyChanged(a.n);
    }

    public void setVideoTime(long j) {
        this.videoTime = j;
        notifyPropertyChanged(a.g);
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
        notifyPropertyChanged(a.f18400e);
    }

    public void setYoutubeUrl(String str) {
        this.youtubeUrl = str;
        notifyPropertyChanged(a.f18401f);
    }

    public VideoDetailInfo() {
    }
}
