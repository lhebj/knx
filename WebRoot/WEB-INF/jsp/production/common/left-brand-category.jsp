<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="leftside clearfix">
	<ul>
		<li class="aside_nav" name="brand"><a class="classification" name="brand"
			href="javascript:;">品牌</a>
			<div class="submenubox">
				<div class="subcate">
					<ul>
						<c:forEach items="${brandTreeCache}" var="brandDTOEntry">
							<li><span class="sort_title">${brandDTOEntry.key}</span>
								<div class="detail">
									<c:forEach items="${brandDTOEntry.value}" var="brandDTO">
										<a href="javascript:;" id="${brandDTO.idBrd}" class="item">${brandDTO.nameBrd}</a>
									</c:forEach>
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</div></li>
		<li class="aside_nav" name="classify"><a class="classification" name="classify"
			href="javascript:;">分类</a>
			<div class="submenubox">
				<div class="subcate">
					<ul>
						<c:forEach items="${categoryTreeCache}" var="categoryDTO">
							<li><a href="javascript:;" class="item"
								id="${categoryDTO.idCat}">${categoryDTO.nameCat}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div></li>
	</ul>
	<c:if test="${newsSimpleDtoList != null}">
		<div class="newsWrap">
			<ul>
				<c:forEach items="${newsSimpleDtoList}" var="newsDto">
					<li><a class="news_list" title="${newsDto.titleN}"
						href="news.do?id=${newsDto.idN}">${newsDto.titleN}</a></li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<c:if test="${trainingSimpleDtoList != null}">
		<div class="newsWrap">
			<ul>
				<c:forEach items="${trainingSimpleDtoList}" var="trainingDto">
					<li><a class="news_list" title="${trainingDto.titleTra}"
						href="training.do?id=${trainingDto.idTra}">${trainingDto.titleTra}</a></li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
</div>