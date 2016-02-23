package gdau.funcionais;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import gdau.funcionais.ListaTurmas;
import gdau.funcionais.ListaProfessores;
import gdau.modelos.Turma;
import gdau.modelos.Professor;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Serializador {
    
    private ArrayList<Turma> listT = new ArrayList();
    private ArrayList<Professor> listP = new ArrayList();
    
    public void serializaT() throws Exception{
        FileOutputStream fos = new FileOutputStream("Turmas");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listT);
        oos.close();
        fos.close();
    }
    
    public void SerializaP() throws Exception{
        FileOutputStream fos = new FileOutputStream("Professores");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(listP);
        oos.close();
        fos.close();
    }
    
    public void deserializaT(ArrayList<Turma> listT) throws Exception{
        FileInputStream fis = new FileInputStream("Turmas");
        ObjectInputStream ois = new ObjectInputStream(fis);
        listT = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
    }
    
    public void deserializaP(ArrayList<Professor> listP) throws Exception{
        FileInputStream fis = new FileInputStream("Professores");
        ObjectInputStream ois = new ObjectInputStream(fis);
        listT = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
    }
} 

