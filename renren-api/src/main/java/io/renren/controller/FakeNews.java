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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


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
    public R fakeNewsFiles(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return R.error().put("msg","参数传递错误");
        }
        InputStreamReader isr = null;
        BufferedReader br = null;
        List<List<String>> strs = new ArrayList<List<String>>();
        try {
            isr = new InputStreamReader(file.getInputStream());
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null){
                strs.add(Arrays.asList(line.split(",")));
            }
        } catch (IOException e) {
            //
        }finally {
            if (br != null){
                br.close();
            }
            if (isr != null){
                isr.close();
            }
        }
        for (List<String> l : strs){
            String title = l.get(0);
            String news = l.get(1);
            if(StringUtils.isEmpty(title) || StringUtils.isEmpty(news)){
                return R.error().put("msg","参数传递错误");
            }
            Date date = new Date();
            String timeStamp = String.valueOf(date);
            Long id = IDUtils.createID();
            NewsEntity newsEntity = new NewsEntity();
            newsEntity.setText(title+" "+news);
            newsEntity.setId(id);
            newsEntity.setCreatedAt(timeStamp);
            newsEntity.setInReplyToStatusId(id+"");
            String json = objectMapper.writeValueAsString(newsEntity);
            FileUtils.save2File("D:\\test\\unknow_label\\"+id+"\\source-tweet\\"+id+".json", json);

            String[] arguments = new String[] {"python", "E:\\code\\ERD-master\\main.py","batch_size","20"};
            try {
                Process process = Runtime.getRuntime().exec(arguments);
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                in.close();
                //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
                //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
                int re = process.waitFor();
                System.out.println(re);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return R.ok().put("msg", "请求成功").put("result","共处理了"+ strs.size() +"条数据").put("code",200);
    }
}
