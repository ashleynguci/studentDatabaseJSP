package studentServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_database.Student;
import student_database.StudentDAO;

@WebServlet("/studentInsertServlet")

public class studentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO studentDAO = null;
		try {
			studentDAO = new StudentDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int studentId = -1;
		
		int postcode = -1;
		String idText = request.getParameter("txtId");
		String firstNameText = request.getParameter("txtFirstName");
		String lastNameText = request.getParameter("txtLastName");
		String streetaddressText = request.getParameter("txtStreet");
		
		String postcodeText = request.getParameter("txtPostcode");
		String postofficeText = request.getParameter("txtPostoffice");
		
		if (idText != null) {
			try {
				studentId = Integer.parseInt(idText);
			} catch (Exception ex) { }
		}
		
		if (postcodeText != null) {
			try {
				postcode = Integer.parseInt(postcodeText);
			} catch (Exception ex) { }
		}
		
		Student inputStudent = new Student(studentId, firstNameText, lastNameText, streetaddressText, postcode, postofficeText);
		
		int returnInt = studentDAO.insertStudent(inputStudent);
		
		String confirmMessage = "Test";
		if(returnInt == 0) {
			confirmMessage = ("Student saved successfully!");
		} else if(returnInt == 1) {
			confirmMessage = ("Id "+ studentId + " is already existed.");
		} else if(returnInt == -1) {
			confirmMessage = ("===== Error =====");
		}
		
		request.setAttribute("confirmMessage", confirmMessage);

		request.getRequestDispatcher("StudentInsert.jsp").forward(request, response);
	}
	

}
