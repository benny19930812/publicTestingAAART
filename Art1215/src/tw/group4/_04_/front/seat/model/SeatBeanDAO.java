package tw.group4._04_.front.seat.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.back.cmsAct.model.ShowBean2;
import tw.group4._04_.front.shopcart.model.Shoppingcart;


@Repository("SeatBeanDAO")
public class SeatBeanDAO {

	private SessionFactory sessionFacory;
	private Session session;

	@Autowired
	private Shoppingcart shoppingcart;
	@Autowired
	private SeatBean seatBean;

//	public SeatBeanDAO() {
//	
//	}	
	// DAO一叫出來就幫忙取完session了
	// 現在都在DAO層用SessionFactory幫忙做事
	// 不再傳遞session一層一層下去
	@Autowired
	public SeatBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}
	
	// BEAN查詢
	public SeatBean selectBean(int actno) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(SeatBean.class, actno);
	}
	public SeatBean2 selectBean2(int actno) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(SeatBean2.class, actno);
	}
	public SeatBean3 selectBean3(int actno) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(SeatBean3.class, actno);
	}

	// 新增
	public SeatBean insert(SeatBean SeatBean) {
		Session session = sessionFacory.getCurrentSession();

			session.save(SeatBean);
			return SeatBean;
	}
	public SeatBean2 insert2(SeatBean2 SeatBean) {
		Session session = sessionFacory.getCurrentSession();
		
		session.save(SeatBean);
		return SeatBean;
	}
	public SeatBean3 insert3(SeatBean3 SeatBean) {
		Session session = sessionFacory.getCurrentSession();
		
		session.save(SeatBean);
		return SeatBean;
	}
	
	public  boolean   insert4Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		String Seat4 = seats[3];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 ," 
				+Seat2+"=1 ," 
				+Seat3+"=1 ," 
				+Seat4+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	
	}

	public boolean insert3Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 ," 
				+Seat2+"=1 ," 
				+Seat3+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean insert2Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 ," 
				+Seat2+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean insert1Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"=1 " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}
	
	public  boolean   delete4Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		String Seat4 = seats[3];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' ," 
				+Seat2+"='' ," 
				+Seat3+"='' ," 
				+Seat4+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	
	}

	public boolean delete3Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' ," 
				+Seat2+"='' ," 
				+Seat3+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean delete2Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' ," 
				+Seat2+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}

	public boolean delete1Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SeatBean st set "
				+Seat1+"='' " 
				+ "where st.ACT_NO="+actno);
		query.executeUpdate();
			
	return true;
	}
	
	
//	// 新增
//	public SeatBean insertSeat (SeatBean SeatBean) {
//		Session session = sessionFacory.getCurrentSession();
//		Query query = session.createQuery("update SEAT set "+SEATA+"=1 where ACT_NO='1'");
//		query.executeUpdate();
//
//		return SeatBean;
//	}
	
	// 查詢  //先將查詢結果放入MAP
		public Map<String, Integer> select(int actno) {
			Session session = sessionFacory.getCurrentSession();
			SeatBean seatBean =session.get(SeatBean.class, actno);
			
			
			Map<String,Integer> SeatMap = new HashMap<>();
			SeatMap.put("actno",seatBean.getaCT_NO());
			SeatMap.put("A1",seatBean.getA1());
			SeatMap.put("A2",seatBean.getA2());
			SeatMap.put("A3",seatBean.getA3());
			SeatMap.put("A4",seatBean.getA4());
			SeatMap.put("A5",seatBean.getA5());
			SeatMap.put("A6",seatBean.getA6());
			SeatMap.put("A7",seatBean.getA7());
			SeatMap.put("A8",seatBean.getA8());
			SeatMap.put("A9",seatBean.getA9());
			SeatMap.put("A10",seatBean.getA10());
			SeatMap.put("B1",seatBean.getB1());
			SeatMap.put("B2",seatBean.getB2());
			SeatMap.put("B3",seatBean.getB3());
			SeatMap.put("B4",seatBean.getB4());
			SeatMap.put("B5",seatBean.getB5());
			SeatMap.put("B6",seatBean.getB6());
			SeatMap.put("B7",seatBean.getB7());
			SeatMap.put("B8",seatBean.getB8());
			SeatMap.put("B9",seatBean.getB9());
			SeatMap.put("B10",seatBean.getB10());
			SeatMap.put("C1",seatBean.getC1());
			SeatMap.put("C2",seatBean.getC2());
			SeatMap.put("C3",seatBean.getC3());
			SeatMap.put("C4",seatBean.getC4());
			SeatMap.put("C5",seatBean.getC5());
			SeatMap.put("C6",seatBean.getC6());
			SeatMap.put("C7",seatBean.getC7());
			SeatMap.put("C8",seatBean.getC8());
			SeatMap.put("C9",seatBean.getC9());
			SeatMap.put("C10",seatBean.getC10());
			SeatMap.put("D1",seatBean.getD1());
			SeatMap.put("D2",seatBean.getD2());
			SeatMap.put("D3",seatBean.getD3());
			SeatMap.put("D4",seatBean.getD4());
			SeatMap.put("D5",seatBean.getD5());
			SeatMap.put("D6",seatBean.getD6());
			SeatMap.put("D7",seatBean.getD7());
			SeatMap.put("D8",seatBean.getD8());
			SeatMap.put("D9",seatBean.getD9());
			SeatMap.put("D10",seatBean.getD10());
			SeatMap.put("E1",seatBean.getE1());
			SeatMap.put("E2",seatBean.getE2());
			SeatMap.put("E3",seatBean.getE3());
			SeatMap.put("E4",seatBean.getE4());
			SeatMap.put("E5",seatBean.getE5());
			SeatMap.put("E6",seatBean.getE6());
			SeatMap.put("E7",seatBean.getE7());
			SeatMap.put("E8",seatBean.getE8());
			SeatMap.put("E9",seatBean.getE9());
			SeatMap.put("E10",seatBean.getE10());

			return SeatMap;
		}
		
		// 查詢SEAT2  //先將查詢結果放入MAP
		public Map<String, Integer> select2(int actno) {
			Session session = sessionFacory.getCurrentSession();
			SeatBean2 seatBean =session.get(SeatBean2.class, actno);
			
			
			Map<String,Integer> SeatMap = new HashMap<>();
			SeatMap.put("actno",seatBean.getACT_NO());
			SeatMap.put("F1",seatBean.getF1());
			SeatMap.put("F2",seatBean.getF2());
			SeatMap.put("F3",seatBean.getF3());
			SeatMap.put("F4",seatBean.getF4());
			SeatMap.put("F5",seatBean.getF5());
			SeatMap.put("F6",seatBean.getF6());
			SeatMap.put("F7",seatBean.getF7());
			SeatMap.put("F8",seatBean.getF8());
			SeatMap.put("F9",seatBean.getF9());
			SeatMap.put("F10",seatBean.getF10());
			SeatMap.put("G1",seatBean.getG1());
			SeatMap.put("G2",seatBean.getG2());
			SeatMap.put("G3",seatBean.getG3());
			SeatMap.put("G4",seatBean.getG4());
			SeatMap.put("G5",seatBean.getG5());
			SeatMap.put("G6",seatBean.getG6());
			SeatMap.put("G7",seatBean.getG7());
			SeatMap.put("G8",seatBean.getG8());
			SeatMap.put("G9",seatBean.getG9());
			SeatMap.put("G10",seatBean.getG10());
			SeatMap.put("H1",seatBean.getH1());
			SeatMap.put("H2",seatBean.getH2());
			SeatMap.put("H3",seatBean.getH3());
			SeatMap.put("H4",seatBean.getH4());
			SeatMap.put("H5",seatBean.getH5());
			SeatMap.put("H6",seatBean.getH6());
			SeatMap.put("H7",seatBean.getH7());
			SeatMap.put("H8",seatBean.getH8());
			SeatMap.put("H9",seatBean.getH9());
			SeatMap.put("H10",seatBean.getH10());
			SeatMap.put("I1",seatBean.getI1());
			SeatMap.put("I2",seatBean.getI2());
			SeatMap.put("I3",seatBean.getI3());
			SeatMap.put("I4",seatBean.getI4());
			SeatMap.put("I5",seatBean.getI5());
			SeatMap.put("I6",seatBean.getI6());
			SeatMap.put("I7",seatBean.getI7());
			SeatMap.put("I8",seatBean.getI8());
			SeatMap.put("I9",seatBean.getI9());
			SeatMap.put("I10",seatBean.getI10());
			SeatMap.put("J1",seatBean.getJ1());
			SeatMap.put("J2",seatBean.getJ2());
			SeatMap.put("J3",seatBean.getJ3());
			SeatMap.put("J4",seatBean.getJ4());
			SeatMap.put("J5",seatBean.getJ5());
			SeatMap.put("J6",seatBean.getJ6());
			SeatMap.put("J7",seatBean.getJ7());
			SeatMap.put("J8",seatBean.getJ8());
			SeatMap.put("J9",seatBean.getJ9());
			SeatMap.put("J10",seatBean.getJ10());

			return SeatMap;
		}
		
		// 查詢  //先將查詢結果放入MAP
		public Map<String, Integer> select3(int actno) {
			Session session = sessionFacory.getCurrentSession();
			SeatBean3 seatBean =session.get(SeatBean3.class, actno);
			
			
			Map<String,Integer> SeatMap = new HashMap<>();
			SeatMap.put("actno",seatBean.getACT_NO());
			SeatMap.put("K1",seatBean.getK1());
			SeatMap.put("K2",seatBean.getK2());
			SeatMap.put("K3",seatBean.getK3());
			SeatMap.put("K4",seatBean.getK4());
			SeatMap.put("K5",seatBean.getK5());
			SeatMap.put("K6",seatBean.getK6());
			SeatMap.put("K7",seatBean.getK7());
			SeatMap.put("K8",seatBean.getK8());
			SeatMap.put("K9",seatBean.getK9());
			SeatMap.put("L1",seatBean.getL1());
			SeatMap.put("L2",seatBean.getL2());
			SeatMap.put("L3",seatBean.getL3());
			SeatMap.put("L4",seatBean.getL4());
			SeatMap.put("L5",seatBean.getL5());
			SeatMap.put("L6",seatBean.getL6());
			SeatMap.put("L7",seatBean.getL7());
			SeatMap.put("L8",seatBean.getL8());
			SeatMap.put("L9",seatBean.getL9());
			SeatMap.put("L10",seatBean.getL10());
			SeatMap.put("L11",seatBean.getL11());
			SeatMap.put("M1",seatBean.getM1());
			SeatMap.put("M2",seatBean.getM2());
			SeatMap.put("M3",seatBean.getM3());
			SeatMap.put("M4",seatBean.getM4());
			SeatMap.put("M5",seatBean.getM5());
			SeatMap.put("M6",seatBean.getM6());
			SeatMap.put("M7",seatBean.getM7());
			SeatMap.put("M8",seatBean.getM8());
			SeatMap.put("M9",seatBean.getM9());
			SeatMap.put("N1",seatBean.getN1());
			SeatMap.put("N2",seatBean.getN2());
			SeatMap.put("N3",seatBean.getN3());
			SeatMap.put("N4",seatBean.getN4());
			SeatMap.put("N5",seatBean.getN5());
			SeatMap.put("N6",seatBean.getN6());
			SeatMap.put("N7",seatBean.getN7());
			SeatMap.put("N8",seatBean.getN8());
			SeatMap.put("N9",seatBean.getN9());
			SeatMap.put("N10",seatBean.getN10());
			SeatMap.put("N11",seatBean.getN11());
			SeatMap.put("O1",seatBean.getO1());
			SeatMap.put("O2",seatBean.getO2());
			SeatMap.put("O3",seatBean.getO3());
			SeatMap.put("O4",seatBean.getO4());
			SeatMap.put("O5",seatBean.getO5());
			SeatMap.put("O6",seatBean.getO6());
			SeatMap.put("O7",seatBean.getO7());
			SeatMap.put("O8",seatBean.getO8());
			SeatMap.put("O9",seatBean.getO9());
			SeatMap.put("O10",seatBean.getO10());
			SeatMap.put("P1",seatBean.getP1());
			SeatMap.put("P2",seatBean.getP2());
			SeatMap.put("P3",seatBean.getP3());
			SeatMap.put("P4",seatBean.getP4());
			SeatMap.put("P5",seatBean.getP5());
			SeatMap.put("P6",seatBean.getP6());
			SeatMap.put("P7",seatBean.getP7());
			SeatMap.put("P8",seatBean.getP8());
			SeatMap.put("P9",seatBean.getP9());
			SeatMap.put("P10",seatBean.getP10());
			SeatMap.put("Q1",seatBean.getQ1());
			SeatMap.put("Q2",seatBean.getQ2());
			SeatMap.put("Q3",seatBean.getQ3());
			SeatMap.put("Q4",seatBean.getQ4());
			SeatMap.put("Q5",seatBean.getQ5());
			SeatMap.put("Q6",seatBean.getQ6());

			return SeatMap;
		}
		
		
		
	// 修改
	public SeatBean update(
			 Integer actno,
			 Integer seatnum,
			 Integer A1,
			 Integer A2,
			 Integer A3,
			 Integer A4,
			 Integer A5,
			 Integer A6,
			 Integer A7,
			 Integer A8,
			 Integer A9,
			 Integer A10,
			 Integer B1,
			 Integer B2,
			 Integer B3,
			 Integer B4,
			 Integer B5,
			 Integer B6,
			 Integer B7,
			 Integer B8,
			 Integer B9,
			 Integer B10,
			 Integer C1,
			 Integer C2,
			 Integer C3,
			 Integer C4,
			 Integer C5,
			 Integer C6,
			 Integer C7,
			 Integer C8,
			 Integer C9,
			 Integer C10,
			 Integer D1,
			 Integer D2,
			 Integer D3,
			 Integer D4,
			 Integer D5,
			 Integer D6,
			 Integer D7,
			 Integer D8,
			 Integer D9,
			 Integer D10,
			 Integer E1,
			 Integer E2,
			 Integer E3,
			 Integer E4,
			 Integer E5,
			 Integer E6,
			 Integer E7,
			 Integer E8,
			 Integer E9,
			 Integer E10) {

		Session session = sessionFacory.getCurrentSession();
		seatBean= session.get(SeatBean.class, actno);
		seatBean.setSEATNUM(seatnum);
		seatBean.setA1(A1);
		seatBean.setA2(A2);
		seatBean.setA3(A3);
		seatBean.setA4(A4);
		seatBean.setA5(A5);
		seatBean.setA6(A6);
		seatBean.setA7(A7);
		seatBean.setA8(A8);
		seatBean.setA9(A9);
		seatBean.setA10(A10);
		
		seatBean.setB1(B1);
		seatBean.setB2(B2);
		seatBean.setB3(B3);
		seatBean.setB4(B4);
		seatBean.setB5(B5);
		seatBean.setB6(B6);
		seatBean.setB7(B7);
		seatBean.setB8(B8);
		seatBean.setB9(B9);
		seatBean.setB10(B10);

		seatBean.setC1(C1);
		seatBean.setC2(C2);
		seatBean.setC3(C3);
		seatBean.setC4(C4);
		seatBean.setC5(C5);
		seatBean.setC6(C6);
		seatBean.setC7(C7);
		seatBean.setC8(C8);
		seatBean.setC9(C9);
		seatBean.setC10(C10);

		seatBean.setD1(D1);
		seatBean.setD2(D2);
		seatBean.setD3(D3);
		seatBean.setD4(D4);
		seatBean.setD5(D5);
		seatBean.setD6(D6);
		seatBean.setD7(D7);
		seatBean.setD8(D8);
		seatBean.setD9(D9);
		seatBean.setD10(D10);

		seatBean.setE1(E1);
		seatBean.setE2(E2);
		seatBean.setE3(E3);
		seatBean.setE4(E4);
		seatBean.setE5(E5);
		seatBean.setE6(E6);
		seatBean.setE7(E7);
		seatBean.setE8(E8);
		seatBean.setE9(E9);
		seatBean.setE10(E10);
		
		
		session.update(seatBean);

		return seatBean;
	}
	
	public SeatBean updateSeatnum(
			 Integer actno,Integer seatnum) {

		Session session = sessionFacory.getCurrentSession();
		seatBean= session.get(SeatBean.class, actno);
		seatBean.setSEATNUM(seatnum);
		session.update(seatBean);

		return seatBean;
	}

	// 刪除
	public boolean delete(int actno) {

		Session session = sessionFacory.getCurrentSession();
		SeatBean result = session.get(SeatBean.class, actno);

		if (result != null) {
			session.delete(result);
			return true;
		}

		return false;
	}
	//查詢單座位
	public Integer search1seat(String seat, int actno) {

		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("select st."+seat+" from SeatBean as st where st.ACT_NO="+actno);
		Integer result=(Integer) query.getSingleResult();
		System.out.println("result"+result);
		return result;
	}

	
}
