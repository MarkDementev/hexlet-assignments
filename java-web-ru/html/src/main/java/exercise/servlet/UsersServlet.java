package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        String filePathString = "./src/main/resources/users.json";
        ObjectMapper mapper = new ObjectMapper();

        Path fileAbsolutePath = Paths.get(filePathString).toAbsolutePath().normalize();
        String fileAbsolutePathString = Files.readString(fileAbsolutePath);

        return mapper.readValue(fileAbsolutePathString, List.class);
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        final int EMAIL_KEY_LENGTH = 6;
        final int ID_KEY_LENGTH = 3;
        final int LAST_NAME_KEY_LENGTH = 9;
        final int FIRST_NAME_KEY_LENGTH = 10;

        final int ID_SUBSTRING_STEP = 8;
        final int LAST_NAME_SUBSTRING_STEP = 5;
        final int FIRST_NAME_SUBSTRING_STEP = 11;

        StringBuilder stringBuilder = new StringBuilder();
        PrintWriter out = response.getWriter();
        List usersList = getUsers();

        response.setContentType("text/html;charset=UTF-8");
        stringBuilder.append("""
            <!DOCTYPE html>
            <html lang=\"ru\">
                <head>
                    <meta charset=\"UTF-8\">
                    <title>Example application | showUsers</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                </head>
                <body>
                    <table>
                        <tr>
            """);

        for (Object user : usersList) {
            int emailIndex = user.toString().indexOf("email=") + EMAIL_KEY_LENGTH;
            int iDIndex = user.toString().indexOf("id=") + ID_KEY_LENGTH;
            int lastNameIndex = user.toString().indexOf("lastName=") + LAST_NAME_KEY_LENGTH;
            int firstNameIndex = user.toString().indexOf("firstName=") + FIRST_NAME_KEY_LENGTH;

            String userID = user.toString().substring(iDIndex, emailIndex - ID_SUBSTRING_STEP);
            String lastName = user.toString().substring(lastNameIndex, iDIndex - LAST_NAME_SUBSTRING_STEP);
            String firstName = user.toString().substring(firstNameIndex, lastNameIndex - FIRST_NAME_SUBSTRING_STEP);

            stringBuilder.append("              <td>").append(userID).append("</td>")
                    .append("\n");
            stringBuilder.append("              <td>")
                    .append("\n")
                    .append("                   <a").append(" href=\"/users/").append(userID).append("\">")
                    .append(firstName).append(" ").append(lastName).append("</a>")
                    .append("\n");
            stringBuilder.append("              </td>")
                    .append("\n");
        }
        stringBuilder.append("""
                        </tr>
                    </table>
                </body>
            </html>
            """);
        out.println(stringBuilder);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        final int EMAIL_KEY_LENGTH = 6;
        final int ID_KEY_LENGTH = 3;
        final int LAST_NAME_KEY_LENGTH = 9;
        final int FIRST_NAME_KEY_LENGTH = 10;

        final int EMAIL_SUBSTRING_STEP = 4;
        final int ID_SUBSTRING_STEP = 8;
        final int LAST_NAME_SUBSTRING_STEP = 5;
        final int FIRST_NAME_SUBSTRING_STEP = 11;

        Boolean isUserWithIDExist = false;
        StringBuilder stringBuilder = new StringBuilder();
        PrintWriter out = response.getWriter();
        List usersList = getUsers();

        response.setContentType("text/html;charset=UTF-8");
        stringBuilder.append("""
            <!DOCTYPE html>
            <html lang=\"ru\">
                <head>
                    <meta charset=\"UTF-8\">
                    <title>Example application | showUsers</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                </head>
                <body>
                    <table>
                        <tr>
            """);

        for (Object user : usersList) {
            int comIndex = user.toString().indexOf(".com");
            int emailIndex = user.toString().indexOf("email=") + EMAIL_KEY_LENGTH;
            int iDIndex = user.toString().indexOf("id=") + ID_KEY_LENGTH;
            int lastNameIndex = user.toString().indexOf("lastName=") + LAST_NAME_KEY_LENGTH;
            int firstNameIndex = user.toString().indexOf("firstName=") + FIRST_NAME_KEY_LENGTH;

            String email = user.toString().substring(emailIndex, comIndex + EMAIL_SUBSTRING_STEP);
            String userID = user.toString().substring(iDIndex, emailIndex - ID_SUBSTRING_STEP);
            String lastName = user.toString().substring(lastNameIndex, iDIndex - LAST_NAME_SUBSTRING_STEP);
            String firstName = user.toString().substring(firstNameIndex, lastNameIndex - FIRST_NAME_SUBSTRING_STEP);

            if (userID.equals(id)) {
                isUserWithIDExist = true;
                stringBuilder.append("              <td>").append("firstName: ")
                        .append(firstName).append("</td>").append("\n");
                stringBuilder.append("              <td>").append("lastName: ")
                        .append(lastName).append("</td>").append("\n");
                stringBuilder.append("              <td>").append("email: ")
                        .append(email).append("</td>").append("\n");
            }
        }
        stringBuilder.append("""
                        </tr>
                    </table>
                </body>
            </html>
            """);

        if (!isUserWithIDExist) {
            response.sendError(404);
        }
        out.println(stringBuilder);
        // END
    }
}
