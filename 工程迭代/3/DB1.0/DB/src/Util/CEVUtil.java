/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import java.io.BufferedInputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
import org.apache.poi.POIXMLDocument;


import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 *
 * @author cong's pc
 */
public class CEVUtil {
    public static boolean isExcel2003(String filePath){
        try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
                if(POIFSFileSystem.hasPOIFSHeader(bis)) {
                    System.out.println("Excel�汾Ϊexcel2003������");
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
     /**
      * ���������ж��Ƿ�Ϊexcel2007������
      */
    public static boolean isExcel2007(String filePath){
        try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
                if(POIXMLDocument.hasOOXMLHeader(bis)) {
                    System.out.println("Excel�汾Ϊexcel2007������");
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
                return false;
    }
    public static boolean isExcel(String filePath){
        if(filePath.matches("^.+\\.(?i)(xls)$")||filePath.matches("^.+\\.(?i)(xlsx)$")){
            return true;
        }
        return false;
    } 
     
     /** 
      * ����ļ��Ƿ���� 
      */  
    public static boolean fileExist(String filePath){
        if(filePath == null || filePath.trim().equals("")) 
            return false;
        File file = new File(filePath);  
        if (file == null || !file.exists()){  
             return false;  
        } 
        return true;
    }
}  
