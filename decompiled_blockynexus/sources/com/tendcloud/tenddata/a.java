package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {
    public static final String MF_JSON = "UNIFIED_SDK_JSON";
    private static final String MF_MP = "MP";
    public static final String MF_STRING = "STRING";
    private int indexNum;
    private String nameString;
    private static volatile List<String> FeaturesList = new ArrayList();
    public static final a APP = new a("APP", 0) { // from class: com.tendcloud.tenddata.a.1
        private boolean isUrlUpdated = false;
        private String url;

        @Override // com.tendcloud.tenddata.a
        public String getCert() {
            return "";
        }

        @Override // com.tendcloud.tenddata.a
        public String getDataFolder() {
            return super.getDataFolder();
        }

        @Override // com.tendcloud.tenddata.a
        public int getFileLimitType() {
            return super.getFileLimitType();
        }

        @Override // com.tendcloud.tenddata.a
        public String getHost() {
            return aa.f19742b;
        }

        @Override // com.tendcloud.tenddata.a
        public String getIP() {
            return null;
        }

        @Override // com.tendcloud.tenddata.a
        public String getMessageFormat() {
            return a.MF_JSON;
        }

        @Override // com.tendcloud.tenddata.a
        public String getRootFolder() {
            return super.getRootFolder();
        }

        @Override // com.tendcloud.tenddata.a
        public String getUrl() {
            return this.isUrlUpdated ? this.url : aa.g;
        }

        @Override // com.tendcloud.tenddata.a
        public void setUrl(String str) {
            this.isUrlUpdated = true;
            this.url = str;
        }
    };
    public static final a ENV = new a("ENV", 2) { // from class: com.tendcloud.tenddata.a.2
        @Override // com.tendcloud.tenddata.a
        public String getCert() {
            return "";
        }

        @Override // com.tendcloud.tenddata.a
        public String getDataFolder() {
            return super.getDataFolder();
        }

        @Override // com.tendcloud.tenddata.a
        public int getFileLimitType() {
            return super.getFileLimitType();
        }

        @Override // com.tendcloud.tenddata.a
        public String getHost() {
            return aa.h;
        }

        @Override // com.tendcloud.tenddata.a
        public String getIP() {
            return null;
        }

        @Override // com.tendcloud.tenddata.a
        public String getMessageFormat() {
            return a.MF_JSON;
        }

        @Override // com.tendcloud.tenddata.a
        public String getRootFolder() {
            return super.getRootFolder();
        }

        @Override // com.tendcloud.tenddata.a
        public String getUrl() {
            return "https://me.cpatrk.net";
        }
    };
    private static final a APP_SQL = new a("APP_SQL", 7) { // from class: com.tendcloud.tenddata.a.3
        @Override // com.tendcloud.tenddata.a
        public String getCert() {
            return "";
        }

        @Override // com.tendcloud.tenddata.a
        public String getDataFolder() {
            return super.getDataFolder();
        }

        @Override // com.tendcloud.tenddata.a
        public int getFileLimitType() {
            return super.getFileLimitType();
        }

        @Override // com.tendcloud.tenddata.a
        public String getHost() {
            return aa.f19742b;
        }

        @Override // com.tendcloud.tenddata.a
        public String getIP() {
            return null;
        }

        @Override // com.tendcloud.tenddata.a
        public String getMessageFormat() {
            return a.MF_MP;
        }

        @Override // com.tendcloud.tenddata.a
        public String getRootFolder() {
            return super.getRootFolder();
        }

        @Override // com.tendcloud.tenddata.a
        public String getUrl() {
            return "https" + getHost() + aa.f19744d;
        }
    };
    private static final a[] service = {APP, ENV, APP_SQL};

    protected a(String str, int i) {
        this.nameString = str;
        this.indexNum = i;
        addFeatures2List(str);
    }

    private void addFeatures2List(String str) {
        try {
            if (af.b(str) || FeaturesList.contains(str)) {
                return;
            }
            FeaturesList.add(str);
        } catch (Throwable unused) {
        }
    }

    public static ArrayList<a> getFeaturesList() {
        ArrayList<a> arrayList = new ArrayList<>();
        for (int i = 0; i < FeaturesList.size(); i++) {
            try {
                if (valueOf(FeaturesList.get(i)) != null) {
                    arrayList.add(valueOf(FeaturesList.get(i)));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static List<String> getFeaturesNameList() {
        return FeaturesList;
    }

    public static a valueOf(String str) {
        if (str.equals(APP.name())) {
            return APP;
        }
        if (str.equals(ENV.name())) {
            return ENV;
        }
        if (str.equals(APP_SQL.name())) {
            return APP_SQL;
        }
        return null;
    }

    public static a[] values() {
        a[] aVarArr = service;
        return (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
    }

    public abstract String getCert();

    public String getDataFolder() {
        return "td_database" + index() + cy.f19981c;
    }

    public int getFileLimitType() {
        return 1;
    }

    public abstract String getHost();

    public abstract String getIP();

    public abstract String getMessageFormat();

    public String getRootFolder() {
        return aa.z;
    }

    public abstract String getUrl();

    public int index() {
        return this.indexNum;
    }

    public String name() {
        return this.nameString;
    }

    public boolean needToSendData() {
        return true;
    }

    public void setUrl(String str) {
    }

    protected a(String str, int i, boolean z) {
        this.nameString = str;
        this.indexNum = i;
    }
}
