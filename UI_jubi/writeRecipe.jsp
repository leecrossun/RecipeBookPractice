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

<title>레시피 등록</title>
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
			<p class="mb-0">레시피 등록</p>
			<footer class="blockquote-footer">나만의 레시피를 등록해 보세여</footer>
		</blockquote>

		<form>
			<div class="form-group">
				<label for="exampleFormControlInput1">레시피 이름</label> 
				<input type="email" class="form-control" id="exampleFormControlInput1"
					placeholder="냠냠">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">레시피 한줄 설명</label> 
				<input type="email" class="form-control" id="exampleFormControlInput1"
					placeholder="냠냠">
			</div>
			<div class="form-group">
				<label for="exampleFormControlFile1">음식 사진</label> 
				<input type="file" class="form-control-file" id="exampleFormControlFile1">
			</div>

			<div class="form-group">
			<label for="exampleFormControlFile1">필요한 재료<br></label>
			<div class="input-group">
				<input type="text" class="form-control"
					placeholder="재료명 입력"
					aria-label="재료명 입력"
					aria-describedby="button-addon4">
				<div class="input-group-append" id="button-addon4">
					<button class="btn btn-outline-secondary" type="button">검색</button>
					<button class="btn btn-outline-secondary" type="button">등록</button>
				</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="exampleFormControlTextarea1">만드는 방법</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" placeholder="1. ... 2. ..."></textarea>
			</div>
		</form>
		
		<button type="button" class="mx-auto btn btn-outline-dark">레시피 등록</button>

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