package com.sandboxol.blockmango.entity;

/* JADX INFO: loaded from: classes2.dex */
public class GameTimeToday {
    private String finishIds;
    private int gameTimeToday;
    private int secondsLeft;

    public String[] getFinishIds() {
        String str = this.finishIds;
        if (str != null) {
            return str.split(",");
        }
        return null;
    }

    public int getGameTimeToday() {
        return this.gameTimeToday;
    }

    public int getSecondsLeft() {
        return this.secondsLeft;
    }

    public void setFinishIds(String str) {
        this.finishIds = str;
    }

    public void setGameTimeToday(int i) {
        this.gameTimeToday = i;
    }

    public void setSecondsLeft(int i) {
        this.secondsLeft = i;
    }
}
