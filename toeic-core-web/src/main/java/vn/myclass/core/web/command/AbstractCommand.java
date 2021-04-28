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
    private String urlType;

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

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

    public String getCrudAction() {
        return crudAction;
    }

    public void setCrudAction(String crudAction) {
        this.crudAction = crudAction;
    }

    public List<T> getListResults() {
        return listResults;
    }

    public void setListResults(List<T> listResults) {
        this.listResults = listResults;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(int firstItem) {
        this.firstItem = firstItem;
    }

    public String[] getCheckList() {
        return checkList;
    }

    public void setCheckList(String[] checkList) {
        this.checkList = checkList;
    }

    public String getSortExpression() {
        return sortExpression;
    }

    public void setSortExpression(String sortExpression) {
        this.sortExpression = sortExpression;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
