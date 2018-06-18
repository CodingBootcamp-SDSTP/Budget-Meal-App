import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;

public class AllFoodPlacesServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;
	FoodPlacesCollection fpc;
	StringBuffer sb;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		fpc = bmmd.getFoodPlacesCollection();
		sb = new StringBuffer("<FoodPlaces>");
			for(int i=0; i<fpc.getFoodPlacesCount(); i++) {
				FoodPlace fp = fpc.getFoodPlaceByIndex(i);
				sb.append("<foodplace><name>" + fp.getName() + "</name>");
				sb.append("<address>" + fp.getAddress() + "</address>");
				sb.append("<menu>" + fp.getCheapestMenu() + "</menu>");
				sb.append("<price>" + fp.getCheapestMenuPrice() + "</price></foodplace>");
			}
		sb.append("</FoodPlaces>");
		out.print(sb.toString());
	}

	public void destroy() {
		bmmd = null;
		fpc = null;
	}
}
