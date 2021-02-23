/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *�����ڲ����壬����֤Ψһ��
 * @author dell
 */
public class FrameUtil {
    //����һ�������ڲ�����ļ���
    public static HashMap<String,JInternalFrame> framemap = new HashMap<String,JInternalFrame>();
    //�����ڲ������˼·��������˵��������ڼ����в����Ƿ��Ѿ����ڶ����жϼ�ֵ�Ƿ���ڣ���
    //����Ѿ����ھʹӼ����л�ȡ������������������µĶ���
    //�����뼯��(��ֵΪ������)
    public static JInternalFrame buildFrame(Class clazz){
         JInternalFrame frame = null;
        if(framemap.containsKey(clazz.getName())){
            frame = framemap.get(clazz.getName());
        }else{
             try {
                 //�����в����ڼ���˵��֮ǰû�д�����
                 frame = (JInternalFrame)clazz.newInstance();
                 //���뼯��
                 framemap.put(clazz.getName(), frame);
             } catch (Exception ex) {
                ex.printStackTrace();
             }
        }
        return frame;
    }
}
