package com.uts.mobprog210040138.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ModelLoans {
    @SerializedName("loan_id")
    @Expose
    private String loanId;
    @SerializedName("borrowed_at")
    @Expose
    private String borrowedAt;
    @SerializedName("due_date")
    @Expose
    private String dueDate;
    @SerializedName("return_status")
    @Expose
    private String returnStatus;
    @SerializedName("returned_at")
    @Expose
    private String returnedAt;
    @SerializedName("borrower_id")
    @Expose
    private String borrowerId;
    @SerializedName("borrower")
    @Expose
    private ModelMember borrower;
    @SerializedName("borrowed_book_id")
    @Expose
    private String borrowedBookId;
    @SerializedName("book")
    @Expose
    private ModelBook book;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(String borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(String returnedAt) {
        this.returnedAt = returnedAt;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public ModelMember getBorrower() {
        return borrower;
    }

    public void setBorrower(ModelMember borrower) {
        this.borrower = borrower;
    }

    public String getBorrowedBookId() {
        return borrowedBookId;
    }

    public void setBorrowedBookId(String borrowedBookId) {
        this.borrowedBookId = borrowedBookId;
    }

    public ModelBook getBook() {
        return book;
    }

    public void setBook(ModelBook book) {
        this.book = book;
    }

}