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

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("application/x-www-form-urlencoded");
			PrintWriter out = res.getWriter();
			
		}
	public void destroy() {
		bmmd = null;
	}
}
