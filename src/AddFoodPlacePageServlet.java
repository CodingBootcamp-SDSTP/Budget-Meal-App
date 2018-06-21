import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import redis.clients.jedis.Jedis;

public class AddFoodPlacePageServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;
	StringBuffer sb;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			RequestDispatcher view = req.getRequestDispatcher("/postyourfoodplace.html");
			view.forward(req, res);
		}
	public void destroy() {
		bmmd = null;
	}
}
