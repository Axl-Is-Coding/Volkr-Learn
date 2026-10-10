package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Response implements bc<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, bo> metaDataMap;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final cg STRUCT_DESC = new cg("Response");
    private static final bw RESP_CODE_FIELD_DESC = new bw("resp_code", (byte) 8, 1);
    private static final bw MSG_FIELD_DESC = new bw("msg", (byte) 11, 2);
    private static final bw IMPRINT_FIELD_DESC = new bw(au.W, (byte) 12, 3);
    private static final Map<Class<? extends cj>, ck> schemes = new HashMap();

    private static class a extends cl<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cb cbVar, Response response) throws bi {
            cbVar.j();
            while (true) {
                bw bwVarL = cbVar.l();
                byte b2 = bwVarL.f20755b;
                if (b2 == 0) {
                    break;
                }
                short s = bwVarL.f20756c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            ce.a(cbVar, b2);
                        } else if (b2 == 12) {
                            response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint.read(cbVar);
                            response.setImprintIsSet(true);
                        } else {
                            ce.a(cbVar, b2);
                        }
                    } else if (b2 == 11) {
                        response.msg = cbVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        ce.a(cbVar, b2);
                    }
                } else if (b2 == 8) {
                    response.resp_code = cbVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    ce.a(cbVar, b2);
                }
                cbVar.m();
            }
            cbVar.k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new cc("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cb cbVar, Response response) throws bi {
            response.validate();
            cbVar.a(Response.STRUCT_DESC);
            cbVar.a(Response.RESP_CODE_FIELD_DESC);
            cbVar.a(response.resp_code);
            cbVar.c();
            if (response.msg != null && response.isSetMsg()) {
                cbVar.a(Response.MSG_FIELD_DESC);
                cbVar.a(response.msg);
                cbVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                cbVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(cbVar);
                cbVar.c();
            }
            cbVar.d();
            cbVar.b();
        }
    }

    private static class b implements ck {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    private static class c extends cm<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cj
        public void a(cb cbVar, Response response) throws bi {
            ch chVar = (ch) cbVar;
            chVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            chVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                chVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(chVar);
            }
        }

        @Override // com.umeng.analytics.pro.cj
        public void b(cb cbVar, Response response) throws bi {
            ch chVar = (ch) cbVar;
            response.resp_code = chVar.w();
            response.setResp_codeIsSet(true);
            BitSet bitSetB = chVar.b(2);
            if (bitSetB.get(0)) {
                response.msg = chVar.z();
                response.setMsgIsSet(true);
            }
            if (bitSetB.get(1)) {
                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint.read(chVar);
                response.setImprintIsSet(true);
            }
        }
    }

    private static class d implements ck {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ck
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        schemes.put(cl.class, new b());
        schemes.put(cm.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.RESP_CODE, new bo("resp_code", (byte) 1, new bp((byte) 8)));
        enumMap.put(e.MSG, new bo("msg", (byte) 2, new bp((byte) 11)));
        enumMap.put(e.IMPRINT, new bo(au.W, (byte) 2, new bt((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        bo.a(Response.class, metaDataMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new bv(new cn(objectInputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bv(new cn(objectOutputStream)));
        } catch (bi e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.bc
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return az.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.bc
    public void read(cb cbVar) throws bi {
        schemes.get(cbVar.D()).b().b(cbVar, this);
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = az.a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = az.b(this.__isset_bitfield, 0);
    }

    public void validate() throws bi {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.bc
    public void write(cb cbVar) throws bi {
        schemes.get(cbVar.D()).b().a(cbVar, this);
    }

    public enum e implements bj {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, au.W);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f21260d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final short f21261e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f21262f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                f21260d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f21261e = s;
            this.f21262f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return RESP_CODE;
            }
            if (i == 2) {
                return MSG;
            }
            if (i != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bj
        public String b() {
            return this.f21262f;
        }

        public static e a(String str) {
            return f21260d.get(str);
        }

        @Override // com.umeng.analytics.pro.bj
        public short a() {
            return this.f21261e;
        }
    }

    @Override // com.umeng.analytics.pro.bc
    public Response deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.bc
    public e fieldForId(int i) {
        return e.a(i);
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }
}
