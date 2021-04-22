package vn.myclass.core.web.command;

import java.util.List;

public class AbstractCommand<T> {
    protected T pojo;
    private String crudAction; // Create, read, update, delete
    private List<T> listResults;
    private String tableId = "tableList";
    private int page = 1;
    private int maxPageItems = 20;
    private int totalItems = 0;
    private int firstItem = 0;
    private String[] checkList;
    private String sortExpression;
    private String sortDirection;
    private String messageResponse; // trả về thông báo

    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }

    public String getCrudaction() {
        return crudAction;
    }

    public void setCrudaction(String crudaction) {
        this.crudAction = crudaction;
    }
}
