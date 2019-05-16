package studentServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import student_database.Student;
import student_database.StudentDAO;

/**
 * Servlet implementation class StudentListServlet
 */

@WebServlet("/studentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			List<Student> studentList = null;

			// 2. Create the data to be sent to the JSP page
			StudentDAO studentDAO = new StudentDAO();

			studentList = studentDAO.getAllStudents();

			// 3. Add the data to the request attributes
			request.setAttribute("studentList", studentList);

			// 4. Forward the request back to the JSP page
			request.getRequestDispatcher("StudentList.jsp").forward(request, response);

		} catch (Exception ex) {
			System.out.println("Error \n");
		}

	}

}