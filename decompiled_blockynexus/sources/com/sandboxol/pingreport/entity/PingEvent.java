package com.sandboxol.pingreport.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PingEvent implements Serializable {
    private static final long serialVersionUID = 1002;
    public Long ID;
    private List<Integer> fpsValueList;
    private String gameId;
    private List<Integer> netPingValueList;
    private List<Integer> pingValueList;

    public PingEvent(String str) {
        this.pingValueList = new ArrayList();
        this.netPingValueList = new ArrayList();
        this.fpsValueList = new ArrayList();
        this.gameId = str;
    }

    public void addFpsValue(int i) {
        this.fpsValueList.add(Integer.valueOf(i));
    }

    public void addPingNetValue(int i) {
        this.netPingValueList.add(Integer.valueOf(i));
    }

    public void addPingValue(int i) {
        this.pingValueList.add(Integer.valueOf(i));
    }

    public List<Integer> getFpsValueList() {
        return this.fpsValueList;
    }

    public String getGameId() {
        return this.gameId;
    }

    public Long getID() {
        return this.ID;
    }

    public List<Integer> getNetPingValueList() {
        return this.netPingValueList;
    }

    public List<Integer> getPingList() {
        return this.pingValueList;
    }

    public List<Integer> getPingValueList() {
        return this.pingValueList;
    }

    public boolean isEmpty() {
        return this.pingValueList.size() <= 0 && this.netPingValueList.size() <= 0 && this.fpsValueList.size() <= 0;
    }

    public void setFpsValueList(List<Integer> list) {
        this.fpsValueList = list;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setNetPingValueList(List<Integer> list) {
        this.netPingValueList = list;
    }

    public void setPingList(List<Integer> list) {
        this.pingValueList = list;
    }

    public void setPingValueList(List<Integer> list) {
        this.pingValueList = list;
    }

    public PingEvent(Long l, String str, List<Integer> list, List<Integer> list2, List<Integer> list3) {
        this.pingValueList = new ArrayList();
        this.netPingValueList = new ArrayList();
        this.fpsValueList = new ArrayList();
        this.ID = l;
        this.gameId = str;
        this.pingValueList = list;
        this.netPingValueList = list2;
        this.fpsValueList = list3;
    }

    public PingEvent() {
        this.pingValueList = new ArrayList();
        this.netPingValueList = new ArrayList();
        this.fpsValueList = new ArrayList();
    }
}
