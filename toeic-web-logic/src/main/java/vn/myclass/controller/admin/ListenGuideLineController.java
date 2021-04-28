package vn.myclass.controller.admin;


import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.service.ListenGuidelineService;
import vn.myclass.core.service.impl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.Utils.FormUtil;
import vn.myclass.core.web.Utils.RequestUtil;
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
import java.util.ResourceBundle;

//@WebServlet("/admin-guideline-listen-list.html")
@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html","/admin-guideline-listen-edit.html"})
public class ListenGuideLineController extends HttpServlet {
    private ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ListenGuidelineCommand command = FormUtil.populate(ListenGuidelineCommand.class, req);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
/*
        command.setMaxPageItems(2);
        RequestUtil.initSearchBean(req, command);
        Object[] objects = guidelineService.findListenGuidelineByProperties(null,null, command.getSortExpression(), command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResults((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems((Integer.parseInt(objects[0].toString())));
*/
//        req.setAttribute(WebConstant.ALERT,WebConstant.TYPE_SUCCESS);
//        req.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.success"));
        req.setAttribute(WebConstant.LIST_ITEMS, command); // truyền ra view
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(req,resp);
        } else if(command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
