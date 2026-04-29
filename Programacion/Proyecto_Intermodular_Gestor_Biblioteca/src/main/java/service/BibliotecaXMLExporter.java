package service;

import DAO.LibrosDAO;
import DAO.SociosDAO;
import DAO.PrestamoDAO;
import DAO.ReservaDAO;

import model.Libros;
import model.Socios;
import model.Prestamo;
import model.Reserva;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.List;

public class BibliotecaXMLExporter {

    private final LibrosDAO librosDAO = new LibrosDAO();
    private final SociosDAO sociosDAO = new SociosDAO();
    private final PrestamoDAO prestamoDAO = new PrestamoDAO();
    private final ReservaDAO reservaDAO = new ReservaDAO();

    public void exportar(String rutaArchivo) {

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // ROOT
            Element root = doc.createElement("Gestor_biblioteca");
            doc.appendChild(root);


            Element librosNode = doc.createElement("libros");
            root.appendChild(librosNode);

            List<Libros> libros = librosDAO.listar();

            for (Libros l : libros) {

                Element libro = doc.createElement("libro");
                libro.setAttribute("id", String.valueOf(l.getId()));

                add(doc, libro, "titulo", l.getTitulo());
                add(doc, libro, "anioPublicacion", l.getAnio_publicacion());
                add(doc, libro, "editorial", l.getEditorial());
                add(doc, libro, "autor", l.getAutor());
                add(doc, libro, "estado", l.getEstado());

                librosNode.appendChild(libro);
            }


            Element sociosNode = doc.createElement("socios");
            root.appendChild(sociosNode);

            List<Socios> socios = sociosDAO.listar();

            for (Socios s : socios) {

                Element socio = doc.createElement("socio");
                socio.setAttribute("id", String.valueOf(s.getId()));

                add(doc, socio, "nombre", s.getNombre());
                add(doc, socio, "apellido", s.getApellido());
                add(doc, socio, "email", s.getEmail());

                sociosNode.appendChild(socio);
            }


            Element prestamosNode = doc.createElement("prestamos");
            root.appendChild(prestamosNode);

            List<Prestamo> prestamos = prestamoDAO.listar();

            for (Prestamo p : prestamos) {

                Element prestamo = doc.createElement("prestamo");

                add(doc, prestamo, "libro", p.getLibro());
                add(doc, prestamo, "socio", p.getSocio());
                add(doc, prestamo, "fechaInicio", p.getFechaInicio());

                prestamosNode.appendChild(prestamo);
            }


            Element reservasNode = doc.createElement("reservas");
            root.appendChild(reservasNode);

            List<Reserva> reservas = reservaDAO.listar();

            for (Reserva r : reservas) {

                Element reserva = doc.createElement("reserva");

                add(doc, reserva, "libro", r.getLibro());
                add(doc, reserva, "socio", r.getSocio());
                add(doc, reserva, "estado", r.getEstado());

                reservasNode.appendChild(reserva);
            }

            // SAVE XML
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));

            transformer.transform(source, result);

            System.out.println("XML exportado correctamente en: " + rutaArchivo);

        } catch (Exception e) {
            System.out.println("Error exportando XML: " + e.getMessage());
        }
    }

    private void add(Document doc, Element parent, String tag, String value) {

        Element node = doc.createElement(tag);
        node.appendChild(doc.createTextNode(value != null ? value : ""));
        parent.appendChild(node);
    }
}