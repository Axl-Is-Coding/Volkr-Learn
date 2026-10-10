package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ConversationClickStateHolder {
    private int gourpIconState;
    private int state;

    private static class StaticSingletonHolder {
        private static final ConversationClickStateHolder stateHolder = new ConversationClickStateHolder();

        private StaticSingletonHolder() {
        }
    }

    public static ConversationClickStateHolder getInstance() {
        return StaticSingletonHolder.stateHolder;
    }

    public int getGourpIconState() {
        return this.gourpIconState;
    }

    public int getState() {
        return this.state;
    }

    public void setGourpIconState(int i) {
        this.gourpIconState = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    private ConversationClickStateHolder() {
        this.state = 1;
        this.gourpIconState = 1;
    }
}
