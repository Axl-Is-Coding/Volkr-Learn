package com.sandboxol.greendao.entity;

import androidx.databinding.BaseObservable;
import com.sandboxol.greendao.a;

/* JADX INFO: loaded from: classes3.dex */
public class VideoTagInfo extends BaseObservable {
    private String gameId;
    private String tagName;

    public VideoTagInfo(String str, String str2) {
        this.gameId = str;
        this.tagName = str2;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setGameId(String str) {
        this.gameId = str;
        notifyPropertyChanged(a.i);
    }

    public void setTagName(String str) {
        this.tagName = str;
        notifyPropertyChanged(a.l);
    }
}
