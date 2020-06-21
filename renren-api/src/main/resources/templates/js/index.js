$(document).ready(function(){

    function ajax(options){
        options = options ||{};  //调用函数时如果options没有指定，就给它赋值{},一个空的Object
        options.type=(options.type || "GET").toUpperCase();/// 请求格式GET、POST，默认为GET
        options.dataType=options.dataType || "json";    //响应数据格式，默认json

        var params=formatParams(options.data);//options.data请求的数据

        var xhr;

        //考虑兼容性
        if(window.XMLHttpRequest){
            xhr=new XMLHttpRequest();
        }else if(window.ActiveObject){//兼容IE6以下版本
            xhr=new ActiveXobject('Microsoft.XMLHTTP');
        }

        //启动并发送一个请求
        if(options.type=="GET"){
            xhr.open("GET",options.url+"?"+params,true);
            xhr.send(null);
        }else if(options.type=="POST"){
            xhr.open("post",options.url,true);

            //设置表单提交时的内容类型
            //Content-type数据请求的格式
            xhr.setRequestHeader("Content-type","application/json;charset=UTF-8");
            xhr.send(params);
        }

        //    设置有效时间
        setTimeout(function(){
            if(xhr.readySate!=4){
                xhr.abort();
            }
        },options.timeout)

        //    接收
        //     options.success成功之后的回调函数  options.error失败后的回调函数
        //xhr.responseText,xhr.responseXML  获得字符串形式的响应数据或者XML形式的响应数据
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4){
                var status=xhr.status;
                if(status>=200&& status<300 || status==304){
                    options.success&&options.success(xhr.responseText,xhr.responseXML);
                }else{
                    options.error&&options.error(status);
                }
            }
        }
    }

    //格式化请求参数
    function formatParams(data){
        var arr=[];
        for(var name in data){
            arr.push(encodeURIComponent(name)+"="+encodeURIComponent(data[name]));
        }
        arr.push(("v="+Math.random()).replace(".",""));
        return arr.join("&");

    }
  

  function submit() {
      var params = "text="+$(".layui-input").val()+"&title="+$(".layui-textarea").val();
      $.post("/renren-api/news.json",params,function(result){
          //因为SpringMVC框架和Jquery框架的联合作用，使得传回来的result保留了原有数据类型
          if(result){
              console.log(result);
              alert("检测完成");
          }else{
              //完全等于document.getElementById("erSpan").innerHTML = result+":"+"登录失败！";
              alert("失败");
          }
      })

  }


  $(".input-btn").click( function () { 
  		console.log("submit form")
  		submit();
   });

  $(".input-check").click( function () {
  	 	$(".input-submit-body").removeClass("no-display");$(".input-submit-body").siblings().addClass("no-display");
	});
  $(".file-check").click( function () { 
  		$(".file-submit-body").removeClass("no-display");$(".file-submit-body").siblings().addClass("no-display");
  	});

  
  $(".upload-submit").click( function() {
  	console.log("upload file");
  	var myformData = new FormData();
  	console.log($("#text-file")[0].files);
  	myformData.append('file', $("#text-file")[0].files);

      var file = $("#text-file")[0].files[0];
      var form = new FormData();
      form.append("file", file);
      $.ajax({
          url: "/renren-api/newsFile.json",
          type: "POST",
          contentType: "multipart/form-data",
          data: form,
          async: false, //异步
          processData: false, //很重要，告诉jquery不要对form进行处理
          contentType: false, //很重要，指定为false才能形成正确的Content-Type
          success: function(res) {
              console.log("success")
              alert("检测完成");
          },
          error: function() {
              alert("失败")
          }
      });


      /*$.post("/renren-api/newsFile.json",myformData,function(result){
          //因为SpringMVC框架和Jquery框架的联合作用，使得传回来的result保留了原有数据类型
          if(result){
              console.log(result);
          }else{
              //完全等于document.getElementById("erSpan").innerHTML = result+":"+"登录失败！";
              alert("失败");
          }
      })*/
      /*$.ajax({
          // 后台接口地址
　　　　"url": "/renren-api/newsFile.json",

　　　　"type": "POST",

　　　　"processData": false,

　　　　"contentType": false,

　　　　"xhrFields": {

　　　　　　withCredentials: true

　　　　},

　　　　"data": myformData,

　　　　success: function(data) {

　　　　　　console.log(data)

　　　　},

　　　　error: function() {
            alert("上传失败");
            console.log("upload error")
　　　　}

　　})*/
  })
              
});