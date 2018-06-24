import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import redis.clients.jedis.Jedis;

public class LoginServlet extends HttpServlet
{
	BudgetMealManagerDatabase bmmd;

	public void init() throws ServletException {
		bmmd = BudgetMealManagerDatabase.instance();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			HttpSession session = req.getSession();
			Jedis jedis = new Jedis("localhost");
			PrintWriter out = res.getWriter();
			String[] query = req.getQueryString().split("&");
			String[] un = query[0].split("=");
			String[] pw = query[1].split("=");
			if(bmmd.checkCredentialsInSQL(un[1], pw[1])) {
				jedis.set("sessionid", session.getId());
				out.write("[{\"sessionid\" : \"" + jedis.get("sessionid") + "\"," +
				"\"userid\" : \"" + bmmd.getUserId(un[1]) + "\"," +
				"\"usertype\": \"" + bmmd.getUserType(un[1]) + "\"}]");
			}
			else {
				out.write("login/password does not match!");
			}
		}
	public void destroy() {
		bmmd = null;
	}
}
