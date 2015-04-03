package com.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

@WebServlet(urlPatterns = "/xml")
public class XMLServlet extends HttpServlet {

	// http://blog.bdoughan.com/2012/11/creating-generic-list-wrapper-in-jaxb.html
	
	
	// 웹컨테이너는 웹클라이언트의 요청이 있는 경우

	// GET 방식 요청이면 doGet() 메소드를 호출한다.

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml;charset=UTF-8");
		OutputStream out = resp.getOutputStream();
		// TODO output your page here
		// String name = request.getParameter("name");

		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Wrapper.class, Employee.class);
		
			/*
			// Unmarshal
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			List<Employee> addresses = unmarshal(unmarshaller, Employee.class, "addresses.xml");
			*/
			// Marshal
			Marshaller marshaller;
			
			marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshal(marshaller, getEmpDatas(), "emps", out);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.close();
	}

	/** * Unmarshal XML to Wrapper and return List value. */
	private static <T> List<T> unmarshal(Unmarshaller unmarshaller, Class<T> clazz, String xmlLocation) throws JAXBException {
		StreamSource xml = new StreamSource(xmlLocation);
		Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml, Wrapper.class).getValue();
		return wrapper.getItems();
	}

	/**
	 * * Wrap List in Wrapper, then leverage JAXBElement to supply root element *
	 * information.
	 */
	private static void marshal(Marshaller marshaller, List<?> list, String name, OutputStream os) throws JAXBException {
		QName qName = new QName(name);
		Wrapper wrapper = new Wrapper(list);
		JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName, Wrapper.class, wrapper);
		marshaller.marshal(jaxbElement, os);
	}

	private List<Employee> getEmpDatas() {

		List<Employee> datas = new ArrayList<Employee>();

		Employee emp = new Employee();
		emp.setId(1);
		emp.setAge(25);
		emp.setName("Pankaj");
		emp.setGender("Male");
		emp.setRole("Developer");
		emp.setPassword("sensitive");

		datas.add(emp);

		emp = new Employee();
		emp.setId(11);
		emp.setAge(125);
		emp.setName("1Pankaj");
		emp.setGender("1Male");
		emp.setRole("1Developer");
		emp.setPassword("1sensitive");

		datas.add(emp);

		return datas;
	}
}