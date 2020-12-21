<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!-- start banner Area -->
<section class="banner-area relative" id="home">
	<div class="overlay overlay-bg"></div>
	<div class="container">
		<div class="row d-flex align-items-center justify-content-center">
			<div class="about-content col-lg-12">
				<h1 class="text-white">尋找您想要的課程</h1>
				<p class="text-white link-nav">
					<a href="index.html">首頁</a> <span class="lnr lnr-arrow-right"></span>
					<a href="<c:url value='/18/cSelectAllFront.ctrl' />">課程總覽</a>
					<span class="lnr lnr-arrow-right"></span>
					<span>關鍵字搜尋結果</span>
				</p>
			</div>
		</div>
	</div>
</section>
<!-- End banner Area -->


<div class="container" style="font-size: 20px">
<div style="margin: 20px">
<form action="<c:url value="/18/searchByWord.ctrl"/>">
						<p style="text-align: center; display: block; font-size: 24px; color:black">
							課程名稱關鍵字查詢： <input type="text" name="searchWord" id=searchw> 
							<input type="submit" name="" value="送出" class="genric-btn primary radius">
						</p>
					</form>
</div>

<button id="flower" class="genric-btn primary-border radius">一鍵輸入欲查詢之關鍵字</button>
<div style="padding-bottom:10px; float:right"><a href="<c:url value='/18/cSelectAllFront.ctrl' />"><button class='btn btn-info'>回課程總覽</button></a></div>
<div style="margin: 20px">
<form action="<c:url value="/18/searchByType.ctrl"/>">

<p style="text-align: center; font-size: 22px;">
	<br>
	<button type="submit" name="searchType" class="genric-btn info circle" value="語文">語文</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="園藝">園藝</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="風俗信仰">風俗信仰</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="手工製作">手工製作</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="國畫書法">國畫書法</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="運動">運動</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="藝術鑑賞">藝術鑑賞</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="美術">美術</button>
	<button type="submit" name="searchType" class="genric-btn info circle" value="戲劇">戲劇</button>	
</p>			
</form>
</div>

<div style="text-align: center;">
				<form action="toCoCart.ctrl">
                <input type="hidden" name="method" value="order"/>
                <input type="submit" style="margin-left: 10px; font-size: 25px;"
							class="genric-btn success radius large" name="check" value="前往結帳">
                </form>
			</div>


<table id="cTable" class="table table-bordered table-hover" width="100%"
	cellspacing="0">
	<thead class="thead-dark">
		<tr>
			<th>圖片</th>
			<th>課程簡介</th>
<!-- 			<th>課程類型</th> -->
<!-- 			<th>課程圖片</th> -->
<!-- 			<th>剩餘名額</th> -->
<!-- 			<th>課程詳細及購買</th> -->
<!-- 			<th>查看次數</th> -->
		</tr>
	</thead>

	<tbody>   <!--直接設定編號${stat.count}取代${cSearchResultw.coId}-->
		<c:forEach var="cSearchResultw" varStatus="stat" items="${psbw}">
			<tr><td><img style='display: block; width: 480px; height: 270px;'
									src="data:image/jpg;base64, ${cSearchResultw.coAct_ImageStr}"></td>
								<td class="unordered-list"><div style="font-size:30px; font-weight:bold; color:black">${cSearchResultw.coId}. ${cSearchResultw.coTitle}</div>
								<div style="padding-top:20px; font-size:24px; color:black">課程類別：<a href="<c:url value='/18/searchByType.ctrl?searchType=${cSearchResultw.coAct_Type}' />">${cSearchResultw.coAct_Type}</a></div>
								<div style="padding-top:20px; font-size:24px; color:black">剩餘名額：${cSearchResultw.coNum}人</div>
								<div style="padding-top:20px; font-size:24px; color:black">售價：${cSearchResultw.coPrice}元</div>
								<div style="padding-top:80px; font-size:24px; color:black"><a href="<c:url value='/18/cCourseDetail.ctrl?coId=${cSearchResultw.coId}' /> "> 
 								<input class='genric-btn success-border radius' type='button' value='查看課程詳細' /></a></div>
								</td></tr>
		</c:forEach>
	</tbody>
</table>
</div>


<script>
$(document).ready( function () {
    $('#cTable').DataTable({
    	language: {
    		search: "在本表格中搜尋：",
    		lengthMenu:"每頁顯示 _MENU_ 筆資料",
    		zeroRecords: "没有符合的结果",
    		info: "顯示第 _START_ 至 _END_ 項结果，共 _TOTAL_ 項",
    		infoEmpty: "顯示第 0 至 0 項结果，共 0 項",
    		paginate: {
                first: "首頁",
                previous: "上一頁",
                next: "下一頁",
                last: "末頁"
            },
            infoFiltered: "(已比對 _MAX_ 項結果)",
    	}
    } );
} );


	$("#flower").click(function(){
		$("#searchw").val("花");
	})
</script>