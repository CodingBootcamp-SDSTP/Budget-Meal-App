import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import java.util.ArrayList;
import java.math.BigDecimal;

public class AddPersonServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("application/x-www-form-urlencoded");
			PrintWriter out = res.getWriter();
			String fname = req.getParameter("firstname");
			String lname = req.getParameter("lastname");
			String age = req.getParameter("age");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String location = req.getParameter("location");
			String food = req.getParameter("food");
			String place = req.getParameter("place");
			String persontype = req.getParameter("usertype");
			System.out.println(fname + lname + age);
			// if("foodie".equals(persontype)) {
			// 	Foodie f = new Foodie(fname, lname, Integer.parseInt(age), username, password, email, location, food);
			// 	bmmd.addPerson(f);
			// }
			// else if("manager".equals(persontype)) {
			// 	Manager m = new Manager(fname, lname, Integer.parseInt(age), username, password, email, location, place);
			// 	bmmd.addPerson(m);
			// }
		}
	public void destroy() {
		bmmd = null;
	}
}
