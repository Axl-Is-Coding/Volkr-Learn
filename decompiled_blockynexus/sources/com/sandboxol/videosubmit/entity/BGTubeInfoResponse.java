package com.sandboxol.videosubmit.entity;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BGTubeInfoResponse {
    private String activityEndTime;
    private String activityId;
    private String activityStartTime;
    private String awardDate;
    private int bestEditingAward;
    private String eventRulesHeadUrl;
    private int excellentPotentialAward;
    private List<LinkInfo> games;
    private int mostCreativeAward;
    private int mostPopularAward;
    private List<String> optionalSubmissionGameUrls;
    private List<String> optionalVideoThemes;
    private List<Winner> previousWinners;
    private RewardDetail reward;
    private SubmissionTime submissionTime;
    private String topBackgroundUrl;
    private int totalGcubeAwards;
    private List<String> videoTypes;
    private String winnerAwardTopicUrl;

    public String getActivityEndTime() {
        return this.activityEndTime;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityStartTime() {
        return this.activityStartTime;
    }

    public String getAwardDate() {
        return this.awardDate;
    }

    public int getBestEditingAward() {
        return this.bestEditingAward;
    }

    public String getEventRulesHeadUrl() {
        return this.eventRulesHeadUrl;
    }

    public int getExcellentPotentialAward() {
        return this.excellentPotentialAward;
    }

    public List<LinkInfo> getGames() {
        return this.games;
    }

    public int getMostCreativeAward() {
        return this.mostCreativeAward;
    }

    public int getMostPopularAward() {
        return this.mostPopularAward;
    }

    public List<String> getOptionalSubmissionGameUrls() {
        return this.optionalSubmissionGameUrls;
    }

    public List<String> getOptionalVideoThemes() {
        return this.optionalVideoThemes;
    }

    public List<Winner> getPreviousWinners() {
        return this.previousWinners;
    }

    public RewardDetail getReward() {
        return this.reward;
    }

    public SubmissionTime getSubmissionTime() {
        return this.submissionTime;
    }

    public String getTopBackgroundUrl() {
        return this.topBackgroundUrl;
    }

    public int getTotalGcubeAwards() {
        return this.totalGcubeAwards;
    }

    public List<String> getVideoTypes() {
        return this.videoTypes;
    }

    public String getWinnerAwardTopicUrl() {
        return this.winnerAwardTopicUrl;
    }

    public void setActivityEndTime(String str) {
        this.activityEndTime = str;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityStartTime(String str) {
        this.activityStartTime = str;
    }

    public void setAwardDate(String str) {
        this.awardDate = str;
    }

    public void setBestEditingAward(int i) {
        this.bestEditingAward = i;
    }

    public void setEventRulesHeadUrl(String str) {
        this.eventRulesHeadUrl = str;
    }

    public void setExcellentPotentialAward(int i) {
        this.excellentPotentialAward = i;
    }

    public void setGames(List<LinkInfo> list) {
        this.games = list;
    }

    public void setMostCreativeAward(int i) {
        this.mostCreativeAward = i;
    }

    public void setMostPopularAward(int i) {
        this.mostPopularAward = i;
    }

    public void setOptionalSubmissionGameUrls(List<String> list) {
        this.optionalSubmissionGameUrls = list;
    }

    public void setOptionalVideoThemes(List<String> list) {
        this.optionalVideoThemes = list;
    }

    public void setPreviousWinners(List<Winner> list) {
        this.previousWinners = list;
    }

    public void setReward(RewardDetail rewardDetail) {
        this.reward = rewardDetail;
    }

    public void setSubmissionTime(SubmissionTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public void setTopBackgroundUrl(String str) {
        this.topBackgroundUrl = str;
    }

    public void setTotalGcubeAwards(int i) {
        this.totalGcubeAwards = i;
    }

    public void setVideoTypes(List<String> list) {
        this.videoTypes = list;
    }

    public void setWinnerAwardTopicUrl(String str) {
        this.winnerAwardTopicUrl = str;
    }
}
