import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

public class AddReviewServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("application/x-www-form-urlencoded");
			PrintWriter out = res.getWriter();
			String text = req.getParameter("text");
			String rating = req.getParameter("rating");
			String rid = req.getParameter("reviewer");
			String fpid = req.getParameter("foodplace");
			Review r = new Review(text, Integer.parseInt(rating), Integer.parseInt(rid), Integer.parseInt(fpid));
			bmmd.addReview(r);
		}
	public void destroy() {
		bmmd = null;
	}
}
