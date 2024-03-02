package org.example;


import clase.Alumno;
import dao.AlumnoDAO;

public class Main {
    public static void main(String[] args) {

            Alumno alumno1 = new Alumno("Victor", "123456789", "victor123@cesur.com", 4.5, 7.5);
            //AlumnoDAO.insertarAlumno(alumno1);

        try {
            AlumnoDAO.listarTodo();
            AlumnoDAO.estadistica();
            alumno1.setNombre("DANI");
            AlumnoDAO.AlumnoMod(alumno1);
            AlumnoDAO.listarTodo();
        }catch (Exception e){

        }

    }
}