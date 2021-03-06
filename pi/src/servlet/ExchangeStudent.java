package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.NameValuePair;

import service.PostHttp;

/**
 * Servlet implementation class ExchangeStudent
 */
public class ExchangeStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExchangeStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		String studentUsername=request.getParameter("studentUsername");
		String studentDomitoryid=request.getParameter("studentDomitoryid");
		String studentPassword=request.getParameter("studentPassword");
		String studentName=request.getParameter("studentName");
		String studentSex=request.getParameter("studentSex");
		String studentClass=request.getParameter("studentClass");
		String studentState=request.getParameter("studentState");
		System.out.println(studentPassword);
		NameValuePair[] data = { 
			    new NameValuePair("studentDomitoryid", studentDomitoryid),
			    new NameValuePair("studentPassword", studentPassword),
			    new NameValuePair("studentName", studentName),
			    new NameValuePair("studentSex", studentSex),
			    new NameValuePair("studentClass", studentClass),
			    new NameValuePair("studentState", studentState),
			  };
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i].toString());
		}
		url="http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/update/"+studentUsername;
		String ok=PostHttp.goPost(url, data);
		System.out.println(ok);
		response.sendRedirect("ReadStudentAll");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
