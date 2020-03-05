<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					APP 信息管理维护 <i class="fa fa-user"></i>${loginInfo.devcode}
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form method="post" id="form1" name="form1" action="${pageContext.request.contextPath}/allAppInfo">
					<!--添加隐藏域  传递页码-->
					<input id="setPage" type="hidden" name="page" value="1">
					<input type="hidden" name="pageIndex" value="1" />
					<ul>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input name="softwarename" value="${condition.softwarename}" type="text" class="form-control col-md-7 col-xs-12" value="${querySoftwareName}">
								</div>
							</div>
						</li>

						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="queryStatus" name="status" class="form-control">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
						</li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="queryFlatformId" name="flatformid" class="form-control">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
						</li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="queryCategoryLevel1" name="categorylevel1" class="form-control">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
						</li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
									<select id="queryCategoryLevel2" name="categorylevel2" id="queryCategoryLevel2" class="form-control">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
						</li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select name="categorylevel3" id="queryCategoryLevel3" class="form-control">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
						</li>
						<li>
							<button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button>&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="reset" class="btn btn-warning"> 清 &nbsp;&nbsp;&nbsp;&nbsp;空 </button>
						</li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_content">
				<p class="text-muted font-13 m-b-30"></p>
				<div id="datatable-responsive_wrapper"
					 class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row">
						<div class="col-sm-12">
							<a href="jsp/developer/appinfoadd.jsp" class="btn btn-success btn-sm">新增APP基础信息</a>
							<!--显示所有的信息-->
							<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
								   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
								<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="First name: activate to sort column descending"
										aria-sort="ascending">软件名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										APK名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										软件大小(单位:M)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										所属平台</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										所属分类(一级分类、二级分类、三级分类)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										状态</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										下载次数</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										最新版本号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 124px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach var="ai" items="${pageInfo.list}" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${ai.softwarename}</td>
										<td>${ai.apkname}</td>
										<td>${ai.softwaresize}</td>
										<td>${ai.flatformname}</td>
										<td>${ai.cname1} -> ${ai.cname2} -> ${ai.cname3}</td>
										<td>${ai.statusname}</td>
										<td>${ai.downloads}</td>
										<td>${ai.versionno}</td>
										<td name="curtd">
											<div class="btn-group">
												<button type="button" class="btn btn-danger">点击操作</button>
												<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
													<span class="caret"></span>
													<span class="sr-only">Toggle Dropdown</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<li>
														<c:choose>
															<c:when test="${ai.status == 2 || ai.status == 5}">
																<a name="upper" appid="${ai.id}" class="saleSwichOpen" saleSwitch="open" data-toggle="tooltip"
																   data-placement="top" title=""
																   data-original-title="恭喜您，您的审核已经通过，您可以点击上架发布您的APP">上架</a>
															</c:when>
															<c:when test="${ai.status == 4}">
																<a name="lower" appid="${ai.id}" class="saleSwichClose" saleSwitch="close"
																   data-toggle="tooltip" data-placement="top" title=""
																   data-original-title="您可以点击下架来停止发布您的APP，市场将不提供APP的下载">下架</a>
															</c:when>
														</c:choose>
													</li>
													<li>
														<a class="addVersion" data-toggle="tooltip" href="${pageContext.request.contextPath}/getAllVersion?id=${ai.id}" data-placement="top">新增版本</a>
													</li>
													<li>
														<a class="modifyVersion" data-toggle="tooltip" href="${pageContext.request.contextPath}/getAllVersions?id=${ai.id}" data-placement="top">修改版本</a>
													</li>
													<li>
														<a  class="modifyAppInfo" data-toggle="tooltip" href="${pageContext.request.contextPath}/updateAppInfo?id=${ai.id}" data-placement="top">修改</a>
													</li>
													<li>
														<a  class="viewApp" data-toggle="tooltip" href="${pageContext.request.contextPath}/getSingleAppInfo?id=${ai.id}&loginInfo=${loginInfo}" data-placement="top">查看</a>
													</li>
													<li>
														<a class="deleteApp"  data-toggle="tooltip" onclick="conf(${ai.id},${ai.logopicpath})" data-placement="top">删除</a>
													</li>
												</ul>
											</div>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5">
							<div class="dataTables_info" id="datatable-responsive_info" role="status" aria-live="polite">共${pageInfo.total}条记录
								${pageInfo.pageNum}/${pageInfo.pages}页</div>
						</div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers" id="datatable-responsive_paginate">
								<ul class="pagination">
									<c:if test="${pageInfo.pageNum >= 1}">
										<li class="paginate_button previous"><a
												href="javascript:goPage(1);"
												aria-controls="datatable-responsive" data-dt-idx="0"
												tabindex="0">首页</a>
										</li>
										<li class="paginate_button "><a
												href="javascript:goPage(${pageInfo.pageNum-1});"
												aria-controls="datatable-responsive" data-dt-idx="1"
												tabindex="0">上一页</a>
										</li>
									</c:if>
									<c:if test="${pageInfo.pageNum <= pageInfo.pages}">
										<li class="paginate_button "><a
												href="javascript:goPage(${pageInfo.pageNum+1});"
												aria-controls="datatable-responsive" data-dt-idx="1"
												tabindex="0">下一页</a>
										</li>
										<li class="paginate_button next"><a
												href="javascript:goPage(${pageInfo.pages});"
												aria-controls="datatable-responsive" data-dt-idx="7"
												tabindex="0">最后一页</a>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jsp"%>
<script language="JavaScript">
	$(function(){  //加载事件
        //1.发送异请求加载app状态信息:采用jquery的异步方法获取数据
		//$.post("服务器地址",传给服务器的参数,回调函数,"json");
                $.post("${pageContext.request.contextPath}/getAppState",null,function(data){
                    //data表示返回的数据
                    //console.log(data); //输出到浏览器的控制台
                    //动态option
                    for(var i=0;i<data.length;i++){
                        var option="<option value="+data[i].valueid+">"+data[i].valuename+"</option>";
                        $("#queryStatus").append(option);
                    }

			//设置选中项
            $("#queryStatus").val(${condition.status});
		},"json");

		//2.发送异步请求获取平台信息
        $.post("${pageContext.request.contextPath}/getAppPt",null,function(data){
            //动态option
            for(var i=0;i<data.length;i++){
                var option="<option value="+data[i].valueid+">"+data[i].valuename+"</option>";
                $("#queryFlatformId").append(option);
            }

            //设置选中项
            $("#queryFlatformId").val(${condition.flatformid});
        },"json");

        //发送异步请求加载一级分类
        $.post("${pageContext.request.contextPath}/getCategroyByParentId",null,function(data){
            //获取数据动态添加到下拉列表
            for(var i=0;i<data.length;i++){
                var option="<option value="+data[i].id+">"+data[i].categoryname+"</option>";
                $("#queryCategoryLevel1").append(option);
            }

            //设置选中项
            $("#queryCategoryLevel1").val(${condition.categorylevel1});
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
                    $("#queryCategoryLevel2").val(${condition.categorylevel2});

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
                        $("#queryCategoryLevel3").val(${condition.categorylevel3});

                    },"json");
                }

		}
       //联动效果
        $("#queryCategoryLevel2").change(loadLevel3);
	});

	//带查询条件的分页展示
	function goPage(pageNum){
	     //1.设置页码
 	 	$("#setPage").val(pageNum);
 	 	//2.提交表单
 		$("#form1").submit();  //提交
	}

	function conf(id,oldPath) {
        if(confirm('是否删除?')){
            window.location.href = "${pageContext.request.contextPath}/delAppInfo?id=" + id + "&oldPath=" + oldPath;
        }
    }

    //实现上架的异步请求
    $(function () {  //加载
        $("a[name='upper']").click(function () {
            //获取app的id
			var id = $(this).attr("appid");
			//显示状态单元格
			var node = $(this).parents("[name='curtd']").prev().prev().prev();
			//上下架的a标签
			var anode = $(this);
            //发送异步请求实现上架
            if (anode.html() == "上架"){
                $.post("${pageContext.request.contextPath}/upperAndLowerFrames",{"id":id,"status":4},function (data) {
                    if (data.result == 1) {
                        node.html("已上架");
                        anode.html("下架");
                    }else{
                        alert("上架失败!");
                    }
                },"json");
			}else{
                $.post("${pageContext.request.contextPath}/upperAndLowerFrames",{"id":id,"status":5},function (data) {
                    if (data.result == 1) {
                        node.html("已下架");
                        anode.html("上架");
                    }else{
                        alert("下架失败!");
                    }
                },"json");
			}
        });
    });
</script>
