import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;

public class AllReviewsServlet extends HttpServlet
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
		rc = bmmd.getReviewCollection();
		sb = new StringBuffer("<Reviews>");
			for(int i=0; i<rc.getReviewCount(); i++) {
				Review r = rc.getReviewByIndex(i);
				sb.append("<review><text>" + r.getReviewText() + "</text>");
				sb.append("<rating>" + r.getRating() + "</rating>");
				sb.append("<reviewerid>" + r.getReviewerId() + "</reviewerid>");
				sb.append("<foodplaceid>" + r.getFoodPlaceId() + "</foodplaceid>");
				sb.append("<reviewdate>" + r.getReviewDate() + "</reviewdate></review>");
			}
		sb.append("</Reviews>");
		out.print(sb.toString());
	}

	public void destroy() {
		bmmd = null;
		rc = null;
	}
}
