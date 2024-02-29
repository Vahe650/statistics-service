package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TrafficByAsin {
    private Integer browserSessions;
    private Integer browserSessionsB2B;
    private Integer mobileAppSessions;
    private Integer mobileAppSessionsB2B;
    private Integer sessions;
    private Integer sessionsB2B;
    private Double browserSessionPercentage;
    private Double browserSessionPercentageB2B;
    private Double mobileAppSessionPercentage;
    private Double mobileAppSessionPercentageB2B;
    private Double sessionPercentage;
    private Double sessionPercentageB2B;
    private Integer browserPageViews;
    private Integer browserPageViewsB2B;
    private Integer mobileAppPageViews;
    private Integer mobileAppPageViewsB2B;
    private Integer pageViews;
    private Integer pageViewsB2B;
    private Double browserPageViewsPercentage;
    private Double browserPageViewsPercentageB2B;
    private Double mobileAppPageViewsPercentage;
    private Double mobileAppPageViewsPercentageB2B;
    private Double pageViewsPercentage;
    private Double pageViewsPercentageB2B;
    private Double buyBoxPercentage;
    private Double buyBoxPercentageB2B;
    private Double unitSessionPercentage;
    private Double unitSessionPercentageB2B;

    @Override
    public int hashCode() {
        return Objects.hash(browserSessions, browserSessionsB2B, mobileAppSessions, mobileAppSessionsB2B, sessions,
                sessionsB2B, browserSessionPercentage, browserSessionPercentageB2B, mobileAppSessionPercentage,
                mobileAppSessionPercentageB2B, sessionPercentage, sessionPercentageB2B, browserPageViews,
                browserPageViewsB2B, mobileAppPageViews, mobileAppPageViewsB2B, pageViews, pageViewsB2B,
                browserPageViewsPercentage, browserPageViewsPercentageB2B, mobileAppPageViewsPercentage,
                mobileAppPageViewsPercentageB2B, pageViewsPercentage, pageViewsPercentageB2B, buyBoxPercentage,
                buyBoxPercentageB2B, unitSessionPercentage, unitSessionPercentageB2B);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficByAsin that = (TrafficByAsin) o;
        return Objects.equals(browserSessions, that.browserSessions)
                && Objects.equals(browserSessionsB2B, that.browserSessionsB2B)
                && Objects.equals(mobileAppSessions, that.mobileAppSessions)
                && Objects.equals(mobileAppSessionsB2B, that.mobileAppSessionsB2B)
                && Objects.equals(sessions, that.sessions) && Objects.equals(sessionsB2B, that.sessionsB2B)
                && Objects.equals(browserSessionPercentage, that.browserSessionPercentage)
                && Objects.equals(browserSessionPercentageB2B, that.browserSessionPercentageB2B)
                && Objects.equals(mobileAppSessionPercentage, that.mobileAppSessionPercentage)
                && Objects.equals(mobileAppSessionPercentageB2B, that.mobileAppSessionPercentageB2B)
                && Objects.equals(sessionPercentage, that.sessionPercentage)
                && Objects.equals(sessionPercentageB2B, that.sessionPercentageB2B)
                && Objects.equals(browserPageViews, that.browserPageViews)
                && Objects.equals(browserPageViewsB2B, that.browserPageViewsB2B)
                && Objects.equals(mobileAppPageViews, that.mobileAppPageViews)
                && Objects.equals(mobileAppPageViewsB2B, that.mobileAppPageViewsB2B)
                && Objects.equals(pageViews, that.pageViews) && Objects.equals(pageViewsB2B, that.pageViewsB2B)
                && Objects.equals(browserPageViewsPercentage, that.browserPageViewsPercentage)
                && Objects.equals(browserPageViewsPercentageB2B, that.browserPageViewsPercentageB2B)
                && Objects.equals(mobileAppPageViewsPercentage, that.mobileAppPageViewsPercentage)
                && Objects.equals(mobileAppPageViewsPercentageB2B, that.mobileAppPageViewsPercentageB2B)
                && Objects.equals(pageViewsPercentage, that.pageViewsPercentage)
                && Objects.equals(pageViewsPercentageB2B, that.pageViewsPercentageB2B)
                && Objects.equals(buyBoxPercentage, that.buyBoxPercentage)
                && Objects.equals(buyBoxPercentageB2B, that.buyBoxPercentageB2B)
                && Objects.equals(unitSessionPercentage, that.unitSessionPercentage)
                && Objects.equals(unitSessionPercentageB2B, that.unitSessionPercentageB2B);
    }
}
