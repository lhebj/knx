<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

    <title><%=LocalizationUtil.getClientString("Title.admin", request) %></title>
<link rel="stylesheet" type="text/css"
	href="assets/lib/blueprint/screen.css" media="screen, projection" />
<link rel="stylesheet" type="text/css"
	href="assets/lib/blueprint/print.css" media="print" />
<!--[if lt IE 8]><link rel="stylesheet" href="assets/lib/blueprint/ie.css" type="text/css" media="screen, projection" /><![endif]-->
<link rel="stylesheet" href="assets/css/jquery.wysiwyg.css"
	type="text/css" />
<script type="text/javascript" src="assets/lib/jquery.js"></script>
<script type="text/javascript" src="assets/js/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="assets/js/controls/wysiwyg.image.js"></script>
<script type="text/javascript" src="assets/js/controls/wysiwyg.link.js"></script>
<script type="text/javascript" src="assets/js/controls/wysiwyg.table.js"></script>

<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {
							$('#introductionPrddWysiwyg')
									.wysiwyg(
											{
												controls : {
													bold : {
														visible : true
													},
													italic : {
														visible : true
													},
													underline : {
														visible : true
													},
													strikeThrough : {
														visible : true
													},

													justifyLeft : {
														visible : true
													},
													justifyCenter : {
														visible : true
													},
													justifyRight : {
														visible : true
													},
													justifyFull : {
														visible : true
													},

													indent : {
														visible : true
													},
													outdent : {
														visible : true
													},

													subscript : {
														visible : false
													},
													superscript : {
														visible : false
													},

													undo : {
														visible : true
													},
													redo : {
														visible : true
													},

													insertOrderedList : {
														visible : true
													},
													insertUnorderedList : {
														visible : true
													},
													insertHorizontalRule : {
														visible : true
													},

													cut : {
														visible : true
													},
													copy : {
														visible : true
													},
													paste : {
														visible : true
													},
													html : {
														visible : true
													},
													increaseFontSize : {
														visible : true
													},
													decreaseFontSize : {
														visible : true
													},
													exam_html : {
														exec : function() {
															this
																	.insertHtml('<abbr title="exam">Jam</abbr>');
															return true;
														},
														visible : true
													}
												},
												events : {
													click : function(event) {
														if ($("#click-inform:checked").length > 0) {
															event
																	.preventDefault();
															alert("You have clicked jWysiwyg content!");
														}
													}
												}
											});
						});
	})(jQuery);
</script>

<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {
							$('#parametersPrddWysiwyg')
									.wysiwyg(
											{
												controls : {
													bold : {
														visible : true
													},
													italic : {
														visible : true
													},
													underline : {
														visible : true
													},
													strikeThrough : {
														visible : true
													},

													justifyLeft : {
														visible : true
													},
													justifyCenter : {
														visible : true
													},
													justifyRight : {
														visible : true
													},
													justifyFull : {
														visible : true
													},

													indent : {
														visible : true
													},
													outdent : {
														visible : true
													},

													subscript : {
														visible : false
													},
													superscript : {
														visible : false
													},

													undo : {
														visible : true
													},
													redo : {
														visible : true
													},

													insertOrderedList : {
														visible : true
													},
													insertUnorderedList : {
														visible : true
													},
													insertHorizontalRule : {
														visible : true
													},
													cut : {
														visible : true
													},
													copy : {
														visible : true
													},
													paste : {
														visible : true
													},
													html : {
														visible : true
													},
													increaseFontSize : {
														visible : true
													},
													decreaseFontSize : {
														visible : true
													},
													exam_html : {
														exec : function() {
															this
																	.insertHtml('<abbr title="exam">Jam</abbr>');
															return true;
														},
														visible : true
													}
												},
												events : {
													click : function(event) {
														if ($("#click-inform:checked").length > 0) {
															event
																	.preventDefault();
															alert("You have clicked jWysiwyg content!");
														}
													}
												}
											});
						});
	})(jQuery);
</script>

<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {
							$('#featuresPrddWysiwyg')
									.wysiwyg(
											{
												controls : {
													bold : {
														visible : true
													},
													italic : {
														visible : true
													},
													underline : {
														visible : true
													},
													strikeThrough : {
														visible : true
													},

													justifyLeft : {
														visible : true
													},
													justifyCenter : {
														visible : true
													},
													justifyRight : {
														visible : true
													},
													justifyFull : {
														visible : true
													},

													indent : {
														visible : true
													},
													outdent : {
														visible : true
													},

													subscript : {
														visible : false
													},
													superscript : {
														visible : false
													},

													undo : {
														visible : true
													},
													redo : {
														visible : true
													},

													insertOrderedList : {
														visible : true
													},
													insertUnorderedList : {
														visible : true
													},
													insertHorizontalRule : {
														visible : true
													},

													cut : {
														visible : true
													},
													copy : {
														visible : true
													},
													paste : {
														visible : true
													},
													html : {
														visible : true
													},
													increaseFontSize : {
														visible : true
													},
													decreaseFontSize : {
														visible : true
													},
													exam_html : {
														exec : function() {
															this
																	.insertHtml('<abbr title="exam">Jam</abbr>');
															return true;
														},
														visible : true
													}
												},
												events : {
													click : function(event) {
														if ($("#click-inform:checked").length > 0) {
															event
																	.preventDefault();
															alert("You have clicked jWysiwyg content!");
														}
													}
												}
											});
						});
	})(jQuery);
</script>


<script type="text/javascript">
	(function($) {
		$(document)
				.ready(
						function() {
							$('#supplierPrdddWysiwyg')
									.wysiwyg(
											{
												controls : {
													bold : {
														visible : true
													},
													italic : {
														visible : true
													},
													underline : {
														visible : true
													},
													strikeThrough : {
														visible : true
													},

													justifyLeft : {
														visible : true
													},
													justifyCenter : {
														visible : true
													},
													justifyRight : {
														visible : true
													},
													justifyFull : {
														visible : true
													},

													indent : {
														visible : true
													},
													outdent : {
														visible : true
													},

													subscript : {
														visible : false
													},
													superscript : {
														visible : false
													},

													undo : {
														visible : true
													},
													redo : {
														visible : true
													},

													insertOrderedList : {
														visible : true
													},
													insertUnorderedList : {
														visible : true
													},
													insertHorizontalRule : {
														visible : true
													},

													cut : {
														visible : true
													},
													copy : {
														visible : true
													},
													paste : {
														visible : true
													},
													html : {
														visible : true
													},
													increaseFontSize : {
														visible : true
													},
													decreaseFontSize : {
														visible : true
													},
													exam_html : {
														exec : function() {
															this
																	.insertHtml('<abbr title="exam">Jam</abbr>');
															return true;
														},
														visible : true
													}
												},
												events : {
													click : function(event) {
														if ($("#click-inform:checked").length > 0) {
															event
																	.preventDefault();
															alert("You have clicked jWysiwyg content!");
														}
													}
												}
											});
						});
	})(jQuery);
</script>
</head>

<body>
	<%@ include file="../homeHead.jsp"%>


	<div class="page-header">
		<h1>添加或编辑产品</h1>
	</div>
	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="productAdmin.do?action=save" ENCTYPE="multipart/form-data">
		<input name="id" type="hidden"
			value="${productDetailDTO.productDTO.idPrd}" />
		<table>
			<tr>
				<td width='220'>所属品牌</td>
				<td>					
					<select class="selectpicker" name="idbrdPrd">
						<c:forEach items="${brandDTOList}" var="brandDTO">
							<c:if test="${brandDTO.idBrd != selectedBrandId}">
								<option value="${brandDTO.idBrd}">${brandDTO.nameBrd}</option>
							</c:if>
							<c:if test="${brandDTO.idBrd == selectedBrandId}">
								<option value="${brandDTO.idBrd}" selected>${brandDTO.nameBrd}</option>
							</c:if>
						</c:forEach>
					</select>
					</td>
			</tr>
			<tr>
				<td width='220'>所属分类</td>
				<td>
					<select class="selectpicker" name="idcatPrd">
						<c:forEach items="${categoryDTOList}" var="categoryDTO">
							<c:if test="${categoryDTO.idCat != selectedCategoryId}">
								<option value="${categoryDTO.idCat}">${categoryDTO.nameCat}</option>
							</c:if>
							<c:if test="${categoryDTO.idCat == selectedCategoryId}">
								<option value="${categoryDTO.idCat}" selected>${categoryDTO.nameCat}</option>
							</c:if>
						</c:forEach>
					</select>
					</td>
			</tr>
			<tr>
				<td width='220'>产品名称(必填*)</td>
				<td><input name="namePrd" type="text"
					style="width:800px;height:30px"
					value="${productDetailDTO.productDTO.namePrd}" /></td>
			</tr>
			<tr>
				<td width='220'>产品型号(必填*)</td>
				<td><input name="modelPrd" type="text"
					style="width:800px;height:30px"
					value="${productDetailDTO.productDTO.modelPrd}" /></td>
			</tr>
			<tr>
				<td width='220'>产品产地(必填*)</td>
				<td><input name="placePrdd" type="text"
					style="width:800px;height:30px"
					value="${productDetailDTO.placePrdd}" /></td>
			</tr>
			<tr>
				<td width='220'>产品简介</td>
				<td height='200'><textarea id="introductionPrddWysiwyg"
						style="width:800px;height:200px" name="introductionPrdd">${productDetailDTO.introductionPrdd}</textarea></td>
			</tr>
			<tr>
				<td width='220'>产品参数</td>
				<td height='200'><textarea id="parametersPrddWysiwyg"
						style="width:800px;height:200px" name="parametersPrdd">${productDetailDTO.parametersPrdd}</textarea></td>
			</tr>
			<tr>
				<td width='220'>产品特性</td>
				<td height='200'><textarea id="featuresPrddWysiwyg"
						style="width:800px;height:200px" name="featuresPrdd">${productDetailDTO.featuresPrdd}</textarea></td>
			</tr>
			<tr>
				<td width='220'>供货商</td>
				<td height='220'><textarea id="supplierPrdddWysiwyg"
						style="width:800px;height:100px" name="supplierPrdd">${productDetailDTO.supplierPrdd}</textarea></td>
			</tr>
			<tr>
				<td width='220'>产品列表页显示图片(必填*)<br>(最佳尺寸：120 * 150)</td>
				<td><input name="logo" type="FILE" id="logo" size="50" />  
					<input id="logoDeleteFlag" name="logoDeleteFlag" type="hidden" value="false" />
					<c:if test="${productDetailDTO.productDTO.logoName != null}">
						<input type="button" value="删除" onclick="DeletePicFile('logoDeleteFlag', 'logoFileNameFlag')" /> 
						<span id='logoFileNameFlag'>${productDetailDTO.productDTO.logoName}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'>产品页面第一张大图(必填*)<br>(最佳尺寸：184 * 184)</td>
				<td><input name="big_pic" type="FILE" id="bigPic" size="50" />  
					<input id="bigPicDeleteFlag" name="bigPicDeleteFlag" type="hidden" value="false" />
					<c:if test="${productDetailDTO.idbigpicNamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('bigPicDeleteFlag', 'bigPicFileNameFlag')" /> 
						<span id='bigPicFileNameFlag'>${productDetailDTO.idbigpicNamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'></td>
				<td>以下小图图片上传时选择和上面的大图一样尺寸 </td>
			</tr>
			<tr>
				<td width='220'>小图1</td>
				<td><input name="small_pic_1" type="FILE" id="smallPic1" size="50" />  
					<input id="idsmallpic1NamePrddDeleteFlag" name="idsmallpic1NamePrddDeleteFlag" type="hidden" value="false" />
					<c:if test="${productDetailDTO.idsmallpic1NamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('idsmallpic1NamePrddDeleteFlag', 'idsmallpic1NamePrddFlag')" /> 
						<span id='idsmallpic1NamePrddFlag'>${productDetailDTO.idsmallpic1NamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'>小图2</td>
				<td><input name="small_pic_2" type="FILE" id="smallPic2" size="50" />
					<input id="idsmallpic2NamePrddDeleteFlag" name="idsmallpic2NamePrddDeleteFlag" type="hidden" value="false" />
					<c:if test="${productDetailDTO.idsmallpic2NamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('idsmallpic2NamePrddDeleteFlag', 'idsmallpic2NamePrddFlag')" /> 
						<span id='idsmallpic2NamePrddFlag'>${productDetailDTO.idsmallpic2NamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'>小图3</td>
				<td><input name="small_pic_3" type="FILE" id="smallPic3" size="50" />
					<input id="idsmallpic3NamePrddDeleteFlag" name="idsmallpic3NamePrddDeleteFlag" type="hidden"	value="false" />
					<c:if test="${productDetailDTO.idsmallpic3NamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('idsmallpic3NamePrddDeleteFlag', 'idsmallpic3NamePrddFlag')" /> 
						<span id='idsmallpic3NamePrddFlag'>${productDetailDTO.idsmallpic3NamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'>小图4</td>
				<td><input name="small_pic_4" type="FILE" id="smallPic4" size="50" />
					<input id="idsmallpic4NamePrddDeleteFlag" name="idsmallpic4NamePrddDeleteFlag" type="hidden"	value="false" />
					<c:if test="${productDetailDTO.idsmallpic4NamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('idsmallpic4NamePrddDeleteFlag', 'idsmallpic4NamePrddFlag')" /> 
						<span id='idsmallpic4NamePrddFlag'>${productDetailDTO.idsmallpic4NamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'>小图5</td>
				<td><input name="small_pic_5" type="FILE" id="smallPic5" size="50" />
					<input id="idsmallpic5NamePrddDeleteFlag" name="idsmallpic5NamePrddDeleteFlag" type="hidden"	value="false" />
					<c:if test="${productDetailDTO.idsmallpic5NamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('idsmallpic5NamePrddDeleteFlag', 'idsmallpic5NamePrddFlag')" /> 
						<span id='idsmallpic5NamePrddFlag'>${productDetailDTO.idsmallpic5NamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'>小图6</td>
				<td><input name="small_pic_6" type="FILE" id="smallPic6" size="50" />
					<input id="idsmallpic6NamePrddDeleteFlag" name="idsmallpic6NamePrddDeleteFlag" type="hidden"	value="false" />
					<c:if test="${productDetailDTO.idsmallpic6NamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('idsmallpic6NamePrddDeleteFlag', 'idsmallpic6NamePrddFlag')" /> 
						<span id='idsmallpic6NamePrddFlag'>${productDetailDTO.idsmallpic6NamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			<tr>
				<td width='220'>产品页产品Logo<br>(最佳尺寸：314 * 124)</td>
				<td><input name="detail_logo" type="FILE" id="detailLogo" size="50" />  
					<input id="iddetaillogoNamePrddDeleteFlag" name="iddetaillogoNamePrddDeleteFlag" type="hidden"	value="false" />
					<c:if test="${productDetailDTO.iddetaillogoNamePrdd != null}">
						<input type="button" value="删除" onclick="DeletePicFile('iddetaillogoNamePrddDeleteFlag', 'iddetaillogoNamePrddFlag')" /> 
						<span id='iddetaillogoNamePrddFlag'>${productDetailDTO.iddetaillogoNamePrdd}</span> 
					</c:if> 
				</td>
			</tr>
			
			<tr>
				<td width='220'>下载专区</td>
				<td>
					<table id="downloadFileTable">
						<tr>
						  <td style="width:300px;">文件类型</td>
            			  <td>上传文件</td>
            			  <td>操作</td>
         			    </tr>
         			    
         			    <c:forEach items="${pdownloadDTOList}" var="pdownloadDTO">
         			    <tr>
						  <td>${pdownloadDTO.namePrdl}</td>
            			  <td>${pdownloadDTO.fileNamePrdl}</td>
            			  <td><input type="button" value="删除" onclick="DeleteOldFile(${pdownloadDTO.idPrdl},event)" /></td>
         			    </tr>
         			    </c:forEach>
         			    
					</table>
					<input id="deleteOldFilesId" name="deleteOldFiles" type="hidden" />
					<input type="button" value="添加一行新的下载文件" onclick="AddNewFile()" />
				</td>
			</tr>
			<tr>
				<td width='220'></td>
				<td><input class="btn btn-primary" name="ok" type="submit"
					value="提交"> <input type="button" value="取消" class="btn"
					onclick="javascript:window.history.go(-1);" /></td>
			</tr>

		</table>
	</form>

	<script src="assets/js/knx/productdl.js"></script>
	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
