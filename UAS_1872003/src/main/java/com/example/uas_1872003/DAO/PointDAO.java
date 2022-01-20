package com.example.uas_1872003.DAO;

import com.example.uas_1872003.Model.FePointEntity;
import com.example.uas_1872003.Utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
//1872003 - Edward Michael S
public class PointDAO implements DAOInterface<FePointEntity>{
    @Override
    public int addData(FePointEntity data) {
        Session s= HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.save(data);

        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(FePointEntity data) {
        Session s= HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.delete(data);

        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int updateData(FePointEntity data) {
        Session s= HibernateUtil.getSession();

        Transaction t = s.beginTransaction();
        s.update(data);

        t.commit();
        s.close();
        return 0;
    }

    @Override
    public ObservableList<FePointEntity> getAll() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(FePointEntity.class);
        query.from(FePointEntity.class);

        List<FePointEntity> pList = s.createQuery(query).getResultList();
        return FXCollections.observableArrayList(pList);
    }
}
