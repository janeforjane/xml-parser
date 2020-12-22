package dom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckDOM", urlPatterns = "/CheckDOM")
public class CheckDOM extends HttpServlet {


    private DemoDOM dom = new DemoDOM();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("windows-1251");
        String fieldName = req.getParameter("fieldName");
        try {
            String result = dom.find(fieldName);
            PrintWriter writer = resp.getWriter();
            if (result == null) {
                writer.write("Not found");
            } else {
                writer.write("Found: " + result);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
