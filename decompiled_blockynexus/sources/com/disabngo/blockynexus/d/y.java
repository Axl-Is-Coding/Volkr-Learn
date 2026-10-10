package com.disabngo.blockynexus.d;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.entity.GroupOwnerRecall;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.greendao.c.ra;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.widget.NineGirdImageView;
import io.rong.imkit.model.UIMessage;
import io.rong.imkit.widget.provider.MessageItemLongClickAction;
import io.rong.imlib.model.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: GroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static y f7244a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7247d;
    private Context g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;
    private GroupInfo l;
    private MessageItemLongClickAction n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Long, Integer> f7245b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Long, a> f7246c = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Long, String> f7248e = new HashMap();
    private List<GroupInfo> m = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<Long, Long> f7249f = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: GroupUtils.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7251b;

        public a(String str, String str2) {
            this.f7250a = str;
            this.f7251b = str2;
        }

        public String a() {
            return this.f7250a;
        }

        public String b() {
            return this.f7251b;
        }
    }

    private y() {
        if (g()) {
            this.h = true;
        }
        this.n = new MessageItemLongClickAction.Builder().titleResId(R.string.new_group_owner_recall).actionListener(new MessageItemLongClickAction.MessageItemLongClickListener() { // from class: com.disabngo.blockynexus.d.c
            @Override // io.rong.imkit.widget.provider.MessageItemLongClickAction.MessageItemLongClickListener
            public final boolean onMessageItemLongClick(Context context, UIMessage uIMessage) {
                return y.a(context, uIMessage);
            }
        }).build();
    }

    private void h(GroupInfo groupInfo) {
        Iterator<GroupInfo> it = this.m.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupInfo next = it.next();
            if (next.getGroupId() == groupInfo.getGroupId()) {
                this.m.remove(next);
                break;
            }
        }
        this.m.add(groupInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(GroupInfo groupInfo) {
        GroupUtilsProxy.getInstance().storeOwnerId(groupInfo.getGroupId(), Long.valueOf(groupInfo.getOwnerId()).longValue());
        ArrayList arrayList = new ArrayList();
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            if (groupMember.getIdentity() == 1) {
                arrayList.add(Long.valueOf(groupMember.getUserId()));
            }
        }
        GroupUtilsProxy.getInstance().storeAdminId(groupInfo.getGroupId(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(GroupInfo groupInfo) {
        if (this.f7249f.keySet().contains(Long.valueOf(groupInfo.getGroupId()))) {
            this.f7249f.remove(Long.valueOf(groupInfo.getGroupId()));
        }
        this.f7249f.put(Long.valueOf(groupInfo.getGroupId()), Long.valueOf(groupInfo.getOwnerId()));
    }

    public String c(long j) {
        return (!this.f7246c.keySet().contains(Long.valueOf(j)) || this.f7246c.get(Long.valueOf(j)) == null) ? "" : this.f7246c.get(Long.valueOf(j)).a();
    }

    public List<GroupMember> d(GroupInfo groupInfo) {
        TreeSet treeSet = new TreeSet(new q());
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            if (groupMember.getIdentity() != 2) {
                treeSet.add(groupMember);
            }
        }
        return new ArrayList(treeSet);
    }

    public String e(long j) {
        return this.f7248e.get(Long.valueOf(j));
    }

    public int f(long j) {
        if (this.f7245b.get(Long.valueOf(j)) != null) {
            return this.f7245b.get(Long.valueOf(j)).intValue();
        }
        return 0;
    }

    public void g(GroupInfo groupInfo) {
        if (!this.f7245b.keySet().contains(Long.valueOf(groupInfo.getGroupId()))) {
            this.f7245b.put(Long.valueOf(groupInfo.getGroupId()), Integer.valueOf(groupInfo.getGroupMembers().size()));
        } else {
            this.f7245b.remove(Long.valueOf(groupInfo.getGroupId()));
            this.f7245b.put(Long.valueOf(groupInfo.getGroupId()), Integer.valueOf(groupInfo.getGroupMembers().size()));
        }
    }

    public void k(long j) {
        if (this.f7245b.keySet().contains(Long.valueOf(j))) {
            this.f7245b.remove(Long.valueOf(j));
        }
    }

    public void l(long j) {
        this.f7247d = j;
    }

    public void m(long j) {
        GroupChatApi.getGroupInfo(this.g, j, new t(this));
    }

    public void e(GroupInfo groupInfo) {
        this.l = groupInfo;
    }

    public void f(GroupInfo groupInfo) {
        if (groupInfo != null) {
            if (this.f7246c.keySet().contains(Long.valueOf(groupInfo.getGroupId()))) {
                this.f7246c.remove(Long.valueOf(groupInfo.getGroupId()));
                this.f7246c.put(Long.valueOf(groupInfo.getGroupId()), new a(TextEllipsizeUtil.ellipsizeString(20, groupInfo.getGroupName(), TextEllipsizeUtil.SignLib.END_POINT), groupInfo.getGroupPic()));
            } else {
                this.f7246c.put(Long.valueOf(groupInfo.getGroupId()), new a(TextEllipsizeUtil.ellipsizeString(20, groupInfo.getGroupName(), TextEllipsizeUtil.SignLib.END_POINT), groupInfo.getGroupPic()));
            }
            for (GroupMember groupMember : groupInfo.getGroupMembers()) {
                a(groupMember.getUserId(), groupMember.getUserName());
            }
            h(groupInfo);
            j(groupInfo);
        }
    }

    public static y b() {
        if (f7244a == null) {
            synchronized (y.class) {
                if (f7244a == null) {
                    f7244a = new y();
                }
            }
        }
        return f7244a;
    }

    public List<String> c(GroupInfo groupInfo) {
        ArrayList arrayList = new ArrayList();
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            if (groupMember.getPic() == null) {
                arrayList.add("");
            } else {
                arrayList.add(groupMember.getPic());
            }
        }
        return arrayList;
    }

    public long e() {
        return this.f7247d;
    }

    public void j(long j) {
        Context context = this.g;
        if (context == null) {
            return;
        }
        GroupChatApi.getGroupInfo(context, j, new u(this));
    }

    static /* synthetic */ boolean a(Context context, UIMessage uIMessage) {
        b().a(uIMessage);
        return true;
    }

    public long g(long j) {
        Map<Long, Long> map = this.f7249f;
        if (map == null || !map.keySet().contains(Long.valueOf(j))) {
            return 0L;
        }
        return this.f7249f.get(Long.valueOf(j)).longValue();
    }

    public List<UserInfo> h(long j) {
        ArrayList arrayList = new ArrayList();
        List<GroupInfo> list = this.m;
        if (list != null) {
            Iterator<GroupInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GroupInfo next = it.next();
                if (next.getGroupId() == j) {
                    for (GroupMember groupMember : next.getGroupMembers()) {
                        arrayList.add(new UserInfo(String.valueOf(groupMember.getUserId()), groupMember.getUserName(), Uri.parse(groupMember.getPic())));
                    }
                }
            }
        }
        return arrayList;
    }

    public List<Long> a(GroupInfo groupInfo) {
        ArrayList arrayList = new ArrayList();
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            if (groupMember.getIdentity() == 1) {
                arrayList.add(Long.valueOf(groupMember.getUserId()));
            }
        }
        return arrayList;
    }

    public String d(long j) {
        return this.f7246c.get(Long.valueOf(j)).b();
    }

    public String d() {
        return this.j;
    }

    public boolean i() {
        return this.k;
    }

    public List<GroupMember> c(List<GroupMember> list) {
        TreeSet treeSet = new TreeSet(new q());
        Iterator<GroupMember> it = list.iterator();
        while (it.hasNext()) {
            treeSet.add(it.next());
        }
        return new ArrayList(treeSet);
    }

    public boolean g() {
        return TribeCenter.newInstance().tribeClanId.get().longValue() != 0;
    }

    public boolean i(long j) {
        return this.f7245b.keySet().contains(Long.valueOf(j));
    }

    public GroupMember b(GroupInfo groupInfo) {
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            if (groupMember.getIdentity() == 2) {
                return groupMember;
            }
        }
        return null;
    }

    public ArrayList<GroupMember> a(GroupInfo groupInfo, boolean z) {
        ArrayList<GroupMember> arrayList = new ArrayList<>();
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            int identity = groupMember.getIdentity();
            if (identity == 1) {
                arrayList.add(groupMember);
            } else if (z && identity == 2 && arrayList.size() > 0) {
                arrayList.add(0, groupMember);
            }
        }
        return arrayList;
    }

    public GroupInfo f() {
        return this.l;
    }

    public boolean h() {
        return this.i;
    }

    public List<GroupMember> b(List<GroupMember> list) {
        TreeSet treeSet = new TreeSet(new q());
        for (GroupMember groupMember : list) {
            if (groupMember.getUserId() != AccountCenter.newInstance().userId.get().longValue()) {
                treeSet.add(groupMember);
            }
        }
        return new ArrayList(treeSet);
    }

    public void c(boolean z) {
        this.k = z;
    }

    public MessageItemLongClickAction c() {
        return this.n;
    }

    public void a(long j, NineGirdImageView<String> nineGirdImageView, Map<Long, List<String>> map) {
        GroupChatApi.getGroupInfo(a(), j, new r(this, nineGirdImageView, map, j));
    }

    public GroupInfo b(long j) {
        List<GroupInfo> list = this.m;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (GroupInfo groupInfo : this.m) {
            if (groupInfo.getGroupId() == j) {
                return groupInfo;
            }
        }
        return null;
    }

    public int a(String str) {
        if (g() && String.valueOf(TribeCenter.newInstance().tribeClanId.get()).equals(str)) {
            return 0;
        }
        if (!g() && String.valueOf(this.f7247d).equals(str)) {
            return 0;
        }
        if (g() || !this.h) {
            return !this.f7246c.keySet().contains(Long.valueOf(str)) ? 2 : 1;
        }
        return 0;
    }

    public boolean b(List<GroupMember> list, long j) {
        if (!a(list, j)) {
            return false;
        }
        Iterator<GroupMember> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GroupMember next = it.next();
            if (next.getUserId() == j) {
                if (next.getIdentity() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(long j) {
        Context context = this.g;
        if (context == null) {
            return;
        }
        GroupChatApi.getGroupInfo(context, j, new s(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str) {
        if (this.f7248e.keySet().contains(Long.valueOf(j))) {
            this.f7248e.remove(Long.valueOf(j));
            this.f7248e.put(Long.valueOf(j), str);
        } else {
            this.f7248e.put(Long.valueOf(j), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, String str, List<String> list) {
        SharedUtils.putString(this.g, SharedConstant.KEY_PRE_GROUP_NOTICE + String.valueOf(j), b(str, list));
    }

    private String b(String str, List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(SharedConstant.KEY_GROUP_NOTICE_SPLIT);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(SharedConstant.KEY_GROUP_NOTICE_SPLIT);
        }
        return sb.toString();
    }

    public boolean a(List<GroupMember> list, long j) {
        Iterator<GroupMember> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getUserId() == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, String str, List<String> list) {
        String[] strArrSplit = SharedUtils.getString(this.g, SharedConstant.KEY_PRE_GROUP_NOTICE + String.valueOf(j), SharedConstant.KEY_PRE_GROUP_NOTICE).split(SharedConstant.KEY_GROUP_NOTICE_SPLIT);
        if (strArrSplit != null && strArrSplit.length > 0) {
            if (!strArrSplit[0].equals(str)) {
                a(str, list);
                b(j, str, list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < strArrSplit.length; i++) {
                if (!TextUtils.isEmpty(strArrSplit[i])) {
                    arrayList.add(strArrSplit[i]);
                }
            }
            if (arrayList.size() == 0) {
                if (list.size() > 0) {
                    a(str, list);
                    b(j, str, list);
                    return;
                }
                return;
            }
            if (list.size() != arrayList.size()) {
                a(str, list);
                b(j, str, list);
                return;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!list.contains(arrayList.get(i2))) {
                    a(str, list);
                    b(j, str, list);
                    return;
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(str) || (list != null && list.size() > 0)) {
            a(str, list);
            b(j, str, list);
        }
    }

    public boolean b(long j, long j2) {
        return g(j) == j2;
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void b(Context context) {
        this.g = context;
    }

    private void a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) || (list != null && list.size() > 0)) {
            Messenger.getDefault().send(b(str, list), ChatMessageToken.TOKEN_SHOW_GROUP_NOTICE_DIALOG);
        }
    }

    public boolean a(long j, long j2) {
        return GroupUtilsProxy.getInstance().judgeAdmin(j, j2);
    }

    public void a(UIMessage uIMessage) {
        GroupOwnerRecall groupOwnerRecall = new GroupOwnerRecall();
        groupOwnerRecall.setGroupId(Long.valueOf(uIMessage.getTargetId()).longValue());
        groupOwnerRecall.setMemberId(Long.valueOf(uIMessage.getSenderUserId()).longValue());
        groupOwnerRecall.setUid(uIMessage.getUId());
        groupOwnerRecall.setSendTime(String.valueOf(uIMessage.getSentTime()));
        groupOwnerRecall.setUserId(AccountCenter.newInstance().userId.get().longValue());
        GroupChatApi.ownerRecallMessage(this.g, groupOwnerRecall, new v(this));
    }

    public void a(Context context) {
        ra.newInstance().a(new x(this, context));
    }

    public String a(int i) {
        if (i == 0) {
            return "";
        }
        if (i != 1) {
            return i != 2 ? "" : BaseApplication.getContext().getString(R.string.group_owner);
        }
        return BaseApplication.getContext().getString(R.string.admi);
    }

    public List<GroupMember> a(List<GroupMember> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GroupMember groupMember : list) {
                if (groupMember.getIdentity() != 1 && groupMember.getIdentity() != 2 && groupMember.getUserId() != AccountCenter.newInstance().userId.get().longValue()) {
                    arrayList.add(groupMember);
                }
            }
        }
        return b(arrayList);
    }

    public void a(boolean z) {
        this.i = z;
    }

    public Context a() {
        return this.g;
    }
}
