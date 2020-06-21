package io.renren.entity.news;
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
public class Hashtags {

    private List<Integer> indices;
    private String text;
    public void setIndices(List<Integer> indices) {
         this.indices = indices;
     }
     public List<Integer> getIndices() {
         return indices;
     }


}