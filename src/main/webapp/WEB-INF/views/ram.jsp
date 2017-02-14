<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<header id="header">
	<div class="header-bottom">
		<!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a href="/" class="active">Home</a></li>
							<li><a href="404.html">404</a></li>
							<li><a href="/contactus">Contact</a></li>
						</ul>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="search_box pull-right">
						<form:form action="/ram" class="form-inline" method="get"
							modelAttribute="filter">
							<custom:hiddenInputs excludeParams="search" />
							<div class="form-group">
								<form:input path="search" placeholder="search"
									class="form-control" />
								<label></label>
								<button type="submit" class="btn btn-primary">Ok</button>
							</div>
						</form:form>
					</div>
					<div class="col-sm-12">
						<div class="col-sm-12">
							<div class="col-sm-6">
								<div class="dropdown">
									<button class="btn btn-primary dropdown-toggle" type="button"
										data-toggle="dropdown">
										Sort <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<custom:sort innerHtml="ramGb asc" paramValue="ramGb" />
										<custom:sort innerHtml="ramGb desc" paramValue="ramGb,desc" />
									</ul>
								</div>
							</div>
							<div class="col-sm-6 ">
								<custom:size posibleSizes="6,12" size="${page.size}"
									title="Page size" />
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</header>
<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="left-sidebar">
					<h2>Category</h2>
					<div class="panel-group category-products" id="accordian">
						<!--category-productsr-->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordian"
										href="#sportswear"> <span class="badge pull-right"><i
											class="fa fa-plus"></i></span> Комплектуючі
									</a>
								</h4>
							</div>
							<div id="sportswear" class="panel-collapse collapse">
								<div class="panel-body">
									<ul>
										<li><a href="/hdd">HDDs </a></li>
										<li><a href="/ram">Rams </a></li>
										<li><a href="/processor">Processors </a></li>
										<li><a href="/videoadapter">Video Adapters</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a href="/komputer">Персональні Комп`ютери</a>
								</h4>
							</div>
						</div>
					</div>
					<div class="brands_products">
						<!--brands_products-->
					</div>
					<div class="price-range">
						<!--price-range-->
						<h2>Price Range</h2>
						<div class="well text-center">
							<input type="text" class="span2" value="" data-slider-min="0"
								data-slider-max="600" data-slider-step="5"
								data-slider-value="[250,450]" id="sl2"><br /> <b
								class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
						</div>
					</div>
					<div class="shipping text-center"></div>
				</div>
			</div>
			<div class="col-sm-9 padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Features Items</h2>
					<div class="col-sm-12">
						<div class="product-image-wrapper">
							<c:forEach items="${page.content}" var="ram">
								<div class="col-md-4">
									<div class="col-md-12">
										<img class="img-thumbnail" width="100"
											src="/images/ram/${ram.id}${ram.path}?version=${ram.version}" />
									</div>
									<div class="col-md-12 col-xs-12">${ram.ramGb}Gb</div>
									<div class="col-md-12 col-xs-12">${ram.price}UAH</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-xs-12 text-center">
				<custom:pageable page="${page}" cell="<li></li>"
					container="<ul class='pagination'></ul>" />
			</div>

		</div>

	</div>
</section>




<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.scrollUp.min.js"></script>
<script src="resources/js/price-range.js"></script>
<script src="resources/js/jquery.prettyPhoto.js"></script>
<script src="resources/js/main.js"></script>
