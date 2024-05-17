

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cloneShape")
public class PrototypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        ShapeCache.loadCache();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shapeId = request.getParameter("shapeId");
        Shape clonedShape = ShapeCache.getShape(shapeId);

        request.setAttribute("clonedShape", clonedShape);
        request.getRequestDispatcher("shape.jsp").forward(request, response);
    }
}
