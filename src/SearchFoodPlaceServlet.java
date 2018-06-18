import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import java.util.ArrayList;

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
		sb = new StringBuffer("<Collection>");
		String[] query = req.getQueryString().split("=");
		String q = query[1].toLowerCase();
			ArrayList<Object> ao = bmmd.search(q);
			for(int i=0; i<ao.size(); i++) {
				Object obj = ao.get(i);
				if(obj instanceof Person) {
					Person p = (Person)obj;
					sb.append("<person><firstname>" + p.getFirstName() + "</firstname>");
					sb.append("<lastname>" + p.getLastName() + "</lastname>");
					sb.append("<age>" + p.getAge() + "</age>");
					sb.append("<username>" + p.getUsername() + "</username>");
					sb.append("<password>" + p.getPassword().replaceAll("(?s).", "*") + "</password>");
					sb.append("<email>" + p.getEmail() + "</email>");
					sb.append("<location>" + p.getLocation() + "</location>");
					if(p instanceof Foodie) {
						sb.append("<usertype>foodie</usertype></person>");
					}
					else if(p instanceof Manager) {
						sb.append("<usertype>manager</usertype></person>");
					}
				}
				else if(obj instanceof FoodPlace) {
					FoodPlace fp = (FoodPlace)obj;
					sb.append("<foodplace><name>" + fp.getName() + "</name>");
					sb.append("<address>" + fp.getAddress() + "</address>");
					sb.append("<menu>" + fp.getCheapestMenu() + "</menu>");
					sb.append("<price>" + fp.getCheapestMenuPrice() + "</price></foodplace>");
				}
				else if(obj instanceof Review) {
					Review r = (Review)obj;
					sb.append("<review><text>" + r.getReviewText() + "</text>");
					sb.append("<rating>" + r.getRating() + "</rating>");
					sb.append("<reviewerid>" + r.getReviewerId() + "</reviewerid>");
					sb.append("<foodplaceid>" + r.getFoodPlaceId() + "</foodplaceid>");
					sb.append("<reviewdate>" + r.getReviewDate() + "</reviewdate></review>");
				}
			}
			sb.append("</Collection>");
			out.print(sb.toString());
		}

	public void destroy() {
		bmmd = null;
		rc = null;
	}
}
