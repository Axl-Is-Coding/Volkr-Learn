package com.sandboxol.imchat.entity;

import com.sandboxol.greendao.entity.TeamMember;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PartyModifyPositionInfo {
    private List<TeamMember> modifyPositionMemberList;

    public PartyModifyPositionInfo(List<TeamMember> list) {
        this.modifyPositionMemberList = list;
    }

    public List<TeamMember> getModifyPositionMemberList() {
        return this.modifyPositionMemberList;
    }

    public void setModifyPositionMemberList(List<TeamMember> list) {
        this.modifyPositionMemberList = list;
    }
}
