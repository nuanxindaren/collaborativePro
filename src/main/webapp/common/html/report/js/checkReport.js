// Call the dataTables jQuery plugin
//实例代码
$.fn.dataTable.ext.buttons.export = {
    className: 'buttons-alert',

    action: function ( e, dt, node, config ) {
        location.href="/weekly/exportWeekly.shtml";
    }
};
$(document).ready(function() {
    var table = $('#dataTable').dataTable({
        /*"scrollY": 300,
         "scrollCollapse": true,*/
        bLengthChange:false,
        "autoWidth": false,
        "jQueryUI": false,
        "bSort": false,
        "bProcessing": true,
        "language": {
            "sProcessing": "处理中...",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "抱歉， 没有找到",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "sZeroRecords": "没有检索到数据",
            "sSearch": "检索:",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "尾页"
            }
        },
        dom: 'Bfrtip',
        buttons: [
            {
                extend: 'export',
                text: '导出'
            }
        ],
        "ajax":{
            type:"post",
            url:"/weekly/getWorkerListReport.shtml",
            dataSrc:function(data){
                console.log(data.officeReportDOList)
                return data.officeReportDOList;
            }
        },
        /*columns:[
         { data : 'reportTitle' },
         { data : 'reportId' },
         { data : 'insDate' }
         ]*/
        "aoColumns":[
            {
                "sTitle":"序号",
                "sClass":"dt-center",
                "bSortable":false,
                "sWidth": "10%",
                "data": null,
                "targets": 0
            },
            {
                "sTitle":"标题",
                "sClass":"dt-center",
                "bSortable":false,
                "sWidth": "50%",
                "mDataProp" : "reportTitle"
            },
            {
                "sTitle":"提交人",
                "sClass":"dt-center",
                "bSortable":false,
                "sWidth": "20%",
                "mDataProp" : "reportAuthor"
            },
            {
                "sTitle":"ID",
                "sClass":"dt-center",
                "bSortable":false,
                "sWidth": "20%",
                "mDataProp" : "reportId"
            },
            {
                "sTitle":"日期",
                "sClass":"dt-center",
                "bSortable":false,
                "sWidth": "20%",
                "mDataProp" : "insDate",
                "render":function(data,type,row,meta){
                    return(new Date(data)).Format("yyyy-MM-dd");
                }
            },
        ],
        "columnDefs": [
            {
                "targets": [ 3 ],
                "visible": false
            }
        ],
        "fnDrawCallback"    : function(){
            this.api().column(0).nodes().each(function(cell, i) {
                cell.innerHTML =  i + 1;
            });
        }
    });
    $("#dataTable").on("click","tr",function(){//给tr或者td添加click事件
        var data=table.api().row(this).data();//获取值的对象数据
        parent.createModel(data.reportId)
    })
});


