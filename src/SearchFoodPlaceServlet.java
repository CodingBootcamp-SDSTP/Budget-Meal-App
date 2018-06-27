import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import java.util.ArrayList;
import java.math.BigDecimal;

public class SearchFoodPlaceServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;
	ReviewCollection rc;
	StringBuffer sb;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		sb = new StringBuffer("<FoodPlaces>");
		String[] query = req.getQueryString().split("&");
		String[] amount = query[0].split("=");
		String[] ff = query[1].split("=");
		String[] loc = query[2].split("=");
		String[] id = query[3].split("=");
		ArrayList<Object> ao = bmmd.search(new BigDecimal(amount[1]), ff[1], loc[1], "");
		for(int i=0; i<ao.size(); i++) {
			Object obj = ao.get(i);
			if(obj instanceof FoodPlace) {
				FoodPlace fp = (FoodPlace)obj;
				sb.append("<foodplace><id>" + bmmd.getFoodPlaceId(fp.getName()) + "</id>");
				sb.append("<name>" + fp.getName() + "</name>");
				sb.append("<address>" + fp.getAddress() + "</address>");
				sb.append("<menu>" + fp.getCheapestMenu() + "</menu>");
				sb.append("<price>" + fp.getCheapestMenuPrice() + "</price></foodplace>");
			}
		}
		sb.append("</FoodPlaces>");
		out.print(sb.toString());
	}
	
	public void destroy() {
		bmmd = null;
		rc = null;
	}
}
