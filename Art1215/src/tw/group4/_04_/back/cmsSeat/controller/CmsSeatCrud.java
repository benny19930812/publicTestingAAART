package tw.group4._04_.back.cmsSeat.controller;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import oracle.net.aso.m;
import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanDAO;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4.util.Hibernate;

@Controller
public class CmsSeatCrud {
	
	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Shoppingcart shoppingcart;
	
	//查詢座位
	@Hibernate
	@RequestMapping(path = "/04/CMS/seatSearch.ctrl", method = RequestMethod.GET)
	public String CMSseatSearch(int actno,Integer category,Model model ,HttpSession session) {	
		
		Map<String, Integer>seatMap=seatBeanService.select(actno);
		System.out.println(seatMap);
		model.addAttribute("seat", seatMap);
		model.addAttribute("category", category);
		return "04/cms_Seat/Seat";
	}
	//查詢座位圖2
	@Hibernate
	@RequestMapping(path = "/04/CMS/seat2Search.ctrl", method = RequestMethod.GET)
	public String CMSseat2Search(int actno,Integer category,Model model ,HttpSession session) {	
		
		Map<String, Integer>seatMap=seatBeanService.select2(actno);
		System.out.println(seatMap);
		model.addAttribute("seat", seatMap);
		model.addAttribute("category", category);
		return "04/cms_Seat/Seat2";
	}
	//查詢座位圖3
	@Hibernate
	@RequestMapping(path = "/04/CMS/seat3Search.ctrl", method = RequestMethod.GET)
	public String CMSseat3Search(int actno,Integer category,Model model ,HttpSession session) {	
		
		Map<String, Integer>seatMap=seatBeanService.select3(actno);
		System.out.println(seatMap);
		model.addAttribute("seat", seatMap);
		model.addAttribute("category", category);
		return "04/cms_Seat/Seat3";
	}
	//存入座位
	@Hibernate
	@RequestMapping(path = "/04/Cms/seatUpdate.ctrl", method = RequestMethod.POST)
	public String seatInsert(			
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
			 Integer E10,
			 Integer category,
			 Model model ,HttpSession session,HttpServletRequest request) {
		System.out.println("actno"+actno);
		System.out.println(seatnum);
		
		seatBeanService.update(
				actno,seatnum,
				A1,	A2,	A3,	A4,	A5,	A6,	A7,	A8,	A9,	A10,
				B1,	B2,	B3,	B4,	B5,	B6,	B7,	B8,	B9,	B10,
				C1,	C2,	C3,	C4,	C5,	C6,	C7,	C8,	C9,	C10,
				D1,	D2,	D3,	D4,	D5,	D6,	D7,	D8,	D9,	D10,
				E1,	E2,	E3,	E4,	E5,	E6,	E7,	E8,	E9,	E10
				);

		return "redirect:/04/CMS/Category.ctrl?category=" + category;
	}
	
	//存入座位
	@Hibernate
	@RequestMapping(path = "/04/Cms/seat2Update.ctrl", method = RequestMethod.POST)
	public String seat2Insert(			
			 Integer actno,
			 Integer seatnum,
			 Integer F1,
			 Integer F2,
			 Integer F3,
			 Integer F4,
			 Integer F5,
			 Integer F6,
			 Integer F7,
			 Integer F8,
			 Integer F9,
			 Integer F10,
			 Integer G1,
			 Integer G2,
			 Integer G3,
			 Integer G4,
			 Integer G5,
			 Integer G6,
			 Integer G7,
			 Integer G8,
			 Integer G9,
			 Integer G10,
			 Integer H1,
			 Integer H2,
			 Integer H3,
			 Integer H4,
			 Integer H5,
			 Integer H6,
			 Integer H7,
			 Integer H8,
			 Integer H9,
			 Integer H10,
			 Integer I1,
			 Integer I2,
			 Integer I3,
			 Integer I4,
			 Integer I5,
			 Integer I6,
			 Integer I7,
			 Integer I8,
			 Integer I9,
			 Integer I10,
			 Integer J1,
			 Integer J2,
			 Integer J3,
			 Integer J4,
			 Integer J5,
			 Integer J6,
			 Integer J7,
			 Integer J8,
			 Integer J9,
			 Integer J10,
			 Integer category,
			 Model model ,HttpSession session,HttpServletRequest request) {
		System.out.println("actno"+actno);
		System.out.println(seatnum);
		
		seatBeanService.update2(
				actno,seatnum,
				F1,	F2,	F3,	F4,	F5,	F6,	F7,	F8,	F9,	F10,
				G1,	G2,	G3,	G4,	G5,	G6,	G7,	G8,	G9,	G10,
				H1,	H2,	H3,	H4,	H5,	H6,	H7,	H8,	H9,	H10,
				I1,	I2,	I3,	I4,	I5,	I6,	I7,	I8,	I9,	I10,
				J1,	J2,	J3,	J4,	J5,	J6,	J7,	J8,	J9,	J10
				);

		return "redirect:/04/CMS/Category.ctrl?category=" + category;
	}
}
