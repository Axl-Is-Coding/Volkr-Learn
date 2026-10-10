package com.disabngo.blockynexus.entity;

import com.disabngo.blockynexus.R;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.DateUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MailInfo implements Serializable {
    private List<Attachment> attachment;
    private String content;
    private String extra;
    private long id;
    private long sendDate;
    private int status;
    private String title;
    private int type;

    public List<Attachment> getAttachment() {
        return this.attachment;
    }

    public String getContent() {
        return "    " + this.content;
    }

    public String getDataText() {
        return DateUtils.timeStamp2Date(this.sendDate, "MM/dd");
    }

    public GameInvite getExtra() {
        try {
            return (GameInvite) new j().a(this.extra, new TypeToken<GameInvite>() { // from class: com.disabngo.blockynexus.entity.MailInfo.1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public long getId() {
        return this.id;
    }

    public long getSendDate() {
        return this.sendDate;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStringExtra() {
        return this.extra;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isReadHasAttachmentEmail() {
        List<Attachment> list;
        return (this.status != 1 || (list = this.attachment) == null || list.size() == 0) ? false : true;
    }

    public void setAttachment(List<Attachment> list) {
        this.attachment = list;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setSendDate(long j) {
        this.sendDate = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String titleText() {
        return BaseApplication.getContext().getString(R.string.email_title) + this.title;
    }
}
