package com.example.uas_1872003.Controller;

import com.example.uas_1872003.DAO.MemberDAO;
import com.example.uas_1872003.DAO.PointDAO;
import com.example.uas_1872003.DAO.TransactionDAO;
import com.example.uas_1872003.Model.FeMemberEntity;
import com.example.uas_1872003.Model.FePointEntity;
import com.example.uas_1872003.Model.FeTransactionEntity;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public Label labelTotalMember;
    public Label tfTotalMember;
    public Label labelTransaction;
    public Label tfTransaction;
    public Label labelTotalPoint;
    public Label tfTotalPoint;
    public Label labelID;
    public Label labelNama;
    public Label labelAlamat;
    public Label labelPhone;
    public Label labelEmail;
    public Label labelUsername;
    public Label labelTLahir;
    public TextField tfID;
    public TextField tfNama;
    public TextArea tfAlamat;
    public TextField tfPhone;
    public TextField tfEmail;
    public TextField tfUsername;
    public DatePicker dpTLahir;
    public Button btnSave;
    public Button btnReset;
    public Button btnUpdate;
    public TableView<FeMemberEntity> tvMember;
    public TableColumn<FeMemberEntity, String> colID;
    public TableColumn<FeMemberEntity, String> colNama;
    public TableColumn<FeMemberEntity, String> colPhone;
    public TableColumn<FeMemberEntity, Date> colTLahir;
    public Label labelNominal;
    public Label labelDate;
    public TextField tfNominal;
    public DatePicker dpDate;
    public Button btnSaveS;
    public TableView<FeTransactionEntity> tvTransaction;
    public TableColumn<FeTransactionEntity, Date> colDate;
    public TableColumn<FeTransactionEntity, Integer> colNominal;
    public TableView<FePointEntity> tvPoint;
    public TableColumn<FePointEntity, Integer> colIDPoint;
    public TableColumn<FePointEntity, Integer> colPoint;

    ObservableList<FeMemberEntity> mList;
    ObservableList<FePointEntity> pList;
    ObservableList<FeTransactionEntity> tList;
    //1872003 - Edward Michael S
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ResourceBundle bundle = ResourceBundle.getBundle("bundle_EN");
        labelTotalMember.setText("totalmember.text");
        labelTransaction.setText("transaction.text");
        labelTotalPoint.setText("totalpoint.text");
        labelID.setText("citizen.text");
        labelNama.setText("nama.text");
        labelAlamat.setText("alamat.text");
        labelPhone.setText("phone.text");
        labelEmail.setText("email.text");
        labelUsername.setText("username.text");
        labelTLahir.setText("tlahir.text");
        btnSave.setText("save.text");
        btnReset.setText("reset.text");
        btnUpdate.setText("update.text");
        colID.setText("citizen.text");
        colNama.setText("nama.text");
        colPhone.setText("phone.text");
        colTLahir.setText("tlahir.text");
        labelNominal.setText("nominal.text");
        labelDate.setText("transactiondate.text");
        btnSaveS.setText("tsave.text");
        colDate.setText("transaction.text");
        colNominal.setText("nominal.text");
        colID.setText("id.text");
        colPoint.setText("point.text");

        MemberDAO mDAO = new MemberDAO();
        mList = mDAO.getAll();
        tvMember.setItems(mList);

        colID.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCitizenId()));
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        colPhone.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPhone()));
        colTLahir.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getBirthdate()));

        PointDAO pDAO = new PointDAO();
        pList = pDAO.getAll();
        tvPoint.setItems(pList);

        colDate.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getTransDate()));
        colNominal.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getNominal()).asObject());

        TransactionDAO tDAO = new TransactionDAO();
        tList = tDAO.getAll();
        tvTransaction.setItems(tList);

        colIDPoint.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        colPoint.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getValue()).asObject());

    }

    public void saveMemberAction(ActionEvent actionEvent) {
        MemberDAO mDAO = new MemberDAO();
        FeMemberEntity data = new FeMemberEntity();
        data.setCitizenId(tfID);
        data.setName(tfNama.getText());
        data.setAddress(tfAlamat.getText());
        data.setPhone(tfPhone.getText());
        data.setEmail(tfEmail.getText());
    }

    public void resetAction(ActionEvent actionEvent) {
    }

    public void updateAction(ActionEvent actionEvent) {
    }

    public void saveTransAction(ActionEvent actionEvent) {
    }
}
