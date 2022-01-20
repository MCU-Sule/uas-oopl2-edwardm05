package com.example.uas_1872003.DAO;

import com.example.uas_1872003.Model.FeMemberEntity;
import com.example.uas_1872003.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
//1872003 - Edward Michael S
public class MemberDAO implements DAOInterface<FeMemberEntity> {
    @Override
    public int addData(FeMemberEntity data) {
        Session s= HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.save(data);

        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(FeMemberEntity data) {
        Session s= HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.delete(data);

        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int updateData(FeMemberEntity data) {
        Session s= HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.update(data);

        t.commit();
        s.close();
        return 0;
    }
    @Override
    public ObservableList<FeMemberEntity> getAll() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FeMemberEntity.class);
        query.from(FeMemberEntity.class);

        List<FeMemberEntity> mList = s.createQuery(query).getResultList();

        return FXCollections.observableArrayList(mList);
    }
}
