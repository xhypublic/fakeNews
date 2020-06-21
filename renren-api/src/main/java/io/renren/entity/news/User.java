package io.renren.entity.news;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class User {
    @JsonProperty("follow_request_sent")
    private boolean followRequestSent;
    @JsonProperty("profile_use_background_image")
    private boolean profileUseBackgroundImage;
    @JsonProperty("default_profile_image")
    private boolean defaultProfileImage;
    private int id;
    @JsonProperty("profile_background_image_url_https")
    private String profileBackgroundImageUrlHttps;
    private boolean verified;
    @JsonProperty("profile_text_color")
    private String profileTextColor;
    @JsonProperty("profile_image_url_https")
    private String profileImageUrlHttps;
    @JsonProperty("profile_sidebar_fill_color")
    private String profileSidebarFillColor;
    private Entities entities;
    @JsonProperty("followers_count")
    private int followersCount;
    @JsonProperty("profile_sidebar_border_color")
    private String profileSidebarBorderColor;
    @JsonProperty("id_str")
    private String idStr;
    @JsonProperty("profile_background_color")
    private String profileBackgroundColor;
    @JsonProperty("listed_count")
    private int listedCount;
    @JsonProperty("is_translation_enabled")
    private boolean isTranslationEnabled;
    @JsonProperty("utc_offset")
    private int utcOffset;
    @JsonProperty("statuses_count")
    private int statusesCount;
    private String description;
    @JsonProperty("friends_count")
    private int friendsCount;
    private String location;
    @JsonProperty("profile_link_color")
    private String profileLinkColor;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
    private boolean following;
    @JsonProperty("geo_enabled")
    private boolean geoEnabled;
    @JsonProperty("profile_banner_url")
    private String profileBannerUrl;
    @JsonProperty("profile_background_image_url")
    private String profileBackgroundImageUrl;
    @JsonProperty("screen_name")
    private String screenName;
    private String lang;
    @JsonProperty("profile_background_tile")
    private boolean profileBackgroundTile;
    @JsonProperty("favourites_count")
    private int favouritesCount;
    private String name;
    private boolean notifications;
    private String url;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("contributors_enabled")
    private boolean contributorsEnabled;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("protected")
    private boolean protect;
    @JsonProperty("default_profile")
    private boolean defaultProfile;
    @JsonProperty("is_translator")
    private boolean isTranslator;
}