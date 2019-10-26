<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>首页</title>
<link rel="stylesheet" href="frame/layui/css/layui.css">
<link rel="stylesheet" href="./frame/static/css/style.css">
<link rel="icon" href="./frame/static/image/code.png">
</head>
<body>

	<!-- layout admin -->
	<div class="layui-layout layui-layout-admin">
		<!-- 添加skin-1类可手动修改主题为纯白，添加skin-2类可手动修改主题为蓝白 -->
		<!-- header -->
		<div class="layui-header my-header">
			<a href="index.jsp"> <!--<img class="my-header-logo" src="" alt="logo">-->
				<div class="my-header-logo">UPMS用户权限管理系统</div>
			</a>
			<div class="my-header-btn">
				<button class="layui-btn layui-btn-small btn-nav">
					<i class="layui-icon">&#xe65f;</i>
				</button>
			</div>
			<!-- 顶部右侧添加选项卡监听 -->
			<ul class="layui-nav my-header-user-nav" lay-filter="side-top-right">
				<li class="layui-nav-item"><a class="name" href="javascript:;"><i
						class="layui-icon">&#xe629;</i>主题</a>
					<dl class="layui-nav-child">
						<dd data-skin="0">
							<a href="javascript:;">默认</a>
						</dd>
						<dd data-skin="1">
							<a href="javascript:;">纯白</a>
						</dd>
						<dd data-skin="2">
							<a href="javascript:;">蓝白</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a class="name" href="javascript:;">
						Admin </a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;" href-url="demo/login.html"><i
								class="layui-icon">&#xe621;</i>修改密码</a>
						</dd>

						<dd>
							<a href="/"><i class="layui-icon">&#x1006;</i>退出</a>
						</dd>
					</dl></li>
			</ul>

		</div>


		<!-- side -->
		<div class="layui-side my-side">
			<div class="layui-side-scroll">
				<!-- 左侧主菜单添加选项卡监听 -->
				<ul class="layui-nav layui-nav-tree" lay-filter="side-main">
				</ul>

			</div>
		</div>


		<!-- body -->
		<div class="layui-body my-body" style="bottom: 0">
			<div class="layui-tab layui-tab-card my-tab" lay-filter="card"
				lay-allowClose="true">
				<ul class="layui-tab-title">
					<li class="layui-this" lay-id="1"><span><i
							class="layui-icon">&#xe638;</i>欢迎页</span></li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe id="iframe" src="jsp/welcome.html" frameborder="0"></iframe>
					</div>
				</div>
			</div>
		</div>

	</div>



	<!-- 右键菜单 -->
	<div class="my-dblclick-box none">
		<table class="layui-tab dblclick-tab">
			<tr class="card-refresh">
				<td><i class="layui-icon">&#x1002;</i>刷新当前标签</td>
			</tr>
			<tr class="card-close">
				<td><i class="layui-icon">&#x1006;</i>关闭当前标签</td>
			</tr>
			<tr class="card-close-all">
				<td><i class="layui-icon">&#x1006;</i>关闭所有标签</td>
			</tr>
		</table>
	</div>

	<script type="text/javascript" src="frame/layui/layui.js"></script>
	<script type="text/javascript" src="./frame/static/js/vip_comm.js"></script>
	<script type="text/javascript">
		layui.use([ 'layer', 'vip_nav' ], function() {

			// 操作对象
			var layer = layui.layer, vipNav = layui.vip_nav, $ = layui.jquery;

			// 主体菜单生成 [请求地址,过滤ID,是否展开,携带参数]
			vipNav.main('./json/tab/tab.json', 'side-main', true);

			// you code ...
		});
		var table;
		var ind;
		function winopen(title, url, w, h, tab) {
			table = tab;
			ind = layer.open({
				title : title,
				type : 2,
				area : [ w, h ],
				fixed : false,//不固定
				maxmin : true,
				content : url
			});
		}
		//关闭窗口
		function winclose() {
			layer.close(ind);
		}
		//刷新表格
		function tableRD() {
			table.reload();
		}
		function winalert(msg, aa) {
			layer.alert(msg,aa);
		}
	</script>
</body>
</html>