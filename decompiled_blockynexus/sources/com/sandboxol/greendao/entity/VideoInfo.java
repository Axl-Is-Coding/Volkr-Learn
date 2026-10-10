package com.sandboxol.greendao.entity;

import android.text.TextUtils;
import com.sandboxol.common.utils.DateUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class VideoInfo {
    public Long ID;
    private long authorId;
    private String authorName;
    private int dislikeNumber;
    private boolean isFirst;
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

    public VideoInfo(boolean z) {
        this.isFirst = z;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getAuthorNameTotal() {
        if (TextUtils.isEmpty(this.authorName)) {
            return "";
        }
        return "UP: " + this.authorName;
    }

    public int getDislikeNumber() {
        return this.dislikeNumber;
    }

    public Long getID() {
        return this.ID;
    }

    public boolean getIsFirst() {
        return this.isFirst;
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

    public String getVideoTimeByHours() {
        return DateUtils.hoursFormatDuringBySeconds(this.videoTime);
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getYoutubeUrl() {
        return this.youtubeUrl;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setAuthorId(long j) {
        this.authorId = j;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setDislikeNumber(int i) {
        this.dislikeNumber = i;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setIsFirst(boolean z) {
        this.isFirst = z;
    }

    public void setIsPublish(int i) {
        this.isPublish = i;
    }

    public void setLikeNumber(int i) {
        this.likeNumber = i;
    }

    public void setPlayAmount(long j) {
        this.playAmount = j;
    }

    public void setTag(Map<String, String> map) {
        this.tag = map;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideoId(long j) {
        this.videoId = j;
    }

    public void setVideoPic(String str) {
        this.videoPic = str;
    }

    public void setVideoTime(long j) {
        this.videoTime = j;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setYoutubeUrl(String str) {
        this.youtubeUrl = str;
    }

    public VideoInfo(Long l, long j, String str, int i, int i2, int i3, long j2, String str2, long j3, String str3, long j4, String str4, String str5, Map<String, String> map, boolean z) {
        this.ID = l;
        this.authorId = j;
        this.authorName = str;
        this.dislikeNumber = i;
        this.isPublish = i2;
        this.likeNumber = i3;
        this.playAmount = j2;
        this.title = str2;
        this.videoId = j3;
        this.videoPic = str3;
        this.videoTime = j4;
        this.videoUrl = str4;
        this.youtubeUrl = str5;
        this.tag = map;
        this.isFirst = z;
    }

    public VideoInfo() {
    }
}
