package com.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author renyangze
 * @date 2017/7/25
 */
public class UploadExcelUtil {
    //显示的导出表的标题
    private String title;
    //导出表的列名
    private String[] rowName ;

    private List<Object[]> dataList = new ArrayList<Object[]>();


    //构造方法，传入要导出的数据
    public UploadExcelUtil(String title, String[] rowName, List<Object[]> dataList){
        this.dataList = dataList;
        this.rowName = rowName;
        this.title = title;
    }

    /*
     * 导出数据
     * */
    public void export(HttpServletResponse response) throws Exception{
        try{
            HSSFWorkbook workbook = new HSSFWorkbook();                        // 创建工作簿对象
            HSSFSheet sheet = workbook.createSheet();                     // 创建工作表
            // 产生表格标题行
            HSSFRow rowm = sheet.createRow(0);
            HSSFCell cellTiltle = rowm.createCell(0);

            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
                HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);//获取列头样式对象
            columnTopStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
            columnTopStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
            columnTopStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
            columnTopStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
            HSSFFont font2 = workbook.createFont();
            font2.setFontName("Microsoft YaHei UI");
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
            font2.setFontHeightInPoints((short) 14);  //字体大小
            columnTopStyle.setFont(font2);
            /*HSSFCellStyle style = this.getStyle(workbook);                    //单元格样式对象
            columnTopStyle.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);*/

            /*sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (rowName.length-1)));*/
            /*cellTiltle.setCellStyle(columnTopStyle);
            cellTiltle.setCellValue(title);*/

            // 定义所需列数
            int columnNum = rowName.length;
            HSSFRow rowRowName = sheet.createRow(0);                // 在索引2的位置创建行(最顶端的行开始的第二行)

            // 将列头设置到sheet的单元格中
            for(int n=0;n<columnNum;n++){
                HSSFCell  cellRowName = rowRowName.createCell(n);                //创建列头对应个数的单元格
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);                //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text);                                    //设置列头单元格的值
                cellRowName.setCellStyle(columnTopStyle);                        //设置列头单元格样式

            }
            HSSFCellStyle cellStyle=workbook.createCellStyle();
            cellStyle.setWrapText(true);
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
            cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
            HSSFFont font3 = workbook.createFont();
            font3.setFontName("宋体");
            font3.setFontHeightInPoints((short) 11);  //字体大小
            cellStyle.setFont(font3);
            //将查询出的数据设置到sheet对应的单元格中
            for(int i=0;i<dataList.size();i++){

                Object[] obj = dataList.get(i);//遍历每个对象
                HSSFRow row = sheet.createRow(i+1);//创建所需的行数
               /*
                HSSFCell  cell = null;
                cell = row.createCell(0,HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(i+1);
                row.createCell(1,HSSFCell.CELL_TYPE_STRING).setCellValue("A类");
                row.createCell(2,HSSFCell.CELL_TYPE_STRING).setCellValue("单选题");
                row.createCell(3,HSSFCell.CELL_TYPE_STRING).setCellValue("发额我发额晚饭哇额");
                */
                for(int j=0; j<obj.length; j++){
                    HSSFCell  cell = null;   //设置单元格的数据类型
                    /*if(j == 0){
                        cell = row.createCell(j,HSSFCell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(i+1);                                 //设置序号
                    }else{*/
                        cell = row.createCell(j,HSSFCell.CELL_TYPE_STRING);
                        if(!"".equals(obj[j]) && obj[j] != null){
                            cell.setCellValue(obj[j].toString());                        //设置单元格的值
                        }else{
                            cell.setCellValue("");
                        }
                    cell.setCellStyle(cellStyle);
                    //}
                    //cell.setCellStyle(style);                                    //设置单元格样式
                }
            }
            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            /*int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }*/
                        }
                    }
                }
                if(colNum == 0){
                    sheet.setColumnWidth(colNum, (columnWidth+2) * 256+3000);
                }else{
                    sheet.setColumnWidth(colNum, (columnWidth+25) * 256+5000);
                }
            }

            if(workbook !=null){
                try
                {
                    String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
                    String headStr = "attachment; filename=\"" + fileName + "\"";
                    /*response = getResponse();*/
                    response.setContentType("application/x-msdownload;");
                    response.setHeader("Content-Disposition", headStr);
                    OutputStream out = response.getOutputStream();
                    workbook.write(out);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /* 
     * 列头单元格样式
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)13);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字 
        font.setFontName("Courier New");
        //设置样式; 
        HSSFCellStyle style = workbook.createCellStyle();
        //style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
        //style.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);
        /*//设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;  
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;   
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色; 
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框; 
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色; 
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框; 
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;  
        style.setTopBorderColor(HSSFColor.BLACK.index);*/
        //在样式用应用设置的字体;  
        style.setFont(font);
        //设置自动换行; 
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐; 
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }

    /*  
   * 列数据信息单元格样式
   */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        //font.setFontHeightInPoints((short)10);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字 
        font.setFontName("Courier New");
        //设置样式; 
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框; 
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;  
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;   
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色; 
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框; 
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色; 
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框; 
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;  
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;  
        style.setFont(font);
        //设置自动换行; 
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐; 
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        return style;

    }


}
