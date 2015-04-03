package org.nwsoft.xmlobj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

public class XmlvsObject {

	public static void main(String[] args) {
		
		unMarshal(); //xml to obj
		
		
		marshal(); //obj to xml

	}
	private static void marshal() {
		ArrayList<Customer> listCust = new ArrayList<>();
		listCust.add(new Customer(1, "Atom", 10));
		listCust.add(new Customer(2, "Tom", 11));
		listCust.add(new Customer(3, "Minsoo", 22));
		//
		Iterator<Customer> it = listCust.iterator();
		while (it.hasNext()) {
			Customer cu = it.next();
			System.out.println(cu.id + cu.name + cu.age);
		}
		//
//		try {
//			JAXBContext jc = JAXBContext.newInstance("com.nwsoft.xmlobj");
//			Marshaller msr = jc.createMarshaller();
//			msr.setProperty("jaxb.encoding", "MS949");
//			msr.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
//			msr.marshal(listCust, new FileOutputStream("customers.xml"));
//			
//		} catch (JAXBException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	private static void unMarshal() {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new File("customers.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
@XmlRootElement
class Customer {
	public   int id;
	public   String name;
	public   int age;
	
	public Customer() {
		
	}

	public Customer(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}