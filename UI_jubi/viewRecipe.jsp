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

<title>레시피 상세페이지</title>
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
					<li class="nav-item"><a class="nav-link" href="#">레시피 검색</a></li>
					<li class="nav-item"><a class="nav-link" href="#">내 냉장고</a></li>
				</ul>
			</div>
		</nav>
		<blockquote class="blockquote"
			style="margin-top: 3rem; margin-bottom: 3rem; margin-left: 1rem">
			<p class="mb-0">레시피 이름</p>
			<footer class="blockquote-footer"> 레시피 요약.. 어쩌구 저쩌구 </footer>
		</blockquote>

		<div class="row" style="margin-top: 20px">
			<div class="col-8">
				<img style="width: 600px; height: auto"
					src="https://images.otwojob.com/product/S/4/j/S4j16Sr3BY3cCiq.jpg/o2j/resize/852x622%3E"
					alt="사진" />
			</div>
			<div class="col-4">
				<ul class="list-unstyled">
					<li>준비물
						<form class="form-inline">
							<select class="custom-select my-1 mr-sm-2"
								id="inlineFormCustomSelectPref">
								<option selected>Choose...</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
							</select> <label class="my-1 mr-2" for="inlineFormCustomSelectPref">인분
								조리</label>
							<button type="submit" class="btn btn-light my-1">적용</button>
						</form>
						<ul>
							<li>사과 1개</li>
							<li>귤 5개</li>
							<li>당근 1개</li>
						</ul>
					</li>
					<li><br>요리방법
						<ol>
							<li>어쩌구</li>
							<li>어쩌구</li>
							<li>어쩌구</li>
						</ol></li>
				</ul>
			</div>
		</div>

		<button type="button" class="mx-auto btn btn-outline-dark">레시피
			저장</button>


		<form style="margin-top: 3rem">
			<p class="font-weight-normal">후기 작성</p>
			<div class="form-group">
				<label for="exampleFormControlInput1">아이디</label>
				<p class="font-weight-light">somvengers</p>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">후기</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3"></textarea>
			</div>
		</form>

		<button type="button" class="mx-auto btn btn-outline-dark">후기
			등록</button>
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