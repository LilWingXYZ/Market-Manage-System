/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author cong's pc
 */
public class ExcelWriteUtil {
        //��ӡ��Ʒ������Ϣ,������⣨���飩 int �������鳤�ȣ��±�+1��
    public static void printSale(List psalelist,File file,String[] title,int limit){
        WritableWorkbook book = null;

        try {
                //2==============����excel�ļ�������������ʾ��ʽ          
            book = Workbook.createWorkbook(file); //�����������͵ı���ʹ֮��Excel����Ӧ�Ա��ڲ���
        } catch (IOException ex) {
            Logger.getLogger(ExcelWriteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableSheet sheet1 = book.createSheet("��һҳ", 0); //�ڱ���д�����һҳ������ָ��ҳ�����ƺ�������������0��ʼ
        try{
            sheet1.setRowView(0, 400); //���ñ����еĸ߶�
            for(int i = 0;i < limit;++ i){
                sheet1.setColumnView(i, 20);//�������б����п�20
            } 
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
        //�������壬7�������ֱ����������ƣ��ֺţ��Ƿ���壬�Ƿ�б�壬�»��ߣ���ɫ�����±�
        WritableFont font = new WritableFont(WritableFont.TIMES, 13, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.DARK_RED, ScriptStyle.NORMAL_SCRIPT); 
        WritableFont font1 = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT);     
        WritableCellFormat format = new WritableCellFormat(font); //��������뵥Ԫ��ʽ��
        WritableCellFormat format1 = new WritableCellFormat(font1);
        try {
            format1.setAlignment(Alignment.CENTRE); //���뷽ʽ����
            format.setAlignment(Alignment.CENTRE); //���뷽ʽ���趨
        } catch (WriteException ex) {
            Logger.getLogger(ExcelWriteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
            //3 ============���õ�һ��Ϊ����,���������
        for(int i = 0;i < limit;++ i ){
            try {
                sheet1.addCell(new Label(i, 0, title[i], format));
            } catch (WriteException ex) {
                Logger.getLogger(ExcelWriteUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            //4 =====================ȡ��List�����еĵ����ݣ��ŵ�Excel��
        int row = psalelist.size();//��ȡ���ϵĳ�����Ϊ��������
        for (int i = 0; i < row; i++) {
            String pro =  psalelist.get(i).toString();
            String[] unit = null;
            unit = pro.split(",");
            for(int j = 0;j < limit;++ j){
                try {
                    sheet1.addCell(new Label(j, i + 1 ,unit[j], format1));//�Ľ�
                } catch (WriteException ex) {
                    Logger.getLogger(ExcelWriteUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            //Public static String getInfo(int i){
//Switch(i){
//case 1: 
//return this.getPname();
//Case 2:
//return this.getFirstmonth().toString;
//}
//    }
//            //5 ===================�������ݣ�����
            book.write();//����
            book.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelWriteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ExcelWriteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
}
