function AddNewFile() {
	// 添加一行
	var i = downloadFileTable.rows.length;
	var dlFileTypeId = "namePrdl" + i;
	var dlFileId = "dlFile" + i;
	var deleteId = "btnDelete" + i;
	var newTr = downloadFileTable.insertRow(i);
	// 添加列

	var dlFileTypeTd = newTr.insertCell(0);
	var dlFileTd = newTr.insertCell(1);
	var deleteTd = newTr.insertCell(2);
	// 设置列内容和属性
	dlFileTypeTd.innerHTML = '文件类型： <input name="' + dlFileTypeId + '" id="'
			+ dlFileTypeId + '" type="text" style="width:200px;height:30px" />';
	dlFileTd.innerHTML = '<input name="' + dlFileId + '" type="FILE" id="'
			+ dlFileId + '" size="50" />';
	deleteTd.innerHTML = '<input id="' + deleteId
			+ '" type="button" value="删除" onclick="DelRow(event)" />';
}
function DelRow(evt) {
	// 删除一行
	// 获得行索引
	// 两个parentElement分别是TD和TR哟，rowIndex是TR的属性
	// this.parentElement.parentElement.rowIndex
	var srcObj = evt.srcElement ? evt.srcElement : evt.target;
	var getRow = srcObj.parentElement.parentElement.rowIndex;
	downloadFileTable.deleteRow(getRow);
}

function DeleteOldFile(idPrd, event) {
	var gnl = confirm("你真的确定要删除吗?");
	if (gnl == false) {
		return true;
	} else {
		DelRow(event);
		var deleteOldFilesId = eval(document.getElementById("deleteOldFilesId")).value;
		document.getElementById("deleteOldFilesId").value = deleteOldFilesId
				+ "," + idPrd;
	}
}