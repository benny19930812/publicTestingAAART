<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/frontstyle/css/processbar.css' />">
<style type="text/css">
            img {max-width: 100%; height: auto;}
            .imagemap {position: relative;}
            .imagemap img {display: block;}
            .imagemap .area {display: block; position: absolute; transition: box-shadow 0.15s ease-in-out;}
            .imagemap .area:hover {box-shadow: 0px 0px 1vw rgba(0,0,0,0.5);}
                </style>



</head>
<body>


	<!-- start banner Area -->
	<section class="banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white">AAART Ticket</h1>
					<p class="text-white link-nav">
						<a href="<c:url value='/index.html' />">Home </a> <span
							class="lnr lnr-arrow-right"></span> <a href=""> Search</a><span
							class="lnr lnr-arrow-right"></span><a href=""> Order</a>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->

<div class="container">

<div class="row bs-wizard" style="border-bottom:0;">
                    
                    <div class="col-lg-3 bs-wizard-step start"><!-- start -->
                      <div class="text-center bs-wizard-stepnum">Step 1</div>
                      <div class="progress"><div class="progress-bar" style="width: 100%;"></div></div>
                      <a href="" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">區域/張數</div>
                    </div>
                    
                    <div class="col-lg-3 bs-wizard-step complet"><!-- complete -->
                      <div class="text-center bs-wizard-stepnum">Step 2</div>
                      <div class="progress"><div class="progress-bar" style="width: 50%;"></div></div>
                      <a href="#" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">劃位</div>
                    </div>
                    
                    <div class="col-lg-3 bs-wizard-step active"><!-- complete -->
                      <div class="text-center bs-wizard-stepnum">Step 3</div>
                      <div class="progress"><div class="progress-bar"></div></div>
                      <a href="" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">購票確認</div>
                    </div>
                    
                    <div class="col-lg-3 bs-wizard-step disabled"><!-- active -->
                      <div class="text-center bs-wizard-stepnum">Step 4</div>
                      <div class="progress"><div class="progress-bar"></div></div>
                      <a href="" class="bs-wizard-dot"></a>
                      <div class="bs-wizard-info text-center">完成訂購</div>
                    </div>
                </div>
	

		<c:set var="seat" value="${requestScope.seat}" />
		<form name="order" action="<c:url value='/04/shoppingcart.ctrl'/>"
			method="get">
			<p id="ticketnum" style="display: none">${sessionScope.shoppingcart.TICKET_NUM}</p>
			<h1>座位表</h1>
			<h2>請勾選位置</h2>
			<p>請在灰色空位上點選您要的位置</p>


			<img src="<c:url value='/images/04/seatmap2.jpg' />" border="0"
				usemap="#image-map" alt="座位表" id="seatmap" class="" width="600" height="849"/> 

			<map name="image-map" id="seatmap" class="map">
				<area  target="sssssss" shape="rect" coords="123,111,470,304" href="sun.html"
					alt="淺藍色" />
				<area  target="sssssss"shape="rect" coords="123,303,470,495" href="sun.html"
					alt="深藍色" />
				<area target="sssssss" alt="area1" title="" href=""
					coords="39,113,123,113,125,495,474,493,474,113,561,113,562,457,521,458,522,534,473,533,473,573,387,573,386,612,211,611,211,571,127,572,127,534,81,535,81,458,40,459"
					shape="poly">
			</map>





			<br> <br> <input type="submit" id="submit"
				class="genric-btn primary-border radius" value="下一步"
				onclick="checknum()">
		</form>

<script type="text/javascript">
    var images = document.querySelectorAll('img[usemap]');
    images.forEach( function(image) {
        var mapid = image.getAttribute('usemap').substr(1);
        var imagewidth = image.getAttribute('width');
        var imageheight = image.getAttribute('height');
        var imagemap = document.querySelector('map[name="'+mapid+'"]');
        var areas = imagemap.querySelectorAll('area');
    
        image.removeAttribute('usemap');
        imagemap.remove();
    
        // create wrapper container
        var wrapper = document.createElement('div');
        wrapper.classList.add('imagemap');
        image.parentNode.insertBefore(wrapper, image);
        wrapper.appendChild(image);
    
        areas.forEach( function(area) {
            var coords = area.getAttribute('coords').split(',');
            var xcoords = [parseInt(coords[0]),parseInt(coords[2])];
            var ycoords = [parseInt(coords[1]),parseInt(coords[3])];
            xcoords = xcoords.sort(function(a, b){return a-b});
            ycoords = ycoords.sort(function(a, b){return a-b});
            wrapper.innerHTML += "<a href='"+area.getAttribute('href')+"' title='"+area.getAttribute('title')+"' class='area' style='left: "+((xcoords[0]/imagewidth)*100).toFixed(2)+"%; top: "+((ycoords[0]/imageheight)*100).toFixed(2)+"%; width: "+(((xcoords[1] - xcoords[0])/imagewidth)*100).toFixed(2)+"%; height: "+(((ycoords[1] - ycoords[0])/imageheight)*100).toFixed(2)+"%;'></a>";
        });
    });
        </script>    

</body>
</html>