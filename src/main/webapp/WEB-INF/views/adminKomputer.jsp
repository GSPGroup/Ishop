<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row-fluid">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="">
				<ul class="nav navbar-nav">
					<li><a href="/admin/ram">Ram</a></li>
					<li><a href="/admin/typeprocessor">Type Processors</a></li>
					<li><a href="/admin/coreprocessor">Core Processors</a></li>
					<li><a href="/admin/videoadapter">Video Adapter</a></li>
					<li><a href="/admin/processor">Processors</a></li>
					<li><a href="/admin/hdd">Hdd</a></li>
					<li><a href="/admin/komputer">Komputer</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row-fluid">
	<div class="col-md-3 col-xs-12">
		<div class="col-md-12 col-xs-12">
			<form:form action="/admin/komputer" class="form-inline"
				method="get" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search" />
				<div class="form-group">
					<form:input path="search" placeholder="search" class="form-control" />
					<label></label>
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
			</form:form>
		</div>
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="col-md-12 col-xs-12">
	<form:form action="/admin/komputer" method="post" modelAttribute="komputer" class="form-inline" enctype="multipart/form-data" >
		<form:errors path="*"/>
		<form:hidden path="id" />
		<custom:hiddenInputs excludeParams=" id,  hdd, ram, videoadapter, processor, price "/>
			<div class="form-group">
			<form:select path="hdd" items="${hdds}" itemLabel="hddGb" itemValue="id">
			</form:select>
			<form:select path="ram" items="${rams}" itemLabel="ramGb" itemValue="id">
			</form:select>
			<form:select path="videoadapter" items="${videoadapters}" itemLabel="name" itemValue="id">
			</form:select>
			<form:select path="processor" items="${processors}" itemLabel="name" itemValue="id">
			</form:select>
			<form:input id="price" path="price" placeholder="processor name" class="form-control" />
					<label for="price"><form:errors path="price" /></label>
					<label
						class="btn btn-default btn-file"> Browse <input
						type="file" name="file" style="display: none;">
					</label>
			<button type="submit" class="btn btn-primary">Create Komputer</button>
			</div>
	</form:form>
		</div>
		<div class="col-md-4 col-xs-4">
			<h4>Komputer </h4>
		</div>
		<div class="col-md-4 col-xs-4">
			<h4>Delete</h4>
		</div>
		<div class="col-md-4 col-xs-4">
			<h4>Update</h4>
		</div>
		<c:forEach items="${page.content}" var="komputer">
		<div class="col-md-3"><img class="img-thumbnail" width="100" src="/images/komputer/${komputer.id}${komputer.path}?version=${komputer.version}" /></div>
			<div class="col-md-4 col-xs-4">${komputer.hdd.hddGb} ${komputer.hdd.typeHdd} ${komputer.ram.ramGb} ${komputer.videoadapter.name} ${komputer.processor.name} </div>
			<div class="col-md-4 col-xs-4">
				<a
					href="/admin/komputer/delete/${komputer.id}<custom:allParams/>">delete</a>
			</div>
			<div class="col-md-4 col-xs-4">
				<a
					href="/admin/komputer/update/${komputer.id}<custom:allParams/>">update</a>
			</div>
		</c:forEach>
		 <div class="col-md-12 col-xs-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div> 
	</div>
	<div class="col-md-2 col-xs-12">
		<div class="col-md-6 col-xs-6 text-center">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Sort <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
				 <custom:sort innerHtml="price asc" paramValue="price"/>
						<custom:sort innerHtml="price desc" paramValue="price,desc"/>
			<%-- 			 <custom:sort innerHtml="coreprocessor core asc" paramValue="coreprocessor.core"/>
						<custom:sort innerHtml="coreprocessor core desc" paramValue="coreprocessor.core,desc"/> --%>
				</ul>
			</div>
		</div>
		<div class="col-md-6 col-xs-6 text-center">
			<custom:size posibleSizes="1,2,5,10" size="${page.size}"
				title="Page size" />
		</div>
	</div>
</div> 