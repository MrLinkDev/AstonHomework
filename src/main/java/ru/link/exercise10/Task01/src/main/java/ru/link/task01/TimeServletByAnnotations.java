package ru.link.task01;

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
import java.util.HashMap;

@WebServlet(urlPatterns = {"/by_annotations/*"})
public class TimeServletByAnnotations extends HttpServlet {

    private HashMap<String, String> pathMap;

    public void init() {
        pathMap = new HashMap<>();

        pathMap.put("/", "UTC");
        pathMap.put("/minsk", "GMT+3");
        pathMap.put("/washington", "GMT-7");
        pathMap.put("/beijing", "GMT+8");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String path = req.getPathInfo();

        PrintWriter writer = resp.getWriter();
        writer.println("By annotations: " + getDateTimeForZone(pathMap.get(path)));
        writer.close();
    }

    private String getDateTimeForZone(String timeZone) {
        return ZonedDateTime.now(ZoneId.of(timeZone)).format(DateTimeFormatter.ofPattern("k:m:s d/L/y"));
    }
}
