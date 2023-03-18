/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.AlbumWebb;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDBWebb {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<AlbumWebb> listAlbums() {
      List<AlbumWebb> resultList = new ArrayList<AlbumWebb>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> albums = session.createQuery("FROM AlbumWebb").list();
         for (Iterator<?> iterator = albums.iterator(); iterator.hasNext();) {
            AlbumWebb album = (AlbumWebb) iterator.next();
            resultList.add(album);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<AlbumWebb> listAlbums(String keyword) {
      List<AlbumWebb> resultList = new ArrayList<AlbumWebb>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> albums = session.createQuery("FROM AlbumWebb").list();
         for (Iterator<?> iterator = albums.iterator(); iterator.hasNext();) {
            AlbumWebb album = (AlbumWebb) iterator.next();
            if (album.getTitle().startsWith(keyword)) {
               resultList.add(album);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }
   
   
   public static List<AlbumWebb> sortAlbums() {
	   List<AlbumWebb> resultList = new ArrayList<AlbumWebb>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> albums = session.createQuery("FROM AlbumWebb ORDER BY YEAR ASC").list();
	         for (Iterator<?> iterator = albums.iterator(); iterator.hasNext();) {
	            AlbumWebb album = (AlbumWebb) iterator.next();
	               resultList.add(album);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
   
   public static List<AlbumWebb> sortAlbumsDescend() {
	   List<AlbumWebb> resultList = new ArrayList<AlbumWebb>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> albums = session.createQuery("FROM AlbumWebb ORDER BY YEAR DESC").list();
	         for (Iterator<?> iterator = albums.iterator(); iterator.hasNext();) {
	            AlbumWebb album = (AlbumWebb) iterator.next();
	               resultList.add(album);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
   

   public static void createAlbum(String title, String artist, String genre, String year) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new AlbumWebb(title, artist, genre, year));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
