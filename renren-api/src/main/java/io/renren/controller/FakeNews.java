package io.renren.controller;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import io.renren.common.utils.R;
import io.renren.entity.NewsEntity;
import io.renren.utils.FileUtils;
import io.renren.utils.IDUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@RestController
@RequestMapping("/api")
public class FakeNews {
    private ObjectMapper objectMapper = new ObjectMapper();
    @PostMapping("news.json")
    @ApiOperation("虚假新闻上传接口")
    public R fakeNews(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws JsonProcessingException {
        String title = httpRequest.getParameter("title");
        String news = httpRequest.getParameter("text");
        if(StringUtils.isEmpty(title) || StringUtils.isEmpty(news)){
            return R.error().put("msg","参数传递错误");
        }
        news = title + " " +news;
        Date date = new Date();
        String timeStamp = String.valueOf(date);
        Long id = IDUtils.createID();
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setText(news);
        newsEntity.setId(id);
        newsEntity.setCreatedAt(timeStamp);
        newsEntity.setInReplyToStatusId(id+"");
        String json = objectMapper.writeValueAsString(newsEntity);
        FileUtils.save2File("D:\\test\\unknow_label\\"+id+"\\source-tweet\\"+id+".json", json);
        return R.ok().put("msg", "请求成功").put("result",newsEntity).put("code",200);
    }

    @PostMapping("newsFile.json")
    @ApiOperation("虚假新闻上传接口")
    public R fakeNewsFiles(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return R.error().put("msg","参数传递错误");
        }
        int len = files.length;
        for (MultipartFile file:
             files) {
            byte[] b = file.getBytes();
            String news = new String(b);
            if(StringUtils.isEmpty(news)){
                return R.error().put("msg","参数传递错误");
            }
            Date date = new Date();
            String timeStamp = String.valueOf(date);
            Long id = IDUtils.createID();
            NewsEntity newsEntity = new NewsEntity();
            newsEntity.setText(news);
            newsEntity.setId(id);
            newsEntity.setCreatedAt(timeStamp);
            newsEntity.setInReplyToStatusId(id+"");
            String json = objectMapper.writeValueAsString(newsEntity);
            FileUtils.save2File("D:\\test\\unknow_label\\"+id+"\\source-tweet\\"+id+".json", json);
        }
        return R.ok().put("msg", "请求成功").put("result","成功上传" + len + "个文件").put("code",200);
    }
}
