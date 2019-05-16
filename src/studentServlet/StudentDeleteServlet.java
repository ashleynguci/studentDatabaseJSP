package studentServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_database.Student;
import student_database.StudentDAO;

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDAO studentDAO = null;
		
		try {
			studentDAO = new StudentDAO();
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		int givenId = -1;

		String studentId = request.getParameter("txtId");

		if (studentId != null) {
			try {
				givenId = Integer.parseInt(studentId);
			} catch (Exception ex) {
			}
		}

		Student deleteStudent = null;
		try {
			deleteStudent = studentDAO.deleteStudent(givenId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;

		request.setAttribute("txtId", deleteStudent);

		request.getRequestDispatcher("StudentList.jsp").forward(request, response);

	}
}
