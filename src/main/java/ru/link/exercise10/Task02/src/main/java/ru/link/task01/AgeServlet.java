package ru.link.task01;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/check")
public class AgeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        try {
            boolean result = checkAge(Integer.parseInt(req.getParameter("age")));
            writer.write(result ? "Adult" : "Not an adult");
        } catch (NumberFormatException e) {
            writer.write("You should pass your age as argument");
        }

        writer.close();
    }

    private boolean checkAge(int age) {
        return age >= 18;
    }
}
