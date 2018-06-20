import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import java.util.ArrayList;
import java.math.BigDecimal;

public class AddFoodPlaceServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("application/x-www-form-urlencoded");
			PrintWriter out = res.getWriter();
			String name = req.getParameter("fpname");
			String address = req.getParameter("fpaddress");
			String menu = req.getParameter("fpmenu");
			String price = req.getParameter("fpprice");
			String photo = req.getParameter("fpphoto");
			FoodPlace fp = new FoodPlace(name, address, menu, new BigDecimal(price), photo);
			bmmd.addFoodPlace(fp);
		}
	public void destroy() {
		bmmd = null;
	}
}
