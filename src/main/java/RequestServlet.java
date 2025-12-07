import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/save-request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Валидируем данные
        if(fullName.trim().isEmpty() || email.trim().isEmpty() || phone.trim().isEmpty()){
            // Одно из полей пустое
            request.setAttribute("message", "Все поля обязательны для заполнения!");
            request.getRequestDispatcher("save-request.jsp").forward(request, response);
            return;
        }

        // Формируем успешное сообщение и добавляем в request scope
        request.setAttribute("fullName", fullName);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("message", "Заявка успешно сохранена!");

        // Перенаправляем на страницу успешного подтверждения
        request.getRequestDispatcher("success.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("save-request.jsp").forward(req,resp);
    }
}

