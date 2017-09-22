package com.chy.test;

import com.chy.po.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        //获取到配置信息
        Configuration conf=new Configuration().configure();
        //创建一个标准的建造器
        StandardServiceRegistryBuilder ssb = new StandardServiceRegistryBuilder();
        //得到ServiceRegistry的实例（一定需要传入configuration.getProperties()）
        StandardServiceRegistry ssr = ssb.applySettings(conf.getProperties()).build();
        //得到SessionFactory工厂
        SessionFactory sessionFactory = conf.buildSessionFactory(ssr);
        //得到Session对象
        Session session = sessionFactory.openSession();
        //获取事物管理
        Transaction tr = session.beginTransaction();
        //创建数据库对象
        Student student=new Student();
        student.setId(1);
        student.setName("张三");
        student.setSex("男");
        student.setAge(20);
        //保持
        session.save(student);
        //事务提交
        tr.commit();
    }
}
