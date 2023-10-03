

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class converter extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conversionType = request.getParameter("conversionType");

        int baseten = Integer.parseInt(request.getParameter("baseten"));

        if ("binary".equals(conversionType)) {
            String result = convertToBinary(baseten);

            request.setAttribute("baseten", baseten);
            request.setAttribute("result", result);
            request.setAttribute("message", "Decimal number converted to binary");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if ("hexa".equals(conversionType)) {
            String result = convertToHexadecimal(baseten);

            request.setAttribute("baseten", baseten);
            request.setAttribute("result", result);
            request.setAttribute("message", "Decimal number converted to Hexadecimal");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if ("octal".equals(conversionType)) {
            String result = convertToOctal(baseten);

            request.setAttribute("baseten", baseten);
            request.setAttribute("result", result);
            request.setAttribute("message", "Decimal number converted to Octal");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public static String convertToBinary(int decimalNumber) {
        return Integer.toBinaryString(decimalNumber);
    }

    public static String convertToHexadecimal(int decimalNumber) {
        return Integer.toHexString(decimalNumber);
    }

    public static String convertToOctal(int decimalNumber) {
        return Integer.toOctalString(decimalNumber);
    }
}