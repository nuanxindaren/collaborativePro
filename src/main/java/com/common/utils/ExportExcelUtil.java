package com.common.utils;


/*import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;*/

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author renyangze
 * @date 2018/3/29
 */
public class ExportExcelUtil {
    //显示的导出表的标题
    private String title;
    //导出表的列名
    private String[] rowName ;

    private List<Object[]> dataList = new ArrayList<Object[]>();


    //构造方法，传入要导出的数据
    public ExportExcelUtil(String title){
        this.title = title;
    }

    /*
     * 导出数据
     * */
    public void export(HttpServletResponse response) throws Exception{
        try{

            String srcFilePath = "d:/周报模板.xlsx";
            //创建Excel文件的输入流对象
            FileInputStream fis = new FileInputStream(srcFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);                        // 创建工作簿对象

            //获取创建的工作簿第一页
            XSSFSheet sheet1 = workbook.getSheetAt(0);

            //修改标题
            XSSFRow row = sheet1.getRow(0);
            XSSFCell thisCell = row.getCell(1);
            thisCell.setCellValue("本周报告");

            XSSFCell nextCell = row.getCell(2);
            nextCell.setCellValue("下周报告");

            //获取当前sheet最后一行数据对应的行索引
            int currentLastRowIndex = sheet1.getLastRowNum();
            int newRowIndex = currentLastRowIndex + 1;
            XSSFRow newRow = sheet1.createRow(newRowIndex);
//开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始
            int cellIndex = 0;

            //创建一个单元格，设置其内的数据格式为字符串，并填充内容，其余单元格类同
            XSSFCell newNameCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
            newNameCell.setCellValue("乔玉宝");
            XSSFCell newGenderCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
            newGenderCell.setCellValue("男");
            XSSFCell newAgeCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_NUMERIC);
            newAgeCell.setCellValue(25);
            XSSFCell newAddressCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_NUMERIC);
            newAddressCell.setCellValue("重庆市渝北区");


            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
            //HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);//获取列头样式对象
            /*HSSFCellStyle style = this.getStyle(workbook);                    //单元格样式对象
            columnTopStyle.setFillBackgroundColor(HSSFColor.ROYAL_BLUE.index);*/
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
            //关闭流
            fis.close();
            System.out.println("导出成功");

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
