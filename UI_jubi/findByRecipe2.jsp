<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/css/find.css' />"
	type="text/css">

<title>레시피 검색</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Recipe Book</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">메인
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">레시피 검색</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">내 냉장고</a>
					</li>
				</ul>
			</div>
		</nav>
		
		<div class="search" style="margin-top:30px">
		<h6>요리명으로 검색</h6>
		
		<div class="input-group mb-3" style="margin-left:1rem">
				<input type="text" class="form-control"
					placeholder="재료명"
					aria-label="재료명" aria-describedby="button-addon2">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="button"
						id="button-addon2"
						onClick="location.href='/UserMan3/user/findByRecipe2.jsp'">레시피 검색</button>
				</div>
			</div>
		</div>
				
		<div class="container" style="margin-top:30px">
			<div class="row">
				<div class="col-3">
					<article id="3685" class="location-listing">
						<a class="location-title" href="#"> 첫번째 </a>
						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://images.otwojob.com/product/S/4/j/S4j16Sr3BY3cCiq.jpg/o2j/resize/852x622%3E"
								alt="san francisco">
							</a>
						</div>
					</article>
				</div>
				<div class="col-3">
					<article id="3688" class="location-listing">
						<a class="location-title" href="#"> 두번째 </a>
						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://dimg.donga.com/a/500/0/90/5/ugc/CDB/29STREET/Article/5e/b2/04/e8/5eb204e81752d2738236.jpg"
								alt="london">
							</a>
						</div>
					</article>
				</div>
				<div class="col-3">
					<article id="3691" class="location-listing">
						<a class="location-title" href="#"> 세번째 </a>
						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://img1.daumcdn.net/thumb/S600x434/?scode=1boon&fname=https://t1.daumcdn.net/liveboard/dailylife/3cfa947defa5429ba74d195c299070c9.jpg"
								alt="new york">
							</a>
						</div>
					</article>
				</div>
				<div class="col-3">
					<article id="3694" class="location-listing">
						<a class="location-title" href="#"> 네번째 </a>
						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/03/a0003495/img/basic/a0003495_main.jpg?20190823151731&q=80&rw=750&rh=536"
								alt="cape town">
							</a>
						</div>
					</article>
				</div>
			</div>
			<div class="row" style="margin-top:10%">
				<div class="col-3">
					<article id="3697" class="location-listing">

						<a class="location-title" href="#"> 다섯번째 </a>

						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://cloudfront-ap-northeast-1.images.arcpublishing.com/chosun/XVPEGSXWHO257H4AOOOTOOAYRQ.jpg"
								alt="beijing">
							</a>
						</div>
					</article>
				</div>
				<div class="col-3">
					<article id="3700" class="location-listing">

						<a class="location-title" href="#"> 여섯번째 </a>

						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://jhealthfile.joins.com/photo//2019/06/10/1341592187da3.jpg"
								alt="paris">
							</a>
						</div>
					</article>
				</div>
				<div class="col-3">
					<article id="3703" class="location-listing">

						<a class="location-title" href="#"> 일곱번째 </a>

						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://health.chosun.com/site/data/img_dir/2020/06/26/2020062603299_0.jpg"
								alt="paris">
							</a>
						</div>
					</article>
				</div>
				<div class="col-3">
					<article id="3706" class="location-listing">

						<a class="location-title" href="#"> 여덟번째 </a>

						<div class="location-image">
							<a href="#"> <img width="300" height="169"
								src="https://gradium.co.kr/wp-content/uploads/taco.jpg"
								alt="paris">
							</a>
						</div>
					</article>
				</div>
			</div>
		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
	</div>
</body>
</html>