package view;
import java.util.*;
import Biz.BaseBizImpl;
import OperateTarget.*;
public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseBizImpl temp = new BaseBizImpl();
		List<Base> lt = temp.findByCondition("��ɽ·4��");
		System.out.println(lt.toString());
	}

}
