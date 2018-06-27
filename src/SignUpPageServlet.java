import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URI;
import redis.clients.jedis.Jedis;

public class SignUpPageServlet extends HttpServlet
{
	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			RequestDispatcher view = req.getRequestDispatcher("/createaccount.html");
			view.forward(req, res);
	}
	
	public void destroy() {
	}
}
