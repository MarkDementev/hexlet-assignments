package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        final String REQUEST_PARAMETER = "search";
        final String NOT_FOUND_REQUEST_PARAMETER = "Companies not found";

        String queryString = request.getQueryString();
        String parameterValue = request.getParameter(REQUEST_PARAMETER);
        List<String> accessibleCompanies = getCompanies();
        StringBuilder neededCompaniesBuilder = new StringBuilder();

        if (queryString == null) {
            for (String company : accessibleCompanies) {
                neededCompaniesBuilder.append(company).append("\n");
            }
        } else if (!queryString.contains(REQUEST_PARAMETER) | parameterValue.equals("")) {
            for (String company : accessibleCompanies) {
                neededCompaniesBuilder.append(company).append("\n");
            }
        } else {
            for (String company : accessibleCompanies) {
                if (company.contains(parameterValue)) {
                    neededCompaniesBuilder.append(company).append("\n");
                }
            }

            if (neededCompaniesBuilder.length() == 0) {
                neededCompaniesBuilder.append(NOT_FOUND_REQUEST_PARAMETER);
            }
        }
        String result = neededCompaniesBuilder.toString();
        PrintWriter out = response.getWriter();
        out.println(result);
        // END
    }
}
