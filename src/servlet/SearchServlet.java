package servlet;
import com.google.gson.Gson;
import connection.ConnectionDB;
import logic.MngPerson;
import logic.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = resp.getWriter()){
            String document = req.getParameter("document");
            MngPerson mngPerson = new MngPerson();

            Person person = new Person();
            if(!mngPerson.readPerson()){
                person = null;
            }
            else {
                ArrayList<Person> persons = mngPerson.getPersons();
                for (int i = 0; i < persons.size(); i++) {
                    if (persons.get(i).getDocument().replace(" ", "").equals(document)) {
                        person = persons.get(i);
                    }
                }
            }
            Gson gg = new Gson();
            writer.write(gg.toJson(person));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
