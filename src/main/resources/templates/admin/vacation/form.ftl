<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/hadmin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx!}/hadmin/css/font-awesome.css" rel="stylesheet">
    <link href="${ctx!}/hadmin/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/hadmin/css/style.css?v=${version}" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
      <#--  <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>jQuery Validate 简介</h5>
                    </div>
                    <div class="ibox-content">
                        <p>jquery.validate.js 是一款优秀的jQuery表单验证插件。它具有如下特点：</p>
                    </div>
                </div>
            </div>
        </div>-->
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>完整验证表单</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="">
                        	<input type="hidden" id="id" name="id" value="1">

                            <#--<div class="form-group">-->
                                <#--<label class="col-sm-2 control-label">标题：</label>-->
                                <#--<div class="col-sm-9">-->
                                    <#--<input id="title" name="title" class="form-control" type="text" value="${article.title}">-->
                                <#--</div>-->
                            <#--</div>-->
                            <div class="input-group date form-group" data-provide="datepicker">
                                <label class="col-sm-2 control-label">开始时间：</label>
                                <input type="text" class="col-sm-4" id="vacation_start" name="vacation_start">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-th"></span>
                                </div>
                            </div>

                            <div class="input-group date form-group" data-provide="datepicker">
                                <label class="col-sm-2 control-label">结束时间：</label>
                                <input type="text" class="col-sm-4" id="vacation_end" name="vacation_end">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-th"></span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">假期联系电话：</label>
                                <div class="col-sm-9">
                                    <input id="homeNum" name="homeNum" class="form-control" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">描述：</label>
                                <div class="col-sm-9" >
                                    <textarea id="description" name="description" style="height:400px;max-height:500px;">
                                        ${article.description}
                                    </textarea>
                                </div>
                            </div>

                            <#--<div class="form-group">-->
                                <#--<label class="col-sm-2 control-label">备注：</label>-->
                                <#--<div class="col-sm-9" >-->
                                    <#--<textarea id="remark" class="form-control" name="remark" >${article.remark}</textarea>-->
                                <#--</div>-->
                            <#--</div>-->

                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- 全局js -->
    <#include "/admin/common/common.ftl">
    <#include "/admin/common/uploadimage_common.ftl">
    <!--引入wangEditor配置文件-->
    <link rel="stylesheet" type="text/css" href="${ctx!}/hadmin/js/plugins/wangEditor-2.1.23/dist/css/wangEditor.min.css"/>
    <script type="text/javascript" src="${ctx!}/hadmin/js/plugins/wangEditor-2.1.23/dist/js/wangEditor.js"></script>
    <script type="text/javascript" src="${ctx!}/hadmin/js/plugins/wangEditor-2.1.23/editorconfig.js"></script>
    <script type="text/javascript" src="${ctx!}/hadmin/js/plugins/datapicker/bootstrap-datepicker.js"></script>

    <script type="text/javascript">
    $(document).ready(function () {
	  	//外部js调用
	  /*  laydate({
	        elem: '#birthday', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
	        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
	    });*/

	    $("#frm").validate({
            rules: {
                description: {
                    required: true,
                    minlength: 5
                }
            },
            messages: {
                description: {
                    required: "请假原因必填"
                }
            },
    	    submitHandler:function(form){
    	        alert("ok");
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/vacation/edit",
   	    		   data: $(form).serialize(),
   	    		   success: function(msg){
   	    		       alert("成功了");
	   	    			layer.msg(msg.message, {time: 2000},function(){
	   						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	   						parent.layer.close(index);
	   					});
   	    		   }
   	    		});
            }
    	});
        //上传照片
        $('#uploadDIv').diyUpload({
            url:'${ctx}/html5/upload.html',
            success:function( data ) {
                    $("#pic").val("${ctx}"+data._raw);
                    $("#picImg").attr('src',"${ctx}"+data._raw);
            },
            error:function( err ) {
                console.info( err );
            },
            buttonText : '上传照片',
            chunked:true,
            // 分片大小
            chunkSize:1024 * 1024*2,
            //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
            fileNumLimit:1,
            fileSizeLimit:10 * 1024*1024,
            fileSingleSizeLimit:50 * 1024*1024,
            accept: {}
        });
    });
    </script>

</body>

</html>
