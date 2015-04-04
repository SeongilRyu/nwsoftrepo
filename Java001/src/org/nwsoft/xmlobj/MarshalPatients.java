package org.nwsoft.xmlobj;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author John O'Conner (john@joconner.com)
 */
public class MarshalPatients {

    
    public static void main(String[] args) {
    	args = new String[2];
    	args[0]="patients.xml";
    	args[1]= "Patients.class";
        if (args.length != 2) {
            System.out.println("Usage: java org.java7recipes.chapter22.MarshalPatients <xmlfile> <context>");
            System.exit(1);
        }
        MarshalPatients app = new MarshalPatients();
        try {
            app.run(args[0], args[1]);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public void run(String xmlFile, String context) throws JAXBException, FileNotFoundException {
        Patients patients = new Patients();
        List<Patient> patientList = patients.getPatient();
        
        Patient p = new Patient();
        p.setId(BigInteger.valueOf(1));
        p.setName("John Doe");
        p.setDiagnosis("Schizophrenia");
        
        patientList.add(p);
        
        JAXBContext jc = JAXBContext.newInstance(Patients.class);
        Marshaller m = jc.createMarshaller();
        m.marshal(patients, new FileOutputStream(xmlFile));
    }
    
}
