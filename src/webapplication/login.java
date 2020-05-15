package webapplication;

import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("loginname");
        String userPassword = request.getParameter("password");

        request.setAttribute("username", userName);
        request.setAttribute("password", userPassword);

        if (User.isValidUserCredentials(userName, userPassword)) {
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid login and password, try again");
            request.getRequestDispatcher("/login.jsp").forward(request,  response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print("Login name " + request.getParameter("loginname")
                + " Password " + request.getParameter("password"));
    }
}
