package com.sandboxol.center.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class Privilege implements Serializable {
    private boolean enable;
    private int id;
    private String level;
    private String textType;
    private String type;

    public int getId() {
        return this.id;
    }

    public String getLevel() {
        return this.level;
    }

    public String getTextType() {
        return this.textType;
    }

    public String getType() {
        return this.type;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setTextType(String str) {
        this.textType = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
