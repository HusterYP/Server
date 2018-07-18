import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(
        name = "firstDemo",
        urlPatterns = {"/greeting", "/hh"},
        loadOnStartup = 1
)
public class Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params =req.getParameter(Constant.state);
        if(params.equals(Constant.get)){
            resp.getWriter().println("You Will get your bike");
        }
        if(params.equals(Constant.put)){
            resp.getWriter().println("You have put your bike");
        }
        //操作数据库
        /*Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/huster?useUnicode=true&characterEncoding=utf-8";
            String sql = "select * from user";
            connection = DriverManager.getConnection(url, "root", "123456");
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            String result = "";
            while (resultSet.next()) {
                result += resultSet.getString("id") + resultSet.getString("name") + "\n";
            }
            System.out.println(result);
            resp.getWriter().write(new String(("Hello I am YP!!").getBytes("utf-8"), "iso8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }*/

    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Servlet destroy");
    }
}
