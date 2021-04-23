package vn.myclass.controller.admin;


import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.web.common.WebConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuideLineController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ListenGuidelineCommand command = new ListenGuidelineCommand();

        List<ListenGuidelineDTO> listenGuidelineDTOS = new ArrayList<ListenGuidelineDTO>();
        ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setTitle("Bài HD nghe 1");
        dto.setContent("Noi dung bai huong dan nghe 1");

        ListenGuidelineDTO dto2 = new ListenGuidelineDTO();
        dto.setTitle("Bài HD nghe 2");
        dto.setContent("Noi dung bai huong dan nghe 2");
        listenGuidelineDTOS.add(dto);
        listenGuidelineDTOS.add(dto2);

        command.setListResults(listenGuidelineDTOS);
        command.setMaxPageItems(1);
        command.setTotalItems(listenGuidelineDTOS.size());

        req.setAttribute(WebConstant.LIST_ITEMS, command); // Đổ dữ liệu từ controller ra ngoài JSP

        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
