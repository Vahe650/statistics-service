package com.statistics.statisticsservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TrafficByDate {
    private Integer browserPageViews;
    private Integer browserPageViewsB2B;
    private Integer mobileAppPageViews;
    private Integer mobileAppPageViewsB2B;
    private Integer pageViews;
    private Integer pageViewsB2B;
    private Integer browserSessions;
    private Integer browserSessionsB2B;
    private Integer mobileAppSessions;
    private Integer mobileAppSessionsB2B;
    private Integer sessions;
    private Integer sessionsB2B;
    private Double buyBoxPercentage;
    private Double buyBoxPercentageB2B;
    private Double orderItemSessionPercentage;
    private Double orderItemSessionPercentageB2B;
    private Double unitSessionPercentage;
    private Double unitSessionPercentageB2B;
    private Integer averageOfferCount;
    private Integer averageParentItems;
    private Integer feedbackReceived;
    private Integer negativeFeedbackReceived;
    private Double receivedNegativeFeedbackRate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficByDate that = (TrafficByDate) o;
        return Objects.equals(browserPageViews, that.browserPageViews)
                && Objects.equals(browserPageViewsB2B, that.browserPageViewsB2B)
                && Objects.equals(mobileAppPageViews, that.mobileAppPageViews)
                && Objects.equals(mobileAppPageViewsB2B, that.mobileAppPageViewsB2B)
                && Objects.equals(pageViews, that.pageViews) && Objects.equals(pageViewsB2B, that.pageViewsB2B)
                && Objects.equals(browserSessions, that.browserSessions)
                && Objects.equals(browserSessionsB2B, that.browserSessionsB2B)
                && Objects.equals(mobileAppSessions, that.mobileAppSessions)
                && Objects.equals(mobileAppSessionsB2B, that.mobileAppSessionsB2B)
                && Objects.equals(sessions, that.sessions) && Objects.equals(sessionsB2B, that.sessionsB2B)
                && Objects.equals(buyBoxPercentage, that.buyBoxPercentage)
                && Objects.equals(buyBoxPercentageB2B, that.buyBoxPercentageB2B)
                && Objects.equals(orderItemSessionPercentage, that.orderItemSessionPercentage)
                && Objects.equals(orderItemSessionPercentageB2B, that.orderItemSessionPercentageB2B)
                && Objects.equals(unitSessionPercentage, that.unitSessionPercentage)
                && Objects.equals(unitSessionPercentageB2B, that.unitSessionPercentageB2B)
                && Objects.equals(averageOfferCount, that.averageOfferCount)
                && Objects.equals(averageParentItems, that.averageParentItems)
                && Objects.equals(feedbackReceived, that.feedbackReceived)
                && Objects.equals(negativeFeedbackReceived, that.negativeFeedbackReceived)
                && Objects.equals(receivedNegativeFeedbackRate, that.receivedNegativeFeedbackRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(browserPageViews, browserPageViewsB2B, mobileAppPageViews, mobileAppPageViewsB2B,
                pageViews, pageViewsB2B, browserSessions, browserSessionsB2B, mobileAppSessions, mobileAppSessionsB2B,
                sessions, sessionsB2B, buyBoxPercentage, buyBoxPercentageB2B, orderItemSessionPercentage,
                orderItemSessionPercentageB2B, unitSessionPercentage, unitSessionPercentageB2B, averageOfferCount,
                averageParentItems, feedbackReceived, negativeFeedbackReceived, receivedNegativeFeedbackRate);
    }
}
