<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>修改APP基础信息 <i class="fa fa-user"></i>${loginInfo.devcode}</h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
        <form class="form-horizontal form-label-left" action="${pageContext.request.contextPath}update?logopicpath=${logopicpath}" method="post" enctype="multipart/form-data">
          <input type="hidden" name="id" id="id" value="${appInfo.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1"
               name="softwarename" value="${appInfo.softwarename}" required="required" placeholder="请输入软件名称" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" type="text" class="form-control col-md-7 col-xs-12" name="apkname" value="${appInfo.apkname}" readonly="readonly">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="supportROM" class="form-control col-md-7 col-xs-12" 
              	name="supportrom" value="${appInfo.supportrom}" required="required"
              	data-validate-length-range="20" data-validate-words="1" 
              	placeholder="请输入支持的ROM" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" 
              data-validate-length-range="20" data-validate-words="1"  required="required"
              name="interfacelanguage" value="${appInfo.interfacelanguage}"
              placeholder="请输入软件支持的界面语言" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwareSize" name="softwaresize" value="${appInfo.softwaresize}" required="required"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads" value="${appInfo.downloads}" required="required"
              data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" value="${appInfo.flatformid}" id="fid" />
              <select name="flatformid" id="flatformId" class="form-control" required="required">
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" value="${appInfo.categorylevel1}" id="cl1" />
              <select name="categorylevel1" id="queryCategoryLevel1" class="form-control"  required="required"></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="hidden" value="${appInfo.categorylevel2}" id="cl2" />
              <select name="categorylevel2" id="queryCategoryLevel2" class="form-control"  required="required"></select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" value="${appInfo.categorylevel3}" id="cl3" />
              <select name="categorylevel3" id="queryCategoryLevel3" class="form-control"  required="required"></select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input id="statusname" type="text" class="form-control col-md-7 col-xs-12"
              	name="statusname" value="${appInfo.statusname}" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appinfo" name="appinfo" required="required"
              placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12"  style="height: 130px; width: 372px">
              ${appInfo.appinfo}</textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <span>
                    <input type="hidden" name="oldPicPath" value="${logopicpath}" />
                  <img height="100" width="100" src="${logopicpath}"><input type="file" class="form-control col-md-7 col-xs-12" name="a_logoPicPath" id="a_logoPicPath"/>
                </span>
				<p><span style="color:red;font-weight: bold;">*注：1、大小不得超过5M.2、图片格式：jpg、png、jpeg、pneg</span></p>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
            	<c:if test="${appInfo.status == 3}">
            	 	<button id="send" type="submit" name="status" value="1" class="btn btn-success">保存并再次提交审核</button>
            	</c:if>
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back" onclick="javascript:window.history.back(-1)">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@ include file="common/footer.jsp"%>
<script type="text/javascript" language="JavaScript">
    $.post("${pageContext.request.contextPath}/getAppPt",null,function(data){
        //动态option
        for(var i=0;i<data.length;i++){
            var option="<option value="+data[i].valueid+">"+data[i].valuename+"</option>";
            $("#flatformId").append(option);
        }

        //设置选中项
        $("#flatformId").val(${appInfo.flatformid});
    },"json");

    //发送异步请求加载一级分类
    $.post("${pageContext.request.contextPath}/getCategroyByParentId",null,function(data){
        //获取数据动态添加到下拉列表
        for(var i=0;i<data.length;i++){
            var option="<option value="+data[i].id+">"+data[i].categoryname+"</option>";
            $("#queryCategoryLevel1").append(option);
        }

        //设置选中项
        $("#queryCategoryLevel1").val(${appInfo.categorylevel1});
        //加载二级分类
        loadCategroyLevel2();
    },"json");

    //当一级分类选项发生改变时加载二级分类
    //加载二级分类:
    function loadCategroyLevel2(){
        //获取当前下拉列表中选中项的值
        var parentId=$("#queryCategoryLevel1").val();
        $("#queryCategoryLevel2>option:gt(0)").remove();  //清空现有项
        if(parentId!=""){  //为"" 表示选中了“请选择”
            //发送异步请求加载
            $.post("${pageContext.request.contextPath}/getCategroyByParentId",{"id":parentId},function(data){
                //获取数据动态添加到下拉列表
                for(var i=0;i<data.length;i++){
                    var option="<option value="+data[i].id+">"+data[i].categoryname+"</option>";
                    $("#queryCategoryLevel2").append(option);
                }

                //设置选中项
                $("#queryCategoryLevel2").val(${appInfo.categorylevel2});

                //加载三级分类
                loadLevel3();
            },"json");
        }
    }
    //二级联动效果
    $("#queryCategoryLevel1").change(loadCategroyLevel2);

    //当二级分类选项发生改变时加载三级分类
    //加载三级分类
    function loadLevel3(){
        //获取当前下拉列表中选中项的值
        var parentId=$("#queryCategoryLevel2").val();
        $("#queryCategoryLevel3>option:gt(0)").remove();  //清空现有项
        if(parentId!=""){  //为"" 表示选中了“请选择”
            //发送异步请求加载
            $.post("${pageContext.request.contextPath}/getCategroyByParentId",{"id":parentId},function(data){
                //获取数据动态添加到下拉列表
                for(var i=0;i<data.length;i++){
                    var option="<option value="+data[i].id+">"+data[i].categoryname+"</option>";
                    $("#queryCategoryLevel3").append(option);
                }

                //设置选中项
                $("#queryCategoryLevel3").val(${appInfo.categorylevel3});

            },"json");
        }

    }
    //联动效果
    $("#queryCategoryLevel2").change(loadLevel3);
</script>
