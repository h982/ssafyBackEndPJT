package com.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dto.Code;
import com.ssafy.dto.HouseDealDto;
import com.ssafy.dto.MemberDto;
import com.ssafy.service.CodeServiceImpl;
import com.ssafy.service.HouseDealServiceImpl;
import com.ssafy.service.MemberServiceImpl;


@WebServlet("/main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = (String) request.getParameter("act");
		
		if("mvregister".equals(act)) {
			request.getRequestDispatcher("/user/join.jsp").forward(request, response);
		}else if("register".equals(act)) {
			register(request, response);
		}else if("login".equals(act)) {
			login(request, response);
		}else if("logout".equals(act)) {
			logout(request, response);
		}else if("search".equals(act)) {
			search(request, response);
		}else if("checklogin".equals(act)) {
			request.getRequestDispatcher("/user/checklogin.jsp").forward(request, response);
		}else if("mvmodifyuserinfo".equals(act)) {
			request.getRequestDispatcher("/user/modify.jsp").forward(request, response);
		}else if("modifyuserinfo".equals(act)) {
			modify(request, response);
		}else if("loadpage".equals(act)) {
			loadPage(request, response);
		}else if("citychange".equals(act)) {
			cityChange(request, response);
		}else if("gugunchange".equals(act)) {
			gugunChange(request, response);
		}
	}

	private void gugunChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cityCode = request.getParameter("gu").substring(0, 5);
		List<Code> dongList = (List<Code>) session.getAttribute("dong");
		List<Code> selectedDong = new ArrayList<>();
		for(Code dong: dongList) {
			if(cityCode.equals(dong.getDongCode().substring(0, 5))) {
				selectedDong.add(dong);
			}
		}
		session.setAttribute("selectedgu", request.getParameter("gu"));
		session.setAttribute("donglist", selectedDong);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void cityChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String cityCode = request.getParameter("city").substring(0, 2);
		List<Code> guList = (List<Code>) session.getAttribute("gugun");
		List<Code> selectedGu = new ArrayList<>();
		for(Code gu: guList) {
			if(cityCode.equals(gu.getDongCode().substring(0, 2))) {
				selectedGu.add(gu);
			}
		}
		session.setAttribute("selectedcity", request.getParameter("city"));
		session.setAttribute("gulist", selectedGu);
		session.removeAttribute("donglist");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dong = request.getParameter("dong");
		String path = "/lookup.jsp";
		String msg = "";
		List<HouseDealDto> list = new ArrayList<>();
		try {
			list = HouseDealServiceImpl.getInstance().searchAll(dong);
			request.setAttribute("houseDeal", list);
			for(HouseDealDto h : list)
				System.out.println(h);
			
		}catch(Exception e) {
			e.printStackTrace();
			msg = "도시정보 로딩 실패";
			request.setAttribute("msg", msg);
			path = "/error/error500.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void loadPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String path = "/index.jsp";
		String msg = "";
		try {
			session.setAttribute("sido", CodeServiceImpl.getInstance().getCityList());
			session.setAttribute("gugun", CodeServiceImpl.getInstance().getGuList());
			session.setAttribute("dong", CodeServiceImpl.getInstance().getDongList());
		}catch(Exception e) {
			e.printStackTrace();
			msg = "도시정보 로딩 실패";
			request.setAttribute("msg", msg);
			path = "/error/error500.jsp";
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	private void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(userId);
		memberDto.setUserPwd(userPwd);
		memberDto.setUserName(userName);
		memberDto.setEmail(email);
		memberDto.setAddress(address);

		
		String path = "/index.jsp";
		String msg = "";
		try {
			MemberServiceImpl.getInstance().modifyMember(memberDto);
			msg = "회원정보 수정 성공!";
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "회원정보 수정 실패!";
			request.setAttribute("msg", msg);
			path = "/error/error500.jsp";
		}
		
		// 프로젝트 안에서
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();	//다 날려버림
		
		response.sendRedirect(request.getContextPath());	// root로 보내버림 -> index.jsp로
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		
		MemberDto memberDto = null;
		try {
			memberDto = MemberServiceImpl.getInstance().login(userId, userPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path = "/index.jsp";
// 		return 페이지 제작
		if(memberDto != null) { // 성공
//			session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
			
//			Cookie 설정
			String idsv = request.getParameter("idsave");
			if("saveok".equals(idsv)) {
				Cookie cookie = new Cookie("save_id", userId);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 365);	// 유지시간 (분 단위)
				
				response.addCookie(cookie);
			} else {	// 아이디 저장 지우기
				Cookie[] cookies = request.getCookies(); //쿠키 여러개 가능
				if(cookies != null){
					for(Cookie cookie : cookies){
						if(cookie.getName().equals("save_id")){
							cookie.setMaxAge(0);	// 지우기
							response.addCookie(cookie);
							break;
						}
					}
				}
			}
			
//			request.setAttribute("userinfo", memberDto);
//			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else {	// 실패
			request.setAttribute("msg", "로그인 실패!!");
			path = "/error/error500.jsp";
//			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
		}
		
		// 프로젝트 안에서
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
		
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(userId);
		memberDto.setUserPwd(userPwd);
		memberDto.setUserName(userName);
		memberDto.setEmail(email);
		memberDto.setAddress(address);

		System.out.println(memberDto);
		
		String path = "/index.jsp";
		String msg = "";
		try {
			MemberServiceImpl.getInstance().registerMember(memberDto);
			msg = "회원가입 성공!";
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
			msg = "회원가입 실패!";
			request.setAttribute("msg", msg);
			path = "/error/error500.jsp";
			System.out.println("NoOk");
		}
		
		// 프로젝트 안에서
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
