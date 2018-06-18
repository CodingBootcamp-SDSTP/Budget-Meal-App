import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;

public class AllPersonsServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;
	PersonCollection pc;
	StringBuffer sb;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		pc = bmmd.getPersonCollection();
		sb = new StringBuffer("<Persons>");
			for(int i=0; i<pc.getPersonCount(); i++) {
				Person p = pc.getPersonByIndex(i);
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
		sb.append("</Persons>");
		out.print(sb.toString());
	}

	public void destroy() {
		bmmd = null;
		pc = null;
	}
}
