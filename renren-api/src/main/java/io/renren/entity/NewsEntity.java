package io.renren.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.renren.entity.news.Entities;
import io.renren.entity.news.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Auto-generated: 2020-06-21 15:34:30
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Getter
@Setter
public class NewsEntity {

    private String contributors;
    private boolean truncated;
    private String text;
    @JsonProperty("in_reply_to_status_id")
    private String inReplyToStatusId;
    private Long id;
    @JsonProperty("favorite_count")
    private int favoriteCount;
    private String source;
    private boolean retweeted;
    private String coordinates;
    private Entities entities;
    @JsonProperty("in_reply_to_screen_name")
    private String inReplyToScreenName;
    @JsonProperty("id_str")
    private String idStr;
    @JsonProperty("retweet_count")
    private int retweetCount;
    @JsonProperty("in_reply_to_user_id")
    private String inReplyToUserId;
    private boolean favorited;
    private User user;
    private String geo;
    @JsonProperty("in_reply_to_user_id_str")
    private String inReplyToUserIdStr;
    private String lang;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("in_reply_to_status_id_str")
    private String inReplyToStatusIdStr;
    private String place;


}