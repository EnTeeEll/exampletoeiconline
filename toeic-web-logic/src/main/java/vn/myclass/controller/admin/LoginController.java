package vn.myclass.controller.admin;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.impl.UserServiceImpl;
import vn.myclass.core.web.Utils.FormUtil;
import vn.myclass.core.web.common.WebConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {

    private transient final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserCommand userCommand = FormUtil.populate(UserCommand.class,req);
        UserDTO pojo = userCommand.getPojo();
        UserService userService = new UserServiceImpl();
            try {
                if(userService.isUserExist(pojo) != null) {
                    if (userService.findRoleByUser(pojo) != null && userService.findRoleByUser(pojo).getRoleDTO() != null) {
                        if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)) {
                            resp.sendRedirect("/admin-home.html");
                        } else if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)) {
                            resp.sendRedirect("/web-home.html");
                        }
                    }
                }
            } catch (NullPointerException e) {
                log.error(e.getMessage(), e);
                req.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                req.setAttribute(WebConstant.MESSAGE_RESPONSE, "Fail!");
                RequestDispatcher rd = req.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(req,resp);
            }
    }
}
