package dao;

import clase.Alumno;
import utils.ObjectDBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class AlumnoDAO {

    public static void insertarAlumno(Alumno alumno){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try{
            //Inicializamos transaccion
            em.getTransaction().begin();
            //Subir alumno a la base de datos
            em.persist(alumno);
            //Ejecutamos transaccion
            em.getTransaction().commit();

        }finally {
            //Cerrar entity manager(en tod.o menos read)
            em.close();
        }
    }

    public static void listarTodo(){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        TypedQuery<Alumno>q=em.createQuery("select a from Alumno a", Alumno.class);
        ArrayList<Alumno>alumnos= (ArrayList<Alumno>) q.getResultList();

        System.out.println(alumnos.toString());


        for(Alumno alumnito:alumnos){
            System.out.println(alumnito);

        }





    }

    public static void estadistica(){
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        TypedQuery<Alumno>q=em.createQuery("select a from Alumno a", Alumno.class);

        ArrayList<Alumno>alumnos= (ArrayList<Alumno>) q.getResultList();

        for(Alumno alumnito:alumnos){
           Double notamedia= ((alumnito.getAd()+alumnito.getDi())/2);
            System.out.println("La nota media de"+alumnito.getNombre()+"es: "+notamedia);

        }

        q=em.createQuery("select a from Alumno a where a.ad>4.9 and a.di>4.9", Alumno.class);
        ArrayList<Alumno>alumnosAprobados = (ArrayList<Alumno>) q.getResultList();
        Double ratioAprobados= (double) (alumnosAprobados.size()/ alumnos.size());

        System.out.println("Ratio aprob"+ratioAprobados);
    }

    public static void AlumnoMod(Alumno alumno){
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        Alumno alumnoBDD=em.find(Alumno.class,alumno.getEmail());
        em.getTransaction().begin();
        alumnoBDD.setNombre(alumno.getNombre());
        em.merge(alumnoBDD);
        em.getTransaction().commit();
        em.close();
    }

    public static void AlumnoDelete(Alumno alumno){
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        Alumno alumnoBDD = em.find(Alumno.class,alumno.getEmail()); //getid
        em.getTransaction().begin();
        em.remove(alumnoBDD);
        em.getTransaction().commit();
        em.close();

    }


}
