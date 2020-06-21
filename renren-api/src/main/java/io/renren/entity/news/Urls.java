package io.renren.entity.news;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Auto-generated: 2020-06-21 15:34:30
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Getter
@Setter
public class Urls {

    private String url;
    private List<Integer> indices;
    @JsonProperty("expanded_url")
    private String expandedUrl;
    @JsonProperty("display_url")
    private String displayUrl;


}